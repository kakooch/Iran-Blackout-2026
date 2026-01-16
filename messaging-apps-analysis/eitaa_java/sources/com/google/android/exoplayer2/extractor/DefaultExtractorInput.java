package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public final class DefaultExtractorInput implements ExtractorInput {
    private final DataSource dataSource;
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final long streamLength;
    private byte[] peekBuffer = new byte[65536];
    private final byte[] scratchSpace = new byte[Factory.DEVICE_HAS_CRAPPY_AAUDIO];

    public DefaultExtractorInput(DataSource dataSource, long position, long length) {
        this.dataSource = dataSource;
        this.position = position;
        this.streamLength = length;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] target, int offset, int length) throws InterruptedException, IOException {
        int fromPeekBuffer = readFromPeekBuffer(target, offset, length);
        if (fromPeekBuffer == 0) {
            fromPeekBuffer = readFromDataSource(target, offset, length, 0, true);
        }
        commitBytesRead(fromPeekBuffer);
        return fromPeekBuffer;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] target, int offset, int length, boolean allowEndOfInput) throws InterruptedException, IOException {
        int fromPeekBuffer = readFromPeekBuffer(target, offset, length);
        while (fromPeekBuffer < length && fromPeekBuffer != -1) {
            fromPeekBuffer = readFromDataSource(target, offset, length, fromPeekBuffer, allowEndOfInput);
        }
        commitBytesRead(fromPeekBuffer);
        return fromPeekBuffer != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] target, int offset, int length) throws InterruptedException, IOException {
        readFully(target, offset, length, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int length) throws InterruptedException, IOException {
        int iSkipFromPeekBuffer = skipFromPeekBuffer(length);
        if (iSkipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            iSkipFromPeekBuffer = readFromDataSource(bArr, 0, Math.min(length, bArr.length), 0, true);
        }
        commitBytesRead(iSkipFromPeekBuffer);
        return iSkipFromPeekBuffer;
    }

    public boolean skipFully(int length, boolean allowEndOfInput) throws InterruptedException, IOException {
        int iSkipFromPeekBuffer = skipFromPeekBuffer(length);
        while (iSkipFromPeekBuffer < length && iSkipFromPeekBuffer != -1) {
            iSkipFromPeekBuffer = readFromDataSource(this.scratchSpace, -iSkipFromPeekBuffer, Math.min(length, this.scratchSpace.length + iSkipFromPeekBuffer), iSkipFromPeekBuffer, allowEndOfInput);
        }
        commitBytesRead(iSkipFromPeekBuffer);
        return iSkipFromPeekBuffer != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int length) throws InterruptedException, IOException {
        skipFully(length, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int peek(byte[] target, int offset, int length) throws InterruptedException, IOException {
        int iMin;
        ensureSpaceForPeek(length);
        int i = this.peekBufferLength;
        int i2 = this.peekBufferPosition;
        int i3 = i - i2;
        if (i3 == 0) {
            iMin = readFromDataSource(this.peekBuffer, i2, length, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.peekBufferLength += iMin;
        } else {
            iMin = Math.min(length, i3);
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition, target, offset, iMin);
        this.peekBufferPosition += iMin;
        return iMin;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] target, int offset, int length, boolean allowEndOfInput) throws InterruptedException, IOException {
        if (!advancePeekPosition(length, allowEndOfInput)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - length, target, offset, length);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] target, int offset, int length) throws InterruptedException, IOException {
        peekFully(target, offset, length, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int length, boolean allowEndOfInput) throws InterruptedException, IOException {
        ensureSpaceForPeek(length);
        int fromDataSource = this.peekBufferLength - this.peekBufferPosition;
        while (fromDataSource < length) {
            fromDataSource = readFromDataSource(this.peekBuffer, this.peekBufferPosition, length, fromDataSource, allowEndOfInput);
            if (fromDataSource == -1) {
                return false;
            }
            this.peekBufferLength = this.peekBufferPosition + fromDataSource;
        }
        this.peekBufferPosition += length;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int length) throws InterruptedException, IOException {
        advancePeekPosition(length, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.position + this.peekBufferPosition;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.position;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.streamLength;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Throwable */
    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long position, E e) throws Throwable {
        Assertions.checkArgument(position >= 0);
        this.position = position;
        throw e;
    }

    private void ensureSpaceForPeek(int length) {
        int i = this.peekBufferPosition + length;
        byte[] bArr = this.peekBuffer;
        if (i > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i, i + 524288));
        }
    }

    private int skipFromPeekBuffer(int length) {
        int iMin = Math.min(this.peekBufferLength, length);
        updatePeekBuffer(iMin);
        return iMin;
    }

    private int readFromPeekBuffer(byte[] target, int offset, int length) {
        int i = this.peekBufferLength;
        if (i == 0) {
            return 0;
        }
        int iMin = Math.min(i, length);
        System.arraycopy(this.peekBuffer, 0, target, offset, iMin);
        updatePeekBuffer(iMin);
        return iMin;
    }

    private void updatePeekBuffer(int bytesConsumed) {
        int i = this.peekBufferLength - bytesConsumed;
        this.peekBufferLength = i;
        this.peekBufferPosition = 0;
        byte[] bArr = this.peekBuffer;
        byte[] bArr2 = i < bArr.length - 524288 ? new byte[65536 + i] : bArr;
        System.arraycopy(bArr, bytesConsumed, bArr2, 0, i);
        this.peekBuffer = bArr2;
    }

    private int readFromDataSource(byte[] target, int offset, int length, int bytesAlreadyRead, boolean allowEndOfInput) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int i = this.dataSource.read(target, offset + bytesAlreadyRead, length - bytesAlreadyRead);
        if (i != -1) {
            return bytesAlreadyRead + i;
        }
        if (bytesAlreadyRead == 0 && allowEndOfInput) {
            return -1;
        }
        throw new EOFException();
    }

    private void commitBytesRead(int bytesRead) {
        if (bytesRead != -1) {
            this.position += bytesRead;
        }
    }
}
