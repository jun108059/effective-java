package study.yjpark.chapter03.item13.clone_use_constructor;

public class SubItem extends Item implements Cloneable {

    private String name;

    @Override
    public SubItem clone() {
        // 상위 Type to 하위 Type 으로 형변환 불가
        return (SubItem) super.clone();
    }

    public static void main(String[] args) {
        SubItem item = new SubItem();
        SubItem clone = item.clone();

        System.out.println(clone != item);
        System.out.println(clone.getClass() == item.getClass());
        System.out.println(clone.equals(item));
    }
}
