package ir.nasim;

/* renamed from: ir.nasim.sy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21001sy extends AbstractC24063xz {
    private int a;
    private long b;
    private EnumC19802qy c;
    private String d;
    private String e;
    private int f;
    private Integer g;
    private Boolean h;

    public C21001sy(int i, long j, EnumC19802qy enumC19802qy, String str, String str2, int i2, Integer num, Boolean bool) {
        this.a = i;
        this.b = j;
        this.c = enumC19802qy;
        this.d = str;
        this.e = str2;
        this.f = i2;
        this.g = num;
        this.h = bool;
    }

    public Boolean C() {
        return this.h;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = EnumC19802qy.p(iH);
        }
        this.d = c19084pl0.A(4);
        this.e = c19084pl0.A(5);
        this.f = c19084pl0.g(6);
        this.g = Integer.valueOf(c19084pl0.x(7));
        this.h = Boolean.valueOf(c19084pl0.u(8));
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 62979;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        EnumC19802qy enumC19802qy = this.c;
        if (enumC19802qy != null) {
            c19675ql0.f(3, enumC19802qy.j());
        }
        String str = this.d;
        if (str != null) {
            c19675ql0.o(4, str);
        }
        String str2 = this.e;
        if (str2 != null) {
            c19675ql0.o(5, str2);
        }
        c19675ql0.f(6, this.f);
        Integer num = this.g;
        if (num != null) {
            c19675ql0.f(7, num.intValue());
        }
        Boolean bool = this.h;
        if (bool != null) {
            c19675ql0.a(8, bool.booleanValue());
        }
    }

    public String toString() {
        return "struct GiftPacketMessage{}";
    }

    public int u() {
        return this.a;
    }

    public EnumC19802qy w() {
        return this.c;
    }

    public String y() {
        return this.e;
    }

    public long z() {
        return this.b;
    }

    public C21001sy() {
    }
}
