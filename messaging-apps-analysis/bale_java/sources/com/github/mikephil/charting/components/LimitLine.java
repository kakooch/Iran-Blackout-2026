package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes2.dex */
public class LimitLine extends ComponentBase {
    private float a;
    private float b;
    private int c;
    private Paint.Style d;
    private String e;
    private DashPathEffect f;
    private LimitLabelPosition g;

    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public LimitLine(float f) {
        this.a = 0.0f;
        this.b = 2.0f;
        this.c = Color.rgb(237, 91, 91);
        this.d = Paint.Style.FILL_AND_STROKE;
        this.e = "";
        this.f = null;
        this.g = LimitLabelPosition.RIGHT_TOP;
        this.a = f;
    }

    public void disableDashedLine() {
        this.f = null;
    }

    public void enableDashedLine(float f, float f2, float f3) {
        this.f = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public DashPathEffect getDashPathEffect() {
        return this.f;
    }

    public String getLabel() {
        return this.e;
    }

    public LimitLabelPosition getLabelPosition() {
        return this.g;
    }

    public float getLimit() {
        return this.a;
    }

    public int getLineColor() {
        return this.c;
    }

    public float getLineWidth() {
        return this.b;
    }

    public Paint.Style getTextStyle() {
        return this.d;
    }

    public boolean isDashedLineEnabled() {
        return this.f != null;
    }

    public void setLabel(String str) {
        this.e = str;
    }

    public void setLabelPosition(LimitLabelPosition limitLabelPosition) {
        this.g = limitLabelPosition;
    }

    public void setLineColor(int i) {
        this.c = i;
    }

    public void setLineWidth(float f) {
        if (f < 0.2f) {
            f = 0.2f;
        }
        if (f > 12.0f) {
            f = 12.0f;
        }
        this.b = Utils.convertDpToPixel(f);
    }

    public void setTextStyle(Paint.Style style) {
        this.d = style;
    }

    public LimitLine(float f, String str) {
        this.a = 0.0f;
        this.b = 2.0f;
        this.c = Color.rgb(237, 91, 91);
        this.d = Paint.Style.FILL_AND_STROKE;
        this.e = "";
        this.f = null;
        this.g = LimitLabelPosition.RIGHT_TOP;
        this.a = f;
        this.e = str;
    }
}
