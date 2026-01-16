package com.genius.multiprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.genius.multiprogressbar.MultiProgressBar;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC3879Ct;
import ir.nasim.C4328Eq7;
import ir.nasim.CE5;
import ir.nasim.ED1;
import ir.nasim.InterfaceC25191zt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 {2\u00020\u0001:\u0004GJ\u0016\u0014B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u00020\u000b*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u000b*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b!\u0010\"J/\u0010&\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(H\u0014¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0006¢\u0006\u0004\b5\u0010\u0010J\r\u00106\u001a\u00020\u0006¢\u0006\u0004\b6\u00107J\u001b\u00108\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b8\u0010\rJ\r\u00109\u001a\u00020\u000b¢\u0006\u0004\b9\u0010\u001cJ\r\u0010:\u001a\u00020\u000b¢\u0006\u0004\b:\u0010\u001cJ\r\u0010;\u001a\u00020\u000b¢\u0006\u0004\b;\u0010\u001cJ\r\u0010<\u001a\u00020\u000b¢\u0006\u0004\b<\u0010\u001cJ\r\u0010=\u001a\u00020\u0006¢\u0006\u0004\b=\u00107J\u0017\u0010?\u001a\u00020\u000b2\b\b\u0001\u0010>\u001a\u00020\u0006¢\u0006\u0004\b?\u0010\u0010J\r\u0010@\u001a\u00020\u0006¢\u0006\u0004\b@\u00107J\u0017\u0010C\u001a\u00020\u000b2\b\b\u0001\u0010B\u001a\u00020A¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020A¢\u0006\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010KR\u0016\u0010O\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010NR\u0016\u0010P\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010NR\u0016\u0010R\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010NR\u0016\u0010S\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010KR\u0016\u0010U\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010TR\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010NR\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010>\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010KR\u0016\u0010[\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010NR\u0016\u0010\\\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010NR\u0016\u0010]\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010TR\u0016\u0010_\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010KR\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010TR0\u0010j\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\bf\u0010K\u0012\u0004\bi\u0010\u001c\u001a\u0004\bg\u00107\"\u0004\bh\u0010\u0010R\u0014\u0010l\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u00107R\u0014\u0010n\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u00107R\u0014\u0010p\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u00107R\u0014\u0010r\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bq\u00107R\u0014\u0010t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bs\u00107R\u0014\u0010v\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bu\u00107R\u0018\u0010x\u001a\u00020A*\u00020A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010wR\u0011\u0010z\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bY\u0010y¨\u0006|"}, d2 = {"Lcom/genius/multiprogressbar/MultiProgressBar;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fromPosition", "Lir/nasim/rB7;", "h", "(Ljava/lang/Integer;)V", "count", "g", "(I)V", "Landroid/graphics/Paint;", "", "isCompactMode", "d", "(Landroid/graphics/Paint;Z)V", "c", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "onDetachedFromWindow", "()V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Lcom/genius/multiprogressbar/MultiProgressBar$d;", "stepChangeListener", "setListener", "(Lcom/genius/multiprogressbar/MultiProgressBar$d;)V", "Lcom/genius/multiprogressbar/MultiProgressBar$c;", "finishListener", "setFinishListener", "(Lcom/genius/multiprogressbar/MultiProgressBar$c;)V", "progressSteps", "setProgressStepsCount", "getProgressStepsCount", "()I", "o", "m", "l", "n", "e", "getCurrentStep", "progressPercents", "setProgressPercents", "getProgressPercents", "", "singleDisplayedTime", "setSingleDisplayTime", "(F)V", "getSingleDisplayTime", "()F", "a", "Landroid/graphics/Paint;", "paint", "b", TokenNames.I, "progressColor", "lineColor", TokenNames.F, "progressPadding", "progressWidth", "f", "singleProgressWidth", "countOfProgressSteps", "Z", "isNeedRestoreProgressAfterRecreate", "i", "j", "Lcom/genius/multiprogressbar/MultiProgressBar$d;", "k", "Lcom/genius/multiprogressbar/MultiProgressBar$c;", "currentAbsoluteProgress", "animatedAbsoluteProgress", "isProgressIsRunning", "p", "displayedStepForListener", "Lir/nasim/Ct;", "q", "Lir/nasim/Ct;", "activeAnimator", "r", "value", "s", "getOrientation", "setOrientation", "getOrientation$annotations", "orientation", "getRelativePaddingStart", "relativePaddingStart", "getRelativePaddingEnd", "relativePaddingEnd", "getRelativePaddingWidthStart", "relativePaddingWidthStart", "getRelativePaddingWidthEnd", "relativePaddingWidthEnd", "getRelativeLength", "relativeLength", "getRelativeWidth", "relativeWidth", "(F)F", "toPx", "()Z", "isPause", "t", "multiprogressbar_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class MultiProgressBar extends View {
    private static final a t = new a(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: b, reason: from kotlin metadata */
    private int progressColor;

    /* renamed from: c, reason: from kotlin metadata */
    private int lineColor;

    /* renamed from: d, reason: from kotlin metadata */
    private float progressPadding;

    /* renamed from: e, reason: from kotlin metadata */
    private float progressWidth;

    /* renamed from: f, reason: from kotlin metadata */
    private float singleProgressWidth;

    /* renamed from: g, reason: from kotlin metadata */
    private int countOfProgressSteps;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isNeedRestoreProgressAfterRecreate;

    /* renamed from: i, reason: from kotlin metadata */
    private float singleDisplayedTime;

    /* renamed from: j, reason: from kotlin metadata */
    private d stepChangeListener;

    /* renamed from: k, reason: from kotlin metadata */
    private c finishListener;

    /* renamed from: l, reason: from kotlin metadata */
    private int progressPercents;

    /* renamed from: m, reason: from kotlin metadata */
    private float currentAbsoluteProgress;

    /* renamed from: n, reason: from kotlin metadata */
    private float animatedAbsoluteProgress;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isProgressIsRunning;

    /* renamed from: p, reason: from kotlin metadata */
    private int displayedStepForListener;

    /* renamed from: q, reason: from kotlin metadata */
    private AbstractC3879Ct activeAnimator;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean isCompactMode;

    /* renamed from: s, reason: from kotlin metadata */
    private int orientation;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
        public static final a a = a.a;

        public static final class a {
            static final /* synthetic */ a a = new a();
            private static final List b = AbstractC10360bX0.p(0, 1, 2, 3);

            private a() {
            }

            public final List a() {
                return b;
            }
        }
    }

    public interface c {
        void U();
    }

    public interface d {
        void E1(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiProgressBar(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void c(Paint paint, boolean z) {
        paint.reset();
        paint.setStrokeCap(z ? Paint.Cap.BUTT : Paint.Cap.ROUND);
        paint.setStrokeWidth(this.progressWidth);
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setColor(this.lineColor);
    }

    private final void d(Paint paint, boolean z) {
        paint.reset();
        paint.setStrokeCap(z ? Paint.Cap.BUTT : Paint.Cap.ROUND);
        paint.setStrokeWidth(this.progressWidth);
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setColor(this.progressColor);
    }

    private final float f(float f) {
        return f * getContext().getResources().getDisplayMetrics().density;
    }

    private final void g(int count) {
        this.countOfProgressSteps = count;
        float relativeLength = getRelativeLength();
        float f = this.progressPadding;
        this.singleProgressWidth = ((((relativeLength - (this.countOfProgressSteps * f)) - f) - getRelativePaddingStart()) - getRelativePaddingEnd()) / this.countOfProgressSteps;
        if (getRelativeLength() == 0 || this.singleProgressWidth >= 0.0f) {
            return;
        }
        int relativeLength2 = ((getRelativeLength() - getRelativePaddingStart()) - getRelativePaddingEnd()) / this.countOfProgressSteps;
        if (relativeLength2 <= 0) {
            this.isCompactMode = false;
            return;
        }
        this.progressPadding = 0.0f;
        this.singleProgressWidth = relativeLength2;
        this.isCompactMode = true;
    }

    public static /* synthetic */ void getOrientation$annotations() {
    }

    private final int getRelativeLength() {
        int i = this.orientation;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                }
            }
            return getMeasuredWidth();
        }
        return getMeasuredHeight();
    }

    private final int getRelativePaddingEnd() {
        int i = this.orientation;
        if (i == 0) {
            return getPaddingTop();
        }
        if (i == 1) {
            return getPaddingRight();
        }
        if (i == 2) {
            return getPaddingBottom();
        }
        if (i != 3) {
            return 0;
        }
        return getPaddingLeft();
    }

    private final int getRelativePaddingStart() {
        int i = this.orientation;
        if (i == 0) {
            return getPaddingBottom();
        }
        if (i == 1) {
            return getPaddingLeft();
        }
        if (i == 2) {
            return getPaddingTop();
        }
        if (i != 3) {
            return 0;
        }
        return getPaddingRight();
    }

    private final int getRelativePaddingWidthEnd() {
        int i = this.orientation;
        if (i == 0) {
            return getPaddingBottom();
        }
        if (i == 1) {
            return getPaddingLeft();
        }
        if (i == 2) {
            return getPaddingTop();
        }
        if (i != 3) {
            return 0;
        }
        return getPaddingRight();
    }

    private final int getRelativePaddingWidthStart() {
        int i = this.orientation;
        if (i == 0) {
            return getPaddingBottom();
        }
        if (i == 1) {
            return getPaddingLeft();
        }
        if (i == 2) {
            return getPaddingTop();
        }
        if (i != 3) {
            return 0;
        }
        return getPaddingRight();
    }

    private final int getRelativeWidth() {
        int i = this.orientation;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                }
            }
            return getMeasuredHeight();
        }
        return getMeasuredWidth();
    }

    private final void h(Integer fromPosition) {
        if (fromPosition != null) {
            float fL = AbstractC23053wG5.l(fromPosition.intValue(), 0.0f, this.countOfProgressSteps) * this.progressPercents;
            this.currentAbsoluteProgress = fL;
            this.animatedAbsoluteProgress = fL;
        }
        int i = this.countOfProgressSteps;
        final float f = i * this.progressPercents;
        float f2 = this.singleDisplayedTime * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT * i;
        float f3 = this.animatedAbsoluteProgress;
        C4328Eq7 c4328Eq7 = new C4328Eq7(f3, f, (long) (f2 * (1 - (f3 / f))));
        c4328Eq7.c(new InterfaceC25191zt() { // from class: ir.nasim.Il4
            @Override // ir.nasim.InterfaceC25191zt
            public final void a(float f4) {
                MultiProgressBar.j(this.a, f, f4);
            }
        });
        this.activeAnimator = c4328Eq7;
        c4328Eq7.d();
    }

    static /* synthetic */ void i(MultiProgressBar multiProgressBar, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        multiProgressBar.h(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(com.genius.multiprogressbar.MultiProgressBar r6, float r7, float r8) {
        /*
            java.lang.String r0 = "this$0"
            ir.nasim.AbstractC13042fc3.i(r6, r0)
            int r0 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Ld
            r3 = r2
            goto Le
        Ld:
            r3 = r1
        Le:
            r3 = r3 ^ r2
            r6.isProgressIsRunning = r3
            int r3 = r6.progressPercents
            float r4 = (float) r3
            float r4 = r8 / r4
            int r4 = (int) r4
            int r5 = r6.displayedStepForListener
            if (r4 == r5) goto L38
            if (r0 != 0) goto L1e
            goto L38
        L1e:
            float r7 = (float) r3
            float r7 = r8 / r7
            int r7 = (int) r7
            r6.displayedStepForListener = r7
            float r1 = (float) r7
            float r4 = (float) r3
            float r1 = r1 * r4
            r6.currentAbsoluteProgress = r1
            float r1 = (float) r7
            float r3 = (float) r3
            float r1 = r1 * r3
            r6.animatedAbsoluteProgress = r1
            com.genius.multiprogressbar.MultiProgressBar$d r1 = r6.stepChangeListener
            if (r1 != 0) goto L33
            goto L36
        L33:
            r1.E1(r7)
        L36:
            r1 = r2
            goto L47
        L38:
            if (r0 != 0) goto L47
            r6.currentAbsoluteProgress = r7
            r6.animatedAbsoluteProgress = r7
            com.genius.multiprogressbar.MultiProgressBar$c r7 = r6.finishListener
            if (r7 != 0) goto L43
            goto L36
        L43:
            r7.U()
            goto L36
        L47:
            if (r0 != 0) goto L58
            ir.nasim.Ct r7 = r6.activeAnimator
            if (r7 != 0) goto L4e
            goto L51
        L4e:
            r7.a()
        L51:
            r7 = 0
            r6.animatedAbsoluteProgress = r7
            r7 = -1
            r6.displayedStepForListener = r7
            goto L6e
        L58:
            if (r1 != 0) goto L67
            int r7 = r6.countOfProgressSteps
            float r7 = (float) r7
            int r0 = r6.progressPercents
            float r0 = (float) r0
            float r7 = r7 * r0
            float r7 = ir.nasim.AbstractC21867uG5.h(r8, r7)
            r6.currentAbsoluteProgress = r7
        L67:
            r6.invalidate()
            if (r1 != 0) goto L6e
            r6.animatedAbsoluteProgress = r8
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.genius.multiprogressbar.MultiProgressBar.j(com.genius.multiprogressbar.MultiProgressBar, float, float):void");
    }

    public static /* synthetic */ void p(MultiProgressBar multiProgressBar, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        multiProgressBar.o(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setSingleDisplayTime$lambda-1, reason: not valid java name */
    public static final void m5setSingleDisplayTime$lambda1(MultiProgressBar multiProgressBar) {
        AbstractC13042fc3.i(multiProgressBar, "this$0");
        multiProgressBar.m();
        i(multiProgressBar, null, 1, null);
    }

    public final void e() {
        if (this.isProgressIsRunning) {
            m();
        }
        this.currentAbsoluteProgress = 0.0f;
        this.animatedAbsoluteProgress = 0.0f;
        this.displayedStepForListener = -1;
        invalidate();
    }

    public final int getCurrentStep() {
        return (int) (this.currentAbsoluteProgress / this.progressPercents);
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getProgressPercents() {
        return this.progressPercents;
    }

    /* renamed from: getProgressStepsCount, reason: from getter */
    public final int getCountOfProgressSteps() {
        return this.countOfProgressSteps;
    }

    /* renamed from: getSingleDisplayTime, reason: from getter */
    public final float getSingleDisplayedTime() {
        return this.singleDisplayedTime;
    }

    public final boolean k() {
        return !this.isProgressIsRunning;
    }

    public final void l() {
        if (!this.isProgressIsRunning) {
            float fH = AbstractC23053wG5.h(((int) (this.currentAbsoluteProgress / this.progressPercents)) + 1.0f, this.countOfProgressSteps) * this.progressPercents;
            this.currentAbsoluteProgress = fH;
            this.animatedAbsoluteProgress = fH;
            invalidate();
            return;
        }
        m();
        float fH2 = AbstractC23053wG5.h(((int) (this.currentAbsoluteProgress / this.progressPercents)) + 1.0f, this.countOfProgressSteps) * this.progressPercents;
        this.currentAbsoluteProgress = fH2;
        this.animatedAbsoluteProgress = fH2;
        p(this, null, 1, null);
    }

    public final void m() {
        AbstractC3879Ct abstractC3879Ct = this.activeAnimator;
        if (abstractC3879Ct != null) {
            abstractC3879Ct.a();
        }
        this.isProgressIsRunning = false;
    }

    public final void n() {
        if (!this.isProgressIsRunning) {
            float fD = AbstractC23053wG5.d(((int) (this.currentAbsoluteProgress / this.progressPercents)) - 1.0f, 0.0f) * this.progressPercents;
            this.currentAbsoluteProgress = fD;
            this.animatedAbsoluteProgress = fD;
            invalidate();
            return;
        }
        m();
        float fD2 = AbstractC23053wG5.d(((int) (this.currentAbsoluteProgress / this.progressPercents)) - 1.0f, 0.0f) * this.progressPercents;
        this.currentAbsoluteProgress = fD2;
        this.animatedAbsoluteProgress = fD2;
        p(this, null, 1, null);
    }

    public final void o(Integer fromPosition) {
        if (this.isProgressIsRunning) {
            return;
        }
        m();
        h(fromPosition);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.isProgressIsRunning) {
            m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        int i = this.countOfProgressSteps;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            float f = this.progressPadding;
            float f2 = i2;
            float f3 = f + (f * f2);
            int i4 = this.orientation;
            float relativePaddingStart = (i4 == 1 || i4 == 2) ? getRelativePaddingStart() + f3 + (this.singleProgressWidth * f2) : ((getRelativeLength() - getRelativePaddingEnd()) - f3) - (this.singleProgressWidth * f2);
            int i5 = this.orientation;
            float relativeLength = (i5 == 1 || i5 == 2) ? i2 == this.countOfProgressSteps - 1 ? (getRelativeLength() - this.progressPadding) - getRelativePaddingEnd() : this.singleProgressWidth + relativePaddingStart : i2 == this.countOfProgressSteps - 1 ? this.progressPadding + getRelativePaddingStart() : relativePaddingStart - this.singleProgressWidth;
            if (f2 > (this.currentAbsoluteProgress / this.progressPercents) - 1) {
                c(this.paint, this.isCompactMode);
            } else {
                d(this.paint, this.isCompactMode);
            }
            int i6 = this.orientation;
            if (i6 == 3 || i6 == 1) {
                canvas.drawLine(relativePaddingStart, (((getRelativeWidth() - getRelativePaddingWidthStart()) - getRelativePaddingWidthEnd()) / 2.0f) + getRelativePaddingWidthStart(), relativeLength, (((getRelativeWidth() - getRelativePaddingWidthStart()) - getRelativePaddingWidthEnd()) / 2.0f) + getRelativePaddingWidthStart(), this.paint);
            } else {
                canvas.drawLine(getRelativePaddingWidthStart() + (((getRelativeWidth() - getRelativePaddingWidthStart()) - getRelativePaddingWidthEnd()) / 2.0f), relativePaddingStart, (((getRelativeWidth() - getRelativePaddingWidthStart()) - getRelativePaddingWidthEnd()) / 2.0f) + getRelativePaddingWidthStart(), relativeLength, this.paint);
            }
            float f4 = (this.currentAbsoluteProgress / this.progressPercents) - f2;
            if (f4 < 1.0f && f4 > 0.0f) {
                int i7 = this.orientation;
                float f5 = (i7 == 1 || i7 == 2) ? (this.singleProgressWidth * f4) + relativePaddingStart : relativePaddingStart - (this.singleProgressWidth * f4);
                d(this.paint, this.isCompactMode);
                int i8 = this.orientation;
                if (i8 == 3 || i8 == 1) {
                    canvas.drawLine(relativePaddingStart, (((getRelativeWidth() - getRelativePaddingWidthStart()) - getRelativePaddingWidthEnd()) / 2.0f) + getRelativePaddingWidthStart(), f5, (((getRelativeWidth() - getRelativePaddingWidthStart()) - getRelativePaddingWidthEnd()) / 2.0f) + getRelativePaddingWidthStart(), this.paint);
                } else {
                    canvas.drawLine(getRelativePaddingWidthStart() + (((getRelativeWidth() - getRelativePaddingWidthStart()) - getRelativePaddingWidthEnd()) / 2.0f), relativePaddingStart, (((getRelativeWidth() - getRelativePaddingWidthStart()) - getRelativePaddingWidthEnd()) / 2.0f) + getRelativePaddingWidthStart(), f5, this.paint);
                }
            }
            i2 = i3;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.orientation;
        setMeasuredDimension(View.resolveSize(getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth() + ((i == 2 || i == 0) ? ((int) this.progressWidth) + 5 : 0), widthMeasureSpec), View.resolveSize(getPaddingBottom() + getPaddingTop() + getSuggestedMinimumHeight() + ((i == 1 || i == 3) ? ((int) this.progressWidth) + 5 : 0), heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof MultiProgressBarSavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        MultiProgressBarSavedState multiProgressBarSavedState = (MultiProgressBarSavedState) state;
        super.onRestoreInstanceState(multiProgressBarSavedState.getSuperState());
        this.progressColor = multiProgressBarSavedState.getProgressColor();
        this.lineColor = multiProgressBarSavedState.getLineColor();
        this.countOfProgressSteps = multiProgressBarSavedState.getCountProgress();
        this.progressPercents = multiProgressBarSavedState.getProgressPercents();
        this.progressPadding = multiProgressBarSavedState.getProgressPadding();
        this.progressWidth = multiProgressBarSavedState.getProgressWidth();
        this.singleProgressWidth = multiProgressBarSavedState.getSingleProgressWidth();
        this.currentAbsoluteProgress = multiProgressBarSavedState.getCurrentAbsoluteProgress();
        this.animatedAbsoluteProgress = multiProgressBarSavedState.getAnimatedAbsoluteProgress();
        this.displayedStepForListener = multiProgressBarSavedState.getDisplayedStepForListener();
        this.isNeedRestoreProgressAfterRecreate = multiProgressBarSavedState.getIsNeedRestoreProgressAfterRecreate();
        this.isProgressIsRunning = multiProgressBarSavedState.getIsProgressIsRunning();
        this.singleDisplayedTime = multiProgressBarSavedState.getSingleDisplayedTime();
        this.isCompactMode = multiProgressBarSavedState.getIsCompactMode();
        setOrientation(multiProgressBarSavedState.getOrientation());
        if (this.isProgressIsRunning && this.isNeedRestoreProgressAfterRecreate) {
            i(this, null, 1, null);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            return null;
        }
        MultiProgressBarSavedState multiProgressBarSavedState = new MultiProgressBarSavedState(parcelableOnSaveInstanceState);
        multiProgressBarSavedState.x(this.progressColor);
        multiProgressBarSavedState.u(this.lineColor);
        multiProgressBarSavedState.r(this.countOfProgressSteps);
        multiProgressBarSavedState.A(this.progressPercents);
        multiProgressBarSavedState.z(this.progressPadding);
        multiProgressBarSavedState.B(this.progressWidth);
        multiProgressBarSavedState.D(this.singleProgressWidth);
        multiProgressBarSavedState.s(this.currentAbsoluteProgress);
        multiProgressBarSavedState.p(this.animatedAbsoluteProgress);
        multiProgressBarSavedState.y(this.isProgressIsRunning);
        multiProgressBarSavedState.t(this.displayedStepForListener);
        multiProgressBarSavedState.v(this.isNeedRestoreProgressAfterRecreate);
        multiProgressBarSavedState.C(this.singleDisplayedTime);
        multiProgressBarSavedState.q(this.isCompactMode);
        multiProgressBarSavedState.w(getOrientation());
        return multiProgressBarSavedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        g(this.countOfProgressSteps);
    }

    public final void setFinishListener(c finishListener) {
        this.finishListener = finishListener;
    }

    public final void setListener(d stepChangeListener) {
        this.stepChangeListener = stepChangeListener;
    }

    public final void setOrientation(int i) {
        if (!b.a.a().contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.orientation = i;
        invalidate();
    }

    public final void setProgressPercents(int progressPercents) {
        this.progressPercents = progressPercents;
    }

    public final void setProgressStepsCount(int progressSteps) {
        g(progressSteps);
    }

    public final void setSingleDisplayTime(float singleDisplayedTime) {
        this.singleDisplayedTime = AbstractC23053wG5.d(singleDisplayedTime, 0.1f);
        if (this.isProgressIsRunning) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.Jl4
                @Override // java.lang.Runnable
                public final void run() {
                    MultiProgressBar.m5setSingleDisplayTime$lambda1(this.a);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ MultiProgressBar(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.paint = new Paint();
        this.progressWidth = 10.0f;
        this.countOfProgressSteps = 1;
        this.singleDisplayedTime = 1.0f;
        this.displayedStepForListener = -1;
        this.orientation = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CE5.MultiProgressBar);
        AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.MultiProgressBar)");
        this.lineColor = typedArrayObtainStyledAttributes.getColor(CE5.MultiProgressBar_progressLineColor, -7829368);
        this.progressColor = typedArrayObtainStyledAttributes.getColor(CE5.MultiProgressBar_progressColor, -1);
        this.progressPadding = typedArrayObtainStyledAttributes.getDimension(CE5.MultiProgressBar_progressPadding, f(8.0f));
        this.countOfProgressSteps = typedArrayObtainStyledAttributes.getInt(CE5.MultiProgressBar_progressSteps, 1);
        this.progressWidth = typedArrayObtainStyledAttributes.getDimension(CE5.MultiProgressBar_progressWidth, f(4.0f));
        this.progressPercents = typedArrayObtainStyledAttributes.getInt(CE5.MultiProgressBar_progressPercents, 100);
        this.isNeedRestoreProgressAfterRecreate = typedArrayObtainStyledAttributes.getBoolean(CE5.MultiProgressBar_progressIsNeedRestoreProgress, true);
        this.singleDisplayedTime = AbstractC23053wG5.d(typedArrayObtainStyledAttributes.getFloat(CE5.MultiProgressBar_progressSingleDisplayedTime, 1.0f), 0.1f);
        setOrientation(typedArrayObtainStyledAttributes.getInt(CE5.MultiProgressBar_progressOrientation, 1));
        typedArrayObtainStyledAttributes.recycle();
        if (isInEditMode()) {
            this.currentAbsoluteProgress = (this.countOfProgressSteps / 2.0f) * this.progressPercents;
        }
    }
}
