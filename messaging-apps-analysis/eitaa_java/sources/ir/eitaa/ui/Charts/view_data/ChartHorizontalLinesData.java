package ir.eitaa.ui.Charts.view_data;

/* loaded from: classes3.dex */
public class ChartHorizontalLinesData {
    public int alpha;
    public int fixedAlpha;
    public int[] values;
    public String[] valuesStr;
    public String[] valuesStr2;

    public ChartHorizontalLinesData(int newMaxHeight, int newMinHeight, boolean useMinHeight) {
        this(newMaxHeight, newMinHeight, useMinHeight, 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ChartHorizontalLinesData(int r8, int r9, boolean r10, float r11) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Charts.view_data.ChartHorizontalLinesData.<init>(int, int, boolean, float):void");
    }

    public static int lookupHeight(int maxValue) {
        if (maxValue > 100) {
            maxValue = round(maxValue);
        }
        return ((int) Math.ceil(maxValue / 5.0f)) * 5;
    }

    private static int round(int maxValue) {
        return ((float) (maxValue / 5)) % 10.0f == 0.0f ? maxValue : ((maxValue / 10) + 1) * 10;
    }
}
