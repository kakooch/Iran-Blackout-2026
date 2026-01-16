package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class StorageDiagramView extends View {
    private float[] animateToPercentage;
    private ClearViewData[] data;
    private float[] drawingPercentage;
    int enabledCount;
    StaticLayout layout1;
    StaticLayout layout2;
    private RectF rectF;
    private float singleProgress;
    private float[] startFromPercentage;
    TextPaint textPaint;
    TextPaint textPaint2;
    ValueAnimator valueAnimator;

    public StorageDiagramView(Context context) {
        super(context);
        this.rectF = new RectF();
        this.singleProgress = 0.0f;
        this.textPaint = new TextPaint(1);
        this.textPaint2 = new TextPaint(1);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(110.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(110.0f), 1073741824));
        this.rectF.set(AndroidUtilities.dp(3.0f), AndroidUtilities.dp(3.0f), getMeasuredWidth() - AndroidUtilities.dp(3.0f), getMeasuredHeight() - AndroidUtilities.dp(3.0f));
        updateDescription();
        this.textPaint.setTextSize(AndroidUtilities.dp(24.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textPaint2.setTextSize(AndroidUtilities.dp(13.0f));
    }

    public void setData(ClearViewData[] data) {
        this.data = data;
        invalidate();
        this.drawingPercentage = new float[data.length];
        this.animateToPercentage = new float[data.length];
        this.startFromPercentage = new float[data.length];
        update(false);
        if (this.enabledCount > 1) {
            this.singleProgress = 0.0f;
        } else {
            this.singleProgress = 1.0f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0233  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r26) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.StorageDiagramView.onDraw(android.graphics.Canvas):void");
    }

    public static class ClearViewData {
        public boolean clear;
        public String color;
        boolean firstDraw;
        Paint paint;
        private final StorageDiagramView parentView;
        public long size;

        public ClearViewData(StorageDiagramView parentView) {
            Paint paint = new Paint(1);
            this.paint = paint;
            this.clear = true;
            this.firstDraw = false;
            this.parentView = parentView;
            paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(AndroidUtilities.dp(5.0f));
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            this.paint.setStrokeJoin(Paint.Join.ROUND);
        }

        public void setClear(boolean clear) {
            if (this.clear != clear) {
                this.clear = clear;
                this.parentView.updateDescription();
                this.firstDraw = true;
                this.parentView.update(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(boolean animate) {
        final ClearViewData[] clearViewDataArr = this.data;
        if (clearViewDataArr == null) {
            return;
        }
        long j = 0;
        for (int i = 0; i < clearViewDataArr.length; i++) {
            if (clearViewDataArr[i] != null && clearViewDataArr[i].clear) {
                j += clearViewDataArr[i].size;
            }
        }
        this.enabledCount = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < clearViewDataArr.length; i2++) {
            if (clearViewDataArr[i2] != null && clearViewDataArr[i2].clear) {
                this.enabledCount++;
            }
            if (clearViewDataArr[i2] == null || !clearViewDataArr[i2].clear) {
                this.animateToPercentage[i2] = 0.0f;
            } else {
                float f3 = clearViewDataArr[i2].size / j;
                if (f3 < 0.02777f) {
                    f3 = 0.02777f;
                }
                f += f3;
                if (f3 > f2 && clearViewDataArr[i2].clear) {
                    f2 = f3;
                }
                this.animateToPercentage[i2] = f3;
            }
        }
        if (f > 1.0f) {
            float f4 = 1.0f / f;
            for (int i3 = 0; i3 < clearViewDataArr.length; i3++) {
                if (clearViewDataArr[i3] != null) {
                    float[] fArr = this.animateToPercentage;
                    fArr[i3] = fArr[i3] * f4;
                }
            }
        }
        if (!animate) {
            System.arraycopy(this.animateToPercentage, 0, this.drawingPercentage, 0, clearViewDataArr.length);
            return;
        }
        System.arraycopy(this.drawingPercentage, 0, this.startFromPercentage, 0, clearViewDataArr.length);
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.valueAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StorageDiagramView$aw-Wxbj1nqnmmGt2YIw1x8VIvac
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.lambda$update$0$StorageDiagramView(clearViewDataArr, valueAnimator2);
            }
        });
        this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.StorageDiagramView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                int i4 = 0;
                while (true) {
                    ClearViewData[] clearViewDataArr2 = clearViewDataArr;
                    if (i4 >= clearViewDataArr2.length) {
                        return;
                    }
                    if (clearViewDataArr2[i4] != null) {
                        clearViewDataArr2[i4].firstDraw = false;
                    }
                    i4++;
                }
            }
        });
        this.valueAnimator.setDuration(450L);
        this.valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
        this.valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$update$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$update$0$StorageDiagramView(ClearViewData[] clearViewDataArr, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (int i = 0; i < clearViewDataArr.length; i++) {
            this.drawingPercentage[i] = (this.startFromPercentage[i] * (1.0f - fFloatValue)) + (this.animateToPercentage[i] * fFloatValue);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDescription() {
        if (this.data == null) {
            return;
        }
        long j = 0;
        int i = 0;
        while (true) {
            ClearViewData[] clearViewDataArr = this.data;
            if (i >= clearViewDataArr.length) {
                break;
            }
            if (clearViewDataArr[i] != null && clearViewDataArr[i].clear) {
                j += clearViewDataArr[i].size;
            }
            i++;
        }
        String[] strArrSplit = AndroidUtilities.formatFileSize(j).split(" ");
        if (strArrSplit.length > 1) {
            this.layout1 = new StaticLayout(j == 0 ? " " : strArrSplit[0], this.textPaint, getMeasuredWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            this.layout2 = new StaticLayout(j != 0 ? strArrSplit[1] : " ", this.textPaint2, getMeasuredWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
    }
}
