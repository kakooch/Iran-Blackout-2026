package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
public class DataBufferIterator<T> implements Iterator<T>, j$.util.Iterator {

    @RecentlyNonNull
    protected final DataBuffer<T> zaa;
    protected int zab = -1;

    public DataBufferIterator(@RecentlyNonNull DataBuffer<T> dataBuffer) {
        this.zaa = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.zab < this.zaa.getCount() - 1;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    @RecentlyNonNull
    public T next() {
        if (!hasNext()) {
            int i = this.zab;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Cannot advance the iterator beyond ");
            sb.append(i);
            throw new NoSuchElementException(sb.toString());
        }
        DataBuffer<T> dataBuffer = this.zaa;
        int i2 = this.zab + 1;
        this.zab = i2;
        return dataBuffer.get(i2);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
