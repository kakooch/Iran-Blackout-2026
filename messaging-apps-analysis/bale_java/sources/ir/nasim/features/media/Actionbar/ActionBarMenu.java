package ir.nasim.features.media.Actionbar;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.C22078ud6;
import ir.nasim.features.media.Actionbar.ActionBar;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ActionBarMenu extends FrameLayout {
    protected ActionBar a;
    private int b;
    private int c;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) view;
            if (!actionBarMenuItem.c()) {
                if (actionBarMenuItem.e()) {
                    ActionBarMenu.this.a.h(actionBarMenuItem.j(true));
                    return;
                } else {
                    ActionBarMenu.this.h(((Integer) view.getTag()).intValue());
                    return;
                }
            }
            Iterator it = ActionBarMenu.this.a.k.iterator();
            while (it.hasNext()) {
                ActionBar.b bVar = (ActionBar.b) it.next();
                if (bVar != null && bVar.a()) {
                    actionBarMenuItem.k();
                }
            }
        }
    }

    public enum b {
        RIGHT,
        LEFT
    }

    public ActionBarMenu(Context context, ActionBar actionBar) {
        super(context);
        this.a = actionBar;
        this.b = 0;
        this.c = 0;
    }

    private ActionBarMenuItem c(int i, int i2, int i3, b bVar) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag instanceof ActionBarMenuItemImp) {
            return (ActionBarMenuItemImp) viewFindViewWithTag;
        }
        ActionBarMenuItemImp actionBarMenuItemImp = new ActionBarMenuItemImp(getContext(), this, this.a.i);
        actionBarMenuItemImp.setTag(Integer.valueOf(i));
        actionBarMenuItemImp.a.setImageResource(i2);
        addView(actionBarMenuItemImp);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) actionBarMenuItemImp.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = i3;
        b bVar2 = b.LEFT;
        layoutParams.gravity = (bVar == bVar2 ? 3 : 5) | 80;
        if (bVar == bVar2) {
            this.a.setBackButtonImage(0);
        }
        if (bVar == b.RIGHT) {
            int i4 = this.c;
            layoutParams.rightMargin = i4;
            this.c = i4 + i3;
        } else {
            int i5 = this.b;
            layoutParams.leftMargin = i5;
            this.b = i5 + i3;
        }
        actionBarMenuItemImp.setLayoutParams(layoutParams);
        actionBarMenuItemImp.setOnClickListener(new a());
        return actionBarMenuItemImp;
    }

    public ActionBarMenuItem a(int i, int i2) {
        return b(i, i2, C22078ud6.a(48.0f));
    }

    public ActionBarMenuItem b(int i, int i2, int i3) {
        return c(i, i2, i3, b.RIGHT);
    }

    public ActionBarMenuItem d(int i, int i2, int i3) {
        return b(i, i2, i3);
    }

    public void e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.e()) {
                    this.a.h(actionBarMenuItem.j(false));
                    return;
                }
            }
        }
    }

    public void f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).b();
            }
        }
    }

    public void g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) actionBarMenuItem.getLayoutParams();
                if (layoutParams.gravity == 83 && layoutParams.leftMargin == 0) {
                    actionBarMenuItem.setVisibility(8);
                    return;
                }
            }
        }
    }

    public void h(int i) {
        Iterator it = this.a.k.iterator();
        while (it.hasNext()) {
            ActionBar.b bVar = (ActionBar.b) it.next();
            if (bVar != null) {
                bVar.b(i);
            }
        }
    }

    public void i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.getVisibility() == 0 && actionBarMenuItem.c()) {
                    actionBarMenuItem.k();
                    return;
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = layoutParams.gravity;
                if (i11 == -1) {
                    i11 = 49;
                }
                int i12 = i11 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                int i13 = i11 & 7;
                if (i13 == 1) {
                    i5 = ((((i3 - i) - measuredWidth) / 2) + layoutParams.leftMargin) - layoutParams.rightMargin;
                } else if (i13 != 5) {
                    i5 = layoutParams.leftMargin;
                } else {
                    i5 = (i3 - measuredWidth) - i9;
                    i9 += measuredWidth;
                }
                if (i12 == 16) {
                    i6 = (((i4 - i2) - measuredHeight) / 2) + layoutParams.topMargin;
                    i7 = layoutParams.bottomMargin;
                } else if (i12 == 48 || i12 != 80) {
                    i8 = layoutParams.topMargin;
                    childAt.layout(i5, i8, measuredWidth + i5, measuredHeight + i8);
                } else {
                    i6 = (i4 - i2) - measuredHeight;
                    i7 = layoutParams.bottomMargin;
                }
                i8 = i6 - i7;
                childAt.layout(i5, i8, measuredWidth + i5, measuredHeight + i8);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a(48.0f), 1073741824), C22078ud6.a(48.0f));
                measureChildWithMargins(childAt, i, 0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824), 0);
            }
        }
    }

    public ActionBarMenu(Context context) {
        super(context);
        this.b = 0;
        this.c = 0;
    }
}
