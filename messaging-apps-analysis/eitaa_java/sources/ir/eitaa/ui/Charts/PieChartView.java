package ir.eitaa.ui.Charts;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.Charts.data.ChartData;
import ir.eitaa.ui.Charts.data.StackLinearChartData;
import ir.eitaa.ui.Charts.view_data.ChartHorizontalLinesData;
import ir.eitaa.ui.Charts.view_data.LegendSignatureView;
import ir.eitaa.ui.Charts.view_data.LineViewData;
import ir.eitaa.ui.Charts.view_data.PieLegendView;
import ir.eitaa.ui.Charts.view_data.TransitionParams;

/* loaded from: classes3.dex */
public class PieChartView extends StackLinearChartView<PieChartViewData> {
    float MAX_TEXT_SIZE;
    float MIN_TEXT_SIZE;
    int currentSelection;
    float[] darawingValuesPercentage;
    float emptyDataAlpha;
    boolean isEmpty;
    int lastEndIndex;
    int lastStartIndex;
    String[] lookupTable;
    int oldW;
    PieLegendView pieLegendView;
    RectF rectF;
    float sum;
    TextPaint textPaint;
    float[] values;

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void drawBottomLine(Canvas canvas) {
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    void drawBottomSignature(Canvas canvas) {
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void drawHorizontalLines(Canvas canvas, ChartHorizontalLinesData a) {
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void drawSelection(Canvas canvas) {
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void drawSignaturesToHorizontalLines(Canvas canvas, ChartHorizontalLinesData a) {
    }

    public PieChartView(Context context) {
        super(context);
        this.currentSelection = -1;
        this.rectF = new RectF();
        this.MIN_TEXT_SIZE = AndroidUtilities.dp(9.0f);
        this.MAX_TEXT_SIZE = AndroidUtilities.dp(13.0f);
        this.lookupTable = new String[R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle];
        this.emptyDataAlpha = 1.0f;
        this.oldW = 0;
        this.lastStartIndex = -1;
        this.lastEndIndex = -1;
        for (int i = 1; i <= 100; i++) {
            this.lookupTable[i] = i + "%";
        }
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setColor(-1);
        this.textPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.canCaptureChartSelection = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b3  */
    @Override // ir.eitaa.ui.Charts.StackLinearChartView, ir.eitaa.ui.Charts.BaseChartView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void drawChart(android.graphics.Canvas r27) {
        /*
            Method dump skipped, instructions count: 929
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Charts.PieChartView.drawChart(android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    @Override // ir.eitaa.ui.Charts.StackLinearChartView, ir.eitaa.ui.Charts.BaseChartView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void drawPickerChart(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Charts.PieChartView.drawPickerChart(android.graphics.Canvas):void");
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    public void setData(StackLinearChartData chartData) {
        super.setData((PieChartView) chartData);
        if (chartData != null) {
            this.values = new float[chartData.lines.size()];
            this.darawingValuesPercentage = new float[chartData.lines.size()];
            onPickerDataChanged(false, true, false);
        }
    }

    @Override // ir.eitaa.ui.Charts.StackLinearChartView, ir.eitaa.ui.Charts.BaseChartView
    public PieChartViewData createLineViewData(ChartData.Line line) {
        return new PieChartViewData(line);
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void selectXOnChart(int x, int y) {
        if (this.chartData == 0 || this.isEmpty) {
            return;
        }
        float degrees = (float) (Math.toDegrees(Math.atan2((this.chartArea.centerY() + AndroidUtilities.dp(16.0f)) - y, this.chartArea.centerX() - x)) - 90.0d);
        float f = 0.0f;
        if (degrees < 0.0f) {
            double d = degrees;
            Double.isNaN(d);
            degrees = (float) (d + 360.0d);
        }
        float f2 = degrees / 360.0f;
        int i = -1;
        int i2 = 0;
        float f3 = 0.0f;
        while (true) {
            if (i2 >= this.lines.size()) {
                f3 = 0.0f;
                break;
            }
            if (((PieChartViewData) this.lines.get(i2)).enabled || ((PieChartViewData) this.lines.get(i2)).alpha != 0.0f) {
                if (f2 > f3) {
                    float[] fArr = this.darawingValuesPercentage;
                    if (f2 < fArr[i2] + f3) {
                        f = f3 + fArr[i2];
                        i = i2;
                        break;
                    }
                }
                f3 += this.darawingValuesPercentage[i2];
            }
            i2++;
        }
        if (this.currentSelection != i && i >= 0) {
            this.currentSelection = i;
            invalidate();
            this.pieLegendView.setVisibility(0);
            LineViewData lineViewData = (LineViewData) this.lines.get(i);
            this.pieLegendView.setData(lineViewData.line.name, (int) this.values[this.currentSelection], lineViewData.lineColor);
            this.pieLegendView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
            float fWidth = this.rectF.width() / 2.0f;
            double dCenterX = this.rectF.centerX();
            double d2 = fWidth;
            double d3 = (f * 360.0f) - 90.0f;
            double dCos = Math.cos(Math.toRadians(d3));
            Double.isNaN(d2);
            Double.isNaN(dCenterX);
            double d4 = dCenterX + (dCos * d2);
            double dCenterX2 = this.rectF.centerX();
            double d5 = (f3 * 360.0f) - 90.0f;
            double dCos2 = Math.cos(Math.toRadians(d5));
            Double.isNaN(d2);
            Double.isNaN(dCenterX2);
            int iMin = (int) Math.min(d4, dCenterX2 + (dCos2 * d2));
            if (iMin < 0) {
                iMin = 0;
            }
            if (this.pieLegendView.getMeasuredWidth() + iMin > getMeasuredWidth() - AndroidUtilities.dp(16.0f)) {
                iMin -= (this.pieLegendView.getMeasuredWidth() + iMin) - (getMeasuredWidth() - AndroidUtilities.dp(16.0f));
            }
            double dCenterY = this.rectF.centerY();
            double dSin = Math.sin(Math.toRadians(d5));
            Double.isNaN(d2);
            Double.isNaN(dCenterY);
            double d6 = dCenterY + (dSin * d2);
            double dCenterY2 = this.rectF.centerY();
            double dSin2 = Math.sin(Math.toRadians(d3));
            Double.isNaN(d2);
            Double.isNaN(dCenterY2);
            int iMin2 = ((int) Math.min(this.rectF.centerY(), (int) Math.min(d6, dCenterY2 + (d2 * dSin2)))) - AndroidUtilities.dp(50.0f);
            this.pieLegendView.setTranslationX(iMin);
            this.pieLegendView.setTranslationY(iMin2);
            if (!(Build.VERSION.SDK_INT >= 27 ? performHapticFeedback(9, 2) : false)) {
                performHapticFeedback(3, 2);
            }
        }
        moveLegend();
    }

    @Override // ir.eitaa.ui.Charts.StackLinearChartView, ir.eitaa.ui.Charts.BaseChartView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.chartData != 0) {
            for (int i = 0; i < this.lines.size(); i++) {
                if (i == this.currentSelection) {
                    if (((PieChartViewData) this.lines.get(i)).selectionA < 1.0f) {
                        ((PieChartViewData) this.lines.get(i)).selectionA += 0.1f;
                        if (((PieChartViewData) this.lines.get(i)).selectionA > 1.0f) {
                            ((PieChartViewData) this.lines.get(i)).selectionA = 1.0f;
                        }
                        invalidate();
                    }
                } else if (((PieChartViewData) this.lines.get(i)).selectionA > 0.0f) {
                    ((PieChartViewData) this.lines.get(i)).selectionA -= 0.1f;
                    if (((PieChartViewData) this.lines.get(i)).selectionA < 0.0f) {
                        ((PieChartViewData) this.lines.get(i)).selectionA = 0.0f;
                    }
                    invalidate();
                }
            }
        }
        super.onDraw(canvas);
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void onActionUp() {
        this.currentSelection = -1;
        this.pieLegendView.setVisibility(8);
        invalidate();
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredWidth() != this.oldW) {
            this.oldW = getMeasuredWidth();
            int iHeight = (int) ((this.chartArea.width() > this.chartArea.height() ? this.chartArea.height() : this.chartArea.width()) * 0.45f);
            this.MIN_TEXT_SIZE = iHeight / 13;
            this.MAX_TEXT_SIZE = iHeight / 7;
        }
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    public void updatePicker(ChartData chartData, long d) {
        int length = chartData.x.length;
        long j = d - (d % 86400000);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (j >= chartData.x[i2]) {
                i = i2;
            }
        }
        float length2 = chartData.xPercentage.length < 2 ? 0.5f : 1.0f / chartData.x.length;
        if (i == 0) {
            ChartPickerDelegate chartPickerDelegate = this.pickerDelegate;
            chartPickerDelegate.pickerStart = 0.0f;
            chartPickerDelegate.pickerEnd = length2;
        } else {
            if (i >= chartData.x.length - 1) {
                ChartPickerDelegate chartPickerDelegate2 = this.pickerDelegate;
                chartPickerDelegate2.pickerStart = 1.0f - length2;
                chartPickerDelegate2.pickerEnd = 1.0f;
                return;
            }
            ChartPickerDelegate chartPickerDelegate3 = this.pickerDelegate;
            float f = i * length2;
            chartPickerDelegate3.pickerStart = f;
            float f2 = f + length2;
            chartPickerDelegate3.pickerEnd = f2;
            if (f2 > 1.0f) {
                chartPickerDelegate3.pickerEnd = 1.0f;
            }
            onPickerDataChanged(true, true, false);
        }
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected LegendSignatureView createLegendView() {
        PieLegendView pieLegendView = new PieLegendView(getContext());
        this.pieLegendView = pieLegendView;
        return pieLegendView;
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    public void onPickerDataChanged(boolean animated, boolean force, boolean useAnimator) {
        super.onPickerDataChanged(animated, force, useAnimator);
        T t = this.chartData;
        if (t == 0 || ((StackLinearChartData) t).xPercentage == null) {
            return;
        }
        ChartPickerDelegate chartPickerDelegate = this.pickerDelegate;
        updateCharValues(chartPickerDelegate.pickerStart, chartPickerDelegate.pickerEnd, force);
    }

    private void updateCharValues(float startPercentage, float endPercentage, boolean force) {
        if (this.values == null) {
            return;
        }
        int length = ((StackLinearChartData) this.chartData).xPercentage.length;
        int size = this.lines.size();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            T t = this.chartData;
            if (((StackLinearChartData) t).xPercentage[i4] >= startPercentage && i3 == -1) {
                i3 = i4;
            }
            if (((StackLinearChartData) t).xPercentage[i4] <= endPercentage) {
                i2 = i4;
            }
        }
        if (i2 < i3) {
            i3 = i2;
        }
        if (!force && this.lastEndIndex == i2 && this.lastStartIndex == i3) {
            return;
        }
        this.lastEndIndex = i2;
        this.lastStartIndex = i3;
        this.isEmpty = true;
        this.sum = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            this.values[i5] = 0.0f;
        }
        while (i3 <= i2) {
            for (int i6 = 0; i6 < size; i6++) {
                float[] fArr = this.values;
                fArr[i6] = fArr[i6] + ((StackLinearChartData) this.chartData).lines.get(i6).y[i3];
                this.sum += ((StackLinearChartData) this.chartData).lines.get(i6).y[i3];
                if (this.isEmpty && ((PieChartViewData) this.lines.get(i6)).enabled && ((StackLinearChartData) this.chartData).lines.get(i6).y[i3] > 0) {
                    this.isEmpty = false;
                }
            }
            i3++;
        }
        if (force) {
            while (i < size) {
                if (this.sum == 0.0f) {
                    ((PieChartViewData) this.lines.get(i)).drawingPart = 0.0f;
                } else {
                    ((PieChartViewData) this.lines.get(i)).drawingPart = this.values[i] / this.sum;
                }
                i++;
            }
            return;
        }
        while (i < size) {
            final PieChartViewData pieChartViewData = (PieChartViewData) this.lines.get(i);
            Animator animator = pieChartViewData.animator;
            if (animator != null) {
                animator.cancel();
            }
            float f = this.sum;
            ValueAnimator valueAnimatorCreateAnimator = createAnimator(pieChartViewData.drawingPart, f == 0.0f ? 0.0f : this.values[i] / f, new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Charts.-$$Lambda$PieChartView$NYtH2EkMMAWtoo_1ATXwehnLFjw
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$updateCharValues$0$PieChartView(pieChartViewData, valueAnimator);
                }
            });
            pieChartViewData.animator = valueAnimatorCreateAnimator;
            valueAnimatorCreateAnimator.start();
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateCharValues$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateCharValues$0$PieChartView(PieChartViewData pieChartViewData, ValueAnimator valueAnimator) {
        pieChartViewData.drawingPart = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView, ir.eitaa.ui.Charts.ChartPickerDelegate.Listener
    public void onPickerJumpTo(float start, float end, boolean force) {
        if (this.chartData == 0) {
            return;
        }
        if (force) {
            updateCharValues(start, end, false);
        } else {
            updateIndexes();
            invalidate();
        }
    }

    @Override // ir.eitaa.ui.Charts.StackLinearChartView, ir.eitaa.ui.Charts.BaseChartView
    public void fillTransitionParams(TransitionParams params) {
        drawChart(null);
        float f = 0.0f;
        int i = 0;
        while (true) {
            float[] fArr = this.darawingValuesPercentage;
            if (i >= fArr.length) {
                return;
            }
            f += fArr[i];
            params.angle[i] = (360.0f * f) - 180.0f;
            i++;
        }
    }
}
