package com.github.mikephil.charting.formatter;

import android.gov.nist.core.Separators;
import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class StackedValueFormatter extends ValueFormatter {
    private boolean a;
    private String b;
    private DecimalFormat c;

    public StackedValueFormatter(boolean z, String str, int i) {
        this.a = z;
        this.b = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(Separators.DOT);
            }
            stringBuffer.append("0");
        }
        this.c = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getBarStackedLabel(float f, BarEntry barEntry) {
        float[] yVals;
        if (this.a || (yVals = barEntry.getYVals()) == null) {
            return this.c.format(f) + this.b;
        }
        if (yVals[yVals.length - 1] != f) {
            return "";
        }
        return this.c.format(barEntry.getY()) + this.b;
    }
}
