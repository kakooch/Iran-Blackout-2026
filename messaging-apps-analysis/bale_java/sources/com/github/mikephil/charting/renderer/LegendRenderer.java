package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class LegendRenderer extends Renderer {
    private Path a;
    protected List<LegendEntry> computedEntries;
    protected Paint.FontMetrics legendFontMetrics;
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            d = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            c = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            b = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            a = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.computedEntries = new ArrayList(16);
        this.legendFontMetrics = new Paint.FontMetrics();
        this.a = new Path();
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void computeLegend(com.github.mikephil.charting.data.ChartData<?> r19) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.computeLegend(com.github.mikephil.charting.data.ChartData):void");
    }

    protected void drawForm(Canvas canvas, float f, float f2, LegendEntry legendEntry, Legend legend) {
        int i = legendEntry.formColor;
        if (i == 1122868 || i == 1122867 || i == 0) {
            return;
        }
        int iSave = canvas.save();
        Legend.LegendForm form = legendEntry.form;
        if (form == Legend.LegendForm.DEFAULT) {
            form = legend.getForm();
        }
        this.mLegendFormPaint.setColor(legendEntry.formColor);
        float fConvertDpToPixel = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? legend.getFormSize() : legendEntry.formSize);
        float f3 = fConvertDpToPixel / 2.0f;
        int i2 = a.d[form.ordinal()];
        if (i2 == 3 || i2 == 4) {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f + f3, f2, f3, this.mLegendFormPaint);
        } else if (i2 == 5) {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, f2 - f3, f + fConvertDpToPixel, f2 + f3, this.mLegendFormPaint);
        } else if (i2 == 6) {
            float fConvertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formLineWidth) ? legend.getFormLineWidth() : legendEntry.formLineWidth);
            DashPathEffect formLineDashEffect = legendEntry.formLineDashEffect;
            if (formLineDashEffect == null) {
                formLineDashEffect = legend.getFormLineDashEffect();
            }
            this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
            this.mLegendFormPaint.setStrokeWidth(fConvertDpToPixel2);
            this.mLegendFormPaint.setPathEffect(formLineDashEffect);
            this.a.reset();
            this.a.moveTo(f, f2);
            this.a.lineTo(f + fConvertDpToPixel, f2);
            canvas.drawPath(this.a, this.mLegendFormPaint);
        }
        canvas.restoreToCount(iSave);
    }

    protected void drawLabel(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.mLegendLabelPaint);
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public void renderLegend(Canvas canvas) {
        float f;
        float f2;
        float chartWidth;
        float f3;
        float f4;
        List<Boolean> list;
        List<FSize> list2;
        int i;
        float f5;
        float f6;
        float f7;
        float f8;
        float fContentTop;
        float f9;
        float f10;
        float f11;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        float fCalcTextWidth;
        double d;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float fCalcTextHeight = lineHeight - (Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float fConvertDpToPixel = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float fConvertDpToPixel2 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float fConvertDpToPixel3 = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float fConvertDpToPixel4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            int i2 = a.a[horizontalAlignment.ordinal()];
            float f12 = fConvertDpToPixel4;
            float f13 = fConvertDpToPixel2;
            if (i2 == 1) {
                f = lineHeight;
                f2 = lineSpacing;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                chartWidth = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? xOffset + this.mLegend.mNeededWidth : xOffset;
            } else if (i2 == 2) {
                f = lineHeight;
                f2 = lineSpacing;
                chartWidth = (orientation == Legend.LegendOrientation.VERTICAL ? this.mViewPortHandler.getChartWidth() : this.mViewPortHandler.contentRight()) - xOffset;
                if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    chartWidth -= this.mLegend.mNeededWidth;
                }
            } else if (i2 != 3) {
                f = lineHeight;
                f2 = lineSpacing;
                chartWidth = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                float chartWidth2 = orientation == legendOrientation ? this.mViewPortHandler.getChartWidth() / 2.0f : this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f2 = lineSpacing;
                chartWidth = chartWidth2 + (direction == legendDirection2 ? xOffset : -xOffset);
                if (orientation == legendOrientation) {
                    double d2 = chartWidth;
                    if (direction == legendDirection2) {
                        f = lineHeight;
                        d = ((-this.mLegend.mNeededWidth) / 2.0d) + xOffset;
                    } else {
                        f = lineHeight;
                        d = (this.mLegend.mNeededWidth / 2.0d) - xOffset;
                    }
                    chartWidth = (float) (d2 + d);
                } else {
                    f = lineHeight;
                }
            }
            int i3 = a.c[orientation.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                int i4 = a.b[verticalAlignment.ordinal()];
                if (i4 == 1) {
                    fContentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.mViewPortHandler.contentTop()) + yOffset;
                } else if (i4 == 2) {
                    fContentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? this.mViewPortHandler.getChartHeight() : this.mViewPortHandler.contentBottom()) - (this.mLegend.mNeededHeight + yOffset);
                } else if (i4 != 3) {
                    fContentTop = 0.0f;
                } else {
                    float chartHeight = this.mViewPortHandler.getChartHeight() / 2.0f;
                    Legend legend = this.mLegend;
                    fContentTop = (chartHeight - (legend.mNeededHeight / 2.0f)) + legend.getYOffset();
                }
                float f14 = fContentTop;
                float f15 = 0.0f;
                boolean z = false;
                int i5 = 0;
                while (i5 < entries.length) {
                    LegendEntry legendEntry2 = entries[i5];
                    boolean z2 = legendEntry2.form != Legend.LegendForm.NONE;
                    float fConvertDpToPixel5 = Float.isNaN(legendEntry2.formSize) ? fConvertDpToPixel3 : Utils.convertDpToPixel(legendEntry2.formSize);
                    if (z2) {
                        Legend.LegendDirection legendDirection3 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        fCalcTextWidth = direction == legendDirection3 ? chartWidth + f15 : chartWidth - (fConvertDpToPixel5 - f15);
                        f10 = fCalcTextHeight;
                        f11 = f12;
                        f9 = chartWidth;
                        legendDirection = direction;
                        drawForm(canvas, fCalcTextWidth, f14 + fCalcTextHeight, legendEntry2, this.mLegend);
                        if (legendDirection == legendDirection3) {
                            fCalcTextWidth += fConvertDpToPixel5;
                        }
                        legendEntry = legendEntry2;
                    } else {
                        f9 = chartWidth;
                        f10 = fCalcTextHeight;
                        f11 = f12;
                        legendDirection = direction;
                        legendEntry = legendEntry2;
                        fCalcTextWidth = f9;
                    }
                    if (legendEntry.label != null) {
                        if (z2 && !z) {
                            fCalcTextWidth += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? fConvertDpToPixel : -fConvertDpToPixel;
                        } else if (z) {
                            fCalcTextWidth = f9;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fCalcTextWidth -= Utils.calcTextWidth(this.mLegendLabelPaint, r1);
                        }
                        float f16 = fCalcTextWidth;
                        if (z) {
                            f14 += f + f2;
                            drawLabel(canvas, f16, f14 + f, legendEntry.label);
                        } else {
                            drawLabel(canvas, f16, f14 + f, legendEntry.label);
                        }
                        f14 += f + f2;
                        f15 = 0.0f;
                    } else {
                        f15 += fConvertDpToPixel5 + f11;
                        z = true;
                    }
                    i5++;
                    direction = legendDirection;
                    f12 = f11;
                    fCalcTextHeight = f10;
                    chartWidth = f9;
                }
                return;
            }
            float f17 = chartWidth;
            float f18 = f12;
            List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
            List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
            List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
            int i6 = a.b[verticalAlignment.ordinal()];
            if (i6 != 1) {
                yOffset = i6 != 2 ? i6 != 3 ? 0.0f : yOffset + ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f) : (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
            }
            int length = entries.length;
            float f19 = f17;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length) {
                float f20 = f18;
                LegendEntry legendEntry3 = entries[i7];
                float f21 = f19;
                int i9 = length;
                boolean z3 = legendEntry3.form != Legend.LegendForm.NONE;
                float fConvertDpToPixel6 = Float.isNaN(legendEntry3.formSize) ? fConvertDpToPixel3 : Utils.convertDpToPixel(legendEntry3.formSize);
                if (i7 >= calculatedLabelBreakPoints.size() || !calculatedLabelBreakPoints.get(i7).booleanValue()) {
                    f3 = f21;
                    f4 = yOffset;
                } else {
                    f4 = yOffset + f + f2;
                    f3 = f17;
                }
                if (f3 == f17 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i8 < calculatedLineSizes.size()) {
                    f3 += (direction == Legend.LegendDirection.RIGHT_TO_LEFT ? calculatedLineSizes.get(i8).width : -calculatedLineSizes.get(i8).width) / 2.0f;
                    i8++;
                }
                int i10 = i8;
                boolean z4 = legendEntry3.label == null;
                if (z3) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f3 -= fConvertDpToPixel6;
                    }
                    float f22 = f3;
                    list2 = calculatedLineSizes;
                    i = i7;
                    list = calculatedLabelBreakPoints;
                    drawForm(canvas, f22, f4 + fCalcTextHeight, legendEntry3, this.mLegend);
                    f3 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f22 + fConvertDpToPixel6 : f22;
                } else {
                    list = calculatedLabelBreakPoints;
                    list2 = calculatedLineSizes;
                    i = i7;
                }
                if (z4) {
                    f5 = f13;
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f6 = f20;
                        f7 = -f6;
                    } else {
                        f6 = f20;
                        f7 = f6;
                    }
                    f19 = f3 + f7;
                } else {
                    if (z3) {
                        f3 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -fConvertDpToPixel : fConvertDpToPixel;
                    }
                    Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                    if (direction == legendDirection4) {
                        f3 -= calculatedLabelSizes.get(i).width;
                    }
                    drawLabel(canvas, f3, f4 + f, legendEntry3.label);
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f3 += calculatedLabelSizes.get(i).width;
                    }
                    if (direction == legendDirection4) {
                        f5 = f13;
                        f8 = -f5;
                    } else {
                        f5 = f13;
                        f8 = f5;
                    }
                    f19 = f3 + f8;
                    f6 = f20;
                }
                f13 = f5;
                f18 = f6;
                i7 = i + 1;
                yOffset = f4;
                length = i9;
                i8 = i10;
                calculatedLineSizes = list2;
                calculatedLabelBreakPoints = list;
            }
        }
    }
}
