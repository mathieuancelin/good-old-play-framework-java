package gopf.play.libs.cache;

import gopf.play.java.GoodOldPlayFrameworkContext;

import java.util.concurrent.Callable;

public class Cache {

    public static <T> T get(String key) {
        return GoodOldPlayFrameworkContext.cache().get(key);
    }
    public static <T> T getOrElse(String key, Callable<T> block, int expiration) {
        return GoodOldPlayFrameworkContext.cache().getOrElse(key, block, expiration);
    }
    public static <T> T getOrElse(String key, Callable<T> block) {
        return GoodOldPlayFrameworkContext.cache().getOrElse(key, block);
    }
    public static void set(String key, Object value, int expiration) {
        GoodOldPlayFrameworkContext.cache().set(key, value, expiration);
    }
    public static void set(String key, Object value) {
        GoodOldPlayFrameworkContext.cache().set(key, value);
    }
    public static void remove(String key) {
        GoodOldPlayFrameworkContext.cache().remove(key);
    }
}
