package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ata extends asv {
    final AtomicReferenceFieldUpdater<ath, Thread> a;
    final AtomicReferenceFieldUpdater<ath, ath> b;
    final AtomicReferenceFieldUpdater<ati, ath> c;
    final AtomicReferenceFieldUpdater<ati, asz> d;
    final AtomicReferenceFieldUpdater<ati, Object> e;

    ata(AtomicReferenceFieldUpdater<ath, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<ath, ath> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<ati, ath> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<ati, asz> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<ati, Object> atomicReferenceFieldUpdater5) {
        this.a = atomicReferenceFieldUpdater;
        this.b = atomicReferenceFieldUpdater2;
        this.c = atomicReferenceFieldUpdater3;
        this.d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final void a(ath athVar, Thread thread) {
        this.a.lazySet(athVar, thread);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final void b(ath athVar, ath athVar2) {
        this.b.lazySet(athVar, athVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean c(ati<?> atiVar, ath athVar, ath athVar2) {
        return this.c.compareAndSet(atiVar, athVar, athVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean d(ati<?> atiVar, asz aszVar, asz aszVar2) {
        return this.d.compareAndSet(atiVar, aszVar, aszVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean e(ati<?> atiVar, Object obj, Object obj2) {
        return this.e.compareAndSet(atiVar, obj, obj2);
    }
}
