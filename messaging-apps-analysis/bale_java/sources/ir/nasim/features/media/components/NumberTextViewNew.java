package ir.nasim.features.media.components;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C22078ud6;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR$\u0010'\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&R$\u0010*\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010&¨\u0006+"}, d2 = {"Lir/nasim/features/media/components/NumberTextViewNew;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/Canvas;", "canvas", "Lir/nasim/rB7;", "onDraw", "(Landroid/graphics/Canvas;)V", "Ljava/util/ArrayList;", "Landroid/text/StaticLayout;", "a", "Ljava/util/ArrayList;", "letters", "b", "oldLetters", "Landroid/text/TextPaint;", "c", "Landroid/text/TextPaint;", "textPaint", "", "d", TokenNames.F, "progress", "", "e", "Z", "addNumber", "f", "center", "value", "g", "getTextWidth", "()F", "textWidth", "h", "getOldTextWidth", "oldTextWidth", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class NumberTextViewNew extends View {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final ArrayList letters;

    /* renamed from: b, reason: from kotlin metadata */
    private final ArrayList oldLetters;

    /* renamed from: c, reason: from kotlin metadata */
    private final TextPaint textPaint;

    /* renamed from: d, reason: from kotlin metadata */
    private float progress;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean addNumber;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean center;

    /* renamed from: g, reason: from kotlin metadata */
    private float textWidth;

    /* renamed from: h, reason: from kotlin metadata */
    private float oldTextWidth;

    public NumberTextViewNew(Context context) {
        super(context);
        this.letters = new ArrayList();
        this.oldLetters = new ArrayList();
        this.textPaint = new TextPaint(1);
    }

    public final float getOldTextWidth() {
        return this.oldTextWidth;
    }

    public final float getTextWidth() {
        return this.textWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float measuredWidth;
        float lineWidth;
        float lineWidth2;
        AbstractC13042fc3.i(canvas, "canvas");
        if (this.letters.isEmpty()) {
            return;
        }
        Object obj = this.letters.get(0);
        AbstractC13042fc3.f(obj);
        float height = ((StaticLayout) obj).getHeight();
        float fA = this.addNumber ? C22078ud6.a(4.0f) : height;
        if (this.center) {
            measuredWidth = (getMeasuredWidth() - this.textWidth) / 2.0f;
            lineWidth = ((getMeasuredWidth() - this.oldTextWidth) / 2.0f) - measuredWidth;
        } else {
            measuredWidth = 0.0f;
            lineWidth = 0.0f;
        }
        canvas.save();
        canvas.translate(getPaddingLeft() + measuredWidth, (getMeasuredHeight() - height) / 2);
        int iMax = Math.max(this.letters.size(), this.oldLetters.size());
        int i = 0;
        while (i < iMax) {
            canvas.save();
            StaticLayout staticLayout = i < this.oldLetters.size() ? (StaticLayout) this.oldLetters.get(i) : null;
            StaticLayout staticLayout2 = i < this.letters.size() ? (StaticLayout) this.letters.get(i) : null;
            float f = this.progress;
            if (f > 0.0f) {
                if (staticLayout != null) {
                    float f2 = 255;
                    this.textPaint.setAlpha((int) (f * f2));
                    canvas.save();
                    canvas.translate(lineWidth, (this.progress - 1.0f) * fA);
                    staticLayout.draw(canvas);
                    canvas.restore();
                    if (staticLayout2 != null) {
                        this.textPaint.setAlpha((int) (f2 * (1.0f - this.progress)));
                        canvas.translate(0.0f, this.progress * fA);
                    }
                } else {
                    this.textPaint.setAlpha(255);
                }
            } else if (f < 0.0f) {
                if (staticLayout != null) {
                    this.textPaint.setAlpha((int) (255 * (-f)));
                    canvas.save();
                    canvas.translate(lineWidth, (this.progress + 1.0f) * fA);
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
                if (staticLayout2 != null) {
                    if (i == iMax - 1 || staticLayout != null) {
                        this.textPaint.setAlpha((int) (255 * (this.progress + 1.0f)));
                        canvas.translate(0.0f, this.progress * fA);
                    } else {
                        this.textPaint.setAlpha(255);
                    }
                }
            } else if (staticLayout2 != null) {
                this.textPaint.setAlpha(255);
            }
            if (staticLayout2 != null) {
                staticLayout2.draw(canvas);
            }
            canvas.restore();
            if (staticLayout2 != null) {
                lineWidth2 = staticLayout2.getLineWidth(0);
            } else {
                AbstractC13042fc3.f(staticLayout);
                lineWidth2 = staticLayout.getLineWidth(0) + C22078ud6.a(1.0f);
            }
            canvas.translate(lineWidth2, 0.0f);
            if (staticLayout2 != null && staticLayout != null) {
                lineWidth += staticLayout.getLineWidth(0) - staticLayout2.getLineWidth(0);
            }
            i++;
        }
        canvas.restore();
    }

    public NumberTextViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.letters = new ArrayList();
        this.oldLetters = new ArrayList();
        this.textPaint = new TextPaint(1);
    }
}
