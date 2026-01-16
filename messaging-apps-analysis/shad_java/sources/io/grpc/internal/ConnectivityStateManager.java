package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class ConnectivityStateManager {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private volatile ConnectivityState state = ConnectivityState.IDLE;

    ConnectivityStateManager() {
    }

    void gotoState(ConnectivityState connectivityState) {
        Preconditions.checkNotNull(connectivityState, "newState");
        if (this.state == connectivityState || this.state == ConnectivityState.SHUTDOWN) {
            return;
        }
        this.state = connectivityState;
        if (this.listeners.isEmpty()) {
            return;
        }
        ArrayList<Listener> arrayList = this.listeners;
        this.listeners = new ArrayList<>();
        Iterator<Listener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().runInExecutor();
        }
    }

    private static final class Listener {
        final Runnable callback;
        final Executor executor;

        void runInExecutor() {
            this.executor.execute(this.callback);
        }
    }
}
