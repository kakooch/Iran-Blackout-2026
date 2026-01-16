package ir.nasim;

import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes5.dex */
public final class PM extends C21569tl7 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PM(TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(textView, textView2, textView3, textView4);
        AbstractC13042fc3.i(textView, "reactions");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(textView3, "body");
        AbstractC13042fc3.i(textView4, "comment");
    }

    @Override // ir.nasim.C21569tl7
    protected void w(TextView textView, StaticLayout staticLayout, TextView textView2, StaticLayout staticLayout2) {
        AbstractC13042fc3.i(textView, "body");
        AbstractC13042fc3.i(staticLayout, "bodyLayout");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(staticLayout2, "stateLayout");
        C(textView, textView2);
    }

    @Override // ir.nasim.C21569tl7
    protected void y(TextView textView) {
        AbstractC13042fc3.i(textView, "textViewBody");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.u = 0;
        layoutParams2.s = 0;
        int iK = k();
        ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
        int marginStart = iK - (layoutParams3 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams3).getMarginStart() : 0);
        ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = marginStart - (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).getMarginEnd() : 0);
        layoutParams2.k = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
        layoutParams2.Z = true;
        textView.setLayoutParams(layoutParams2);
    }
}
