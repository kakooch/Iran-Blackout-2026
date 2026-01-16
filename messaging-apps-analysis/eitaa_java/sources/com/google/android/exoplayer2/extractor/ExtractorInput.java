package com.google.android.exoplayer2.extractor;

import java.io.IOException;

/* loaded from: classes.dex */
public interface ExtractorInput {
    void advancePeekPosition(int length) throws InterruptedException, IOException;

    boolean advancePeekPosition(int length, boolean allowEndOfInput) throws InterruptedException, IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    int peek(byte[] target, int offset, int length) throws InterruptedException, IOException;

    void peekFully(byte[] target, int offset, int length) throws InterruptedException, IOException;

    boolean peekFully(byte[] target, int offset, int length, boolean allowEndOfInput) throws InterruptedException, IOException;

    int read(byte[] target, int offset, int length) throws InterruptedException, IOException;

    void readFully(byte[] target, int offset, int length) throws InterruptedException, IOException;

    boolean readFully(byte[] target, int offset, int length, boolean allowEndOfInput) throws InterruptedException, IOException;

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long position, E e) throws Throwable;

    int skip(int length) throws InterruptedException, IOException;

    void skipFully(int length) throws InterruptedException, IOException;
}
