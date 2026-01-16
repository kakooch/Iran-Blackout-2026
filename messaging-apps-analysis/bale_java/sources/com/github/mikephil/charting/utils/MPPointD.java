package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* loaded from: classes2.dex */
public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool b;
    public double x;
    public double y;

    static {
        ObjectPool objectPoolCreate = ObjectPool.create(64, new MPPointD(0.0d, 0.0d));
        b = objectPoolCreate;
        objectPoolCreate.setReplenishPercentage(0.5f);
    }

    private MPPointD(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public static MPPointD getInstance(double d, double d2) {
        MPPointD mPPointD = (MPPointD) b.get();
        mPPointD.x = d;
        mPPointD.y = d2;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        b.recycle((ObjectPool) mPPointD);
    }

    public static void recycleInstances(List<MPPointD> list) {
        b.recycle(list);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MPPointD(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.x + ", y: " + this.y;
    }
}
