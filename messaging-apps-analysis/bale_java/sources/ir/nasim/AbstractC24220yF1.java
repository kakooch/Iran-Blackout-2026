package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC24220yF1;
import ir.nasim.InterfaceC16030kb1;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.yF1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC24220yF1 {

    /* renamed from: ir.nasim.yF1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        /* renamed from: ir.nasim.yF1$a$a, reason: collision with other inner class name */
        static final class C1779a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            C1779a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC21639ts7.i(UY6.c(QD5.settings_default_title, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(694639956, true, new C1779a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yF1$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        b(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, C15726k41.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yF1$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ AF1 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ C18195oF1 c;
        final /* synthetic */ C19391qG6 d;

        /* renamed from: ir.nasim.yF1$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ AF1 c;
            final /* synthetic */ Context d;
            final /* synthetic */ C19391qG6 e;
            final /* synthetic */ SA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AF1 af1, Context context, C19391qG6 c19391qG6, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = af1;
                this.d = context;
                this.e = c19391qG6;
                this.f = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(SA2 sa2) {
                sa2.invoke();
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    XF6 xf6F = this.c.f();
                    if (xf6F != null) {
                        Context context = this.d;
                        C19391qG6 c19391qG6 = this.e;
                        final SA2 sa2 = this.f;
                        SA2 sa22 = new SA2() { // from class: ir.nasim.zF1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC24220yF1.c.a.y(sa2);
                            }
                        };
                        this.b = 1;
                        if (AbstractC24220yF1.h(context, c19391qG6, xf6F, sa22, this) == objE) {
                            return objE;
                        }
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(AF1 af1, SA2 sa2, C18195oF1 c18195oF1, C19391qG6 c19391qG6) {
            this.a = af1;
            this.b = sa2;
            this.c = c18195oF1;
            this.d = c19391qG6;
        }

        public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            XF6 xf6F = this.a.f();
            interfaceC22053ub1.W(1183640480);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(context) | interfaceC22053ub1.V(this.b);
            AF1 af1 = this.a;
            C19391qG6 c19391qG6 = this.d;
            SA2 sa2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                Object aVar = new a(af1, context, c19391qG6, sa2, null);
                interfaceC22053ub1.s(aVar);
                objB = aVar;
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(xf6F, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            AbstractC24220yF1.c(AbstractC8014Ud6.g(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null), this.a, this.c, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yF1$d */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[XF6.values().length];
            try {
                iArr[XF6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.yF1$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC24220yF1.h(null, null, null, null, this);
        }
    }

    public static final void c(final androidx.compose.ui.e eVar, final AF1 af1, final C18195oF1 c18195oF1, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(eVar, "modifier");
        AbstractC13042fc3.i(af1, "state");
        AbstractC13042fc3.i(c18195oF1, "defaultTabCallBack");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1208221767);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(af1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(c18195oF1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC16867m00.e(UY6.c(QD5.tab_title_chat, interfaceC22053ub1J, 0), af1.d() == EnumC15002iq4.b, null, null, c18195oF1.a(), false, null, interfaceC22053ub1J, 0, Type.EUI48);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16867m00.e(UY6.c(QD5.jaryan, interfaceC22053ub1J, 0), af1.d() == EnumC15002iq4.c, null, null, c18195oF1.b(), false, null, interfaceC22053ub1J, 0, Type.EUI48);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16867m00.e(UY6.c(QD5.tab_title_khadamat, interfaceC22053ub1J, 0), af1.d() == EnumC15002iq4.d, null, null, c18195oF1.c(), false, null, interfaceC22053ub1J, 0, Type.EUI48);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xF1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24220yF1.d(eVar, af1, c18195oF1, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(androidx.compose.ui.e eVar, AF1 af1, C18195oF1 c18195oF1, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(af1, "$state");
        AbstractC13042fc3.i(c18195oF1, "$defaultTabCallBack");
        c(eVar, af1, c18195oF1, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void e(final AF1 af1, final SA2 sa2, final C18195oF1 c18195oF1, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(af1, "state");
        AbstractC13042fc3.i(sa2, "onBackPress");
        AbstractC13042fc3.i(c18195oF1, "defaultTabCallBack");
        AbstractC13042fc3.i(sa22, "resetSnackBarState");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1021878184);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(af1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(c18195oF1) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-671850294);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1J.s(objB);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-671849068);
            if (af1.e()) {
                CG3.g(null, null, null, interfaceC22053ub1J, 0, 7);
            }
            interfaceC22053ub1J.Q();
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(-333190636, true, new a(sa2), interfaceC22053ub1J, 54), null, AbstractC19242q11.e(1766547794, true, new b(c19391qG6), interfaceC22053ub1J, 54), null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-2020561623, true, new c(af1, sa22, c18195oF1, c19391qG6), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805309494, 436);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.wF1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24220yF1.f(af1, sa2, c18195oF1, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(AF1 af1, SA2 sa2, C18195oF1 c18195oF1, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(af1, "$state");
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(c18195oF1, "$defaultTabCallBack");
        AbstractC13042fc3.i(sa22, "$resetSnackBarState");
        e(af1, sa2, c18195oF1, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(android.content.Context r9, ir.nasim.C19391qG6 r10, ir.nasim.XF6 r11, ir.nasim.SA2 r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            boolean r0 = r13 instanceof ir.nasim.AbstractC24220yF1.e
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.yF1$e r0 = (ir.nasim.AbstractC24220yF1.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.yF1$e r0 = new ir.nasim.yF1$e
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r9 = r6.a
            r12 = r9
            ir.nasim.SA2 r12 = (ir.nasim.SA2) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto L61
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            ir.nasim.AbstractC10685c16.b(r13)
            int[] r13 = ir.nasim.AbstractC24220yF1.d.a
            int r11 = r11.ordinal()
            r11 = r13[r11]
            if (r11 != r2) goto L67
            int r11 = ir.nasim.QD5.settings_success_change_default_tab
            java.lang.String r9 = r9.getString(r11)
            ir.nasim.AbstractC13042fc3.f(r9)
            r6.a = r12
            r6.c = r2
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            r1 = r10
            r2 = r9
            java.lang.Object r9 = ir.nasim.C19391qG6.f(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 != r0) goto L61
            return r0
        L61:
            r12.invoke()
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        L67:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24220yF1.h(android.content.Context, ir.nasim.qG6, ir.nasim.XF6, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }
}
