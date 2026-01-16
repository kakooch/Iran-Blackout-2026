package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC13709gh2;
import ir.nasim.C24254yJ;
import ir.nasim.PS0;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.gh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC13709gh2 {

    /* renamed from: ir.nasim.gh2$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ List a;
        final /* synthetic */ androidx.compose.ui.e b;
        final /* synthetic */ int c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ SA2 e;

        /* renamed from: ir.nasim.gh2$a$a, reason: collision with other inner class name */
        static final class C1255a implements InterfaceC16978mB2 {
            final /* synthetic */ List a;
            final /* synthetic */ androidx.compose.ui.e b;
            final /* synthetic */ int c;
            final /* synthetic */ UA2 d;

            C1255a(List list, androidx.compose.ui.e eVar, int i, UA2 ua2) {
                this.a = list;
                this.b = eVar;
                this.c = i;
                this.d = ua2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(UA2 ua2, List list, C9046Yg2 c9046Yg2) {
                AbstractC13042fc3.i(c9046Yg2, "$currentItem");
                ua2.invoke(Integer.valueOf(list.indexOf(c9046Yg2)));
                return C19938rB7.a;
            }

            public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                if ((i2 & 48) == 0) {
                    i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final C9046Yg2 c9046Yg2 = (C9046Yg2) this.a.get(i);
                if (!(!AbstractC20762sZ6.n0(c9046Yg2.c())) || !(!AbstractC20762sZ6.n0(c9046Yg2.b())) || c9046Yg2.c().length() <= 0 || c9046Yg2.b().length() <= 0) {
                    return;
                }
                PS0.a aVar = new PS0.a(null, 1, null);
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.q.k(this.b, 0.0f, 0.0f, 3, null), C17784nZ1.q(36));
                boolean z = this.c == this.a.indexOf(c9046Yg2);
                String strC = JF5.g() ? c9046Yg2.c() : c9046Yg2.b();
                interfaceC22053ub1.W(-257769754);
                boolean zV = interfaceC22053ub1.V(this.d) | interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(c9046Yg2);
                final UA2 ua2 = this.d;
                final List list = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.fh2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC13709gh2.a.C1255a.c(ua2, list, c9046Yg2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                NS0.f(eVarI, z, (SA2) objB, false, strC, aVar, 0L, interfaceC22053ub1, PS0.a.b << 15, 72);
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.gh2$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19206px3 c;
            final /* synthetic */ SA2 d;

            /* renamed from: ir.nasim.gh2$a$b$a, reason: collision with other inner class name */
            static final class C1256a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ C9663aL5 d;
                final /* synthetic */ SA2 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1256a(C9663aL5 c9663aL5, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c9663aL5;
                    this.e = sa2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1256a c1256a = new C1256a(this.d, this.e, interfaceC20295rm1);
                    c1256a.c = ((Boolean) obj).booleanValue();
                    return c1256a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    boolean z = this.c;
                    if (!z && this.d.a) {
                        this.e.invoke();
                    }
                    this.d.a = z;
                    return C19938rB7.a;
                }

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1256a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C19206px3 c19206px3, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19206px3;
                this.d = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean y(C19206px3 c19206px3) {
                return c19206px3.c();
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
                    C9663aL5 c9663aL5 = new C9663aL5();
                    final C19206px3 c19206px3 = this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC10222bH6.r(new SA2() { // from class: ir.nasim.hh2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return Boolean.valueOf(AbstractC13709gh2.a.b.y(c19206px3));
                        }
                    });
                    C1256a c1256a = new C1256a(c9663aL5, this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2R, c1256a, this) == objE) {
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.gh2$a$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19206px3 c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C19206px3 c19206px3, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19206px3;
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object next;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    List listI = this.c.x().i();
                    InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) AbstractC15401jX0.s0(listI);
                    if (interfaceC7948Tw3 == null) {
                        return C19938rB7.a;
                    }
                    int index = interfaceC7948Tw3.getIndex();
                    InterfaceC7948Tw3 interfaceC7948Tw32 = (InterfaceC7948Tw3) AbstractC15401jX0.F0(listI);
                    if (interfaceC7948Tw32 == null) {
                        return C19938rB7.a;
                    }
                    int index2 = interfaceC7948Tw32.getIndex();
                    int i2 = this.d;
                    if (index > i2 || i2 > index2) {
                        int iD = (this.c.x().d() - this.c.x().f()) / 2;
                        this.b = 2;
                        if (this.c.k(this.d, -iD, this) == objE) {
                            return objE;
                        }
                    } else {
                        Iterator it = listI.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (((InterfaceC7948Tw3) next).getIndex() == i2) {
                                break;
                            }
                        }
                        InterfaceC7948Tw3 interfaceC7948Tw33 = (InterfaceC7948Tw3) next;
                        if (interfaceC7948Tw33 != null) {
                            int offset = (interfaceC7948Tw33.getOffset() + (interfaceC7948Tw33.f() / 2)) - ((this.c.x().f() + this.c.x().d()) / 2);
                            this.b = 1;
                            if (AbstractC7778Td6.b(this.c, offset, null, this, 2, null) == objE) {
                                return objE;
                            }
                        }
                    }
                } else {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(List list, androidx.compose.ui.e eVar, int i, UA2 ua2, SA2 sa2) {
            this.a = list;
            this.b = eVar;
            this.c = i;
            this.d = ua2;
            this.e = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, androidx.compose.ui.e eVar, int i, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
            InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), null, null, AbstractC19242q11.c(-2069719761, true, new C1255a(list, eVar, i, ua2)), 6, null);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C19206px3 c19206px3B = AbstractC19797qx3.b(0, 0, interfaceC22053ub1, 0, 3);
            if (!this.a.isEmpty()) {
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(this.b, 0.0f, 1, null), C17784nZ1.q(12), 0.0f, 0.0f, 0.0f, 14, null);
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.b.d(eVarM, g10.a(interfaceC22053ub1, i2).r(), null, 2, null), C17784nZ1.q(60));
                TS4 ts4E = androidx.compose.foundation.layout.q.e(0.0f, g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().c(), 1, null);
                C24254yJ.f fVarO = C24254yJ.a.o(C17784nZ1.q(8));
                interfaceC22053ub1.W(-1007786699);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.e(this.c) | interfaceC22053ub1.V(this.d);
                final List list = this.a;
                final androidx.compose.ui.e eVar = this.b;
                final int i3 = this.c;
                final UA2 ua2 = this.d;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.eh2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC13709gh2.a.c(list, eVar, i3, ua2, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.d(eVarI, c19206px3B, ts4E, false, fVarO, null, null, false, null, (UA2) objB, interfaceC22053ub1, 24576, 488);
                interfaceC22053ub1.W(-1007749640);
                boolean zV = interfaceC22053ub1.V(c19206px3B) | interfaceC22053ub1.V(this.e);
                SA2 sa2 = this.e;
                Object objB2 = interfaceC22053ub1.B();
                if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new b(c19206px3B, sa2, null);
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(c19206px3B, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
                Integer numValueOf = Integer.valueOf(this.c);
                interfaceC22053ub1.W(-1007736343);
                boolean zV2 = interfaceC22053ub1.V(c19206px3B) | interfaceC22053ub1.e(this.c);
                int i4 = this.c;
                Object objB3 = interfaceC22053ub1.B();
                if (zV2 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new c(c19206px3B, i4, null);
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(numValueOf, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-682977668);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            g(null, AbstractC9766aX0.e(new C9046Yg2(1, "همه", "All")), null, 0, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 21);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ah2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13709gh2.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(androidx.compose.ui.e r14, java.util.List r15, ir.nasim.UA2 r16, int r17, ir.nasim.SA2 r18, ir.nasim.InterfaceC22053ub1 r19, final int r20, final int r21) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13709gh2.g(androidx.compose.ui.e, java.util.List, ir.nasim.UA2, int, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(int i) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(androidx.compose.ui.e eVar, List list, UA2 ua2, int i, SA2 sa2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        g(eVar, list, ua2, i, sa2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }
}
