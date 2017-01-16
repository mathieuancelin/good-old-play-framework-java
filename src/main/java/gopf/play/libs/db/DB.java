package gopf.play.libs.db;

import gopf.play.java.GoodOldPlayFrameworkContext;
import play.db.ConnectionCallable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Optional;

public class DB {
    public static Connection getConnection(String _name, Boolean _autocommit) {
        String name = Optional.ofNullable(_name).orElse("default");
        boolean autocommit = Optional.ofNullable(_autocommit).orElse(true);
        return GoodOldPlayFrameworkContext.db().getDatabase(name).getConnection(autocommit);
    }
    public static DataSource getDataSource(String _name) {
        String name = Optional.ofNullable(_name).orElse("default");
        return GoodOldPlayFrameworkContext.db().getDatabase(name).getDataSource();
    }
    public static <A> A withConnection(ConnectionCallable<A> block) {
        return GoodOldPlayFrameworkContext.db().getDatabase("default").withConnection(block);
    }
    public static <A> A withConnection(String name, ConnectionCallable<A> block) {
        return GoodOldPlayFrameworkContext.db().getDatabase(name).withConnection(block);
    }
    public static <A> A withTransaction(ConnectionCallable<A> block) {
        return GoodOldPlayFrameworkContext.db().getDatabase("default").withTransaction(block);
    }
    public static <A> A withTransaction(String _name, ConnectionCallable<A> block) {
        String name = Optional.ofNullable(_name).orElse("default");
        return GoodOldPlayFrameworkContext.db().getDatabase(name).withTransaction(block);
    }
}
