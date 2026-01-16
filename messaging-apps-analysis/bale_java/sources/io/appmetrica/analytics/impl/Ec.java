package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Ec extends K2 {
    public final String b;

    public Ec(String str, InterfaceC2882tk interfaceC2882tk) {
        super(interfaceC2882tk);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.K2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
