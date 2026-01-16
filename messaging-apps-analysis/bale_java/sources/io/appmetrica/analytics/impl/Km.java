package io.appmetrica.analytics.impl;

import android.util.SparseArray;

/* loaded from: classes3.dex */
public abstract class Km {
    public static final SparseArray a;

    static {
        SparseArray sparseArray = new SparseArray();
        a = sparseArray;
        sparseArray.put(0, "String");
        sparseArray.put(1, "Number");
        sparseArray.put(2, "Counter");
    }
}
