package ir.nasim.components.badges.view;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15199jA5;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.OY0;
import ir.nasim.SA2;
import ir.nasim.components.badges.view.CounterBadge;
import java.text.NumberFormat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0012\u001a\u00020\u0011*\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J;\u0010\u0017\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u00112\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010!\u001a\u00020\u00112\b\b\u0003\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\fH\u0016¢\u0006\u0004\b(\u0010)R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010,R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010+R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010.R\u0014\u0010/\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010+R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R#\u0010B\u001a\n =*\u0004\u0018\u00010<0<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lir/nasim/components/badges/view/CounterBadge;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "()I", "Landroid/graphics/Canvas;", "left", "top", "right", "bottom", "Lir/nasim/rB7;", "b", "(Landroid/graphics/Canvas;IIII)V", "c", "", ParameterNames.TEXT, "d", "(Landroid/graphics/Canvas;Ljava/lang/String;IIII)V", "count", "", "animated", "setCount", "(IZ)V", "strokeColor", "", "strokeWidth", "setupStroke", "(IF)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "a", TokenNames.I, "Ljava/lang/String;", "countString", TokenNames.F, "backgroundColor", "Landroid/graphics/RectF;", "f", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/Paint;", "g", "Landroid/graphics/Paint;", "paint", "Landroid/text/TextPaint;", "h", "Landroid/text/TextPaint;", "textPaint", "Ljava/text/NumberFormat;", "kotlin.jvm.PlatformType", "i", "Lir/nasim/Yu3;", "getNumberFormat", "()Ljava/text/NumberFormat;", "numberFormat", "j", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class CounterBadge extends View {
    private static final a j;
    public static final int k;
    private static final int l;
    private static final int m;
    private static final float n;
    private static final float o;

    /* renamed from: a, reason: from kotlin metadata */
    private int count;

    /* renamed from: b, reason: from kotlin metadata */
    private String countString;

    /* renamed from: c, reason: from kotlin metadata */
    private int strokeColor;

    /* renamed from: d, reason: from kotlin metadata */
    private float strokeWidth;

    /* renamed from: e, reason: from kotlin metadata */
    private final int backgroundColor;

    /* renamed from: f, reason: from kotlin metadata */
    private final RectF rect;

    /* renamed from: g, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: h, reason: from kotlin metadata */
    private final TextPaint textPaint;

    /* renamed from: i, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 numberFormat;

    private static final class a {
        private a() {
        }

        public final int a(Number number) {
            AbstractC13042fc3.i(number, "<this>");
            return (int) ((number.doubleValue() * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        j = aVar;
        k = 8;
        l = aVar.a(24);
        m = aVar.a(9);
        n = aVar.a(Double.valueOf(16.2d));
        o = aVar.a(15);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CounterBadge(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void b(Canvas canvas, int i, int i2, int i3, int i4) {
        Paint paint = this.paint;
        paint.setColor(this.backgroundColor);
        paint.setStyle(Paint.Style.FILL);
        RectF rectF = this.rect;
        float f = this.strokeWidth;
        rectF.set(i + f, i2 + f, i3 - f, i4 - f);
        RectF rectF2 = this.rect;
        float f2 = o;
        canvas.drawRoundRect(rectF2, f2, f2, this.paint);
    }

    private final void c(Canvas canvas, int i, int i2, int i3, int i4) {
        if (this.strokeWidth <= 0.0f) {
            return;
        }
        Paint paint = this.paint;
        paint.setColor(this.strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.strokeWidth);
        float fCeil = (float) Math.ceil(this.strokeWidth / 2);
        this.rect.set(i + fCeil, i2 + fCeil, i3 - fCeil, i4 - fCeil);
        RectF rectF = this.rect;
        float f = o;
        canvas.drawRoundRect(rectF, f, f, this.paint);
    }

    private final void d(Canvas canvas, String str, int i, int i2, int i3, int i4) {
        float f = i2 + n;
        float fMeasureText = this.textPaint.measureText(str);
        TextPaint textPaint = this.textPaint;
        int i5 = textPaint.baselineShift;
        canvas.drawText(str, ((i + i3) / 2) - (fMeasureText / 2), f, textPaint);
    }

    private final int e() {
        return Math.max(AbstractC20723sV3.d(this.textPaint.measureText(this.countString) + (this.strokeWidth * 2) + m + getPaddingStart() + getPaddingEnd()), l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NumberFormat f() {
        return NumberFormat.getInstance();
    }

    private final NumberFormat getNumberFormat() {
        return (NumberFormat) this.numberFormat.getValue();
    }

    public static /* synthetic */ void setCount$default(CounterBadge counterBadge, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        counterBadge.setCount(i, z);
    }

    public static /* synthetic */ void setupStroke$default(CounterBadge counterBadge, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = counterBadge.strokeColor;
        }
        if ((i2 & 2) != 0) {
            f = counterBadge.strokeWidth;
        }
        counterBadge.setupStroke(i, f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        super.draw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int measuredHeight = getMeasuredHeight() - getPaddingBottom();
        b(canvas, paddingLeft, paddingTop, measuredWidth, measuredHeight);
        c(canvas, paddingLeft, paddingTop, measuredWidth, measuredHeight);
        d(canvas, this.countString, paddingLeft, paddingTop, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(widthMeasureSpec), e()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(heightMeasureSpec), l), 1073741824));
    }

    public final void setCount(int count, boolean animated) {
        int iE = AbstractC23053wG5.e(count, 0);
        int i = this.count;
        if (iE == i) {
            return;
        }
        boolean z = iE > i;
        this.count = iE;
        this.countString = getNumberFormat().format(Integer.valueOf(count));
        if (getMeasuredWidth() != e()) {
            requestLayout();
        }
        setVisibility(iE > 0 ? 0 : 8);
        invalidate();
        if (animated && getVisibility() == 0) {
            float f = z ? 0.9f : 1.1f;
            setScaleX(f);
            setScaleY(f);
            animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new OvershootInterpolator()).setDuration(180L);
        }
    }

    public final void setupStroke(int strokeColor, float strokeWidth) {
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CounterBadge(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ CounterBadge(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CounterBadge(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.countString = "";
        Context context2 = getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        this.backgroundColor = OY0.b(context2, AbstractC15199jA5.colorPrimary);
        this.rect = new RectF();
        this.paint = new Paint(1);
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(j.a(12));
        textPaint.setTypeface(C6011Lu2.k());
        Context context3 = getContext();
        AbstractC13042fc3.h(context3, "getContext(...)");
        textPaint.setColor(OY0.b(context3, AbstractC15199jA5.colorOnPrimary));
        this.textPaint = textPaint;
        this.numberFormat = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Xo1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return CounterBadge.f();
            }
        });
        setCount$default(this, this.count, false, 2, null);
    }
}
