package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class acm implements abw {
    private final acp a;
    private final String b;
    private final int c;
    private final int d;

    public acm(String str) {
        this();
        ary.v(str);
        this.b = str;
        this.c = 8000;
        this.d = 8000;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abw
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final acq a() {
        return c(this.a);
    }

    protected /* bridge */ /* synthetic */ acq c(acp acpVar) {
        return new aci(this.b, this.c, this.d, acpVar);
    }

    public acm() {
        this.a = new acp();
    }
}
