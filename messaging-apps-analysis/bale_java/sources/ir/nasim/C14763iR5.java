package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.iR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14763iR5 extends TP5 {
    private String a;
    private String b;

    public static C14763iR5 r(byte[] bArr) {
        return (C14763iR5) AbstractC16720ll0.b(new C14763iR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.A(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 128;
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
    }

    public String toString() {
        return "rpc EditParameter{}";
    }
}
