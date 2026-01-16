package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.mx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17429mx extends AbstractC17902nl0 {
    private String a;
    private long b;
    private String c;
    private SA d;
    private boolean e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = SA.p(iH);
        }
        this.e = c19084pl0.b(5);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.g(2, this.b);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
        SA sa = this.d;
        if (sa != null) {
            c19675ql0.f(4, sa.j());
        }
        c19675ql0.a(5, this.e);
    }

    public String toString() {
        return "struct CryptoPocket{}";
    }
}
