package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Nv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6511Nv extends AbstractC17902nl0 {
    private int a;
    private EnumC6017Lv b;
    private int c;
    private String d;
    private String e;
    private int f;
    private String g;
    private Double h;
    private Double i;
    private Long j;
    private OC k;

    public C6511Nv(int i, EnumC6017Lv enumC6017Lv, int i2, String str, String str2, int i3, String str3, Double d, Double d2, Long l, OC oc) {
        this.a = i;
        this.b = enumC6017Lv;
        this.c = i2;
        this.d = str;
        this.e = str2;
        this.f = i3;
        this.g = str3;
        this.h = d;
        this.i = d2;
        this.j = l;
        this.k = oc;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC6017Lv.p(iH);
        }
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.g(6);
        this.g = c19084pl0.r(7);
        this.h = Double.valueOf(c19084pl0.w(8));
        this.i = Double.valueOf(c19084pl0.w(9));
        this.j = Long.valueOf(c19084pl0.y(10));
        this.k = (OC) c19084pl0.z(11, new OC());
    }

    public String q() {
        return this.d;
    }

    public EnumC6017Lv r() {
        return this.b;
    }

    public int s() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        EnumC6017Lv enumC6017Lv = this.b;
        if (enumC6017Lv != null) {
            c19675ql0.f(2, enumC6017Lv.j());
        }
        c19675ql0.f(3, this.c);
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str);
        String str2 = this.e;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str2);
        c19675ql0.f(6, this.f);
        String str3 = this.g;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str3);
        Double d = this.h;
        if (d != null) {
            c19675ql0.e(8, d.doubleValue());
        }
        Double d2 = this.i;
        if (d2 != null) {
            c19675ql0.e(9, d2.doubleValue());
        }
        Long l = this.j;
        if (l != null) {
            c19675ql0.g(10, l.longValue());
        }
        OC oc = this.k;
        if (oc != null) {
            c19675ql0.i(11, oc);
        }
    }

    public String toString() {
        return "struct AuthSession{}";
    }

    public String u() {
        return this.e;
    }

    public int w() {
        return this.a;
    }

    public C6511Nv() {
    }
}
