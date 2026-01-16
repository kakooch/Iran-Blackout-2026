package ir.nasim.designsystem.modal.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C11637dL5;
import ir.nasim.C12889fL5;
import ir.nasim.C5161Id6;
import ir.nasim.designsystem.modal.dialog.AlertDialog$onCreate$containerView$1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"ir/nasim/designsystem/modal/dialog/AlertDialog$onCreate$containerView$1", "Landroid/widget/LinearLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Lir/nasim/rB7;", "onMeasure", "(II)V", "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "requestLayout", "()V", "hasOverlappingRendering", "()Z", "a", "Z", "inLayout", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class AlertDialog$onCreate$containerView$1 extends LinearLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private boolean inLayout;
    final /* synthetic */ AlertDialog b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlertDialog$onCreate$containerView$1(AlertDialog alertDialog, Context context) {
        super(context);
        this.b = alertDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(ir.nasim.designsystem.modal.dialog.AlertDialog r6, android.widget.ScrollView r7) {
        /*
            java.lang.String r0 = "this$0"
            ir.nasim.AbstractC13042fc3.i(r6, r0)
            java.lang.String r0 = "$this_apply"
            ir.nasim.AbstractC13042fc3.i(r7, r0)
            android.widget.TextView r0 = ir.nasim.designsystem.modal.dialog.AlertDialog.r(r6)
            r1 = 0
            java.lang.String r2 = "scrollContainer"
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L2b
            int r0 = r7.getScrollY()
            android.widget.LinearLayout r5 = ir.nasim.designsystem.modal.dialog.AlertDialog.o(r6)
            if (r5 != 0) goto L23
            ir.nasim.AbstractC13042fc3.y(r2)
            r5 = r1
        L23:
            int r5 = r5.getTop()
            if (r0 <= r5) goto L2b
            r0 = r3
            goto L2c
        L2b:
            r0 = r4
        L2c:
            ir.nasim.designsystem.modal.dialog.AlertDialog.s(r6, r4, r0)
            int r0 = r7.getScrollY()
            int r5 = r7.getHeight()
            int r0 = r0 + r5
            android.widget.LinearLayout r5 = ir.nasim.designsystem.modal.dialog.AlertDialog.o(r6)
            if (r5 != 0) goto L42
            ir.nasim.AbstractC13042fc3.y(r2)
            goto L43
        L42:
            r1 = r5
        L43:
            int r1 = r1.getBottom()
            if (r0 >= r1) goto L4a
            r4 = r3
        L4a:
            ir.nasim.designsystem.modal.dialog.AlertDialog.s(r6, r3, r4)
            r7.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.designsystem.modal.dialog.AlertDialog$onCreate$containerView$1.d(ir.nasim.designsystem.modal.dialog.AlertDialog, android.widget.ScrollView):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView e(AlertDialog alertDialog, int i, C11637dL5 c11637dL5, C12889fL5 c12889fL5) {
        AbstractC13042fc3.i(alertDialog, "this$0");
        AbstractC13042fc3.i(c11637dL5, "$availableHeight");
        AbstractC13042fc3.i(c12889fL5, "$layoutParams");
        TextView textView = alertDialog.c;
        if (textView == null) {
            AbstractC13042fc3.y("messageTextView");
            textView = null;
        }
        textView.measure(i, View.MeasureSpec.makeMeasureSpec(c11637dL5.a, RecyclerView.UNDEFINED_DURATION));
        if (textView.getVisibility() != 8) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            c12889fL5.a = (LinearLayout.LayoutParams) layoutParams;
            int i2 = c11637dL5.a;
            int measuredHeight = textView.getMeasuredHeight();
            Object obj = c12889fL5.a;
            c11637dL5.a = i2 - ((measuredHeight + ((LinearLayout.LayoutParams) obj).bottomMargin) + ((LinearLayout.LayoutParams) obj).topMargin);
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AlertDialog alertDialog) {
        AbstractC13042fc3.i(alertDialog, "this$0");
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        alertDialog.k = aVar.m().x;
        int iF = aVar.m().x - aVar.f(56.0f);
        int iF2 = C5161Id6.k() ? C5161Id6.a.j() ? aVar.f(446.0f) : aVar.f(496.0f) : aVar.f(356.0f);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window != null ? window.getAttributes() : null);
        layoutParams.width = (int) (Math.min(iF2, iF) + alertDialog.D.left + alertDialog.D.right);
        if (window != null) {
            window.setAttributes(layoutParams);
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        final ScrollView scrollView = this.b.e;
        if (scrollView != null) {
            final AlertDialog alertDialog = this.b;
            if (alertDialog.g == null) {
                alertDialog.g = new ViewTreeObserver.OnScrollChangedListener() { // from class: ir.nasim.Xl
                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public final void onScrollChanged() {
                        AlertDialog$onCreate$containerView$1.d(alertDialog, scrollView);
                    }
                };
                scrollView.getViewTreeObserver().addOnScrollChangedListener(alertDialog.g);
            }
            ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = alertDialog.g;
            if (onScrollChangedListener != null) {
                onScrollChangedListener.onScrollChanged();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016e  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.designsystem.modal.dialog.AlertDialog$onCreate$containerView$1.onMeasure(int, int):void");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.inLayout) {
            return;
        }
        super.requestLayout();
    }
}
