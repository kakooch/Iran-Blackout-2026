package org.rbmain.ui.Charts;

import android.animation.Animator;
import org.rbmain.ui.Charts.data.ChartData;
import org.rbmain.ui.Charts.view_data.StackLinearViewData;

/* loaded from: classes4.dex */
public class PieChartViewData extends StackLinearViewData {
    Animator animator;
    float drawingPart;
    float selectionA;

    public PieChartViewData(ChartData.Line line) {
        super(line);
    }
}
