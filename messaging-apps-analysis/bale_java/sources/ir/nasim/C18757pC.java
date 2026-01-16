package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.pC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18757pC extends VB {
    private int a;
    private Long b;
    private EnumC5091Hw c;
    private Boolean d;
    private C19811qz e;
    private C4857Gw f;

    public C18757pC(int i, Long l, EnumC5091Hw enumC5091Hw, Boolean bool, C19811qz c19811qz, C4857Gw c4857Gw) {
        this.a = i;
        this.b = l;
        this.c = enumC5091Hw;
        this.d = bool;
        this.e = c19811qz;
        this.f = c4857Gw;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = Long.valueOf(c19084pl0.y(2));
        this.c = EnumC5091Hw.p(c19084pl0.g(3));
        this.d = Boolean.valueOf(c19084pl0.u(4));
        this.e = (C19811qz) c19084pl0.z(7, new C19811qz());
        this.f = (C4857Gw) c19084pl0.z(8, new C4857Gw());
    }

    @Override // ir.nasim.VB
    public int s() {
        return 16;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        Long l = this.b;
        if (l != null) {
            c19675ql0.g(2, l.longValue());
        }
        EnumC5091Hw enumC5091Hw = this.c;
        if (enumC5091Hw == null) {
            throw new IOException();
        }
        c19675ql0.f(3, enumC5091Hw.j());
        Boolean bool = this.d;
        if (bool != null) {
            c19675ql0.a(4, bool.booleanValue());
        }
        C19811qz c19811qz = this.e;
        if (c19811qz != null) {
            c19675ql0.i(7, c19811qz);
        }
        C4857Gw c4857Gw = this.f;
        if (c4857Gw != null) {
            c19675ql0.i(8, c4857Gw);
        }
    }

    public String toString() {
        return "struct ServiceExPhoneCall{}";
    }

    public EnumC5091Hw u() {
        return this.c;
    }

    public int w() {
        return this.a;
    }

    public Long y() {
        return this.b;
    }

    public Boolean z() {
        return this.d;
    }

    public C18757pC() {
    }
}
