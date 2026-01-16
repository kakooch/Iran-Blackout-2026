package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.C10424bb1;
import ir.nasim.C9804ab1;
import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* renamed from: ir.nasim.Yp4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9129Yp4 {

    /* renamed from: ir.nasim.Yp4$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C8588Wp4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C8588Wp4 c8588Wp4) {
            super(0);
            this.e = c8588Wp4;
        }

        public final void a() {
            this.e.V();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yp4$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Map e;
        final /* synthetic */ C10424bb1 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ InterfaceC9664aL6 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Map map, C10424bb1 c10424bb1, UA2 ua2, UA2 ua22, InterfaceC9664aL6 interfaceC9664aL6) {
            super(1);
            this.e = map;
            this.f = c10424bb1;
            this.g = ua2;
            this.h = ua22;
            this.i = interfaceC9664aL6;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C17312ml1 invoke(androidx.compose.animation.d dVar) {
            float fFloatValue;
            if (!AbstractC9129Yp4.f(this.i).contains(dVar.b())) {
                return androidx.compose.animation.a.e(androidx.compose.animation.h.a.a(), androidx.compose.animation.j.a.a());
            }
            Float f = (Float) this.e.get(((androidx.navigation.d) dVar.b()).f());
            if (f != null) {
                fFloatValue = f.floatValue();
            } else {
                this.e.put(((androidx.navigation.d) dVar.b()).f(), Float.valueOf(0.0f));
                fFloatValue = 0.0f;
            }
            if (!AbstractC13042fc3.d(((androidx.navigation.d) dVar.a()).f(), ((androidx.navigation.d) dVar.b()).f())) {
                fFloatValue = ((Boolean) this.f.getIsPop().getValue()).booleanValue() ? fFloatValue - 1.0f : fFloatValue + 1.0f;
            }
            float f2 = fFloatValue;
            this.e.put(((androidx.navigation.d) dVar.a()).f(), Float.valueOf(f2));
            return new C17312ml1((androidx.compose.animation.h) this.g.invoke(dVar), (androidx.compose.animation.j) this.h.invoke(dVar), f2, null, 8, null);
        }
    }

    /* renamed from: ir.nasim.Yp4$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(androidx.navigation.d dVar) {
            return dVar.f();
        }
    }

    /* renamed from: ir.nasim.Yp4$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC9809ab6 e;
        final /* synthetic */ InterfaceC9664aL6 f;

        /* renamed from: ir.nasim.Yp4$e$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ androidx.navigation.d e;
            final /* synthetic */ InterfaceC5757Ks f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(androidx.navigation.d dVar, InterfaceC5757Ks interfaceC5757Ks) {
                super(2);
                this.e = dVar;
                this.f = interfaceC5757Ks;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1425390790, i, -1, "androidx.navigation.compose.NavHost.<anonymous>.<anonymous> (NavHost.kt:306)");
                }
                androidx.navigation.i iVarE = this.e.e();
                AbstractC13042fc3.g(iVarE, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                ((C10424bb1.b) iVarE).W().e(this.f, this.e, interfaceC22053ub1, 72);
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
        e(InterfaceC9809ab6 interfaceC9809ab6, InterfaceC9664aL6 interfaceC9664aL6) {
            super(4);
            this.e = interfaceC9809ab6;
            this.f = interfaceC9664aL6;
        }

        public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            Object objPrevious;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1440061047, i, -1, "androidx.navigation.compose.NavHost.<anonymous> (NavHost.kt:301)");
            }
            List listF = AbstractC9129Yp4.f(this.f);
            ListIterator listIterator = listF.listIterator(listF.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (AbstractC13042fc3.d(dVar, (androidx.navigation.d) objPrevious)) {
                        break;
                    }
                }
            }
            androidx.navigation.d dVar2 = (androidx.navigation.d) objPrevious;
            if (dVar2 != null) {
                AbstractC7413Rp4.a(dVar2, this.e, AbstractC19242q11.b(interfaceC22053ub1, -1425390790, true, new a(dVar2, interfaceC5757Ks)), interfaceC22053ub1, 456);
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yp4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C21669tv7 c;
        final /* synthetic */ Map d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ C10424bb1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C21669tv7 c21669tv7, Map map, InterfaceC9664aL6 interfaceC9664aL6, C10424bb1 c10424bb1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c21669tv7;
            this.d = map;
            this.e = interfaceC9664aL6;
            this.f = c10424bb1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (AbstractC13042fc3.d(this.c.h(), this.c.o())) {
                List listF = AbstractC9129Yp4.f(this.e);
                C10424bb1 c10424bb1 = this.f;
                Iterator it = listF.iterator();
                while (it.hasNext()) {
                    c10424bb1.o((androidx.navigation.d) it.next());
                }
                Map map = this.d;
                C21669tv7 c21669tv7 = this.c;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (!AbstractC13042fc3.d(entry.getKey(), ((androidx.navigation.d) c21669tv7.o()).f())) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Map map2 = this.d;
                Iterator it2 = linkedHashMap.entrySet().iterator();
                while (it2.hasNext()) {
                    map2.remove(((Map.Entry) it2.next()).getKey());
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Yp4$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ C10424bb1 f;

        /* renamed from: ir.nasim.Yp4$g$a */
        public static final class a implements KV1 {
            final /* synthetic */ InterfaceC9664aL6 a;
            final /* synthetic */ C10424bb1 b;

            public a(InterfaceC9664aL6 interfaceC9664aL6, C10424bb1 c10424bb1) {
                this.a = interfaceC9664aL6;
                this.b = c10424bb1;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                Iterator it = AbstractC9129Yp4.f(this.a).iterator();
                while (it.hasNext()) {
                    this.b.o((androidx.navigation.d) it.next());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC9664aL6 interfaceC9664aL6, C10424bb1 c10424bb1) {
            super(1);
            this.e = interfaceC9664aL6;
            this.f = c10424bb1;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            return new a(this.e, this.f);
        }
    }

    /* renamed from: ir.nasim.Yp4$h */
    static final class h extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C8588Wp4 e;
        final /* synthetic */ androidx.navigation.j f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ InterfaceC12529em h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ UA2 k;
        final /* synthetic */ UA2 l;
        final /* synthetic */ int m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C8588Wp4 c8588Wp4, androidx.navigation.j jVar, androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, int i, int i2) {
            super(2);
            this.e = c8588Wp4;
            this.f = jVar;
            this.g = eVar;
            this.h = interfaceC12529em;
            this.i = ua2;
            this.j = ua22;
            this.k = ua23;
            this.l = ua24;
            this.m = i;
            this.n = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
            AbstractC9129Yp4.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC22053ub1, QJ5.a(this.m | 1), this.n);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yp4$i */
    static final class i extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C8588Wp4 e;
        final /* synthetic */ String f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ String h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C8588Wp4 c8588Wp4, String str, androidx.compose.ui.e eVar, String str2, UA2 ua2, int i, int i2) {
            super(2);
            this.e = c8588Wp4;
            this.f = str;
            this.g = eVar;
            this.h = str2;
            this.i = ua2;
            this.j = i;
            this.k = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
            AbstractC9129Yp4.c(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1), this.k);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yp4$j */
    static final class j extends AbstractC8614Ws3 implements UA2 {
        public static final j e = new j();

        j() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.animation.h invoke(androidx.compose.animation.d dVar) {
            return androidx.compose.animation.f.o(AbstractC5999Lt.l(700, 0, null, 6, null), 0.0f, 2, null);
        }
    }

    /* renamed from: ir.nasim.Yp4$k */
    static final class k extends AbstractC8614Ws3 implements UA2 {
        public static final k e = new k();

        k() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.animation.j invoke(androidx.compose.animation.d dVar) {
            return androidx.compose.animation.f.q(AbstractC5999Lt.l(700, 0, null, 6, null), 0.0f, 2, null);
        }
    }

    /* renamed from: ir.nasim.Yp4$l */
    static final class l extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C8588Wp4 e;
        final /* synthetic */ String f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ InterfaceC12529em h;
        final /* synthetic */ String i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ UA2 k;
        final /* synthetic */ UA2 l;
        final /* synthetic */ UA2 m;
        final /* synthetic */ UA2 n;
        final /* synthetic */ int o;
        final /* synthetic */ int p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(C8588Wp4 c8588Wp4, String str, androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em, String str2, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25, int i, int i2) {
            super(2);
            this.e = c8588Wp4;
            this.f = str;
            this.g = eVar;
            this.h = interfaceC12529em;
            this.i = str2;
            this.j = ua2;
            this.k = ua22;
            this.l = ua23;
            this.m = ua24;
            this.n = ua25;
            this.o = i;
            this.p = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
            AbstractC9129Yp4.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, interfaceC22053ub1, QJ5.a(this.o | 1), this.p);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yp4$m */
    static final class m extends AbstractC8614Ws3 implements UA2 {
        public static final m e = new m();

        m() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.animation.h invoke(androidx.compose.animation.d dVar) {
            return androidx.compose.animation.f.o(AbstractC5999Lt.l(700, 0, null, 6, null), 0.0f, 2, null);
        }
    }

    /* renamed from: ir.nasim.Yp4$n */
    static final class n extends AbstractC8614Ws3 implements UA2 {
        public static final n e = new n();

        n() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.animation.j invoke(androidx.compose.animation.d dVar) {
            return androidx.compose.animation.f.q(AbstractC5999Lt.l(700, 0, null, 6, null), 0.0f, 2, null);
        }
    }

    /* renamed from: ir.nasim.Yp4$o */
    static final class o extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C8588Wp4 e;
        final /* synthetic */ androidx.navigation.j f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ InterfaceC12529em h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ UA2 k;
        final /* synthetic */ UA2 l;
        final /* synthetic */ int m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(C8588Wp4 c8588Wp4, androidx.navigation.j jVar, androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, int i, int i2) {
            super(2);
            this.e = c8588Wp4;
            this.f = jVar;
            this.g = eVar;
            this.h = interfaceC12529em;
            this.i = ua2;
            this.j = ua22;
            this.k = ua23;
            this.l = ua24;
            this.m = i;
            this.n = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
            AbstractC9129Yp4.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC22053ub1, QJ5.a(this.m | 1), this.n);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yp4$p */
    static final class p extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C8588Wp4 e;
        final /* synthetic */ androidx.navigation.j f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ InterfaceC12529em h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ UA2 k;
        final /* synthetic */ UA2 l;
        final /* synthetic */ int m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(C8588Wp4 c8588Wp4, androidx.navigation.j jVar, androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, int i, int i2) {
            super(2);
            this.e = c8588Wp4;
            this.f = jVar;
            this.g = eVar;
            this.h = interfaceC12529em;
            this.i = ua2;
            this.j = ua22;
            this.k = ua23;
            this.l = ua24;
            this.m = i;
            this.n = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
            AbstractC9129Yp4.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC22053ub1, QJ5.a(this.m | 1), this.n);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yp4$q */
    static final class q extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C10424bb1 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ UA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(C10424bb1 c10424bb1, UA2 ua2, UA2 ua22) {
            super(1);
            this.e = c10424bb1;
            this.f = ua2;
            this.g = ua22;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.animation.h invoke(androidx.compose.animation.d dVar) {
            androidx.navigation.i iVarE = ((androidx.navigation.d) dVar.a()).e();
            AbstractC13042fc3.g(iVarE, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
            C10424bb1.b bVar = (C10424bb1.b) iVarE;
            androidx.compose.animation.h hVar = null;
            if (((Boolean) this.e.getIsPop().getValue()).booleanValue()) {
                Iterator it = androidx.navigation.i.j.c(bVar).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    androidx.compose.animation.h hVarO = AbstractC9129Yp4.o((androidx.navigation.i) it.next(), dVar);
                    if (hVarO != null) {
                        hVar = hVarO;
                        break;
                    }
                }
                return hVar == null ? (androidx.compose.animation.h) this.f.invoke(dVar) : hVar;
            }
            Iterator it2 = androidx.navigation.i.j.c(bVar).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                androidx.compose.animation.h hVarM = AbstractC9129Yp4.m((androidx.navigation.i) it2.next(), dVar);
                if (hVarM != null) {
                    hVar = hVarM;
                    break;
                }
            }
            return hVar == null ? (androidx.compose.animation.h) this.g.invoke(dVar) : hVar;
        }
    }

    /* renamed from: ir.nasim.Yp4$r */
    static final class r extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C10424bb1 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ UA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(C10424bb1 c10424bb1, UA2 ua2, UA2 ua22) {
            super(1);
            this.e = c10424bb1;
            this.f = ua2;
            this.g = ua22;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.animation.j invoke(androidx.compose.animation.d dVar) {
            androidx.navigation.i iVarE = ((androidx.navigation.d) dVar.b()).e();
            AbstractC13042fc3.g(iVarE, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
            C10424bb1.b bVar = (C10424bb1.b) iVarE;
            androidx.compose.animation.j jVar = null;
            if (((Boolean) this.e.getIsPop().getValue()).booleanValue()) {
                Iterator it = androidx.navigation.i.j.c(bVar).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    androidx.compose.animation.j jVarP = AbstractC9129Yp4.p((androidx.navigation.i) it.next(), dVar);
                    if (jVarP != null) {
                        jVar = jVarP;
                        break;
                    }
                }
                return jVar == null ? (androidx.compose.animation.j) this.f.invoke(dVar) : jVar;
            }
            Iterator it2 = androidx.navigation.i.j.c(bVar).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                androidx.compose.animation.j jVarN = AbstractC9129Yp4.n((androidx.navigation.i) it2.next(), dVar);
                if (jVarN != null) {
                    jVar = jVarN;
                    break;
                }
            }
            return jVar == null ? (androidx.compose.animation.j) this.g.invoke(dVar) : jVar;
        }
    }

    /* renamed from: ir.nasim.Yp4$s */
    static final class s extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(InterfaceC9664aL6 interfaceC9664aL6) {
            super(0);
            this.e = interfaceC9664aL6;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List listE = AbstractC9129Yp4.e(this.e);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listE) {
                if (AbstractC13042fc3.d(((androidx.navigation.d) obj).e().B(), "composable")) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    public static final void a(C8588Wp4 c8588Wp4, androidx.navigation.j jVar, androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) throws Resources.NotFoundException {
        UA2 ua25;
        int i4;
        UA2 ua26;
        UA2 ua27;
        YO1 yo1;
        int i5;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1818191915);
        androidx.compose.ui.e eVar2 = (i3 & 4) != 0 ? androidx.compose.ui.e.a : eVar;
        InterfaceC12529em interfaceC12529emE = (i3 & 8) != 0 ? InterfaceC12529em.a.e() : interfaceC12529em;
        UA2 ua28 = (i3 & 16) != 0 ? m.e : ua2;
        UA2 ua29 = (i3 & 32) != 0 ? n.e : ua22;
        if ((i3 & 64) != 0) {
            i4 = i2 & (-3670017);
            ua25 = ua28;
        } else {
            ua25 = ua23;
            i4 = i2;
        }
        if ((i3 & 128) != 0) {
            i4 &= -29360129;
            ua26 = ua29;
        } else {
            ua26 = ua24;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1818191915, i4, -1, "androidx.navigation.compose.NavHost (NavHost.kt:195)");
        }
        InterfaceC18633oz3 interfaceC18633oz3 = (InterfaceC18633oz3) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        InterfaceC15408jX7 interfaceC15408jX7A = C24834zH3.a.a(interfaceC22053ub1J, C24834zH3.c);
        if (interfaceC15408jX7A == null) {
            throw new IllegalStateException("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner".toString());
        }
        c8588Wp4.m0(interfaceC15408jX7A.d1());
        c8588Wp4.j0(jVar);
        androidx.navigation.p pVarE = c8588Wp4.H().e("composable");
        C10424bb1 c10424bb1 = pVarE instanceof C10424bb1 ? (C10424bb1) pVarE : null;
        if (c10424bb1 == null) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M == null) {
                return;
            }
            interfaceC20208rd6M.a(new o(c8588Wp4, jVar, eVar2, interfaceC12529emE, ua28, ua29, ua25, ua26, i2, i3));
            return;
        }
        UV.a(d(AbstractC10222bH6.b(c10424bb1.m(), null, interfaceC22053ub1J, 8, 1)).size() > 1, new a(c8588Wp4), interfaceC22053ub1J, 0, 0);
        AbstractC10721c52.a(interfaceC18633oz3, new b(c8588Wp4, interfaceC18633oz3), interfaceC22053ub1J, 8);
        InterfaceC9809ab6 interfaceC9809ab6A = AbstractC11019cb6.a(interfaceC22053ub1J, 0);
        InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(c8588Wp4.I(), null, interfaceC22053ub1J, 8, 1);
        interfaceC22053ub1J.A(-492369756);
        Object objB = interfaceC22053ub1J.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC10222bH6.d(new s(interfaceC9664aL6B));
            interfaceC22053ub1J.s(objB);
        }
        interfaceC22053ub1J.U();
        InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB;
        androidx.navigation.d dVar = (androidx.navigation.d) AbstractC15401jX0.F0(f(interfaceC9664aL6));
        interfaceC22053ub1J.A(-492369756);
        Object objB2 = interfaceC22053ub1J.B();
        if (objB2 == aVar.a()) {
            objB2 = new LinkedHashMap();
            interfaceC22053ub1J.s(objB2);
        }
        interfaceC22053ub1J.U();
        Map map = (Map) objB2;
        interfaceC22053ub1J.A(1822177954);
        if (dVar != null) {
            interfaceC22053ub1J.A(1618982084);
            boolean zV = interfaceC22053ub1J.V(c10424bb1) | interfaceC22053ub1J.V(ua25) | interfaceC22053ub1J.V(ua28);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV || objB3 == aVar.a()) {
                objB3 = new q(c10424bb1, ua25, ua28);
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.U();
            UA2 ua210 = (UA2) objB3;
            interfaceC22053ub1J.A(1618982084);
            boolean zV2 = interfaceC22053ub1J.V(c10424bb1) | interfaceC22053ub1J.V(ua26) | interfaceC22053ub1J.V(ua29);
            Object objB4 = interfaceC22053ub1J.B();
            if (zV2 || objB4 == aVar.a()) {
                objB4 = new r(c10424bb1, ua26, ua29);
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.U();
            ua27 = ua26;
            i5 = 0;
            C21669tv7 c21669tv7H = AbstractC4139Dv7.h(dVar, "entry", interfaceC22053ub1J, 56, 0);
            c cVar = new c(map, c10424bb1, ua210, (UA2) objB4, interfaceC9664aL6);
            d dVar2 = d.e;
            InterfaceC18060o11 interfaceC18060o11B = AbstractC19242q11.b(interfaceC22053ub1J, -1440061047, true, new e(interfaceC9809ab6A, interfaceC9664aL6));
            int i6 = ((i4 >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 221184 | (i4 & 7168);
            yo1 = null;
            C10424bb1 c10424bb12 = c10424bb1;
            androidx.compose.animation.a.a(c21669tv7H, eVar2, cVar, interfaceC12529emE, dVar2, interfaceC18060o11B, interfaceC22053ub1J, i6, 0);
            AbstractC10721c52.f(c21669tv7H.h(), c21669tv7H.o(), new f(c21669tv7H, map, interfaceC9664aL6, c10424bb12, null), interfaceC22053ub1J, 584);
            Boolean bool = Boolean.TRUE;
            interfaceC22053ub1J.A(511388516);
            boolean zV3 = interfaceC22053ub1J.V(interfaceC9664aL6) | interfaceC22053ub1J.V(c10424bb12);
            Object objB5 = interfaceC22053ub1J.B();
            if (zV3 || objB5 == aVar.a()) {
                objB5 = new g(interfaceC9664aL6, c10424bb12);
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.U();
            AbstractC10721c52.a(bool, (UA2) objB5, interfaceC22053ub1J, 6);
        } else {
            ua27 = ua26;
            yo1 = null;
            i5 = 0;
        }
        interfaceC22053ub1J.U();
        androidx.navigation.p pVarE2 = c8588Wp4.H().e("dialog");
        YO1 yo12 = pVarE2 instanceof YO1 ? (YO1) pVarE2 : yo1;
        if (yo12 == null) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M2 == null) {
                return;
            }
            interfaceC20208rd6M2.a(new p(c8588Wp4, jVar, eVar2, interfaceC12529emE, ua28, ua29, ua25, ua27, i2, i3));
            return;
        }
        DN1.a(yo12, interfaceC22053ub1J, i5);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M3 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M3 == null) {
            return;
        }
        interfaceC20208rd6M3.a(new h(c8588Wp4, jVar, eVar2, interfaceC12529emE, ua28, ua29, ua25, ua27, i2, i3));
    }

    public static final void b(C8588Wp4 c8588Wp4, String str, androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em, String str2, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) throws Resources.NotFoundException {
        UA2 ua26;
        int i4;
        UA2 ua27;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(410432995);
        androidx.compose.ui.e eVar2 = (i3 & 4) != 0 ? androidx.compose.ui.e.a : eVar;
        InterfaceC12529em interfaceC12529emE = (i3 & 8) != 0 ? InterfaceC12529em.a.e() : interfaceC12529em;
        String str3 = (i3 & 16) != 0 ? null : str2;
        UA2 ua28 = (i3 & 32) != 0 ? j.e : ua2;
        UA2 ua29 = (i3 & 64) != 0 ? k.e : ua22;
        if ((i3 & 128) != 0) {
            i4 = i2 & (-29360129);
            ua26 = ua28;
        } else {
            ua26 = ua23;
            i4 = i2;
        }
        if ((i3 & 256) != 0) {
            i4 &= -234881025;
            ua27 = ua29;
        } else {
            ua27 = ua24;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(410432995, i4, -1, "androidx.navigation.compose.NavHost (NavHost.kt:126)");
        }
        interfaceC22053ub1J.A(1618982084);
        boolean zV = interfaceC22053ub1J.V(str3) | interfaceC22053ub1J.V(str) | interfaceC22053ub1J.V(ua25);
        Object objB = interfaceC22053ub1J.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            C8120Up4 c8120Up4 = new C8120Up4(c8588Wp4.H(), str, str3);
            ua25.invoke(c8120Up4);
            objB = c8120Up4.d();
            interfaceC22053ub1J.s(objB);
        }
        interfaceC22053ub1J.U();
        int i5 = (i4 & 896) | 72 | (i4 & 7168);
        int i6 = i4 >> 3;
        a(c8588Wp4, (androidx.navigation.j) objB, eVar2, interfaceC12529emE, ua28, ua29, ua26, ua27, interfaceC22053ub1J, i5 | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (i6 & 29360128), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M == null) {
            return;
        }
        interfaceC20208rd6M.a(new l(c8588Wp4, str, eVar2, interfaceC12529emE, str3, ua28, ua29, ua26, ua27, ua25, i2, i3));
    }

    public static final /* synthetic */ void c(C8588Wp4 c8588Wp4, String str, androidx.compose.ui.e eVar, String str2, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) throws Resources.NotFoundException {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(141827520);
        androidx.compose.ui.e eVar2 = (i3 & 4) != 0 ? androidx.compose.ui.e.a : eVar;
        String str3 = (i3 & 8) != 0 ? null : str2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(141827520, i2, -1, "androidx.navigation.compose.NavHost (NavHost.kt:80)");
        }
        interfaceC22053ub1J.A(1618982084);
        boolean zV = interfaceC22053ub1J.V(str3) | interfaceC22053ub1J.V(str) | interfaceC22053ub1J.V(ua2);
        Object objB = interfaceC22053ub1J.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            C8120Up4 c8120Up4 = new C8120Up4(c8588Wp4.H(), str, str3);
            ua2.invoke(c8120Up4);
            objB = c8120Up4.d();
            interfaceC22053ub1J.s(objB);
        }
        interfaceC22053ub1J.U();
        a(c8588Wp4, (androidx.navigation.j) objB, eVar2, null, null, null, null, null, interfaceC22053ub1J, (i2 & 896) | 72, 248);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M == null) {
            return;
        }
        interfaceC20208rd6M.a(new i(c8588Wp4, str, eVar2, str3, ua2, i2, i3));
    }

    private static final List d(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.animation.h m(androidx.navigation.i iVar, androidx.compose.animation.d dVar) {
        UA2 ua2O0;
        if (iVar instanceof C10424bb1.b) {
            UA2 ua2Y = ((C10424bb1.b) iVar).Y();
            if (ua2Y != null) {
                return (androidx.compose.animation.h) ua2Y.invoke(dVar);
            }
            return null;
        }
        if (!(iVar instanceof C9804ab1.a) || (ua2O0 = ((C9804ab1.a) iVar).o0()) == null) {
            return null;
        }
        return (androidx.compose.animation.h) ua2O0.invoke(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.animation.j n(androidx.navigation.i iVar, androidx.compose.animation.d dVar) {
        UA2 ua2P0;
        if (iVar instanceof C10424bb1.b) {
            UA2 ua2Z = ((C10424bb1.b) iVar).Z();
            if (ua2Z != null) {
                return (androidx.compose.animation.j) ua2Z.invoke(dVar);
            }
            return null;
        }
        if (!(iVar instanceof C9804ab1.a) || (ua2P0 = ((C9804ab1.a) iVar).p0()) == null) {
            return null;
        }
        return (androidx.compose.animation.j) ua2P0.invoke(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.animation.h o(androidx.navigation.i iVar, androidx.compose.animation.d dVar) {
        UA2 ua2Q0;
        if (iVar instanceof C10424bb1.b) {
            UA2 ua2A0 = ((C10424bb1.b) iVar).a0();
            if (ua2A0 != null) {
                return (androidx.compose.animation.h) ua2A0.invoke(dVar);
            }
            return null;
        }
        if (!(iVar instanceof C9804ab1.a) || (ua2Q0 = ((C9804ab1.a) iVar).q0()) == null) {
            return null;
        }
        return (androidx.compose.animation.h) ua2Q0.invoke(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.animation.j p(androidx.navigation.i iVar, androidx.compose.animation.d dVar) {
        UA2 ua2R0;
        if (iVar instanceof C10424bb1.b) {
            UA2 ua2B0 = ((C10424bb1.b) iVar).b0();
            if (ua2B0 != null) {
                return (androidx.compose.animation.j) ua2B0.invoke(dVar);
            }
            return null;
        }
        if (!(iVar instanceof C9804ab1.a) || (ua2R0 = ((C9804ab1.a) iVar).r0()) == null) {
            return null;
        }
        return (androidx.compose.animation.j) ua2R0.invoke(dVar);
    }

    /* renamed from: ir.nasim.Yp4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C8588Wp4 e;
        final /* synthetic */ InterfaceC18633oz3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C8588Wp4 c8588Wp4, InterfaceC18633oz3 interfaceC18633oz3) {
            super(1);
            this.e = c8588Wp4;
            this.f = interfaceC18633oz3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.l0(this.f);
            return new a();
        }

        /* renamed from: ir.nasim.Yp4$b$a */
        public static final class a implements KV1 {
            @Override // ir.nasim.KV1
            public void dispose() {
            }
        }
    }
}
