package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.k;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import androidx.transition.r;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC16714lk4;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9594aE;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C23313wi5;
import ir.nasim.C6187Mn7;
import ir.nasim.DC5;
import ir.nasim.InterfaceC20850si5;
import ir.nasim.X2;
import java.util.HashSet;

/* loaded from: classes3.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements k {
    private static final int[] D = {R.attr.state_checked};
    private static final int[] G = {-16842910};
    private NavigationBarPresenter A;
    private e B;
    private final TransitionSet a;
    private final View.OnClickListener b;
    private final InterfaceC20850si5 c;
    private final SparseArray d;
    private int e;
    private NavigationBarItemView[] f;
    private int g;
    private int h;
    private ColorStateList i;
    private int j;
    private ColorStateList k;
    private final ColorStateList l;
    private int m;
    private int n;
    private Drawable o;
    private int p;
    private final SparseArray q;
    private int r;
    private int s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private C11411cx6 x;
    private boolean y;
    private ColorStateList z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g itemData = ((NavigationBarItemView) view).getItemData();
            if (NavigationBarMenuView.this.B.O(itemData, NavigationBarMenuView.this.A, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public NavigationBarMenuView(Context context) {
        super(context);
        this.c = new C23313wi5(5);
        this.d = new SparseArray(5);
        this.g = 0;
        this.h = 0;
        this.q = new SparseArray(5);
        this.r = -1;
        this.s = -1;
        this.y = false;
        this.l = e(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.a = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.a = autoTransition;
            autoTransition.w0(0);
            autoTransition.b0(AbstractC16714lk4.d(getContext(), AbstractC12181eA5.motionDurationLong1, getResources().getInteger(DC5.material_motion_duration_long_1)));
            autoTransition.e0(AbstractC16714lk4.e(getContext(), AbstractC12181eA5.motionEasingStandard, AbstractC6732Ot.b));
            autoTransition.n0(new C6187Mn7());
        }
        this.b = new a();
        AbstractC12990fW7.A0(this, 1);
    }

    private Drawable f() {
        if (this.x == null || this.z == null) {
            return null;
        }
        C10345bV3 c10345bV3 = new C10345bV3(this.x);
        c10345bV3.b0(this.z);
        return c10345bV3;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.c.b();
        return navigationBarItemView == null ? g(getContext()) : navigationBarItemView;
    }

    private boolean i(int i) {
        return i != -1;
    }

    private void j() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.B.size(); i++) {
            hashSet.add(Integer.valueOf(this.B.getItem(i).getItemId()));
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            int iKeyAt = this.q.keyAt(i2);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.q.delete(iKeyAt);
            }
        }
    }

    private void setBadgeIfNeeded(NavigationBarItemView navigationBarItemView) throws Resources.NotFoundException {
        com.google.android.material.badge.a aVar;
        int id = navigationBarItemView.getId();
        if (i(id) && (aVar = (com.google.android.material.badge.a) this.q.get(id)) != null) {
            navigationBarItemView.setBadge(aVar);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(e eVar) {
        this.B = eVar;
    }

    public void d() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.c.a(navigationBarItemView);
                    navigationBarItemView.h();
                }
            }
        }
        if (this.B.size() == 0) {
            this.g = 0;
            this.h = 0;
            this.f = null;
            return;
        }
        j();
        this.f = new NavigationBarItemView[this.B.size()];
        boolean zH = h(this.e, this.B.G().size());
        for (int i = 0; i < this.B.size(); i++) {
            this.A.m(true);
            this.B.getItem(i).setCheckable(true);
            this.A.m(false);
            NavigationBarItemView newItem = getNewItem();
            this.f[i] = newItem;
            newItem.setIconTintList(this.i);
            newItem.setIconSize(this.j);
            newItem.setTextColor(this.l);
            newItem.setTextAppearanceInactive(this.m);
            newItem.setTextAppearanceActive(this.n);
            newItem.setTextColor(this.k);
            int i2 = this.r;
            if (i2 != -1) {
                newItem.setItemPaddingTop(i2);
            }
            int i3 = this.s;
            if (i3 != -1) {
                newItem.setItemPaddingBottom(i3);
            }
            newItem.setActiveIndicatorWidth(this.u);
            newItem.setActiveIndicatorHeight(this.v);
            newItem.setActiveIndicatorMarginHorizontal(this.w);
            newItem.setActiveIndicatorDrawable(f());
            newItem.setActiveIndicatorResizeable(this.y);
            newItem.setActiveIndicatorEnabled(this.t);
            Drawable drawable = this.o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.p);
            }
            newItem.setShifting(zH);
            newItem.setLabelVisibilityMode(this.e);
            g gVar = (g) this.B.getItem(i);
            newItem.c(gVar, 0);
            newItem.setItemPosition(i);
            int itemId = gVar.getItemId();
            newItem.setOnTouchListener((View.OnTouchListener) this.d.get(itemId));
            newItem.setOnClickListener(this.b);
            int i4 = this.g;
            if (i4 != 0 && itemId == i4) {
                this.h = i;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.B.size() - 1, this.h);
        this.h = iMin;
        this.B.getItem(iMin).setChecked(true);
    }

    public ColorStateList e(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = AbstractC9594aE.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(AbstractC15790kA5.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = G;
        return new ColorStateList(new int[][]{iArr, D, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    protected abstract NavigationBarItemView g(Context context);

    SparseArray<com.google.android.material.badge.a> getBadgeDrawables() {
        return this.q;
    }

    public ColorStateList getIconTintList() {
        return this.i;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.z;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.t;
    }

    public int getItemActiveIndicatorHeight() {
        return this.v;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.w;
    }

    public C11411cx6 getItemActiveIndicatorShapeAppearance() {
        return this.x;
    }

    public int getItemActiveIndicatorWidth() {
        return this.u;
    }

    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.o : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.p;
    }

    public int getItemIconSize() {
        return this.j;
    }

    public int getItemPaddingBottom() {
        return this.s;
    }

    public int getItemPaddingTop() {
        return this.r;
    }

    public int getItemTextAppearanceActive() {
        return this.n;
    }

    public int getItemTextAppearanceInactive() {
        return this.m;
    }

    public ColorStateList getItemTextColor() {
        return this.k;
    }

    public int getLabelVisibilityMode() {
        return this.e;
    }

    protected e getMenu() {
        return this.B;
    }

    public int getSelectedItemId() {
        return this.g;
    }

    protected int getSelectedItemPosition() {
        return this.h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    protected boolean h(int i, int i2) {
        if (i == -1) {
            if (i2 <= 3) {
                return false;
            }
        } else if (i != 0) {
            return false;
        }
        return true;
    }

    void k(SparseArray sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            if (this.q.indexOfKey(iKeyAt) < 0) {
                this.q.append(iKeyAt, sparseArray.get(iKeyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge((com.google.android.material.badge.a) this.q.get(navigationBarItemView.getId()));
            }
        }
    }

    void l(int i) {
        int size = this.B.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.B.getItem(i2);
            if (i == item.getItemId()) {
                this.g = i;
                this.h = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    public void m() {
        TransitionSet transitionSet;
        e eVar = this.B;
        if (eVar == null || this.f == null) {
            return;
        }
        int size = eVar.size();
        if (size != this.f.length) {
            d();
            return;
        }
        int i = this.g;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.B.getItem(i2);
            if (item.isChecked()) {
                this.g = item.getItemId();
                this.h = i2;
            }
        }
        if (i != this.g && (transitionSet = this.a) != null) {
            r.a(this, transitionSet);
        }
        boolean zH = h(this.e, this.B.G().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.A.m(true);
            this.f[i3].setLabelVisibilityMode(this.e);
            this.f[i3].setShifting(zH);
            this.f[i3].c((g) this.B.getItem(i3), 0);
            this.A.m(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        X2.g1(accessibilityNodeInfo).r0(X2.e.b(1, this.B.G().size(), false, 1));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.z = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(f());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.t = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.v = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.w = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i);
            }
        }
    }

    protected void setItemActiveIndicatorResizeable(boolean z) {
        this.y = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(C11411cx6 c11411cx6) {
        this.x = c11411cx6;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(f());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.u = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.o = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.p = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i);
            }
        }
    }

    public void setItemIconSize(int i) {
        this.j = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i);
            }
        }
    }

    public void setItemOnTouchListener(int i, View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.d.remove(i);
        } else {
            this.d.put(i, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i) {
        this.s = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i);
            }
        }
    }

    public void setItemPaddingTop(int i) {
        this.r = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i);
            }
        }
    }

    public void setItemTextAppearanceActive(int i) throws Resources.NotFoundException {
        this.n = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i);
                ColorStateList colorStateList = this.k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) throws Resources.NotFoundException {
        this.m = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.e = i;
    }

    public void setPresenter(NavigationBarPresenter navigationBarPresenter) {
        this.A = navigationBarPresenter;
    }
}
