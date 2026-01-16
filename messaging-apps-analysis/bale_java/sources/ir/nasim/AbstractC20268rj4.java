package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import ir.nasim.AbstractC20268rj4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.rj4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20268rj4 {
    private static final float a = C17784nZ1.q(SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER);

    /* renamed from: ir.nasim.rj4$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ EnumC5526Js2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ int e;
        final /* synthetic */ EnumC23487x03 f;

        /* renamed from: ir.nasim.rj4$a$a, reason: collision with other inner class name */
        static final class C1513a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            C1513a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strC = UY6.c(this.a, interfaceC22053ub1, 0);
                G10 g10 = G10.a;
                int i2 = G10.b;
                AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).c(), interfaceC22053ub1, 0, 0, 65530);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.rj4$a$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ EnumC23487x03 a;

            b(EnumC23487x03 enumC23487x03) {
                this.a = enumC23487x03;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC24077y03.a(FN1.d(this.a, interfaceC22053ub1, 0), null, null, G10.a.a(interfaceC22053ub1, G10.b).B(), interfaceC22053ub1, 48, 4);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.rj4$a$c */
        public /* synthetic */ class c {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC5526Js2.values().length];
                try {
                    iArr[EnumC5526Js2.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC5526Js2.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC5526Js2.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        a(EnumC5526Js2 enumC5526Js2, SA2 sa2, SA2 sa22, SA2 sa23, int i, EnumC23487x03 enumC23487x03) {
            this.a = enumC5526Js2;
            this.b = sa2;
            this.c = sa22;
            this.d = sa23;
            this.e = i;
            this.f = enumC23487x03;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            SA2 sa2;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-345760938, true, new C1513a(this.e), interfaceC22053ub1, 54);
            int i2 = c.a[this.a.ordinal()];
            if (i2 == 1) {
                sa2 = this.b;
            } else if (i2 == 2) {
                sa2 = this.c;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                sa2 = this.d;
            }
            AbstractC6197Mp.b(interfaceC18060o11E, sa2, null, AbstractC19242q11.e(-1619960167, true, new b(this.f), interfaceC22053ub1, 54), null, false, null, null, null, interfaceC22053ub1, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rj4$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ int b;
        final /* synthetic */ EnumC23487x03 c;

        /* renamed from: ir.nasim.rj4$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strC = UY6.c(this.a, interfaceC22053ub1, 0);
                G10 g10 = G10.a;
                int i2 = G10.b;
                AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).c(), interfaceC22053ub1, 0, 0, 65530);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.rj4$b$b, reason: collision with other inner class name */
        static final class C1514b implements InterfaceC14603iB2 {
            final /* synthetic */ EnumC23487x03 a;

            C1514b(EnumC23487x03 enumC23487x03) {
                this.a = enumC23487x03;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC24077y03.a(FN1.d(this.a, interfaceC22053ub1, 0), null, null, G10.a.a(interfaceC22053ub1, G10.b).B(), interfaceC22053ub1, 48, 4);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(SA2 sa2, int i, EnumC23487x03 enumC23487x03) {
            this.a = sa2;
            this.b = i;
            this.c = enumC23487x03;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC6197Mp.b(AbstractC19242q11.e(1201428911, true, new a(this.b), interfaceC22053ub1, 54), this.a, null, AbstractC19242q11.e(-810964302, true, new C1514b(this.c), interfaceC22053ub1, 54), null, false, null, null, null, interfaceC22053ub1, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rj4$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ float b;
        final /* synthetic */ boolean c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ boolean e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ boolean g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ EnumC5526Js2 i;
        final /* synthetic */ SA2 j;
        final /* synthetic */ SA2 k;
        final /* synthetic */ SA2 l;

        /* renamed from: ir.nasim.rj4$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ float a;
            final /* synthetic */ boolean b;
            final /* synthetic */ SA2 c;
            final /* synthetic */ boolean d;
            final /* synthetic */ SA2 e;
            final /* synthetic */ boolean f;
            final /* synthetic */ SA2 g;
            final /* synthetic */ EnumC5526Js2 h;
            final /* synthetic */ SA2 i;
            final /* synthetic */ SA2 j;
            final /* synthetic */ SA2 k;

            /* renamed from: ir.nasim.rj4$c$a$a, reason: collision with other inner class name */
            static final class C1515a implements InterfaceC15796kB2 {
                final /* synthetic */ boolean a;
                final /* synthetic */ SA2 b;
                final /* synthetic */ SA2 c;
                final /* synthetic */ boolean d;
                final /* synthetic */ SA2 e;
                final /* synthetic */ EnumC5526Js2 f;
                final /* synthetic */ SA2 g;
                final /* synthetic */ SA2 h;
                final /* synthetic */ SA2 i;

                C1515a(boolean z, SA2 sa2, SA2 sa22, boolean z2, SA2 sa23, EnumC5526Js2 enumC5526Js2, SA2 sa24, SA2 sa25, SA2 sa26) {
                    this.a = z;
                    this.b = sa2;
                    this.c = sa22;
                    this.d = z2;
                    this.e = sa23;
                    this.f = enumC5526Js2;
                    this.g = sa24;
                    this.h = sa25;
                    this.i = sa26;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h(SA2 sa2, SA2 sa22) {
                    AbstractC13042fc3.i(sa2, "$onToggleMarkAsUnRead");
                    AbstractC13042fc3.i(sa22, "$onDismissRequest");
                    sa2.invoke();
                    sa22.invoke();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(SA2 sa2, SA2 sa22) {
                    AbstractC13042fc3.i(sa2, "$onAddToFolderClicked");
                    AbstractC13042fc3.i(sa22, "$onDismissRequest");
                    sa2.invoke();
                    sa22.invoke();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 k(SA2 sa2, SA2 sa22) {
                    AbstractC13042fc3.i(sa2, "$onRemoveFromFolderClicked");
                    AbstractC13042fc3.i(sa22, "$onDismissRequest");
                    sa2.invoke();
                    sa22.invoke();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 n(SA2 sa2, SA2 sa22) {
                    AbstractC13042fc3.i(sa2, "$onCreateFolderClicked");
                    AbstractC13042fc3.i(sa22, "$onDismissRequest");
                    sa2.invoke();
                    sa22.invoke();
                    return C19938rB7.a;
                }

                public final void f(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    EnumC5526Js2 enumC5526Js2;
                    AbstractC13042fc3.i(zy0, "$this$DropdownMenu");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    interfaceC22053ub1.W(-163938695);
                    if (this.a) {
                        AbstractC20268rj4.k(this.b, this.c, interfaceC22053ub1, 0);
                    }
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-163933850);
                    if (C8386Vt0.a.O7()) {
                        boolean z = this.d;
                        interfaceC22053ub1.W(-163929559);
                        boolean zV = interfaceC22053ub1.V(this.e) | interfaceC22053ub1.V(this.c);
                        final SA2 sa2 = this.e;
                        final SA2 sa22 = this.c;
                        Object objB = interfaceC22053ub1.B();
                        if (zV || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.sj4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return AbstractC20268rj4.c.a.C1515a.h(sa2, sa22);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC20268rj4.g(z, (SA2) objB, interfaceC22053ub1, 0);
                    }
                    interfaceC22053ub1.Q();
                    if (!C8386Vt0.u8() || (enumC5526Js2 = this.f) == null) {
                        return;
                    }
                    final SA2 sa23 = this.g;
                    final SA2 sa24 = this.c;
                    final SA2 sa25 = this.h;
                    final SA2 sa26 = this.i;
                    interfaceC22053ub1.W(-507420793);
                    boolean zV2 = interfaceC22053ub1.V(sa23) | interfaceC22053ub1.V(sa24);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.tj4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC20268rj4.c.a.C1515a.i(sa23, sa24);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa27 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-507414324);
                    boolean zV3 = interfaceC22053ub1.V(sa25) | interfaceC22053ub1.V(sa24);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new SA2() { // from class: ir.nasim.uj4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC20268rj4.c.a.C1515a.k(sa25, sa24);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    SA2 sa28 = (SA2) objB3;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-507407832);
                    boolean zV4 = interfaceC22053ub1.V(sa26) | interfaceC22053ub1.V(sa24);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zV4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.vj4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC20268rj4.c.a.C1515a.n(sa26, sa24);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC20268rj4.e(enumC5526Js2, sa27, sa28, (SA2) objB4, interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    f((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(float f, boolean z, SA2 sa2, boolean z2, SA2 sa22, boolean z3, SA2 sa23, EnumC5526Js2 enumC5526Js2, SA2 sa24, SA2 sa25, SA2 sa26) {
                this.a = f;
                this.b = z;
                this.c = sa2;
                this.d = z2;
                this.e = sa22;
                this.f = z3;
                this.g = sa23;
                this.h = enumC5526Js2;
                this.i = sa24;
                this.j = sa25;
                this.k = sa26;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                G10 g10 = G10.a;
                int i2 = G10.b;
                M46 m46D = N46.d(g10.c(interfaceC22053ub1, i2).a().b());
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.x(androidx.compose.foundation.b.d(androidx.compose.ui.e.a, g10.a(interfaceC22053ub1, i2).M(), null, 2, null), this.a, 0.0f, 0.0f, 0.0f, 14, null), g10.c(interfaceC22053ub1, i2).b().g(), 0.0f, 2, null);
                boolean z = this.b;
                SA2 sa2 = this.c;
                AbstractC6197Mp.a(z, sa2, eVarK, 0L, null, null, m46D, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(-326305974, true, new C1515a(this.d, this.e, sa2, this.f, this.g, this.h, this.i, this.j, this.k), interfaceC22053ub1, 54), interfaceC22053ub1, 0, 48, 1976);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c(boolean z, float f, boolean z2, SA2 sa2, boolean z3, SA2 sa22, boolean z4, SA2 sa23, EnumC5526Js2 enumC5526Js2, SA2 sa24, SA2 sa25, SA2 sa26) {
            this.a = z;
            this.b = f;
            this.c = z2;
            this.d = sa2;
            this.e = z3;
            this.f = sa22;
            this.g = z4;
            this.h = sa23;
            this.i = enumC5526Js2;
            this.j = sa24;
            this.k = sa25;
            this.l = sa26;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(this.a ? EnumC12613eu3.b : EnumC12613eu3.a), AbstractC19242q11.e(-1946051313, true, new a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rj4$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;

        d(SA2 sa2, SA2 sa22) {
            this.a = sa2;
            this.b = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(sa2, "$onViewContactClicked");
            AbstractC13042fc3.i(sa22, "$onDismissRequest");
            sa2.invoke();
            sa22.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            H61 h61 = H61.a;
            InterfaceC14603iB2 interfaceC14603iB2A = h61.a();
            interfaceC22053ub1.W(-2120935730);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final SA2 sa2 = this.a;
            final SA2 sa22 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.wj4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC20268rj4.d.c(sa2, sa22);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC6197Mp.b(interfaceC14603iB2A, (SA2) objB, null, h61.b(), null, false, null, null, null, interfaceC22053ub1, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rj4$e */
    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5526Js2.values().length];
            try {
                iArr[EnumC5526Js2.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5526Js2.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC5526Js2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final void e(final EnumC5526Js2 enumC5526Js2, final SA2 sa2, final SA2 sa22, final SA2 sa23, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        XV4 xv4;
        AbstractC13042fc3.i(enumC5526Js2, "folderMenuState");
        AbstractC13042fc3.i(sa2, "onAddToFolderClicked");
        AbstractC13042fc3.i(sa22, "onRemoveFromFolderClicked");
        AbstractC13042fc3.i(sa23, "onCreateFolderClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2069323595);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(enumC5526Js2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int i3 = e.a[enumC5526Js2.ordinal()];
            if (i3 == 1) {
                xv4 = new XV4(Integer.valueOf(FD5.remove_from_folder), EnumC23487x03.G);
            } else if (i3 == 2) {
                xv4 = new XV4(Integer.valueOf(FD5.add_to_folder), EnumC23487x03.H);
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                xv4 = new XV4(Integer.valueOf(FD5.add_folder), EnumC23487x03.J);
            }
            M10.f(false, AbstractC19242q11.e(-405557370, true, new a(enumC5526Js2, sa2, sa22, sa23, ((Number) xv4.a()).intValue(), (EnumC23487x03) xv4.b()), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.oj4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC20268rj4.f(enumC5526Js2, sa2, sa22, sa23, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(EnumC5526Js2 enumC5526Js2, SA2 sa2, SA2 sa22, SA2 sa23, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(enumC5526Js2, "$folderMenuState");
        AbstractC13042fc3.i(sa2, "$onAddToFolderClicked");
        AbstractC13042fc3.i(sa22, "$onRemoveFromFolderClicked");
        AbstractC13042fc3.i(sa23, "$onCreateFolderClicked");
        e(enumC5526Js2, sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void g(final boolean z, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onToggleMarkAsUnRead");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1135486436);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            XV4 xv4 = z ? new XV4(Integer.valueOf(FD5.dialogs_menu_un_read_chat_mode), EnumC23487x03.Y) : new XV4(Integer.valueOf(FD5.dialogs_menu_read_chat_mode), EnumC23487x03.Z);
            M10.f(false, AbstractC19242q11.e(-1618687521, true, new b(sa2, ((Number) xv4.a()).intValue(), (EnumC23487x03) xv4.b()), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.nj4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC20268rj4.h(z, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(boolean z, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onToggleMarkAsUnRead");
        g(z, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final boolean r20, final boolean r21, final boolean r22, final ir.nasim.EnumC5526Js2 r23, final ir.nasim.SA2 r24, final ir.nasim.SA2 r25, final ir.nasim.SA2 r26, final ir.nasim.SA2 r27, final ir.nasim.SA2 r28, final ir.nasim.SA2 r29, float r30, ir.nasim.InterfaceC22053ub1 r31, final int r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20268rj4.i(boolean, boolean, boolean, ir.nasim.Js2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, float, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(boolean z, boolean z2, boolean z3, EnumC5526Js2 enumC5526Js2, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26, float f, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(sa22, "$onViewContactClicked");
        AbstractC13042fc3.i(sa23, "$onToggleMarkAsUnRead");
        AbstractC13042fc3.i(sa24, "$onAddToFolderClicked");
        AbstractC13042fc3.i(sa25, "$onRemoveFromFolderClicked");
        AbstractC13042fc3.i(sa26, "$onCreateFolderClicked");
        i(z, z2, z3, enumC5526Js2, sa2, sa22, sa23, sa24, sa25, sa26, f, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2082025303);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(1477170620, true, new d(sa2, sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.pj4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC20268rj4.l(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onViewContactClicked");
        AbstractC13042fc3.i(sa22, "$onDismissRequest");
        k(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
