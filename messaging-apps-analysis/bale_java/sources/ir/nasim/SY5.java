package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class SY5 extends AbstractC10365bX5 {
    private String b;

    public static SY5 s(byte[] bArr) {
        return (SY5) AbstractC16720ll0.b(new SY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.r(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
    }

    public String toString() {
        return "response GetPspPaymentToken{}";
    }
}
