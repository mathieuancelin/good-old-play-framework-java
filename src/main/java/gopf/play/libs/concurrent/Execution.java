package gopf.play.libs.concurrent;

import gopf.play.java.GoodOldPlayFrameworkContext;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Execution {

    public static Executor defaultContext() { return GoodOldPlayFrameworkContext.executor(); }
    public static ExecutorService httpRequestsContext() { return GoodOldPlayFrameworkContext.httpRequestContext(); }
    public static ExecutorService httpCallsContext() { return GoodOldPlayFrameworkContext.httpCallsExecContext(); }
    public static ExecutorService dataStoreContext() { return GoodOldPlayFrameworkContext.dataStoreExecContext(); }
}
