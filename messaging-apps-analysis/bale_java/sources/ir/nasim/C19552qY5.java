package ir.nasim;

/* renamed from: ir.nasim.qY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19552qY5 extends AbstractC10365bX5 {
    private long b;
    private int c;
    private long d;
    private EnumC6786Oz e;

    public static C19552qY5 s(byte[] bArr) {
        return (C19552qY5) AbstractC16720ll0.b(new C19552qY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.c = c19084pl0.g(2);
        this.d = c19084pl0.i(3);
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.e = EnumC6786Oz.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.b);
        c19675ql0.f(2, this.c);
        c19675ql0.g(3, this.d);
        EnumC6786Oz enumC6786Oz = this.e;
        if (enumC6786Oz != null) {
            c19675ql0.f(4, enumC6786Oz.j());
        }
    }

    public String toString() {
        return "response GetMoneyRequestDetails{}";
    }
}
