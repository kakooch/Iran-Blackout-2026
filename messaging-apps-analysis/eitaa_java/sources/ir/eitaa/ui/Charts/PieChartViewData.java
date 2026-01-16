package ir.eitaa.ui.Charts;

import android.animation.Animator;
import ir.eitaa.ui.Charts.data.ChartData;
import ir.eitaa.ui.Charts.view_data.StackLinearViewData;

/* loaded from: classes3.dex */
public class PieChartViewData extends StackLinearViewData {
    Animator animator;
    float drawingPart;
    float selectionA;

    public PieChartViewData(ChartData.Line line) {
        super(line);
    }
}
