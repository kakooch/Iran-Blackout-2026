package ir.nasim;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class OZ extends RecyclerView.o {
    public static final a e = new a(null);
    public static final int f = 8;
    private static final int[] g = {android.R.attr.listDivider};
    private final boolean a;
    private Drawable b;
    private int c;
    private final Rect d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public OZ(Context context, int i, boolean z) {
        AbstractC13042fc3.i(context, "context");
        this.a = z;
        this.d = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(g);
        AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.b = drawable;
        if (drawable == null) {
            Log.w("BaleDivider", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        p(i);
    }

    private final void l(Canvas canvas, RecyclerView recyclerView, Drawable drawable) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = this.a ? recyclerView.getChildCount() : recyclerView.getChildCount() - 1;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.d);
            int iD = this.d.right + AbstractC20723sV3.d(childAt.getTranslationX());
            drawable.setBounds(iD - drawable.getIntrinsicWidth(), paddingTop, iD, height);
            drawable.draw(canvas);
        }
        canvas.restore();
    }

    private final void m(Canvas canvas, RecyclerView recyclerView, Drawable drawable) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = this.a ? recyclerView.getChildCount() : recyclerView.getChildCount() - 1;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.d);
            int iD = this.d.bottom + AbstractC20723sV3.d(childAt.getTranslationY());
            drawable.setBounds(paddingLeft, iD - drawable.getIntrinsicHeight(), width, iD);
            drawable.draw(canvas);
        }
        canvas.restore();
    }

    private final boolean n(RecyclerView recyclerView, View view) {
        RecyclerView.h adapter;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        return (childAdapterPosition == -1 || (adapter = recyclerView.getAdapter()) == null || childAdapterPosition != adapter.getItemCount() - 1) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        AbstractC13042fc3.i(rect, "outRect");
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(recyclerView, "parent");
        AbstractC13042fc3.i(zVar, "state");
        Drawable drawable = this.b;
        if (drawable == null || (!this.a && n(recyclerView, view))) {
            rect.set(0, 0, 0, 0);
        } else if (this.c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        AbstractC13042fc3.i(canvas, "c");
        AbstractC13042fc3.i(recyclerView, "parent");
        AbstractC13042fc3.i(zVar, "state");
        Drawable drawable = this.b;
        if (drawable == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        if (this.c == 1) {
            m(canvas, recyclerView, drawable);
        } else {
            l(canvas, recyclerView, drawable);
        }
    }

    public final void o(Drawable drawable) {
        AbstractC13042fc3.i(drawable, "drawable");
        this.b = drawable;
    }

    public final void p(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL".toString());
        }
        this.c = i;
    }
}
