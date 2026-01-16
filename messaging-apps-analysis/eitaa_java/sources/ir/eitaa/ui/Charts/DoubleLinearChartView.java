package ir.eitaa.ui.Charts;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.Charts.data.ChartData;
import ir.eitaa.ui.Charts.data.DoubleLinearChartData;
import ir.eitaa.ui.Charts.view_data.ChartHorizontalLinesData;
import ir.eitaa.ui.Charts.view_data.LineViewData;
import ir.eitaa.ui.Charts.view_data.TransitionParams;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DoubleLinearChartView extends BaseChartView<DoubleLinearChartData, LineViewData> {
    public DoubleLinearChartView(Context context) {
        super(context);
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void init() {
        this.useMinHeight = true;
        super.init();
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void drawChart(Canvas canvas) {
        float f;
        float f2;
        float f3;
        if (this.chartData != 0) {
            float f4 = this.chartWidth;
            ChartPickerDelegate chartPickerDelegate = this.pickerDelegate;
            float f5 = chartPickerDelegate.pickerEnd;
            float f6 = chartPickerDelegate.pickerStart;
            float f7 = f4 / (f5 - f6);
            float f8 = (f6 * f7) - BaseChartView.HORIZONTAL_PADDING;
            canvas.save();
            int i = this.transitionMode;
            int i2 = 2;
            float f9 = 0.0f;
            int i3 = 1;
            if (i == 2) {
                TransitionParams transitionParams = this.transitionParams;
                float f10 = transitionParams.progress;
                f = f10 > 0.5f ? 0.0f : 1.0f - (f10 * 2.0f);
                canvas.scale((f10 * 2.0f) + 1.0f, 1.0f, transitionParams.pX, transitionParams.pY);
            } else if (i == 1) {
                float f11 = this.transitionParams.progress;
                f = f11 < 0.3f ? 0.0f : f11;
                canvas.save();
                TransitionParams transitionParams2 = this.transitionParams;
                float f12 = transitionParams2.progress;
                canvas.scale(f12, f12, transitionParams2.pX, transitionParams2.pY);
            } else {
                f = i == 3 ? this.transitionParams.progress : 1.0f;
            }
            int i4 = 0;
            int i5 = 0;
            while (i5 < this.lines.size()) {
                LineViewData lineViewData = (LineViewData) this.lines.get(i5);
                if (lineViewData.enabled || lineViewData.alpha != f9) {
                    int[] iArr = lineViewData.line.y;
                    lineViewData.chartPath.reset();
                    T t = this.chartData;
                    int i6 = ((int) (BaseChartView.HORIZONTAL_PADDING / (((DoubleLinearChartData) t).xPercentage.length < i2 ? 1.0f : ((DoubleLinearChartData) t).xPercentage[i3] * f7))) + i3;
                    int iMax = Math.max(i4, this.startXIndex - i6);
                    int iMin = Math.min(((DoubleLinearChartData) this.chartData).xPercentage.length - i3, this.endXIndex + i6);
                    boolean z = true;
                    int i7 = 0;
                    while (iMax <= iMin) {
                        if (iArr[iMax] < 0) {
                            f3 = f7;
                        } else {
                            T t2 = this.chartData;
                            float f13 = (((DoubleLinearChartData) t2).xPercentage[iMax] * f7) - f8;
                            float f14 = iArr[iMax] * ((DoubleLinearChartData) t2).linesK[i5];
                            float f15 = this.currentMinHeight;
                            float f16 = (f14 - f15) / (this.currentMaxHeight - f15);
                            float strokeWidth = lineViewData.paint.getStrokeWidth() / 2.0f;
                            f3 = f7;
                            float measuredHeight = ((getMeasuredHeight() - this.chartBottom) - strokeWidth) - (f16 * (((getMeasuredHeight() - this.chartBottom) - BaseChartView.SIGNATURE_TEXT_HEIGHT) - strokeWidth));
                            if (BaseChartView.USE_LINES) {
                                if (i7 == 0) {
                                    float[] fArr = lineViewData.linesPath;
                                    int i8 = i7 + 1;
                                    fArr[i7] = f13;
                                    i7 = i8 + 1;
                                    fArr[i8] = measuredHeight;
                                } else {
                                    float[] fArr2 = lineViewData.linesPath;
                                    int i9 = i7 + 1;
                                    fArr2[i7] = f13;
                                    int i10 = i9 + 1;
                                    fArr2[i9] = measuredHeight;
                                    int i11 = i10 + 1;
                                    fArr2[i10] = f13;
                                    i7 = i11 + 1;
                                    fArr2[i11] = measuredHeight;
                                }
                            } else if (z) {
                                lineViewData.chartPath.moveTo(f13, measuredHeight);
                                z = false;
                            } else {
                                lineViewData.chartPath.lineTo(f13, measuredHeight);
                            }
                        }
                        iMax++;
                        f7 = f3;
                    }
                    f2 = f7;
                    if (this.endXIndex - this.startXIndex > 100) {
                        lineViewData.paint.setStrokeCap(Paint.Cap.SQUARE);
                    } else {
                        lineViewData.paint.setStrokeCap(Paint.Cap.ROUND);
                    }
                    lineViewData.paint.setAlpha((int) (lineViewData.alpha * 255.0f * f));
                    if (BaseChartView.USE_LINES) {
                        canvas.drawLines(lineViewData.linesPath, 0, i7, lineViewData.paint);
                        i5++;
                        f7 = f2;
                        i4 = 0;
                        i2 = 2;
                        f9 = 0.0f;
                        i3 = 1;
                    } else {
                        canvas.drawPath(lineViewData.chartPath, lineViewData.paint);
                    }
                } else {
                    f2 = f7;
                }
                i5++;
                f7 = f2;
                i4 = 0;
                i2 = 2;
                f9 = 0.0f;
                i3 = 1;
            }
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    @Override // ir.eitaa.ui.Charts.BaseChartView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void drawPickerChart(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Charts.DoubleLinearChartView.drawPickerChart(android.graphics.Canvas):void");
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void drawSelection(Canvas canvas) {
        int i = this.selectedIndex;
        if (i < 0 || !this.legendShowing) {
            return;
        }
        int i2 = (int) (this.chartActiveLineAlpha * this.selectionA);
        float f = this.chartWidth;
        ChartPickerDelegate chartPickerDelegate = this.pickerDelegate;
        float f2 = chartPickerDelegate.pickerEnd;
        float f3 = chartPickerDelegate.pickerStart;
        float f4 = f / (f2 - f3);
        float f5 = (((DoubleLinearChartData) this.chartData).xPercentage[i] * f4) - ((f3 * f4) - BaseChartView.HORIZONTAL_PADDING);
        this.selectedLinePaint.setAlpha(i2);
        canvas.drawLine(f5, 0.0f, f5, this.chartArea.bottom, this.selectedLinePaint);
        this.tmpN = this.lines.size();
        int i3 = 0;
        while (true) {
            this.tmpI = i3;
            int i4 = this.tmpI;
            if (i4 >= this.tmpN) {
                return;
            }
            LineViewData lineViewData = (LineViewData) this.lines.get(i4);
            if (lineViewData.enabled || lineViewData.alpha != 0.0f) {
                float f6 = lineViewData.line.y[this.selectedIndex] * ((DoubleLinearChartData) this.chartData).linesK[this.tmpI];
                float f7 = this.currentMinHeight;
                float measuredHeight = (getMeasuredHeight() - this.chartBottom) - (((f6 - f7) / (this.currentMaxHeight - f7)) * ((getMeasuredHeight() - this.chartBottom) - BaseChartView.SIGNATURE_TEXT_HEIGHT));
                lineViewData.selectionPaint.setAlpha((int) (lineViewData.alpha * 255.0f * this.selectionA));
                this.selectionBackgroundPaint.setAlpha((int) (lineViewData.alpha * 255.0f * this.selectionA));
                canvas.drawPoint(f5, measuredHeight, lineViewData.selectionPaint);
                canvas.drawPoint(f5, measuredHeight, this.selectionBackgroundPaint);
            }
            i3 = this.tmpI + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    @Override // ir.eitaa.ui.Charts.BaseChartView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void drawSignaturesToHorizontalLines(android.graphics.Canvas r18, ir.eitaa.ui.Charts.view_data.ChartHorizontalLinesData r19) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Charts.DoubleLinearChartView.drawSignaturesToHorizontalLines(android.graphics.Canvas, ir.eitaa.ui.Charts.view_data.ChartHorizontalLinesData):void");
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    public LineViewData createLineViewData(ChartData.Line line) {
        return new LineViewData(line);
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    public int findMaxValue(int startXIndex, int endXIndex) {
        if (this.lines.isEmpty()) {
            return 0;
        }
        int size = this.lines.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int iRMaxQ = ((LineViewData) this.lines.get(i2)).enabled ? (int) (((DoubleLinearChartData) this.chartData).lines.get(i2).segmentTree.rMaxQ(startXIndex, endXIndex) * ((DoubleLinearChartData) this.chartData).linesK[i2]) : 0;
            if (iRMaxQ > i) {
                i = iRMaxQ;
            }
        }
        return i;
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    public int findMinValue(int startXIndex, int endXIndex) {
        if (this.lines.isEmpty()) {
            return 0;
        }
        int size = this.lines.size();
        int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
        for (int i2 = 0; i2 < size; i2++) {
            int iRMinQ = ((LineViewData) this.lines.get(i2)).enabled ? (int) (((DoubleLinearChartData) this.chartData).lines.get(i2).segmentTree.rMinQ(startXIndex, endXIndex) * ((DoubleLinearChartData) this.chartData).linesK[i2]) : ConnectionsManager.DEFAULT_DATACENTER_ID;
            if (iRMinQ < i) {
                i = iRMinQ;
            }
        }
        return i;
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected void updatePickerMinMaxHeight() {
        int i;
        if (BaseChartView.ANIMATE_PICKER_SIZES) {
            int i2 = 0;
            if (((LineViewData) this.lines.get(0)).enabled) {
                super.updatePickerMinMaxHeight();
                return;
            }
            Iterator it = this.lines.iterator();
            while (it.hasNext()) {
                LineViewData lineViewData = (LineViewData) it.next();
                if (lineViewData.enabled && (i = lineViewData.line.maxValue) > i2) {
                    i2 = i;
                }
            }
            if (this.lines.size() > 1) {
                i2 = (int) (i2 * ((DoubleLinearChartData) this.chartData).linesK[1]);
            }
            if (i2 > 0) {
                float f = i2;
                if (f != this.animatedToPickerMaxHeight) {
                    this.animatedToPickerMaxHeight = f;
                    Animator animator = this.pickerAnimator;
                    if (animator != null) {
                        animator.cancel();
                    }
                    ValueAnimator valueAnimatorCreateAnimator = createAnimator(this.pickerMaxHeight, this.animatedToPickerMaxHeight, new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Charts.DoubleLinearChartView.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator animation) {
                            DoubleLinearChartView.this.pickerMaxHeight = ((Float) animation.getAnimatedValue()).floatValue();
                            DoubleLinearChartView doubleLinearChartView = DoubleLinearChartView.this;
                            doubleLinearChartView.invalidatePickerChart = true;
                            doubleLinearChartView.invalidate();
                        }
                    });
                    this.pickerAnimator = valueAnimatorCreateAnimator;
                    valueAnimatorCreateAnimator.start();
                }
            }
        }
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected ChartHorizontalLinesData createHorizontalLinesData(int newMaxHeight, int newMinHeight) {
        T t = this.chartData;
        float f = 1.0f;
        if (((DoubleLinearChartData) t).linesK.length >= 2) {
            f = ((DoubleLinearChartData) t).linesK[((DoubleLinearChartData) t).linesK[0] == 1.0f ? (char) 1 : (char) 0];
        }
        return new ChartHorizontalLinesData(newMaxHeight, newMinHeight, this.useMinHeight, f);
    }
}
