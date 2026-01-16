package com.google.android.exoplayer2t.decoder;

/* loaded from: classes.dex */
public abstract class OutputBuffer extends Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public abstract void release();
}
