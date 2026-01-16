package com.github.mikephil.charting.formatter;

import android.gov.nist.core.Separators;
import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class DefaultValueFormatter extends ValueFormatter {
    protected int mDecimalDigits;
    protected DecimalFormat mFormat;

    public DefaultValueFormatter(int i) {
        setup(i);
    }

    public int getDecimalDigits() {
        return this.mDecimalDigits;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        return this.mFormat.format(f);
    }

    public void setup(int i) {
        this.mDecimalDigits = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(Separators.DOT);
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
