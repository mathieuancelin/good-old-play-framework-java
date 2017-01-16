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

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public interface GoodOldPlayFramework {

    default GoodOldPlayFramework gopf() {
        return GoodOldPlayFrameworkContext.current();
    }

    default Application application() {
        return GoodOldPlayFrameworkContext.application();
    }

    default Injector injector() {
        return GoodOldPlayFrameworkContext.injector();
    }

    default Environment environment() {
        return GoodOldPlayFrameworkContext.environment();
    }

    default ActorSystem actorSystem() {
        return GoodOldPlayFrameworkContext.actorSystem();
    }

    default Materializer materializer() {
        return GoodOldPlayFrameworkContext.materializer();
    }

    default Configuration configuration() {
        return GoodOldPlayFrameworkContext.configuration();
    }

    default Scheduler scheduler() {
        return GoodOldPlayFrameworkContext.scheduler();
    }

    default Mode mode() {
        return GoodOldPlayFrameworkContext.mode();
    }

    default Executor executor() {
        return GoodOldPlayFrameworkContext.executor();
    }

    default WSClient ws() {
        return GoodOldPlayFrameworkContext.ws();
    }

    default DBApi db() {
        return GoodOldPlayFrameworkContext.db();
    }

    default CacheApi cache() {
        return GoodOldPlayFrameworkContext.cache();
    }

    default Integer procNumber() {
        return GoodOldPlayFrameworkContext.procNumber();
    }

    default ExecutorService httpRequestContext() {
        return GoodOldPlayFrameworkContext.httpRequestContext();
    }

    default ExecutorService httpCallsExecContext() {
        return GoodOldPlayFrameworkContext.httpCallsExecContext();
    }

    default ExecutorService dataStoreExecContext() {
        return GoodOldPlayFrameworkContext.dataStoreExecContext();
    }
}
