package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
public class DataBufferRef {

    @RecentlyNonNull
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int zaa;

    public DataBufferRef(@RecentlyNonNull DataHolder dataHolder, int i) {
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(dataHolder);
        zaa(i);
    }

    protected final void zaa(int i) {
        Preconditions.checkState(i >= 0 && i < this.mDataHolder.getCount());
        this.mDataRow = i;
        this.zaa = this.mDataHolder.getWindowIndex(i);
    }

    protected int getInteger(@RecentlyNonNull String str) {
        return this.mDataHolder.getInteger(str, this.mDataRow, this.zaa);
    }

    @RecentlyNonNull
    protected String getString(@RecentlyNonNull String str) {
        return this.mDataHolder.getString(str, this.mDataRow, this.zaa);
    }

    @RecentlyNonNull
    protected byte[] getByteArray(@RecentlyNonNull String str) {
        return this.mDataHolder.getByteArray(str, this.mDataRow, this.zaa);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.zaa), this.mDataHolder);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) && Objects.equal(Integer.valueOf(dataBufferRef.zaa), Integer.valueOf(this.zaa)) && dataBufferRef.mDataHolder == this.mDataHolder) {
                return true;
            }
        }
        return false;
    }
}
