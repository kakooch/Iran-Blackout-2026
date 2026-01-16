package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
public interface DataBuffer<T> extends Releasable, Closeable, Iterable<T> {
    @RecentlyNonNull
    T get(int i);

    int getCount();
}
