package gopf.play.libs.ws;

import gopf.play.java.GoodOldPlayFrameworkContext;
import play.libs.ws.WSRequest;

import java.io.IOException;

public class WS {
    public static WSRequest url(String url) { return GoodOldPlayFrameworkContext.ws().url(url); }
    public static Object underlying() { return GoodOldPlayFrameworkContext.ws().getUnderlying(); }
    public static void close() throws IOException { GoodOldPlayFrameworkContext.ws().close(); }
}
