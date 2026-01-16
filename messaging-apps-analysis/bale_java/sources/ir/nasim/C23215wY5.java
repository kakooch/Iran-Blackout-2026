package ir.nasim;

import java.io.IOException;
import java.util.List;

/* renamed from: ir.nasim.wY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23215wY5 extends AbstractC10365bX5 {
    private List b;
    private boolean c;
    private String d;

    public static C23215wY5 s(byte[] bArr) {
        return (C23215wY5) AbstractC16720ll0.b(new C23215wY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.q(1);
        this.c = c19084pl0.b(2);
        this.d = c19084pl0.r(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.n(1, this.b);
        c19675ql0.a(2, this.c);
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
    }

    public String toString() {
        return "response GetMySentence{}";
    }
}
