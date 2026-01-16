package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zi {
    private final SparseArray<aes> a = new SparseArray<>();

    public final aes a(int i) {
        aes aesVar = this.a.get(i);
        if (aesVar != null) {
            return aesVar;
        }
        aes aesVar2 = new aes(Long.MAX_VALUE);
        this.a.put(i, aesVar2);
        return aesVar2;
    }

    public final void b() {
        this.a.clear();
    }
}
