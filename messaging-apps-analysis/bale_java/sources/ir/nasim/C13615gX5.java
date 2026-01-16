package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.gX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13615gX5 extends AbstractC10365bX5 {
    private boolean b;
    private String c;

    public static C13615gX5 s(byte[] bArr) {
        return (C13615gX5) AbstractC16720ll0.b(new C13615gX5(), bArr);
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
        return "response AuthorizeUser{}";
    }
}
