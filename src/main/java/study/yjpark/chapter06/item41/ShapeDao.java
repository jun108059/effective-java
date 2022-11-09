package study.yjpark.chapter06.item41;

public class ShapeDao {

    // other dao methods

    public boolean delete(Object object) {
        if (!(object instanceof Deletable)) {
            return false;
        }
        // delete 기능 구현
        return true;
    }
}
