package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.C;
import androidx.customview.view.AbsSavedState;
import ir.nasim.AbstractC10961cV3;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC24690z26;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C14394hq4;
import ir.nasim.GE5;
import ir.nasim.X17;

/* loaded from: classes3.dex */
public abstract class NavigationBarView extends FrameLayout {
    private final C14394hq4 a;
    private final NavigationBarMenuView b;
    private final NavigationBarPresenter c;
    private ColorStateList d;
    private MenuInflater e;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        Bundle c;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel, ClassLoader classLoader) {
            this.c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    class a implements e.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            NavigationBarView.a(NavigationBarView.this);
            NavigationBarView.b(NavigationBarView.this);
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    public interface b {
    }

    public interface c {
    }

    public NavigationBarView(Context context, AttributeSet attributeSet, int i, int i2) throws Resources.NotFoundException {
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.c = navigationBarPresenter;
        Context context2 = getContext();
        C cI = AbstractC5729Ko7.i(context2, attributeSet, GE5.NavigationBarView, i, i2, GE5.NavigationBarView_itemTextAppearanceInactive, GE5.NavigationBarView_itemTextAppearanceActive);
        C14394hq4 c14394hq4 = new C14394hq4(context2, getClass(), getMaxItemCount());
        this.a = c14394hq4;
        NavigationBarMenuView navigationBarMenuViewD = d(context2);
        this.b = navigationBarMenuViewD;
        navigationBarPresenter.b(navigationBarMenuViewD);
        navigationBarPresenter.a(1);
        navigationBarMenuViewD.setPresenter(navigationBarPresenter);
        c14394hq4.b(navigationBarPresenter);
        navigationBarPresenter.l(getContext(), c14394hq4);
        if (cI.s(GE5.NavigationBarView_itemIconTint)) {
            navigationBarMenuViewD.setIconTintList(cI.c(GE5.NavigationBarView_itemIconTint));
        } else {
            navigationBarMenuViewD.setIconTintList(navigationBarMenuViewD.e(R.attr.textColorSecondary));
        }
        setItemIconSize(cI.f(GE5.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_navigation_bar_item_default_icon_size)));
        if (cI.s(GE5.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(cI.n(GE5.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (cI.s(GE5.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(cI.n(GE5.NavigationBarView_itemTextAppearanceActive, 0));
        }
        if (cI.s(GE5.NavigationBarView_itemTextColor)) {
            setItemTextColor(cI.c(GE5.NavigationBarView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            AbstractC12990fW7.t0(this, c(context2));
        }
        if (cI.s(GE5.NavigationBarView_itemPaddingTop)) {
            setItemPaddingTop(cI.f(GE5.NavigationBarView_itemPaddingTop, 0));
        }
        if (cI.s(GE5.NavigationBarView_itemPaddingBottom)) {
            setItemPaddingBottom(cI.f(GE5.NavigationBarView_itemPaddingBottom, 0));
        }
        if (cI.s(GE5.NavigationBarView_elevation)) {
            setElevation(cI.f(GE5.NavigationBarView_elevation, 0));
        }
        AbstractC21710u02.i(getBackground().mutate(), AbstractC9751aV3.b(context2, cI, GE5.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(cI.l(GE5.NavigationBarView_labelVisibilityMode, -1));
        int iN = cI.n(GE5.NavigationBarView_itemBackground, 0);
        if (iN != 0) {
            navigationBarMenuViewD.setItemBackgroundRes(iN);
        } else {
            setItemRippleColor(AbstractC9751aV3.b(context2, cI, GE5.NavigationBarView_itemRippleColor));
        }
        int iN2 = cI.n(GE5.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (iN2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iN2, GE5.NavigationBarActiveIndicator);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.NavigationBarActiveIndicator_android_width, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.NavigationBarActiveIndicator_android_height, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(GE5.NavigationBarActiveIndicator_marginHorizontal, 0));
            setItemActiveIndicatorColor(AbstractC9751aV3.a(context2, typedArrayObtainStyledAttributes, GE5.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(C11411cx6.b(context2, typedArrayObtainStyledAttributes.getResourceId(GE5.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m());
            typedArrayObtainStyledAttributes.recycle();
        }
        if (cI.s(GE5.NavigationBarView_menu)) {
            e(cI.n(GE5.NavigationBarView_menu, 0));
        }
        cI.w();
        addView(navigationBarMenuViewD);
        c14394hq4.V(new a());
    }

    static /* synthetic */ b a(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    static /* synthetic */ c b(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    private C10345bV3 c(Context context) {
        C10345bV3 c10345bV3 = new C10345bV3();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            c10345bV3.b0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        c10345bV3.Q(context);
        return c10345bV3;
    }

    private MenuInflater getMenuInflater() {
        if (this.e == null) {
            this.e = new X17(getContext());
        }
        return this.e;
    }

    protected abstract NavigationBarMenuView d(Context context);

    public void e(int i) {
        this.c.m(true);
        getMenuInflater().inflate(i, this.a);
        this.c.m(false);
        this.c.i(true);
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.b.getItemActiveIndicatorMarginHorizontal();
    }

    public C11411cx6 getItemActiveIndicatorShapeAppearance() {
        return this.b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.d;
    }

    public int getItemTextAppearanceActive() {
        return this.b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.a;
    }

    public k getMenuView() {
        return this.b;
    }

    public NavigationBarPresenter getPresenter() {
        return this.c;
    }

    public int getSelectedItemId() {
        return this.b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC10961cV3.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.a.S(savedState.c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.c = bundle;
        this.a.U(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC10961cV3.d(this, f);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.b.setItemActiveIndicatorEnabled(z);
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.b.setItemActiveIndicatorHeight(i);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.b.setItemActiveIndicatorMarginHorizontal(i);
    }

    public void setItemActiveIndicatorShapeAppearance(C11411cx6 c11411cx6) {
        this.b.setItemActiveIndicatorShapeAppearance(c11411cx6);
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.b.setItemActiveIndicatorWidth(i);
    }

    public void setItemBackground(Drawable drawable) {
        this.b.setItemBackground(drawable);
        this.d = null;
    }

    public void setItemBackgroundResource(int i) {
        this.b.setItemBackgroundRes(i);
        this.d = null;
    }

    public void setItemIconSize(int i) {
        this.b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i, View.OnTouchListener onTouchListener) {
        this.b.setItemOnTouchListener(i, onTouchListener);
    }

    public void setItemPaddingBottom(int i) {
        this.b.setItemPaddingBottom(i);
    }

    public void setItemPaddingTop(int i) {
        this.b.setItemPaddingTop(i);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        if (this.d == colorStateList) {
            if (colorStateList != null || this.b.getItemBackground() == null) {
                return;
            }
            this.b.setItemBackground(null);
            return;
        }
        this.d = colorStateList;
        if (colorStateList == null) {
            this.b.setItemBackground(null);
        } else {
            this.b.setItemBackground(new RippleDrawable(AbstractC24690z26.a(colorStateList), null, null));
        }
    }

    public void setItemTextAppearanceActive(int i) throws Resources.NotFoundException {
        this.b.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceInactive(int i) throws Resources.NotFoundException {
        this.b.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.b.getLabelVisibilityMode() != i) {
            this.b.setLabelVisibilityMode(i);
            this.c.i(false);
        }
    }

    public void setOnItemReselectedListener(b bVar) {
    }

    public void setOnItemSelectedListener(c cVar) {
    }

    public void setSelectedItemId(int i) {
        MenuItem menuItemFindItem = this.a.findItem(i);
        if (menuItemFindItem == null || this.a.O(menuItemFindItem, this.c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
