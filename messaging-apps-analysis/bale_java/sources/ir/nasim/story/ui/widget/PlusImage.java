package ir.nasim.story.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14597iA5;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.OY0;
import ir.nasim.SA2;
import ir.nasim.story.ui.widget.PlusImage;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013¨\u0006\u001b"}, d2 = {"Lir/nasim/story/ui/widget/PlusImage;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", "Lir/nasim/rB7;", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Paint;", "a", "Lir/nasim/Yu3;", "getRingPaint", "()Landroid/graphics/Paint;", "ringPaint", "b", "getCirclePaint", "circlePaint", "c", "getPlusLinesPaint", "plusLinesPaint", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class PlusImage extends View {

    /* renamed from: a, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 ringPaint;

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 circlePaint;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 plusLinesPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlusImage(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint d(Context context) {
        AbstractC13042fc3.i(context, "$context");
        Paint paint = new Paint();
        paint.setColor(OY0.b(context, AbstractC14597iA5.colorPrimary));
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint e(Context context) {
        AbstractC13042fc3.i(context, "$context");
        Paint paint = new Paint();
        paint.setColor(OY0.b(context, AbstractC14597iA5.background));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth((int) ((AbstractC3742Cd6.c() * 1.5d) + 0.5d));
        return paint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint f(Context context) {
        AbstractC13042fc3.i(context, "$context");
        Paint paint = new Paint();
        paint.setColor(OY0.b(context, AbstractC14597iA5.background));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((int) ((AbstractC3742Cd6.c() * 2.3d) + 0.5d));
        return paint;
    }

    private final Paint getCirclePaint() {
        return (Paint) this.circlePaint.getValue();
    }

    private final Paint getPlusLinesPaint() {
        return (Paint) this.plusLinesPaint.getValue();
    }

    private final Paint getRingPaint() {
        return (Paint) this.ringPaint.getValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        canvas.drawCircle(width, height, width - getRingPaint().getStrokeWidth(), getCirclePaint());
        canvas.drawCircle(width, height, width - getRingPaint().getStrokeWidth(), getRingPaint());
        float width2 = getWidth() / 2.9f;
        float height2 = getHeight() / 2.9f;
        canvas.drawLine(width2, height, getWidth() - width2, height, getPlusLinesPaint());
        canvas.drawLine(width, height2, width, getHeight() - height2, getPlusLinesPaint());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlusImage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ PlusImage(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlusImage(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.ringPaint = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.sg5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return PlusImage.f(context);
            }
        });
        this.circlePaint = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.tg5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return PlusImage.d(context);
            }
        });
        this.plusLinesPaint = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ug5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return PlusImage.e(context);
            }
        });
    }
}
