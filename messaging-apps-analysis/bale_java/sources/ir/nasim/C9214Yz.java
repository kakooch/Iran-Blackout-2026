package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Yz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9214Yz extends AbstractC19202px {
    private String a;
    private String b;
    private String c;
    private String d;

    public C9214Yz(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.r(4);
    }

    @Override // ir.nasim.AbstractC19202px
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        String str3 = this.c;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str3);
        String str4 = this.d;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str4);
    }

    public String toString() {
        return "struct OpenDialogAction{}";
    }

    public String u() {
        return this.c;
    }

    public String w() {
        return this.b;
    }

    public String y() {
        return this.d;
    }

    public String z() {
        return this.a;
    }

    public C9214Yz() {
    }
}
