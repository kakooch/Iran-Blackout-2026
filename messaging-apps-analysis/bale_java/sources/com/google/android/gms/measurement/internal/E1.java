package com.google.android.gms.measurement.internal;

import android.os.Process;
import ir.nasim.AbstractC3795Cj5;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes3.dex */
final class E1 extends Thread {
    private final Object a;
    private final BlockingQueue b;
    private boolean c = false;
    final /* synthetic */ F1 d;

    public E1(F1 f1, String str, BlockingQueue blockingQueue) {
        this.d = f1;
        AbstractC3795Cj5.j(str);
        AbstractC3795Cj5.j(blockingQueue);
        this.a = new Object();
        this.b = blockingQueue;
        setName(str);
    }

    private final void b() {
        synchronized (this.d.i) {
            try {
                if (!this.c) {
                    this.d.j.release();
                    this.d.i.notifyAll();
                    F1 f1 = this.d;
                    if (this == f1.c) {
                        f1.c = null;
                    } else if (this == f1.d) {
                        f1.d = null;
                    } else {
                        f1.a.b().r().a("Current scheduler thread is neither worker nor network");
                    }
                    this.c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c(InterruptedException interruptedException) {
        this.d.a.b().w().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.a) {
            this.a.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        boolean z = false;
        while (!z) {
            try {
                this.d.j.acquire();
                z = true;
            } catch (InterruptedException e) {
                c(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                D1 d1 = (D1) this.b.poll();
                if (d1 != null) {
                    Process.setThreadPriority(true != d1.b ? 10 : threadPriority);
                    d1.run();
                } else {
                    synchronized (this.a) {
                        if (this.b.peek() == null) {
                            F1.B(this.d);
                            try {
                                this.a.wait(30000L);
                            } catch (InterruptedException e2) {
                                c(e2);
                            }
                        }
                    }
                    synchronized (this.d.i) {
                        if (this.b.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
