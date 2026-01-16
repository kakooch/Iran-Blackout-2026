package ir.nasim;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.iU4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14789iU4 {
    private static final void a(Rect rect, Rect rect2) {
        rect.right += rect2.width();
        rect.top = Math.min(rect.top, rect2.top);
        rect.bottom = Math.max(rect.bottom, rect2.bottom);
    }

    private static final void b(Paint paint, CharSequence charSequence, int i, int i2, Rect rect) {
        if (Build.VERSION.SDK_INT >= 29) {
            C12360eU4.a(paint, charSequence, i, i2, rect);
        } else {
            paint.getTextBounds(charSequence.toString(), i, i2, rect);
        }
    }

    public static final Rect c(TextPaint textPaint, CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (AbstractC18227oI6.b(spanned, MetricAffectingSpan.class, i, i2)) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i < i2) {
                    int iNextSpanTransition = spanned.nextSpanTransition(i, i2, MetricAffectingSpan.class);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i, iNextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    b(textPaint2, charSequence, i, iNextSpanTransition, rect2);
                    a(rect, rect2);
                    i = iNextSpanTransition;
                }
                return rect;
            }
        }
        return d(textPaint, charSequence, i, i2);
    }

    public static final Rect d(Paint paint, CharSequence charSequence, int i, int i2) {
        Rect rect = new Rect();
        b(paint, charSequence, i, i2, rect);
        return rect;
    }
}
