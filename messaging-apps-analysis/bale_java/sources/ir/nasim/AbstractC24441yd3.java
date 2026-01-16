package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.A98;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC24441yd3;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.chat.ChatViewModel;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.yd3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC24441yd3 {

    /* renamed from: ir.nasim.yd3$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1382270886);
            A98.a aVar = A98.a;
            A98 a98H = AbstractC21393ta8.h(AbstractC24416ya8.c(aVar, interfaceC22053ub1, 6), AbstractC24416ya8.b(aVar, interfaceC22053ub1, 6));
            interfaceC22053ub1.Q();
            return a98H;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.yd3$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ ChatViewModel a;
        final /* synthetic */ InterfaceC20315ro1 b;
        final /* synthetic */ C19818qz6 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ W25 e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ String h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ ZN2 j;

        /* renamed from: ir.nasim.yd3$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.yd3$b$b, reason: collision with other inner class name */
        static final class C1791b implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC9664aL6 a;
            final /* synthetic */ ChatViewModel b;

            /* renamed from: ir.nasim.yd3$b$b$a */
            static final class a implements InterfaceC16978mB2 {
                final /* synthetic */ InterfaceC9664aL6 a;
                final /* synthetic */ ChatViewModel b;

                /* renamed from: ir.nasim.yd3$b$b$a$a, reason: collision with other inner class name */
                static final class C1792a implements InterfaceC14603iB2 {
                    final /* synthetic */ BI7 a;

                    C1792a(BI7 bi7) {
                        this.a = bi7;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(this.a.c(), null, false, 0, interfaceC22053ub1, 0, 14), null, AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(50.0f)), N46.g()), this.a.d(), this.a.f(), 0.0f, false, null, 28, null), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1, 24624, 104);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                a(InterfaceC9664aL6 interfaceC9664aL6, ChatViewModel chatViewModel) {
                    this.a = interfaceC9664aL6;
                    this.b = chatViewModel;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(ChatViewModel chatViewModel, BI7 bi7) {
                    AbstractC13042fc3.i(chatViewModel, "$viewModel");
                    AbstractC13042fc3.i(bi7, "$it");
                    chatViewModel.Na(bi7.d());
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(ChatViewModel chatViewModel, BI7 bi7, boolean z) {
                    AbstractC13042fc3.i(chatViewModel, "$viewModel");
                    AbstractC13042fc3.i(bi7, "$it");
                    chatViewModel.Na(bi7.d());
                    return C19938rB7.a;
                }

                public final void c(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    String strC;
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                    if ((i2 & 48) == 0) {
                        i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
                    }
                    if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    Object obj = ((List) this.a.getValue()).get(i);
                    final ChatViewModel chatViewModel = this.b;
                    final BI7 bi7 = (BI7) obj;
                    if (bi7.g()) {
                        interfaceC22053ub1.W(1216506893);
                        strC = UY6.c(AbstractC12217eE5.members_adapter_bot_online_status, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    } else {
                        interfaceC22053ub1.W(1216641433);
                        strC = (String) AbstractC10222bH6.a(bi7.e(), "", null, interfaceC22053ub1, 48, 2).getValue();
                        interfaceC22053ub1.Q();
                    }
                    String str = strC;
                    e.a aVar = androidx.compose.ui.e.a;
                    interfaceC22053ub1.W(-792029911);
                    boolean zD = interfaceC22053ub1.D(chatViewModel) | interfaceC22053ub1.V(bi7);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Id3
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC24441yd3.b.C1791b.a.d(chatViewModel, bi7);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null);
                    boolean zH = bi7.h();
                    String strF = bi7.f();
                    InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1876886049, true, new C1792a(bi7), interfaceC22053ub1, 54);
                    interfaceC22053ub1.W(-792024370);
                    boolean zD2 = interfaceC22053ub1.D(chatViewModel) | interfaceC22053ub1.V(bi7);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new UA2() { // from class: ir.nasim.Jd3
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return AbstractC24441yd3.b.C1791b.a.f(chatViewModel, bi7, ((Boolean) obj2).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC24459yf1.C(eVarF, strF, str, interfaceC18060o11E, false, zH, (UA2) objB2, true, interfaceC22053ub1, 12585984, 16);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    c((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            C1791b(InterfaceC9664aL6 interfaceC9664aL6, ChatViewModel chatViewModel) {
                this.a = interfaceC9664aL6;
                this.b = chatViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(InterfaceC9664aL6 interfaceC9664aL6, ChatViewModel chatViewModel, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(interfaceC9664aL6, "$users");
                AbstractC13042fc3.i(chatViewModel, "$viewModel");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.g(interfaceC15069ix3, ((List) interfaceC9664aL6.getValue()).size(), null, null, AbstractC19242q11.c(1027166732, true, new a(interfaceC9664aL6, chatViewModel)), 6, null);
                return C19938rB7.a;
            }

            public final void b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                AbstractC13042fc3.i(eVar, "modifier");
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-56649217);
                boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(this.b);
                final InterfaceC9664aL6 interfaceC9664aL6 = this.a;
                final ChatViewModel chatViewModel = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Hd3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC24441yd3.b.C1791b.c(interfaceC9664aL6, chatViewModel, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVar, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, i2 & 14, 510);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.yd3$b$c */
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

        b(ChatViewModel chatViewModel, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, SA2 sa2, W25 w25, String str, String str2, String str3, UA2 ua2, ZN2 zn2) {
            this.a = chatViewModel;
            this.b = interfaceC20315ro1;
            this.c = c19818qz6;
            this.d = sa2;
            this.e = w25;
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = ua2;
            this.j = zn2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(UA2 ua2, String str, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, final C19818qz6 c19818qz6, final SA2 sa2) {
            AbstractC13042fc3.i(ua2, "$onInviteUsers");
            AbstractC13042fc3.i(str, "$inviteLink");
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$messageString$delegate");
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismiss");
            ua2.invoke(p(interfaceC9102Ym4) + Separators.RETURN + str);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.Ed3
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC24441yd3.b.k(c19818qz6, sa2, (Throwable) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C19818qz6 c19818qz6, SA2 sa2, Throwable th) {
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismiss");
            if (!c19818qz6.k()) {
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final SA2 sa2) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismiss");
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.Fd3
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC24441yd3.b.o(c19818qz6, sa2, (Throwable) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(C19818qz6 c19818qz6, SA2 sa2, Throwable th) {
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismiss");
            if (!c19818qz6.k()) {
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        private static final String p(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (String) interfaceC9102Ym4.getValue();
        }

        private static final void t(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            interfaceC9102Ym4.setValue(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$messageString$delegate");
            AbstractC13042fc3.i(str, "it");
            t(interfaceC9102Ym4, str);
            return C19938rB7.a;
        }

        public final void h(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            InterfaceC19114po0 interfaceC19114po0;
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, 0.0f, AbstractC21393ta8.d(AbstractC24416ya8.g(A98.a, interfaceC22053ub1, 6), interfaceC22053ub1, 0).c(), 0.0f, 0.0f, 13, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(eVarM, g10.a(interfaceC22053ub1, i2).r(), N46.f(g10.c(interfaceC22053ub1, i2).a().b(), g10.c(interfaceC22053ub1, i2).a().b(), 0.0f, 0.0f, 12, null));
            ChatViewModel chatViewModel = this.a;
            final InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            final C19818qz6 c19818qz6 = this.c;
            final SA2 sa2 = this.d;
            W25 w25 = this.e;
            String str = this.f;
            String str2 = this.g;
            final String str3 = this.h;
            final UA2 ua2 = this.i;
            ZN2 zn2 = this.j;
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
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
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(17.61f), g10.c(interfaceC22053ub1, i2).b().f());
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
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(13.0f));
            interfaceC22053ub1.W(-56719803);
            boolean zD = interfaceC22053ub1.D(interfaceC20315ro1) | interfaceC22053ub1.V(c19818qz6) | interfaceC22053ub1.V(sa2);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.zd3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC24441yd3.b.n(interfaceC20315ro1, c19818qz6, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC11456d23.b(ev4C, null, androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.features_chat_invite_link_string, interfaceC22053ub1, 0), L66.b(m66, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65016);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(13.0f)), interfaceC22053ub1, 6);
            interfaceC22053ub1.u();
            MY2.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1.0f)), null, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
            AbstractC9339Zm7.b(UY6.c(chatViewModel.C6().size() == 1 ? AbstractC12217eE5.features_chat_invite_link_sheet_body_one : AbstractC12217eE5.features_chat_invite_link_sheet_body, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i2).b().c()), g10.a(interfaceC22053ub1, i2).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).b(), interfaceC22053ub1, 0, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().u()), interfaceC22053ub1, 0);
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(chatViewModel.B6(), null, interfaceC22053ub1, 0, 1);
            AbstractC7329Rg1.c(c9784aZ0.a(aVar, 1.0f, false), chatViewModel.C6().size(), ((List) interfaceC9664aL6B.getValue()).isEmpty(), AbstractC19242q11.e(697062122, true, new C1791b(interfaceC9664aL6B, chatViewModel), interfaceC22053ub1, 54), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0);
            Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            interfaceC22053ub1.W(416569205);
            Object objB2 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
            if (objB2 == aVar4.a()) {
                objB2 = AbstractC13472gH6.d(context.getString(AbstractC12217eE5.features_chat_invite_link_body_help, w25 == W25.a ? str : str2), null, 2, null);
                interfaceC22053ub1.s(objB2);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1.Q();
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1, 0);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().r()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.c(interfaceC22053ub1, i2).b().c(), 0.0f, 2, null);
            AbstractC14472hy4.d dVar = new AbstractC14472hy4.d(null, null, null, 7, null);
            String strP = p(interfaceC9102Ym4);
            String strC = UY6.c(AbstractC12217eE5.features_chat_invite_link_title_help, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-56545855);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar4.a()) {
                objB3 = new UA2() { // from class: ir.nasim.Bd3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC24441yd3.b.v(interfaceC9102Ym4, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.v0(strP, (UA2) objB3, strC, str3, eVarK, dVar, null, null, false, 0, 0, interfaceC22053ub1, (AbstractC14472hy4.d.e << 15) | 100663344, 0, 1728);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(23.0f)), interfaceC22053ub1, 6);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub1, i2).r(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A3 = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1, 0);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            SA2 sa2A4 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A4);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3A3, aVar3.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar3.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar3.f());
            MY2.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1.0f)), null, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i2).b().c()), 0.0f, 1, null);
            interfaceC22053ub1.W(-56513839);
            boolean zV = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.V(str3) | interfaceC22053ub1.D(interfaceC20315ro1) | interfaceC22053ub1.V(c19818qz6) | interfaceC22053ub1.V(sa2);
            Object objB4 = interfaceC22053ub1.B();
            if (zV || objB4 == aVar4.a()) {
                Object obj = new SA2() { // from class: ir.nasim.Dd3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC24441yd3.b.i(ua2, str3, interfaceC20315ro1, interfaceC9102Ym4, c19818qz6, sa2);
                    }
                };
                interfaceC22053ub1.s(obj);
                objB4 = obj;
            }
            SA2 sa22 = (SA2) objB4;
            interfaceC22053ub1.Q();
            Iterable iterable = (Iterable) interfaceC9664aL6B.getValue();
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                interfaceC19114po0 = InterfaceC19114po0.a.C1453a.a;
            } else {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    if (((BI7) it.next()).h()) {
                        interfaceC19114po0 = InterfaceC19114po0.b.a.a;
                        break;
                    }
                }
                interfaceC19114po0 = InterfaceC19114po0.a.C1453a.a;
            }
            AbstractC17932no0.y(eVarH, sa22, interfaceC19114po0, null, UY6.c(zn2 == ZN2.GROUP ? AbstractC12217eE5.features_chat_invite_link_button_help_group : AbstractC12217eE5.features_chat_invite_link_button_help_channel, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 40);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            h((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final boolean r36, final java.lang.String r37, final ir.nasim.ZN2 r38, final ir.nasim.W25 r39, final java.lang.String r40, final java.lang.String r41, final ir.nasim.chat.ChatViewModel r42, final ir.nasim.SA2 r43, final ir.nasim.UA2 r44, ir.nasim.InterfaceC22053ub1 r45, final int r46) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24441yd3.b(boolean, java.lang.String, ir.nasim.ZN2, ir.nasim.W25, java.lang.String, java.lang.String, ir.nasim.chat.ChatViewModel, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(boolean z, String str, ZN2 zn2, W25 w25, String str2, String str3, ChatViewModel chatViewModel, SA2 sa2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$inviteLink");
        AbstractC13042fc3.i(zn2, "$groupType");
        AbstractC13042fc3.i(w25, "$peerType");
        AbstractC13042fc3.i(str2, "$userName");
        AbstractC13042fc3.i(str3, "$groupName");
        AbstractC13042fc3.i(chatViewModel, "$viewModel");
        AbstractC13042fc3.i(sa2, "$onDismiss");
        AbstractC13042fc3.i(ua2, "$onInviteUsers");
        b(z, str, zn2, w25, str2, str3, chatViewModel, sa2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
