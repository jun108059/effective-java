package study.yjpark.chapter01.item01;

// 정적 팩터리 메서드 샘플
// 메서드 이름으로 생성 객체를 명확히 표현 가능
// 생성자의 시그니처가 중복되는 경우 활용
public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;

    /**
     * 인스턴스를 만들어서 리턴하는 정적 팩터리 메서드
     *
     * @param product 제품
     * @return 주문
     */
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;

        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    public static void main(String[] args) {
        Order order = new Order();
        if (order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("delivered");
        }
    }

}
