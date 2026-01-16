package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajk extends agt<AtomicIntegerArray> {
    ajk() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ AtomicIntegerArray read(alb albVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        albVar.a();
        while (albVar.e()) {
            try {
                arrayList.add(Integer.valueOf(albVar.l()));
            } catch (NumberFormatException e) {
                throw new agq(e);
            }
        }
        albVar.b();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
        aldVar.b();
        int length = atomicIntegerArray.length();
        for (int i = 0; i < length; i++) {
            aldVar.h(r6.get(i));
        }
        aldVar.d();
    }
}
