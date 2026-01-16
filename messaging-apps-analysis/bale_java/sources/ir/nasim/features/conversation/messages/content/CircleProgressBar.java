package ir.nasim.features.conversation.messages.content;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.ED1;
import ir.nasim.ZU3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u000fJ\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u000fJ\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0011J\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u000fJ\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0011J\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u000fJ\u0017\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\n¢\u0006\u0004\b$\u0010\fJ\r\u0010%\u001a\u00020\n¢\u0006\u0004\b%\u0010\fJ\u0015\u0010&\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u000fR\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010(R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010*R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010*R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010*R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010*R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010<R\u0016\u0010E\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010<¨\u0006G"}, d2 = {"Lir/nasim/features/conversation/messages/content/CircleProgressBar;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "a", "()V", "width", "setStrokeWidth", "(I)V", "getStrokeWidth", "()I", "getColor", "color", "setColor", "setBgColor", "", "useRotation", "setUseRotation", "(Z)V", "getValue", "value", "setValue", "getMaxValue", "maxValue", "setMaxValue", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "b", "c", "setProgressWithoutAnimation", "Landroid/view/animation/Interpolator;", "Landroid/view/animation/Interpolator;", "progressInterpolator", TokenNames.I, "w", "d", "Z", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "paint", "f", "bgPaint", "g", "h", "", "i", "J", "lastValueChange", "", "j", TokenNames.F, "getRawValue", "()F", "setRawValue", "(F)V", "rawValue", "k", "startRawValue", "l", "endRawValue", "m", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class CircleProgressBar extends View {
    public static final int n = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private Interpolator progressInterpolator;

    /* renamed from: b, reason: from kotlin metadata */
    private int w;

    /* renamed from: c, reason: from kotlin metadata */
    private int color;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean useRotation;

    /* renamed from: e, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: f, reason: from kotlin metadata */
    private final Paint bgPaint;

    /* renamed from: g, reason: from kotlin metadata */
    private int maxValue;

    /* renamed from: h, reason: from kotlin metadata */
    private int value;

    /* renamed from: i, reason: from kotlin metadata */
    private long lastValueChange;

    /* renamed from: j, reason: from kotlin metadata */
    private float rawValue;

    /* renamed from: k, reason: from kotlin metadata */
    private float startRawValue;

    /* renamed from: l, reason: from kotlin metadata */
    private float endRawValue;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void a() {
        this.w = (int) (getResources().getDisplayMetrics().density * 3);
        Paint paint = this.paint;
        paint.setAntiAlias(true);
        paint.setColor(-12744461);
        paint.setStrokeWidth(this.w);
        Paint paint2 = this.bgPaint;
        paint2.setAntiAlias(true);
        paint2.setColor(-12744461);
        paint2.setStrokeWidth(this.w);
        paint2.setStyle(Paint.Style.STROKE);
    }

    public final void b() {
        this.useRotation = true;
        this.value = 1;
        invalidate();
    }

    public final void c() {
        this.useRotation = false;
        invalidate();
    }

    public final int getColor() {
        return this.color;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final float getRawValue() {
        return this.rawValue;
    }

    /* renamed from: getStrokeWidth, reason: from getter */
    public final int getW() {
        return this.w;
    }

    public final int getValue() {
        return this.value;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        AbstractC13042fc3.i(canvas, "canvas");
        int width = (getWidth() - (this.w * 4)) / 2;
        int width2 = getWidth() / 2;
        int height = getHeight() / 2;
        double dUptimeMillis = this.useRotation ? ((SystemClock.uptimeMillis() % 1600) * 6.283185307179586d) / 1600 : -1.5707963267948966d;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.lastValueChange;
        if (jUptimeMillis < 300) {
            float interpolation = this.progressInterpolator.getInterpolation(jUptimeMillis / 300.0f);
            float f = this.startRawValue;
            this.rawValue = f + ((this.endRawValue - f) * interpolation);
            z = true;
        } else {
            this.rawValue = this.endRawValue;
            z = false;
        }
        double d = this.rawValue * 2 * 3.141592653589793d;
        double d2 = width;
        float fCos = (float) (Math.cos(dUptimeMillis) * d2);
        float fSin = (float) (Math.sin(dUptimeMillis) * d2);
        double d3 = dUptimeMillis + d;
        boolean z2 = z;
        float fCos2 = (float) (Math.cos(d3) * d2);
        float fSin2 = (float) (Math.sin(d3) * d2);
        this.paint.setStyle(Paint.Style.FILL);
        float f2 = width2;
        float f3 = height;
        canvas.drawCircle(fCos + f2, fSin + f3, this.w >> 1, this.paint);
        canvas.drawCircle(fCos2 + f2, fSin2 + f3, this.w >> 1, this.paint);
        canvas.drawCircle(f2, f3, width, this.bgPaint);
        this.paint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(width2 - width, height - width, width2 + width, height + width);
        double d4 = SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
        canvas.drawArc(rectF, (float) ((dUptimeMillis * d4) / 3.141592653589793d), (float) ((d4 * d) / 3.141592653589793d), false, this.paint);
        if (z2 || this.useRotation) {
            postInvalidateOnAnimation();
        }
    }

    public final void setBgColor(int color) {
        this.bgPaint.setColor(color);
    }

    public final void setColor(int color) {
        this.color = color;
        this.paint.setColor(color);
    }

    public final void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        invalidate();
    }

    public final void setProgressWithoutAnimation(int value) {
        int iM = AbstractC23053wG5.m(value, 0, this.maxValue);
        this.value = iM;
        float f = iM / this.maxValue;
        this.rawValue = f;
        this.startRawValue = f;
        this.endRawValue = f;
        invalidate();
    }

    public final void setRawValue(float f) {
        this.rawValue = f;
    }

    public final void setStrokeWidth(int width) {
        this.w = width;
        float f = width;
        this.paint.setStrokeWidth(f);
        this.bgPaint.setStrokeWidth(f);
        invalidate();
    }

    public final void setUseRotation(boolean useRotation) {
        this.useRotation = useRotation;
    }

    public final void setValue(int value) {
        this.value = value;
        this.lastValueChange = SystemClock.uptimeMillis();
        this.startRawValue = this.rawValue;
        this.endRawValue = value / this.maxValue;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.progressInterpolator = new ZU3();
        this.color = -12744461;
        this.useRotation = true;
        this.paint = new Paint();
        this.bgPaint = new Paint();
        this.maxValue = 100;
        a();
    }
}
