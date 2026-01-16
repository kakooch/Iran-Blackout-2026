package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class HZ5 extends AbstractC10365bX5 {
    private List b;
    private String c;

    public static HZ5 s(byte[] bArr) {
        return (HZ5) AbstractC16720ll0.b(new HZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C16238kw());
        }
        this.b = c19084pl0.p(1, arrayList);
        this.c = c19084pl0.r(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.m(1, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
    }

    public String toString() {
        return "response InquiryBill{}";
    }
}
