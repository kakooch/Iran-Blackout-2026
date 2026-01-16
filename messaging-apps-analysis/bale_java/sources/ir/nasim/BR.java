package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import ir.nasim.BR;
import ir.nasim.InterfaceC22053ub1;

/* loaded from: classes4.dex */
public final class BR implements InterfaceC23146wR {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ RR a;
        final /* synthetic */ InterfaceC14603iB2 b;

        /* renamed from: ir.nasim.BR$a$a, reason: collision with other inner class name */
        static final class C0294a implements InterfaceC14603iB2 {
            final /* synthetic */ RR a;
            final /* synthetic */ InterfaceC14603iB2 b;

            C0294a(RR rr, InterfaceC14603iB2 interfaceC14603iB2) {
                this.a = rr;
                this.b = interfaceC14603iB2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.animation.j f(androidx.compose.animation.d dVar) {
                AbstractC13042fc3.i(dVar, "$this$NavHost");
                return androidx.compose.animation.j.a.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.animation.h h(androidx.compose.animation.d dVar) {
                AbstractC13042fc3.i(dVar, "$this$NavHost");
                return androidx.compose.animation.h.a.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(InterfaceC14603iB2 interfaceC14603iB2, C8588Wp4 c8588Wp4, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(interfaceC14603iB2, "$builder");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c8120Up4, "$this$NavHost");
                interfaceC14603iB2.invoke(c8120Up4, c8588Wp4);
                return C19938rB7.a;
            }

            public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final C8588Wp4 c8588Wp4E = AbstractC8854Xp4.e(new androidx.navigation.p[0], interfaceC22053ub1, 0);
                String strA = this.a.a();
                UA2 ua2E = AbstractC8216Va1.e(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-36867045);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new UA2() { // from class: ir.nasim.yR
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return BR.a.C0294a.f((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-36864932);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.zR
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return BR.a.C0294a.h((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                UA2 ua2H = AbstractC8216Va1.h(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-36861026);
                boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(c8588Wp4E);
                final InterfaceC14603iB2 interfaceC14603iB2 = this.b;
                Object objB3 = interfaceC22053ub1.B();
                if (zV || objB3 == aVar.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.AR
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return BR.a.C0294a.i(interfaceC14603iB2, c8588Wp4E, (C8120Up4) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC9129Yp4.b(c8588Wp4E, strA, null, null, null, ua2E, ua2, ua22, ua2H, (UA2) objB3, interfaceC22053ub1, 14155776, 28);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
                d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(RR rr, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = rr;
            this.b = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(-2102827250, true, new C0294a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements LX7 {
        final /* synthetic */ boolean b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ TR d;
        final /* synthetic */ boolean e;

        b(boolean z, SA2 sa2, TR tr, boolean z2) {
            this.b = z;
            this.c = sa2;
            this.d = tr;
            this.e = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(boolean z, final SA2 sa2, TR tr, boolean z2, final UA2 ua2, final SA2 sa22, C8120Up4 c8120Up4, androidx.navigation.e eVar) {
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(tr, "$sourceType");
            AbstractC13042fc3.i(ua2, "$notifier");
            AbstractC13042fc3.i(sa22, "$onCreatePasswordComplete");
            AbstractC13042fc3.i(c8120Up4, "$this$BasedNavController");
            AbstractC13042fc3.i(eVar, "navController");
            AbstractC5992Ls1.c(c8120Up4, eVar, z, sa2, new SA2() { // from class: ir.nasim.ER
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return BR.b.e(ua2, sa2, sa22);
                }
            }, tr, z2);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 e(UA2 ua2, SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(ua2, "$notifier");
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(sa22, "$onCreatePasswordComplete");
            ua2.invoke(AbstractC23348wm0.b(AbstractC4616Fw7.a("AuthenticationResult_Key", Boolean.TRUE)));
            sa2.invoke();
            sa22.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(b bVar, SA2 sa2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(bVar, "$tmp1_rcvr");
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(ua2, "$notifier");
            bVar.I(sa2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
            return C19938rB7.a;
        }

        @Override // ir.nasim.LX7
        public final void I(final SA2 sa2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
            int i2;
            AbstractC13042fc3.i(sa2, "onBackPressed");
            AbstractC13042fc3.i(ua2, "notifier");
            InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-670598456);
            if ((i & 6) == 0) {
                i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= interfaceC22053ub1J.V(this) ? 256 : 128;
            }
            if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
                interfaceC22053ub1J.L();
            } else {
                BR br = BR.this;
                C5057Hs1 c5057Hs1 = C5057Hs1.a;
                interfaceC22053ub1J.W(1082045797);
                boolean zA = ((i2 & 14) == 4) | interfaceC22053ub1J.a(this.b) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.V(this.c) | interfaceC22053ub1J.D(this.d) | interfaceC22053ub1J.a(this.e);
                final boolean z = this.b;
                final TR tr = this.d;
                final boolean z2 = this.e;
                final SA2 sa22 = this.c;
                Object objB = interfaceC22053ub1J.B();
                if (zA || objB == InterfaceC22053ub1.a.a()) {
                    InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.CR
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return BR.b.d(z, sa2, tr, z2, ua2, sa22, (C8120Up4) obj, (androidx.navigation.e) obj2);
                        }
                    };
                    interfaceC22053ub1J.s(interfaceC14603iB2);
                    objB = interfaceC14603iB2;
                }
                interfaceC22053ub1J.Q();
                br.k(c5057Hs1, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 6);
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.DR
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return BR.b.f(this.a, sa2, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    static final class c implements LX7 {
        final /* synthetic */ SA2 b;
        final /* synthetic */ TR c;
        final /* synthetic */ SA2 d;

        c(SA2 sa2, TR tr, SA2 sa22) {
            this.b = sa2;
            this.c = tr;
            this.d = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2, SA2 sa22, TR tr, SA2 sa23, C8120Up4 c8120Up4, androidx.navigation.e eVar) {
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(sa22, "$onValidationComplete");
            AbstractC13042fc3.i(tr, "$sourceType");
            AbstractC13042fc3.i(sa23, "$onDeletePassword");
            AbstractC13042fc3.i(c8120Up4, "$this$BasedNavController");
            AbstractC13042fc3.i(eVar, "navController");
            AbstractC16822lv2.a(c8120Up4, eVar, sa2, sa22, tr, sa23);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(c cVar, SA2 sa2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(cVar, "$tmp1_rcvr");
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(ua2, "$notifier");
            cVar.I(sa2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
            return C19938rB7.a;
        }

        @Override // ir.nasim.LX7
        public final void I(final SA2 sa2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
            int i2;
            AbstractC13042fc3.i(sa2, "onBackPressed");
            AbstractC13042fc3.i(ua2, "notifier");
            InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1051591979);
            if ((i & 6) == 0) {
                i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 384) == 0) {
                i2 |= interfaceC22053ub1J.V(this) ? 256 : 128;
            }
            if ((i2 & 131) == 130 && interfaceC22053ub1J.k()) {
                interfaceC22053ub1J.L();
            } else {
                BR br = BR.this;
                C18004nv2 c18004nv2 = C18004nv2.a;
                interfaceC22053ub1J.W(494872924);
                boolean zV = ((i2 & 14) == 4) | interfaceC22053ub1J.V(this.b) | interfaceC22053ub1J.D(this.c) | interfaceC22053ub1J.V(this.d);
                final SA2 sa22 = this.b;
                final TR tr = this.c;
                final SA2 sa23 = this.d;
                Object objB = interfaceC22053ub1J.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new InterfaceC14603iB2() { // from class: ir.nasim.FR
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return BR.c.c(sa2, sa22, tr, sa23, (C8120Up4) obj, (androidx.navigation.e) obj2);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                br.k(c18004nv2, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 6);
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.GR
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return BR.c.d(this.a, sa2, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    static final class d implements LX7 {
        final /* synthetic */ boolean a;
        final /* synthetic */ BR b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ TR d;

        d(boolean z, BR br, SA2 sa2, TR tr) {
            this.a = z;
            this.b = br;
            this.c = sa2;
            this.d = tr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(final SA2 sa2, TR tr, final UA2 ua2, final SA2 sa22, C8120Up4 c8120Up4, androidx.navigation.e eVar) {
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(tr, "$sourceType");
            AbstractC13042fc3.i(ua2, "$notifier");
            AbstractC13042fc3.i(sa22, "$onValidationComplete");
            AbstractC13042fc3.i(c8120Up4, "$this$BasedNavController");
            AbstractC13042fc3.i(eVar, "navController");
            AbstractC21941uO7.f(c8120Up4, eVar, sa2, new SA2() { // from class: ir.nasim.JR
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return BR.d.e(ua2, sa22, sa2);
                }
            }, tr, null, 16, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 e(UA2 ua2, SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(ua2, "$notifier");
            AbstractC13042fc3.i(sa2, "$onValidationComplete");
            AbstractC13042fc3.i(sa22, "$onBackPressed");
            ua2.invoke(AbstractC23348wm0.b(AbstractC4616Fw7.a("AuthenticationResult_Key", Boolean.TRUE)));
            sa2.invoke();
            sa22.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(d dVar, SA2 sa2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(dVar, "$tmp1_rcvr");
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(ua2, "$notifier");
            dVar.I(sa2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
            return C19938rB7.a;
        }

        @Override // ir.nasim.LX7
        public final void I(final SA2 sa2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
            int i2;
            AbstractC13042fc3.i(sa2, "onBackPressed");
            AbstractC13042fc3.i(ua2, "notifier");
            InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1040480354);
            if ((i & 6) == 0) {
                i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= interfaceC22053ub1J.V(this) ? 256 : 128;
            }
            if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
                interfaceC22053ub1J.L();
            } else {
                RR rr = this.a ? C12946fS.a : C22531vO7.a;
                BR br = this.b;
                interfaceC22053ub1J.W(1668898291);
                boolean zV = ((i2 & 14) == 4) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.V(this.c) | interfaceC22053ub1J.D(this.d);
                final TR tr = this.d;
                final SA2 sa22 = this.c;
                Object objB = interfaceC22053ub1J.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new InterfaceC14603iB2() { // from class: ir.nasim.HR
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return BR.d.d(sa2, tr, ua2, sa22, (C8120Up4) obj, (androidx.navigation.e) obj2);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                br.k(rr, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 0);
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.IR
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return BR.d.f(this.a, sa2, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(final RR rr, final InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1231929111);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(rr) : interfaceC22053ub1J.D(rr) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(789619662, true, new a(rr, interfaceC14603iB2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xR
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return BR.l(this.a, rr, interfaceC14603iB2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(BR br, RR rr, InterfaceC14603iB2 interfaceC14603iB2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(br, "$tmp0_rcvr");
        AbstractC13042fc3.i(rr, "$startDestination");
        AbstractC13042fc3.i(interfaceC14603iB2, "$builder");
        br.k(rr, interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC23146wR
    public Fragment d(String str, TR tr, boolean z, boolean z2, SA2 sa2) {
        AbstractC13042fc3.i(tr, "sourceType");
        AbstractC13042fc3.i(sa2, "onCreatePasswordComplete");
        return MX7.INSTANCE.a(str, new b(z, sa2, tr, z2));
    }

    @Override // ir.nasim.InterfaceC23146wR
    public Fragment f(String str, TR tr, boolean z, boolean z2, SA2 sa2) {
        AbstractC13042fc3.i(tr, "sourceType");
        AbstractC13042fc3.i(sa2, "onValidationComplete");
        return MX7.INSTANCE.a(str, new d(z2, this, sa2, tr));
    }

    @Override // ir.nasim.InterfaceC23146wR
    public Fragment h(SA2 sa2, TR tr, String str, SA2 sa22) {
        AbstractC13042fc3.i(sa2, "onValidationComplete");
        AbstractC13042fc3.i(tr, "sourceType");
        AbstractC13042fc3.i(str, "notifierKey");
        AbstractC13042fc3.i(sa22, "onDeletePassword");
        return MX7.INSTANCE.a(str, new c(sa2, tr, sa22));
    }
}
