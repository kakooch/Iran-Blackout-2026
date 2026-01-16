package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Gy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4875Gy extends AbstractC17902nl0 {
    private String a;
    private String b;
    private String c;
    private C23610xD d;
    private C19220pz e;
    private String f;
    private String g;
    private QC h;
    private C15656jx i;
    private C6750Ov j;
    private C18611ox k;
    private Boolean l;

    public C4875Gy(String str, String str2, String str3, C23610xD c23610xD, C19220pz c19220pz, String str4, String str5, QC qc, C15656jx c15656jx, C6750Ov c6750Ov, C18611ox c18611ox, Boolean bool) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = c23610xD;
        this.e = c19220pz;
        this.f = str4;
        this.g = str5;
        this.h = qc;
        this.i = c15656jx;
        this.j = c6750Ov;
        this.k = c18611ox;
        this.l = bool;
    }

    public Boolean C() {
        return this.l;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.A(2);
        this.c = c19084pl0.A(3);
        this.d = (C23610xD) c19084pl0.z(4, new C23610xD());
        this.e = (C19220pz) c19084pl0.z(5, new C19220pz());
        this.f = c19084pl0.A(6);
        this.g = c19084pl0.A(7);
        this.h = (QC) c19084pl0.z(8, new QC());
        this.i = (C15656jx) c19084pl0.z(9, new C15656jx());
        this.j = (C6750Ov) c19084pl0.z(10, new C6750Ov());
        this.k = (C18611ox) c19084pl0.z(11, new C18611ox());
        this.l = Boolean.valueOf(c19084pl0.u(12));
    }

    public C6750Ov q() {
        return this.j;
    }

    public String r() {
        return this.c;
    }

    public C15656jx s() {
        return this.i;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 != null) {
            c19675ql0.o(2, str2);
        }
        String str3 = this.c;
        if (str3 != null) {
            c19675ql0.o(3, str3);
        }
        C23610xD c23610xD = this.d;
        if (c23610xD != null) {
            c19675ql0.i(4, c23610xD);
        }
        C19220pz c19220pz = this.e;
        if (c19220pz != null) {
            c19675ql0.i(5, c19220pz);
        }
        String str4 = this.f;
        if (str4 != null) {
            c19675ql0.o(6, str4);
        }
        String str5 = this.g;
        if (str5 != null) {
            c19675ql0.o(7, str5);
        }
        QC qc = this.h;
        if (qc != null) {
            c19675ql0.i(8, qc);
        }
        C15656jx c15656jx = this.i;
        if (c15656jx != null) {
            c19675ql0.i(9, c15656jx);
        }
        C6750Ov c6750Ov = this.j;
        if (c6750Ov != null) {
            c19675ql0.i(10, c6750Ov);
        }
        C18611ox c18611ox = this.k;
        if (c18611ox != null) {
            c19675ql0.i(11, c18611ox);
        }
        Boolean bool = this.l;
        if (bool != null) {
            c19675ql0.a(12, bool.booleanValue());
        }
    }

    public String toString() {
        return "struct InlineKeyboardButton{}";
    }

    public C18611ox u() {
        return this.k;
    }

    public String w() {
        return this.a;
    }

    public String y() {
        return this.b;
    }

    public C23610xD z() {
        return this.d;
    }

    public C4875Gy() {
    }
}
