package ir.nasim;

/* renamed from: ir.nasim.vD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22424vD extends AbstractC17902nl0 {
    private long a;
    private EnumC18020nx b;
    private String c;
    private long d;
    private String e;
    private String f;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC18020nx.p(iH);
        }
        this.c = c19084pl0.A(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.A(5);
        this.f = c19084pl0.A(6);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        EnumC18020nx enumC18020nx = this.b;
        if (enumC18020nx != null) {
            c19675ql0.f(2, enumC18020nx.j());
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
        c19675ql0.g(4, this.d);
        String str2 = this.e;
        if (str2 != null) {
            c19675ql0.o(5, str2);
        }
        String str3 = this.f;
        if (str3 != null) {
            c19675ql0.o(6, str3);
        }
    }

    public String toString() {
        return "struct WalletInvoice{}";
    }
}
