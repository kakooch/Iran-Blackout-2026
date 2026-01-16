package ir.nasim;

/* loaded from: classes4.dex */
public class BY5 extends AbstractC10365bX5 {
    private C12647ey b;

    public static BY5 s(byte[] bArr) {
        return (BY5) AbstractC16720ll0.b(new BY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C12647ey) c19084pl0.z(1, new C12647ey());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C12647ey c12647ey = this.b;
        if (c12647ey != null) {
            c19675ql0.i(1, c12647ey);
        }
    }

    public String toString() {
        return "response GetNasimFileUrl{}";
    }
}
