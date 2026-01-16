package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import ir.nasim.AX7;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC15808kC5;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.BX7;
import ir.nasim.C20480s5;
import ir.nasim.C23798xX7;
import ir.nasim.C24388yX7;
import ir.nasim.H5;
import ir.nasim.HE5;
import ir.nasim.InterfaceC24982zX7;
import ir.nasim.PB1;
import ir.nasim.X17;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class m extends ActionBar implements ActionBarOverlayLayout.d {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;
    Context a;
    private Context b;
    private Activity c;
    ActionBarOverlayLayout d;
    ActionBarContainer e;
    PB1 f;
    ActionBarContextView g;
    View h;
    ScrollingTabContainerView i;
    private boolean l;
    d m;
    H5 n;
    H5.a o;
    private boolean p;
    private boolean r;
    boolean u;
    boolean v;
    private boolean w;
    C24388yX7 y;
    private boolean z;
    private ArrayList j = new ArrayList();
    private int k = -1;
    private ArrayList q = new ArrayList();
    private int s = 0;
    boolean t = true;
    private boolean x = true;
    final InterfaceC24982zX7 B = new a();
    final InterfaceC24982zX7 C = new b();
    final BX7 D = new c();

    class a extends AX7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC24982zX7
        public void b(View view) {
            View view2;
            m mVar = m.this;
            if (mVar.t && (view2 = mVar.h) != null) {
                view2.setTranslationY(0.0f);
                m.this.e.setTranslationY(0.0f);
            }
            m.this.e.setVisibility(8);
            m.this.e.setTransitioning(false);
            m mVar2 = m.this;
            mVar2.y = null;
            mVar2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = m.this.d;
            if (actionBarOverlayLayout != null) {
                AbstractC12990fW7.m0(actionBarOverlayLayout);
            }
        }
    }

    class b extends AX7 {
        b() {
        }

        @Override // ir.nasim.InterfaceC24982zX7
        public void b(View view) {
            m mVar = m.this;
            mVar.y = null;
            mVar.e.requestLayout();
        }
    }

    class c implements BX7 {
        c() {
        }

        @Override // ir.nasim.BX7
        public void a(View view) {
            ((View) m.this.e.getParent()).invalidate();
        }
    }

    public class d extends H5 implements e.a {
        private final Context c;
        private final androidx.appcompat.view.menu.e d;
        private H5.a e;
        private WeakReference f;

        public d(Context context, H5.a aVar) {
            this.c = context;
            this.e = aVar;
            androidx.appcompat.view.menu.e eVarW = new androidx.appcompat.view.menu.e(context).W(1);
            this.d = eVarW;
            eVarW.V(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            H5.a aVar = this.e;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.e == null) {
                return;
            }
            k();
            m.this.g.l();
        }

        @Override // ir.nasim.H5
        public void c() {
            m mVar = m.this;
            if (mVar.m != this) {
                return;
            }
            if (m.w(mVar.u, mVar.v, false)) {
                this.e.d(this);
            } else {
                m mVar2 = m.this;
                mVar2.n = this;
                mVar2.o = this.e;
            }
            this.e = null;
            m.this.v(false);
            m.this.g.g();
            m mVar3 = m.this;
            mVar3.d.setHideOnContentScrollEnabled(mVar3.A);
            m.this.m = null;
        }

        @Override // ir.nasim.H5
        public View d() {
            WeakReference weakReference = this.f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // ir.nasim.H5
        public Menu e() {
            return this.d;
        }

        @Override // ir.nasim.H5
        public MenuInflater f() {
            return new X17(this.c);
        }

        @Override // ir.nasim.H5
        public CharSequence g() {
            return m.this.g.getSubtitle();
        }

        @Override // ir.nasim.H5
        public CharSequence i() {
            return m.this.g.getTitle();
        }

        @Override // ir.nasim.H5
        public void k() {
            if (m.this.m != this) {
                return;
            }
            this.d.h0();
            try {
                this.e.b(this, this.d);
            } finally {
                this.d.g0();
            }
        }

        @Override // ir.nasim.H5
        public boolean l() {
            return m.this.g.j();
        }

        @Override // ir.nasim.H5
        public void m(View view) {
            m.this.g.setCustomView(view);
            this.f = new WeakReference(view);
        }

        @Override // ir.nasim.H5
        public void n(int i) {
            o(m.this.a.getResources().getString(i));
        }

        @Override // ir.nasim.H5
        public void o(CharSequence charSequence) {
            m.this.g.setSubtitle(charSequence);
        }

        @Override // ir.nasim.H5
        public void q(int i) {
            r(m.this.a.getResources().getString(i));
        }

        @Override // ir.nasim.H5
        public void r(CharSequence charSequence) {
            m.this.g.setTitle(charSequence);
        }

        @Override // ir.nasim.H5
        public void s(boolean z) {
            super.s(z);
            m.this.g.setTitleOptional(z);
        }

        public boolean t() {
            this.d.h0();
            try {
                return this.e.a(this, this.d);
            } finally {
                this.d.g0();
            }
        }
    }

    public m(Activity activity, boolean z) {
        this.c = activity;
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z) {
            return;
        }
        this.h = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PB1 A(View view) {
        if (view instanceof PB1) {
            return (PB1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void C() {
        if (this.w) {
            this.w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(AbstractC15808kC5.decor_content_parent);
        this.d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f = A(view.findViewById(AbstractC15808kC5.action_bar));
        this.g = (ActionBarContextView) view.findViewById(AbstractC15808kC5.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(AbstractC15808kC5.action_bar_container);
        this.e = actionBarContainer;
        PB1 pb1 = this.f;
        if (pb1 == null || this.g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = pb1.getContext();
        boolean z = (this.f.s() & 4) != 0;
        if (z) {
            this.l = true;
        }
        C20480s5 c20480s5B = C20480s5.b(this.a);
        J(c20480s5B.a() || z);
        H(c20480s5B.g());
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, HE5.ActionBar, AbstractC15790kA5.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(HE5.ActionBar_hideOnContentScroll, false)) {
            I(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(HE5.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void H(boolean z) {
        this.r = z;
        if (z) {
            this.e.setTabContainer(null);
            this.f.p(this.i);
        } else {
            this.f.p(null);
            this.e.setTabContainer(this.i);
        }
        boolean z2 = B() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.i;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.d;
                if (actionBarOverlayLayout != null) {
                    AbstractC12990fW7.m0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f.n(!this.r && z2);
        this.d.setHasNonEmbeddedTabs(!this.r && z2);
    }

    private boolean K() {
        return AbstractC12990fW7.T(this.e);
    }

    private void L() {
        if (this.w) {
            return;
        }
        this.w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z) {
        if (w(this.u, this.v, this.w)) {
            if (this.x) {
                return;
            }
            this.x = true;
            z(z);
            return;
        }
        if (this.x) {
            this.x = false;
            y(z);
        }
    }

    static boolean w(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public int B() {
        return this.f.i();
    }

    public void E(boolean z) {
        F(z ? 4 : 0, 4);
    }

    public void F(int i, int i2) {
        int iS = this.f.s();
        if ((i2 & 4) != 0) {
            this.l = true;
        }
        this.f.g((i & i2) | ((~i2) & iS));
    }

    public void G(float f) {
        AbstractC12990fW7.x0(this.e, f);
    }

    public void I(boolean z) {
        if (z && !this.d.s()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z;
        this.d.setHideOnContentScrollEnabled(z);
    }

    public void J(boolean z) {
        this.f.l(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.v) {
            this.v = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b(int i) {
        this.s = i;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(boolean z) {
        this.t = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.v) {
            return;
        }
        this.v = true;
        M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        C24388yX7 c24388yX7 = this.y;
        if (c24388yX7 != null) {
            c24388yX7.a();
            this.y = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean h() {
        PB1 pb1 = this.f;
        if (pb1 == null || !pb1.f()) {
            return false;
        }
        this.f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(boolean z) {
        if (z == this.p) {
            return;
        }
        this.p = z;
        if (this.q.size() <= 0) {
            return;
        }
        AbstractC18350oW3.a(this.q.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int j() {
        return this.f.s();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context k() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(AbstractC15790kA5.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.a, i);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m(Configuration configuration) {
        H(C20480s5.b(this.a).g());
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean o(int i, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.m;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r(boolean z) {
        if (this.l) {
            return;
        }
        E(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z) {
        C24388yX7 c24388yX7;
        this.z = z;
        if (z || (c24388yX7 = this.y) == null) {
            return;
        }
        c24388yX7.a();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t(CharSequence charSequence) {
        this.f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public H5 u(H5.a aVar) {
        d dVar = this.m;
        if (dVar != null) {
            dVar.c();
        }
        this.d.setHideOnContentScrollEnabled(false);
        this.g.k();
        d dVar2 = new d(this.g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.m = dVar2;
        dVar2.k();
        this.g.h(dVar2);
        v(true);
        return dVar2;
    }

    public void v(boolean z) {
        C23798xX7 c23798xX7J;
        C23798xX7 c23798xX7F;
        if (z) {
            L();
        } else {
            C();
        }
        if (!K()) {
            if (z) {
                this.f.setVisibility(4);
                this.g.setVisibility(0);
                return;
            } else {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                return;
            }
        }
        if (z) {
            c23798xX7F = this.f.j(4, 100L);
            c23798xX7J = this.g.f(0, 200L);
        } else {
            c23798xX7J = this.f.j(0, 200L);
            c23798xX7F = this.g.f(8, 100L);
        }
        C24388yX7 c24388yX7 = new C24388yX7();
        c24388yX7.d(c23798xX7F, c23798xX7J);
        c24388yX7.h();
    }

    void x() {
        H5.a aVar = this.o;
        if (aVar != null) {
            aVar.d(this.n);
            this.n = null;
            this.o = null;
        }
    }

    public void y(boolean z) {
        View view;
        C24388yX7 c24388yX7 = this.y;
        if (c24388yX7 != null) {
            c24388yX7.a();
        }
        if (this.s != 0 || (!this.z && !z)) {
            this.B.b(null);
            return;
        }
        this.e.setAlpha(1.0f);
        this.e.setTransitioning(true);
        C24388yX7 c24388yX72 = new C24388yX7();
        float f = -this.e.getHeight();
        if (z) {
            this.e.getLocationInWindow(new int[]{0, 0});
            f -= r5[1];
        }
        C23798xX7 c23798xX7M = AbstractC12990fW7.e(this.e).m(f);
        c23798xX7M.k(this.D);
        c24388yX72.c(c23798xX7M);
        if (this.t && (view = this.h) != null) {
            c24388yX72.c(AbstractC12990fW7.e(view).m(f));
        }
        c24388yX72.f(E);
        c24388yX72.e(250L);
        c24388yX72.g(this.B);
        this.y = c24388yX72;
        c24388yX72.h();
    }

    public void z(boolean z) {
        View view;
        View view2;
        C24388yX7 c24388yX7 = this.y;
        if (c24388yX7 != null) {
            c24388yX7.a();
        }
        this.e.setVisibility(0);
        if (this.s == 0 && (this.z || z)) {
            this.e.setTranslationY(0.0f);
            float f = -this.e.getHeight();
            if (z) {
                this.e.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.e.setTranslationY(f);
            C24388yX7 c24388yX72 = new C24388yX7();
            C23798xX7 c23798xX7M = AbstractC12990fW7.e(this.e).m(0.0f);
            c23798xX7M.k(this.D);
            c24388yX72.c(c23798xX7M);
            if (this.t && (view2 = this.h) != null) {
                view2.setTranslationY(f);
                c24388yX72.c(AbstractC12990fW7.e(this.h).m(0.0f));
            }
            c24388yX72.f(F);
            c24388yX72.e(250L);
            c24388yX72.g(this.C);
            this.y = c24388yX72;
            c24388yX72.h();
        } else {
            this.e.setAlpha(1.0f);
            this.e.setTranslationY(0.0f);
            if (this.t && (view = this.h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (actionBarOverlayLayout != null) {
            AbstractC12990fW7.m0(actionBarOverlayLayout);
        }
    }

    public m(Dialog dialog) {
        D(dialog.getWindow().getDecorView());
    }
}
