import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class CrearTablasBolsa {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:h2:file:./bolsa";
        ConnectionSource conexion =
                new JdbcConnectionSource(url);
        TableUtils.createTable(conexion, Aspirante.class);
        System.out.println("Tabla creada satisfactoriamente");
        conexion.close();
    }
}
