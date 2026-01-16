package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Py, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7021Py extends AbstractC17902nl0 {
    private String a;
    private C12056dy b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private C11413cy h;

    public C7021Py(String str, C12056dy c12056dy, int i, int i2, int i3, String str2, String str3, C11413cy c11413cy) {
        this.a = str;
        this.b = c12056dy;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = str2;
        this.g = str3;
        this.h = c11413cy;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.A(1);
        this.b = (C12056dy) c19084pl0.z(2, new C12056dy());
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.g(4);
        this.e = c19084pl0.g(5);
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.r(7);
        this.h = (C11413cy) c19084pl0.z(8, new C11413cy());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str != null) {
            c19675ql0.o(1, str);
        }
        C12056dy c12056dy = this.b;
        if (c12056dy != null) {
            c19675ql0.i(2, c12056dy);
        }
        c19675ql0.f(3, this.c);
        c19675ql0.f(4, this.d);
        c19675ql0.f(5, this.e);
        String str2 = this.f;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str2);
        String str3 = this.g;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str3);
        C11413cy c11413cy = this.h;
        if (c11413cy != null) {
            c19675ql0.i(8, c11413cy);
        }
    }

    public String toString() {
        return "struct Intro{}";
    }

    public C7021Py() {
    }
}
