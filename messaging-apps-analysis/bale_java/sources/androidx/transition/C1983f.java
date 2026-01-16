package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.TB5;
import java.util.ArrayList;

/* renamed from: androidx.transition.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1983f extends FrameLayout {
    private ViewGroup a;
    private boolean b;

    C1983f(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.a = viewGroup;
        viewGroup.setTag(TB5.ghost_view_holder, this);
        y.b(this.a).c(this);
        this.b = true;
    }

    static C1983f b(ViewGroup viewGroup) {
        return (C1983f) viewGroup.getTag(TB5.ghost_view_holder);
    }

    private int c(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i = 0;
        while (i <= childCount) {
            int i2 = (i + childCount) / 2;
            d(((C1985h) getChildAt(i2)).c, arrayList2);
            if (f(arrayList, arrayList2)) {
                i = i2 + 1;
            } else {
                childCount = i2 - 1;
            }
            arrayList2.clear();
        }
        return i;
    }

    private static void d(View view, ArrayList arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(y.a(viewGroup, i));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    private static boolean f(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        for (int i = 1; i < iMin; i++) {
            View view = (View) arrayList.get(i);
            View view2 = (View) arrayList2.get(i);
            if (view != view2) {
                return e(view, view2);
            }
        }
        return arrayList2.size() == iMin;
    }

    void a(C1985h c1985h) {
        ArrayList arrayList = new ArrayList();
        d(c1985h.c, arrayList);
        int iC = c(arrayList);
        if (iC < 0 || iC >= getChildCount()) {
            addView(c1985h);
        } else {
            addView(c1985h, iC);
        }
    }

    void g() {
        if (!this.b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        y.b(this.a).d(this);
        y.b(this.a).c(this);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.a.setTag(TB5.ghost_view_holder, null);
            y.b(this.a).d(this);
            this.b = false;
        }
    }
}
