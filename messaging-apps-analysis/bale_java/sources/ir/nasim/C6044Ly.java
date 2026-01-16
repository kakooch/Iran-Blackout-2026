package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Ly, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6044Ly extends AbstractC17902nl0 {
    private long a;
    private String b;
    private int c;
    private int d;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.g(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        c19675ql0.f(3, this.c);
        c19675ql0.f(4, this.d);
    }

    public String toString() {
        return "struct InternetBundle{}";
    }
}
