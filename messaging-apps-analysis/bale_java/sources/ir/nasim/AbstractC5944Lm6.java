package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC5944Lm6;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.OA2;
import ir.nasim.PS0;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;

/* renamed from: ir.nasim.Lm6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5944Lm6 {

    /* renamed from: ir.nasim.Lm6$a */
    /* synthetic */ class a extends EB2 implements UA2 {
        a(Object obj) {
            super(1, obj, C7622Sm6.class, "updateSearchQuery", "updateSearchQuery(Ljava/lang/String;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((String) obj);
            return C19938rB7.a;
        }

        public final void y(String str) {
            AbstractC13042fc3.i(str, "p0");
            ((C7622Sm6) this.receiver).c1(str);
        }
    }

    /* renamed from: ir.nasim.Lm6$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ String a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ InterfaceC4557Fq2 c;
        final /* synthetic */ InterfaceC10258bL6 d;
        final /* synthetic */ String e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ String i;

        /* renamed from: ir.nasim.Lm6$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;
            final /* synthetic */ SA2 b;

            a(String str, SA2 sa2) {
                this.a = str;
                this.b = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC21639ts7.i(this.a, null, this.b, null, null, null, null, interfaceC22053ub1, 0, 122);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Lm6$b$b, reason: collision with other inner class name */
        static final class C0487b implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ InterfaceC10258bL6 b;
            final /* synthetic */ String c;
            final /* synthetic */ UA2 d;
            final /* synthetic */ UA2 e;
            final /* synthetic */ UA2 f;
            final /* synthetic */ String g;

            /* renamed from: ir.nasim.Lm6$b$b$a */
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

            /* renamed from: ir.nasim.Lm6$b$b$b, reason: collision with other inner class name */
            static final class C0488b implements InterfaceC14603iB2 {
                final /* synthetic */ UA2 a;
                final /* synthetic */ C22613vY b;

                /* renamed from: ir.nasim.Lm6$b$b$b$a */
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

                C0488b(UA2 ua2, C22613vY c22613vY) {
                    this.a = ua2;
                    this.b = c22613vY;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    e.a aVar = androidx.compose.ui.e.a;
                    interfaceC22053ub1.W(-35857888);
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

            /* renamed from: ir.nasim.Lm6$b$b$c */
            static final class c implements InterfaceC16978mB2 {
                final /* synthetic */ C20996sx3 a;
                final /* synthetic */ UA2 b;

                /* renamed from: ir.nasim.Lm6$b$b$c$a */
                static final class a implements InterfaceC14603iB2 {
                    final /* synthetic */ C22613vY a;

                    a(C22613vY c22613vY) {
                        this.a = c22613vY;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else {
                            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(this.a.c(), null, false, 0, interfaceC22053ub1, 0, 14), null, androidx.compose.foundation.layout.t.t(FV0.a(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, 0.0f, C17784nZ1.q(12), 0.0f, 11, null), C24381yX0.b.i(), null, 2, null), N46.g()), C17784nZ1.q(52)), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                c(C20996sx3 c20996sx3, UA2 ua2) {
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
                    InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-35222526, true, new a(c22613vY), interfaceC22053ub1, 54);
                    interfaceC22053ub1.W(-35783929);
                    boolean zV = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.V(c22613vY);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.Qm6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC5944Lm6.b.C0487b.c.c(ua2, c22613vY, ((Boolean) obj).booleanValue());
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

            /* renamed from: ir.nasim.Lm6$b$b$d */
            public static final class d extends AbstractC8614Ws3 implements UA2 {
                public static final d e = new d();

                public d() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Object obj) {
                    return null;
                }
            }

            /* renamed from: ir.nasim.Lm6$b$b$e */
            public static final class e extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ List f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public e(UA2 ua2, List list) {
                    super(1);
                    this.e = ua2;
                    this.f = list;
                }

                public final Object a(int i) {
                    return this.e.invoke(this.f.get(i));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Number) obj).intValue());
                }
            }

            /* renamed from: ir.nasim.Lm6$b$b$f */
            public static final class f extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ List e;
                final /* synthetic */ UA2 f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public f(List list, UA2 ua2) {
                    super(4);
                    this.e = list;
                    this.f = ua2;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    int i3;
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
                        AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    C22613vY c22613vY = (C22613vY) this.e.get(i);
                    interfaceC22053ub1.W(245451502);
                    e.a aVar = androidx.compose.ui.e.a;
                    G10 g10 = G10.a;
                    int i4 = G10.b;
                    NS0.f(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g10.c(interfaceC22053ub1, i4).b().u(), g10.c(interfaceC22053ub1, i4).b().u(), g10.c(interfaceC22053ub1, i4).b().u(), 1, null), false, null, false, c22613vY.f(), new PS0.b(null, AbstractC19242q11.e(-1934413903, true, new a(c22613vY), interfaceC22053ub1, 54), AbstractC19242q11.e(1718239218, true, new C0488b(this.f, c22613vY), interfaceC22053ub1, 54), 1, null), 0L, interfaceC22053ub1, PS0.b.d << 15, 78);
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

            C0487b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC10258bL6 interfaceC10258bL6, String str, UA2 ua2, UA2 ua22, UA2 ua23, String str2) {
                this.a = interfaceC4557Fq2;
                this.b = interfaceC10258bL6;
                this.c = str;
                this.d = ua2;
                this.e = ua22;
                this.f = ua23;
                this.g = str2;
            }

            private static final List h(InterfaceC9664aL6 interfaceC9664aL6) {
                return (List) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(interfaceC9664aL6, "$selectedContacts$delegate");
                AbstractC13042fc3.i(ua2, "$toggleContact");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
                List listH = h(interfaceC9664aL6);
                interfaceC15069ix3.a(listH.size(), null, new e(d.e, listH), AbstractC19242q11.c(-632812321, true, new f(listH, ua2)));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(C20996sx3 c20996sx3, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(c20996sx3, "$item");
                AbstractC13042fc3.i(ua2, "$toggleContact");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C14583i91.a.a(), 3, null);
                InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.Pm6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC5944Lm6.b.C0487b.n((C22613vY) obj);
                    }
                }), null, AbstractC19242q11.c(-1217583011, true, new c(c20996sx3, ua2)), 4, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Object n(C22613vY c22613vY) {
                AbstractC13042fc3.i(c22613vY, "it");
                return Integer.valueOf(c22613vY.d());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
                AbstractC13042fc3.i(ua2, "$onActionClicked");
                AbstractC13042fc3.i(interfaceC9664aL6, "$selectedContacts$delegate");
                ua2.invoke(h(interfaceC9664aL6));
                return C19938rB7.a;
            }

            public final void f(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                e.a aVar;
                UA2 ua2;
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
                InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.b, null, null, null, interfaceC22053ub1, 0, 7);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), ts4);
                String str = this.c;
                UA2 ua22 = this.d;
                final UA2 ua23 = this.e;
                final UA2 ua24 = this.f;
                String str2 = this.g;
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
                final InterfaceC9664aL6 interfaceC9664aL6 = interfaceC9664aL6C;
                AbstractC16075kf6.j(UY6.c(BD5.contacts_search_hint, interfaceC22053ub1, 0), str, ua22, false, null, null, false, null, null, null, null, interfaceC22053ub1, 0, 0, 2040);
                interfaceC22053ub1.W(536298107);
                if (!h(interfaceC9664aL6).isEmpty()) {
                    cVar = null;
                    androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), C17784nZ1.q(52)), G10.a.a(interfaceC22053ub1, G10.b).A(), null, 2, null);
                    C24254yJ.e eVarP = c24254yJ.p(C17784nZ1.q(8), aVar3.k());
                    InterfaceC12529em.c cVarI = aVar3.i();
                    interfaceC22053ub1.W(536312163);
                    boolean zV = interfaceC22053ub1.V(interfaceC9664aL6) | interfaceC22053ub1.V(ua23);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.Mm6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC5944Lm6.b.C0487b.i(interfaceC9664aL6, ua23, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    ua2 = ua23;
                    interfaceC9664aL6 = interfaceC9664aL6;
                    aVar = aVar2;
                    AbstractC12623ev3.d(eVarD, null, null, false, eVarP, cVarI, null, false, null, (UA2) objB, interfaceC22053ub1, 221184, 462);
                } else {
                    aVar = aVar2;
                    ua2 = ua23;
                    cVar = null;
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarB = ZY0.b(c9784aZ0, androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, cVar), 1.0f, false, 2, null);
                e.a aVar5 = aVar;
                interfaceC22053ub1.W(536402627);
                final UA2 ua25 = ua2;
                boolean zD = interfaceC22053ub1.D(c20996sx3B) | interfaceC22053ub1.V(ua25);
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Nm6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC5944Lm6.b.C0487b.k(c20996sx3B, ua25, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarB, null, null, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1, 0, 510);
                float f2 = 12;
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.h(aVar5, 0.0f, 1, cVar), cVar, false, 3, cVar), C17784nZ1.q(f2));
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
                InterfaceC19114po0 interfaceC19114po0 = h(interfaceC9664aL6).isEmpty() ^ true ? OA2.b.C0545b.c : OA2.b.a.c;
                interfaceC22053ub1.W(45771262);
                final InterfaceC9664aL6 interfaceC9664aL62 = interfaceC9664aL6;
                boolean zV2 = interfaceC22053ub1.V(ua24) | interfaceC22053ub1.V(interfaceC9664aL62);
                Object objB3 = interfaceC22053ub1.B();
                if (zV2 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.Om6
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC5944Lm6.b.C0487b.o(ua24, interfaceC9664aL62);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC17932no0.D((SA2) objB3, interfaceC19114po0, androidx.compose.foundation.layout.q.b(AbstractC3624Bq5.a(XA5.spacing_16, interfaceC22053ub1, 0), AbstractC3624Bq5.a(XA5.spacing_14, interfaceC22053ub1, 0)), C17784nZ1.q(f2), null, str2, G10.a.d(interfaceC22053ub1, G10.b).k(), androidx.compose.foundation.layout.t.k(androidx.compose.foundation.layout.t.g(aVar5, 1.0f), C17784nZ1.q(54), 0.0f, 2, cVar), null, interfaceC22053ub1, (OA2.b.b << 3) | 12610560, 256);
                interfaceC22053ub1.u();
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                f((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        b(String str, SA2 sa2, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC10258bL6 interfaceC10258bL6, String str2, UA2 ua2, UA2 ua22, UA2 ua23, String str3) {
            this.a = str;
            this.b = sa2;
            this.c = interfaceC4557Fq2;
            this.d = interfaceC10258bL6;
            this.e = str2;
            this.f = ua2;
            this.g = ua22;
            this.h = ua23;
            this.i = str3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            A98 a98F = AbstractC21393ta8.f(C9819ac6.a.a(interfaceC22053ub1, C9819ac6.b), AbstractC24416ya8.c(A98.a, interfaceC22053ub1, 6));
            AbstractC11029cc6.a(eVarF, AbstractC19242q11.e(800988582, true, new a(this.a, this.b), interfaceC22053ub1, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1, G10.b).r(), 0L, a98F, AbstractC19242q11.e(-921424271, true, new C0487b(this.c, this.d, this.e, this.f, this.g, this.h, this.i), interfaceC22053ub1, 54), interfaceC22053ub1, 805306422, 188);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(final ir.nasim.SA2 r19, final java.lang.String r20, final ir.nasim.UA2 r21, final java.lang.String r22, ir.nasim.C7622Sm6 r23, ir.nasim.InterfaceC22053ub1 r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5944Lm6.d(ir.nasim.SA2, java.lang.String, ir.nasim.UA2, java.lang.String, ir.nasim.Sm6, ir.nasim.ub1, int, int):void");
    }

    private static final C7388Rm6 e(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C7388Rm6) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(C7622Sm6 c7622Sm6, C22613vY c22613vY) {
        AbstractC13042fc3.i(c22613vY, "it");
        c7622Sm6.b1(c22613vY);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2, String str, UA2 ua2, String str2, C7622Sm6 c7622Sm6, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(ua2, "$onActionClicked");
        AbstractC13042fc3.i(str2, "$actionTitle");
        d(sa2, str, ua2, str2, c7622Sm6, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void h(final InterfaceC4557Fq2 interfaceC4557Fq2, final InterfaceC10258bL6 interfaceC10258bL6, final UA2 ua2, final UA2 ua22, final UA2 ua23, final String str, final SA2 sa2, final String str2, final String str3, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC4557Fq2, ContactEntity.TABLE_NAME);
        AbstractC13042fc3.i(interfaceC10258bL6, "selectedContact");
        AbstractC13042fc3.i(ua2, "onActionClicked");
        AbstractC13042fc3.i(ua22, "toggleContact");
        AbstractC13042fc3.i(ua23, "searchContact");
        AbstractC13042fc3.i(str, "searchQuery");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        AbstractC13042fc3.i(str2, "title");
        AbstractC13042fc3.i(str3, "actionTitle");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1753439001);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC4557Fq2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC10258bL6) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(ua23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str3) ? 67108864 : 33554432;
        }
        if ((i2 & 38347923) == 38347922 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            M10.f(false, AbstractC19242q11.e(1735782626, true, new b(str2, sa2, interfaceC4557Fq2, interfaceC10258bL6, str, ua23, ua22, ua2, str3), interfaceC22053ub12, 54), interfaceC22053ub12, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Km6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5944Lm6.i(interfaceC4557Fq2, interfaceC10258bL6, ua2, ua22, ua23, str, sa2, str2, str3, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, UA2 ua22, UA2 ua23, String str, SA2 sa2, String str2, String str3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "$contacts");
        AbstractC13042fc3.i(interfaceC10258bL6, "$selectedContact");
        AbstractC13042fc3.i(ua2, "$onActionClicked");
        AbstractC13042fc3.i(ua22, "$toggleContact");
        AbstractC13042fc3.i(ua23, "$searchContact");
        AbstractC13042fc3.i(str, "$searchQuery");
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(str2, "$title");
        AbstractC13042fc3.i(str3, "$actionTitle");
        h(interfaceC4557Fq2, interfaceC10258bL6, ua2, ua22, ua23, str, sa2, str2, str3, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
