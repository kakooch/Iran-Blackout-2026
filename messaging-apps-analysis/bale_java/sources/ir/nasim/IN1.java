package ir.nasim;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.B98;
import java.util.List;

/* loaded from: classes2.dex */
final class IN1 extends AbstractComposeView implements InterfaceC22474vI4 {
    private final Window i;
    private final InterfaceC9102Ym4 j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;

    public static final class a extends B98.b {
        a() {
            super(1);
        }

        @Override // ir.nasim.B98.b
        public O98 e(O98 o98, List list) {
            IN1 in1 = IN1.this;
            if (in1.l) {
                return o98;
            }
            View childAt = in1.getChildAt(0);
            int iMax = Math.max(0, childAt.getLeft());
            int iMax2 = Math.max(0, childAt.getTop());
            int iMax3 = Math.max(0, in1.getWidth() - childAt.getRight());
            int iMax4 = Math.max(0, in1.getHeight() - childAt.getBottom());
            return (iMax == 0 && iMax2 == 0 && iMax3 == 0 && iMax4 == 0) ? o98 : o98.p(iMax, iMax2, iMax3, iMax4);
        }

        @Override // ir.nasim.B98.b
        public B98.a f(B98 b98, B98.a aVar) {
            IN1 in1 = IN1.this;
            if (in1.l) {
                return aVar;
            }
            View childAt = in1.getChildAt(0);
            int iMax = Math.max(0, childAt.getLeft());
            int iMax2 = Math.max(0, childAt.getTop());
            int iMax3 = Math.max(0, in1.getWidth() - childAt.getRight());
            int iMax4 = Math.max(0, in1.getHeight() - childAt.getBottom());
            return (iMax == 0 && iMax2 == 0 && iMax3 == 0 && iMax4 == 0) ? aVar : aVar.c(L93.b(iMax, iMax2, iMax3, iMax4));
        }
    }

    public IN1(Context context, Window window) {
        super(context, null, 0, 6, null);
        this.i = window;
        this.j = AbstractC13472gH6.d(K11.a.a(), null, 2, null);
        AbstractC12990fW7.E0(this, this);
        AbstractC12990fW7.N0(this, new a());
    }

    private final InterfaceC14603iB2 getContent() {
        return (InterfaceC14603iB2) this.j.getValue();
    }

    private final void setContent(InterfaceC14603iB2 interfaceC14603iB2) {
        this.j.setValue(interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC22474vI4
    public O98 b(View view, O98 o98) {
        if (this.l) {
            return o98;
        }
        View childAt = getChildAt(0);
        int iMax = Math.max(0, childAt.getLeft());
        int iMax2 = Math.max(0, childAt.getTop());
        int iMax3 = Math.max(0, getWidth() - childAt.getRight());
        int iMax4 = Math.max(0, getHeight() - childAt.getBottom());
        return (iMax == 0 && iMax2 == 0 && iMax3 == 0 && iMax4 == 0) ? o98 : o98.p(iMax, iMax2, iMax3, iMax4);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(1735448596);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1735448596, i, -1, "androidx.compose.ui.window.DialogLayout.Content (AndroidDialog.android.kt:410)");
        }
        getContent().invoke(interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.n;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void j(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int paddingLeft2 = getPaddingLeft() + (((i5 - measuredWidth) - paddingLeft) / 2);
        int paddingTop2 = getPaddingTop() + (((i6 - measuredHeight) - paddingTop) / 2);
        childAt.layout(paddingLeft2, paddingTop2, measuredWidth + paddingLeft2, measuredHeight + paddingTop2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void k(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.k(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int i3 = (mode != Integer.MIN_VALUE || this.k || this.l || o().getAttributes().height != -2) ? size2 : size2 + 1;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i4 = size - paddingLeft;
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = i3 - paddingTop;
        int i6 = i5 >= 0 ? i5 : 0;
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode2 != 0) {
            i = View.MeasureSpec.makeMeasureSpec(i4, RecyclerView.UNDEFINED_DURATION);
        }
        if (mode != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i6, RecyclerView.UNDEFINED_DURATION);
        }
        childAt.measure(i, i2);
        if (mode2 == Integer.MIN_VALUE) {
            size = Math.min(size, childAt.getMeasuredWidth() + paddingLeft);
        } else if (mode2 != 1073741824) {
            size = childAt.getMeasuredWidth() + paddingLeft;
        }
        setMeasuredDimension(size, mode != Integer.MIN_VALUE ? mode != 1073741824 ? childAt.getMeasuredHeight() + paddingTop : size2 : Math.min(size2, childAt.getMeasuredHeight() + paddingTop));
        if (this.k || this.l || childAt.getMeasuredHeight() + paddingTop <= size2 || o().getAttributes().height != -2) {
            return;
        }
        o().setLayout(-1, -1);
    }

    public Window o() {
        return this.i;
    }

    public final boolean p(MotionEvent motionEvent) {
        View childAt;
        int iD;
        float x = motionEvent.getX();
        if (Float.isInfinite(x) || Float.isNaN(x)) {
            return false;
        }
        float y = motionEvent.getY();
        if (Float.isInfinite(y) || Float.isNaN(y) || (childAt = getChildAt(0)) == null) {
            return false;
        }
        int left = getLeft() + childAt.getLeft();
        int width = childAt.getWidth() + left;
        int top = getTop() + childAt.getTop();
        int height = childAt.getHeight() + top;
        int iD2 = AbstractC20723sV3.d(motionEvent.getX());
        return left <= iD2 && iD2 <= width && top <= (iD = AbstractC20723sV3.d(motionEvent.getY())) && iD <= height;
    }

    public final void q(boolean z, boolean z2) {
        boolean z3 = (this.m && z == this.k && z2 == this.l) ? false : true;
        this.k = z;
        this.l = z2;
        if (z3) {
            WindowManager.LayoutParams attributes = o().getAttributes();
            int i = z ? -2 : -1;
            if (i == attributes.width && this.m) {
                return;
            }
            o().setLayout(i, -2);
            this.m = true;
        }
    }

    public final void setContent(AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2) {
        setParentCompositionContext(abstractC7050Qb1);
        setContent(interfaceC14603iB2);
        this.n = true;
        g();
    }
}
