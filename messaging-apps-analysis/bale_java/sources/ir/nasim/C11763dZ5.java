package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.dZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11763dZ5 extends AbstractC10365bX5 {
    private String b;
    private String c;

    public static C11763dZ5 s(byte[] bArr) {
        return (C11763dZ5) AbstractC16720ll0.b(new C11763dZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.r(1);
        this.c = c19084pl0.r(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
    }

    public String toString() {
        return "response GetRemainToken{}";
    }
}
