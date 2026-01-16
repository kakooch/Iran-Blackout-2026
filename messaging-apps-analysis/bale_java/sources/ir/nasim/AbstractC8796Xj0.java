package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC8796Xj0;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import java.util.List;

/* renamed from: ir.nasim.Xj0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8796Xj0 {

    /* renamed from: ir.nasim.Xj0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ C19818qz6 b;
        final /* synthetic */ InterfaceC20315ro1 c;
        final /* synthetic */ List d;
        final /* synthetic */ UA2 e;

        /* renamed from: ir.nasim.Xj0$a$a, reason: collision with other inner class name */
        static final class C0763a implements InterfaceC14603iB2 {
            public static final C0763a a = new C0763a();

            C0763a() {
            }

            public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(1490477181);
                A98 a98G = AbstractC21393ta8.g(C8062Uj0.a.g(interfaceC22053ub1, 6), AbstractC23236wa8.a.e());
                interfaceC22053ub1.Q();
                return a98G;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            }
        }

        /* renamed from: ir.nasim.Xj0$a$b */
        static final class b implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC20315ro1 a;
            final /* synthetic */ C19818qz6 b;
            final /* synthetic */ UA2 c;
            final /* synthetic */ List d;
            final /* synthetic */ UA2 e;

            /* renamed from: ir.nasim.Xj0$a$b$a, reason: collision with other inner class name */
            static final class C0764a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19818qz6 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0764a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19818qz6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0764a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C19818qz6 c19818qz6 = this.c;
                        this.b = 1;
                        if (c19818qz6.j(this) == objE) {
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
                    return ((C0764a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Xj0$a$b$b, reason: collision with other inner class name */
            static final class C0765b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19818qz6 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0765b(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19818qz6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0765b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C19818qz6 c19818qz6 = this.c;
                        this.b = 1;
                        if (c19818qz6.j(this) == objE) {
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
                    return ((C0765b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Xj0$a$b$c */
            static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19818qz6 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19818qz6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new c(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C19818qz6 c19818qz6 = this.c;
                        this.b = 1;
                        if (c19818qz6.j(this) == objE) {
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
                    return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Xj0$a$b$d */
            public /* synthetic */ class d {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[SQ.values().length];
                    try {
                        iArr[SQ.b.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SQ.d.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SQ.e.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[SQ.f.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[SQ.g.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[SQ.j.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[SQ.l.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    a = iArr;
                }
            }

            b(InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, UA2 ua2, List list, UA2 ua22) {
                this.a = interfaceC20315ro1;
                this.b = c19818qz6;
                this.c = ua2;
                this.d = list;
                this.e = ua22;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, List list, final C19818qz6 c19818qz6, final UA2 ua22) {
                AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
                AbstractC13042fc3.i(ua2, "$onStartAuth");
                AbstractC13042fc3.i(list, "$availableType");
                AbstractC13042fc3.i(c19818qz6, "$sheetState");
                AbstractC13042fc3.i(ua22, "$onChangedShowing");
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C0765b(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.dk0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC8796Xj0.a.b.n(c19818qz6, ua22, (Throwable) obj);
                    }
                });
                ua2.invoke(list.get(0));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(C19818qz6 c19818qz6, UA2 ua2, Throwable th) {
                AbstractC13042fc3.i(c19818qz6, "$sheetState");
                AbstractC13042fc3.i(ua2, "$onChangedShowing");
                if (!c19818qz6.k()) {
                    ua2.invoke(Boolean.FALSE);
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, List list, final C19818qz6 c19818qz6, final UA2 ua22) {
                AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
                AbstractC13042fc3.i(ua2, "$onStartAuth");
                AbstractC13042fc3.i(list, "$availableType");
                AbstractC13042fc3.i(c19818qz6, "$sheetState");
                AbstractC13042fc3.i(ua22, "$onChangedShowing");
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.bk0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC8796Xj0.a.b.p(c19818qz6, ua22, (Throwable) obj);
                    }
                });
                ua2.invoke(list.get(1));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(C19818qz6 c19818qz6, UA2 ua2, Throwable th) {
                AbstractC13042fc3.i(c19818qz6, "$sheetState");
                AbstractC13042fc3.i(ua2, "$onChangedShowing");
                if (!c19818qz6.k()) {
                    ua2.invoke(Boolean.FALSE);
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 t(InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final UA2 ua2) {
                AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
                AbstractC13042fc3.i(c19818qz6, "$sheetState");
                AbstractC13042fc3.i(ua2, "$onChangedShowing");
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C0764a(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.ck0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC8796Xj0.a.b.v(c19818qz6, ua2, (Throwable) obj);
                    }
                });
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 v(C19818qz6 c19818qz6, UA2 ua2, Throwable th) {
                AbstractC13042fc3.i(c19818qz6, "$sheetState");
                AbstractC13042fc3.i(ua2, "$onChangedShowing");
                if (!c19818qz6.k()) {
                    ua2.invoke(Boolean.FALSE);
                }
                return C19938rB7.a;
            }

            public final void i(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                int i3;
                UA2 ua2;
                final UA2 ua22;
                C19818qz6 c19818qz6;
                InterfaceC20315ro1 interfaceC20315ro1;
                int i4;
                int i5;
                AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final InterfaceC20315ro1 interfaceC20315ro12 = this.a;
                final C19818qz6 c19818qz62 = this.b;
                final UA2 ua23 = this.c;
                final List list = this.d;
                final UA2 ua24 = this.e;
                e.a aVar = androidx.compose.ui.e.a;
                C24254yJ c24254yJ = C24254yJ.a;
                C24254yJ.m mVarH = c24254yJ.h();
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar3.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
                float fQ = C17784nZ1.q((float) 17.61d);
                G10 g10 = G10.a;
                int i6 = G10.b;
                androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarH, fQ, g10.c(interfaceC22053ub1, i6).b().f());
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1, 54);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
                SA2 sa2A2 = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A2);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                M66 m66 = M66.a;
                EV4 ev4C = FV4.c(KB5.cross_search, interfaceC22053ub1, 0);
                String strC = UY6.c(AbstractC12217eE5.dialog_negative_button_cancel, interfaceC22053ub1, 0);
                float f = 13;
                androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f));
                interfaceC22053ub1.W(-1112153756);
                boolean zD = interfaceC22053ub1.D(interfaceC20315ro12) | interfaceC22053ub1.V(c19818qz62) | interfaceC22053ub1.V(ua23);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Yj0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8796Xj0.a.b.t(interfaceC20315ro12, c19818qz62, ua23);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC11456d23.b(ev4C, strC, androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), null, null, 0.0f, null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.enter_bale_code_string, interfaceC22053ub1, 0), L66.b(m66, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1, i6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i6).l(), interfaceC22053ub1, 0, 0, 65016);
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f)), interfaceC22053ub1, 6);
                interfaceC22053ub1.u();
                androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
                float f2 = 1;
                ZV1.b(androidx.compose.foundation.layout.t.y(eVarH2, C17784nZ1.q(f2)), 0.0f, g10.a(interfaceC22053ub1, i6).A(), interfaceC22053ub1, 6, 2);
                AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.enter_bale_bottom_sheet_body_selector, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i6).b().c()), g10.a(interfaceC22053ub1, i6).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i6).b(), interfaceC22053ub1, 0, 0, 65528);
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f2)), 0.0f, g10.a(interfaceC22053ub1, i6).A(), interfaceC22053ub1, 6, 2);
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.c(interfaceC22053ub1, i6).b().c());
                InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.o(g10.c(interfaceC22053ub1, i6).b().c()), aVar2.l(), interfaceC22053ub1, 0);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
                SA2 sa2A3 = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A3);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar3.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
                androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
                InterfaceC19114po0.b.a aVar4 = InterfaceC19114po0.b.a.a;
                SQ sq = (SQ) list.get(0);
                int[] iArr = d.a;
                switch (iArr[sq.ordinal()]) {
                    case 1:
                        i2 = AbstractC12217eE5.enter_bale_bootom_sheet_sms;
                        break;
                    case 2:
                        i2 = AbstractC12217eE5.enter_bale_bootom_sheet_sms;
                        break;
                    case 3:
                        i2 = AbstractC12217eE5.enter_bale_bootom_sheet_call;
                        break;
                    case 4:
                        i2 = AbstractC12217eE5.enter_bale_bootom_sheet_email;
                        break;
                    case 5:
                        i2 = AbstractC12217eE5.enter_bale_bootom_sheet_call;
                        break;
                    case 6:
                        i2 = AbstractC12217eE5.enter_bale_bootom_sheet_telegram;
                        break;
                    case 7:
                        i2 = AbstractC12217eE5.enter_bale_bootom_sheet_ussd;
                        break;
                    default:
                        i2 = AbstractC12217eE5.enter_bale_bootom_sheet_sms;
                        break;
                }
                String strC2 = UY6.c(i2, interfaceC22053ub1, 0);
                switch (iArr[((SQ) list.get(0)).ordinal()]) {
                    case 1:
                        i3 = KB5.sms;
                        break;
                    case 2:
                        i3 = KB5.sms;
                        break;
                    case 3:
                        i3 = KB5.call;
                        break;
                    case 4:
                        i3 = KB5.message;
                        break;
                    case 5:
                        i3 = KB5.call;
                        break;
                    case 6:
                        i3 = KB5.send;
                        break;
                    case 7:
                        i3 = KB5.ussd;
                        break;
                    default:
                        i3 = KB5.send;
                        break;
                }
                interfaceC22053ub1.W(-1112047832);
                boolean zD2 = interfaceC22053ub1.D(interfaceC20315ro12) | interfaceC22053ub1.V(c19818qz62) | interfaceC22053ub1.V(ua23) | interfaceC22053ub1.V(ua24) | interfaceC22053ub1.D(list);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    ua2 = ua24;
                    ua22 = ua23;
                    c19818qz6 = c19818qz62;
                    interfaceC20315ro1 = interfaceC20315ro12;
                    Object obj = new SA2() { // from class: ir.nasim.Zj0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8796Xj0.a.b.k(interfaceC20315ro12, ua24, list, c19818qz62, ua22);
                        }
                    };
                    interfaceC22053ub1.s(obj);
                    objB2 = obj;
                } else {
                    ua2 = ua24;
                    ua22 = ua23;
                    c19818qz6 = c19818qz62;
                    interfaceC20315ro1 = interfaceC20315ro12;
                }
                interfaceC22053ub1.Q();
                AbstractC17932no0.A((SA2) objB2, aVar4, strC2, eVarB, Integer.valueOf(i3), null, interfaceC22053ub1, InterfaceC19114po0.b.a.b << 3, 32);
                androidx.compose.ui.e eVarB2 = L66.b(m66, aVar, 1.0f, false, 2, null);
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                switch (iArr[((SQ) list.get(1)).ordinal()]) {
                    case 1:
                        i4 = AbstractC12217eE5.enter_bale_bootom_sheet_sms;
                        break;
                    case 2:
                        i4 = AbstractC12217eE5.enter_bale_bootom_sheet_sms;
                        break;
                    case 3:
                        i4 = AbstractC12217eE5.enter_bale_bootom_sheet_call;
                        break;
                    case 4:
                        i4 = AbstractC12217eE5.enter_bale_bootom_sheet_email;
                        break;
                    case 5:
                        i4 = AbstractC12217eE5.enter_bale_bootom_sheet_call;
                        break;
                    case 6:
                        i4 = AbstractC12217eE5.enter_bale_bootom_sheet_telegram;
                        break;
                    case 7:
                        i4 = AbstractC12217eE5.enter_bale_bootom_sheet_ussd;
                        break;
                    default:
                        i4 = AbstractC12217eE5.enter_bale_bootom_sheet_sms;
                        break;
                }
                String strC3 = UY6.c(i4, interfaceC22053ub1, 0);
                switch (iArr[((SQ) list.get(1)).ordinal()]) {
                    case 1:
                        i5 = KB5.sms;
                        break;
                    case 2:
                        i5 = KB5.sms;
                        break;
                    case 3:
                        i5 = KB5.call;
                        break;
                    case 4:
                        i5 = KB5.message;
                        break;
                    case 5:
                        i5 = KB5.call;
                        break;
                    case 6:
                        i5 = KB5.send;
                        break;
                    case 7:
                        i5 = KB5.ussd;
                        break;
                    default:
                        i5 = KB5.send;
                        break;
                }
                interfaceC22053ub1.W(-1111975320);
                final InterfaceC20315ro1 interfaceC20315ro13 = interfaceC20315ro1;
                final C19818qz6 c19818qz63 = c19818qz6;
                final UA2 ua25 = ua22;
                final UA2 ua26 = ua2;
                boolean zD3 = interfaceC22053ub1.D(interfaceC20315ro13) | interfaceC22053ub1.V(c19818qz63) | interfaceC22053ub1.V(ua25) | interfaceC22053ub1.V(ua26) | interfaceC22053ub1.D(list);
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    Object obj2 = new SA2() { // from class: ir.nasim.ak0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8796Xj0.a.b.o(interfaceC20315ro13, ua26, list, c19818qz63, ua25);
                        }
                    };
                    interfaceC22053ub1.s(obj2);
                    objB3 = obj2;
                }
                interfaceC22053ub1.Q();
                AbstractC17932no0.A((SA2) objB3, c1454b, strC3, eVarB2, Integer.valueOf(i5), null, interfaceC22053ub1, InterfaceC19114po0.b.C1454b.b << 3, 32);
                interfaceC22053ub1.u();
                ZH6.a(AbstractC23826xa8.a(aVar, AbstractC24416ya8.d(A98.a, interfaceC22053ub1, 6)), interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                i((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(UA2 ua2, C19818qz6 c19818qz6, InterfaceC20315ro1 interfaceC20315ro1, List list, UA2 ua22) {
            this.a = ua2;
            this.b = c19818qz6;
            this.c = interfaceC20315ro1;
            this.d = list;
            this.e = ua22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "$onChangedShowing");
            ua2.invoke(Boolean.FALSE);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            long jM = G10.a.a(interfaceC22053ub1, G10.b).M();
            interfaceC22053ub1.W(-949640212);
            boolean zV = interfaceC22053ub1.V(this.a);
            final UA2 ua2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Wj0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC8796Xj0.a.c(ua2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            C19818qz6 c19818qz6 = this.b;
            AbstractC9273Zf4.a((SA2) objB, eVarH, c19818qz6, 0.0f, null, jM, 0L, 0.0f, 0L, null, C0763a.a, null, AbstractC19242q11.e(-304990799, true, new b(this.c, c19818qz6, this.a, this.d, this.e), interfaceC22053ub1, 54), interfaceC22053ub1, 805306416, 384, 2520);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final java.util.List r23, final ir.nasim.UA2 r24, final ir.nasim.UA2 r25, ir.nasim.InterfaceC22053ub1 r26, final int r27) {
        /*
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r27
            java.lang.String r0 = "availableType"
            ir.nasim.AbstractC13042fc3.i(r6, r0)
            java.lang.String r0 = "onStartAuth"
            ir.nasim.AbstractC13042fc3.i(r7, r0)
            java.lang.String r0 = "onChangedShowing"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            r0 = 436156426(0x19ff380a, float:2.6389016E-23)
            r1 = r26
            ir.nasim.ub1 r14 = r1.j(r0)
            r0 = r9 & 6
            r1 = 2
            if (r0 != 0) goto L30
            boolean r0 = r14.D(r6)
            if (r0 == 0) goto L2d
            r0 = 4
            goto L2e
        L2d:
            r0 = r1
        L2e:
            r0 = r0 | r9
            goto L31
        L30:
            r0 = r9
        L31:
            r2 = r9 & 48
            if (r2 != 0) goto L41
            boolean r2 = r14.D(r7)
            if (r2 == 0) goto L3e
            r2 = 32
            goto L40
        L3e:
            r2 = 16
        L40:
            r0 = r0 | r2
        L41:
            r2 = r9 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L51
            boolean r2 = r14.D(r8)
            if (r2 == 0) goto L4e
            r2 = 256(0x100, float:3.59E-43)
            goto L50
        L4e:
            r2 = 128(0x80, float:1.8E-43)
        L50:
            r0 = r0 | r2
        L51:
            r0 = r0 & 147(0x93, float:2.06E-43)
            r2 = 146(0x92, float:2.05E-43)
            if (r0 != r2) goto L63
            boolean r0 = r14.k()
            if (r0 != 0) goto L5e
            goto L63
        L5e:
            r14.L()
        L61:
            r2 = r14
            goto Lb4
        L63:
            java.lang.Object r0 = r14.B()
            ir.nasim.ub1$a r2 = ir.nasim.InterfaceC22053ub1.a
            java.lang.Object r2 = r2.a()
            if (r0 != r2) goto L78
            ir.nasim.p72 r0 = ir.nasim.C18712p72.a
            ir.nasim.ro1 r0 = ir.nasim.AbstractC10721c52.k(r0, r14)
            r14.s(r0)
        L78:
            r3 = r0
            ir.nasim.ro1 r3 = (ir.nasim.InterfaceC20315ro1) r3
            r0 = 0
            r10 = 1
            r2 = 6
            ir.nasim.qz6 r2 = ir.nasim.AbstractC9273Zf4.l(r10, r0, r14, r2, r1)
            int r0 = r23.size()
            if (r0 <= r10) goto L61
            ir.nasim.Xj0$a r11 = new ir.nasim.Xj0$a
            r0 = r11
            r1 = r25
            r4 = r23
            r5 = r24
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 54
            r1 = -1190659052(0xffffffffb907fc14, float:-1.296851E-4)
            ir.nasim.o11 r19 = ir.nasim.AbstractC19242q11.e(r1, r10, r11, r14, r0)
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r22 = 127(0x7f, float:1.78E-43)
            r10 = 0
            r11 = 0
            r12 = 0
            r0 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r2 = r14
            r14 = r0
            r20 = r2
            ir.nasim.F27.a(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22)
        Lb4:
            ir.nasim.rd6 r0 = r2.m()
            if (r0 == 0) goto Lc2
            ir.nasim.Vj0 r1 = new ir.nasim.Vj0
            r1.<init>()
            r0.a(r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8796Xj0.b(java.util.List, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(List list, UA2 ua2, UA2 ua22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(list, "$availableType");
        AbstractC13042fc3.i(ua2, "$onStartAuth");
        AbstractC13042fc3.i(ua22, "$onChangedShowing");
        b(list, ua2, ua22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
