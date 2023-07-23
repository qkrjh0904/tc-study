# Test Code Study

### 요구사항
```text
1. 커머스 프로젝트를 생성한다.
2. 커머스에서 상품을 등록할 수 있다.
3. 커머스에서 주문을 할 수 있다.
4. 주문 목록을 계산할 수 있다.
```

#### Layered Architecture
```text
Layered Architecture 는 보통 Presentation Layer, Business Layer, Persistence Layer 로 구성된다.
```

#### Persistence Layer
```text
- Data Access 의 역할
- 비즈니스 가공 로직이 포함되어서는 안된다. 
- Data 에 대한 CRUD 에만 집중한 레이어.
```

#### Business Layer
```text
- 비즈니스 로직을 구현하는 역할
- Persistence Layer 와의 상호작용을 통해 비즈니스 로직을 전개시킨다.
- 트랜잭션을 보장해야한다.
- business layer 와 persistence layer 를 정상작동한다는 가정 하에 Mocking 하여 테스트 작성한다.
```

### Presentation Layer
```text
- 외부 세계의 요청을 가장 먼저 받는 계층.
- 파라미터에 대한 최소한의 검증을 수행한다.
- 비즈니스 로직을 전개시키기 전에 유효한가에 대한 검증을 한다.
```