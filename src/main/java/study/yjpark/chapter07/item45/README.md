# 아이템 45. 스트림은 주의해서 사용하라

1. Stream vs. loop 각각 맞는 상황이 있음
2. Stream + loop 를 적절히 사용하면 가장 좋음

> Stream vs. loop 중 어느 쪽이 더 나은지 확신하기 어렵다면 둘 다 해보고 더 나은 쪽을 택하라

### 코드 블록과 스트림에 맞는 연산

**코드 블록**

- 범위 안의 지역변수 수정 가능
  - Stream 람다는 final인 값만 읽을 수 있음
- return, continue, break 사용 가능

**Stream**

- 원소의 시퀀스를 일관되게 변환
- 원소들의 시퀀스를 필터링
- 원소들의 시퀀스를 하나의 연산을 사용해 결합
- 원소들의 시퀀스를 컬렉션에 모을 때
- 원소들의 시퀀스에서 특정 조건을 만족하는 원소를 찾을 때
