package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aub {
    private final ConcurrentHashMap<aua, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> b = new ReferenceQueue<>();

    aub() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        ReferenceQueue<Throwable> referenceQueue = this.b;
        while (true) {
            Reference<? extends Throwable> referencePoll = referenceQueue.poll();
            if (referencePoll == null) {
                break;
            }
            this.a.remove(referencePoll);
            referenceQueue = this.b;
        }
        List<Throwable> list = this.a.get(new aua(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> listPutIfAbsent = this.a.putIfAbsent(new aua(th, this.b), vector);
        return listPutIfAbsent == null ? vector : listPutIfAbsent;
    }
}
