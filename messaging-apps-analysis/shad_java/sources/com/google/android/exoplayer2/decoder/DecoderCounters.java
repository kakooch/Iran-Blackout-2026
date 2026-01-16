package com.google.android.exoplayer2.decoder;

/* loaded from: classes.dex */
public final class DecoderCounters {
    public int decoderInitCount;
    public int decoderReleaseCount;
    public int droppedBufferCount;
    public int droppedToKeyframeCount;
    public int inputBufferCount;
    public int maxConsecutiveDroppedBufferCount;
    public int renderedOutputBufferCount;
    public int skippedInputBufferCount;
    public int skippedOutputBufferCount;
    public long totalVideoFrameProcessingOffsetUs;
    public int videoFrameProcessingOffsetCount;

    public synchronized void ensureUpdated() {
    }

    public void addVideoFrameProcessingOffset(long j) {
        addVideoFrameProcessingOffsets(j, 1);
    }

    private void addVideoFrameProcessingOffsets(long j, int i) {
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount += i;
    }
}
