package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: ir.nasim.yV2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C24365yV2 extends AnimatorListenerAdapter {
    private final View a;
    private final boolean b;

    public C24365yV2(View view) {
        this.a = view;
        this.b = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.setVisibility(this.b ? 8 : 4);
    }

    public C24365yV2(View view, boolean z) {
        this.a = view;
        this.b = z;
    }
}
