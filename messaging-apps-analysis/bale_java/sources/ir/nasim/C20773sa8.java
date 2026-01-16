package ir.nasim;

import android.view.View;
import android.view.WindowInsets;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.O98;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.sa8, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20773sa8 {
    private static boolean A;
    public static final a x = new a(null);
    public static final int y = 8;
    private static final WeakHashMap z = new WeakHashMap();
    private final C14409hs a;
    private final C14409hs b;
    private final C14409hs c;
    private final C14409hs d;
    private final C14409hs e;
    private final C14409hs f;
    private final C14409hs g;
    private final C14409hs h;
    private final C14409hs i;
    private final C18891pQ7 j;
    private final A98 k;
    private final A98 l;
    private final A98 m;
    private final C18891pQ7 n;
    private final C18891pQ7 o;
    private final C18891pQ7 p;
    private final C18891pQ7 q;
    private final C18891pQ7 r;
    private final C18891pQ7 s;
    private final C18891pQ7 t;
    private final boolean u;
    private int v;
    private final M93 w;

    /* renamed from: ir.nasim.sa8$a */
    public static final class a {

        /* renamed from: ir.nasim.sa8$a$a, reason: collision with other inner class name */
        static final class C1543a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C20773sa8 e;
            final /* synthetic */ View f;

            /* renamed from: ir.nasim.sa8$a$a$a, reason: collision with other inner class name */
            public static final class C1544a implements KV1 {
                final /* synthetic */ C20773sa8 a;
                final /* synthetic */ View b;

                public C1544a(C20773sa8 c20773sa8, View view) {
                    this.a = c20773sa8;
                    this.b = view;
                }

                @Override // ir.nasim.KV1
                public void dispose() {
                    this.a.b(this.b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1543a(C20773sa8 c20773sa8, View view) {
                super(1);
                this.e = c20773sa8;
                this.f = view;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final KV1 invoke(LV1 lv1) {
                this.e.k(this.f);
                return new C1544a(this.e, this.f);
            }
        }

        private a() {
        }

        private final C20773sa8 d(View view) {
            C20773sa8 c20773sa8;
            synchronized (C20773sa8.z) {
                try {
                    WeakHashMap weakHashMap = C20773sa8.z;
                    Object obj = weakHashMap.get(view);
                    Object obj2 = obj;
                    if (obj == null) {
                        C20773sa8 c20773sa82 = new C20773sa8(null, view, false ? 1 : 0);
                        weakHashMap.put(view, c20773sa82);
                        obj2 = c20773sa82;
                    }
                    c20773sa8 = (C20773sa8) obj2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c20773sa8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C14409hs e(O98 o98, int i, String str) {
            C14409hs c14409hs = new C14409hs(i, str);
            if (o98 != null) {
                c14409hs.i(o98, i);
            }
            return c14409hs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C18891pQ7 f(O98 o98, int i, String str) {
            L93 l93G;
            if (o98 == null || (l93G = o98.g(i)) == null) {
                l93G = L93.e;
            }
            return AbstractC24416ya8.a(l93G, str);
        }

        public final C20773sa8 c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1366542614, i, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:578)");
            }
            View view = (View) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.k());
            C20773sa8 c20773sa8D = d(view);
            boolean zD = interfaceC22053ub1.D(c20773sa8D) | interfaceC22053ub1.D(view);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new C1543a(c20773sa8D, view);
                interfaceC22053ub1.s(objB);
            }
            AbstractC10721c52.a(c20773sa8D, (UA2) objB, interfaceC22053ub1, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            return c20773sa8D;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C20773sa8(O98 o98, View view, ED1 ed1) {
        this(o98, view);
    }

    public static /* synthetic */ void m(C20773sa8 c20773sa8, O98 o98, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        c20773sa8.l(o98, i);
    }

    public final void b(View view) {
        int i = this.v - 1;
        this.v = i;
        if (i == 0) {
            AbstractC12990fW7.E0(view, null);
            AbstractC12990fW7.N0(view, null);
            view.removeOnAttachStateChangeListener(this.w);
        }
    }

    public final boolean c() {
        return this.u;
    }

    public final C14409hs d() {
        return this.c;
    }

    public final C14409hs e() {
        return this.d;
    }

    public final C14409hs f() {
        return this.e;
    }

    public final C18891pQ7 g() {
        return this.o;
    }

    public final A98 h() {
        return this.k;
    }

    public final C14409hs i() {
        return this.f;
    }

    public final C14409hs j() {
        return this.g;
    }

    public final void k(View view) {
        if (this.v == 0) {
            AbstractC12990fW7.E0(view, this.w);
            if (view.isAttachedToWindow()) {
                view.requestApplyInsets();
            }
            view.addOnAttachStateChangeListener(this.w);
            AbstractC12990fW7.N0(view, this.w);
        }
        this.v++;
    }

    public final void l(O98 o98, int i) {
        if (A) {
            WindowInsets windowInsetsY = o98.y();
            AbstractC13042fc3.f(windowInsetsY);
            o98 = O98.z(windowInsetsY);
        }
        this.a.i(o98, i);
        this.c.i(o98, i);
        this.b.i(o98, i);
        this.e.i(o98, i);
        this.f.i(o98, i);
        this.g.i(o98, i);
        this.h.i(o98, i);
        this.i.i(o98, i);
        this.d.i(o98, i);
        if (i == 0) {
            this.n.f(AbstractC24416ya8.i(o98.g(O98.m.b())));
            this.o.f(AbstractC24416ya8.i(o98.g(O98.m.g())));
            this.p.f(AbstractC24416ya8.i(o98.g(O98.m.h())));
            this.q.f(AbstractC24416ya8.i(o98.g(O98.m.i())));
            this.r.f(AbstractC24416ya8.i(o98.g(O98.m.k())));
            C20112rV1 c20112rV1E = o98.e();
            if (c20112rV1E != null) {
                this.j.f(AbstractC24416ya8.i(c20112rV1E.e()));
            }
        }
        androidx.compose.runtime.snapshots.g.e.m();
    }

    public final void n(O98 o98) {
        this.t.f(AbstractC24416ya8.i(o98.f(O98.m.d())));
    }

    public final void o(O98 o98) {
        this.s.f(AbstractC24416ya8.i(o98.f(O98.m.d())));
    }

    private C20773sa8(O98 o98, View view) {
        C20112rV1 c20112rV1E;
        L93 l93E;
        a aVar = x;
        this.a = aVar.e(o98, O98.m.b(), "captionBar");
        C14409hs c14409hsE = aVar.e(o98, O98.m.c(), "displayCutout");
        this.b = c14409hsE;
        C14409hs c14409hsE2 = aVar.e(o98, O98.m.d(), "ime");
        this.c = c14409hsE2;
        C14409hs c14409hsE3 = aVar.e(o98, O98.m.f(), "mandatorySystemGestures");
        this.d = c14409hsE3;
        this.e = aVar.e(o98, O98.m.g(), "navigationBars");
        this.f = aVar.e(o98, O98.m.h(), "statusBars");
        C14409hs c14409hsE4 = aVar.e(o98, O98.m.i(), "systemBars");
        this.g = c14409hsE4;
        C14409hs c14409hsE5 = aVar.e(o98, O98.m.j(), "systemGestures");
        this.h = c14409hsE5;
        C14409hs c14409hsE6 = aVar.e(o98, O98.m.k(), "tappableElement");
        this.i = c14409hsE6;
        C18891pQ7 c18891pQ7A = AbstractC24416ya8.a((o98 == null || (c20112rV1E = o98.e()) == null || (l93E = c20112rV1E.e()) == null) ? L93.e : l93E, "waterfall");
        this.j = c18891pQ7A;
        A98 a98H = AbstractC21393ta8.h(AbstractC21393ta8.h(c14409hsE4, c14409hsE2), c14409hsE);
        this.k = a98H;
        A98 a98H2 = AbstractC21393ta8.h(AbstractC21393ta8.h(AbstractC21393ta8.h(c14409hsE6, c14409hsE3), c14409hsE5), c18891pQ7A);
        this.l = a98H2;
        this.m = AbstractC21393ta8.h(a98H, a98H2);
        this.n = aVar.f(o98, O98.m.b(), "captionBarIgnoringVisibility");
        this.o = aVar.f(o98, O98.m.g(), "navigationBarsIgnoringVisibility");
        this.p = aVar.f(o98, O98.m.h(), "statusBarsIgnoringVisibility");
        this.q = aVar.f(o98, O98.m.i(), "systemBarsIgnoringVisibility");
        this.r = aVar.f(o98, O98.m.k(), "tappableElementIgnoringVisibility");
        this.s = aVar.f(o98, O98.m.d(), "imeAnimationTarget");
        this.t = aVar.f(o98, O98.m.d(), "imeAnimationSource");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        Object tag = view2 != null ? view2.getTag(AbstractC22421vC5.consume_window_insets_tag) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        this.u = bool != null ? bool.booleanValue() : true;
        this.w = new M93(this);
    }
}
