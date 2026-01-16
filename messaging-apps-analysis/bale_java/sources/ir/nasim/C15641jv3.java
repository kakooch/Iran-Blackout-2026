package ir.nasim;

import ir.nasim.AbstractC17424mw3;

/* renamed from: ir.nasim.jv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15641jv3 implements AbstractC17424mw3.a {
    private final UA2 a;
    private final InterfaceC14603iB2 b;
    private final UA2 c;
    private final InterfaceC16978mB2 d;

    public C15641jv3(UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2) {
        this.a = ua2;
        this.b = interfaceC14603iB2;
        this.c = ua22;
        this.d = interfaceC16978mB2;
    }

    public final InterfaceC16978mB2 a() {
        return this.d;
    }

    public final InterfaceC14603iB2 b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17424mw3.a
    public UA2 getKey() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17424mw3.a
    public UA2 getType() {
        return this.c;
    }
}
