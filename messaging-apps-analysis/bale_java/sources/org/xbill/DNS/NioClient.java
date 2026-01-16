package org.xbill.DNS;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import lombok.Generated;
import org.xbill.DNS.NioClient;
import org.xbill.DNS.utils.hexdump;

/* loaded from: classes8.dex */
public abstract class NioClient {
    private static Thread closeThread;
    private static volatile boolean run;
    private static volatile Selector selector;
    private static Thread selectorThread;

    @Generated
    private static final OI3 log = RI3.i(NioClient.class);
    private static PacketLogger packetLogger = null;
    private static final Runnable[] TIMEOUT_TASKS = new Runnable[2];
    private static final Runnable[] REGISTRATIONS_TASKS = new Runnable[2];
    private static final Runnable[] CLOSE_TASKS = new Runnable[2];

    interface KeyProcessor {
        void processReadyKey(SelectionKey selectionKey);
    }

    private static void addTask(Runnable[] runnableArr, Runnable runnable, boolean z) {
        if (z) {
            runnableArr[0] = runnable;
        } else {
            runnableArr[1] = runnable;
        }
    }

    public static void close() throws InterruptedException, IOException {
        close(false);
    }

    private static void processReadyKeys() {
        Iterator<SelectionKey> it = selector.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            ((KeyProcessor) next.attachment()).processReadyKey(next);
        }
    }

    static void runSelector() {
        int iIntValue = Integer.getInteger("dnsjava.nio.selector_timeout", AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT).intValue();
        if (iIntValue <= 0 || iIntValue > 1000) {
            throw new IllegalArgumentException("Invalid selector_timeout, must be between 1 and 1000");
        }
        while (run) {
            try {
                if (selector.select(iIntValue) == 0) {
                    runTasks(TIMEOUT_TASKS);
                }
                if (run) {
                    runTasks(REGISTRATIONS_TASKS);
                    processReadyKeys();
                }
            } catch (IOException e) {
                log.a("A selection operation failed", e);
            } catch (ClosedSelectorException unused) {
            }
        }
        log.b("dnsjava NIO selector thread stopped");
    }

    private static synchronized void runTasks(Runnable[] runnableArr) {
        try {
            Runnable runnable = runnableArr[0];
            if (runnable != null) {
                runnable.run();
            }
            Runnable runnable2 = runnableArr[1];
            if (runnable2 != null) {
                runnable2.run();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static Selector selector() {
        if (selector == null) {
            synchronized (NioClient.class) {
                try {
                    if (selector == null) {
                        selector = Selector.open();
                        log.b("Starting dnsjava NIO selector thread");
                        run = true;
                        Thread thread = new Thread(new Runnable() { // from class: org.xbill.DNS.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                NioClient.runSelector();
                            }
                        });
                        selectorThread = thread;
                        thread.setDaemon(true);
                        selectorThread.setName("dnsjava NIO selector");
                        selectorThread.start();
                        Thread thread2 = new Thread(new Runnable() { // from class: ir.nasim.Uz4
                            @Override // java.lang.Runnable
                            public final void run() throws InterruptedException, IOException {
                                NioClient.close(true);
                            }
                        });
                        closeThread = thread2;
                        thread2.setName("dnsjava NIO shutdown hook");
                        if (Boolean.parseBoolean(System.getProperty("dnsjava.nio.register_shutdown_hook", "true"))) {
                            Runtime.getRuntime().addShutdownHook(closeThread);
                        }
                    }
                } finally {
                }
            }
        }
        return selector;
    }

    static synchronized void setCloseTask(Runnable runnable, boolean z) {
        addTask(CLOSE_TASKS, runnable, z);
    }

    static void setPacketLogger(PacketLogger packetLogger2) {
        packetLogger = packetLogger2;
    }

    static synchronized void setRegistrationsTask(Runnable runnable, boolean z) {
        addTask(REGISTRATIONS_TASKS, runnable, z);
    }

    static synchronized void setTimeoutTask(Runnable runnable, boolean z) {
        addTask(TIMEOUT_TASKS, runnable, z);
    }

    static void verboseLog(String str, SocketAddress socketAddress, SocketAddress socketAddress2, ByteBuffer byteBuffer) {
        if (log.j() || packetLogger != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            int iPosition = byteBuffer.position();
            byteBuffer.get(bArr, 0, byteBuffer.remaining());
            byteBuffer.position(iPosition);
            verboseLog(str, socketAddress, socketAddress2, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void close(boolean z) throws InterruptedException, IOException {
        run = false;
        if (!z) {
            try {
                Runtime.getRuntime().removeShutdownHook(closeThread);
            } catch (Exception unused) {
                log.y("Failed to remove shutdown hook, ignoring and continuing close");
            }
        }
        try {
            runTasks(CLOSE_TASKS);
        } catch (Exception e) {
            log.m("Failed to execute shutdown task, ignoring and continuing close", e);
        }
        Selector selector2 = selector;
        Thread thread = selectorThread;
        synchronized (NioClient.class) {
            selector = null;
            selectorThread = null;
            closeThread = null;
        }
        if (selector2 != null) {
            selector2.wakeup();
            try {
                selector2.close();
            } catch (IOException e2) {
                log.m("Failed to properly close selector, ignoring and continuing close", e2);
            }
        }
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static void verboseLog(String str, SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr) {
        OI3 oi3 = log;
        if (oi3.j()) {
            oi3.z(hexdump.dump(str, bArr));
        }
        PacketLogger packetLogger2 = packetLogger;
        if (packetLogger2 != null) {
            packetLogger2.log(str, socketAddress, socketAddress2, bArr);
        }
    }
}
