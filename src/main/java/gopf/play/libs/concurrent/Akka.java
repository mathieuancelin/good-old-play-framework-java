package gopf.play.libs.concurrent;

import akka.actor.ActorSystem;
import akka.actor.Scheduler;
import akka.stream.Materializer;
import gopf.play.java.GoodOldPlayFrameworkContext;

public class Akka {
    public static Scheduler defaultScheduler() { return GoodOldPlayFrameworkContext.scheduler(); }
    public static ActorSystem defaultActorSystem() { return GoodOldPlayFrameworkContext.actorSystem(); }
    public static Materializer defaultMaterializer() { return GoodOldPlayFrameworkContext.materializer(); }
}
