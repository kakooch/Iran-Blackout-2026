package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import com.skydoves.balloon.compose.BalloonComposeView;
import ir.nasim.AbstractC21430te5;
import ir.nasim.D20;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class J20 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(ComposeView composeView) {
            AbstractC13042fc3.i(composeView, "it");
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((ComposeView) obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final void a(Z20 z20) {
            AbstractC13042fc3.i(z20, "it");
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Z20) obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ BalloonComposeView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UA2 ua2, BalloonComposeView balloonComposeView, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = balloonComposeView;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.invoke(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ float e;
        final /* synthetic */ float f;
        final /* synthetic */ int g;
        final /* synthetic */ BalloonComposeView h;
        final /* synthetic */ InterfaceC14603iB2 i;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ int e;
            final /* synthetic */ BalloonComposeView f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i, BalloonComposeView balloonComposeView) {
                super(1);
                this.e = i;
                this.f = balloonComposeView;
            }

            public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
                AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
                long jA = interfaceC11379cu3.a();
                int iG = C4414Fa3.g(jA);
                int iG2 = this.e;
                if (iG <= iG2) {
                    iG2 = C4414Fa3.g(jA);
                }
                long jA2 = AbstractC4663Ga3.a(iG2, C4414Fa3.f(interfaceC11379cu3.a()));
                this.f.p(jA2);
                this.f.getBalloonLayoutInfo().setValue(new Q20(ZG4.m(AbstractC12000du3.f(interfaceC11379cu3)), ZG4.n(AbstractC12000du3.f(interfaceC11379cu3)), C4414Fa3.g(jA2), C4414Fa3.f(jA2)));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11379cu3) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(float f, float f2, int i, BalloonComposeView balloonComposeView, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = f;
            this.f = f2;
            this.g = i;
            this.h = balloonComposeView;
            this.i = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(276797535, i, -1, "com.skydoves.balloon.compose.Balloon.<anonymous> (Balloon.kt:129)");
            }
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(AbstractC21571tm.a(androidx.compose.ui.e.a, 0.0f), this.e, 0.0f, this.f, 0.0f, 10, null);
            interfaceC22053ub1.A(-1159531991);
            boolean zE = interfaceC22053ub1.e(this.g) | interfaceC22053ub1.V(this.h);
            int i2 = this.g;
            BalloonComposeView balloonComposeView = this.h;
            Object objB = interfaceC22053ub1.B();
            if (zE || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(i2, balloonComposeView);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.U();
            androidx.compose.ui.e eVarA = androidx.compose.ui.layout.c.a(eVarM, (UA2) objB);
            InterfaceC14603iB2 interfaceC14603iB2 = this.i;
            interfaceC22053ub1.A(733328855);
            InterfaceC10970cW3 interfaceC10970cW3I = androidx.compose.foundation.layout.f.i(InterfaceC12529em.a.o(), false, interfaceC22053ub1, 0);
            interfaceC22053ub1.A(-1323940314);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            InterfaceC15796kB2 interfaceC15796kB2D = AbstractC19768qu3.d(eVarA);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3I, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC15796kB2D.q(C12827fE6.a(C12827fE6.b(interfaceC22053ub1)), interfaceC22053ub1, 0);
            interfaceC22053ub1.A(2058660585);
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub1.A(-233420289);
            if (interfaceC14603iB2 != null) {
                interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
            }
            interfaceC22053ub1.U();
            interfaceC22053ub1.U();
            interfaceC22053ub1.u();
            interfaceC22053ub1.U();
            interfaceC22053ub1.U();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ BalloonComposeView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(BalloonComposeView balloonComposeView) {
            super(1);
            this.e = balloonComposeView;
        }

        public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
            AbstractC13042fc3.i(interfaceC11379cu3, "it");
            BalloonComposeView balloonComposeView = this.e;
            E20 e20R = balloonComposeView.getBalloon().R();
            if (e20R == null) {
                e20R = E20.d;
            }
            balloonComposeView.o(e20R, 0, 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11379cu3) obj);
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ ComposeView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ComposeView composeView) {
            super(1);
            this.e = composeView;
        }

        public final void a(long j) {
            ComposeView composeView = this.e;
            ViewGroup.LayoutParams layoutParams = composeView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.width = C4414Fa3.g(j);
            layoutParams.height = C4414Fa3.f(j);
            composeView.setLayoutParams(layoutParams);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((C4414Fa3) obj).j());
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ ComposeView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(ComposeView composeView) {
            super(1);
            this.e = composeView;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ComposeView invoke(Context context) {
            AbstractC13042fc3.i(context, "it");
            return this.e;
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ BalloonComposeView e;
        final /* synthetic */ ComposeView f;

        public static final class a implements KV1 {
            final /* synthetic */ BalloonComposeView a;
            final /* synthetic */ ComposeView b;

            public a(BalloonComposeView balloonComposeView, ComposeView composeView) {
                this.a = balloonComposeView;
                this.b = composeView;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.n();
                ComposeView composeView = this.b;
                XX7.b(composeView, null);
                VX7.b(composeView, null);
                YX7.b(composeView, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(BalloonComposeView balloonComposeView, ComposeView composeView) {
            super(1);
            this.e = balloonComposeView;
            this.f = composeView;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
            return new a(this.e, this.f);
        }
    }

    static final class i extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ D20.a f;
        final /* synthetic */ Object g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ InterfaceC15796kB2 k;
        final /* synthetic */ int l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(androidx.compose.ui.e eVar, D20.a aVar, Object obj, UA2 ua2, UA2 ua22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = aVar;
            this.g = obj;
            this.h = ua2;
            this.i = ua22;
            this.j = interfaceC14603iB2;
            this.k = interfaceC15796kB2;
            this.l = i;
            this.m = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            J20.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC22053ub1, QJ5.a(this.l | 1), this.m);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class j implements Runnable {
        final /* synthetic */ UA2 a;
        final /* synthetic */ ComposeView b;

        j(UA2 ua2, ComposeView composeView) {
            this.a = ua2;
            this.b = composeView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke(this.b);
        }
    }

    static final class k extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9664aL6 e;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
                Y20.a(interfaceC11943do6);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC9664aL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC9664aL6 interfaceC9664aL6) {
                super(2);
                this.e = interfaceC9664aL6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(807728771, i, -1, "com.skydoves.balloon.compose.Balloon.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Balloon.kt:104)");
                }
                InterfaceC14603iB2 interfaceC14603iB2B = J20.b(this.e);
                if (interfaceC14603iB2B != null) {
                    interfaceC14603iB2B.invoke(interfaceC22053ub1, 0);
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(InterfaceC9664aL6 interfaceC9664aL6) {
            super(3);
            this.e = interfaceC9664aL6;
        }

        public final void a(BalloonComposeView balloonComposeView, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(balloonComposeView, "it");
            if ((i & 81) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1629600746, i, -1, "com.skydoves.balloon.compose.Balloon.<anonymous>.<anonymous>.<anonymous> (Balloon.kt:101)");
            }
            J20.c(AbstractC6919Pn6.d(androidx.compose.ui.e.a, false, a.e, 1, null), AbstractC19242q11.b(interfaceC22053ub1, 807728771, true, new b(this.e)), interfaceC22053ub1, 48, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((BalloonComposeView) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class l extends AbstractC8614Ws3 implements SA2 {
        public static final l e = new l();

        l() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    static final class m implements InterfaceC10970cW3 {
        public static final m a = new m();

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list) {
                super(1);
                this.e = list;
            }

            public final void a(AbstractC21430te5.a aVar) {
                AbstractC13042fc3.i(aVar, "$this$layout");
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    AbstractC21430te5.a.h(aVar, (AbstractC21430te5) it.next(), 0, 0, 0.0f, 4, null);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        m() {
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            AbstractC13042fc3.i(interfaceC12377eW3, "$this$Layout");
            AbstractC13042fc3.i(list, "measurables");
            long jD = C17833ne1.d(j, 0, 0, 0, 0, 10, null);
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((ZV3) it.next()).l0(jD));
            }
            Iterator it2 = arrayList.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            int iP0 = ((AbstractC21430te5) it2.next()).P0();
            while (it2.hasNext()) {
                int iP02 = ((AbstractC21430te5) it2.next()).P0();
                if (iP0 < iP02) {
                    iP0 = iP02;
                }
            }
            int iMax = Integer.max(iP0, C17833ne1.n(j));
            Iterator it3 = arrayList.iterator();
            if (!it3.hasNext()) {
                throw new NoSuchElementException();
            }
            int iA0 = ((AbstractC21430te5) it3.next()).A0();
            while (it3.hasNext()) {
                int iA02 = ((AbstractC21430te5) it3.next()).A0();
                if (iA0 < iA02) {
                    iA0 = iA02;
                }
            }
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, iMax, Integer.max(iA0, C17833ne1.m(j)), null, new a(arrayList), 4, null);
        }
    }

    static final class n extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC14603iB2;
            this.g = i;
            this.h = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            J20.c(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1), this.h);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(androidx.compose.ui.e eVar, D20.a aVar, Object obj, UA2 ua2, UA2 ua22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        boolean z;
        Object obj2;
        BalloonComposeView balloonComposeView;
        AbstractC13042fc3.i(aVar, "builder");
        AbstractC13042fc3.i(interfaceC15796kB2, "content");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-851848777);
        androidx.compose.ui.e eVar2 = (i3 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
        Object obj3 = (i3 & 4) != 0 ? null : obj;
        UA2 ua23 = (i3 & 8) != 0 ? a.e : ua2;
        UA2 ua24 = (i3 & 16) != 0 ? b.e : ua22;
        InterfaceC14603iB2 interfaceC14603iB22 = (i3 & 32) != 0 ? null : interfaceC14603iB2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-851848777, i2, -1, "com.skydoves.balloon.compose.Balloon (Balloon.kt:76)");
        }
        Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
        View view = (View) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.k());
        interfaceC22053ub1J.A(-492369756);
        Object objB = interfaceC22053ub1J.B();
        InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
        Object obj4 = objB;
        if (objB == aVar2.a()) {
            ComposeView composeView = new ComposeView(context, null, 0, 6, null);
            VX7.b(composeView, VX7.a(view));
            YX7.b(composeView, YX7.a(view));
            XX7.b(composeView, XX7.a(view));
            composeView.post(new j(ua23, composeView));
            interfaceC22053ub1J.s(composeView);
            obj4 = composeView;
        }
        interfaceC22053ub1J.U();
        ComposeView composeView2 = (ComposeView) obj4;
        AbstractC7050Qb1 abstractC7050Qb1D = AbstractC6797Pa1.d(interfaceC22053ub1J, 0);
        int i4 = i2 >> 15;
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(interfaceC14603iB22, interfaceC22053ub1J, i4 & 14);
        boolean z2 = interfaceC14603iB22 != null;
        InterfaceC14603iB2 interfaceC14603iB23 = interfaceC14603iB22;
        UA2 ua25 = ua24;
        UUID uuid = (UUID) AbstractC9681aN5.e(new Object[0], null, null, l.e, interfaceC22053ub1J, 3080, 6);
        interfaceC22053ub1J.A(1157296644);
        boolean zV = interfaceC22053ub1J.V(obj3);
        Object objB2 = interfaceC22053ub1J.B();
        if (zV || objB2 == aVar2.a()) {
            AbstractC13042fc3.f(uuid);
            BalloonComposeView balloonComposeView2 = new BalloonComposeView(composeView2, z2, aVar, uuid);
            if (z2) {
                z = true;
                balloonComposeView2.setContent(abstractC7050Qb1D, AbstractC19242q11.c(-1629600746, true, new k(interfaceC9664aL6Q)));
            } else {
                z = true;
            }
            interfaceC22053ub1J.s(balloonComposeView2);
            obj2 = balloonComposeView2;
        } else {
            z = true;
            obj2 = objB2;
        }
        interfaceC22053ub1J.U();
        BalloonComposeView balloonComposeView3 = (BalloonComposeView) obj2;
        C19938rB7 c19938rB7 = C19938rB7.a;
        interfaceC22053ub1J.A(-1159532838);
        boolean zD = interfaceC22053ub1J.D(ua25) | interfaceC22053ub1J.V(balloonComposeView3);
        Object objB3 = interfaceC22053ub1J.B();
        if (zD || objB3 == aVar2.a()) {
            objB3 = new c(ua25, balloonComposeView3, null);
            interfaceC22053ub1J.s(objB3);
        }
        interfaceC22053ub1J.U();
        AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB3, interfaceC22053ub1J, 70);
        interfaceC22053ub1J.A(986536304);
        if (z2 && balloonComposeView3.getBalloonLayoutInfo().getValue() == null) {
            Configuration configuration = (Configuration) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.f());
            WH1 wh1 = (WH1) interfaceC22053ub1J.H(AbstractC13040fc1.g());
            interfaceC22053ub1J.A(-492369756);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar2.a()) {
                objB4 = Integer.valueOf((int) wh1.w1(C17784nZ1.q(configuration.screenWidthDp)));
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.U();
            int iIntValue = ((Number) objB4).intValue();
            interfaceC22053ub1J.A(-492369756);
            Object objB5 = interfaceC22053ub1J.B();
            if (objB5 == aVar2.a()) {
                objB5 = C17784nZ1.j(wh1.D(aVar.u0() + aVar.Y()));
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.U();
            float fV = ((C17784nZ1) objB5).v();
            interfaceC22053ub1J.A(-492369756);
            Object objB6 = interfaceC22053ub1J.B();
            if (objB6 == aVar2.a()) {
                objB6 = C17784nZ1.j(wh1.D(aVar.v0() + aVar.Z()));
                interfaceC22053ub1J.s(objB6);
            }
            interfaceC22053ub1J.U();
            float fV2 = ((C17784nZ1) objB6).v();
            balloonComposeView = balloonComposeView3;
            AbstractC6456Nq.c(null, 0L, null, new C7117Qi5(false, false, false, null, false, false, 57, null), AbstractC19242q11.b(interfaceC22053ub1J, 276797535, z, new d(fV, fV2, iIntValue, balloonComposeView3, interfaceC14603iB23)), interfaceC22053ub1J, 27648, 7);
        } else {
            balloonComposeView = balloonComposeView3;
        }
        interfaceC22053ub1J.U();
        interfaceC22053ub1J.A(-1159531166);
        boolean zV2 = interfaceC22053ub1J.V(balloonComposeView);
        Object objB7 = interfaceC22053ub1J.B();
        if (zV2 || objB7 == aVar2.a()) {
            objB7 = new e(balloonComposeView);
            interfaceC22053ub1J.s(objB7);
        }
        interfaceC22053ub1J.U();
        androidx.compose.ui.e eVarA = androidx.compose.ui.layout.e.a(androidx.compose.ui.layout.c.a(eVar2, (UA2) objB7), new f(composeView2));
        interfaceC22053ub1J.A(733328855);
        InterfaceC10970cW3 interfaceC10970cW3I = androidx.compose.foundation.layout.f.i(InterfaceC12529em.a.o(), false, interfaceC22053ub1J, 0);
        interfaceC22053ub1J.A(-1323940314);
        int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
        InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
        InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
        SA2 sa2A = aVar3.a();
        InterfaceC15796kB2 interfaceC15796kB2D = AbstractC19768qu3.d(eVarA);
        if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
            AbstractC6797Pa1.c();
        }
        interfaceC22053ub1J.G();
        if (interfaceC22053ub1J.h()) {
            interfaceC22053ub1J.g(sa2A);
        } else {
            interfaceC22053ub1J.r();
        }
        InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
        DG7.c(interfaceC22053ub1A, interfaceC10970cW3I, aVar3.e());
        DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
        InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
        if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
            interfaceC22053ub1A.s(Integer.valueOf(iA));
            interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
        }
        interfaceC15796kB2D.q(C12827fE6.a(C12827fE6.b(interfaceC22053ub1J)), interfaceC22053ub1J, 0);
        interfaceC22053ub1J.A(2058660585);
        AbstractC11355cs.a(new g(composeView2), androidx.compose.foundation.layout.h.a.e(androidx.compose.ui.e.a), null, interfaceC22053ub1J, 0, 4);
        interfaceC15796kB2.q(balloonComposeView, interfaceC22053ub1J, Integer.valueOf(i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
        interfaceC22053ub1J.U();
        interfaceC22053ub1J.u();
        interfaceC22053ub1J.U();
        interfaceC22053ub1J.U();
        AbstractC10721c52.a(obj3, new h(balloonComposeView, composeView2), interfaceC22053ub1J, 8);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new i(eVar2, aVar, obj3, ua23, ua25, interfaceC14603iB23, interfaceC15796kB2, i2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC14603iB2 b(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC14603iB2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1755950697);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if ((i4 & 91) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i5 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1755950697, i4, -1, "com.skydoves.balloon.compose.BalloonLayout (Balloon.kt:200)");
            }
            m mVar = m.a;
            int i6 = ((i4 >> 3) & 14) | 384 | ((i4 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1J.A(-1323940314);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            InterfaceC15796kB2 interfaceC15796kB2D = AbstractC19768qu3.d(eVar);
            int i7 = ((i6 << 9) & 7168) | 6;
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, mVar, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC15796kB2D.q(C12827fE6.a(C12827fE6.b(interfaceC22053ub1J)), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.A(2058660585);
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf((i7 >> 9) & 14));
            interfaceC22053ub1J.U();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.U();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new n(eVar, interfaceC14603iB2, i2, i3));
        }
    }
}
