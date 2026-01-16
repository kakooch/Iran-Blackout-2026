package defpackage;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.foundation.layout.q;
import androidx.compose.foundation.layout.t;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.C;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10721c52;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC11029cc6;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15909kN7;
import ir.nasim.AbstractC18209oG6;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC21639ts7;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC8014Ud6;
import ir.nasim.AbstractC9339Zm7;
import ir.nasim.C10639bw6;
import ir.nasim.C18018nw6;
import ir.nasim.C19391qG6;
import ir.nasim.C19938rB7;
import ir.nasim.C20390rv6;
import ir.nasim.C6015Lu6;
import ir.nasim.C7252Qx5;
import ir.nasim.C9619aG6;
import ir.nasim.CG3;
import ir.nasim.CI3;
import ir.nasim.EnumC12613eu3;
import ir.nasim.G10;
import ir.nasim.H07;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.QD5;
import ir.nasim.QJ5;
import ir.nasim.SA2;
import ir.nasim.TS4;
import ir.nasim.UA2;
import ir.nasim.UY6;

/* loaded from: classes5.dex */
public abstract class C {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        /* renamed from: C$a$a, reason: collision with other inner class name */
        static final class C0000a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            C0000a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC21639ts7.i(UY6.c(QD5.settings_setting, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
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
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(85343962, true, new C0000a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        b(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, s.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ C10639bw6 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ C18018nw6 d;
        final /* synthetic */ C20390rv6 e;
        final /* synthetic */ C6015Lu6 f;
        final /* synthetic */ C19391qG6 g;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C10639bw6 c;
            final /* synthetic */ Context d;
            final /* synthetic */ C19391qG6 e;
            final /* synthetic */ SA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10639bw6 c10639bw6, Context context, C19391qG6 c19391qG6, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c10639bw6;
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
                    C9619aG6 c9619aG6H = this.c.h();
                    if (c9619aG6H != null) {
                        Context context = this.d;
                        C19391qG6 c19391qG6 = this.e;
                        final SA2 sa2 = this.f;
                        SA2 sa22 = new SA2() { // from class: D
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C.c.a.y(sa2);
                            }
                        };
                        this.b = 1;
                        if (C.l(context, c19391qG6, c9619aG6H, sa22, this) == objE) {
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

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C10639bw6 c;
            final /* synthetic */ UA2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C10639bw6 c10639bw6, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c10639bw6;
                this.d = ua2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                H07 h07E = this.c.e();
                if (h07E != null) {
                    this.d.invoke(h07E.a());
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(C10639bw6 c10639bw6, SA2 sa2, UA2 ua2, C18018nw6 c18018nw6, C20390rv6 c20390rv6, C6015Lu6 c6015Lu6, C19391qG6 c19391qG6) {
            this.a = c10639bw6;
            this.b = sa2;
            this.c = ua2;
            this.d = c18018nw6;
            this.e = c20390rv6;
            this.f = c6015Lu6;
            this.g = c19391qG6;
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
            interfaceC22053ub1.W(-1290963131);
            if (this.a.g()) {
                CG3.g(null, null, null, interfaceC22053ub1, 0, 7);
            }
            interfaceC22053ub1.Q();
            C9619aG6 c9619aG6H = this.a.h();
            interfaceC22053ub1.W(-1290960014);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(context) | interfaceC22053ub1.V(this.b);
            C10639bw6 c10639bw6 = this.a;
            C19391qG6 c19391qG6 = this.g;
            SA2 sa2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c10639bw6, context, c19391qG6, sa2, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(c9619aG6H, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            H07 h07E = this.a.e();
            interfaceC22053ub1.W(-1290951562);
            boolean zV2 = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.c);
            C10639bw6 c10639bw62 = this.a;
            UA2 ua2 = this.c;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(c10639bw62, ua2, null);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(h07E, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
            C.f(this.d, this.e, this.f, this.a, AbstractC8014Ud6.g(q.m(t.f(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ C10639bw6 a;

        d(C10639bw6 c10639bw6) {
            this.a = c10639bw6;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "it");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(AbstractC15909kN7.b(this.a.d()), interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(strC, eVar, g10.a(interfaceC22053ub1, i3).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).c(), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CI3.values().length];
            try {
                iArr[CI3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CI3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CI3.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CI3.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CI3.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C.l(null, null, null, null, this);
        }
    }

    public static final void d(final C10639bw6 c10639bw6, final SA2 sa2, final C18018nw6 c18018nw6, final C20390rv6 c20390rv6, final C6015Lu6 c6015Lu6, final SA2 sa22, final SA2 sa23, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c10639bw6, "state");
        AbstractC13042fc3.i(sa2, "onBackPress");
        AbstractC13042fc3.i(c18018nw6, "settingsNavigationCallbacks");
        AbstractC13042fc3.i(c20390rv6, "settingLogSendingCallback");
        AbstractC13042fc3.i(c6015Lu6, "settingDeveloperModeCallback");
        AbstractC13042fc3.i(sa22, "updateLanguage");
        AbstractC13042fc3.i(sa23, "resetSnackBarState");
        AbstractC13042fc3.i(ua2, "shareFileAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(781698390);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c10639bw6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(c18018nw6) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(c20390rv6) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(c6015Lu6) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 8388608 : 4194304;
        }
        if ((i2 & 4793491) == 4793490 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(1790542044);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1J.s(objB);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB;
            interfaceC22053ub1J.Q();
            sa22.invoke();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(934935066, true, new a(sa2), interfaceC22053ub1J, 54), null, AbstractC19242q11.e(-378894820, true, new b(c19391qG6), interfaceC22053ub1J, 54), null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1658257179, true, new c(c10639bw6, sa23, ua2, c18018nw6, c20390rv6, c6015Lu6, c19391qG6), interfaceC22053ub12, 54), interfaceC22053ub12, 805309494, 436);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: z
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C.e(c10639bw6, sa2, c18018nw6, c20390rv6, c6015Lu6, sa22, sa23, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(C10639bw6 c10639bw6, SA2 sa2, C18018nw6 c18018nw6, C20390rv6 c20390rv6, C6015Lu6 c6015Lu6, SA2 sa22, SA2 sa23, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c10639bw6, "$state");
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(c18018nw6, "$settingsNavigationCallbacks");
        AbstractC13042fc3.i(c20390rv6, "$settingLogSendingCallback");
        AbstractC13042fc3.i(c6015Lu6, "$settingDeveloperModeCallback");
        AbstractC13042fc3.i(sa22, "$updateLanguage");
        AbstractC13042fc3.i(sa23, "$resetSnackBarState");
        AbstractC13042fc3.i(ua2, "$shareFileAction");
        d(c10639bw6, sa2, c18018nw6, c20390rv6, c6015Lu6, sa22, sa23, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final ir.nasim.C18018nw6 r29, final ir.nasim.C20390rv6 r30, final ir.nasim.C6015Lu6 r31, final ir.nasim.C10639bw6 r32, androidx.compose.ui.e r33, ir.nasim.InterfaceC22053ub1 r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 1276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C.f(ir.nasim.nw6, ir.nasim.rv6, ir.nasim.Lu6, ir.nasim.bw6, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    private static final boolean g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(C20390rv6 c20390rv6, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(c20390rv6, "$logSendingCallback");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isWebViewDebugging$delegate");
        h(interfaceC9102Ym4, !g(interfaceC9102Ym4));
        c20390rv6.e().invoke(Boolean.valueOf(g(interfaceC9102Ym4)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(C18018nw6 c18018nw6, C20390rv6 c20390rv6, C6015Lu6 c6015Lu6, C10639bw6 c10639bw6, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c18018nw6, "$navigationCallbacks");
        AbstractC13042fc3.i(c20390rv6, "$logSendingCallback");
        AbstractC13042fc3.i(c6015Lu6, "$developerModeCallback");
        AbstractC13042fc3.i(c10639bw6, "$settingUiState");
        f(c18018nw6, c20390rv6, c6015Lu6, c10639bw6, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(android.content.Context r9, ir.nasim.C19391qG6 r10, ir.nasim.C9619aG6 r11, ir.nasim.SA2 r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            boolean r0 = r13 instanceof C.f
            if (r0 == 0) goto L14
            r0 = r13
            C$f r0 = (C.f) r0
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
            C$f r0 = new C$f
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
            goto L93
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.CI3 r11 = r11.a()
            int[] r13 = C.e.a
            int r11 = r11.ordinal()
            r11 = r13[r11]
            if (r11 == r2) goto L77
            r13 = 2
            if (r11 == r13) goto L70
            r13 = 3
            if (r11 == r13) goto L69
            r13 = 4
            if (r11 == r13) goto L62
            r13 = 5
            if (r11 != r13) goto L5c
            int r11 = ir.nasim.QD5.settings_web_view_debug_enabled
            java.lang.String r9 = r9.getString(r11)
            goto L7d
        L5c:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L62:
            int r11 = ir.nasim.QD5.settings_web_view_debug_disabled
            java.lang.String r9 = r9.getString(r11)
            goto L7d
        L69:
            int r11 = ir.nasim.QD5.settings_send_log_error_empty
            java.lang.String r9 = r9.getString(r11)
            goto L7d
        L70:
            int r11 = ir.nasim.QD5.settings_send_log_error
            java.lang.String r9 = r9.getString(r11)
            goto L7d
        L77:
            int r11 = ir.nasim.QD5.settings_delete_log_success
            java.lang.String r9 = r9.getString(r11)
        L7d:
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
            if (r9 != r0) goto L93
            return r0
        L93:
            r12.invoke()
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C.l(android.content.Context, ir.nasim.qG6, ir.nasim.aG6, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }
}
