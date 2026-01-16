package ir.nasim.gallery.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.TA5;
import ir.nasim.XV4;
import ir.nasim.XY6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001\u001bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&R\u0011\u0010+\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010*¨\u0006-"}, d2 = {"Lir/nasim/gallery/widget/GalleryCheckBox;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "c", "()V", "b", "", "num", "", "animated", "setNumber", "(Ljava/lang/Integer;Z)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "a", "Ljava/lang/String;", "number", "", TokenNames.F, "textWidth", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "e", "textPaint", "()Z", "isChecked", "f", "gallery_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class GalleryCheckBox extends View {
    private static final a f = new a(null);
    public static final int g = 8;
    private static final float h = AbstractC8943Xx1.c(2);
    private static final float i = AbstractC8943Xx1.c(12);
    private static final float j = AbstractC8943Xx1.c(6);
    private static final float k = AbstractC8943Xx1.a(16.2d);
    private static final float l = AbstractC8943Xx1.c(7);
    private static final float m = AbstractC8943Xx1.a(1.5d);
    private static final float n = AbstractC8943Xx1.c(24);

    /* renamed from: a, reason: from kotlin metadata */
    private String number;

    /* renamed from: b, reason: from kotlin metadata */
    private float textWidth;

    /* renamed from: c, reason: from kotlin metadata */
    private RectF rect;

    /* renamed from: d, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: e, reason: from kotlin metadata */
    private final Paint textPaint;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GalleryCheckBox(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        AbstractC13042fc3.i(context, "context");
    }

    private final void b() {
        float fMeasureText = this.textPaint.measureText(this.number);
        if (fMeasureText == this.textWidth) {
            return;
        }
        this.textWidth = fMeasureText;
        requestLayout();
    }

    private final void c() {
        if (AbstractC13042fc3.d(this.number, "")) {
            Paint paint = this.paint;
            paint.setColor(AbstractC4043Dl1.c(getContext(), TA5.color3_2));
            paint.setStyle(Paint.Style.STROKE);
        } else {
            Paint paint2 = this.paint;
            paint2.setColor(AbstractC4043Dl1.c(getContext(), TA5.secondary));
            paint2.setStyle(Paint.Style.FILL);
        }
    }

    public static /* synthetic */ void setNumber$default(GalleryCheckBox galleryCheckBox, Integer num, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        galleryCheckBox.setNumber(num, z);
    }

    public final boolean a() {
        return !AbstractC13042fc3.d(this.number, "");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        RectF rectF = this.rect;
        float f2 = j;
        canvas.drawRoundRect(rectF, f2, f2, this.paint);
        canvas.drawText(this.number, getPaddingLeft() + ((((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - this.textWidth) / 2.0f), getPaddingTop() + k, this.textPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        float f2 = n;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paddingLeft + ((int) Float.max(f2, this.textWidth + l)), 1073741824), View.MeasureSpec.makeMeasureSpec(getPaddingTop() + getPaddingBottom() + ((int) f2), 1073741824));
        float f3 = AbstractC13042fc3.d(this.number, "") ? h : 0.0f;
        this.rect.set(getPaddingLeft() + f3, getPaddingTop() + f3, (getMeasuredWidth() - f3) - getPaddingRight(), (getMeasuredHeight() - f3) - getPaddingBottom());
    }

    public final void setNumber(Integer num, boolean animated) {
        String strV;
        Float fValueOf;
        Float fValueOf2;
        String string;
        if (num == null || (string = num.toString()) == null || (strV = XY6.v(string)) == null) {
            strV = "";
        }
        this.number = strV;
        c();
        b();
        invalidate();
        if (animated) {
            if (num == null) {
                fValueOf = Float.valueOf(1.0f);
                fValueOf2 = Float.valueOf(1.1f);
            } else {
                fValueOf = Float.valueOf(1.1f);
                fValueOf2 = Float.valueOf(1.0f);
            }
            XV4 xv4A = AbstractC4616Fw7.a(fValueOf, fValueOf2);
            float fFloatValue = ((Number) xv4A.a()).floatValue();
            float fFloatValue2 = ((Number) xv4A.b()).floatValue();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<GalleryCheckBox, Float>) View.SCALE_X, fFloatValue, fFloatValue2), ObjectAnimator.ofFloat(this, (Property<GalleryCheckBox, Float>) View.SCALE_Y, fFloatValue, fFloatValue2));
            animatorSet.setInterpolator(new OvershootInterpolator());
            animatorSet.setDuration(180L);
            animatorSet.start();
        }
    }

    public /* synthetic */ GalleryCheckBox(Context context, AttributeSet attributeSet, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GalleryCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        this.number = "";
        this.rect = new RectF();
        Paint paint = new Paint(1);
        paint.setColor(AbstractC4043Dl1.c(context, TA5.secondary));
        paint.setStrokeWidth(m);
        this.paint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(AbstractC4043Dl1.c(context, TA5.color3_2));
        paint2.setTypeface(C6011Lu2.i());
        paint2.setTextSize(i);
        this.textPaint = paint2;
    }
}
