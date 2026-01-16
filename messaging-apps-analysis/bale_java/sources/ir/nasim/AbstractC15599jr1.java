package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.A98;
import ir.nasim.AbstractC15599jr1;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OA2;
import ir.nasim.PS0;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;

/* renamed from: ir.nasim.jr1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC15599jr1 {

    /* renamed from: ir.nasim.jr1$a */
    /* synthetic */ class a extends EB2 implements UA2 {
        a(Object obj) {
            super(1, obj, C20345rr1.class, "updateSearchQuery", "updateSearchQuery(Ljava/lang/String;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((String) obj);
            return C19938rB7.a;
        }

        public final void y(String str) {
            AbstractC13042fc3.i(str, "p0");
            ((C20345rr1) this.receiver).g1(str);
        }
    }

    /* renamed from: ir.nasim.jr1$b */
    /* synthetic */ class b extends EB2 implements UA2 {
        b(Object obj) {
            super(1, obj, C20345rr1.class, "setStateForSearch", "setStateForSearch(Lir/nasim/components/appbar/searchbar/SearchFocusState;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((AbstractC17858ng6) obj);
            return C19938rB7.a;
        }

        public final void y(AbstractC17858ng6 abstractC17858ng6) {
            AbstractC13042fc3.i(abstractC17858ng6, "p0");
            ((C20345rr1) this.receiver).d1(abstractC17858ng6);
        }
    }

    /* renamed from: ir.nasim.jr1$c */
    /* synthetic */ class c extends EB2 implements SA2 {
        c(Object obj) {
            super(0, obj, C20345rr1.class, "onKeyboardHasBeenClosed", "onKeyboardHasBeenClosed()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C20345rr1) this.receiver).c1();
        }
    }

    /* renamed from: ir.nasim.jr1$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ InterfaceC4557Fq2 c;
        final /* synthetic */ InterfaceC10258bL6 d;
        final /* synthetic */ String e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ AbstractC17858ng6 h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ SA2 j;

        /* renamed from: ir.nasim.jr1$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ int c;
            final /* synthetic */ SA2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = i;
                this.d = sa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c == 0) {
                    this.d.invoke();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.jr1$d$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            /* renamed from: ir.nasim.jr1$d$b$a */
            static final class a implements InterfaceC14603iB2 {
                final /* synthetic */ SA2 a;

                a(SA2 sa2) {
                    this.a = sa2;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        AbstractC21639ts7.i(UY6.c(BD5.call_log_option_create_group_call, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            b(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(716910862, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.jr1$d$c */
        static final class c implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ InterfaceC10258bL6 b;
            final /* synthetic */ String c;
            final /* synthetic */ UA2 d;
            final /* synthetic */ UA2 e;
            final /* synthetic */ AbstractC17858ng6 f;
            final /* synthetic */ UA2 g;
            final /* synthetic */ SA2 h;

            /* renamed from: ir.nasim.jr1$d$c$a */
            static final class a implements InterfaceC14603iB2 {
                final /* synthetic */ C22613vY a;

                a(C22613vY c22613vY) {
                    this.a = c22613vY;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(this.a.c(), null, false, 0, interfaceC22053ub1, 0, 14), null, AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, G10.b).b().j()), N46.g()), this.a.d(), this.a.f(), 0.0f, false, null, 28, null), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1, 24624, 104);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.jr1$d$c$b */
            static final class b implements InterfaceC14603iB2 {
                final /* synthetic */ UA2 a;
                final /* synthetic */ C22613vY b;

                /* renamed from: ir.nasim.jr1$d$c$b$a */
                static final class a implements SA2 {
                    final /* synthetic */ UA2 a;
                    final /* synthetic */ C22613vY b;

                    a(UA2 ua2, C22613vY c22613vY) {
                        this.a = ua2;
                        this.b = c22613vY;
                    }

                    public final void a() {
                        this.a.invoke(this.b);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                b(UA2 ua2, C22613vY c22613vY) {
                    this.a = ua2;
                    this.b = c22613vY;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    e.a aVar = androidx.compose.ui.e.a;
                    interfaceC22053ub1.W(388209967);
                    boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
                    UA2 ua2 = this.a;
                    C22613vY c22613vY = this.b;
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new a(ua2, c22613vY);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null);
                    G10 g10 = G10.a;
                    int i2 = G10.b;
                    androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(eVarF, g10.c(interfaceC22053ub1, i2).b().b());
                    AbstractC24077y03.b(FV4.c(KB5.cross_search, interfaceC22053ub1, 0), UY6.c(AbstractC12217eE5.deleted_for_chip_content_desc, interfaceC22053ub1, 0) + this.b.f(), eVarT, g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.jr1$d$c$c, reason: collision with other inner class name */
            static final class C1325c implements InterfaceC16978mB2 {
                final /* synthetic */ C20996sx3 a;
                final /* synthetic */ UA2 b;

                /* renamed from: ir.nasim.jr1$d$c$c$a */
                static final class a implements InterfaceC14603iB2 {
                    final /* synthetic */ C22613vY a;

                    a(C22613vY c22613vY) {
                        this.a = c22613vY;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(this.a.c(), null, false, 0, interfaceC22053ub1, 0, 14), null, androidx.compose.foundation.layout.t.t(AbstractC9747aV.k(FV0.a(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, 0.0f, C17784nZ1.q(12), 0.0f, 11, null), C24381yX0.b.i(), null, 2, null), N46.g()), this.a.d(), this.a.f(), 0.0f, false, null, 28, null), C17784nZ1.q(52)), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C1325c(C20996sx3 c20996sx3, UA2 ua2) {
                    this.a = c20996sx3;
                    this.b = ua2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(UA2 ua2, C22613vY c22613vY, boolean z) {
                    AbstractC13042fc3.i(ua2, "$toggleContact");
                    ua2.invoke(c22613vY);
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
                    final C22613vY c22613vY = (C22613vY) this.a.f(i);
                    if (c22613vY == null) {
                        return;
                    }
                    final UA2 ua2 = this.b;
                    String strF = c22613vY.f();
                    String strE = c22613vY.e();
                    boolean zH = c22613vY.h();
                    InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-227204694, true, new a(c22613vY), interfaceC22053ub1, 54);
                    interfaceC22053ub1.W(388283926);
                    boolean zV = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.V(c22613vY);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.nr1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC15599jr1.d.c.C1325c.c(ua2, c22613vY, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC24459yf1.C(null, strF, strE, interfaceC18060o11E, false, zH, (UA2) objB, false, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.jr1$d$c$d, reason: collision with other inner class name */
            public static final class C1326d extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ List e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C1326d(List list) {
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

            /* renamed from: ir.nasim.jr1$d$c$e */
            public static final class e extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ List e;
                final /* synthetic */ UA2 f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public e(List list, UA2 ua2) {
                    super(4);
                    this.e = list;
                    this.f = ua2;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    int i3;
                    float fU;
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
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
                    C22613vY c22613vY = (C22613vY) this.e.get(i);
                    interfaceC22053ub1.W(-241043334);
                    e.a aVar = androidx.compose.ui.e.a;
                    if (i == 0) {
                        interfaceC22053ub1.W(546416091);
                        fU = G10.a.c(interfaceC22053ub1, G10.b).b().c();
                    } else {
                        interfaceC22053ub1.W(546417370);
                        fU = G10.a.c(interfaceC22053ub1, G10.b).b().u();
                    }
                    interfaceC22053ub1.Q();
                    float f = fU;
                    G10 g10 = G10.a;
                    int i4 = G10.b;
                    NS0.f(androidx.compose.foundation.layout.q.m(aVar, f, g10.c(interfaceC22053ub1, i4).b().u(), 0.0f, g10.c(interfaceC22053ub1, i4).b().u(), 4, null), false, null, false, c22613vY.f(), new PS0.b(null, AbstractC19242q11.e(860143083, true, new a(c22613vY), interfaceC22053ub1, 54), AbstractC19242q11.e(-1485690166, true, new b(this.f, c22613vY), interfaceC22053ub1, 54), 1, null), 0L, interfaceC22053ub1, PS0.b.d << 15, 78);
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

            c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC10258bL6 interfaceC10258bL6, String str, UA2 ua2, UA2 ua22, AbstractC17858ng6 abstractC17858ng6, UA2 ua23, SA2 sa2) {
                this.a = interfaceC4557Fq2;
                this.b = interfaceC10258bL6;
                this.c = str;
                this.d = ua2;
                this.e = ua22;
                this.f = abstractC17858ng6;
                this.g = ua23;
                this.h = sa2;
            }

            private static final List f(InterfaceC9664aL6 interfaceC9664aL6) {
                return (List) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(interfaceC9664aL6, "$selectedContacts$delegate");
                AbstractC13042fc3.i(ua2, "$toggleContact");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
                List listF = f(interfaceC9664aL6);
                interfaceC15069ix3.a(listF.size(), null, new C1326d(listF), AbstractC19242q11.c(-1091073711, true, new e(listF, ua2)));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C20996sx3 c20996sx3, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(c20996sx3, "$item");
                AbstractC13042fc3.i(ua2, "$toggleContact");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, X31.a.a(), 3, null);
                InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.mr1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC15599jr1.d.c.k((C22613vY) obj);
                    }
                }), null, AbstractC19242q11.c(104983749, true, new C1325c(c20996sx3, ua2)), 4, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Object k(C22613vY c22613vY) {
                AbstractC13042fc3.i(c22613vY, "it");
                return Integer.valueOf(c22613vY.d());
            }

            public final void d(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                InterfaceC9664aL6 interfaceC9664aL6;
                UA2 ua2;
                e.a aVar;
                InterfaceC12529em.c cVar;
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
                final C20996sx3 c20996sx3B = AbstractC21683tx3.b(this.a, null, interfaceC22053ub1, 0, 1);
                final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.b, null, null, null, interfaceC22053ub1, 0, 7);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), ts4);
                String str = this.c;
                UA2 ua22 = this.d;
                UA2 ua23 = this.e;
                AbstractC17858ng6 abstractC17858ng6 = this.f;
                final UA2 ua24 = this.g;
                SA2 sa2 = this.h;
                C24254yJ c24254yJ = C24254yJ.a;
                C24254yJ.m mVarH = c24254yJ.h();
                InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar3.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
                InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar4.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar4.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                AbstractC16075kf6.j(UY6.c(BD5.contacts_search_hint, interfaceC22053ub1, 0), str, ua22, false, ua23, abstractC17858ng6, false, null, null, null, null, interfaceC22053ub1, AbstractC17858ng6.a << 15, 0, 1992);
                interfaceC22053ub1.W(1132674365);
                if (!f(interfaceC9664aL6C).isEmpty()) {
                    cVar = null;
                    androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), C17784nZ1.q(52)), G10.a.a(interfaceC22053ub1, G10.b).A(), null, 2, null);
                    C24254yJ.e eVarP = c24254yJ.p(C17784nZ1.q(8), aVar3.k());
                    InterfaceC12529em.c cVarI = aVar3.i();
                    interfaceC22053ub1.W(1132688421);
                    boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.V(ua24);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.kr1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC15599jr1.d.c.h(interfaceC9664aL6C, ua24, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    ua2 = ua24;
                    interfaceC9664aL6 = interfaceC9664aL6C;
                    aVar = aVar2;
                    AbstractC12623ev3.d(eVarD, null, null, false, eVarP, cVarI, null, false, null, (UA2) objB, interfaceC22053ub1, 221184, 462);
                } else {
                    interfaceC9664aL6 = interfaceC9664aL6C;
                    ua2 = ua24;
                    aVar = aVar2;
                    cVar = null;
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarB = ZY0.b(c9784aZ0, androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, cVar), 1.0f, false, 2, null);
                e.a aVar5 = aVar;
                interfaceC22053ub1.W(1132779734);
                final UA2 ua25 = ua2;
                boolean zD = interfaceC22053ub1.D(c20996sx3B) | interfaceC22053ub1.V(ua25);
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.lr1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC15599jr1.d.c.i(c20996sx3B, ua25, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarB, null, null, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1, 0, 510);
                float f = 12;
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.h(aVar5, 0.0f, 1, cVar), cVar, false, 3, cVar), C17784nZ1.q(f));
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
                SA2 sa2A2 = aVar4.a();
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar4.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                AbstractC17932no0.D(sa2, f(interfaceC9664aL6).isEmpty() ^ true ? OA2.b.C0545b.c : OA2.b.a.c, androidx.compose.foundation.layout.q.b(AbstractC3624Bq5.a(XA5.spacing_16, interfaceC22053ub1, 0), AbstractC3624Bq5.a(XA5.spacing_14, interfaceC22053ub1, 0)), C17784nZ1.q(f), null, UY6.c(BD5.start_call, interfaceC22053ub1, 0), G10.a.d(interfaceC22053ub1, G10.b).k(), androidx.compose.foundation.layout.t.k(androidx.compose.foundation.layout.t.g(aVar5, 1.0f), C17784nZ1.q(54), 0.0f, 2, cVar), null, interfaceC22053ub1, (OA2.b.b << 3) | 12610560, 256);
                interfaceC22053ub1.u();
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                d((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        d(SA2 sa2, SA2 sa22, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC10258bL6 interfaceC10258bL6, String str, UA2 ua2, UA2 ua22, AbstractC17858ng6 abstractC17858ng6, UA2 ua23, SA2 sa23) {
            this.a = sa2;
            this.b = sa22;
            this.c = interfaceC4557Fq2;
            this.d = interfaceC10258bL6;
            this.e = str;
            this.f = ua2;
            this.g = ua22;
            this.h = abstractC17858ng6;
            this.i = ua23;
            this.j = sa23;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            A98.a aVar = A98.a;
            int iC = AbstractC24416ya8.b(aVar, interfaceC22053ub1, 6).c((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g()));
            Integer numValueOf = Integer.valueOf(iC);
            interfaceC22053ub1.W(1429125377);
            boolean zE = interfaceC22053ub1.e(iC) | interfaceC22053ub1.V(this.a);
            SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zE || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(iC, sa2, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(numValueOf, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            A98 a98F = AbstractC21393ta8.f(C9819ac6.a.a(interfaceC22053ub1, C9819ac6.b), AbstractC24416ya8.c(aVar, interfaceC22053ub1, 6));
            AbstractC11029cc6.a(eVarF, AbstractC19242q11.e(-795263922, true, new b(this.b), interfaceC22053ub1, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1, G10.b).r(), 0L, a98F, AbstractC19242q11.e(277485529, true, new c(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j), interfaceC22053ub1, 54), interfaceC22053ub1, 805306422, 188);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void l(final C20345rr1 c20345rr1, final C22042ua0 c22042ua0, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c20345rr1, "viewModel");
        AbstractC13042fc3.i(c22042ua0, "fragment");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(272170586);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c20345rr1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(c22042ua0) : interfaceC22053ub1J.D(c22042ua0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(c20345rr1.b1(), null, null, null, interfaceC22053ub1J, 0, 7);
            InterfaceC4557Fq2 interfaceC4557Fq2Z0 = c20345rr1.Z0();
            InterfaceC10258bL6 interfaceC10258bL6A1 = c20345rr1.a1();
            interfaceC22053ub1J.W(-201352451);
            boolean zD = interfaceC22053ub1J.D(c20345rr1);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c20345rr1);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB;
            interfaceC22053ub1J.Q();
            String strD = m(interfaceC9664aL6C).d();
            interfaceC22053ub1J.W(-201348035);
            boolean zD2 = interfaceC22053ub1J.D(c20345rr1);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(c20345rr1);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB2;
            interfaceC22053ub1J.Q();
            AbstractC17858ng6 abstractC17858ng6C = m(interfaceC9664aL6C).c();
            interfaceC22053ub1J.W(-201344349);
            boolean zD3 = interfaceC22053ub1J.D(c20345rr1);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new c(c20345rr1);
                interfaceC22053ub1J.s(objB3);
            }
            InterfaceC16733lm3 interfaceC16733lm33 = (InterfaceC16733lm3) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-201355109);
            boolean zD4 = interfaceC22053ub1J.D(c20345rr1) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32 || ((i2 & 64) != 0 && interfaceC22053ub1J.D(c22042ua0)));
            Object objB4 = interfaceC22053ub1J.B();
            if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.hr1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15599jr1.n(c20345rr1, c22042ua0);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            SA2 sa22 = (SA2) objB4;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-201357900);
            boolean zD5 = interfaceC22053ub1J.D(c20345rr1);
            Object objB5 = interfaceC22053ub1J.B();
            if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new UA2() { // from class: ir.nasim.ir1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC15599jr1.o(c20345rr1, (C22613vY) obj);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            q(interfaceC4557Fq2Z0, interfaceC10258bL6A1, sa22, (UA2) objB5, (UA2) interfaceC16733lm3, strD, sa2, (UA2) interfaceC16733lm32, abstractC17858ng6C, (SA2) interfaceC16733lm33, interfaceC22053ub1J, ((i2 << 12) & 3670016) | (AbstractC17858ng6.a << 24));
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Zq1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15599jr1.p(c20345rr1, c22042ua0, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final C19736qr1 m(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C19736qr1) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(C20345rr1 c20345rr1, C22042ua0 c22042ua0) {
        AbstractC13042fc3.i(c20345rr1, "$viewModel");
        AbstractC13042fc3.i(c22042ua0, "$fragment");
        c20345rr1.e1(c22042ua0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(C20345rr1 c20345rr1, C22613vY c22613vY) {
        AbstractC13042fc3.i(c20345rr1, "$viewModel");
        AbstractC13042fc3.i(c22613vY, "it");
        c20345rr1.f1(c22613vY);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C20345rr1 c20345rr1, C22042ua0 c22042ua0, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c20345rr1, "$viewModel");
        AbstractC13042fc3.i(c22042ua0, "$fragment");
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        l(c20345rr1, c22042ua0, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void q(final InterfaceC4557Fq2 interfaceC4557Fq2, final InterfaceC10258bL6 interfaceC10258bL6, final SA2 sa2, final UA2 ua2, final UA2 ua22, final String str, final SA2 sa22, final UA2 ua23, final AbstractC17858ng6 abstractC17858ng6, final SA2 sa23, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC4557Fq2, ContactEntity.TABLE_NAME);
        AbstractC13042fc3.i(interfaceC10258bL6, "selectedContact");
        AbstractC13042fc3.i(sa2, "startGroupCallWithUsers");
        AbstractC13042fc3.i(ua2, "toggleContact");
        AbstractC13042fc3.i(ua22, "searchContact");
        AbstractC13042fc3.i(str, "searchQuery");
        AbstractC13042fc3.i(sa22, "onBackPressed");
        AbstractC13042fc3.i(ua23, "setStateForSearch");
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        AbstractC13042fc3.i(sa23, "onKeyboardHasBeenClosed");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1467196465);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC4557Fq2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC10258bL6) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(ua22) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua23) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= (134217728 & i) == 0 ? interfaceC22053ub1J.V(abstractC17858ng6) : interfaceC22053ub1J.D(abstractC17858ng6) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) == 306783378 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            M10.f(false, AbstractC19242q11.e(-1314079094, true, new d(sa23, sa22, interfaceC4557Fq2, interfaceC10258bL6, str, ua22, ua23, abstractC17858ng6, ua2, sa2), interfaceC22053ub12, 54), interfaceC22053ub12, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.gr1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15599jr1.r(interfaceC4557Fq2, interfaceC10258bL6, sa2, ua2, ua22, str, sa22, ua23, abstractC17858ng6, sa23, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC10258bL6 interfaceC10258bL6, SA2 sa2, UA2 ua2, UA2 ua22, String str, SA2 sa22, UA2 ua23, AbstractC17858ng6 abstractC17858ng6, SA2 sa23, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "$contacts");
        AbstractC13042fc3.i(interfaceC10258bL6, "$selectedContact");
        AbstractC13042fc3.i(sa2, "$startGroupCallWithUsers");
        AbstractC13042fc3.i(ua2, "$toggleContact");
        AbstractC13042fc3.i(ua22, "$searchContact");
        AbstractC13042fc3.i(str, "$searchQuery");
        AbstractC13042fc3.i(sa22, "$onBackPressed");
        AbstractC13042fc3.i(ua23, "$setStateForSearch");
        AbstractC13042fc3.i(abstractC17858ng6, "$searchFocusState");
        AbstractC13042fc3.i(sa23, "$onKeyboardHasBeenClosed");
        q(interfaceC4557Fq2, interfaceC10258bL6, sa2, ua2, ua22, str, sa22, ua23, abstractC17858ng6, sa23, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void s(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-312264280);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
            InterfaceC4557Fq2 interfaceC4557Fq2T = AbstractC6459Nq2.T(NT4.e.a());
            interfaceC22053ub1J.W(-1579786295);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.Yq1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15599jr1.t();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1579785911);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.ar1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC15599jr1.u((C22613vY) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            UA2 ua2 = (UA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1579785527);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new UA2() { // from class: ir.nasim.br1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC15599jr1.v((String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            UA2 ua22 = (UA2) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1579784759);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.cr1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15599jr1.w();
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            SA2 sa22 = (SA2) objB4;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1579784375);
            Object objB5 = interfaceC22053ub1J.B();
            if (objB5 == aVar.a()) {
                objB5 = new UA2() { // from class: ir.nasim.dr1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC15599jr1.x((AbstractC17858ng6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            UA2 ua23 = (UA2) objB5;
            interfaceC22053ub1J.Q();
            AbstractC17858ng6.b bVar = AbstractC17858ng6.b.b;
            interfaceC22053ub1J.W(-1579782807);
            Object objB6 = interfaceC22053ub1J.B();
            if (objB6 == aVar.a()) {
                objB6 = new SA2() { // from class: ir.nasim.er1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15599jr1.y();
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            interfaceC22053ub1J.Q();
            q(interfaceC4557Fq2T, interfaceC9336Zm4A, sa2, ua2, ua22, "", sa22, ua23, bVar, (SA2) objB6, interfaceC22053ub1J, (AbstractC17858ng6.b.c << 24) | 819686784);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fr1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15599jr1.z(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(C22613vY c22613vY) {
        AbstractC13042fc3.i(c22613vY, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(AbstractC17858ng6 abstractC17858ng6) {
        AbstractC13042fc3.i(abstractC17858ng6, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        s(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
