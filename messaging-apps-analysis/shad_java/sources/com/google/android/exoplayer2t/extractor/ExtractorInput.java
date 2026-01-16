package com.google.android.exoplayer2t.extractor;

import java.io.IOException;

/* loaded from: classes.dex */
public interface ExtractorInput {
    void advancePeekPosition(int i) throws InterruptedException, IOException;

    boolean advancePeekPosition(int i, boolean z) throws InterruptedException, IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    int peek(byte[] bArr, int i, int i2) throws InterruptedException, IOException;

    void peekFully(byte[] bArr, int i, int i2) throws InterruptedException, IOException;

    boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, IOException;

    int read(byte[] bArr, int i, int i2) throws InterruptedException, IOException;

    void readFully(byte[] bArr, int i, int i2) throws InterruptedException, IOException;

    boolean readFully(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, IOException;

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long j, E e) throws Throwable;

    int skip(int i) throws InterruptedException, IOException;

    void skipFully(int i) throws InterruptedException, IOException;
}
