package ir.nasim;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class BF4 implements ThreadFactory {
    private final String a;
    private final AtomicInteger b = new AtomicInteger();
    private final int c;

    public BF4(String str, int i) {
        this.a = str;
        this.c = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.a + "_" + this.b.getAndIncrement());
        int i = this.c;
        if (i != -1987432) {
            thread.setPriority(i);
        }
        return thread;
    }
}
