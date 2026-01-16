package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class ActionBarMenu extends LinearLayout {
    protected ActionBar a;
    protected boolean b;
    private ArrayList c;
    private Runnable d;

    public ActionBarMenu(Context context, ActionBar actionBar) {
        super(context);
        setOrientation(0);
        this.a = actionBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) view;
        if (actionBarMenuItem.Q()) {
            if (this.a.E0.a()) {
                actionBarMenuItem.p0();
            }
        } else if (actionBarMenuItem.S()) {
            this.a.w(actionBarMenuItem.o0(true));
        } else {
            j(((Integer) view.getTag()).intValue());
        }
    }

    public ActionBarMenuItem b(int i, int i2) {
        return c(i, i2, this.b ? this.a.B0 : this.a.A0, null);
    }

    public ActionBarMenuItem c(int i, int i2, int i3, m.h hVar) {
        return e(i, i2, null, i3, null, AbstractC21455b.F(48.0f), null, hVar);
    }

    public ActionBarMenuItem d(int i, int i2, CharSequence charSequence, int i3, Drawable drawable, int i4, CharSequence charSequence2) {
        return e(i, i2, charSequence, i3, drawable, i4, charSequence2, null);
    }

    public ActionBarMenuItem e(int i, int i2, CharSequence charSequence, int i3, Drawable drawable, int i4, CharSequence charSequence2, m.h hVar) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(Integer.valueOf(i));
        return g(-1, i, i2, charSequence, i3, drawable, i4, charSequence2, hVar);
    }

    public ActionBarMenuItem f(int i, Drawable drawable) {
        return d(i, 0, null, this.b ? this.a.B0 : this.a.A0, drawable, AbstractC21455b.F(48.0f), null);
    }

    protected ActionBarMenuItem g(int i, int i2, int i3, CharSequence charSequence, int i4, Drawable drawable, int i5, CharSequence charSequence2, m.h hVar) {
        int i6 = i5;
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(getContext(), this, i4, this.b ? this.a.D0 : this.a.C0, charSequence != null, hVar);
        actionBarMenuItem.setTag(Integer.valueOf(i2));
        if (charSequence != null) {
            actionBarMenuItem.o.setText(charSequence);
            if (i6 == 0) {
                i6 = -2;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, -1);
            int iF = AbstractC21455b.F(14.0f);
            layoutParams.rightMargin = iF;
            layoutParams.leftMargin = iF;
            addView(actionBarMenuItem, i, layoutParams);
        } else {
            if (drawable != null) {
                if (drawable instanceof RLottieDrawable) {
                    actionBarMenuItem.m.setAnimation((RLottieDrawable) drawable);
                } else {
                    actionBarMenuItem.m.setImageDrawable(drawable);
                }
            } else if (i3 != 0) {
                actionBarMenuItem.m.setImageResource(i3);
            }
            addView(actionBarMenuItem, i, new LinearLayout.LayoutParams(i6, -1));
        }
        actionBarMenuItem.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Q4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.i(view);
            }
        });
        if (charSequence2 != null) {
            actionBarMenuItem.setContentDescription(charSequence2);
        }
        return actionBarMenuItem;
    }

    public int getItemsMeasuredWidth() {
        int childCount = getChildCount();
        int measuredWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
        return measuredWidth;
    }

    public void h(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.S() && actionBarMenuItem.T()) {
                    this.a.w(false);
                    actionBarMenuItem.o0(z);
                    return;
                }
            }
        }
    }

    public void j(int i) {
        ActionBar.e eVar = this.a.E0;
        if (eVar != null) {
            eVar.b(i);
        }
    }

    public void k() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.getVisibility() != 0) {
                    continue;
                } else if (actionBarMenuItem.Q()) {
                    actionBarMenuItem.p0();
                    return;
                } else if (actionBarMenuItem.A) {
                    j(((Integer) actionBarMenuItem.getTag()).intValue());
                    return;
                }
            }
        }
    }

    protected void l(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).k0(i);
            }
        }
    }

    public boolean m() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.getSearchContainer() != null && actionBarMenuItem.getSearchContainer().getVisibility() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void n(int i, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).setPopupItemsColor(i, z);
            }
        }
    }

    public void o(float f) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).setTransitionOffset(f);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Runnable runnable = this.d;
        if (runnable != null) {
            runnable.run();
        }
    }

    protected void p() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                childAt.setBackgroundDrawable(m.Y(this.b ? this.a.B0 : this.a.A0));
            }
        }
    }

    protected void q() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).setIconColor(this.b ? this.a.D0 : this.a.C0);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    public void setOnLayoutListener(Runnable runnable) {
        this.d = runnable;
    }

    public void setSearchTextColor(int i, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.S()) {
                    if (z) {
                        actionBarMenuItem.getSearchField().setHintTextColor(i);
                        return;
                    } else {
                        actionBarMenuItem.getSearchField().setTextColor(i);
                        return;
                    }
                }
            }
        }
    }

    public ActionBarMenu(Context context) {
        super(context);
    }
}
