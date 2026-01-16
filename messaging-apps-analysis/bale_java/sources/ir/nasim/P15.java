package ir.nasim;

/* loaded from: classes5.dex */
public class P15 extends AbstractC17902nl0 implements HB3 {
    public static final InterfaceC17311ml0 i = new a();
    private Long a;
    private Long b;
    private Long c;
    private Long d;
    private Long e;
    private Long f;
    private Integer g;
    private EnumC6786Oz h;

    class a implements InterfaceC17311ml0 {
        a() {
        }

        @Override // ir.nasim.InterfaceC17311ml0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public P15 a() {
            return new P15();
        }
    }

    public P15() {
    }

    @Override // ir.nasim.HB3
    public long a() {
        return this.a.longValue();
    }

    @Override // ir.nasim.HB3
    public long j() {
        return this.f.longValue();
    }

    @Override // ir.nasim.HB3
    public String p() {
        return this.d.toString();
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Long.valueOf(c19084pl0.i(1));
        this.b = Long.valueOf(c19084pl0.i(2));
        this.c = Long.valueOf(c19084pl0.i(3));
        this.d = Long.valueOf(c19084pl0.i(4));
        this.e = Long.valueOf(c19084pl0.i(5));
        this.f = Long.valueOf(c19084pl0.i(6));
        this.g = Integer.valueOf(c19084pl0.g(7));
        this.h = EnumC6786Oz.p(c19084pl0.g(8));
    }

    public Long q() {
        return this.e;
    }

    public Long r() {
        return this.f;
    }

    public Integer s() {
        return this.g;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a.longValue());
        c19675ql0.g(2, this.b.longValue());
        c19675ql0.g(3, this.c.longValue());
        c19675ql0.g(4, this.d.longValue());
        c19675ql0.g(5, this.e.longValue());
        c19675ql0.g(6, this.f.longValue());
        c19675ql0.f(7, this.g.intValue());
        c19675ql0.f(8, this.h.j());
    }

    public Long u() {
        return this.c;
    }

    public Long w() {
        return this.b;
    }

    public Long y() {
        return this.d;
    }

    public EnumC6786Oz z() {
        return this.h;
    }

    public P15(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Integer num, EnumC6786Oz enumC6786Oz) {
        this.a = l;
        this.b = l2;
        this.c = l3;
        this.d = l4;
        this.e = l5;
        this.f = l6;
        this.g = num;
        this.h = enumC6786Oz;
    }
}
