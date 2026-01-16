package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.zz6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C25254zz6 extends AbstractC17902nl0 implements HB3 {
    private C11458d25 a;
    private String b;
    private int c;
    private ExPeerType d;
    private long e;
    private Long f;
    private Boolean g;

    public C25254zz6(C11458d25 c11458d25, String str, int i, long j, ExPeerType exPeerType, Long l, Boolean bool) {
        this.g = Boolean.FALSE;
        this.a = c11458d25;
        this.b = str;
        this.c = i;
        this.e = j;
        this.d = exPeerType;
        this.f = l;
        this.g = Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public static C25254zz6 q(byte[] bArr) {
        return (C25254zz6) AbstractC16720ll0.b(new C25254zz6(), bArr);
    }

    @Override // ir.nasim.HB3
    public long a() {
        return this.a.u();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((C25254zz6) obj).a);
    }

    public ExPeerType getExPeerType() {
        return this.d;
    }

    public long h() {
        return this.e;
    }

    @Override // ir.nasim.HB3
    public long j() {
        return this.a.u();
    }

    @Override // ir.nasim.HB3
    public String p() {
        return null;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = C11458d25.q(c19084pl0.d(1));
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(4);
        this.d = ExPeerType.fromValue(c19084pl0.x(5));
        this.e = c19084pl0.y(7);
        this.f = Long.valueOf(c19084pl0.y(8));
        this.g = Boolean.valueOf(c19084pl0.c(9, false));
    }

    public int r() {
        return this.c;
    }

    public Long s() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.b(1, this.a.toByteArray());
        c19675ql0.o(2, this.b);
        c19675ql0.f(4, this.c);
        ExPeerType exPeerType = this.d;
        if (exPeerType != null) {
            c19675ql0.f(5, exPeerType.getValue());
        }
        c19675ql0.g(7, this.e);
        Long l = this.f;
        if (l != null) {
            c19675ql0.g(8, l.longValue());
        }
        c19675ql0.a(9, this.g.booleanValue());
    }

    public Boolean u() {
        return this.g;
    }

    public C11458d25 w() {
        return this.a;
    }

    public String y() {
        return this.b;
    }

    public boolean z() {
        return this.f.longValue() < this.e;
    }

    public C25254zz6() {
        this.g = Boolean.FALSE;
    }

    public C25254zz6(C17067mL1 c17067mL1) {
        this(c17067mL1.R(), c17067mL1.J(), c17067mL1.Y(), c17067mL1.Q().h(), c17067mL1.getExPeerType(), c17067mL1.N(), null);
    }
}
