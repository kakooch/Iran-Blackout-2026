package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.wearable.internal.zzcy;

/* loaded from: classes3.dex */
public class DataEventBuffer extends EntityBuffer<Object> implements Result {
    private final Status zzp;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzp = new Status(dataHolder.getStatusCode());
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected String getPrimaryDataMarkerColumn() {
        return "path";
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzp;
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected /* synthetic */ Object getEntry(int i, int i2) {
        return new zzcy(this.mDataHolder, i, i2);
    }
}
