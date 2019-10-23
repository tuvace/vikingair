package servlets.interfaces;

        import java.util.ArrayList;

public interface VikingAir <V> {

    void create(V v);

    void delete(int id);

    void update(V v);

    ArrayList<V> showAll();

    V showOne(int id);
}