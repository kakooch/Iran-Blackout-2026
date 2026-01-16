package ir.nasim;

/* loaded from: classes4.dex */
public class H06 extends AbstractC10365bX5 {
    private boolean b;

    public H06(boolean z) {
        this.b = z;
    }

    public static H06 s(byte[] bArr) {
        return (H06) AbstractC16720ll0.b(new H06(), bArr);
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
        return "response UpdateView{}";
    }

    public H06() {
    }
}
