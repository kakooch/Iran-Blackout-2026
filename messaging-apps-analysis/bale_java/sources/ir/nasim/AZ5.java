package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class AZ5 extends AbstractC10365bX5 {
    private long b;
    private long c;
    private String d;
    private List e;
    private String f;
    private EnumC4848Gv g;

    public static AZ5 s(byte[] bArr) {
        return (AZ5) AbstractC16720ll0.b(new AZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.c = c19084pl0.i(2);
        this.d = c19084pl0.r(3);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(4); i++) {
            arrayList.add(new C13292fz());
        }
        this.e = c19084pl0.p(4, arrayList);
        this.f = c19084pl0.r(5);
        int iH = c19084pl0.h(6, 0);
        if (iH != 0) {
            this.g = EnumC4848Gv.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.b);
        c19675ql0.g(2, this.c);
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        c19675ql0.m(4, this.e);
        String str2 = this.f;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str2);
        EnumC4848Gv enumC4848Gv = this.g;
        if (enumC4848Gv != null) {
            c19675ql0.f(6, enumC4848Gv.j());
        }
    }

    public String toString() {
        return "response GetWalletContracts{}";
    }
}
