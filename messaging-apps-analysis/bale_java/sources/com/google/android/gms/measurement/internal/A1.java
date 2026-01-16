package com.google.android.gms.measurement.internal;

import ir.nasim.InterfaceC11995dt8;
import java.util.Map;

/* loaded from: classes3.dex */
final class A1 implements InterfaceC11995dt8 {
    final /* synthetic */ String a;
    final /* synthetic */ B1 b;

    A1(B1 b1, String str) {
        this.b = b1;
        this.a = str;
    }

    @Override // ir.nasim.InterfaceC11995dt8
    public final String a(String str) {
        Map map = (Map) this.b.d.get(this.a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
