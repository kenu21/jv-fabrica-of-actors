package actors;

import akka.actor.typed.ActorSystem;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int amountActors;
        try {
            amountActors = Integer.parseInt(args[0]);
        } catch (Exception e) {
            throw new RuntimeException("You can set amount of actors");
        }
        final ActorSystem<CloneActor.Message> firstActor = ActorSystem.create(CloneActor.create(1), "first");
        firstActor.tell(new CloneActor.Message(0, amountActors));
        try {
            System.out.println("Press any button and \"enter\" for exit");
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            firstActor.terminate();
        }
    }
}
