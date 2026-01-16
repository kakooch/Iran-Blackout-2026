package ir.eitaa.ui.Charts.view_data;

import android.graphics.Paint;
import ir.eitaa.ui.Charts.BaseChartView;
import ir.eitaa.ui.Charts.data.ChartData;

/* loaded from: classes3.dex */
public class StackLinearViewData extends LineViewData {
    public StackLinearViewData(ChartData.Line line) {
        super(line);
        this.paint.setStyle(Paint.Style.FILL);
        if (BaseChartView.USE_LINES) {
            this.paint.setAntiAlias(false);
        }
    }
}
