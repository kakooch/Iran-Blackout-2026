package ir.nasim;

/* loaded from: classes4.dex */
public class O06 extends AbstractC10365bX5 {
    private Long b;
    private String c;
    private String d;

    public static O06 s(byte[] bArr) {
        return (O06) AbstractC16720ll0.b(new O06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = Long.valueOf(c19084pl0.y(1));
        this.c = c19084pl0.A(2);
        this.d = c19084pl0.A(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Long l = this.b;
        if (l != null) {
            c19675ql0.g(1, l.longValue());
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(2, str);
        }
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(3, str2);
        }
    }

    public String toString() {
        return "response VerifyPurchaseMessage{}";
    }
}
