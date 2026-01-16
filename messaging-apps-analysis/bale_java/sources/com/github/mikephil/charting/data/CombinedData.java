package com.github.mikephil.charting.data;

import android.util.Log;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {
    private LineData a;
    private BarData b;
    private ScatterData c;
    private CandleData d;
    private BubbleData e;

    @Override // com.github.mikephil.charting.data.ChartData
    public void calcMinMax() {
        if (this.mDataSets == null) {
            this.mDataSets = new ArrayList();
        }
        this.mDataSets.clear();
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        for (BarLineScatterCandleBubbleData barLineScatterCandleBubbleData : getAllData()) {
            barLineScatterCandleBubbleData.calcMinMax();
            this.mDataSets.addAll(barLineScatterCandleBubbleData.getDataSets());
            if (barLineScatterCandleBubbleData.getYMax() > this.mYMax) {
                this.mYMax = barLineScatterCandleBubbleData.getYMax();
            }
            if (barLineScatterCandleBubbleData.getYMin() < this.mYMin) {
                this.mYMin = barLineScatterCandleBubbleData.getYMin();
            }
            if (barLineScatterCandleBubbleData.getXMax() > this.mXMax) {
                this.mXMax = barLineScatterCandleBubbleData.getXMax();
            }
            if (barLineScatterCandleBubbleData.getXMin() < this.mXMin) {
                this.mXMin = barLineScatterCandleBubbleData.getXMin();
            }
            float f = barLineScatterCandleBubbleData.mLeftAxisMax;
            if (f > this.mLeftAxisMax) {
                this.mLeftAxisMax = f;
            }
            float f2 = barLineScatterCandleBubbleData.mLeftAxisMin;
            if (f2 < this.mLeftAxisMin) {
                this.mLeftAxisMin = f2;
            }
            float f3 = barLineScatterCandleBubbleData.mRightAxisMax;
            if (f3 > this.mRightAxisMax) {
                this.mRightAxisMax = f3;
            }
            float f4 = barLineScatterCandleBubbleData.mRightAxisMin;
            if (f4 < this.mRightAxisMin) {
                this.mRightAxisMin = f4;
            }
        }
    }

    public List<BarLineScatterCandleBubbleData> getAllData() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.a;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.b;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.c;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.d;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.e;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }

    public BarData getBarData() {
        return this.b;
    }

    public BubbleData getBubbleData() {
        return this.e;
    }

    public CandleData getCandleData() {
        return this.d;
    }

    public BarLineScatterCandleBubbleData getDataByIndex(int i) {
        return getAllData().get(i);
    }

    public int getDataIndex(ChartData chartData) {
        return getAllData().indexOf(chartData);
    }

    public IBarLineScatterCandleBubbleDataSet<? extends Entry> getDataSetByHighlight(Highlight highlight) {
        if (highlight.getDataIndex() >= getAllData().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData dataByIndex = getDataByIndex(highlight.getDataIndex());
        if (highlight.getDataSetIndex() >= dataByIndex.getDataSetCount()) {
            return null;
        }
        return (IBarLineScatterCandleBubbleDataSet) dataByIndex.getDataSets().get(highlight.getDataSetIndex());
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    @Override // com.github.mikephil.charting.data.ChartData
    public Entry getEntryForHighlight(Highlight highlight) {
        if (highlight.getDataIndex() >= getAllData().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData dataByIndex = getDataByIndex(highlight.getDataIndex());
        if (highlight.getDataSetIndex() >= dataByIndex.getDataSetCount()) {
            return null;
        }
        for (Entry entry : dataByIndex.getDataSetByIndex(highlight.getDataSetIndex()).getEntriesForXValue(highlight.getX())) {
            if (entry.getY() == highlight.getY() || Float.isNaN(highlight.getY())) {
                return entry;
            }
        }
        return null;
    }

    public LineData getLineData() {
        return this.a;
    }

    public ScatterData getScatterData() {
        return this.c;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public void notifyDataChanged() {
        LineData lineData = this.a;
        if (lineData != null) {
            lineData.notifyDataChanged();
        }
        BarData barData = this.b;
        if (barData != null) {
            barData.notifyDataChanged();
        }
        CandleData candleData = this.d;
        if (candleData != null) {
            candleData.notifyDataChanged();
        }
        ScatterData scatterData = this.c;
        if (scatterData != null) {
            scatterData.notifyDataChanged();
        }
        BubbleData bubbleData = this.e;
        if (bubbleData != null) {
            bubbleData.notifyDataChanged();
        }
        calcMinMax();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeEntry(Entry entry, int i) {
        Log.e(Chart.LOG_TAG, "removeEntry(...) not supported for CombinedData");
        return false;
    }

    public void setData(LineData lineData) {
        this.a = lineData;
        notifyDataChanged();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public boolean removeDataSet(IBarLineScatterCandleBubbleDataSet<? extends Entry> iBarLineScatterCandleBubbleDataSet) {
        Iterator<BarLineScatterCandleBubbleData> it = getAllData().iterator();
        boolean zRemoveDataSet = false;
        while (it.hasNext() && !(zRemoveDataSet = it.next().removeDataSet((BarLineScatterCandleBubbleData) iBarLineScatterCandleBubbleDataSet))) {
        }
        return zRemoveDataSet;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeEntry(float f, int i) {
        Log.e(Chart.LOG_TAG, "removeEntry(...) not supported for CombinedData");
        return false;
    }

    public void setData(BarData barData) {
        this.b = barData;
        notifyDataChanged();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeDataSet(int i) {
        Log.e(Chart.LOG_TAG, "removeDataSet(int index) not supported for CombinedData");
        return false;
    }

    public void setData(ScatterData scatterData) {
        this.c = scatterData;
        notifyDataChanged();
    }

    public void setData(CandleData candleData) {
        this.d = candleData;
        notifyDataChanged();
    }

    public void setData(BubbleData bubbleData) {
        this.e = bubbleData;
        notifyDataChanged();
    }
}
