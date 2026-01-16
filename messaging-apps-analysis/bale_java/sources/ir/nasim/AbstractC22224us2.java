package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import ir.nasim.AbstractC22224us2;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.us2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22224us2 {

    /* renamed from: ir.nasim.us2$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        /* renamed from: ir.nasim.us2$a$a, reason: collision with other inner class name */
        static final class C1641a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            C1641a(int i) {
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

        /* renamed from: ir.nasim.us2$a$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC24077y03.b(FV4.c(this.a, interfaceC22053ub1, 0), null, null, G10.a.a(interfaceC22053ub1, G10.b).F(), interfaceC22053ub1, 48, 4);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, SA2 sa22, int i, int i2) {
            this.a = sa2;
            this.b = sa22;
            this.c = i;
            this.d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(sa2, "$onDeleteClicked");
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
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-547524604, true, new C1641a(this.c), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-1021473191);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final SA2 sa2 = this.a;
            final SA2 sa22 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.ts2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC22224us2.a.c(sa2, sa22);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC6197Mp.b(interfaceC18060o11E, (SA2) objB, null, AbstractC19242q11.e(183085985, true, new b(this.d), interfaceC22053ub1, 54), null, false, null, null, null, interfaceC22053ub1, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.us2$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;

        b(SA2 sa2, SA2 sa22) {
            this.a = sa2;
            this.b = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(sa2, "$onEditClicked");
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
            L51 l51 = L51.a;
            InterfaceC14603iB2 interfaceC14603iB2A = l51.a();
            interfaceC22053ub1.W(1603573302);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final SA2 sa2 = this.a;
            final SA2 sa22 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.vs2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC22224us2.b.c(sa2, sa22);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC6197Mp.b(interfaceC14603iB2A, (SA2) objB, null, l51.b(), null, false, null, null, null, interfaceC22053ub1, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.us2$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ SA2 e;

        /* renamed from: ir.nasim.us2$c$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ boolean a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ SA2 c;
            final /* synthetic */ SA2 d;

            a(boolean z, SA2 sa2, SA2 sa22, SA2 sa23) {
                this.a = z;
                this.b = sa2;
                this.c = sa22;
                this.d = sa23;
            }

            public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(zy0, "$this$DropdownMenu");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(509421072);
                if (this.a) {
                    AbstractC22224us2.o(this.b, this.c, interfaceC22053ub1, 0);
                }
                interfaceC22053ub1.Q();
                AbstractC22224us2.m(this.a, this.d, this.c, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        c(boolean z, SA2 sa2, boolean z2, SA2 sa22, SA2 sa23) {
            this.a = z;
            this.b = sa2;
            this.c = z2;
            this.d = sa22;
            this.e = sa23;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            int i2 = G10.b;
            M46 m46D = N46.d(g10.c(interfaceC22053ub1, i2).a().b());
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.b.d(androidx.compose.ui.e.a, g10.a(interfaceC22053ub1, i2).M(), null, 2, null), g10.c(interfaceC22053ub1, i2).b().g(), 0.0f, 2, null);
            boolean z = this.a;
            SA2 sa2 = this.b;
            AbstractC6197Mp.a(z, sa2, eVarK, 0L, null, null, m46D, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(-2036582930, true, new a(this.c, this.d, sa2, this.e), interfaceC22053ub1, 54), interfaceC22053ub1, 0, 48, 1976);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.us2$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ List a;
        final /* synthetic */ e b;

        /* renamed from: ir.nasim.us2$d$a */
        public static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            public a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Object obj) {
                return null;
            }
        }

        /* renamed from: ir.nasim.us2$d$b */
        public static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(UA2 ua2, List list) {
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

        /* renamed from: ir.nasim.us2$d$c */
        public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;
            final /* synthetic */ e f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list, e eVar) {
                super(4);
                this.e = list;
                this.f = eVar;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                if ((i2 & 6) == 0) {
                    i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
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
                XV4 xv4 = (XV4) this.e.get(i);
                interfaceC22053ub1.W(-396357722);
                AbstractC22224us2.q((C8870Xr2) xv4.f(), null, this.f, interfaceC22053ub1, 0, 2);
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

        d(List list, e eVar) {
            this.a = list;
            this.b = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, e eVar, InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(list, "$items");
            AbstractC13042fc3.i(eVar, "$folderListAction");
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            interfaceC15069ix3.a(list.size(), null, new b(a.e, list), AbstractC19242q11.c(-632812321, true, new c(list, eVar)));
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.ui.e.a, G10.a.a(interfaceC22053ub1, G10.b).r(), null, 2, null);
            interfaceC22053ub1.W(267936165);
            boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b);
            final List list = this.a;
            final e eVar = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.ws2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC22224us2.d.c(list, eVar, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC12623ev3.b(eVarD, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 510);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.us2$e */
    public static final class e implements InterfaceC13228fs2 {
        private final UA2 a = new UA2() { // from class: ir.nasim.xs2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC22224us2.e.q(((Integer) obj).intValue());
            }
        };
        private final UA2 b = new UA2() { // from class: ir.nasim.ys2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC22224us2.e.s(((Integer) obj).intValue());
            }
        };
        private final SA2 c = new SA2() { // from class: ir.nasim.zs2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC22224us2.e.t();
            }
        };
        private final InterfaceC15796kB2 d = new InterfaceC15796kB2() { // from class: ir.nasim.As2
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return AbstractC22224us2.e.r((String) obj, ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue());
            }
        };
        private final UA2 e = new UA2() { // from class: ir.nasim.Bs2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC22224us2.e.o(((Integer) obj).intValue());
            }
        };
        private final UA2 f = new UA2() { // from class: ir.nasim.Cs2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC22224us2.e.v(((Integer) obj).intValue());
            }
        };
        private final SA2 g = new SA2() { // from class: ir.nasim.Ds2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC22224us2.e.u();
            }
        };

        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(List list) {
            AbstractC13042fc3.i(list, "it");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(int i) {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 q(int i) {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 r(String str, int i, boolean z) {
            AbstractC13042fc3.i(str, "<unused var>");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 s(int i) {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 u() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(int i) {
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC4824Gs2
        /* renamed from: S1 */
        public UA2 getOnCreateNewFolderClick() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC5058Hs2
        public SA2 a() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC5058Hs2
        public UA2 b() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC5058Hs2
        public UA2 c() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC5058Hs2
        public UA2 d() {
            return new UA2() { // from class: ir.nasim.Es2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC22224us2.e.n((List) obj);
                }
            };
        }

        @Override // ir.nasim.InterfaceC4824Gs2
        /* renamed from: h */
        public UA2 getOnEditFolderClicked() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC4824Gs2
        /* renamed from: p */
        public InterfaceC15796kB2 getOnDeleteFolderClicked() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC4824Gs2
        /* renamed from: s1 */
        public SA2 getOnEditReservedFolderClicked() {
            return this.c;
        }
    }

    public static final void A(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(533806417);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC23384wp6 interfaceC23384wp6A = new C4575Fs2().a();
            interfaceC22053ub1J.W(-5087729);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.hs2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(AbstractC22224us2.B((XV4) obj));
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(170541585, true, new d(AbstractC11342cq6.K(AbstractC11342cq6.r(interfaceC23384wp6A, (UA2) objB)), new e()), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ks2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22224us2.C(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "it");
        return xv4.e() == EnumC12613eu3.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        A(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final boolean z, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1247328303);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            XV4 xv4 = z ? new XV4(Integer.valueOf(FD5.delete_folder), Integer.valueOf(AbstractC16390lB5.delete)) : new XV4(Integer.valueOf(FD5.dective_folder), Integer.valueOf(AbstractC16390lB5.file_off));
            M10.f(false, AbstractC19242q11.e(289524180, true, new a(sa2, sa22, ((Number) xv4.a()).intValue(), ((Number) xv4.b()).intValue()), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.js2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22224us2.n(z, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(boolean z, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onDeleteClicked");
        AbstractC13042fc3.i(sa22, "$onDismissRequest");
        m(z, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-450797876);
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
            M10.f(false, AbstractC19242q11.e(-1595913551, true, new b(sa2, sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.is2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22224us2.p(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onEditClicked");
        AbstractC13042fc3.i(sa22, "$onDismissRequest");
        o(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0303  */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void q(final ir.nasim.C8870Xr2 r42, androidx.compose.ui.e r43, final ir.nasim.InterfaceC13228fs2 r44, ir.nasim.InterfaceC22053ub1 r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22224us2.q(ir.nasim.Xr2, androidx.compose.ui.e, ir.nasim.fs2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(C8870Xr2 c8870Xr2, InterfaceC13228fs2 interfaceC13228fs2) {
        AbstractC13042fc3.i(c8870Xr2, "$folderDTO");
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        if (c8870Xr2.e()) {
            boolean zH = c8870Xr2.h();
            if (zH) {
                interfaceC13228fs2.getOnEditReservedFolderClicked().invoke();
            } else {
                if (zH) {
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC13228fs2.getOnEditFolderClicked().invoke(Integer.valueOf(c8870Xr2.c()));
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(InterfaceC13228fs2 interfaceC13228fs2, C8870Xr2 c8870Xr2, Resources resources) {
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        AbstractC13042fc3.i(c8870Xr2, "$folderDTO");
        InterfaceC15796kB2 interfaceC15796kB2P = interfaceC13228fs2.getOnDeleteFolderClicked();
        int iC = c8870Xr2.c();
        String strD = c8870Xr2.d();
        AbstractC13042fc3.f(resources);
        interfaceC15796kB2P.q(AbstractC9978as2.a(iC, strD, resources), Integer.valueOf(c8870Xr2.c()), Boolean.valueOf(!c8870Xr2.h()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(InterfaceC13228fs2 interfaceC13228fs2, C8870Xr2 c8870Xr2) {
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        AbstractC13042fc3.i(c8870Xr2, "$folderDTO");
        interfaceC13228fs2.b().invoke(Integer.valueOf(c8870Xr2.c()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC13228fs2 interfaceC13228fs2, C8870Xr2 c8870Xr2) {
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        AbstractC13042fc3.i(c8870Xr2, "$folderDTO");
        interfaceC13228fs2.getOnEditFolderClicked().invoke(Integer.valueOf(c8870Xr2.c()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(InterfaceC13228fs2 interfaceC13228fs2, C8870Xr2 c8870Xr2) {
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        AbstractC13042fc3.i(c8870Xr2, "$folderDTO");
        interfaceC13228fs2.c().invoke(Integer.valueOf(c8870Xr2.c()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(C8870Xr2 c8870Xr2, androidx.compose.ui.e eVar, InterfaceC13228fs2 interfaceC13228fs2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c8870Xr2, "$folderDTO");
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        q(c8870Xr2, eVar, interfaceC13228fs2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void y(final boolean z, final boolean z2, final SA2 sa2, final SA2 sa22, final SA2 sa23, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(sa22, "onEditFolderClicked");
        AbstractC13042fc3.i(sa23, "onDeleteFolderClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1025224178);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.a(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(-522443661, true, new c(z, sa2, z2, sa22, sa23), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ss2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22224us2.z(z, z2, sa2, sa22, sa23, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(boolean z, boolean z2, SA2 sa2, SA2 sa22, SA2 sa23, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(sa22, "$onEditFolderClicked");
        AbstractC13042fc3.i(sa23, "$onDeleteFolderClicked");
        y(z, z2, sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
