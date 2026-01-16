package ir.eitaa.ui.Charts.data;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.SegmentTree;
import ir.eitaa.tgnet.ConnectionsManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ChartData {
    public String[] daysLookup;
    public ArrayList<Line> lines = new ArrayList<>();
    public int maxValue = 0;
    public int minValue = ConnectionsManager.DEFAULT_DATACENTER_ID;
    public float oneDayPercentage = 0.0f;
    protected long timeStep;
    public long[] x;
    public float[] xPercentage;

    protected ChartData() {
    }

    public ChartData(JSONObject jsonObject) throws JSONException {
        JSONArray jSONArray = jsonObject.getJSONArray("columns");
        jSONArray.length();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            if (jSONArray2.getString(0).equals("x")) {
                int length = jSONArray2.length() - 1;
                this.x = new long[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    this.x[i2] = jSONArray2.getLong(i3);
                    i2 = i3;
                }
            } else {
                Line line = new Line();
                this.lines.add(line);
                int length2 = jSONArray2.length() - 1;
                line.id = jSONArray2.getString(0);
                line.y = new int[length2];
                int i4 = 0;
                while (i4 < length2) {
                    int i5 = i4 + 1;
                    line.y[i4] = jSONArray2.getInt(i5);
                    int[] iArr = line.y;
                    if (iArr[i4] > line.maxValue) {
                        line.maxValue = iArr[i4];
                    }
                    if (iArr[i4] < line.minValue) {
                        line.minValue = iArr[i4];
                    }
                    i4 = i5;
                }
            }
            long[] jArr = this.x;
            if (jArr.length > 1) {
                this.timeStep = jArr[1] - jArr[0];
            } else {
                this.timeStep = 86400000L;
            }
            measure();
        }
        JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("colors");
        JSONObject jSONObjectOptJSONObject2 = jsonObject.optJSONObject("names");
        Pattern patternCompile = Pattern.compile("(.*)(#.*)");
        for (int i6 = 0; i6 < this.lines.size(); i6++) {
            Line line2 = this.lines.get(i6);
            if (jSONObjectOptJSONObject != null) {
                Matcher matcher = patternCompile.matcher(jSONObjectOptJSONObject.getString(line2.id));
                if (matcher.matches()) {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        line2.colorKey = "statisticChartLine_" + matcher.group(1).toLowerCase();
                    }
                    int color = Color.parseColor(matcher.group(2));
                    line2.color = color;
                    line2.colorDark = ColorUtils.blendARGB(-1, color, 0.85f);
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                line2.name = jSONObjectOptJSONObject2.getString(line2.id);
            }
        }
    }

    protected void measure() {
        SimpleDateFormat simpleDateFormat;
        long[] jArr = this.x;
        int length = jArr.length;
        if (length == 0) {
            return;
        }
        long j = jArr[0];
        long j2 = jArr[length - 1];
        float[] fArr = new float[length];
        this.xPercentage = fArr;
        if (length == 1) {
            fArr[0] = 1.0f;
        } else {
            for (int i = 0; i < length; i++) {
                this.xPercentage[i] = (this.x[i] - j) / (j2 - j);
            }
        }
        for (int i2 = 0; i2 < this.lines.size(); i2++) {
            if (this.lines.get(i2).maxValue > this.maxValue) {
                this.maxValue = this.lines.get(i2).maxValue;
            }
            if (this.lines.get(i2).minValue < this.minValue) {
                this.minValue = this.lines.get(i2).minValue;
            }
            this.lines.get(i2).segmentTree = new SegmentTree(this.lines.get(i2).y);
        }
        long j3 = this.timeStep;
        this.daysLookup = new String[((int) ((j2 - j) / j3)) + 10];
        if (j3 == 1) {
            simpleDateFormat = null;
        } else if (j3 < 86400000) {
            simpleDateFormat = new SimpleDateFormat("HH:mm");
        } else {
            simpleDateFormat = new SimpleDateFormat("MMM d");
        }
        int i3 = 0;
        while (true) {
            String[] strArr = this.daysLookup;
            if (i3 >= strArr.length) {
                float f = this.timeStep;
                long[] jArr2 = this.x;
                this.oneDayPercentage = f / (jArr2[jArr2.length - 1] - jArr2[0]);
                return;
            } else {
                if (this.timeStep == 1) {
                    strArr[i3] = String.format(Locale.ENGLISH, "%02d:00", Integer.valueOf(i3));
                } else {
                    strArr[i3] = simpleDateFormat.format(new Date((i3 * this.timeStep) + j));
                }
                i3++;
            }
        }
    }

    public String getDayString(int i) {
        String[] strArr = this.daysLookup;
        long[] jArr = this.x;
        return strArr[(int) ((jArr[i] - jArr[0]) / this.timeStep)];
    }

    public int findStartIndex(float v) {
        int length;
        int i = 0;
        if (v == 0.0f || (length = this.xPercentage.length) < 2) {
            return 0;
        }
        int i2 = length - 1;
        while (i <= i2) {
            int i3 = (i2 + i) >> 1;
            float[] fArr = this.xPercentage;
            if ((v < fArr[i3] && (i3 == 0 || v > fArr[i3 - 1])) || v == fArr[i3]) {
                return i3;
            }
            if (v < fArr[i3]) {
                i2 = i3 - 1;
            } else if (v > fArr[i3]) {
                i = i3 + 1;
            }
        }
        return i;
    }

    public int findEndIndex(int left, float v) {
        int length = this.xPercentage.length;
        if (v == 1.0f) {
            return length - 1;
        }
        int i = length - 1;
        int i2 = i;
        while (left <= i2) {
            int i3 = (i2 + left) >> 1;
            float[] fArr = this.xPercentage;
            if ((v > fArr[i3] && (i3 == i || v < fArr[i3 + 1])) || v == fArr[i3]) {
                return i3;
            }
            if (v < fArr[i3]) {
                i2 = i3 - 1;
            } else if (v > fArr[i3]) {
                left = i3 + 1;
            }
        }
        return i2;
    }

    public int findIndex(int left, int right, float v) {
        float[] fArr = this.xPercentage;
        int length = fArr.length;
        if (v <= fArr[left]) {
            return left;
        }
        if (v >= fArr[right]) {
            return right;
        }
        while (left <= right) {
            int i = (right + left) >> 1;
            float[] fArr2 = this.xPercentage;
            if ((v > fArr2[i] && (i == length - 1 || v < fArr2[i + 1])) || v == fArr2[i]) {
                return i;
            }
            if (v < fArr2[i]) {
                right = i - 1;
            } else if (v > fArr2[i]) {
                left = i + 1;
            }
        }
        return right;
    }

    public class Line {
        public String colorKey;
        public String id;
        public String name;
        public SegmentTree segmentTree;
        public int[] y;
        public int maxValue = 0;
        public int minValue = ConnectionsManager.DEFAULT_DATACENTER_ID;
        public int color = -16777216;
        public int colorDark = -1;

        public Line() {
        }
    }
}
