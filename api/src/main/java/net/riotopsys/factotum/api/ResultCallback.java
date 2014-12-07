package net.riotopsys.factotum.api;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by afitzgerald on 8/29/14.
 */
public abstract class ResultCallback implements Runnable{

    private AtomicBoolean stopped = new AtomicBoolean();

    private final CompletionService completionService;

    public ResultCallback(CompletionService completionService) {
        this.completionService = completionService;
    }

    public abstract void onResult( Object result );

    @Override
    public void run() {
        while ( !stopped.get() ){
            try {
                onResult(completionService.take().get());
            } catch (Exception e) {
                //TODO: think of better handling
                //noop
            }
        }
    }

    public void stop(){
        stopped.set(true);
        Thread.currentThread().interrupt();
    }

}