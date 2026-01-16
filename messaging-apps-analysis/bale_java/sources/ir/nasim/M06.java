package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class M06 extends AbstractC10365bX5 {
    private String b;
    private String c;
    private String d;

    public static M06 s(byte[] bArr) {
        return (M06) AbstractC16720ll0.b(new M06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.r(1);
        this.c = c19084pl0.A(2);
        this.d = c19084pl0.A(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.c;
        if (str2 != null) {
            c19675ql0.o(2, str2);
        }
        String str3 = this.d;
        if (str3 != null) {
            c19675ql0.o(3, str3);
        }
    }

    public String toString() {
        return "response VerifyCashOutKifpool{}";
    }
}
