# 아이템 39. 명명 패턴보다 애너테이션을 사용하라

1. 애너테이션으로 할 수 있는 일을 명명 패턴으로 처리할 이유는 없다.
2. public void testSomeApi() -> @Test public void someApi()
3. 자바 프로그래머라면 예외 없이 자바가 제공하는 애너테이션 타입들은 사용해야 한다. (Item27, 40)
4. ex: @SuppressWarning...