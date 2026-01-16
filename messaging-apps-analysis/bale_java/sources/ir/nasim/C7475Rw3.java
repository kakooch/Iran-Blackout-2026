package ir.nasim;

import ir.nasim.AbstractC17424mw3;

/* renamed from: ir.nasim.Rw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7475Rw3 implements AbstractC17424mw3.a {
    private final UA2 a;
    private final UA2 b;
    private final InterfaceC16978mB2 c;

    public C7475Rw3(UA2 ua2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2) {
        this.a = ua2;
        this.b = ua22;
        this.c = interfaceC16978mB2;
    }

    public final InterfaceC16978mB2 a() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17424mw3.a
    public UA2 getKey() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17424mw3.a
    public UA2 getType() {
        return this.b;
    }
}
