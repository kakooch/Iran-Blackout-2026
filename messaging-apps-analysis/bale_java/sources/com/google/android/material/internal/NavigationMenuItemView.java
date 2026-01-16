package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.LinearLayoutCompat;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC8375Vr7;
import ir.nasim.C22317v2;
import ir.nasim.HB5;
import ir.nasim.VW5;
import ir.nasim.WB5;
import ir.nasim.X2;
import ir.nasim.YC5;

/* loaded from: classes3.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements k.a {
    private static final int[] J = {R.attr.state_checked};
    private g A;
    private ColorStateList B;
    private boolean D;
    private Drawable G;
    private final C22317v2 H;
    private int v;
    private boolean w;
    boolean x;
    private final CheckedTextView y;
    private FrameLayout z;

    class a extends C22317v2 {
        a() {
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            x2.n0(NavigationMenuItemView.this.x);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void B() {
        if (E()) {
            this.y.setVisibility(8);
            FrameLayout frameLayout = this.z;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.z.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.y.setVisibility(0);
        FrameLayout frameLayout2 = this.z;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.z.setLayoutParams(layoutParams2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(AbstractC15790kA5.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(J, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean E() {
        return this.A.getTitle() == null && this.A.getIcon() == null && this.A.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.z == null) {
                this.z = (FrameLayout) ((ViewStub) findViewById(WB5.design_menu_item_action_area_stub)).inflate();
            }
            this.z.removeAllViews();
            this.z.addView(view);
        }
    }

    public void D() {
        FrameLayout frameLayout = this.z;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.y.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void c(g gVar, int i) {
        this.A = gVar;
        if (gVar.getItemId() > 0) {
            setId(gVar.getItemId());
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            AbstractC12990fW7.t0(this, C());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        AbstractC8375Vr7.a(this, gVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        g gVar = this.A;
        if (gVar != null && gVar.isCheckable() && this.A.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, J);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.x != z) {
            this.x = z;
            this.H.l(this.y, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.y.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = AbstractC21710u02.l(drawable).mutate();
                AbstractC21710u02.i(drawable, this.B);
            }
            int i = this.v;
            drawable.setBounds(0, 0, i, i);
        } else if (this.w) {
            if (this.G == null) {
                Drawable drawableF = VW5.f(getResources(), HB5.navigation_empty_icon, getContext().getTheme());
                this.G = drawableF;
                if (drawableF != null) {
                    int i2 = this.v;
                    drawableF.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.G;
        }
        AbstractC15575jo7.j(this.y, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.y.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.v = i;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.B = colorStateList;
        this.D = colorStateList != null;
        g gVar = this.A;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.y.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.w = z;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearance(int i) {
        AbstractC15575jo7.p(this.y, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.y.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a();
        this.H = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(YC5.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(AbstractC12799fB5.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(WB5.design_menu_item_text);
        this.y = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        AbstractC12990fW7.p0(checkedTextView, aVar);
    }
}
