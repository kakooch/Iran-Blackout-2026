package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class EZ5 extends AbstractC10365bX5 {
    private List b;
    private int c;
    private byte[] d;
    private List e;

    public static EZ5 s(byte[] bArr) {
        return (EZ5) AbstractC16720ll0.b(new EZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C15811kD());
        }
        this.b = c19084pl0.p(1, arrayList);
        this.c = c19084pl0.g(2);
        this.d = c19084pl0.d(3);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(4); i2++) {
            arrayList2.add(new C18766pD());
        }
        this.e = c19084pl0.p(4, arrayList2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.m(1, this.b);
        c19675ql0.f(2, this.c);
        byte[] bArr = this.d;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(3, bArr);
        c19675ql0.m(4, this.e);
    }

    public String toString() {
        return "response ImportContacts{}";
    }
}
