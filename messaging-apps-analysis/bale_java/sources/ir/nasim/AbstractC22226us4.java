package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.platform.ComposeView;

/* renamed from: ir.nasim.us4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22226us4 {

    /* renamed from: ir.nasim.us4$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ InterfaceC10258bL6 c;

        /* renamed from: ir.nasim.us4$a$a, reason: collision with other inner class name */
        static final class C1642a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;
            final /* synthetic */ UA2 b;
            final /* synthetic */ InterfaceC10258bL6 c;

            /* renamed from: ir.nasim.us4$a$a$a, reason: collision with other inner class name */
            static final class C1643a implements InterfaceC14603iB2 {
                final /* synthetic */ SA2 a;
                final /* synthetic */ UA2 b;
                final /* synthetic */ InterfaceC10258bL6 c;

                /* renamed from: ir.nasim.us4$a$a$a$a, reason: collision with other inner class name */
                static final class C1644a implements InterfaceC14603iB2 {
                    final /* synthetic */ SA2 a;
                    final /* synthetic */ UA2 b;
                    final /* synthetic */ InterfaceC10258bL6 c;

                    C1644a(SA2 sa2, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6) {
                        this.a = sa2;
                        this.b = ua2;
                        this.c = interfaceC10258bL6;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else {
                            AbstractC23412ws4.b(this.a, this.b, this.c, interfaceC22053ub1, 0);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C1643a(SA2 sa2, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6) {
                    this.a = sa2;
                    this.b = ua2;
                    this.c = interfaceC10258bL6;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        F27.a(null, null, 0L, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(-286620952, true, new C1644a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 12582912, 127);
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            C1642a(SA2 sa2, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6) {
                this.a = sa2;
                this.b = ua2;
                this.c = interfaceC10258bL6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(-462315229, true, new C1643a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6) {
            this.a = sa2;
            this.b = ua2;
            this.c = interfaceC10258bL6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC17159mV3.a(null, null, null, AbstractC19242q11.e(571444707, true, new C1642a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 7);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(ComposeView composeView, SA2 sa2, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(composeView, "<this>");
        AbstractC13042fc3.i(sa2, "onBarClicked");
        AbstractC13042fc3.i(ua2, "onJoinCallClicked");
        AbstractC13042fc3.i(interfaceC10258bL6, "callBarStateFlow");
        composeView.setContent(AbstractC19242q11.c(1894868751, true, new a(sa2, ua2, interfaceC10258bL6)));
    }
}
