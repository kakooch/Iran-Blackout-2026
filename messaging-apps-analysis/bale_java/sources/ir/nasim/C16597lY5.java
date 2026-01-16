package ir.nasim;

/* renamed from: ir.nasim.lY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16597lY5 extends AbstractC10365bX5 {
    private C13883gz b;

    public static C16597lY5 s(byte[] bArr) {
        return (C16597lY5) AbstractC16720ll0.b(new C16597lY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C13883gz) c19084pl0.z(1, new C13883gz());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C13883gz c13883gz = this.b;
        if (c13883gz != null) {
            c19675ql0.i(1, c13883gz);
        }
    }

    public String toString() {
        return "response GetLinkPreview{}";
    }
}
