package ir.nasim;

import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.bI3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10228bI3 {
    private final boolean a;
    private final int b;
    private int c;

    public C10228bI3(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    private final boolean a(TextView textView, TextView textView2, StaticLayout staticLayout, StaticLayout staticLayout2) {
        return staticLayout2.getLineCount() <= 1 && AbstractC21258tN7.a(textView, textView2, staticLayout, staticLayout2) < ((float) this.c);
    }

    private final void c(TextView textView) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
        layoutParams2.setMarginEnd(AbstractC8943Xx1.c(this.a ? 10 : 4));
        layoutParams2.k = 0;
        textView.setLayoutParams(layoutParams2);
    }

    private final void d(TextView textView, TextView textView2) {
        CharSequence text = textView.getText();
        if (text == null || AbstractC20762sZ6.n0(text)) {
            e(textView2);
        } else if (a(textView, textView2, AbstractC21258tN7.d(textView, this.c), AbstractC21258tN7.d(textView2, this.c))) {
            c(textView2);
        } else {
            e(textView2);
        }
    }

    private final void e(TextView textView) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int iC = AbstractC8943Xx1.c(4);
        layoutParams2.setMargins(iC, iC, iC, iC);
        layoutParams2.k = this.b;
        textView.setLayoutParams(layoutParams2);
    }

    public final void b(TextView textView, TextView textView2) {
        AbstractC13042fc3.i(textView, "textViewReactions");
        AbstractC13042fc3.i(textView2, "textViewState");
        d(textView, textView2);
    }

    public final void f(int i) {
        this.c = i;
    }
}
