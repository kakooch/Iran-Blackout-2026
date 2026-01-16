package ir.nasim;

import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Be1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C3512Be1 extends AbstractC17902nl0 implements HB3 {
    public static final InterfaceC17311ml0 f = new a();
    private int a;
    private long b;
    private Avatar c;
    private String d;
    private boolean e;

    /* renamed from: ir.nasim.Be1$a */
    class a implements InterfaceC17311ml0 {
        a() {
        }

        @Override // ir.nasim.InterfaceC17311ml0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3512Be1 a() {
            return new C3512Be1();
        }
    }

    @Override // ir.nasim.HB3
    public long a() {
        return this.a;
    }

    public String getName() {
        return this.d;
    }

    @Override // ir.nasim.HB3
    public long j() {
        return this.b;
    }

    @Override // ir.nasim.HB3
    public String p() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.d = c19084pl0.r(3);
        if (c19084pl0.v(4) != null) {
            this.c = new Avatar(c19084pl0.d(4));
        }
        this.e = c19084pl0.u(5);
    }

    public Avatar q() {
        return this.c;
    }

    public int r() {
        return this.a;
    }

    public boolean s() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.o(3, this.d);
        Avatar avatar = this.c;
        if (avatar != null) {
            c19675ql0.i(4, avatar);
        }
        c19675ql0.a(5, this.e);
    }

    public C3512Be1(int i, long j, Avatar avatar, String str, boolean z) {
        this.a = i;
        this.b = j;
        this.c = avatar;
        this.d = str;
        this.e = z;
    }

    private C3512Be1() {
    }
}
