package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class PercentFormatter extends ValueFormatter {
    private PieChart a;
    public DecimalFormat mFormat;

    public PercentFormatter() {
        this.mFormat = new DecimalFormat("###,###,##0.0");
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        return this.mFormat.format(f) + " %";
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getPieLabel(float f, PieEntry pieEntry) {
        PieChart pieChart = this.a;
        return (pieChart == null || !pieChart.isUsePercentValuesEnabled()) ? this.mFormat.format(f) : getFormattedValue(f);
    }

    public PercentFormatter(PieChart pieChart) {
        this();
        this.a = pieChart;
    }
}
