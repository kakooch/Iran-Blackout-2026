package com.google.android.exoplayer2t.offline;

import java.util.List;

/* loaded from: classes.dex */
public interface FilterableManifest<T> {
    T copy(List<StreamKey> list);
}
