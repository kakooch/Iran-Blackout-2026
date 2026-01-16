package org.rbmain.ui.Charts.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.rbmain.messenger.SegmentTree;
import org.rbmain.ui.Charts.data.ChartData;

/* loaded from: classes4.dex */
public class StackLinearChartData extends ChartData {
    public int simplifiedSize;
    public int[][] simplifiedY;
    int[] ySum;

    public StackLinearChartData(JSONObject jSONObject, boolean z) throws JSONException {
        super(jSONObject);
        if (z) {
            long[] jArr = new long[this.lines.size()];
            int[] iArr = new int[this.lines.size()];
            long j = 0;
            for (int i = 0; i < this.lines.size(); i++) {
                int length = this.x.length;
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = this.lines.get(i).y[i2];
                    jArr[i] = jArr[i] + i3;
                    if (i3 == 0) {
                        iArr[i] = iArr[i] + 1;
                    }
                }
                j += jArr[i];
            }
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < this.lines.size(); i4++) {
                double d = jArr[i4];
                double d2 = j;
                Double.isNaN(d);
                Double.isNaN(d2);
                if (d / d2 < 0.01d && iArr[i4] > this.x.length / 2.0f) {
                    arrayList.add(this.lines.get(i4));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.lines.remove((ChartData.Line) it.next());
            }
        }
        int length2 = this.lines.get(0).y.length;
        int size = this.lines.size();
        this.ySum = new int[length2];
        for (int i5 = 0; i5 < length2; i5++) {
            this.ySum[i5] = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int[] iArr2 = this.ySum;
                iArr2[i5] = iArr2[i5] + this.lines.get(i6).y[i5];
            }
        }
        new SegmentTree(this.ySum);
    }

    public StackLinearChartData(ChartData chartData, long j) {
        int iBinarySearch = Arrays.binarySearch(chartData.x, j);
        int length = iBinarySearch - 4;
        int length2 = iBinarySearch + 4;
        if (length < 0) {
            length2 += -length;
            length = 0;
        }
        long[] jArr = chartData.x;
        if (length2 > jArr.length - 1) {
            length -= length2 - jArr.length;
            length2 = jArr.length - 1;
        }
        length = length < 0 ? 0 : length;
        int i = (length2 - length) + 1;
        this.x = new long[i];
        this.xPercentage = new float[i];
        this.lines = new ArrayList<>();
        for (int i2 = 0; i2 < chartData.lines.size(); i2++) {
            ChartData.Line line = new ChartData.Line(this);
            line.y = new int[i];
            line.id = chartData.lines.get(i2).id;
            line.name = chartData.lines.get(i2).name;
            line.colorKey = chartData.lines.get(i2).colorKey;
            line.color = chartData.lines.get(i2).color;
            line.colorDark = chartData.lines.get(i2).colorDark;
            this.lines.add(line);
        }
        int i3 = 0;
        while (length <= length2) {
            this.x[i3] = chartData.x[length];
            for (int i4 = 0; i4 < this.lines.size(); i4++) {
                this.lines.get(i4).y[i3] = chartData.lines.get(i4).y[length];
            }
            i3++;
            length++;
        }
        this.timeStep = 86400000L;
        measure();
    }

    @Override // org.rbmain.ui.Charts.data.ChartData
    protected void measure() {
        super.measure();
        this.simplifiedSize = 0;
        int length = this.xPercentage.length;
        int size = this.lines.size();
        int iMax = Math.max(1, Math.round(length / 140.0f));
        int i = length / iMax;
        this.simplifiedY = (int[][]) Array.newInstance((Class<?>) int.class, size, i);
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < size; i3++) {
                int[] iArr2 = this.lines.get(i3).y;
                if (iArr2[i2] > iArr[i3]) {
                    iArr[i3] = iArr2[i2];
                }
            }
            if (i2 % iMax == 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    this.simplifiedY[i4][this.simplifiedSize] = iArr[i4];
                    iArr[i4] = 0;
                }
                int i5 = this.simplifiedSize + 1;
                this.simplifiedSize = i5;
                if (i5 >= i) {
                    return;
                }
            }
        }
    }
}
