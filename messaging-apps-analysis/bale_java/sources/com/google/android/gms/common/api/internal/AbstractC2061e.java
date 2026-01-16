package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.C2060d;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.common.api.internal.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2061e {
    public static C2060d a(Object obj, Looper looper, String str) {
        AbstractC3795Cj5.k(obj, "Listener must not be null");
        AbstractC3795Cj5.k(looper, "Looper must not be null");
        AbstractC3795Cj5.k(str, "Listener type must not be null");
        return new C2060d(looper, obj, str);
    }

    public static C2060d.a b(Object obj, String str) {
        AbstractC3795Cj5.k(obj, "Listener must not be null");
        AbstractC3795Cj5.k(str, "Listener type must not be null");
        AbstractC3795Cj5.g(str, "Listener type must not be empty");
        return new C2060d.a(obj, str);
    }
}
