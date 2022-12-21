package study.yjpark.chapter04.item18;

import java.util.*;

/**
 * <h3>[Item18] 상속보다는 컴포지션을 사용하라</h3>
 * 상속은 강력하지만 캡슐화를 해친다는 문제가 있다.
 * 상속은 상위 클래스와 하위 클래스가 순수한 is-a 관계일 때만 써야 한다.
 * is-a 관계일 때도 안심할 수만은 없는 게, 하위 클래스의 패키지가 상위 클래스와 다르고,
 * 상위 클래스가 확장을 고려해 설계되지 않았다면 여전히 문제가 될 수 있다.
 * 상속의 취약점을 피하려면 상속 대신 컴포지션과 전달을 사용하자.
 * 특히 래퍼 클래스로 구현할 적당한 인터페이스가 있다면 더욱 그렇다.
 * 래퍼 클래스는 하위 클래스보다 견고하고 강력하다.
 * <p></p>
 * <h3>[상속의 단점]</h3>
 * 1. 캡슐화를 깨트린다.<br>
 * 2. 내부 구현을 불필요하게 노출한다.<br>
 * 3. 상위 클래스 API의 결함까지도 승계한다.<br>
 * <p></p>
 * <h3>[래퍼 클래스의 단점]</h3>
 * 래퍼 클래스는 콜백 프레임워크와는 어울리지 않는다.(SELF 문제)<br>
 * 1. 콜백 프레임워크에서는 자기 자신의 참조를 다른 객체에 넘겨서 다음 호출(콜백) 때 사용하도록 함<br>
 * 2. 내부 객체는 자신을 감싸고 있는 래퍼의 존재를 모르니 대신 자신(this)의 참조를 넘김<br>
 * 3. 콜백 때는 래퍼가 아닌 내부 객체를 호출하게 됨
 */
public class Item18 {

    // [1] HashSet - 상속을 잘못 사용한 예
    public static class InstrumentedHashSet<E> extends HashSet<E> {
        // 추가된 원소의 수
        private int addCount = 0;

        public InstrumentedHashSet() {
        }

        public InstrumentedHashSet(int initCap, float loadFactor) {
            super(initCap, loadFactor);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
        set.addAll(List.of("틱", "탁탁", "펑"));
        System.out.println("[1] : " + set.getAddCount());
        // 3을 기대하지만, 6이 반환 됨
        // HashSet.addAll() 메서드가 add() 메서드를 사용해 구현되기 때문
        // 1. InstrumentedHashSet.addAll()에서 addCount + 3
        // 2. HashSet.addAll()이 호출되고 내부에서 add() 메서드 호출
        // 3. 이 때 add() 메서드는 InstrumentedHashSet 에서 재정의한 메서드이다.
        // 4. 따라서, InstrumentedHashSet.add()에서 addCount + 3


        // [2] ForwardingSet<E> 클래스를 통해 훨씬 유연해지고 문제점이 해결되었다.
        InstrumentedSetVer2<String> setVer2 = new InstrumentedSetVer2<>(new HashSet<>());
        setVer2.addAll(List.of("틱", "탁탁", "펑"));

        System.out.println("[2] : " + setVer2.getAddCount());
    }


    // [2] 래퍼 클래스 - 상속 대신 컴포지션을 사용
    public static class InstrumentedSetVer2<E> extends ForwardingSet<E> {
        private int addCount = 0;

        public InstrumentedSetVer2(Set<E> s) {
            super(s);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    // [2] 재사용할 수 있는 전달 클래스(ForwardingClass)
    public static class ForwardingSet<E> implements Set<E> {
        private final Set<E> s;
        public ForwardingSet(Set<E> s) { this.s = s; }

        public void clear() { s.clear(); }
        public boolean contains(Object o) { return s.contains(o); }
        public boolean isEmpty() { return s.isEmpty(); }
        public int size() { return s.size(); }
        public Iterator<E> iterator() { return s.iterator(); }
        public boolean add(E e) { return s.add(e); }
        public boolean remove(Object o) { return s.remove(o); }
        public boolean containsAll(Collection<?> c) { return s.containsAll(c); }
        public boolean addAll(Collection<? extends E> c) { return s.addAll(c); }
        public boolean removeAll(Collection<?> c) { return s.removeAll(c); }
        public boolean retainAll(Collection<?> c) { return s.retainAll(c); }
        public Object[] toArray() { return s.toArray(); }
        public <T> T[] toArray(T[] a) { return s.toArray(a); }

        @Override public boolean equals(Object o) { return s.equals(o); }
        @Override public int hashCode() { return s.hashCode(); }
        @Override public String toString() { return s.toString(); }

    }

}