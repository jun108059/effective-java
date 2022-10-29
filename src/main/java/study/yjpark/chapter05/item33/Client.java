package study.yjpark.chapter05.item33;

public class Client {
    public static void main(String[] args) {
        Favorites f = new Favorites();

        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());

//        f.putFavorite((Class)Integer.class, "Integer 인스턴스가 아님");
//        Integer favorite = f.getFavorite(Integer.class);
//        System.out.println("favorite = " + favorite);


    }
}
