package study.yjpark.chapter04.item19.SideEffect;

class Coffee {

    // Instance field & Method
    int price;
    int getPrice() {
        return price;
    }

    // static field
    static String kind;
    static String getKind() {
        return kind;
    }

    protected String decideBean(String type) {
        if (type.equals("default")) {
            type = selectDefault();
            printScreen();
        }

        if (type.equals("robusta")) {
            return "robusta";
        } else {
            return "arabica";
        }
    }

    protected String selectDefault() {
        return "robusta";
    }

    protected void printScreen() {
        System.out.println("Default Bean is robusta. Because cheap");
    }
}
