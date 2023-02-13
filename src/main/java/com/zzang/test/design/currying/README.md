# Currying 

> 여러 인수를 받는 함수를 각각 단일 인수를 받는 일련의 함수로 변환하는 함수형 프로그래밍 기술
> 다른 기능과 함께 재사용 및 구성될 수 있는 부분적으로 적용된 기능을 만드는 데 유용할 수 있습니다.


### javascript 예
```
function curry(fn) {
  return function curried(...args) {
    if (args.length >= fn.length) {
      return fn.apply(this, args);
    } else {
      return function(...args2) {
        return curried.apply(this, args.concat(args2));
      }
    }
  };
}

// example usage
let add = (a, b, c) => a + b + c;
let curriedAdd = curry(add);
let add5 = curriedAdd(5);
console.log(add5(10)(15)); // 30
```

### java 예
```
import java.util.function.Function;

public class Currying {
  public static <T, R> Function<T, Function<T, R>> curry(
      final BiFunction<T, T, R> biFunction) {
    return t1 -> t2 -> biFunction.apply(t1, t2);
  }

  public static void main(String[] args) {
    final BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
    final Function<Integer, Function<Integer, Integer>> curriedAdd = curry(add);
    final Function<Integer, Integer> add5 = curriedAdd.apply(5);
    System.out.println(add5.apply(10)); // 15
  }
}
```

### 참조
- https://www.baeldung.com/java-currying
- https://towardsdatascience.com/what-is-currying-in-programming-56fd57103431#:~:text=Currying%20is%20helpful%20when%20you,concise%2C%20and%20more%20readable%20solution.
