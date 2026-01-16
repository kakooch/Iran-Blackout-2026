package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class Tooltip extends AppCompatTextView {
    private View h;
    private ViewPropertyAnimator i;
    private boolean j;
    Runnable k;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Tooltip.this.setVisibility(8);
        }
    }

    public Tooltip(Context context, ViewGroup viewGroup, int i, int i2) {
        super(context);
        this.k = new Runnable() { // from class: ir.nasim.Ur7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t();
            }
        };
        setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.W(AbstractC21455b.F(3.0f), i));
        setTextColor(i2);
        setTextSize(1, 14.0f);
        setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(7.0f));
        setGravity(16);
        viewGroup.addView(this, AbstractC13840gu3.c(-2, -2.0f, 51, 5.0f, 0.0f, 5.0f, 3.0f));
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        ViewPropertyAnimator duration = animate().alpha(0.0f).setListener(new a()).setDuration(300L);
        this.i = duration;
        duration.start();
    }

    private void v() {
        if (this.h == null) {
            return;
        }
        View view = (View) getParent();
        int left = 0;
        int top = 0;
        for (View view2 = this.h; view2 != view; view2 = (View) view2.getParent()) {
            top += view2.getTop();
            left += view2.getLeft();
        }
        int width = (left + (this.h.getWidth() / 2)) - (getMeasuredWidth() / 2);
        setTranslationX(width >= 0 ? getMeasuredWidth() + width > view.getMeasuredWidth() ? (view.getMeasuredWidth() - getMeasuredWidth()) - AbstractC21455b.F(16.0f) : width : 0);
        setTranslationY(top - getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        v();
    }

    public void s() {
        if (this.j) {
            ViewPropertyAnimator viewPropertyAnimator = this.i;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.setListener(null);
                this.i.cancel();
                this.i = null;
            }
            AbstractC21455b.t(this.k);
            this.k.run();
        }
        this.j = false;
    }

    public void u(View view) {
        if (view == null) {
            return;
        }
        this.h = view;
        v();
        this.j = true;
        AbstractC21455b.t(this.k);
        AbstractC21455b.n1(this.k, 2000L);
        ViewPropertyAnimator viewPropertyAnimator = this.i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setListener(null);
            this.i.cancel();
            this.i = null;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
            setVisibility(0);
            ViewPropertyAnimator listener = animate().setDuration(300L).alpha(1.0f).setListener(null);
            this.i = listener;
            listener.start();
        }
    }
}
