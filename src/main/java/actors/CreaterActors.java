package actors;

import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Receive;

public class CreaterActors extends AbstractBehavior<Integer> {
    private final int numberChildActors;

    public CreaterActors(ActorContext<Integer> context, int numberChildActors) {
        super(context);
        this.numberChildActors = numberChildActors;
    }

    @Override
    public Receive<Integer> createReceive() {
        return null;
    }
}
