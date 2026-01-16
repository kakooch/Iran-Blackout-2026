package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.gR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13561gR5 extends TP5 {
    private String a;

    public static C13561gR5 r(byte[] bArr) {
        return (C13561gR5) AbstractC16720ll0.b(new C13561gR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 53;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
    }

    public String toString() {
        return "rpc EditName{}";
    }
}
