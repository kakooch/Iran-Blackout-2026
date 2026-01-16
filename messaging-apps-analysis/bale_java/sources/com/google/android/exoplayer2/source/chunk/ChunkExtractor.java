package com.google.android.exoplayer2.source.chunk;

import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.InterfaceC9845af2;

/* loaded from: classes2.dex */
public interface ChunkExtractor {

    public interface Factory {
    }

    public interface TrackOutputProvider {
        InterfaceC4589Ft7 b(int i, int i2);
    }

    boolean a(InterfaceC9845af2 interfaceC9845af2);

    void c(TrackOutputProvider trackOutputProvider, long j, long j2);
}
