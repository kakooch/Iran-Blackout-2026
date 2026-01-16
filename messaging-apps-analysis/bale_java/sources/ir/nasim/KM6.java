package ir.nasim;

import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes5.dex */
public final class KM6 extends T73 {
    private final Barrier h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KM6(TextView textView, TextView textView2, Barrier barrier) {
        super(textView, textView2, null, 4, null);
        AbstractC13042fc3.i(textView, "reactions");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(barrier, "barrier");
        this.h = barrier;
    }

    @Override // ir.nasim.T73
    protected void h(TextView textView, TextView textView2, StaticLayout staticLayout, StaticLayout staticLayout2) {
        AbstractC13042fc3.i(textView, "reaction");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(staticLayout, "reactionLayout");
        AbstractC13042fc3.i(staticLayout2, "stateLayout");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.F = 1.0f;
        layoutParams2.t = textView2.getId();
        layoutParams2.Z = false;
        textView.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.i = -1;
        textView2.setLayoutParams(layoutParams4);
    }

    @Override // ir.nasim.T73
    protected void p(TextView textView) {
        AbstractC13042fc3.i(textView, "textViewReactions");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.t = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
        layoutParams2.Z = true;
        textView.setLayoutParams(layoutParams2);
    }

    @Override // ir.nasim.T73
    protected void q(TextView textView, TextView textView2, TextView textView3) {
        AbstractC13042fc3.i(textView, "stateView");
        AbstractC13042fc3.i(textView2, "textViewReactions");
        AbstractC13042fc3.i(textView3, "comment");
        super.q(textView, textView2, textView3);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.u = this.h.getId();
        layoutParams2.r = -1;
        textView.setLayoutParams(layoutParams2);
    }
}
