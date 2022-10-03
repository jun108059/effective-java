package study.yjpark.chapter04.item19.SideEffect;

class Starbucks extends Coffee {
    int price;
    String beanKind;
    String getBeanKind() {
        return beanKind;
    }
    @Override
    protected String selectDefault() {
        return "arabica";
    }

    Starbucks(String beanType) {
        this.price = 4500;
        this.beanKind = super.decideBean(beanType);
    }
}