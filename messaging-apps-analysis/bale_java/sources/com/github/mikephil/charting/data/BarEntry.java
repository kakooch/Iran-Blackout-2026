package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.highlight.Range;

/* loaded from: classes2.dex */
public class BarEntry extends Entry {
    private float[] e;
    private Range[] f;
    private float g;
    private float h;

    public BarEntry(float f, float f2) {
        super(f, f2);
    }

    private void a() {
        float[] fArr = this.e;
        if (fArr == null) {
            this.g = 0.0f;
            this.h = 0.0f;
            return;
        }
        float fAbs = 0.0f;
        float f = 0.0f;
        for (float f2 : fArr) {
            if (f2 <= 0.0f) {
                fAbs += Math.abs(f2);
            } else {
                f += f2;
            }
        }
        this.g = fAbs;
        this.h = f;
    }

    private static float b(float[] fArr) {
        float f = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    protected void calcRanges() {
        float[] yVals = getYVals();
        if (yVals == null || yVals.length == 0) {
            return;
        }
        this.f = new Range[yVals.length];
        float f = -getNegativeSum();
        int i = 0;
        float f2 = 0.0f;
        while (true) {
            Range[] rangeArr = this.f;
            if (i >= rangeArr.length) {
                return;
            }
            float f3 = yVals[i];
            if (f3 < 0.0f) {
                float f4 = f - f3;
                rangeArr[i] = new Range(f, f4);
                f = f4;
            } else {
                float f5 = f3 + f2;
                rangeArr[i] = new Range(f2, f5);
                f2 = f5;
            }
            i++;
        }
    }

    @Deprecated
    public float getBelowSum(int i) {
        return getSumBelow(i);
    }

    public float getNegativeSum() {
        return this.g;
    }

    public float getPositiveSum() {
        return this.h;
    }

    public Range[] getRanges() {
        return this.f;
    }

    public float getSumBelow(int i) {
        float[] fArr = this.e;
        float f = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (int length = fArr.length - 1; length > i && length >= 0; length--) {
            f += this.e[length];
        }
        return f;
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    public float[] getYVals() {
        return this.e;
    }

    public boolean isStacked() {
        return this.e != null;
    }

    public void setVals(float[] fArr) {
        setY(b(fArr));
        this.e = fArr;
        a();
        calcRanges();
    }

    public BarEntry(float f, float f2, Object obj) {
        super(f, f2, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getX(), getY(), getData());
        barEntry.setVals(this.e);
        return barEntry;
    }

    public BarEntry(float f, float f2, Drawable drawable) {
        super(f, f2, drawable);
    }

    public BarEntry(float f, float f2, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
    }

    public BarEntry(float f, float[] fArr) {
        super(f, b(fArr));
        this.e = fArr;
        a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Object obj) {
        super(f, b(fArr), obj);
        this.e = fArr;
        a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Drawable drawable) {
        super(f, b(fArr), drawable);
        this.e = fArr;
        a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Drawable drawable, Object obj) {
        super(f, b(fArr), drawable, obj);
        this.e = fArr;
        a();
        calcRanges();
    }
}
