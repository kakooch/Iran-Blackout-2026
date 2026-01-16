package com.github.mikephil.charting.data;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
    private int f;
    private int g;
    private float h;
    private int i;
    private int j;
    private int k;
    private String[] l;

    public BarDataSet(List<BarEntry> list, String str) {
        super(list, str);
        this.f = 1;
        this.g = Color.rgb(215, 215, 215);
        this.h = 0.0f;
        this.i = -16777216;
        this.j = SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
        this.k = 0;
        this.l = new String[]{"Stack"};
        this.mHighLightColor = Color.rgb(0, 0, 0);
        b(list);
        a(list);
    }

    private void a(List list) {
        this.k = 0;
        for (int i = 0; i < list.size(); i++) {
            float[] yVals = ((BarEntry) list.get(i)).getYVals();
            if (yVals == null) {
                this.k++;
            } else {
                this.k += yVals.length;
            }
        }
    }

    private void b(List list) {
        for (int i = 0; i < list.size(); i++) {
            float[] yVals = ((BarEntry) list.get(i)).getYVals();
            if (yVals != null && yVals.length > this.f) {
                this.f = yVals.length;
            }
        }
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BarEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((BarEntry) this.mValues.get(i)).copy());
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, getLabel());
        copy(barDataSet);
        return barDataSet;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getBarBorderColor() {
        return this.i;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public float getBarBorderWidth() {
        return this.h;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getBarShadowColor() {
        return this.g;
    }

    public int getEntryCountStacks() {
        return this.k;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getHighLightAlpha() {
        return this.j;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public String[] getStackLabels() {
        return this.l;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getStackSize() {
        return this.f;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public boolean isStacked() {
        return this.f > 1;
    }

    public void setBarBorderColor(int i) {
        this.i = i;
    }

    public void setBarBorderWidth(float f) {
        this.h = f;
    }

    public void setBarShadowColor(int i) {
        this.g = i;
    }

    public void setHighLightAlpha(int i) {
        this.j = i;
    }

    public void setStackLabels(String[] strArr) {
        this.l = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public void calcMinMax(BarEntry barEntry) {
        if (barEntry == null || Float.isNaN(barEntry.getY())) {
            return;
        }
        if (barEntry.getYVals() == null) {
            if (barEntry.getY() < this.mYMin) {
                this.mYMin = barEntry.getY();
            }
            if (barEntry.getY() > this.mYMax) {
                this.mYMax = barEntry.getY();
            }
        } else {
            if ((-barEntry.getNegativeSum()) < this.mYMin) {
                this.mYMin = -barEntry.getNegativeSum();
            }
            if (barEntry.getPositiveSum() > this.mYMax) {
                this.mYMax = barEntry.getPositiveSum();
            }
        }
        calcMinMaxX(barEntry);
    }

    protected void copy(BarDataSet barDataSet) {
        super.copy((BarLineScatterCandleBubbleDataSet) barDataSet);
        barDataSet.f = this.f;
        barDataSet.g = this.g;
        barDataSet.h = this.h;
        barDataSet.l = this.l;
        barDataSet.j = this.j;
    }
}
