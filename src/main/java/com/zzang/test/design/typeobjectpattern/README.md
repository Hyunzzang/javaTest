# Type Object Pattern

> Type Object 디자인 패턴은 하나의 클래스가 수많은 하위 클래스를 갖거나, 그 하위 클래스의 개수를 소프트웨어 개발시에 예측할 수 없는 상황을 해결하고자 제시된 패턴

> 타입을 상속으로 표현하는 대신 참조 관계로 만들어서 유연하게 타입을 표현하는 패턴

> 객체의 타입에 따라 다른 처리를 해야 할 경우 Type Object Pattern을 사용할 수 있다. 각 타입에 대한 정보를 객체로 구현하여, 객체를 생성할 때 각 타입에 맞는 정보를 갖는 객체를 생성할 수 있다. 이를 통해 객체의 타입에 따른 분기 처리를 피할 수 있어, 코드의 가독성이 높아지고 관리가 쉬워진다.

### 참조
- https://gameprogrammingpatterns.com/type-object.html

<img src="https://gameprogrammingpatterns.com/images/type-object-subclasses.png">

<img src="https://gameprogrammingpatterns.com/images/type-object-breed.png">


### 장점:
동적인 구성에 유리
(게임에서는 캐릭터의 규형을 위하여 보정이 자주 일어)

1. 코드 간소화: Type Object를 사용하면, 각 타입에 대한 정보를 따로 관리할 필요가 없어져 코드 간소화가 이루어집니다.
2. 가독성 향상: Type Object를 사용하면, 각 타입에 대한 정보를 한 곳에 모아 가독성이 향상됩니다.
3. 유지보수 용이: Type Object를 사용하면, 각 타입에 대한 정보를 한 곳에 모아 관리하기 쉽습니다. 이로 인해, 유지보수가 용이해집니다.

### 단점:
1. 구조 복잡: Type Object의 구조가 복잡할 수 있어서, 적절한 구조를 고민하는 시간이 소요됩니다.
2. 메모리 사용: Type Object를 사용하면, 각 타입에 대한 정보를 메모리에 저장해야 하므로, 메모리 사용량이 증가할 수 있습니다.
3. 적은 재사용성: Type Object를 사용하면, 특정 타입에 국한된 정보만 사용할 수 있어서, 적


## 유사한 패턴
1. Factory Method 패턴: Type Object 패턴과 마찬가지로, 객체의 생성을 캡슐화하여 유연성을 높여줍니다.
2. Strategy 패턴: Type Object 패턴과 마찬가지로, 알고리즘을 캡슐화하여 동적으로 변경할 수 있도록 합니다.
3. State 패턴: Type Object 패턴과 마찬가지로, 상태에 따른 행동을 캡슐화하여 객체의 동작을 변경할 수 있도록 합니다.




Strategy Pattern과 Type Object Pattern은 둘 다 구현 방법이 다른 여러 객체를 생성하고 관리하는 디자인 패턴이다. 하지만 그 차이점은 다음과 같다:

1. 대상 객체: Strategy Pattern에서는 전략을 적용할 대상 객체와 관련된 객체를 생성하지만, Type Object Pattern에서는 타입 객체를 생성한다.

2. 적용 범위: Strategy Pattern에서는 전략을 객체 단위로 적용할 수 있지만, Type Object Pattern에서는 객체의 타입만으로 구분할 수 있다.

3. 구현 방법: Strategy Pattern에서는 전략 인터페이스를 구현한 여러 개의 클래스를 정의하여 구현하는 반면, Type Object Pattern에서는 객체의 타입 값을 기준으로 구현한다.

어떤 패턴을 사용할지는 주어진 문제의 조건과 필요성에 따라 결정할 수 있다. 각 패턴의 강점을 파악하여 개발할 수 있는 최적의 패턴을 선택하는 것이 좋다.



State Pattern과 Type-Object Pattern은 개념적으로 비슷하지만, 주요 차이점은 다음과 같습니다.

적용 대상: State Pattern은 어떤 객체의 상태에 따라서 그 객체의 행위가 달라지는 경우에 적용하는 패턴입니다. Type-Object Pattern은 객체의 상태와 무관하게 그 객체의 행위를 분리하여 관리하는 경우에 적용하는 패턴입니다.

구현 방식: State Pattern에서는 객체 상태를 나타내는 객체와 객체의 행위를 나타내는 객체를 분리하여, 객체 상태에 따라 객체의 행위를 변경합니다. Type-Object Pattern에서는 각 행위를 나타내는 객체를 생성하여 관리하고, 객체가 수행할 행위를 위임하여 구현합니다.

즉, State Pattern은 객체의 상태에 따라 객체의 행위를 변경하는 것이 목적이고, Type-Object Pattern은 객체의 행위와 객체의 상태를 분리하여 관리하
