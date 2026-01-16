package ir.nasim;

import android.text.Spannable;
import android.text.StaticLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.Pu5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6981Pu5 extends AbstractC22597vW1 {
    private final BubbleTextView a;

    public AbstractC6981Pu5(BubbleTextView bubbleTextView) {
        AbstractC13042fc3.i(bubbleTextView, "progressTextView");
        this.a = bubbleTextView;
    }

    public abstract Spannable v(float f);

    public final float w(float f) {
        Spannable spannableV = v(f);
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(spannableV, 0, spannableV.length(), this.a.getPaint(), AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND).build();
        AbstractC13042fc3.h(staticLayoutBuild, "build(...)");
        return staticLayoutBuild.getLineWidth(0);
    }

    protected final BubbleTextView x() {
        return this.a;
    }
}
