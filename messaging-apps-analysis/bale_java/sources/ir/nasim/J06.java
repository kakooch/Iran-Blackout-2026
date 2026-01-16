package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class J06 extends AbstractC10365bX5 {
    private boolean b;
    private String c;

    public static J06 s(byte[] bArr) {
        return (J06) AbstractC16720ll0.b(new J06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.b(1);
        this.c = c19084pl0.r(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.a(1, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
    }

    public String toString() {
        return "response UserHasCred{}";
    }
}
