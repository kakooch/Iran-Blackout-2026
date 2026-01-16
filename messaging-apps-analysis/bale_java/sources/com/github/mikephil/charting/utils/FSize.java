package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* loaded from: classes2.dex */
public final class FSize extends ObjectPool.Poolable {
    private static ObjectPool b;
    public float height;
    public float width;

    static {
        ObjectPool objectPoolCreate = ObjectPool.create(256, new FSize(0.0f, 0.0f));
        b = objectPoolCreate;
        objectPoolCreate.setReplenishPercentage(0.5f);
    }

    public FSize() {
    }

    public static FSize getInstance(float f, float f2) {
        FSize fSize = (FSize) b.get();
        fSize.width = f;
        fSize.height = f2;
        return fSize;
    }

    public static void recycleInstance(FSize fSize) {
        b.recycle((ObjectPool) fSize);
    }

    public static void recycleInstances(List<FSize> list) {
        b.recycle(list);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FSize)) {
            return false;
        }
        FSize fSize = (FSize) obj;
        return this.width == fSize.width && this.height == fSize.height;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.width) ^ Float.floatToIntBits(this.height);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new FSize(0.0f, 0.0f);
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public FSize(float f, float f2) {
        this.width = f;
        this.height = f2;
    }
}
