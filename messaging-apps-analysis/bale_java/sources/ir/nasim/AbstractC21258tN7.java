package ir.nasim;

import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;

/* renamed from: ir.nasim.tN7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC21258tN7 {
    public static final float a(TextView textView, TextView textView2, StaticLayout staticLayout, StaticLayout staticLayout2) {
        AbstractC13042fc3.i(textView, "firstView");
        AbstractC13042fc3.i(textView2, "secondView");
        AbstractC13042fc3.i(staticLayout, "firstLayout");
        AbstractC13042fc3.i(staticLayout2, "secondLayout");
        return staticLayout.getLineWidth(staticLayout.getLineCount() - 1) + (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r1).getMarginStart() : 0) + (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r3).getMarginEnd() : 0) + staticLayout2.getLineWidth(0) + (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r3).getMarginEnd() : 0) + (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r3).getMarginStart() : 0);
    }

    public static final float b(TextView textView, TextView textView2, StaticLayout staticLayout, StaticLayout staticLayout2) {
        AbstractC13042fc3.i(textView, "firstView");
        AbstractC13042fc3.i(textView2, "secondView");
        AbstractC13042fc3.i(staticLayout, "firstLayout");
        AbstractC13042fc3.i(staticLayout2, "secondLayout");
        float lineWidth = staticLayout2.getLineWidth(0);
        int lineCount = staticLayout.getLineCount();
        float lineWidth2 = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            if (staticLayout.getLineWidth(i) > lineWidth2) {
                lineWidth2 = staticLayout.getLineWidth(i);
            }
        }
        return lineWidth2 + (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r7).getMarginStart() : 0) + (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r5).getMarginEnd() : 0) + lineWidth + (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r5).getMarginEnd() : 0) + (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r5).getMarginStart() : 0);
    }

    public static final boolean c(TextView textView, TextView textView2, StaticLayout staticLayout, StaticLayout staticLayout2, int i) {
        AbstractC13042fc3.i(textView, "firstView");
        AbstractC13042fc3.i(textView2, "secondView");
        AbstractC13042fc3.i(staticLayout, "firstLayout");
        AbstractC13042fc3.i(staticLayout2, "secondLayout");
        return staticLayout2.getLineCount() <= 1 && a(textView, textView2, staticLayout, staticLayout2) < ((float) i);
    }

    public static final StaticLayout d(TextView textView, int i) {
        AbstractC13042fc3.i(textView, "<this>");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        int marginStart = i - (layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart() : 0);
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(textView.getText(), 0, textView.getText().length(), textView.getPaint(), marginStart - (layoutParams2 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams2).getMarginEnd() : 0)).build();
        AbstractC13042fc3.h(staticLayoutBuild, "build(...)");
        return staticLayoutBuild;
    }

    public static final boolean e(StaticLayout staticLayout, float f) {
        AbstractC13042fc3.i(staticLayout, "firstLayout");
        int lineCount = staticLayout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (staticLayout.getLineWidth(i) > f) {
                return false;
            }
        }
        return true;
    }
}
