package ir.nasim;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* renamed from: ir.nasim.m0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC16866m0 {

    /* renamed from: ir.nasim.m0$a */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iMin = Math.min(C22078ud6.b(), this.a.getHeight());
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.e) ((View) this.a.getParent()).getLayoutParams()).f();
            if (behaviorF instanceof BottomSheetBehavior) {
                ((BottomSheetBehavior) behaviorF).F0(iMin);
            }
        }
    }

    default boolean a() {
        return false;
    }

    default void f(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view));
    }

    default void b() {
    }
}
