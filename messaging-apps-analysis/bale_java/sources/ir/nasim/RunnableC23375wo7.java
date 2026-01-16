package ir.nasim;

import java.util.concurrent.CountDownLatch;

/* renamed from: ir.nasim.wo7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final /* synthetic */ class RunnableC23375wo7 implements Runnable {
    public final /* synthetic */ CountDownLatch a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.countDown();
    }
}
