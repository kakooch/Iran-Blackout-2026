package ir.nasim;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewAnimationUtils;

/* renamed from: ir.nasim.wW7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC23199wW7 {
    public static final /* synthetic */ void b(final View view, final long j) {
        AbstractC13042fc3.i(view, "<this>");
        view.setVisibility(4);
        view.post(new Runnable() { // from class: ir.nasim.vW7
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC23199wW7.c(view, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view, long j) {
        AbstractC13042fc3.i(view, "$this_circularRevealed");
        if (view.isAttachedToWindow()) {
            view.setVisibility(0);
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, (view.getLeft() + view.getRight()) / 2, (view.getTop() + view.getBottom()) / 2, 0.0f, Math.max(view.getWidth(), view.getHeight()));
            animatorCreateCircularReveal.setDuration(j);
            animatorCreateCircularReveal.start();
        }
    }

    public static final /* synthetic */ int d(View view, boolean z) {
        AbstractC13042fc3.i(view, "<this>");
        Rect rect = new Rect();
        Context context = view.getContext();
        if (!(context instanceof Activity) || !z) {
            return 0;
        }
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static final /* synthetic */ Point e(View view) {
        AbstractC13042fc3.i(view, "<this>");
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public static final /* synthetic */ void f(View view, boolean z) {
        AbstractC13042fc3.i(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }
}
