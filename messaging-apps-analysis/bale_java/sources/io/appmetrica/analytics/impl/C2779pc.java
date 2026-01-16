package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import io.sentry.protocol.DebugImage;

/* renamed from: io.appmetrica.analytics.impl.pc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2779pc {
    public static final SparseArray c;
    public final String a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new C2779pc(DebugImage.JVM, "binder"));
        sparseArray.put(5890, new C2779pc(DebugImage.JVM, "intent"));
        sparseArray.put(5889, new C2779pc(DebugImage.JVM, "file"));
        sparseArray.put(5897, new C2779pc("jni_native", "file"));
        sparseArray.put(5898, new C2779pc("jni_native", "file"));
    }

    public C2779pc(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
