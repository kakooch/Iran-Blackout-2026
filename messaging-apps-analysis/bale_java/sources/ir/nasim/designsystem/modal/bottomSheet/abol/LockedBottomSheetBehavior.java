package ir.nasim.designsystem.modal.bottomSheet.abol;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C22078ud6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\b\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ,\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\b\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\rJ<\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\b\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015JD\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\b\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\b\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ<\u0010\"\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\b\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b9¨\u0006$"}, d2 = {"Lir/nasim/designsystem/modal/bottomSheet/abol/LockedBottomSheetBehavior;", "Landroid/view/View;", TokenNames.V, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "<init>", "()V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "child", "Landroid/view/MotionEvent;", "event", "", "k", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "D", "coordinatorLayout", "directTargetChild", "target", "", "nestedScrollAxes", "z", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;I)Z", "dx", "dy", "", "consumed", "Lir/nasim/rB7;", "p", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[I)V", "B", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)V", "", "velocityX", "velocityY", "o", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;FF)Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class LockedBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void B(CoordinatorLayout coordinatorLayout, View child, View target) {
        AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
        AbstractC13042fc3.i(child, "child");
        AbstractC13042fc3.i(target, "target");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout parent, View child, MotionEvent event) {
        AbstractC13042fc3.i(parent, "parent");
        AbstractC13042fc3.i(child, "child");
        AbstractC13042fc3.i(event, "event");
        if (child.getTop() <= event.getY() && event.getY() <= child.getTop() + C22078ud6.a(80.0f)) {
            return super.D(parent, child, event);
        }
        if (k0() == 1) {
            return super.D(parent, child, event);
        }
        if (k0() == 2) {
            return super.D(parent, child, event);
        }
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout parent, View child, MotionEvent event) {
        AbstractC13042fc3.i(parent, "parent");
        AbstractC13042fc3.i(child, "child");
        AbstractC13042fc3.i(event, "event");
        if (child.getTop() <= event.getY() && event.getY() <= child.getTop() + C22078ud6.a(80.0f)) {
            return super.k(parent, child, event);
        }
        if (k0() == 1) {
            return super.k(parent, child, event);
        }
        if (k0() == 2) {
            return super.k(parent, child, event);
        }
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean o(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
        AbstractC13042fc3.i(child, "child");
        AbstractC13042fc3.i(target, "target");
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void p(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
        AbstractC13042fc3.i(child, "child");
        AbstractC13042fc3.i(target, "target");
        AbstractC13042fc3.i(consumed, "consumed");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean z(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
        AbstractC13042fc3.i(child, "child");
        AbstractC13042fc3.i(directTargetChild, "directTargetChild");
        AbstractC13042fc3.i(target, "target");
        return false;
    }
}
