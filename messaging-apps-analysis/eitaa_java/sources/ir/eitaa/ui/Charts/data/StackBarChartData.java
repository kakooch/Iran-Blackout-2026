package ir.eitaa.ui.Charts.data;

import ir.eitaa.messenger.SegmentTree;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class StackBarChartData extends ChartData {
    public int[] ySum;
    public SegmentTree ySumSegmentTree;

    public StackBarChartData(JSONObject jsonObject) throws JSONException {
        super(jsonObject);
        init();
    }

    public void init() {
        int length = this.lines.get(0).y.length;
        int size = this.lines.size();
        this.ySum = new int[length];
        for (int i = 0; i < length; i++) {
            this.ySum[i] = 0;
            for (int i2 = 0; i2 < size; i2++) {
                int[] iArr = this.ySum;
                iArr[i] = iArr[i] + this.lines.get(i2).y[i];
            }
        }
        this.ySumSegmentTree = new SegmentTree(this.ySum);
    }

    public int findMax(int start, int end) {
        return this.ySumSegmentTree.rMaxQ(start, end);
    }
}
