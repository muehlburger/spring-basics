package org.springframework.basics.sectionxx;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class CustomProtocolHandler implements SmartLifecycle {

    private boolean running;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAutoStartup() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop(Runnable callback) {
        this.running = false;
        System.out.println("protocol handler stopped");

        callback.run();
    }

    @Override
    public void start() {
        // start the protocol handler
        this.running = true;
        System.out.println("protocol handler started");
    }

    @Override
    public void stop() {
        // stop the protocol handler
        this.running = false;
        System.out.println("protocol handler stopped");
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public int getPhase() {
        return 0;
    }

}
