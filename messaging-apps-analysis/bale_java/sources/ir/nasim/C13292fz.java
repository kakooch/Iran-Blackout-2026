package ir.nasim;

/* renamed from: ir.nasim.fz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13292fz extends AbstractC17902nl0 {
    private Long a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Long f;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Long.valueOf(c19084pl0.y(1));
        this.b = c19084pl0.A(2);
        this.c = c19084pl0.A(3);
        this.d = c19084pl0.A(4);
        this.e = c19084pl0.A(5);
        this.f = Long.valueOf(c19084pl0.y(6));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Long l = this.a;
        if (l != null) {
            c19675ql0.g(1, l.longValue());
        }
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
        }
        String str2 = this.c;
        if (str2 != null) {
            c19675ql0.o(3, str2);
        }
        String str3 = this.d;
        if (str3 != null) {
            c19675ql0.o(4, str3);
        }
        String str4 = this.e;
        if (str4 != null) {
            c19675ql0.o(5, str4);
        }
        Long l2 = this.f;
        if (l2 != null) {
            c19675ql0.g(6, l2.longValue());
        }
    }

    public String toString() {
        return "struct Limitation{}";
    }
}
