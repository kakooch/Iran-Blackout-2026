package ir.nasim;

import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.tl7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21569tl7 extends T73 {
    private final TextView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C21569tl7(TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(textView, textView2, textView4);
        AbstractC13042fc3.i(textView, "reactions");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(textView3, "body");
        AbstractC13042fc3.i(textView4, "comment");
        this.h = textView3;
    }

    private final boolean A(StaticLayout staticLayout) {
        int paragraphDirection = staticLayout.getParagraphDirection(staticLayout.getLineCount() - 1);
        int lineCount = staticLayout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (paragraphDirection != staticLayout.getParagraphDirection(i)) {
                return true;
            }
        }
        return false;
    }

    private final boolean B(StaticLayout staticLayout) {
        return JF5.g() == (staticLayout.getParagraphDirection(staticLayout.getLineCount() - 1) == -1);
    }

    private final void v(TextView textView, TextView textView2) {
        CharSequence text = textView.getText();
        CharSequence text2 = textView2.getText();
        if (text == null || text.length() == 0 || text2 == null || text2.length() == 0) {
            C(this.h, n());
            return;
        }
        StaticLayout staticLayoutD = AbstractC21258tN7.d(textView, k());
        StaticLayout staticLayoutD2 = AbstractC21258tN7.d(textView2, k());
        Float fValueOf = j().getVisibility() == 0 ? Float.valueOf(AbstractC21258tN7.d(j(), k()).getLineWidth(0)) : null;
        if (!AbstractC21258tN7.c(textView, textView2, staticLayoutD, staticLayoutD2, k())) {
            c(fValueOf, staticLayoutD);
            C(textView, textView2);
        } else {
            if (staticLayoutD.getLineCount() <= 1) {
                b(textView, textView2);
                d(textView, textView2, staticLayoutD, staticLayoutD2, fValueOf);
                return;
            }
            c(fValueOf, staticLayoutD);
            if (B(staticLayoutD)) {
                w(textView, staticLayoutD, textView2, staticLayoutD2);
            } else {
                C(textView, textView2);
            }
        }
    }

    private final void z(TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        o(textView2, textView3, textView4);
        y(textView);
    }

    protected void C(TextView textView, TextView textView2) {
        AbstractC13042fc3.i(textView, "bodyView");
        AbstractC13042fc3.i(textView2, "stateView");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.j = -1;
        layoutParams2.k = -1;
        textView.setLayoutParams(layoutParams2);
        TextView textViewJ = j();
        ViewGroup.LayoutParams layoutParams3 = textViewJ.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.i = -1;
        textViewJ.setLayoutParams(layoutParams4);
    }

    @Override // ir.nasim.T73
    public void r() {
        z(this.h, m(), n(), j());
        CharSequence text = m().getText();
        if (text == null || text.length() == 0) {
            v(this.h, n());
        } else {
            C(this.h, n());
            f(m(), n(), this.h);
        }
    }

    protected void w(TextView textView, StaticLayout staticLayout, TextView textView2, StaticLayout staticLayout2) {
        AbstractC13042fc3.i(textView, "body");
        AbstractC13042fc3.i(staticLayout, "bodyLayout");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(staticLayout2, "stateLayout");
        if (A(staticLayout)) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int iK = k();
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            int marginStart = iK - (layoutParams3 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams3).getMarginStart() : 0);
            ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = marginStart - (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).getMarginEnd() : 0);
            layoutParams2.Z = false;
            textView.setLayoutParams(layoutParams2);
        } else {
            float fA = (AbstractC21258tN7.a(textView, textView2, staticLayout, staticLayout2) - (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r0).getMarginStart() : 0)) - (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r0).getMarginEnd() : 0);
            if (AbstractC21258tN7.e(staticLayout, fA)) {
                ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
                if (layoutParams5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                ((ViewGroup.MarginLayoutParams) layoutParams6).width = Math.min((int) fA, k());
                textView.setLayoutParams(layoutParams6);
            }
        }
        ViewGroup.LayoutParams layoutParams7 = textView.getLayoutParams();
        if (layoutParams7 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
        layoutParams8.j = j().getId();
        ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = AbstractC8943Xx1.c(4);
        textView.setLayoutParams(layoutParams8);
        ViewGroup.LayoutParams layoutParams9 = textView2.getLayoutParams();
        if (layoutParams9 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) layoutParams9;
        layoutParams10.i = -1;
        textView2.setLayoutParams(layoutParams10);
    }

    protected final TextView x() {
        return this.h;
    }

    protected void y(TextView textView) {
        int marginEnd;
        AbstractC13042fc3.i(textView, "textViewBody");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.u = 0;
        layoutParams2.t = -1;
        layoutParams2.k = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
        layoutParams2.Z = true;
        if (A(AbstractC21258tN7.d(textView, k()))) {
            int iK = k();
            ViewGroup.LayoutParams layoutParams3 = this.h.getLayoutParams();
            int marginStart = iK - (layoutParams3 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams3).getMarginStart() : 0);
            ViewGroup.LayoutParams layoutParams4 = this.h.getLayoutParams();
            marginEnd = marginStart - (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).getMarginEnd() : 0);
        } else {
            marginEnd = -2;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = marginEnd;
        textView.setLayoutParams(layoutParams2);
    }
}
