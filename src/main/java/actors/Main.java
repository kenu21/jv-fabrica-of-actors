package actors;

import akka.actor.typed.ActorSystem;

public class Main {
    final ActorSystem<CreaterActors> mainActor = ActorSystem.create(CreaterActors.create(), "helloakka");
}
