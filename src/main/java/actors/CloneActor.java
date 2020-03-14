package actors;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.io.OutputStream;

public class CloneActor extends AbstractBehavior<CloneActor.Message> {

    public static final class Message {
        public final int numberOfHopsTravelled;
        public final int amountActors;

        public Message(int numberOfHopsTravelled, int amountActors) {
            this.numberOfHopsTravelled = numberOfHopsTravelled;
            this.amountActors = amountActors;
        }
    }

    private final int id;

    private CloneActor(ActorContext<Message> context, int id) {
        super(context);
        this.id = id;
    }

    public static Behavior<CloneActor.Message> create(int id) {
        return Behaviors.setup(context -> new CloneActor(context, id));
    }

    @Override
    public Receive<CloneActor.Message> createReceive() {
        return newReceiveBuilder().onMessage(CloneActor.Message.class, this::onCloneActorMessage).build();
    }

    private Behavior<CloneActor.Message> onCloneActorMessage(CloneActor.Message message) {
        if (id == message.amountActors) {
            System.out.println(message.numberOfHopsTravelled);
            return Behaviors.stopped();
        } else {
            int newId = id + 1;
            ActorRef<CloneActor.Message> messageActorRef = getContext().spawnAnonymous(CloneActor.create(newId));
            int newNumberOfHopsTravelled = message.numberOfHopsTravelled + 1;
            messageActorRef.tell(new CloneActor.Message(newNumberOfHopsTravelled, message.amountActors));
            return this;
        }
    }
}
