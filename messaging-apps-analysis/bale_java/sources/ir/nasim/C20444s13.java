package ir.nasim;

import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.s13, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20444s13 extends C21569tl7 {
    private Integer i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20444s13(TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(textView, textView2, textView3, textView4);
        AbstractC13042fc3.i(textView, "reactions");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(textView3, "body");
        AbstractC13042fc3.i(textView4, "comment");
    }

    private final void D(StaticLayout staticLayout, float f, TextView textView, int i) {
        if (AbstractC21258tN7.e(staticLayout, f)) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = Math.min(Math.max((int) f, i), k());
            textView.setLayoutParams(layoutParams2);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = i;
        textView.setLayoutParams(layoutParams4);
    }

    public final int E(int i, int i2) {
        CharSequence text;
        CharSequence text2 = x().getText();
        int iIntValue = (((text2 != null && text2.length() != 0) || (text = j().getText()) == null || text.length() == 0) ? 0 : Float.valueOf(AbstractC21258tN7.d(j(), i).getLineWidth(0) + T73.e.a())).intValue();
        if (iIntValue == 0) {
            return 0;
        }
        TextView textViewJ = j();
        ViewGroup.LayoutParams layoutParams = textViewJ.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (iIntValue <= i2) {
            layoutParams2.Z = true;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        } else {
            layoutParams2.Z = false;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
        }
        textViewJ.setLayoutParams(layoutParams2);
        return iIntValue;
    }

    public final Integer F() {
        return this.i;
    }

    public final void G(Integer num) {
        this.i = num;
    }

    @Override // ir.nasim.T73
    public void t() {
        this.i = null;
    }

    @Override // ir.nasim.C21569tl7
    protected void w(TextView textView, StaticLayout staticLayout, TextView textView2, StaticLayout staticLayout2) {
        AbstractC13042fc3.i(textView, "body");
        AbstractC13042fc3.i(staticLayout, "bodyLayout");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(staticLayout2, "stateLayout");
        C(textView, textView2);
        float fA = (AbstractC21258tN7.a(textView, textView2, staticLayout, staticLayout2) - (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r0).getMarginStart() : 0)) - (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r0).getMarginEnd() : 0);
        Integer num = this.i;
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue < fA) {
                return;
            } else {
                D(staticLayout, fA, textView, iIntValue);
            }
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.j = j().getId();
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = AbstractC8943Xx1.c(4);
        textView.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.i = -1;
        textView2.setLayoutParams(layoutParams4);
    }
}
