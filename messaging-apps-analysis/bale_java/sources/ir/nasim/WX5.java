package ir.nasim;

/* loaded from: classes4.dex */
public class WX5 extends AbstractC10365bX5 {
    private OC b;

    public static WX5 s(byte[] bArr) {
        return (WX5) AbstractC16720ll0.b(new WX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (OC) c19084pl0.z(1, new OC());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        OC oc = this.b;
        if (oc != null) {
            c19675ql0.i(1, oc);
        }
    }

    public String toString() {
        return "response GetDefaultCard{}";
    }
}
