package actors;

import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Receive;

public class CloneActor extends AbstractBehavior<CloneActor.Message> {

    public static final class Message {
        private final int numberOfHopsTravelled;

        public Message(int numberOfHopsTravelled) {
            this.numberOfHopsTravelled = numberOfHopsTravelled;
        }
    }

    private final int id;

    public CloneActor(ActorContext<Message> context, int id) {
        super(context);
        this.id = id;
    }

    @Override
    public Receive<Message> createReceive() {
        return null;
    }
}
