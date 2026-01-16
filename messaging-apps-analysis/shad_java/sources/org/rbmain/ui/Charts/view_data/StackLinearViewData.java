package org.rbmain.ui.Charts.view_data;

import android.graphics.Paint;
import org.rbmain.ui.Charts.BaseChartView;
import org.rbmain.ui.Charts.data.ChartData;

/* loaded from: classes4.dex */
public class StackLinearViewData extends LineViewData {
    public StackLinearViewData(ChartData.Line line) {
        super(line);
        this.paint.setStyle(Paint.Style.FILL);
        if (BaseChartView.USE_LINES) {
            this.paint.setAntiAlias(false);
        }
    }
}
