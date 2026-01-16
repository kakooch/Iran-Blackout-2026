package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class OH5 extends RecyclerView.o {
    private static final a c = new a(null);
    private static final int d = AbstractC8943Xx1.c(1);
    private final int a;
    private final InterfaceC9173Yu3 b;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ OH5(int i, int i2, int i3, ED1 ed1) {
        this(i, (i3 & 2) != 0 ? d : i2);
    }

    private final Paint m() {
        return (Paint) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint n(int i) {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(i);
        return paint;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        AbstractC13042fc3.i(canvas, "c");
        AbstractC13042fc3.i(recyclerView, "parent");
        AbstractC13042fc3.i(zVar, "state");
        super.k(canvas, recyclerView, zVar);
        if (recyclerView.getChildCount() <= 1) {
            return;
        }
        float paddingLeft = recyclerView.getPaddingLeft();
        float width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount() - 1;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            AbstractC13042fc3.h(childAt, "getChildAt(...)");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            canvas.drawRect(paddingLeft, childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin, width, this.a + r1, m());
        }
    }

    public OH5(final int i, int i2) {
        this.a = i2;
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.NH5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return OH5.n(i);
            }
        });
    }
}
