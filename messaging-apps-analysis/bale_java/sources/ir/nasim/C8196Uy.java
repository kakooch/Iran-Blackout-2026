package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Uy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C8196Uy extends AbstractC17902nl0 {
    private long a;
    private EnumC13429gD b;
    private String c;
    private long d;
    private long e;
    private long f;
    private String g;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC13429gD.p(iH);
        }
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.i(6);
        this.g = c19084pl0.r(7);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        EnumC13429gD enumC13429gD = this.b;
        if (enumC13429gD != null) {
            c19675ql0.f(2, enumC13429gD.j());
        }
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        c19675ql0.g(4, this.d);
        c19675ql0.g(5, this.e);
        c19675ql0.g(6, this.f);
        String str2 = this.g;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str2);
    }

    public String toString() {
        return "struct InvoiceRecord{}";
    }
}
