package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class A8 {
    public final C2707mc a;
    public final C2707mc b;

    public A8() {
        this(new Q7(), new F9(), new C2428b());
    }

    public A8(Q7 q7, F9 f9, C2428b c2428b) {
        C2707mc c2707mc = new C2707mc(q7);
        this.a = c2707mc;
        c2707mc.a(B8.NONE, q7);
        c2707mc.a(B8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, f9);
        c2707mc.a(B8.AES_VALUE_ENCRYPTION, c2428b);
        this.b = new C2707mc(q7);
    }
}
