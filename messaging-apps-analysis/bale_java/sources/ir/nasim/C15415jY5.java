package ir.nasim;

/* renamed from: ir.nasim.jY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15415jY5 extends AbstractC10365bX5 {
    private String b;

    public static C15415jY5 s(byte[] bArr) {
        return (C15415jY5) AbstractC16720ll0.b(new C15415jY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.A(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        String str = this.b;
        if (str != null) {
            c19675ql0.o(1, str);
        }
    }

    public String toString() {
        return "response GetJWTToken{}";
    }
}
