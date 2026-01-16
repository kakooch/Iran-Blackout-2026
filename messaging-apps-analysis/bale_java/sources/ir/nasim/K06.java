package ir.nasim;

/* loaded from: classes4.dex */
public class K06 extends AbstractC10365bX5 {
    private boolean b;

    public static K06 s(byte[] bArr) {
        return (K06) AbstractC16720ll0.b(new K06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.b(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.b);
    }

    public String toString() {
        return "response ValidateMySentence{}";
    }
}
