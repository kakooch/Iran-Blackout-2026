package ir.nasim;

/* renamed from: ir.nasim.iX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14817iX5 extends AbstractC10365bX5 {
    private OC b;
    private C4374Ew c;

    public static C14817iX5 s(byte[] bArr) {
        return (C14817iX5) AbstractC16720ll0.b(new C14817iX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (OC) c19084pl0.z(1, new OC());
        this.c = (C4374Ew) c19084pl0.z(2, new C4374Ew());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        OC oc = this.b;
        if (oc != null) {
            c19675ql0.i(1, oc);
        }
        C4374Ew c4374Ew = this.c;
        if (c4374Ew != null) {
            c19675ql0.i(2, c4374Ew);
        }
    }

    public String toString() {
        return "response BuyCharge{}";
    }
}
