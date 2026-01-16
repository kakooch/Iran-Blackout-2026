package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public final class IG6 implements InterfaceC7645Sp2 {
    private final LG6 a;
    private final InterfaceC10163bB1 b;
    private final InterfaceC5766Kt c;
    private final InterfaceC15796kB2 d;
    private final UA2 e;
    private final InterfaceC9102Ym4 f;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        float d;
        /* synthetic */ Object e;
        int g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return IG6.this.l(null, 0, 0.0f, this);
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return IG6.this.n(null, null, 0, 0.0f, false, this);
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C10873cL5 e;
        final /* synthetic */ InterfaceC8748Xd6 f;
        final /* synthetic */ C10873cL5 g;
        final /* synthetic */ IG6 h;
        final /* synthetic */ boolean i;
        final /* synthetic */ int j;

        /* synthetic */ class a extends EB2 implements UA2 {
            a(Object obj) {
                super(1, obj, InterfaceC8748Xd6.class, "scrollBy", "scrollBy(F)F", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return y(((Number) obj).floatValue());
            }

            public final Float y(float f) {
                return Float.valueOf(((InterfaceC8748Xd6) this.receiver).e(f));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C10873cL5 c10873cL5, InterfaceC8748Xd6 interfaceC8748Xd6, C10873cL5 c10873cL52, IG6 ig6, boolean z, int i) {
            super(1);
            this.e = c10873cL5;
            this.f = interfaceC8748Xd6;
            this.g = c10873cL52;
            this.h = ig6;
            this.i = z;
            this.j = i;
        }

        public final void a(C5064Ht c5064Ht) {
            AbstractC13042fc3.i(c5064Ht, "$this$animateDecay");
            float fFloatValue = ((Number) c5064Ht.e()).floatValue() - this.e.a;
            float fE = this.f.e(fFloatValue);
            this.e.a = ((Number) c5064Ht.e()).floatValue();
            this.g.a = ((Number) c5064Ht.f()).floatValue();
            if (Math.abs(fFloatValue - fE) > 0.5f) {
                c5064Ht.a();
            }
            MG6 mg6E = this.h.a.e();
            if (mg6E == null) {
                c5064Ht.a();
                return;
            }
            if (c5064Ht.h() && this.i) {
                if (((Number) c5064Ht.f()).floatValue() > 0.0f && mg6E.a() == this.j - 1) {
                    c5064Ht.a();
                } else if (((Number) c5064Ht.f()).floatValue() < 0.0f && mg6E.a() == this.j) {
                    c5064Ht.a();
                }
            }
            if (c5064Ht.h() && this.h.p(c5064Ht, mg6E, this.j, new a(this.f))) {
                c5064Ht.a();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return IG6.this.q(null, null, 0, 0.0f, this);
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C10873cL5 e;
        final /* synthetic */ InterfaceC8748Xd6 f;
        final /* synthetic */ C10873cL5 g;
        final /* synthetic */ IG6 h;
        final /* synthetic */ int i;

        /* synthetic */ class a extends EB2 implements UA2 {
            a(Object obj) {
                super(1, obj, InterfaceC8748Xd6.class, "scrollBy", "scrollBy(F)F", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return y(((Number) obj).floatValue());
            }

            public final Float y(float f) {
                return Float.valueOf(((InterfaceC8748Xd6) this.receiver).e(f));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C10873cL5 c10873cL5, InterfaceC8748Xd6 interfaceC8748Xd6, C10873cL5 c10873cL52, IG6 ig6, int i) {
            super(1);
            this.e = c10873cL5;
            this.f = interfaceC8748Xd6;
            this.g = c10873cL52;
            this.h = ig6;
            this.i = i;
        }

        public final void a(C5064Ht c5064Ht) {
            AbstractC13042fc3.i(c5064Ht, "$this$animateTo");
            float fFloatValue = ((Number) c5064Ht.e()).floatValue() - this.e.a;
            float fE = this.f.e(fFloatValue);
            this.e.a = ((Number) c5064Ht.e()).floatValue();
            this.g.a = ((Number) c5064Ht.f()).floatValue();
            MG6 mg6E = this.h.a.e();
            if (mg6E == null) {
                c5064Ht.a();
            } else if (this.h.p(c5064Ht, mg6E, this.i, new a(this.f))) {
                c5064Ht.a();
            } else if (Math.abs(fFloatValue - fE) > 0.5f) {
                c5064Ht.a();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }
    }

    private IG6(LG6 lg6, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2) {
        this.a = lg6;
        this.b = interfaceC10163bB1;
        this.c = interfaceC5766Kt;
        this.d = interfaceC15796kB2;
        this.e = ua2;
        this.f = AbstractC13472gH6.d(null, null, 2, null);
    }

    private final int i(float f, MG6 mg6, int i) {
        if (f > 0.0f && mg6.a() >= i) {
            return this.a.d(mg6.a());
        }
        if (f >= 0.0f || mg6.a() > i - 1) {
            return 0;
        }
        return this.a.d(mg6.a() + 1);
    }

    private final boolean j(InterfaceC10163bB1 interfaceC10163bB1, float f, MG6 mg6) {
        if (Math.abs(f) < 0.5f) {
            return false;
        }
        float fA = AbstractC11543dB1.a(interfaceC10163bB1, 0.0f, f);
        NG6 ng6 = NG6.a;
        if (f < 0.0f) {
            if (fA > this.a.d(mg6.a())) {
                return false;
            }
        } else if (fA < this.a.d(mg6.a() + 1)) {
            return false;
        }
        return true;
    }

    private final float k(float f) {
        if (f < 0.0f && !this.a.b()) {
            return f;
        }
        if (f <= 0.0f || this.a.a()) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(ir.nasim.InterfaceC8748Xd6 r17, int r18, float r19, ir.nasim.InterfaceC20295rm1 r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IG6.l(ir.nasim.Xd6, int, float, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(ir.nasim.InterfaceC8748Xd6 r20, ir.nasim.MG6 r21, int r22, float r23, boolean r24, ir.nasim.InterfaceC20295rm1 r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IG6.n(ir.nasim.Xd6, ir.nasim.MG6, int, float, boolean, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object o(IG6 ig6, InterfaceC8748Xd6 interfaceC8748Xd6, MG6 mg6, int i, float f, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        return ig6.n(interfaceC8748Xd6, mg6, i, f, z, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(C5064Ht c5064Ht, MG6 mg6, int i, UA2 ua2) {
        NG6 ng6 = NG6.a;
        int i2 = i(((Number) c5064Ht.f()).floatValue(), mg6, i);
        if (i2 == 0) {
            return false;
        }
        ua2.invoke(Float.valueOf(i2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(ir.nasim.InterfaceC8748Xd6 r26, ir.nasim.MG6 r27, int r28, float r29, ir.nasim.InterfaceC20295rm1 r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IG6.q(ir.nasim.Xd6, ir.nasim.MG6, int, float, ir.nasim.rm1):java.lang.Object");
    }

    private final void r(Integer num) {
        this.f.setValue(num);
    }

    @Override // ir.nasim.InterfaceC7645Sp2
    public Object a(InterfaceC8748Xd6 interfaceC8748Xd6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!this.a.b() || !this.a.a()) {
            return AbstractC6392Nk0.c(f);
        }
        NG6 ng6 = NG6.a;
        float fFloatValue = ((Number) this.e.invoke(this.a)).floatValue();
        if (fFloatValue <= 0.0f) {
            throw new IllegalArgumentException("Distance returned by maximumFlingDistance should be greater than 0".toString());
        }
        MG6 mg6E = this.a.e();
        if (mg6E == null) {
            return AbstractC6392Nk0.c(f);
        }
        int iIntValue = ((Number) this.d.q(this.a, AbstractC6392Nk0.d(f < 0.0f ? mg6E.a() + 1 : mg6E.a()), AbstractC6392Nk0.d(this.a.c(f, this.b, fFloatValue)))).intValue();
        if (iIntValue < 0 || iIntValue >= this.a.h()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return l(interfaceC8748Xd6, iIntValue, f, interfaceC20295rm1);
    }

    public final Integer m() {
        return (Integer) this.f.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IG6(LG6 lg6, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt, InterfaceC15796kB2 interfaceC15796kB2) {
        this(lg6, interfaceC10163bB1, interfaceC5766Kt, interfaceC15796kB2, JG6.a.a());
        AbstractC13042fc3.i(lg6, "layoutInfo");
        AbstractC13042fc3.i(interfaceC10163bB1, "decayAnimationSpec");
        AbstractC13042fc3.i(interfaceC5766Kt, "springAnimationSpec");
        AbstractC13042fc3.i(interfaceC15796kB2, "snapIndex");
    }
}
