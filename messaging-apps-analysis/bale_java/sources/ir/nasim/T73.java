package ir.nasim;

import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes5.dex */
public class T73 {
    public static final a e = new a(null);
    public static final int f = 8;
    private static final int g = AbstractC8943Xx1.c(24);
    private final TextView a;
    private final TextView b;
    private final TextView c;
    private int d;

    public static final class a {
        private a() {
        }

        public final int a() {
            return T73.g;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public T73(TextView textView, TextView textView2, TextView textView3) {
        AbstractC13042fc3.i(textView, "reactions");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(textView3, "comment");
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    private final void e(TextView textView, StaticLayout staticLayout, TextView textView2, TextView textView3, StaticLayout staticLayout2, Float f2) {
        XV4 xv4L = l(textView, staticLayout, textView2);
        TextView textView4 = (TextView) xv4L.a();
        d(textView4 == null ? textView : textView4, textView3, (StaticLayout) xv4L.b(), staticLayout2, f2);
    }

    public static /* synthetic */ void g(T73 t73, TextView textView, TextView textView2, TextView textView3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignReactionAndStateView");
        }
        if ((i & 4) != 0) {
            textView3 = null;
        }
        t73.f(textView, textView2, textView3);
    }

    private final void i(TextView textView, TextView textView2, StaticLayout staticLayout, StaticLayout staticLayout2) {
        float fA = AbstractC21258tN7.a(textView, textView2, staticLayout, staticLayout2);
        if (AbstractC21258tN7.e(staticLayout, fA)) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) fA;
            textView.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.i = -1;
        textView2.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.c.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams6 = layoutParams5 instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams5 : null;
        if (layoutParams6 != null) {
            layoutParams6.i = textView.getId();
            this.c.setLayoutParams(layoutParams6);
        }
    }

    private final XV4 l(TextView textView, StaticLayout staticLayout, TextView textView2) {
        float lineWidth = staticLayout.getLineWidth(0);
        if (textView2 != null) {
            StaticLayout staticLayoutD = AbstractC21258tN7.d(textView2, this.d);
            int lineCount = staticLayoutD.getLineCount();
            float lineWidth2 = 0.0f;
            for (int i = 0; i < lineCount; i++) {
                if (staticLayoutD.getLineWidth(i) > lineWidth2) {
                    lineWidth2 = staticLayoutD.getLineWidth(i);
                }
            }
            if (lineWidth2 > lineWidth) {
                textView = textView2;
                staticLayout = staticLayoutD;
            }
            textView2 = textView;
        }
        return AbstractC4616Fw7.a(textView2, staticLayout);
    }

    public final void b(TextView textView, TextView textView2) {
        AbstractC13042fc3.i(textView, "bodyView");
        AbstractC13042fc3.i(textView2, "stateView");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.u = -1;
        layoutParams2.t = textView2.getId();
        layoutParams2.Z = false;
        layoutParams2.j = this.c.getId();
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

    public final void c(Float f2, StaticLayout staticLayout) {
        AbstractC13042fc3.i(staticLayout, "mainLayout");
        if (f2 != null) {
            float fFloatValue = f2.floatValue();
            TextView textView = this.c;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int lineCount = staticLayout.getLineCount();
            int i = 0;
            while (true) {
                if (i >= lineCount) {
                    layoutParams2.Z = false;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
                    break;
                } else {
                    if (staticLayout.getLineWidth(i) > g + fFloatValue) {
                        layoutParams2.Z = true;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                        break;
                    }
                    i++;
                }
            }
            textView.setLayoutParams(layoutParams2);
        }
    }

    protected final void d(TextView textView, TextView textView2, StaticLayout staticLayout, StaticLayout staticLayout2, Float f2) {
        AbstractC13042fc3.i(textView, "first");
        AbstractC13042fc3.i(textView2, "second");
        AbstractC13042fc3.i(staticLayout, "firstLayout");
        AbstractC13042fc3.i(staticLayout2, "secondLayout");
        float fB = AbstractC21258tN7.b(textView, textView2, staticLayout, staticLayout2);
        if (f2 != null) {
            TextView textView3 = this.c;
            ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (fB > f2.floatValue() + g) {
                layoutParams2.Z = true;
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
            } else {
                layoutParams2.Z = false;
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
            }
            textView3.setLayoutParams(layoutParams2);
        }
    }

    protected final void f(TextView textView, TextView textView2, TextView textView3) {
        AbstractC13042fc3.i(textView, "reaction");
        AbstractC13042fc3.i(textView2, "state");
        CharSequence text = textView.getText();
        CharSequence text2 = textView2.getText();
        if (text == null || text.length() == 0 || text2 == null || text2.length() == 0) {
            return;
        }
        StaticLayout staticLayoutD = AbstractC21258tN7.d(textView, this.d);
        StaticLayout staticLayoutD2 = AbstractC21258tN7.d(textView2, this.d);
        Float fValueOf = this.c.getVisibility() == 0 ? Float.valueOf(AbstractC21258tN7.d(this.c, this.d).getLineWidth(0)) : null;
        if (!AbstractC21258tN7.c(textView, textView2, staticLayoutD, staticLayoutD2, this.d)) {
            c(fValueOf, (StaticLayout) l(textView, staticLayoutD, textView3).f());
        } else if (staticLayoutD.getLineCount() <= 1) {
            h(textView, textView2, staticLayoutD, staticLayoutD2);
            e(textView, staticLayoutD, textView3, textView2, staticLayoutD2, fValueOf);
        } else {
            c(fValueOf, (StaticLayout) l(textView, staticLayoutD, textView3).f());
            i(textView, textView2, staticLayoutD, staticLayoutD2);
        }
    }

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
        layoutParams2.u = -1;
        layoutParams2.t = textView2.getId();
        layoutParams2.Z = false;
        layoutParams2.j = this.c.getId();
        textView.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.i = -1;
        textView2.setLayoutParams(layoutParams4);
    }

    protected final TextView j() {
        return this.c;
    }

    public final int k() {
        return this.d;
    }

    protected final TextView m() {
        return this.a;
    }

    protected final TextView n() {
        return this.b;
    }

    protected void o(TextView textView, TextView textView2, TextView textView3) {
        AbstractC13042fc3.i(textView, "reactions");
        AbstractC13042fc3.i(textView2, "state");
        AbstractC13042fc3.i(textView3, "comment");
        p(textView);
        q(textView2, textView, textView3);
    }

    protected void p(TextView textView) {
        AbstractC13042fc3.i(textView, "textViewReactions");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.u = 0;
        layoutParams2.t = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
        layoutParams2.Z = true;
        textView.setLayoutParams(layoutParams2);
    }

    protected void q(TextView textView, TextView textView2, TextView textView3) {
        AbstractC13042fc3.i(textView, "stateView");
        AbstractC13042fc3.i(textView2, "textViewReactions");
        AbstractC13042fc3.i(textView3, "comment");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.i = textView2.getId();
        if (textView3.getVisibility() == 0) {
            layoutParams2.j = textView3.getId();
        }
        textView.setLayoutParams(layoutParams2);
    }

    public void r() {
        o(this.a, this.b, this.c);
        g(this, this.a, this.b, null, 4, null);
    }

    public final void s(int i) {
        this.d = i;
    }

    public void t() {
        this.d = 0;
    }

    public final void u() {
        TextView textView = this.c;
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.Z = true;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        textView.setLayoutParams(layoutParams2);
    }

    public /* synthetic */ T73(TextView textView, TextView textView2, TextView textView3, int i, ED1 ed1) {
        if ((i & 4) != 0) {
            textView3 = new TextView(textView.getContext());
            textView3.setVisibility(8);
        }
        this(textView, textView2, textView3);
    }
}
