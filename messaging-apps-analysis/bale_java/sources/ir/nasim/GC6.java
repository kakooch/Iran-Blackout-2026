package ir.nasim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public final class GC6 extends RecyclerView.o {
    private final Drawable a;

    public GC6(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        Drawable drawableF = AbstractC4043Dl1.f(context, i);
        AbstractC13042fc3.f(drawableF);
        this.a = drawableF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void j(Canvas canvas, RecyclerView recyclerView) {
        AbstractC13042fc3.i(canvas, "c");
        AbstractC13042fc3.i(recyclerView, "parent");
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount() - 1;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            AbstractC13042fc3.h(childAt, "getChildAt(...)");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
            this.a.setBounds(paddingLeft, bottom, width, this.a.getIntrinsicHeight() + bottom);
            this.a.draw(canvas);
        }
    }
}
