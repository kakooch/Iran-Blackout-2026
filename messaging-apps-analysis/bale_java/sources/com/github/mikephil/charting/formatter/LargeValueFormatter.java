package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class LargeValueFormatter extends ValueFormatter {
    private String[] a;
    private int b;
    private DecimalFormat c;
    private String d;

    public LargeValueFormatter() {
        this.a = new String[]{"", "k", "m", "b", "t"};
        this.b = 5;
        this.d = "";
        this.c = new DecimalFormat("###E00");
    }

    private String a(double d) {
        String str = this.c.format(d);
        int numericValue = Character.getNumericValue(str.charAt(str.length() - 1));
        String strReplaceAll = str.replaceAll("E[0-9][0-9]", this.a[Integer.valueOf(Character.getNumericValue(str.charAt(str.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (strReplaceAll.length() <= this.b && !strReplaceAll.matches("[0-9]+\\.[a-z]")) {
                return strReplaceAll;
            }
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 2) + strReplaceAll.substring(strReplaceAll.length() - 1);
        }
    }

    public int getDecimalDigits() {
        return 0;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        return a(f) + this.d;
    }

    public void setAppendix(String str) {
        this.d = str;
    }

    public void setMaxLength(int i) {
        this.b = i;
    }

    public void setSuffix(String[] strArr) {
        this.a = strArr;
    }

    public LargeValueFormatter(String str) {
        this();
        this.d = str;
    }
}
