package io.appmetrica.analytics.impl;

import ir.nasim.C12275eL0;

/* loaded from: classes3.dex */
public abstract class A9 {
    public static final C2895u9 a(int i, String str) {
        byte[] bytes;
        C2895u9 c2895u9 = new C2895u9();
        c2895u9.a = i;
        if (str == null || (bytes = str.getBytes(C12275eL0.b)) == null) {
            bytes = c2895u9.b;
        }
        c2895u9.b = bytes;
        return c2895u9;
    }
}
