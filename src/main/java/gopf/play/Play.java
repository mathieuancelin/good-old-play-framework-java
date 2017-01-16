package gopf.play;

import gopf.play.java.GoodOldPlayFrameworkContext;
import play.Application;
import play.Configuration;
import play.Mode;
import play.inject.Injector;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Play {
    public static Application application() { return GoodOldPlayFrameworkContext.application(); }
    public static Application current() { return GoodOldPlayFrameworkContext.application(); }
    public static Injector injector() { return GoodOldPlayFrameworkContext.injector(); }
    public static ClassLoader classloader() { return GoodOldPlayFrameworkContext.application().classloader(); }
    public static Configuration configuration() { return GoodOldPlayFrameworkContext.configuration(); }
    public static boolean isDev() { return GoodOldPlayFrameworkContext.mode() == Mode.DEV; }
    public static boolean isProd() { return GoodOldPlayFrameworkContext.mode() == Mode.PROD; }
    public static boolean isTest() { return GoodOldPlayFrameworkContext.mode() == Mode.TEST; }
    public static Mode mode() { return GoodOldPlayFrameworkContext.mode(); }
    public static File getFile(String relativePath) { return GoodOldPlayFrameworkContext.application().getFile(relativePath); }
    public static URL resource(String name) { return GoodOldPlayFrameworkContext.application().resource(name); };
    public static InputStream resourceAsStream(String name) { return GoodOldPlayFrameworkContext.application().resourceAsStream(name); }
}
