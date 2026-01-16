package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.dz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12065dz extends AbstractC17902nl0 {
    private boolean a;
    private String b;
    private long c;
    private String d;
    private int e;
    private String f;
    private String g;
    private C17429mx h;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.b(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.g(5);
        this.f = c19084pl0.A(6);
        this.g = c19084pl0.A(7);
        this.h = (C17429mx) c19084pl0.z(8, new C17429mx());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.a(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        c19675ql0.g(3, this.c);
        String str2 = this.d;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str2);
        c19675ql0.f(5, this.e);
        String str3 = this.f;
        if (str3 != null) {
            c19675ql0.o(6, str3);
        }
        String str4 = this.g;
        if (str4 != null) {
            c19675ql0.o(7, str4);
        }
        C17429mx c17429mx = this.h;
        if (c17429mx != null) {
            c19675ql0.i(8, c17429mx);
        }
    }

    public String toString() {
        return "struct Kifpool{}";
    }
}
