package androidx.appcompat.widget;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.A44;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC23123wO3;
import ir.nasim.AbstractC8375Vr7;
import ir.nasim.AbstractC9594aE;
import ir.nasim.C18093o44;
import ir.nasim.HE5;
import ir.nasim.InterfaceC17502n44;
import ir.nasim.KW0;
import ir.nasim.PB1;
import ir.nasim.X17;
import ir.nasim.YK2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC17502n44 {
    private ColorStateList A;
    private ArrayList A0;
    private boolean B;
    g B0;
    private final ActionMenuView.d C0;
    private boolean D;
    private D D0;
    private ActionMenuPresenter E0;
    private f F0;
    private final ArrayList G;
    private j.a G0;
    private final ArrayList H;
    e.a H0;
    private boolean I0;
    private final int[] J;
    private OnBackInvokedCallback J0;
    private OnBackInvokedDispatcher K0;
    private boolean L0;
    private final Runnable M0;
    ActionMenuView a;
    private TextView b;
    private TextView c;
    private ImageButton d;
    private ImageView e;
    private Drawable f;
    private CharSequence g;
    ImageButton h;
    View i;
    private Context j;
    private int k;
    private int l;
    private int m;
    int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private w t;
    private int u;
    private int v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private ColorStateList z;
    final C18093o44 z0;

    class a implements ActionMenuView.d {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.d
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.z0.d(menuItem)) {
                return true;
            }
            g gVar = Toolbar.this.B0;
            if (gVar != null) {
                return gVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.N();
        }
    }

    class c implements e.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.H0;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.a.J()) {
                Toolbar.this.z0.e(eVar);
            }
            e.a aVar = Toolbar.this.H0;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.f();
        }
    }

    static class e {
        static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: ir.nasim.Ar7
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class f implements androidx.appcompat.view.menu.j {
        androidx.appcompat.view.menu.e a;
        androidx.appcompat.view.menu.g b;

        f() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean d(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.h();
            ViewParent parent = Toolbar.this.h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.h);
            }
            Toolbar.this.i = gVar.getActionView();
            this.b = gVar;
            ViewParent parent2 = Toolbar.this.i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.i);
                }
                LayoutParams layoutParamsGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                layoutParamsGenerateDefaultLayoutParams.a = (toolbar4.n & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 8388611;
                layoutParamsGenerateDefaultLayoutParams.b = 2;
                toolbar4.i.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.i);
            }
            Toolbar.this.K();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.i;
            if (callback instanceof KW0) {
                ((KW0) callback).b();
            }
            Toolbar.this.O();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public void f(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean g(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.j
        public Parcelable h() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.j
        public void i(boolean z) {
            if (this.b != null) {
                androidx.appcompat.view.menu.e eVar = this.a;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i = 0; i < size; i++) {
                        if (this.a.getItem(i) == this.b) {
                            return;
                        }
                    }
                }
                k(this.a, this.b);
            }
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean j() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean k(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.i;
            if (callback instanceof KW0) {
                ((KW0) callback).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.i = null;
            toolbar3.a();
            this.b = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.O();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public void l(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.a;
            if (eVar2 != null && (gVar = this.b) != null) {
                eVar2.f(gVar);
            }
            this.a = eVar;
        }
    }

    public interface g {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private boolean A(View view) {
        return view.getParent() == this || this.H.contains(view);
    }

    private int E(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iR = r(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iR, iMax + measuredWidth, view.getMeasuredHeight() + iR);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int F(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iR = r(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iR, iMax, view.getMeasuredHeight() + iR);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int G(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void H(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void I() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.z0.b(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.A0 = currentMenuItems2;
    }

    private void J() {
        removeCallbacks(this.M0);
        post(this.M0);
    }

    private boolean L() {
        if (!this.I0) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (M(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean M(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i) {
        boolean z = AbstractC12990fW7.A(this) == 1;
        int childCount = getChildCount();
        int iB = YK2.b(i, AbstractC12990fW7.A(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.b == 0 && M(childAt) && q(layoutParams.a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.b == 0 && M(childAt2) && q(layoutParams2.a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParamsGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        layoutParamsGenerateDefaultLayoutParams.b = 1;
        if (!z || this.i == null) {
            addView(view, layoutParamsGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.H.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new X17(getContext());
    }

    private void i() {
        if (this.t == null) {
            this.t = new w();
        }
    }

    private void j() {
        if (this.e == null) {
            this.e = new AppCompatImageView(getContext());
        }
    }

    private void k() {
        l();
        if (this.a.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.a.getMenu();
            if (this.F0 == null) {
                this.F0 = new f();
            }
            this.a.setExpandedActionViewsExclusive(true);
            eVar.c(this.F0, this.j);
            O();
        }
    }

    private void l() {
        if (this.a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.a = actionMenuView;
            actionMenuView.setPopupTheme(this.k);
            this.a.setOnMenuItemClickListener(this.C0);
            this.a.setMenuCallbacks(this.G0, new c());
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.a = (this.n & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 8388613;
            this.a.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            c(this.a, false);
        }
    }

    private void m() {
        if (this.d == null) {
            this.d = new AppCompatImageButton(getContext(), null, AbstractC15790kA5.toolbarNavigationButtonStyle);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.a = (this.n & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 8388611;
            this.d.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
        }
    }

    private int q(int i) {
        int iA = AbstractC12990fW7.A(this);
        int iB = YK2.b(i, iA) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : iA == 1 ? 5 : 3;
    }

    private int r(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iS = s(layoutParams.a);
        if (iS == 48) {
            return getPaddingTop() - i2;
        }
        if (iS == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (iMax < i3) {
            iMax = i3;
        } else {
            int i4 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i4 < i5) {
                iMax = Math.max(0, iMax - (i5 - i4));
            }
        }
        return paddingTop + iMax;
    }

    private int s(int i) {
        int i2 = i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.w & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC23123wO3.b(marginLayoutParams) + AbstractC23123wO3.a(marginLayoutParams);
    }

    private int u(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int v(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int measuredWidth = 0;
        while (i3 < size) {
            View view = (View) list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i;
            int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i2;
            int iMax = Math.max(0, i4);
            int iMax2 = Math.max(0, i5);
            int iMax3 = Math.max(0, -i4);
            int iMax4 = Math.max(0, -i5);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i3++;
            i2 = iMax4;
            i = iMax3;
        }
        return measuredWidth;
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.I();
    }

    @Override // ir.nasim.InterfaceC17502n44
    public void C(A44 a44) {
        this.z0.a(a44);
    }

    public boolean D() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.J();
    }

    void K() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).b != 2 && childAt != this.a) {
                removeViewAt(childCount);
                this.H.add(childAt);
            }
        }
    }

    public boolean N() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.O();
    }

    void O() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z = w() && onBackInvokedDispatcherA != null && AbstractC12990fW7.S(this) && this.L0;
            if (z && this.K0 == null) {
                if (this.J0 == null) {
                    this.J0 = e.b(new Runnable() { // from class: ir.nasim.yr7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.f();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.J0);
                this.K0 = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.K0) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.J0);
            this.K0 = null;
        }
    }

    void a() {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            addView((View) this.H.get(size));
        }
        this.H.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.a) != null && actionMenuView.K();
    }

    @Override // ir.nasim.InterfaceC17502n44
    public void e(A44 a44) {
        this.z0.f(a44);
    }

    public void f() {
        f fVar = this.F0;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.b;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void g() {
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        w wVar = this.t;
        if (wVar != null) {
            return wVar.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        w wVar = this.t;
        if (wVar != null) {
            return wVar.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        w wVar = this.t;
        if (wVar != null) {
            return wVar.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        w wVar = this.t;
        if (wVar != null) {
            return wVar.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.u;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarN;
        ActionMenuView actionMenuView = this.a;
        return (actionMenuView == null || (eVarN = actionMenuView.N()) == null || !eVarN.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return AbstractC12990fW7.A(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return AbstractC12990fW7.A(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        k();
        return this.a.getMenu();
    }

    View getNavButtonView() {
        return this.d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.E0;
    }

    public Drawable getOverflowIcon() {
        k();
        return this.a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    final TextView getSubtitleTextView() {
        return this.c;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    final TextView getTitleTextView() {
        return this.b;
    }

    public PB1 getWrapper() {
        if (this.D0 == null) {
            this.D0 = new D(this, true);
        }
        return this.D0;
    }

    void h() {
        if (this.h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, AbstractC15790kA5.toolbarNavigationButtonStyle);
            this.h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.a = (this.n & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 8388611;
            layoutParamsGenerateDefaultLayoutParams.b = 2;
            this.h.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.h.setOnClickListener(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        O();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.M0);
        O();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.J;
        boolean zB = F.b(this);
        int i3 = !zB ? 1 : 0;
        if (M(this.d)) {
            H(this.d, i, 0, i2, 0, this.o);
            measuredWidth = this.d.getMeasuredWidth() + t(this.d);
            iMax = Math.max(0, this.d.getMeasuredHeight() + u(this.d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (M(this.h)) {
            H(this.h, i, 0, i2, 0, this.o);
            measuredWidth = this.h.getMeasuredWidth() + t(this.h);
            iMax = Math.max(iMax, this.h.getMeasuredHeight() + u(this.h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (M(this.a)) {
            H(this.a, i, iMax3, i2, 0, this.o);
            measuredWidth2 = this.a.getMeasuredWidth() + t(this.a);
            iMax = Math.max(iMax, this.a.getMeasuredHeight() + u(this.a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i3] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (M(this.i)) {
            iMax4 += G(this.i, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.i.getMeasuredHeight() + u(this.i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.i.getMeasuredState());
        }
        if (M(this.e)) {
            iMax4 += G(this.e, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.e.getMeasuredHeight() + u(this.e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((LayoutParams) childAt.getLayoutParams()).b == 0 && M(childAt)) {
                iMax4 += G(childAt, i, iMax4, i2, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + u(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i5 = this.r + this.s;
        int i6 = this.p + this.q;
        if (M(this.b)) {
            G(this.b, i, iMax4 + i6, i2, i5, iArr);
            int measuredWidth3 = this.b.getMeasuredWidth() + t(this.b);
            measuredHeight = this.b.getMeasuredHeight() + u(this.b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (M(this.c)) {
            iMax2 = Math.max(iMax2, G(this.c, i, iMax4 + i6, i2, measuredHeight + i5, iArr));
            measuredHeight += this.c.getMeasuredHeight() + u(this.c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2), L() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.a;
        androidx.appcompat.view.menu.e eVarN = actionMenuView != null ? actionMenuView.N() : null;
        int i = savedState.c;
        if (i != 0 && this.F0 != null && eVarN != null && (menuItemFindItem = eVarN.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.d) {
            J();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        i();
        this.t.f(i == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.F0;
        if (fVar != null && (gVar = fVar.b) != null) {
            savedState.c = gVar.getItemId();
        }
        savedState.d = D();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ActionBar.LayoutParams ? new LayoutParams((ActionBar.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.L0 != z) {
            this.L0 = z;
            O();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(AbstractC9594aE.b(getContext(), i));
    }

    public void setCollapsible(boolean z) {
        this.I0 = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = RecyclerView.UNDEFINED_DURATION;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = RecyclerView.UNDEFINED_DURATION;
        }
        if (i != this.u) {
            this.u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        i();
        this.t.e(i, i2);
    }

    public void setContentInsetsRelative(int i, int i2) {
        i();
        this.t.g(i, i2);
    }

    public void setLogo(int i) {
        setLogo(AbstractC9594aE.b(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setMenu(androidx.appcompat.view.menu.e eVar, ActionMenuPresenter actionMenuPresenter) {
        if (eVar == null && this.a == null) {
            return;
        }
        l();
        androidx.appcompat.view.menu.e eVarN = this.a.N();
        if (eVarN == eVar) {
            return;
        }
        if (eVarN != null) {
            eVarN.Q(this.E0);
            eVarN.Q(this.F0);
        }
        if (this.F0 == null) {
            this.F0 = new f();
        }
        actionMenuPresenter.J(true);
        if (eVar != null) {
            eVar.c(actionMenuPresenter, this.j);
            eVar.c(this.F0, this.j);
        } else {
            actionMenuPresenter.l(this.j, null);
            this.F0.l(this.j, null);
            actionMenuPresenter.i(true);
            this.F0.i(true);
        }
        this.a.setPopupTheme(this.k);
        this.a.setPresenter(actionMenuPresenter);
        this.E0 = actionMenuPresenter;
        O();
    }

    public void setMenuCallbacks(j.a aVar, e.a aVar2) {
        this.G0 = aVar;
        this.H0 = aVar2;
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(AbstractC9594aE.b(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m();
        this.d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(g gVar) {
        this.B0 = gVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        k();
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.m = i;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.p = i;
        this.r = i2;
        this.q = i3;
        this.s = i4;
        requestLayout();
    }

    public void setTitleMarginBottom(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.l = i;
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public boolean w() {
        f fVar = this.F0;
        return (fVar == null || fVar.b == null) ? false : true;
    }

    public boolean x() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void y(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void z() {
        Iterator it = this.A0.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        I();
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        int b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.b = 0;
            this.b = layoutParams.b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC15790kA5.toolbarStyle);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            h();
        }
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            h();
            this.h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!A(this.e)) {
                c(this.e, true);
            }
        } else {
            ImageView imageView = this.e;
            if (imageView != null && A(imageView)) {
                removeView(this.e);
                this.H.remove(this.e);
            }
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            AbstractC8375Vr7.a(this.d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!A(this.d)) {
                c(this.d, true);
            }
        } else {
            ImageButton imageButton = this.d;
            if (imageButton != null && A(imageButton)) {
                removeView(this.d);
                this.H.remove(this.d);
            }
        }
        ImageButton imageButton2 = this.d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.c;
            if (textView != null && A(textView)) {
                removeView(this.c);
                this.H.remove(this.c);
            }
        } else {
            if (this.c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!A(this.c)) {
                c(this.c, true);
            }
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.b;
            if (textView != null && A(textView)) {
                removeView(this.b);
                this.H.remove(this.b);
            }
        } else {
            if (this.b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.l;
                if (i != 0) {
                    this.b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.z;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
            }
            if (!A(this.b)) {
                c(this.b, true);
            }
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.z = colorStateList;
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int c;
        boolean d;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
            this.d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 8388627;
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.J = new int[2];
        this.z0 = new C18093o44(new Runnable() { // from class: ir.nasim.zr7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z();
            }
        });
        this.A0 = new ArrayList();
        this.C0 = new a();
        this.M0 = new b();
        C cV = C.v(getContext(), attributeSet, HE5.Toolbar, i, 0);
        AbstractC12990fW7.n0(this, context, HE5.Toolbar, attributeSet, cV.r(), i, 0);
        this.l = cV.n(HE5.Toolbar_titleTextAppearance, 0);
        this.m = cV.n(HE5.Toolbar_subtitleTextAppearance, 0);
        this.w = cV.l(HE5.Toolbar_android_gravity, this.w);
        this.n = cV.l(HE5.Toolbar_buttonGravity, 48);
        int iE = cV.e(HE5.Toolbar_titleMargin, 0);
        iE = cV.s(HE5.Toolbar_titleMargins) ? cV.e(HE5.Toolbar_titleMargins, iE) : iE;
        this.s = iE;
        this.r = iE;
        this.q = iE;
        this.p = iE;
        int iE2 = cV.e(HE5.Toolbar_titleMarginStart, -1);
        if (iE2 >= 0) {
            this.p = iE2;
        }
        int iE3 = cV.e(HE5.Toolbar_titleMarginEnd, -1);
        if (iE3 >= 0) {
            this.q = iE3;
        }
        int iE4 = cV.e(HE5.Toolbar_titleMarginTop, -1);
        if (iE4 >= 0) {
            this.r = iE4;
        }
        int iE5 = cV.e(HE5.Toolbar_titleMarginBottom, -1);
        if (iE5 >= 0) {
            this.s = iE5;
        }
        this.o = cV.f(HE5.Toolbar_maxButtonHeight, -1);
        int iE6 = cV.e(HE5.Toolbar_contentInsetStart, RecyclerView.UNDEFINED_DURATION);
        int iE7 = cV.e(HE5.Toolbar_contentInsetEnd, RecyclerView.UNDEFINED_DURATION);
        int iF = cV.f(HE5.Toolbar_contentInsetLeft, 0);
        int iF2 = cV.f(HE5.Toolbar_contentInsetRight, 0);
        i();
        this.t.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.t.g(iE6, iE7);
        }
        this.u = cV.e(HE5.Toolbar_contentInsetStartWithNavigation, RecyclerView.UNDEFINED_DURATION);
        this.v = cV.e(HE5.Toolbar_contentInsetEndWithActions, RecyclerView.UNDEFINED_DURATION);
        this.f = cV.g(HE5.Toolbar_collapseIcon);
        this.g = cV.p(HE5.Toolbar_collapseContentDescription);
        CharSequence charSequenceP = cV.p(HE5.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = cV.p(HE5.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.j = getContext();
        setPopupTheme(cV.n(HE5.Toolbar_popupTheme, 0));
        Drawable drawableG = cV.g(HE5.Toolbar_navigationIcon);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = cV.p(HE5.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = cV.g(HE5.Toolbar_logo);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = cV.p(HE5.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        if (cV.s(HE5.Toolbar_titleTextColor)) {
            setTitleTextColor(cV.c(HE5.Toolbar_titleTextColor));
        }
        if (cV.s(HE5.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(cV.c(HE5.Toolbar_subtitleTextColor));
        }
        if (cV.s(HE5.Toolbar_menu)) {
            y(cV.n(HE5.Toolbar_menu, 0));
        }
        cV.w();
    }
}
