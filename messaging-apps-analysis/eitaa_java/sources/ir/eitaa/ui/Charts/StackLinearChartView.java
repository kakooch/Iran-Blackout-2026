package ir.eitaa.ui.Charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.Charts.data.ChartData;
import ir.eitaa.ui.Charts.data.StackLinearChartData;
import ir.eitaa.ui.Charts.view_data.StackLinearViewData;

/* loaded from: classes3.dex */
public class StackLinearChartView<T extends StackLinearViewData> extends BaseChartView<StackLinearChartData, T> {
    private float[] mapPoints;
    private Matrix matrix;
    Path ovalPath;
    boolean[] skipPoints;
    float[] startFromY;

    @Override // ir.eitaa.ui.Charts.BaseChartView
    public int findMaxValue(int startXIndex, int endXIndex) {
        return 100;
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    protected float getMinDistance() {
        return 0.1f;
    }

    public StackLinearChartView(Context context) {
        super(context);
        this.matrix = new Matrix();
        this.mapPoints = new float[2];
        this.ovalPath = new Path();
        this.superDraw = true;
        this.useAlphaSignature = true;
        this.drawPointOnSelection = false;
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView
    public T createLineViewData(ChartData.Line line) {
        return (T) new StackLinearViewData(line);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0254  */
    @Override // ir.eitaa.ui.Charts.BaseChartView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void drawChart(android.graphics.Canvas r36) {
        /*
            Method dump skipped, instructions count: 1574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Charts.StackLinearChartView.drawChart(android.graphics.Canvas):void");
    }

    private int quarterForPoint(float x, float y) {
        float fCenterX = this.chartArea.centerX();
        float fCenterY = this.chartArea.centerY() + AndroidUtilities.dp(16.0f);
        if (x >= fCenterX && y <= fCenterY) {
            return 0;
        }
        if (x < fCenterX || y < fCenterY) {
            return (x >= fCenterX || y < fCenterY) ? 3 : 2;
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015e  */
    @Override // ir.eitaa.ui.Charts.BaseChartView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void drawPickerChart(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Charts.StackLinearChartView.drawPickerChart(android.graphics.Canvas):void");
    }

    @Override // ir.eitaa.ui.Charts.BaseChartView, android.view.View
    protected void onDraw(Canvas canvas) {
        tick();
        drawChart(canvas);
        drawBottomLine(canvas);
        this.tmpN = this.horizontalLines.size();
        int i = 0;
        while (true) {
            this.tmpI = i;
            int i2 = this.tmpI;
            if (i2 < this.tmpN) {
                drawHorizontalLines(canvas, this.horizontalLines.get(i2));
                drawSignaturesToHorizontalLines(canvas, this.horizontalLines.get(this.tmpI));
                i = this.tmpI + 1;
            } else {
                drawBottomSignature(canvas);
                drawPicker(canvas);
                drawSelection(canvas);
                super.onDraw(canvas);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0140  */
    @Override // ir.eitaa.ui.Charts.BaseChartView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void fillTransitionParams(ir.eitaa.ui.Charts.view_data.TransitionParams r18) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Charts.StackLinearChartView.fillTransitionParams(ir.eitaa.ui.Charts.view_data.TransitionParams):void");
    }
}
