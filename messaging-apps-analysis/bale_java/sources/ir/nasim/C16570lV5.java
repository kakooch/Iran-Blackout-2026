package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.lV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16570lV5 extends TP5 {
    private C17557nA a;
    private long b;
    private AbstractC24063xz c;
    private Integer d;
    private C3933Cz e;
    private C16966mA f;
    private C3460Az g;

    public C16570lV5(C17557nA c17557nA, long j, AbstractC24063xz abstractC24063xz, Integer num, C3933Cz c3933Cz, C16966mA c16966mA, C3460Az c3460Az) {
        this.a = c17557nA;
        this.b = j;
        this.c = abstractC24063xz;
        this.d = num;
        this.e = c3933Cz;
        this.f = c16966mA;
        this.g = c3460Az;
    }

    public static C16570lV5 r(byte[] bArr) {
        return (C16570lV5) AbstractC16720ll0.b(new C16570lV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.k(1, new C17557nA());
        this.b = c19084pl0.i(3);
        this.c = AbstractC24063xz.r(c19084pl0.d(4));
        this.d = Integer.valueOf(c19084pl0.x(5));
        this.e = (C3933Cz) c19084pl0.z(6, new C3933Cz());
        this.f = (C16966mA) c19084pl0.z(7, new C16966mA());
        this.g = (C3460Az) c19084pl0.z(8, new C3460Az());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 92;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C17557nA c17557nA = this.a;
        if (c17557nA == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c17557nA);
        c19675ql0.g(3, this.b);
        AbstractC24063xz abstractC24063xz = this.c;
        if (abstractC24063xz == null) {
            throw new IOException();
        }
        c19675ql0.b(4, abstractC24063xz.q());
        Integer num = this.d;
        if (num != null) {
            c19675ql0.f(5, num.intValue());
        }
        C3933Cz c3933Cz = this.e;
        if (c3933Cz != null) {
            c19675ql0.i(6, c3933Cz);
        }
        C16966mA c16966mA = this.f;
        if (c16966mA != null) {
            c19675ql0.i(7, c16966mA);
        }
        C3460Az c3460Az = this.g;
        if (c3460Az != null) {
            c19675ql0.i(8, c3460Az);
        }
    }

    public String toString() {
        return "rpc SendMessage{}";
    }

    public C16570lV5() {
    }
}
