package io.sentry.android.replay.util;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;

/* loaded from: classes3.dex */
public final class a implements o {
    private final Layout a;

    public a(Layout layout) {
        AbstractC13042fc3.i(layout, "layout");
        this.a = layout;
    }

    @Override // io.sentry.android.replay.util.o
    public int a(int i) {
        return this.a.getLineTop(i);
    }

    @Override // io.sentry.android.replay.util.o
    public int b(int i) {
        return this.a.getLineStart(i);
    }

    @Override // io.sentry.android.replay.util.o
    public int d(int i) {
        return this.a.getLineBottom(i);
    }

    @Override // io.sentry.android.replay.util.o
    public float e(int i, int i2) {
        return this.a.getPrimaryHorizontal(i2);
    }

    @Override // io.sentry.android.replay.util.o
    public Integer f() {
        int i;
        if (!(this.a.getText() instanceof Spanned)) {
            return null;
        }
        CharSequence text = this.a.getText();
        AbstractC13042fc3.g(text, "null cannot be cast to non-null type android.text.Spanned");
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) ((Spanned) text).getSpans(0, this.a.getText().length(), ForegroundColorSpan.class);
        AbstractC13042fc3.h(foregroundColorSpanArr, "spans");
        int i2 = RecyclerView.UNDEFINED_DURATION;
        Integer numValueOf = null;
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            CharSequence text2 = this.a.getText();
            AbstractC13042fc3.g(text2, "null cannot be cast to non-null type android.text.Spanned");
            int spanStart = ((Spanned) text2).getSpanStart(foregroundColorSpan);
            CharSequence text3 = this.a.getText();
            AbstractC13042fc3.g(text3, "null cannot be cast to non-null type android.text.Spanned");
            int spanEnd = ((Spanned) text3).getSpanEnd(foregroundColorSpan);
            if (spanStart != -1 && spanEnd != -1 && (i = spanEnd - spanStart) > i2) {
                numValueOf = Integer.valueOf(foregroundColorSpan.getForegroundColor());
                i2 = i;
            }
        }
        if (numValueOf != null) {
            return Integer.valueOf(p.j(numValueOf.intValue()));
        }
        return null;
    }

    @Override // io.sentry.android.replay.util.o
    public int g(int i) {
        return this.a.getLineVisibleEnd(i);
    }

    @Override // io.sentry.android.replay.util.o
    public int getLineCount() {
        return this.a.getLineCount();
    }

    @Override // io.sentry.android.replay.util.o
    public int h(int i) {
        return this.a.getEllipsisCount(i);
    }
}
