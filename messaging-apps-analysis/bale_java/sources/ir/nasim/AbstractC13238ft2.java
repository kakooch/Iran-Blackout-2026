package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC13238ft2;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13521gN1;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.ft2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13238ft2 {

    /* renamed from: ir.nasim.ft2$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1060875706);
            A98 a98G = AbstractC21393ta8.g(C8062Uj0.a.g(interfaceC22053ub1, 6), AbstractC23236wa8.a.e());
            interfaceC22053ub1.Q();
            return a98G;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.ft2$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ C8370Vr2 a;
        final /* synthetic */ InterfaceC20315ro1 b;
        final /* synthetic */ C19818qz6 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ SA2 f;

        /* renamed from: ir.nasim.ft2$b$a */
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

        b(C8370Vr2 c8370Vr2, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22) {
            this.a = c8370Vr2;
            this.b = interfaceC20315ro1;
            this.c = c19818qz6;
            this.d = sa2;
            this.e = interfaceC14603iB2;
            this.f = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final SA2 sa2) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.ht2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC13238ft2.b.f(c19818qz6, sa2, (Throwable) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C19818qz6 c19818qz6, SA2 sa2, Throwable th) {
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            if (!c19818qz6.k()) {
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        public final void c(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.layout.t.k(eVarH, g10.c(interfaceC22053ub1, i2).b().s(), 0.0f, 2, null), g10.c(interfaceC22053ub1, i2).b().f(), g10.c(interfaceC22053ub1, i2).b().d());
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC9339Zm7.b(UY6.c(FD5.add_to_folder, interfaceC22053ub1, 0), hVar.h(aVar, aVar2.e()), g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65016);
            interfaceC22053ub1.u();
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
            C8370Vr2 c8370Vr2 = this.a;
            interfaceC22053ub1.W(1205165573);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.V(this.d);
            final InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            final C19818qz6 c19818qz6 = this.c;
            final SA2 sa2 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.gt2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13238ft2.b.d(interfaceC20315ro1, c19818qz6, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC13238ft2.k(c8370Vr2, (SA2) objB, this.e, this.f, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ft2$c */
    static final class c implements SA2 {
        final /* synthetic */ InterfaceC13521gN1.b a;
        final /* synthetic */ String b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        c(InterfaceC13521gN1.b bVar, String str, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = bVar;
            this.b = str;
            this.c = interfaceC9102Ym4;
        }

        public final void a() {
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            AbstractC13238ft2.n(interfaceC9102Ym4, C8370Vr2.b(AbstractC13238ft2.m(interfaceC9102Ym4), null, Integer.valueOf(this.a.e()), this.b, 1, null));
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ft2$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;

        d(SA2 sa2) {
            this.a = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onCreateFolderClicked");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.t.k(aVar, g10.c(interfaceC22053ub1, i2).b().q(), 0.0f, 2, null);
            String strC = UY6.c(FD5.create_folder, interfaceC22053ub1, 0);
            int i3 = AbstractC16390lB5.add_to_folder;
            C11984ds7 c11984ds7 = new C11984ds7(g10.a(interfaceC22053ub1, i2).M(), g10.a(interfaceC22053ub1, i2).I(), g10.a(interfaceC22053ub1, i2).z(), g10.a(interfaceC22053ub1, i2).I(), null);
            interfaceC22053ub1.W(593045783);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.it2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13238ft2.d.c(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16797ls7.i(strC, i3, eVarK, null, null, null, c11984ds7, (SA2) objB, null, false, interfaceC22053ub1, C11984ds7.f << 18, 824);
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ft2$e */
    static final class e implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC14603iB2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        e(InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = interfaceC14603iB2;
            this.b = sa2;
            this.c = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$onAddToFolderClicked");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$state$delegate");
            interfaceC14603iB2.invoke(AbstractC13238ft2.m(interfaceC9102Ym4).d(), AbstractC13238ft2.m(interfaceC9102Ym4).e());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void c(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i2).b().c());
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            C24254yJ.f fVarE = C24254yJ.a.e();
            final InterfaceC14603iB2 interfaceC14603iB2 = this.a;
            final SA2 sa2 = this.b;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarE, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 0.5f, false, 2, null);
            InterfaceC19114po0 interfaceC19114po0 = AbstractC13238ft2.m(interfaceC9102Ym4).d() == null ? InterfaceC19114po0.a.C1453a.a : InterfaceC19114po0.b.a.a;
            String strC = UY6.c(FD5.add_button, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(1177906693);
            boolean zV = interfaceC22053ub1.V(interfaceC14603iB2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.jt2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13238ft2.e.d(interfaceC14603iB2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.A((SA2) objB, interfaceC19114po0, strC, eVarB, null, null, interfaceC22053ub1, 24576, 32);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, g10.c(interfaceC22053ub1, i2).b().c()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarB2 = L66.b(m66, aVar, 0.5f, false, 2, null);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(FD5.cancel, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(1177927121);
            boolean zV2 = interfaceC22053ub1.V(sa2);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.kt2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13238ft2.e.f(sa2);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.A((SA2) objB2, c1454b, strC2, eVarB2, null, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 3) | 24576, 32);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ft2$f */
    public static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        public f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.ft2$g */
    public static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(UA2 ua2, List list) {
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

    /* renamed from: ir.nasim.ft2$h */
    public static final class h extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ Context f;
        final /* synthetic */ InterfaceC9102Ym4 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(List list, Context context, InterfaceC9102Ym4 interfaceC9102Ym4) {
            super(4);
            this.e = list;
            this.f = context;
            this.g = interfaceC9102Ym4;
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
            InterfaceC13521gN1.b bVar = (InterfaceC13521gN1.b) this.e.get(i);
            interfaceC22053ub1.W(1203915460);
            String strA = bVar.f().a(this.f);
            int iE = bVar.e();
            Integer numD = AbstractC13238ft2.m(this.g).d();
            boolean z = numD != null && iE == numD.intValue();
            interfaceC22053ub1.W(593032271);
            boolean zV = interfaceC22053ub1.V(bVar) | interfaceC22053ub1.V(strA);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new c(bVar, strA, this.g);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC13238ft2.i(strA, z, (SA2) objB, interfaceC22053ub1, 0);
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

    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(androidx.compose.ui.e r29, final ir.nasim.C19818qz6 r30, final ir.nasim.C8370Vr2 r31, ir.nasim.SA2 r32, final ir.nasim.InterfaceC14603iB2 r33, final ir.nasim.SA2 r34, ir.nasim.InterfaceC22053ub1 r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13238ft2.f(androidx.compose.ui.e, ir.nasim.qz6, ir.nasim.Vr2, ir.nasim.SA2, ir.nasim.iB2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(androidx.compose.ui.e eVar, C19818qz6 c19818qz6, C8370Vr2 c8370Vr2, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c19818qz6, "$sheetState");
        AbstractC13042fc3.i(c8370Vr2, "$folderBottomSheetState");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onAddToFolderClicked");
        AbstractC13042fc3.i(sa22, "$onCreateFolderClicked");
        f(eVar, c19818qz6, c8370Vr2, sa2, interfaceC14603iB2, sa22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void i(final String str, final boolean z, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "folderName");
        AbstractC13042fc3.i(sa2, "itemClickListener");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1878777341);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC16867m00.e(str, z, androidx.compose.foundation.layout.t.k(aVar, g10.c(interfaceC22053ub1J, i3).b().q(), 0.0f, 2, null), null, sa2, false, new C11984ds7(g10.a(interfaceC22053ub1J, i3).M(), g10.a(interfaceC22053ub1J, i3).F(), g10.a(interfaceC22053ub1J, i3).z(), g10.a(interfaceC22053ub1J, i3).B(), null), interfaceC22053ub1J, ((i2 << 6) & 57344) | (i2 & 14) | (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (C11984ds7.f << 18), 40);
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1J, i3).A(), interfaceC22053ub1J, 6, 2);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.et2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13238ft2.j(str, z, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(String str, boolean z, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$folderName");
        AbstractC13042fc3.i(sa2, "$itemClickListener");
        i(str, z, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void k(final C8370Vr2 c8370Vr2, final SA2 sa2, final InterfaceC14603iB2 interfaceC14603iB2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c8370Vr2, "folderBottomSheetState");
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(interfaceC14603iB2, "onAddToFolderClicked");
        AbstractC13042fc3.i(sa22, "onCreateFolderClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-587729508);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c8370Vr2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(412301803);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(c8370Vr2, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            final Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            final List listC = m(interfaceC9102Ym4).c();
            interfaceC22053ub1J.W(412308766);
            boolean zD = ((i2 & 896) == 256) | ((i2 & 7168) == 2048) | interfaceC22053ub1J.D(listC) | interfaceC22053ub1J.D(context) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == aVar.a()) {
                UA2 ua2 = new UA2() { // from class: ir.nasim.ct2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC13238ft2.o(listC, context, interfaceC9102Ym4, sa22, interfaceC14603iB2, sa2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(ua2);
                objB2 = ua2;
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1J, 0, 511);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.dt2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13238ft2.l(c8370Vr2, sa2, interfaceC14603iB2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(C8370Vr2 c8370Vr2, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8370Vr2, "$folderBottomSheetState");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onAddToFolderClicked");
        AbstractC13042fc3.i(sa22, "$onCreateFolderClicked");
        k(c8370Vr2, sa2, interfaceC14603iB2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8370Vr2 m(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (C8370Vr2) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(InterfaceC9102Ym4 interfaceC9102Ym4, C8370Vr2 c8370Vr2) {
        interfaceC9102Ym4.setValue(c8370Vr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(List list, Context context, InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$folders");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$state$delegate");
        AbstractC13042fc3.i(sa2, "$onCreateFolderClicked");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onAddToFolderClicked");
        AbstractC13042fc3.i(sa22, "$onDismissRequest");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        interfaceC15069ix3.a(list.size(), null, new g(f.e, list), AbstractC19242q11.c(-632812321, true, new h(list, context, interfaceC9102Ym4)));
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1193351153, true, new d(sa2)), 3, null);
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1871600984, true, new e(interfaceC14603iB2, sa22, interfaceC9102Ym4)), 3, null);
        return C19938rB7.a;
    }
}
