package jawnae.pyronet;

import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class PyroSelector {
    public static boolean DO_NOT_CHECK_NETWORK_THREAD = true;
    private int currentAcccount;
    Thread networkThread;
    final Selector nioSelector;
    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue();
    final ByteBuffer networkBuffer = ByteBuffer.allocateDirect(65536);

    public PyroSelector(int currentAcccount) {
        try {
            this.nioSelector = Selector.open();
            this.networkThread = Thread.currentThread();
            this.currentAcccount = currentAcccount;
        } catch (IOException e) {
            throw new PyroException("Failed to open a selector?!", e);
        }
    }

    public final boolean isNetworkThread() {
        return DO_NOT_CHECK_NETWORK_THREAD || this.networkThread == Thread.currentThread();
    }

    public final void checkThread() {
        if (!DO_NOT_CHECK_NETWORK_THREAD && !isNetworkThread()) {
            throw new PyroException("call from outside the network-thread, you must schedule tasks");
        }
    }

    public PyroClient connect(InetSocketAddress host) throws IOException {
        return connect(host, null);
    }

    public PyroClient connect(InetSocketAddress host, InetSocketAddress bind) throws IOException {
        return new PyroClient(this, bind, host, this.currentAcccount);
    }

    public void select() throws IOException {
        select(6000L);
    }

    public void select(long eventTimeout) throws IOException {
        checkThread();
        executePendingTasks();
        performNioSelect(eventTimeout);
        long jCurrentTimeMillis = System.currentTimeMillis();
        handleSelectedKeys(jCurrentTimeMillis);
        handleSocketTimeouts(jCurrentTimeMillis);
    }

    private void executePendingTasks() {
        while (true) {
            Runnable runnablePoll = this.tasks.poll();
            if (runnablePoll == null) {
                return;
            }
            try {
                runnablePoll.run();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void performNioSelect(long timeout) throws IOException {
        try {
            this.nioSelector.select(timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleSelectedKeys(long now) {
        Iterator<SelectionKey> it = this.nioSelector.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            if (next.channel() instanceof SocketChannel) {
                ((PyroClient) next.attachment()).onInterestOp(now);
            }
        }
    }

    private void handleSocketTimeouts(long now) throws SocketTimeoutException {
        for (SelectionKey selectionKey : this.nioSelector.keys()) {
            if (selectionKey.channel() instanceof SocketChannel) {
                PyroClient pyroClient = (PyroClient) selectionKey.attachment();
                if (pyroClient.didTimeout(now)) {
                    try {
                        throw new SocketTimeoutException("PyroNet detected NIO timeout");
                    } catch (SocketTimeoutException e) {
                        pyroClient.onConnectionError(e);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public void spawnNetworkThread(final String name) {
        this.networkThread = null;
        new Thread(new Runnable() { // from class: jawnae.pyronet.PyroSelector.1
            @Override // java.lang.Runnable
            public void run() {
                PyroSelector.this.networkThread = Thread.currentThread();
                while (true) {
                    try {
                        PyroSelector.this.select();
                        Log.w("selector", "selector . . . ");
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }, name).start();
    }

    public void scheduleTask(Runnable task) throws InterruptedException {
        task.getClass();
        try {
            this.tasks.put(task);
            wakeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void wakeup() {
        this.nioSelector.wakeup();
    }

    final SelectionKey register(SelectableChannel channel, int ops) throws IOException {
        return channel.register(this.nioSelector, ops);
    }

    final boolean adjustInterestOp(SelectionKey key, int op, boolean state) {
        checkThread();
        try {
            int iInterestOps = key.interestOps();
            boolean z = true;
            if (state == ((iInterestOps & op) == op)) {
                z = false;
            }
            if (z) {
                key.interestOps(state ? op | iInterestOps : (op ^ (-1)) & iInterestOps);
            }
            return z;
        } catch (CancelledKeyException unused) {
            return false;
        }
    }
}
