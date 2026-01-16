package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21866uG4;
import ir.nasim.AbstractC22068uc6;
import ir.nasim.AbstractC22804vr2;
import ir.nasim.AbstractC23052wG4;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC23254wc6;
import ir.nasim.C24411ya3;
import ir.nasim.C3348Am4;
import ir.nasim.C3587Bm4;
import ir.nasim.C7386Rm4;
import ir.nasim.C7620Sm4;
import ir.nasim.ED1;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final class r {
    public static final b d = new b(null);
    public static final int e = 8;
    private static final a f = new a();
    private final Rect a = new Rect();
    private final c b = new c(new c.a() { // from class: ir.nasim.ur2
        @Override // androidx.compose.ui.platform.r.c.a
        public final View a(View view, View view2) {
            return androidx.compose.ui.platform.r.k(this.a, view, view2);
        }
    });
    private final C3587Bm4 c = new C3587Bm4(0, 1, null);

    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r initialValue() {
            return new r();
        }
    }

    public static final class b {
        private b() {
        }

        public final r a() {
            Object obj = r.f.get();
            AbstractC13042fc3.f(obj);
            return (r) obj;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final class c implements Comparator {
        private final a a;
        private final C7386Rm4 b = AbstractC22068uc6.b();
        private final C7620Sm4 c = AbstractC23254wc6.a();
        private final C7386Rm4 d = AbstractC22068uc6.b();
        private final C3348Am4 e = AbstractC21866uG4.b();
        private View f;

        public interface a {
            View a(View view, View view2);
        }

        public c(a aVar) {
            this.a = aVar;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            if (view == view2) {
                return 0;
            }
            if (view == null) {
                return -1;
            }
            if (view2 == null) {
                return 1;
            }
            View view3 = (View) this.d.e(view);
            View view4 = (View) this.d.e(view2);
            if (view3 == view4 && view3 != null) {
                if (view == view3) {
                    return -1;
                }
                return (view2 == view3 || this.b.e(view) == null) ? 1 : -1;
            }
            if (view3 != null) {
                view = view3;
            }
            if (view4 != null) {
                view2 = view4;
            }
            if (view3 == null && view4 == null) {
                return 0;
            }
            return this.e.c(view) < this.e.c(view2) ? -1 : 1;
        }

        public final void b() {
            this.f = null;
            this.d.k();
            this.c.m();
            this.e.j();
            this.b.k();
        }

        public final void c(AbstractC23052wG4 abstractC23052wG4, View view) {
            this.f = view;
            Object[] objArr = abstractC23052wG4.a;
            int i = abstractC23052wG4.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.e.u((View) objArr[i2], i2);
            }
            C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, abstractC23052wG4.b);
            int iO = c24411ya3Y.o();
            int iT = c24411ya3Y.t();
            if (iO <= iT) {
                while (true) {
                    View view2 = (View) abstractC23052wG4.d(iT);
                    View viewA = this.a.a(view, view2);
                    if (viewA != null && this.e.a(viewA)) {
                        this.b.x(view2, viewA);
                        this.c.h(viewA);
                    }
                    if (iT == iO) {
                        break;
                    } else {
                        iT--;
                    }
                }
            }
            C24411ya3 c24411ya3Y2 = AbstractC23053wG5.y(0, abstractC23052wG4.b);
            int iO2 = c24411ya3Y2.o();
            int iT2 = c24411ya3Y2.t();
            if (iO2 > iT2) {
                return;
            }
            while (true) {
                View view3 = (View) abstractC23052wG4.d(iT2);
                if (((View) this.b.e(view3)) != null && !this.c.a(view3)) {
                    d(view3);
                }
                if (iT2 == iO2) {
                    return;
                } else {
                    iT2--;
                }
            }
        }

        public final void d(View view) {
            View view2 = view;
            while (view != null) {
                View view3 = (View) this.d.e(view);
                if (view3 != null) {
                    if (view3 == view2) {
                        return;
                    }
                    view = view2;
                    view2 = view3;
                }
                this.d.x(view, view2);
                view = (View) this.b.e(view);
            }
        }
    }

    private final View c(ViewGroup viewGroup, View view, int i, C3587Bm4 c3587Bm4) {
        Rect rect = this.a;
        view.getFocusedRect(rect);
        viewGroup.offsetDescendantRectToMyCoords(view, rect);
        return e(c3587Bm4, viewGroup, view, i);
    }

    private final View e(C3587Bm4 c3587Bm4, ViewGroup viewGroup, View view, int i) {
        try {
            c cVar = this.b;
            AbstractC13042fc3.f(viewGroup);
            cVar.c(c3587Bm4, viewGroup);
            Collections.sort(c3587Bm4.s(), this.b);
            this.b.b();
            int iE = c3587Bm4.e();
            View viewI = null;
            if (iE < 2) {
                return null;
            }
            boolean[] zArr = new boolean[1];
            if (i == 1) {
                viewI = i(view, c3587Bm4, iE, zArr);
            } else if (i == 2) {
                viewI = h(view, c3587Bm4, iE, zArr);
            }
            return viewI == null ? (View) c3587Bm4.d(iE - 1) : viewI;
        } catch (Throwable th) {
            this.b.b();
            throw th;
        }
    }

    private final View f(ViewGroup viewGroup, View view, int i) {
        View viewF = AbstractC22804vr2.f(view, viewGroup, i);
        View viewF2 = viewF;
        boolean z = true;
        while (viewF != null) {
            if (viewF.isFocusable() && viewF.getVisibility() == 0 && (!viewF.isInTouchMode() || viewF.isFocusableInTouchMode())) {
                return viewF;
            }
            viewF = AbstractC22804vr2.f(viewF, viewGroup, i);
            z = !z;
            if (z) {
                viewF2 = viewF2 != null ? AbstractC22804vr2.f(viewF2, viewGroup, i) : null;
                if (viewF2 == viewF) {
                    break;
                }
            }
        }
        return null;
    }

    private final ViewGroup g(ViewGroup viewGroup, View view) {
        if (view != null && view != viewGroup) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup2 = null;
            while (parent instanceof ViewGroup) {
                if (parent == viewGroup) {
                    return viewGroup2 == null ? viewGroup : viewGroup2;
                }
                ViewGroup viewGroup3 = (ViewGroup) parent;
                if (viewGroup3.getTouchscreenBlocksFocus() && view.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
                    viewGroup2 = viewGroup3;
                }
                parent = viewGroup3.getParent();
            }
        }
        return viewGroup;
    }

    private final View h(View view, AbstractC23052wG4 abstractC23052wG4, int i, boolean[] zArr) {
        int i2;
        if (i < 2) {
            return null;
        }
        int iK = abstractC23052wG4.k(view);
        if (iK >= 0 && (i2 = iK + 1) < i) {
            return (View) abstractC23052wG4.d(i2);
        }
        zArr[0] = true;
        return (View) abstractC23052wG4.d(0);
    }

    private final View i(View view, AbstractC23052wG4 abstractC23052wG4, int i, boolean[] zArr) {
        int iF;
        if (i < 2) {
            return null;
        }
        if (view != null && (iF = abstractC23052wG4.f(view)) > 0) {
            return (View) abstractC23052wG4.d(iF - 1);
        }
        zArr[0] = true;
        return (View) abstractC23052wG4.d(i - 1);
    }

    private final boolean j(int i) {
        return (i == 0 || i == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View k(r rVar, View view, View view2) {
        if (rVar.j(view2.getNextFocusForwardId())) {
            return AbstractC22804vr2.f(view2, view, 2);
        }
        return null;
    }

    public final View d(ViewGroup viewGroup, View view, int i) {
        ViewGroup viewGroupG = g(viewGroup, view);
        View viewF = f(viewGroupG, view, i);
        if (viewF != null) {
            return viewF;
        }
        C3587Bm4 c3587Bm4 = this.c;
        try {
            c3587Bm4.t();
            AbstractC22804vr2.d(viewGroupG, c3587Bm4, i);
            if (!c3587Bm4.g()) {
                viewF = c(viewGroupG, view, i, c3587Bm4);
            }
            return viewF;
        } finally {
            c3587Bm4.t();
        }
    }
}
