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
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class GoodOldPlayFrameworkContext {

    private static ThreadFactory factory(String of) {
        AtomicInteger counter = new AtomicInteger(0);
        return r -> new Thread(r, of + "- " + counter.incrementAndGet());
    }

    private static LazyVal<play.api.inject.Injector> _scalaInjector = LazyVal.of(gopf.play.GooOldPlayFrameworkContext::injector);
    private static LazyVal<GoodOldPlayFramework> _context = LazyVal.of(() -> new GoodOldPlayFramework() {});
    private static LazyVal<Application> _application = _scalaInjector.map(i -> i.instanceOf(Application.class));
    private static LazyVal<Injector> _injector = _application.map(Application::injector);
    private static LazyVal<Environment> _environment = _scalaInjector.map(a -> a.instanceOf(Environment.class));
    private static LazyVal<ActorSystem> _actorySystem = _scalaInjector.map(a -> a.instanceOf(ActorSystem.class));
    private static LazyVal<Materializer> _materializer = _scalaInjector.map(a -> a.instanceOf(Materializer.class));
    private static LazyVal<Configuration> _configuration = _application.map(Application::configuration);
    private static LazyVal<Scheduler> _scheduler = _actorySystem.map(ActorSystem::scheduler);
    private static LazyVal<Mode> _mode = _environment.map(Environment::mode);
    private static LazyVal<Executor> _executor = _scalaInjector.map(a -> a.instanceOf(Executor.class));
    private static LazyVal<WSClient> _wsClient = _scalaInjector.map(a -> a.instanceOf(WSClient.class));
    private static LazyVal<DBApi> _dbApi = _scalaInjector.map(a -> a.instanceOf(DBApi.class));
    private static LazyVal<CacheApi> _cacheApi = _injector.map(a -> a.instanceOf(CacheApi.class));
    private static LazyVal<Integer> _procNumber = LazyVal.of(() -> Runtime.getRuntime().availableProcessors());
    private static LazyVal<ExecutorService> _httpRequestContext = LazyVal.of(() -> Executors.newFixedThreadPool(_configuration.get().getInt("gopf.threadpools.http-requests", 2), factory("http-requests")));
    private static LazyVal<ExecutorService> _httpCallsExecContext = LazyVal.of(() -> Executors.newFixedThreadPool(_configuration.get().getInt("gopf.threadpools.http-calls", 10), factory("http-calls")));
    private static LazyVal<ExecutorService> _dataStoreExecContext = LazyVal.of(() -> Executors.newFixedThreadPool(_configuration.get().getInt("gopf.threadpools.data-store", 5), factory("data-store")));

    public static Application application() { return _application.get(); }
    public static Injector injector() { return _injector.get(); }
    public static Environment environment() { return _environment.get(); }
    public static ActorSystem actorSystem() { return _actorySystem.get(); }
    public static Materializer materializer() { return _materializer.get(); }
    public static Configuration configuration() { return _configuration.get(); }
    public static Scheduler scheduler() { return _scheduler.get(); }
    public static Mode mode() { return _mode.get(); }
    public static Executor executor() { return _executor.get(); }
    public static WSClient ws() { return _wsClient.get(); }
    public static DBApi db() { return _dbApi.get(); }
    public static CacheApi cache() { return _cacheApi.get(); }
    public static Integer procNumber() { return _procNumber.get(); }
    public static ExecutorService httpRequestContext() { return _httpRequestContext.get(); }
    public static ExecutorService httpCallsExecContext() { return _httpCallsExecContext.get(); }
    public static ExecutorService dataStoreExecContext() { return _dataStoreExecContext.get(); }
    public static GoodOldPlayFramework current() { return _context.get(); }
}
