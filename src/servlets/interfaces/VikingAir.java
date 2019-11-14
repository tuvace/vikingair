package servlets.interfaces;

        import java.sql.SQLException;
        import java.util.ArrayList;

public interface VikingAir <V> {

    void create(V v) throws SQLException;

    void delete(int id);

    void update(V v);

    ArrayList<V> showAll() throws SQLException;

    V showOne(int id);
}