package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC13042fc3;

/* renamed from: io.appmetrica.analytics.impl.t5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2867t5 implements InterfaceC2994yc {
    public final String a;

    public C2867t5(String str) {
        this.a = str;
    }

    public final C2867t5 a(String str) {
        return new C2867t5(str);
    }

    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2867t5) && AbstractC13042fc3.d(this.a, ((C2867t5) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.a + ')';
    }

    public static C2867t5 a(C2867t5 c2867t5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c2867t5.a;
        }
        c2867t5.getClass();
        return new C2867t5(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2994yc
    public final String a() {
        return this.a;
    }
}
