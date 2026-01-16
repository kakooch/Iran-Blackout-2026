package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class DZ5 extends AbstractC10365bX5 {
    private int b;
    private String c;
    private List d;

    public static DZ5 s(byte[] bArr) {
        return (DZ5) AbstractC16720ll0.b(new DZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
        this.c = c19084pl0.r(2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(3); i++) {
            arrayList.add(new AD());
        }
        this.d = c19084pl0.p(3, arrayList);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        c19675ql0.m(3, this.d);
    }

    public String toString() {
        return "response GetWheel{}";
    }
}
