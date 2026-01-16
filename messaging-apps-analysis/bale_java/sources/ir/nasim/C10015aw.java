package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.aw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10015aw extends AbstractC17902nl0 {
    private String a;
    private int b;
    private long c;
    private int d;
    private long e;
    private long f;
    private String g;
    private String h;

    public C10015aw(String str, int i, long j, int i2, long j2, long j3, String str2, String str3) {
        this.a = str;
        this.b = i;
        this.c = j;
        this.d = i2;
        this.e = j2;
        this.f = j3;
        this.g = str2;
        this.h = str3;
    }

    public int C() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.g(4);
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.i(6);
        this.g = c19084pl0.r(7);
        this.h = c19084pl0.r(8);
    }

    public String q() {
        return this.a;
    }

    public long r() {
        return this.e;
    }

    public int s() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.f(2, this.b);
        c19675ql0.g(3, this.c);
        c19675ql0.f(4, this.d);
        c19675ql0.g(5, this.e);
        c19675ql0.g(6, this.f);
        String str2 = this.g;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str2);
        String str3 = this.h;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(8, str3);
    }

    public String toString() {
        return "struct BankAccount{}";
    }

    public String u() {
        return this.g;
    }

    public long w() {
        return this.f;
    }

    public String y() {
        return this.h;
    }

    public long z() {
        return this.c;
    }

    public C10015aw() {
    }
}
