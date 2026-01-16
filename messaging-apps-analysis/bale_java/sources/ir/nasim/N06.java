package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class N06 extends AbstractC10365bX5 {
    private String b;
    private Integer c;
    private String d;

    public static N06 s(byte[] bArr) {
        return (N06) AbstractC16720ll0.b(new N06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.r(1);
        this.c = Integer.valueOf(c19084pl0.x(2));
        this.d = c19084pl0.r(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        Integer num = this.c;
        if (num != null) {
            c19675ql0.f(2, num.intValue());
        }
        String str2 = this.d;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
    }

    public String toString() {
        return "response VerifyPeer{}";
    }
}
