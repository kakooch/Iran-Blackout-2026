package ir.nasim;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class YV1 extends RecyclerView.o {
    private final Drawable a;

    public YV1(Drawable drawable) {
        AbstractC13042fc3.i(drawable, "mDivider");
        this.a = drawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(recyclerView, "parent");
        AbstractC13042fc3.i(zVar, "state");
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount() - 2;
        if (childCount < 0) {
            return;
        }
        int i = 0;
        while (true) {
            View childAt = recyclerView.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
            this.a.setBounds(paddingLeft, bottom, width, this.a.getIntrinsicHeight() + bottom);
            this.a.draw(canvas);
            if (i == childCount) {
                return;
            } else {
                i++;
            }
        }
    }
}
