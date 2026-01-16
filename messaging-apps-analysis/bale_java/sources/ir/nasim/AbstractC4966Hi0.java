package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.AbstractC4966Hi0;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;

/* renamed from: ir.nasim.Hi0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4966Hi0 {

    /* renamed from: ir.nasim.Hi0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15607js c;
        final /* synthetic */ InterfaceC14354hm4 d;
        final /* synthetic */ InterfaceC20315ro1 e;
        final /* synthetic */ C19206px3 f;
        final /* synthetic */ SA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C15607js c15607js, InterfaceC14354hm4 interfaceC14354hm4, InterfaceC20315ro1 interfaceC20315ro1, C19206px3 c19206px3, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15607js;
            this.d = interfaceC14354hm4;
            this.e = interfaceC20315ro1;
            this.f = c19206px3;
            this.g = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (AbstractC4966Hi0.p(this.d) == 0.0f) {
                return C19938rB7.a;
            }
            boolean z = this.c.p() == null;
            boolean zB = true ^ AbstractC13042fc3.b((Float) this.c.p(), AbstractC4966Hi0.p(this.d));
            if (!z && zB) {
                AbstractC4966Hi0.j(this.e, this.c, this.f, this.g, this.d);
            }
            this.c.z(AbstractC6392Nk0.c(0.0f), AbstractC6392Nk0.c(AbstractC4966Hi0.p(this.d)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Hi0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ WH1 e;
        final /* synthetic */ C15607js f;
        final /* synthetic */ List g;
        final /* synthetic */ InterfaceC14354hm4 h;
        final /* synthetic */ InterfaceC20315ro1 i;
        final /* synthetic */ C19206px3 j;
        final /* synthetic */ SA2 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z, SA2 sa2, WH1 wh1, C15607js c15607js, List list, InterfaceC14354hm4 interfaceC14354hm4, InterfaceC20315ro1 interfaceC20315ro1, C19206px3 c19206px3, SA2 sa22, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = sa2;
            this.e = wh1;
            this.f = c15607js;
            this.g = list;
            this.h = interfaceC14354hm4;
            this.i = interfaceC20315ro1;
            this.j = c19206px3;
            this.k = sa22;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c) {
                    this.d.invoke();
                    float fMax = this.g.size() > 3 ? Math.max(this.e.w1(C17784nZ1.q(64)), AbstractC4966Hi0.p(this.h) / 1.5f) : 0.0f;
                    C15607js c15607js = this.f;
                    Float fC = AbstractC6392Nk0.c(fMax);
                    C18827pJ6 c18827pJ6 = new C18827pJ6(0.75f, 0.0f, null, 6, null);
                    this.b = 1;
                    if (C15607js.h(c15607js, fC, c18827pJ6, null, null, this, 12, null) == objE) {
                        return objE;
                    }
                } else {
                    AbstractC4966Hi0.j(this.i, this.f, this.j, this.k, this.h);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Hi0$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ C19206px3 a;
        final /* synthetic */ List b;
        final /* synthetic */ UA2 c;

        /* renamed from: ir.nasim.Hi0$c$a */
        public static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(List list) {
                super(1);
                this.e = list;
            }

            public final Object a(int i) {
                this.e.get(i);
                return null;
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        /* renamed from: ir.nasim.Hi0$c$b */
        public static final class b extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;
            final /* synthetic */ UA2 f;
            final /* synthetic */ List g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(List list, UA2 ua2, List list2) {
                super(4);
                this.e = list;
                this.f = ua2;
                this.g = list2;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                if ((i2 & 6) == 0) {
                    i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1091073711, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                C24488yi0 c24488yi0 = (C24488yi0) this.e.get(i);
                interfaceC22053ub1.W(-1497224710);
                AbstractC4966Hi0.s(c24488yi0, this.f, interfaceC22053ub1, C24488yi0.d);
                interfaceC22053ub1.W(367347308);
                if (i != AbstractC10360bX0.o(this.g)) {
                    MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
                }
                interfaceC22053ub1.Q();
                interfaceC22053ub1.Q();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        c(C19206px3 c19206px3, List list, UA2 ua2) {
            this.a = c19206px3;
            this.b = list;
            this.c = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(list, "$commands");
            AbstractC13042fc3.i(ua2, "$onCommandClicked");
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, R21.a.a(), 3, null);
            interfaceC15069ix3.a(list.size(), null, new a(list), AbstractC19242q11.c(-1091073711, true, new b(list, ua2, list)));
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            C19206px3 c19206px3 = this.a;
            C24254yJ.f fVarB = C24254yJ.a.b();
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            interfaceC22053ub1.W(-1524814248);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.c);
            final List list = this.b;
            final UA2 ua2 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Ii0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC4966Hi0.c.c(list, ua2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC12623ev3.b(eVarH, c19206px3, null, false, fVarB, bVarG, null, false, null, (UA2) objB, interfaceC22053ub1, 221190, 460);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Hi0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15607js c;
        final /* synthetic */ C19206px3 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC14354hm4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C15607js c15607js, C19206px3 c19206px3, SA2 sa2, InterfaceC14354hm4 interfaceC14354hm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15607js;
            this.d = c19206px3;
            this.e = sa2;
            this.f = interfaceC14354hm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = this.c;
                Float fC = AbstractC6392Nk0.c(AbstractC4966Hi0.p(this.f));
                this.b = 1;
                if (C15607js.h(c15607js, fC, null, null, null, this, 14, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.e.invoke();
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            C19206px3 c19206px3 = this.d;
            this.b = 2;
            if (C19206px3.J(c19206px3, 0, 0, this, 2, null) == objE) {
                return objE;
            }
            this.e.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Hi0$e */
    public static final class e implements InterfaceC24572yq4 {
        final /* synthetic */ C15607js a;
        final /* synthetic */ C19206px3 b;
        final /* synthetic */ InterfaceC20315ro1 c;
        final /* synthetic */ float d;
        final /* synthetic */ InterfaceC14354hm4 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ InterfaceC10163bB1 g;

        /* renamed from: ir.nasim.Hi0$e$a */
        static final class a extends AbstractC22163um1 {
            Object a;
            long b;
            long c;
            /* synthetic */ Object d;
            int f;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.d = obj;
                this.f |= RecyclerView.UNDEFINED_DURATION;
                return e.this.i0(0L, 0L, this);
            }
        }

        /* renamed from: ir.nasim.Hi0$e$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C15607js c;
            final /* synthetic */ float d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C15607js c15607js, float f, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c15607js;
                this.d = f;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C15607js c15607js = this.c;
                    Float fC = AbstractC6392Nk0.c(this.d);
                    this.b = 1;
                    if (c15607js.x(fC, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(C15607js c15607js, C19206px3 c19206px3, InterfaceC20315ro1 interfaceC20315ro1, float f, InterfaceC14354hm4 interfaceC14354hm4, SA2 sa2, InterfaceC10163bB1 interfaceC10163bB1) {
            this.a = c15607js;
            this.b = c19206px3;
            this.c = interfaceC20315ro1;
            this.d = f;
            this.e = interfaceC14354hm4;
            this.f = sa2;
            this.g = interfaceC10163bB1;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC24572yq4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object i0(long r11, long r13, ir.nasim.InterfaceC20295rm1 r15) {
            /*
                r10 = this;
                boolean r0 = r15 instanceof ir.nasim.AbstractC4966Hi0.e.a
                if (r0 == 0) goto L13
                r0 = r15
                ir.nasim.Hi0$e$a r0 = (ir.nasim.AbstractC4966Hi0.e.a) r0
                int r1 = r0.f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f = r1
                goto L18
            L13:
                ir.nasim.Hi0$e$a r0 = new ir.nasim.Hi0$e$a
                r0.<init>(r15)
            L18:
                java.lang.Object r15 = r0.d
                java.lang.Object r8 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r0.f
                r9 = 2
                r2 = 1
                if (r1 == 0) goto L43
                if (r1 == r2) goto L35
                if (r1 != r9) goto L2d
                ir.nasim.AbstractC10685c16.b(r15)
                goto L9b
            L2d:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L35:
                long r13 = r0.c
                long r11 = r0.b
                java.lang.Object r1 = r0.a
                ir.nasim.Hi0$e r1 = (ir.nasim.AbstractC4966Hi0.e) r1
                ir.nasim.AbstractC10685c16.b(r15)
            L40:
                r2 = r11
                r4 = r13
                goto L68
            L43:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.js r1 = r10.a
                float r15 = ir.nasim.C17718nR7.i(r13)
                java.lang.Float r15 = ir.nasim.AbstractC6392Nk0.c(r15)
                ir.nasim.bB1 r3 = r10.g
                r0.a = r10
                r0.b = r11
                r0.c = r13
                r0.f = r2
                r4 = 0
                r6 = 4
                r7 = 0
                r2 = r15
                r5 = r0
                java.lang.Object r15 = ir.nasim.C15607js.f(r1, r2, r3, r4, r5, r6, r7)
                if (r15 != r8) goto L66
                return r8
            L66:
                r1 = r10
                goto L40
            L68:
                float r11 = r1.d
                ir.nasim.hm4 r12 = r1.e
                float r12 = ir.nasim.AbstractC4966Hi0.x(r12)
                ir.nasim.js r13 = r1.a
                java.lang.Object r13 = r13.q()
                java.lang.Number r13 = (java.lang.Number) r13
                float r13 = r13.floatValue()
                float r12 = r12 - r13
                int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
                if (r11 <= 0) goto L8e
                ir.nasim.ro1 r11 = r1.c
                ir.nasim.js r12 = r1.a
                ir.nasim.px3 r13 = r1.b
                ir.nasim.SA2 r14 = r1.f
                ir.nasim.hm4 r15 = r1.e
                ir.nasim.AbstractC4966Hi0.w(r11, r12, r13, r14, r15)
            L8e:
                r11 = 0
                r0.a = r11
                r0.f = r9
                r6 = r0
                java.lang.Object r15 = super.i0(r2, r4, r6)
                if (r15 != r8) goto L9b
                return r8
            L9b:
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4966Hi0.e.i0(long, long, ir.nasim.rm1):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC24572yq4
        public long s1(long j, int i) {
            int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (j & 4294967295L));
            float fFloatValue = ((Number) this.a.q()).floatValue();
            if (fFloatValue == 0.0f && (this.b.d() || iIntBitsToFloat < 0)) {
                return ZG4.b.c();
            }
            float fFloatValue2 = ((Number) this.a.q()).floatValue() + iIntBitsToFloat;
            AbstractC10533bm0.d(this.c, null, null, new b(this.a, fFloatValue2, null), 3, null);
            float f = fFloatValue2 - fFloatValue;
            if (this.d > AbstractC4966Hi0.p(this.e) - fFloatValue2) {
                AbstractC4966Hi0.j(this.c, this.a, this.b, this.f, this.e);
            }
            return ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (4294967295L & Float.floatToRawIntBits(f)));
        }
    }

    /* renamed from: ir.nasim.Hi0$f */
    static final class f implements InterfaceC14603iB2 {
        final /* synthetic */ C24488yi0 a;
        final /* synthetic */ UA2 b;

        f(C24488yi0 c24488yi0, UA2 ua2) {
            this.a = c24488yi0;
            this.b = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, String str) {
            AbstractC13042fc3.i(ua2, "$onCommandClicked");
            AbstractC13042fc3.i(str, "$slashCommandText");
            ua2.invoke(str);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final String str = Separators.SLASH + this.a.c();
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(-1034942910);
            boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.V(str);
            final UA2 ua2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Ji0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC4966Hi0.f.c(ua2, str);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarF, g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().e());
            C24488yi0 c24488yi0 = this.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            C9348Zn7 c9348Zn7C = g10.d(interfaceC22053ub1, i2).c();
            long jB = g10.a(interfaceC22053ub1, i2).B();
            AbstractC23365wn7.a aVar3 = AbstractC23365wn7.a;
            AbstractC9339Zm7.b(str, null, jB, 0L, null, null, null, 0L, null, null, 0L, aVar3.b(), false, 0, 0, null, c9348Zn7C, interfaceC22053ub1, 0, 48, SetRpcStruct$ComposedRpc.RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(12)), interfaceC22053ub1, 6);
            ZH6.a(L66.b(m66, aVar, 1.0f, false, 2, null), interfaceC22053ub1, 0);
            AbstractC9339Zm7.b(c24488yi0.a(), null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, null, 0L, aVar3.b(), false, 0, 0, null, g10.d(interfaceC22053ub1, i2).a(), interfaceC22053ub1, 0, 48, SetRpcStruct$ComposedRpc.RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01aa  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final boolean r39, final java.util.List r40, final ir.nasim.UA2 r41, androidx.compose.ui.e r42, ir.nasim.SA2 r43, ir.nasim.SA2 r44, ir.nasim.InterfaceC22053ub1 r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 1269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4966Hi0.i(boolean, java.util.List, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC13730gj3 j(InterfaceC20315ro1 interfaceC20315ro1, C15607js c15607js, C19206px3 c19206px3, SA2 sa2, InterfaceC14354hm4 interfaceC14354hm4) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new d(c15607js, c19206px3, sa2, interfaceC14354hm4, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(InterfaceC14354hm4 interfaceC14354hm4, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(interfaceC14354hm4, "$sheetHeight$delegate");
        AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
        if (((int) (interfaceC11379cu3.a() & 4294967295L)) != p(interfaceC14354hm4)) {
            q(interfaceC14354hm4, (int) (interfaceC11379cu3.a() & 4294967295L));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C22045ua3 m(C15607js c15607js, WH1 wh1) {
        AbstractC13042fc3.i(c15607js, "$animatedOffset");
        AbstractC13042fc3.i(wh1, "$this$offset");
        return C22045ua3.c(C22045ua3.f((AbstractC20723sV3.d(((Number) c15607js.q()).floatValue()) & 4294967295L) | (0 << 32)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(boolean z, List list, UA2 ua2, androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$commands");
        AbstractC13042fc3.i(ua2, "$onCommandClicked");
        i(z, list, ua2, eVar, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float p(InterfaceC14354hm4 interfaceC14354hm4) {
        return interfaceC14354hm4.a();
    }

    private static final void q(InterfaceC14354hm4 interfaceC14354hm4, float f2) {
        interfaceC14354hm4.s(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(InterfaceC20315ro1 interfaceC20315ro1, C15607js c15607js, C19206px3 c19206px3, SA2 sa2, InterfaceC14354hm4 interfaceC14354hm4) {
        AbstractC13042fc3.i(interfaceC20315ro1, "$coroutineScope");
        AbstractC13042fc3.i(c15607js, "$animatedOffset");
        AbstractC13042fc3.i(c19206px3, "$listState");
        AbstractC13042fc3.i(interfaceC14354hm4, "$sheetHeight$delegate");
        j(interfaceC20315ro1, c15607js, c19206px3, sa2, interfaceC14354hm4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final C24488yi0 c24488yi0, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(922404527);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(c24488yi0) : interfaceC22053ub1J.D(c24488yi0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-2077586961, true, new f(c24488yi0, ua2), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Gi0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4966Hi0.t(c24488yi0, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(C24488yi0 c24488yi0, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c24488yi0, "$command");
        AbstractC13042fc3.i(ua2, "$onCommandClicked");
        s(c24488yi0, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1097368220);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.v(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g10.c(interfaceC22053ub1J, i2).b().h(), 0.0f, g10.c(interfaceC22053ub1J, i2).b().u(), 5, null), g10.c(interfaceC22053ub1J, i2).b().l(), g10.c(interfaceC22053ub1J, i2).b().n()), g10.a(interfaceC22053ub1J, i2).E(), N46.d(g10.c(interfaceC22053ub1J, i2).b().n())), interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Fi0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4966Hi0.v(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        u(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
