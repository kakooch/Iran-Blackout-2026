package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.rw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20393rw extends AbstractC17902nl0 {
    private String a;
    private String b;
    private String c;

    public C20393rw(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.A(3);
    }

    public String q() {
        return this.b;
    }

    public String r() {
        return this.c;
    }

    public String s() {
        return this.a;
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
        if (str3 != null) {
            c19675ql0.o(3, str3);
        }
    }

    public String toString() {
        return "struct BotCommand{}";
    }

    public C20393rw() {
    }
}
