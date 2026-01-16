package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class BatchBuffer extends DecoderInputBuffer {
    private int accessUnitCount;
    private long firstAccessUnitTimeUs;
    private boolean hasPendingAccessUnit;
    private int maxAccessUnitCount;
    private final DecoderInputBuffer nextAccessUnitBuffer;

    public BatchBuffer() {
        super(2);
        this.nextAccessUnitBuffer = new DecoderInputBuffer(2);
        clear();
    }

    public void setMaxAccessUnitCount(int i) {
        Assertions.checkArgument(i > 0);
        this.maxAccessUnitCount = i;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        flush();
        this.maxAccessUnitCount = 32;
    }

    public void flush() {
        clearMainBuffer();
        this.nextAccessUnitBuffer.clear();
        this.hasPendingAccessUnit = false;
    }

    public void batchWasConsumed() {
        clearMainBuffer();
        if (this.hasPendingAccessUnit) {
            putAccessUnit(this.nextAccessUnitBuffer);
            this.hasPendingAccessUnit = false;
        }
    }

    public DecoderInputBuffer getNextAccessUnitBuffer() {
        return this.nextAccessUnitBuffer;
    }

    public long getFirstAccessUnitTimeUs() {
        return this.firstAccessUnitTimeUs;
    }

    public long getLastAccessUnitTimeUs() {
        return this.timeUs;
    }

    public int getAccessUnitCount() {
        return this.accessUnitCount;
    }

    public boolean isEmpty() {
        return this.accessUnitCount == 0;
    }

    public boolean isFull() {
        ByteBuffer byteBuffer;
        return this.accessUnitCount >= this.maxAccessUnitCount || ((byteBuffer = this.data) != null && byteBuffer.position() >= 3072000) || this.hasPendingAccessUnit;
    }

    public void commitNextAccessUnit() {
        DecoderInputBuffer decoderInputBuffer = this.nextAccessUnitBuffer;
        boolean z = false;
        Assertions.checkState((isFull() || isEndOfStream()) ? false : true);
        if (!decoderInputBuffer.isEncrypted() && !decoderInputBuffer.hasSupplementalData()) {
            z = true;
        }
        Assertions.checkArgument(z);
        if (!canBatch(decoderInputBuffer)) {
            this.hasPendingAccessUnit = true;
        } else {
            putAccessUnit(decoderInputBuffer);
        }
    }

    private boolean canBatch(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (isEmpty()) {
            return true;
        }
        if (decoderInputBuffer.isDecodeOnly() != isDecodeOnly()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.data;
        return byteBuffer2 == null || (byteBuffer = this.data) == null || byteBuffer.position() + byteBuffer2.limit() < 3072000;
    }

    private void putAccessUnit(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        if (byteBuffer != null) {
            decoderInputBuffer.flip();
            ensureSpaceForWrite(byteBuffer.remaining());
            this.data.put(byteBuffer);
        }
        if (decoderInputBuffer.isEndOfStream()) {
            setFlags(4);
        }
        if (decoderInputBuffer.isDecodeOnly()) {
            setFlags(Integer.MIN_VALUE);
        }
        if (decoderInputBuffer.isKeyFrame()) {
            setFlags(1);
        }
        int i = this.accessUnitCount + 1;
        this.accessUnitCount = i;
        long j = decoderInputBuffer.timeUs;
        this.timeUs = j;
        if (i == 1) {
            this.firstAccessUnitTimeUs = j;
        }
        decoderInputBuffer.clear();
    }

    private void clearMainBuffer() {
        super.clear();
        this.accessUnitCount = 0;
        this.firstAccessUnitTimeUs = -9223372036854775807L;
        this.timeUs = -9223372036854775807L;
    }
}
