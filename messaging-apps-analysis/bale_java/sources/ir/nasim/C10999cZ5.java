package ir.nasim;

/* renamed from: ir.nasim.cZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10999cZ5 extends AbstractC10365bX5 {
    private Integer b;
    private long c;
    private boolean d;

    public static C10999cZ5 s(byte[] bArr) {
        return (C10999cZ5) AbstractC16720ll0.b(new C10999cZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = Integer.valueOf(c19084pl0.x(1));
        this.c = c19084pl0.i(2);
        this.d = c19084pl0.b(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Integer num = this.b;
        if (num != null) {
            c19675ql0.f(1, num.intValue());
        }
        c19675ql0.g(2, this.c);
        c19675ql0.a(3, this.d);
    }

    public String toString() {
        return "response GetReferringUser{}";
    }
}
