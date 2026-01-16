package ir.nasim;

/* renamed from: ir.nasim.z06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24670z06 extends AbstractC10365bX5 {
    private AD b;

    public static C24670z06 s(byte[] bArr) {
        return (C24670z06) AbstractC16720ll0.b(new C24670z06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (AD) c19084pl0.z(1, new AD());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AD ad = this.b;
        if (ad != null) {
            c19675ql0.i(1, ad);
        }
    }

    public String toString() {
        return "response SpinWheel{}";
    }
}
