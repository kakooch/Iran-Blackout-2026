package ir.nasim;

/* renamed from: ir.nasim.vz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22883vz extends AbstractC17902nl0 {
    private int a;
    private int b;
    private long c;
    private Boolean d;
    private Integer e;
    private Long f;
    private DA g;
    private String h;

    public C22883vz(int i, int i2, long j, Boolean bool, Integer num, Long l, DA da, String str) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bool;
        this.e = num;
        this.f = l;
        this.g = da;
        this.h = str;
    }

    public long h() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.i(3);
        this.d = Boolean.valueOf(c19084pl0.u(4));
        this.e = Integer.valueOf(c19084pl0.x(5));
        this.f = Long.valueOf(c19084pl0.y(6));
        this.g = (DA) c19084pl0.z(7, new DA());
        this.h = c19084pl0.A(8);
    }

    public int q() {
        return this.b;
    }

    public DA r() {
        return this.g;
    }

    public Long s() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
        c19675ql0.g(3, this.c);
        Boolean bool = this.d;
        if (bool != null) {
            c19675ql0.a(4, bool.booleanValue());
        }
        Integer num = this.e;
        if (num != null) {
            c19675ql0.f(5, num.intValue());
        }
        Long l = this.f;
        if (l != null) {
            c19675ql0.g(6, l.longValue());
        }
        DA da = this.g;
        if (da != null) {
            c19675ql0.i(7, da);
        }
        String str = this.h;
        if (str != null) {
            c19675ql0.o(8, str);
        }
    }

    public String toString() {
        return "struct Member{}";
    }

    public Integer u() {
        return this.e;
    }

    public String w() {
        return this.h;
    }

    public int y() {
        return this.a;
    }

    public Boolean z() {
        return this.d;
    }

    public C22883vz() {
    }
}
