package ir.nasim;

import ir.nasim.AbstractC18874pP;
import ir.nasim.C18787pF2;
import ir.nasim.InterfaceC10876cM;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.pF2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18787pF2 {
    private final InterfaceC11621dJ7 a;
    private final KM2 b;

    /* renamed from: ir.nasim.pF2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.pF2$a$a, reason: collision with other inner class name */
        public static final class C1436a extends AbstractC17683nO {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ C18787pF2 b;
            final /* synthetic */ InterfaceC16204ks5 c;

            C1436a(C12889fL5 c12889fL5, C18787pF2 c18787pF2, InterfaceC16204ks5 interfaceC16204ks5) {
                this.a = c12889fL5;
                this.b = c18787pF2;
                this.c = interfaceC16204ks5;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C22505vM q(C18787pF2 c18787pF2, VL vl, C22505vM c22505vM) {
                AbstractC13042fc3.i(c18787pF2, "this$0");
                AbstractC13042fc3.i(c22505vM, "<unused var>");
                return c18787pF2.d(C23709xO.a, vl);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C22505vM r(C18787pF2 c18787pF2, AbstractC18874pP abstractC18874pP, C22505vM c22505vM) {
                AbstractC13042fc3.i(c18787pF2, "this$0");
                AbstractC13042fc3.i(abstractC18874pP, "$audioSpeedMode");
                AbstractC13042fc3.i(c22505vM, "currentState");
                return C22505vM.b(c22505vM, c18787pF2.c(abstractC18874pP), null, null, 6, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C22505vM s(C22505vM c22505vM) {
                AbstractC13042fc3.i(c22505vM, "<unused var>");
                return null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C22505vM t(C22505vM c22505vM) {
                AbstractC13042fc3.i(c22505vM, "<unused var>");
                return null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C22505vM u(C22505vM c22505vM) {
                AbstractC13042fc3.i(c22505vM, "currentState");
                return C22505vM.b(c22505vM, null, null, EnumC20638sM.b, 3, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C22505vM v(C22505vM c22505vM) {
                AbstractC13042fc3.i(c22505vM, "currentState");
                return C22505vM.b(c22505vM, null, null, EnumC20638sM.a, 3, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C22505vM w(C18787pF2 c18787pF2, C22505vM c22505vM) {
                AbstractC13042fc3.i(c18787pF2, "this$0");
                AbstractC13042fc3.i(c22505vM, "currentState");
                return C22505vM.b(c22505vM, null, c22505vM.c().a(r7.O() / r7.R()), C23709xO.a.i() ? EnumC20638sM.a : EnumC20638sM.b, 1, null);
            }

            @Override // ir.nasim.AbstractC17683nO
            public void a(final VL vl) {
                C12889fL5 c12889fL5 = this.a;
                final C18787pF2 c18787pF2 = this.b;
                a.D(c12889fL5, c18787pF2, this.c, new UA2() { // from class: ir.nasim.lF2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C18787pF2.a.C1436a.q(c18787pF2, vl, (C22505vM) obj);
                    }
                });
            }

            @Override // ir.nasim.AbstractC17683nO
            public void b(final AbstractC18874pP abstractC18874pP) {
                AbstractC13042fc3.i(abstractC18874pP, "audioSpeedMode");
                C12889fL5 c12889fL5 = this.a;
                final C18787pF2 c18787pF2 = this.b;
                a.D(c12889fL5, c18787pF2, this.c, new UA2() { // from class: ir.nasim.jF2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C18787pF2.a.C1436a.r(c18787pF2, abstractC18874pP, (C22505vM) obj);
                    }
                });
            }

            @Override // ir.nasim.AbstractC17683nO
            public void c(VL vl) {
                AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
                a.D(this.a, this.b, this.c, new UA2() { // from class: ir.nasim.kF2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C18787pF2.a.C1436a.s((C22505vM) obj);
                    }
                });
            }

            @Override // ir.nasim.AbstractC17683nO
            public void e() {
                a.D(this.a, this.b, this.c, new UA2() { // from class: ir.nasim.nF2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C18787pF2.a.C1436a.t((C22505vM) obj);
                    }
                });
            }

            @Override // ir.nasim.AbstractC17683nO
            public void f(VL vl) {
                AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
                a.D(this.a, this.b, this.c, new UA2() { // from class: ir.nasim.mF2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C18787pF2.a.C1436a.u((C22505vM) obj);
                    }
                });
            }

            @Override // ir.nasim.AbstractC17683nO
            public void g(VL vl) {
                AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
                a.D(this.a, this.b, this.c, new UA2() { // from class: ir.nasim.iF2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C18787pF2.a.C1436a.v((C22505vM) obj);
                    }
                });
            }

            @Override // ir.nasim.AbstractC17683nO
            public void h(VL vl, long j) {
                AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
                C12889fL5 c12889fL5 = this.a;
                final C18787pF2 c18787pF2 = this.b;
                a.D(c12889fL5, c18787pF2, this.c, new UA2() { // from class: ir.nasim.oF2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C18787pF2.a.C1436a.w(c18787pF2, (C22505vM) obj);
                    }
                });
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(C12889fL5 c12889fL5, C18787pF2 c18787pF2, InterfaceC16204ks5 interfaceC16204ks5, UA2 ua2) {
            C22505vM c22505vME = (C22505vM) c12889fL5.a;
            if (c22505vME == null) {
                c22505vME = C18787pF2.e(c18787pF2, C23709xO.a, null, 1, null);
            }
            C22505vM c22505vM = c22505vME != null ? (C22505vM) ua2.invoke(c22505vME) : null;
            c12889fL5.a = c22505vM;
            interfaceC16204ks5.h(new C17092mO(C23709xO.a.M(), c22505vM));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(C1436a c1436a) {
            C23709xO.a.z0(c1436a);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C18787pF2.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final C1436a c1436a = new C1436a(new C12889fL5(), C18787pF2.this, interfaceC16204ks5);
                C23709xO.a.u(c1436a);
                SA2 sa2 = new SA2() { // from class: ir.nasim.hF2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C18787pF2.a.z(c1436a);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C18787pF2(InterfaceC11621dJ7 interfaceC11621dJ7, KM2 km2) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(km2, "groupRepository");
        this.a = interfaceC11621dJ7;
        this.b = km2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnumC21915uM c(AbstractC18874pP abstractC18874pP) {
        if (abstractC18874pP instanceof AbstractC18874pP.a) {
            return EnumC21915uM.a;
        }
        if (abstractC18874pP instanceof AbstractC18874pP.b) {
            return EnumC21915uM.c;
        }
        if (abstractC18874pP instanceof AbstractC18874pP.c) {
            return EnumC21915uM.b;
        }
        if (abstractC18874pP instanceof AbstractC18874pP.d) {
            return EnumC21915uM.d;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C22505vM d(C23709xO c23709xO, VL vl) {
        InterfaceC10876cM bVar;
        if (vl instanceof C8552Wl4) {
            C8552Wl4 c8552Wl4 = (C8552Wl4) vl;
            bVar = new InterfaceC10876cM.a(c8552Wl4.h(), c8552Wl4.j(), c23709xO.O() / c23709xO.R());
        } else {
            if (!(vl instanceof QZ7)) {
                if (vl == null) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            bVar = new InterfaceC10876cM.b(f((QZ7) vl), c23709xO.O() / c23709xO.R());
        }
        return new C22505vM(c(c23709xO.K()), bVar, c23709xO.i() ? EnumC20638sM.a : EnumC20638sM.b);
    }

    static /* synthetic */ C22505vM e(C18787pF2 c18787pF2, C23709xO c23709xO, VL vl, int i, Object obj) {
        if ((i & 1) != 0) {
            vl = c23709xO.M();
        }
        return c18787pF2.d(c23709xO, vl);
    }

    private final String f(QZ7 qz7) {
        String name;
        C17637nI7 c17637nI7P = this.a.p(qz7.h());
        if (c17637nI7P != null && (name = c17637nI7P.getName()) != null) {
            return name;
        }
        C14697iL2 c14697iL2B = this.b.b(qz7.d().e().getPeerId());
        String strG0 = c14697iL2B != null ? c14697iL2B.G0() : null;
        return strG0 == null ? "" : strG0;
    }

    public final InterfaceC4557Fq2 g() {
        return AbstractC6459Nq2.f(new a(null));
    }
}
