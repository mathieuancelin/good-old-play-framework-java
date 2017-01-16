# GoodOldPlayFramework-Java

Use Play Scala 2.5 like it's Play Scala 2.4

* Add the library in your build
```scala
resolvers += "good-old-play-framework-java repository" at "https://raw.githubusercontent.com/mathieuancelin/good-old-play-framework-java/master/repository/releases"

libraryDependencies += "org.reactivecouchbase" %% "good-old-play-framework-java" % "1.0.0"
```
* in the `conf/application.conf` file add
  - `play.application.loader = "gopf.play.GooOldPlayFrameworkLoader"`
* in the `build.sbt` file, add (if you want to use static routes)
  - `routesGenerator := StaticRoutesGenerator`
* declare your controllers as objects
  - `public class MyController extends GoodOldPlayFrameworkController { ... }`
* use the interface `gopf.play.java.GoodOldPlayframework` wherever you want or just use `gopf.play.*` imports
* Have fun not using `@Inject` (except maybe for Filter, ErrorHandler, modules, etc ...)

## Before

```java
package controllers;

import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletionStage;

@Singleton
public class MyController extends Controller {

    private final WSClient wsClient;

    @Inject
    public MyController(WSClient wsClient) {
        this.wsClient = wsClient;
    }

    public CompletionStage<Result> ip() {
        return wsClient.url("http://jsonip.com").get()
            .thenApply(WSResponse::asJson)
            .thenApply(Results::ok);
    }
}
```

## After

```java
package controllers;

import gopf.play.libs.ws.WS;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import java.util.concurrent.CompletionStage;

public class MyController extends Controller {

    public static CompletionStage<Result> ip() {
        return WS.url("http://jsonip.com").get()
            .thenApply(WSResponse::asJson)
            .thenApply(Results::ok);
    }
}
```
