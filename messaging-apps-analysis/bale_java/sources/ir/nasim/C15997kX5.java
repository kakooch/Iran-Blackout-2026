package ir.nasim;

/* renamed from: ir.nasim.kX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15997kX5 extends AbstractC10365bX5 {
    private OC b;
    private C4608Fw c;

    public static C15997kX5 s(byte[] bArr) {
        return (C15997kX5) AbstractC16720ll0.b(new C15997kX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (OC) c19084pl0.z(1, new OC());
        this.c = (C4608Fw) c19084pl0.z(2, new C4608Fw());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        OC oc = this.b;
        if (oc != null) {
            c19675ql0.i(1, oc);
        }
        C4608Fw c4608Fw = this.c;
        if (c4608Fw != null) {
            c19675ql0.i(2, c4608Fw);
        }
    }

    public String toString() {
        return "response BuyInternetBundle{}";
    }
}
