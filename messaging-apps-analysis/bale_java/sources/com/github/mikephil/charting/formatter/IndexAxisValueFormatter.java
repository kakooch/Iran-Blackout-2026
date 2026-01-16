package com.github.mikephil.charting.formatter;

import java.util.Collection;

/* loaded from: classes2.dex */
public class IndexAxisValueFormatter extends ValueFormatter {
    private String[] a;
    private int b;

    public IndexAxisValueFormatter() {
        this.a = new String[0];
        this.b = 0;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        int iRound = Math.round(f);
        return (iRound < 0 || iRound >= this.b || iRound != ((int) f)) ? "" : this.a[iRound];
    }

    public String[] getValues() {
        return this.a;
    }

    public void setValues(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.a = strArr;
        this.b = strArr.length;
    }

    public IndexAxisValueFormatter(String[] strArr) {
        this.a = new String[0];
        this.b = 0;
        if (strArr != null) {
            setValues(strArr);
        }
    }

    public IndexAxisValueFormatter(Collection<String> collection) {
        this.a = new String[0];
        this.b = 0;
        if (collection != null) {
            setValues((String[]) collection.toArray(new String[collection.size()]));
        }
    }
}
