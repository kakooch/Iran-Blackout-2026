package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class tj implements ui {
    private final SparseArray<ui> a;
    private final int[] b;

    public tj(abw abwVar, kc kcVar) {
        SparseArray<ui> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (ui) wp.class.asSubclass(ui.class).getConstructor(abw.class).newInstance(abwVar));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (ui) Class.forName("com.google.ads.interactivemedia.v3.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(ui.class).getConstructor(abw.class).newInstance(abwVar));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (ui) ys.class.asSubclass(ui.class).getConstructor(abw.class).newInstance(abwVar));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new uu(abwVar, kcVar));
        this.a = sparseArray;
        this.b = new int[sparseArray.size()];
        for (int i = 0; i < this.a.size(); i++) {
            this.b[i] = this.a.keyAt(i);
        }
    }
}
