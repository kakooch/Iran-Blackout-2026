package ir.nasim;

/* renamed from: ir.nasim.kY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16006kY5 extends AbstractC10365bX5 {
    private String b;
    private String c;
    private EnumC12656ez d;
    private long e;

    public static C16006kY5 s(byte[] bArr) {
        return (C16006kY5) AbstractC16720ll0.b(new C16006kY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.A(1);
        this.c = c19084pl0.A(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.d = EnumC12656ez.p(iH);
        }
        this.e = c19084pl0.i(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        String str = this.b;
        if (str != null) {
            c19675ql0.o(1, str);
        }
        String str2 = this.c;
        if (str2 != null) {
            c19675ql0.o(2, str2);
        }
        EnumC12656ez enumC12656ez = this.d;
        if (enumC12656ez != null) {
            c19675ql0.f(3, enumC12656ez.j());
        }
        c19675ql0.g(4, this.e);
    }

    public String toString() {
        return "response GetKifpoolOwner{}";
    }
}
