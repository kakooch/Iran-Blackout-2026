package ir.nasim;

/* loaded from: classes4.dex */
public class KX5 extends AbstractC10365bX5 {
    private C5784Kv b;

    public static KX5 s(byte[] bArr) {
        return (KX5) AbstractC16720ll0.b(new KX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C5784Kv) c19084pl0.z(1, new C5784Kv());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C5784Kv c5784Kv = this.b;
        if (c5784Kv != null) {
            c19675ql0.i(1, c5784Kv);
        }
    }

    public String toString() {
        return "response GetBotWhiteList{}";
    }

    public C5784Kv u() {
        return this.b;
    }
}
