package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class at {
    private final BlockingQueue<Runnable> a;
    private final ThreadPoolExecutor b;
    private final ArrayDeque<as> c = new ArrayDeque<>();
    private as d = null;

    public at() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.a = linkedBlockingQueue;
        this.b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void c() {
        as asVarPoll = this.c.poll();
        this.d = asVarPoll;
        if (asVarPoll != null) {
            asVarPoll.executeOnExecutor(this.b, new Object[0]);
        }
    }

    public final void a(as asVar) {
        asVar.b(this);
        this.c.add(asVar);
        if (this.d == null) {
            c();
        }
    }

    public final void b() {
        this.d = null;
        c();
    }
}
