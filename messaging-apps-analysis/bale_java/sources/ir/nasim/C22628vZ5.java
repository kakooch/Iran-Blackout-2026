package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.vZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22628vZ5 extends AbstractC10365bX5 {
    private String b;

    public static C22628vZ5 s(byte[] bArr) {
        return (C22628vZ5) AbstractC16720ll0.b(new C22628vZ5(), bArr);
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
        return "response GetUserVitrine{}";
    }
}
