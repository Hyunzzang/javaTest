select t.team_id, t.team_name, coalesce(sum(points),0) as num_points from
(
    select host_team as team_id,
        case
            when host_goals > guest_goals then 3
            when host_goals = guest_goals then 1
            else 0
        end as points
    from matches
    union all
    select guest_team as team_id,
        case
            when host_goals < guest_goals then 3
            when host_goals = guest_goals then 1
            else 0
        end as points
    from matches
) as m
right join teams t on t.team_id = m.team_id
group by t.team_id, t.team_name
order by num_points desc, t.team_id