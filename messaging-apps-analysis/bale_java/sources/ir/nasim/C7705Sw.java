package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Sw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7705Sw extends AbstractC17902nl0 {
    private String a;
    private long b;
    private String c;
    private String d;
    private long e;
    private String f;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.A(6);
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
        String str3 = this.d;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str3);
        c19675ql0.g(5, this.e);
        String str4 = this.f;
        if (str4 != null) {
            c19675ql0.o(6, str4);
        }
    }

    public String toString() {
        return "struct ClubVoucher{}";
    }
}
