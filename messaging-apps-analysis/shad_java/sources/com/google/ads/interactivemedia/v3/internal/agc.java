package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class agc extends agt<AtomicLongArray> {
    final /* synthetic */ agt a;

    agc(agt agtVar) {
        this.a = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ AtomicLongArray read(alb albVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        albVar.a();
        while (albVar.e()) {
            arrayList.add(Long.valueOf(((Number) this.a.read(albVar)).longValue()));
        }
        albVar.b();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i = 0; i < size; i++) {
            atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
        }
        return atomicLongArray;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, AtomicLongArray atomicLongArray) throws IOException {
        AtomicLongArray atomicLongArray2 = atomicLongArray;
        aldVar.b();
        int length = atomicLongArray2.length();
        for (int i = 0; i < length; i++) {
            this.a.write(aldVar, Long.valueOf(atomicLongArray2.get(i)));
        }
        aldVar.d();
    }
}
