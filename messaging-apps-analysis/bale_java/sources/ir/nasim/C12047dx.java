package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.dx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12047dx extends AbstractC17902nl0 {
    private String a;
    private int b;
    private boolean c;
    private int d;
    private String e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.b(3);
        this.d = c19084pl0.g(4);
        this.e = c19084pl0.r(5);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.f(2, this.b);
        c19675ql0.a(3, this.c);
        c19675ql0.f(4, this.d);
        String str2 = this.e;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str2);
    }

    public String toString() {
        return "struct Competitor{}";
    }
}
