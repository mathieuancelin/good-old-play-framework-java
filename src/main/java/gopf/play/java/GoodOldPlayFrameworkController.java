package gopf.play.java;

import akka.actor.ActorSystem;
import akka.actor.Scheduler;
import akka.stream.Materializer;
import play.Application;
import play.Configuration;
import play.Environment;
import play.Mode;
import play.cache.CacheApi;
import play.db.DBApi;
import play.inject.Injector;
import play.libs.ws.WSClient;
import play.mvc.Controller;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class GoodOldPlayFrameworkController extends Controller {

    public static GoodOldPlayFramework gopf() {
        return GoodOldPlayFrameworkContext.current();
    }

    public static Application application() {
        return GoodOldPlayFrameworkContext.application();
    }

    public static Injector injector() {
        return GoodOldPlayFrameworkContext.injector();
    }

    public static Environment environment() {
        return GoodOldPlayFrameworkContext.environment();
    }

    public static ActorSystem actorSystem() {
        return GoodOldPlayFrameworkContext.actorSystem();
    }

    public static Materializer materializer() {
        return GoodOldPlayFrameworkContext.materializer();
    }

    public static Configuration configuration() {
        return GoodOldPlayFrameworkContext.configuration();
    }

    public static Scheduler scheduler() {
        return GoodOldPlayFrameworkContext.scheduler();
    }

    public static Mode mode() {
        return GoodOldPlayFrameworkContext.mode();
    }

    public static Executor executor() {
        return GoodOldPlayFrameworkContext.executor();
    }

    public static WSClient ws() {
        return GoodOldPlayFrameworkContext.ws();
    }

    public static DBApi db() {
        return GoodOldPlayFrameworkContext.db();
    }

    public static CacheApi cache() {
        return GoodOldPlayFrameworkContext.cache();
    }

    public static Integer procNumber() {
        return GoodOldPlayFrameworkContext.procNumber();
    }

    public static ExecutorService httpRequestContext() {
        return GoodOldPlayFrameworkContext.httpRequestContext();
    }

    public static ExecutorService httpCallsExecContext() {
        return GoodOldPlayFrameworkContext.httpCallsExecContext();
    }

    public static ExecutorService dataStoreExecContext() {
        return GoodOldPlayFrameworkContext.dataStoreExecContext();
    }
}
