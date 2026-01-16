package ir.nasim;

import android.util.Log;
import androidx.compose.animation.tooling.ComposeAnimation;
import ir.nasim.C5298It;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Zo5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C9355Zo5 {
    private final SA2 a;
    private final boolean c;
    private final String b = "PreviewAnimationClock";
    private final Map d = new LinkedHashMap();
    private final Map e = new LinkedHashMap();
    private final Map f = new LinkedHashMap();
    private final Map g = new LinkedHashMap();
    private final Map h = new LinkedHashMap();
    private final LinkedHashSet i = new LinkedHashSet();
    private final LinkedHashSet j = new LinkedHashSet();
    private final Object k = new Object();

    /* renamed from: ir.nasim.Zo5$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C5298It.c e;
        final /* synthetic */ C9355Zo5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C5298It.c cVar, C9355Zo5 c9355Zo5) {
            super(1);
            this.e = cVar;
            this.f = c9355Zo5;
        }

        public final void a(Object obj) {
            C5289Is c5289IsB = C5289Is.g.b(this.e);
            if (c5289IsB == null) {
                this.f.c(this.e.a().m());
                return;
            }
            C9355Zo5 c9355Zo5 = this.f;
            c9355Zo5.e().put(c5289IsB, new C5055Hs(c5289IsB));
            c9355Zo5.j(c5289IsB);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zo5$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ C9355Zo5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C21669tv7 c21669tv7, C9355Zo5 c9355Zo5) {
            super(1);
            this.e = c21669tv7;
            this.f = c9355Zo5;
        }

        public final void a(Object obj) {
            C5523Js c5523JsB = C5523Js.e.b(this.e);
            if (c5523JsB == null) {
                this.f.c(this.e.j());
                return;
            }
            C9355Zo5 c9355Zo5 = this.f;
            c9355Zo5.f().put(c5523JsB, new C24035xv7(c5523JsB));
            c9355Zo5.j(c5523JsB);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zo5$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ C9355Zo5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C21669tv7 c21669tv7, SA2 sa2, C9355Zo5 c9355Zo5) {
            super(1);
            this.e = c21669tv7;
            this.f = sa2;
            this.g = c9355Zo5;
        }

        public final void a(Object obj) {
            AbstractC13042fc3.g(this.e, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Boolean>");
            C20954st c20954stA = AbstractC21641tt.a(this.e);
            this.f.invoke();
            Map mapG = this.g.g();
            C20363rt c20363rt = new C20363rt(c20954stA);
            c20363rt.d(0L);
            mapG.put(c20954stA, c20363rt);
            this.g.j(c20954stA);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zo5$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C5298It.h e;
        final /* synthetic */ C9355Zo5 f;

        /* renamed from: ir.nasim.Zo5$d$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C9355Zo5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C9355Zo5 c9355Zo5) {
                super(0);
                this.e = c9355Zo5;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Long invoke() {
                Long lValueOf;
                Iterator it = this.e.d().iterator();
                Long lValueOf2 = null;
                if (it.hasNext()) {
                    lValueOf = Long.valueOf(((InterfaceC7041Qa1) it.next()).a());
                    while (it.hasNext()) {
                        Long lValueOf3 = Long.valueOf(((InterfaceC7041Qa1) it.next()).a());
                        if (lValueOf.compareTo(lValueOf3) < 0) {
                            lValueOf = lValueOf3;
                        }
                    }
                } else {
                    lValueOf = null;
                }
                long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
                Iterator it2 = this.e.h().values().iterator();
                if (it2.hasNext()) {
                    lValueOf2 = Long.valueOf(((C21771u63) it2.next()).d());
                    while (it2.hasNext()) {
                        Long lValueOf4 = Long.valueOf(((C21771u63) it2.next()).d());
                        if (lValueOf2.compareTo(lValueOf4) < 0) {
                            lValueOf2 = lValueOf4;
                        }
                    }
                }
                return Long.valueOf(Math.max(jLongValue, lValueOf2 != null ? lValueOf2.longValue() : 0L));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C5298It.h hVar, C9355Zo5 c9355Zo5) {
            super(1);
            this.e = hVar;
            this.f = c9355Zo5;
        }

        public final void a(Object obj) {
            C22361v63 c22361v63B = C22361v63.f.b(this.e);
            if (c22361v63B != null) {
                C9355Zo5 c9355Zo5 = this.f;
                c9355Zo5.h().put(c22361v63B, new C21771u63(c22361v63B, new a(c9355Zo5)));
                c9355Zo5.j(c22361v63B);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zo5$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ C9355Zo5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C21669tv7 c21669tv7, C9355Zo5 c9355Zo5) {
            super(1);
            this.e = c21669tv7;
            this.f = c9355Zo5;
        }

        public final void a(Object obj) {
            C24625yv7 c24625yv7A = AbstractC25219zv7.a(this.e);
            if (c24625yv7A == null) {
                this.f.c(this.e.j());
                return;
            }
            C9355Zo5 c9355Zo5 = this.f;
            c9355Zo5.i().put(c24625yv7A, new C24035xv7(c24625yv7A));
            c9355Zo5.j(c24625yv7A);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zo5$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(1);
            this.f = str;
        }

        public final void a(Object obj) {
            C9355Zo5.this.c(this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    public C9355Zo5(SA2 sa2) {
        this.a = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str) {
        C10794cC7 c10794cC7A = C10794cC7.e.a(str);
        if (c10794cC7A != null) {
            this.i.add(c10794cC7A);
            j(c10794cC7A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List d() {
        return AbstractC15401jX0.R0(AbstractC15401jX0.R0(AbstractC15401jX0.R0(this.d.values(), this.e.values()), this.f.values()), this.h.values());
    }

    private final boolean o(Object obj, UA2 ua2) {
        synchronized (this.k) {
            if (this.j.contains(obj)) {
                if (this.c) {
                    Log.d(this.b, "Animation " + obj + " is already being tracked");
                }
                return false;
            }
            this.j.add(obj);
            ua2.invoke(obj);
            if (!this.c) {
                return true;
            }
            Log.d(this.b, "Animation " + obj + " is now tracked");
            return true;
        }
    }

    private final void t(Object obj, String str) {
        o(obj, new f(str));
    }

    public final Map e() {
        return this.f;
    }

    public final Map f() {
        return this.h;
    }

    public final Map g() {
        return this.e;
    }

    public final Map h() {
        return this.g;
    }

    public final Map i() {
        return this.d;
    }

    public final void k(Object obj) {
        t(obj, "animateContentSize");
    }

    public final void l(C5298It.c cVar) {
        o(cVar.a(), new a(cVar, this));
    }

    public final void m(C21669tv7 c21669tv7) {
        o(c21669tv7, new b(c21669tv7, this));
    }

    public final void n(C21669tv7 c21669tv7, SA2 sa2) {
        if (c21669tv7.h() instanceof Boolean) {
            o(c21669tv7, new c(c21669tv7, sa2, this));
        }
    }

    public final void p(C9569aB1 c9569aB1) {
        t(c9569aB1, "DecayAnimation");
    }

    public final void q(C5298It.h hVar) {
        o(hVar.a(), new d(hVar, this));
    }

    public final void r(C23915xj7 c23915xj7) {
        t(c23915xj7, "TargetBasedAnimation");
    }

    public final void s(C21669tv7 c21669tv7) {
        o(c21669tv7, new e(c21669tv7, this));
    }

    protected void j(ComposeAnimation composeAnimation) {
    }
}
