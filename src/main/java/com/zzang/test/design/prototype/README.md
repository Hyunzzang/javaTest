# Prototype

> 객체의 복사를 통해서 새로운 객체를 생성하는 패턴입니다. 기존의 객체를 복사하여 새로운 객체를 생성하면, 새로운 객체를 수정하여도 기존 객체에 영향을 주지 않기 때문에 유연한 개발이 가능합니다.
> Prototype 패턴에서는 객체의 복사를 위한 클래스를 정의하고, 객체를 복사할 때 clone() 메소드를 호출합니다. 객체를 복사할 때는 얕은 복사와 깊은 복사를 구분할 수 있으며, 깊은 복사는 객체의 내부 객체까지 복사하는 것을 의미합니다.
> Prototype 패턴은 복잡한 객체를 생성하는 경우, 기존의 객체를 기반으로 새로운 객체를 생성할 때 유용하게 사용할 수 있습니다. 또한, 객체의 생성 시간이 많이 걸리는 경우에도 효율적으로 사용할 수 있습니다.


### 참조
- https://gameprogrammingpatterns.com/prototype.html
- https://ko.wikipedia.org/wiki/%ED%94%84%EB%A1%9C%ED%86%A0%ED%83%80%EC%9E%85_%ED%8C%A8%ED%84%B4

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Prototype_Pattern_ZP.svg/2880px-Prototype_Pattern_ZP.svg.png">


### 장점
1. 향상된 성능: 프로토타입 패턴을 사용하면 처음부터 새 개체를 만드는 대신 기존 개체를 복제하여 새 개체를 만들 수 있습니다. 이렇게 하면 많은 수의 개체를 만들 때 성능이 향상될 수 있습니다.
2. 단순화된 개체 생성: 프로토타입 패턴은 새 개체를 만드는 프로세스를 추상화하여 기존 개체를 복제하여 새 개체를 만들 수 있도록 합니다.
3. 향상된 유연성: 프로토타입 패턴을 사용하면 런타임에 개체의 속성을 변경할 수 있으므로 런타임에 개체의 동작을 쉽게 변경할 수 있습니다.
4. 결합 감소: 프로토타입 패턴은 생성자를 호출하지 않고 새 객체를 생성할 수 있게 하여 객체 간의 결합을 줄입니다. 이로 인해 보다 유연하고 유지 관리 가능한 코드베이스가 생성될 수 있습니다.

### 단점
1. 복잡성 증가: 프로토타입 패턴은 특히 여러 속성 및 종속성이 있는 복잡한 개체를 복제해야 하는 경우 코드의 복잡성을 증가시킬 수 있습니다.
2. 구현하기 어려움: 프로토타입 패턴을 구현하는 것은 어려울 수 있습니다. 특히 개체의 깊은 복사본을 만들어야 하는 경우에는 더욱 그렇습니다.
3. 유지 관리 문제: 개체의 속성을 변경해야 하는 경우 프로토타입 패턴은 유지 관리 문제를 초래할 수 있습니다. 이러한 변경 사항은 원래 개체에서 복제된 모든 개체에 반영되어야 하기 때문입니다.


개인적인 의문
javascript의 prototype 과는 다른 것인가?
> JavaScript의 Prototype 패턴과 다른 Prototype 패턴은 주로 구현 방식의 차이입니다. JavaScript의 Prototype 패턴은 JavaScript의 특징인 Prototype-based OOP(객체 지향 프로그래밍)에 기반하여 구현됩니다. 반면에, 다른 언어에서의 Prototype 패턴은 Class-based OOP에 기반하여 구현될 수 있습니다.

확장 메서드(Extension Method) 인가? 


https://www.digitalocean.com/community/conceptual-articles/prototype-design-pattern-in-javascript
