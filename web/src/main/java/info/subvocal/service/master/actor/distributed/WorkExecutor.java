package info.subvocal.service.master.actor.distributed;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * When the worker receives work from the master it delegates the actual processing to a child actor, WorkExecutor,
 * to keep the worker responsive while executing the work.
 */
public class WorkExecutor extends UntypedActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) {
        if (message instanceof Work.Square) {
            Integer n = ((Work.Square) message).getOperand();
            int n2 = n * n;
            String result = n + " * " + n + " = " + n2;
            log.debug("Produced result {}", result);
            getSender().tell(new Worker.WorkComplete(result), getSelf());
        }
    }
}
