package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import ir.nasim.AX7;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC15808kC5;
import ir.nasim.AbstractC20545sB5;
import ir.nasim.AbstractC9594aE;
import ir.nasim.C23798xX7;
import ir.nasim.CD5;
import ir.nasim.G5;
import ir.nasim.HE5;
import ir.nasim.PB1;

/* loaded from: classes.dex */
public class D implements PB1 {
    Toolbar a;
    private int b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    class a implements View.OnClickListener {
        final G5 a;

        a() {
            this.a = new G5(D.this.a.getContext(), 0, R.id.home, 0, 0, D.this.i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            D d = D.this;
            Window.Callback callback = d.l;
            if (callback == null || !d.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.a);
        }
    }

    class b extends AX7 {
        private boolean a = false;
        final /* synthetic */ int b;

        b(int i) {
            this.b = i;
        }

        @Override // ir.nasim.AX7, ir.nasim.InterfaceC24982zX7
        public void a(View view) {
            this.a = true;
        }

        @Override // ir.nasim.InterfaceC24982zX7
        public void b(View view) {
            if (this.a) {
                return;
            }
            D.this.a.setVisibility(this.b);
        }

        @Override // ir.nasim.AX7, ir.nasim.InterfaceC24982zX7
        public void c(View view) {
            D.this.a.setVisibility(0);
        }
    }

    public D(Toolbar toolbar, boolean z) {
        this(toolbar, z, CD5.abc_action_bar_up_description, AbstractC20545sB5.abc_ic_ab_back_material);
    }

    private void D(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
            if (this.h) {
                AbstractC12990fW7.s0(this.a.getRootView(), charSequence);
            }
        }
    }

    private void E() {
        if ((this.b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }

    private void F() {
        if ((this.b & 4) == 0) {
            this.a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.a;
        Drawable drawable = this.g;
        if (drawable == null) {
            drawable = this.q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void G() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.e;
        }
        this.a.setLogo(drawable);
    }

    private int u() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.g = drawable;
        F();
    }

    public void B(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void C(CharSequence charSequence) {
        this.h = true;
        D(charSequence);
    }

    @Override // ir.nasim.PB1
    public boolean a() {
        return this.a.d();
    }

    @Override // ir.nasim.PB1
    public boolean b() {
        return this.a.x();
    }

    @Override // ir.nasim.PB1
    public boolean c() {
        return this.a.N();
    }

    @Override // ir.nasim.PB1
    public void collapseActionView() {
        this.a.f();
    }

    @Override // ir.nasim.PB1
    public boolean d() {
        return this.a.D();
    }

    @Override // ir.nasim.PB1
    public boolean e() {
        return this.a.B();
    }

    @Override // ir.nasim.PB1
    public boolean f() {
        return this.a.w();
    }

    @Override // ir.nasim.PB1
    public void g(int i) {
        View view;
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    E();
                }
                F();
            }
            if ((i2 & 3) != 0) {
                G();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.i);
                    this.a.setSubtitle(this.j);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    @Override // ir.nasim.PB1
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // ir.nasim.PB1
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // ir.nasim.PB1
    public Menu h() {
        return this.a.getMenu();
    }

    @Override // ir.nasim.PB1
    public int i() {
        return this.o;
    }

    @Override // ir.nasim.PB1
    public C23798xX7 j(int i, long j) {
        return AbstractC12990fW7.e(this.a).b(i == 0 ? 1.0f : 0.0f).f(j).h(new b(i));
    }

    @Override // ir.nasim.PB1
    public ViewGroup k() {
        return this.a;
    }

    @Override // ir.nasim.PB1
    public void l(boolean z) {
    }

    @Override // ir.nasim.PB1
    public void m() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // ir.nasim.PB1
    public void n(boolean z) {
        this.a.setCollapsible(z);
    }

    @Override // ir.nasim.PB1
    public void o() {
        this.a.g();
    }

    @Override // ir.nasim.PB1
    public void p(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.o != 2) {
            return;
        }
        this.a.addView(scrollingTabContainerView, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // ir.nasim.PB1
    public void q(int i) {
        x(i != 0 ? AbstractC9594aE.b(getContext(), i) : null);
    }

    @Override // ir.nasim.PB1
    public void r(j.a aVar, e.a aVar2) {
        this.a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // ir.nasim.PB1
    public int s() {
        return this.b;
    }

    @Override // ir.nasim.PB1
    public void setIcon(int i) {
        setIcon(i != 0 ? AbstractC9594aE.b(getContext(), i) : null);
    }

    @Override // ir.nasim.PB1
    public void setMenu(Menu menu, j.a aVar) {
        if (this.n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.a.getContext());
            this.n = actionMenuPresenter;
            actionMenuPresenter.s(AbstractC15808kC5.action_menu_presenter);
        }
        this.n.e(aVar);
        this.a.setMenu((androidx.appcompat.view.menu.e) menu, this.n);
    }

    @Override // ir.nasim.PB1
    public void setMenuPrepared() {
        this.m = true;
    }

    @Override // ir.nasim.PB1
    public void setVisibility(int i) {
        this.a.setVisibility(i);
    }

    @Override // ir.nasim.PB1
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // ir.nasim.PB1
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        D(charSequence);
    }

    @Override // ir.nasim.PB1
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void v(View view) {
        View view2 = this.d;
        if (view2 != null && (this.b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.d = view;
        if (view == null || (this.b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }

    public void w(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            y(this.p);
        }
    }

    public void x(Drawable drawable) {
        this.f = drawable;
        G();
    }

    public void y(int i) {
        z(i == 0 ? null : getContext().getString(i));
    }

    public void z(CharSequence charSequence) {
        this.k = charSequence;
        E();
    }

    public D(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        C cV = C.v(toolbar.getContext(), null, HE5.ActionBar, AbstractC15790kA5.actionBarStyle, 0);
        this.q = cV.g(HE5.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceP = cV.p(HE5.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceP)) {
                C(charSequenceP);
            }
            CharSequence charSequenceP2 = cV.p(HE5.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                B(charSequenceP2);
            }
            Drawable drawableG = cV.g(HE5.ActionBar_logo);
            if (drawableG != null) {
                x(drawableG);
            }
            Drawable drawableG2 = cV.g(HE5.ActionBar_icon);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.g == null && (drawable = this.q) != null) {
                A(drawable);
            }
            g(cV.k(HE5.ActionBar_displayOptions, 0));
            int iN = cV.n(HE5.ActionBar_customNavigationLayout, 0);
            if (iN != 0) {
                v(LayoutInflater.from(this.a.getContext()).inflate(iN, (ViewGroup) this.a, false));
                g(this.b | 16);
            }
            int iM = cV.m(HE5.ActionBar_height, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = iM;
                this.a.setLayoutParams(layoutParams);
            }
            int iE = cV.e(HE5.ActionBar_contentInsetStart, -1);
            int iE2 = cV.e(HE5.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.a.setContentInsetsRelative(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = cV.n(HE5.ActionBar_titleTextStyle, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), iN2);
            }
            int iN3 = cV.n(HE5.ActionBar_subtitleTextStyle, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), iN3);
            }
            int iN4 = cV.n(HE5.ActionBar_popupTheme, 0);
            if (iN4 != 0) {
                this.a.setPopupTheme(iN4);
            }
        } else {
            this.b = u();
        }
        cV.w();
        w(i);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    @Override // ir.nasim.PB1
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        G();
    }
}
