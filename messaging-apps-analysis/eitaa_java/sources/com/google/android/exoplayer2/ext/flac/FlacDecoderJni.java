package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class FlacDecoderJni {
    private static final int TEMP_BUFFER_SIZE = 8192;
    private ByteBuffer byteBufferData;
    private boolean endOfExtractorInput;
    private ExtractorInput extractorInput;
    private final long nativeDecoderContext;
    private byte[] tempBuffer;

    private native FlacStreamMetadata flacDecodeMetadata(long context) throws InterruptedException, IOException;

    private native int flacDecodeToArray(long context, byte[] outputArray) throws InterruptedException, IOException;

    private native int flacDecodeToBuffer(long context, ByteBuffer outputBuffer) throws InterruptedException, IOException;

    private native void flacFlush(long context);

    private native long flacGetDecodePosition(long context);

    private native long flacGetLastFrameFirstSampleIndex(long context);

    private native long flacGetLastFrameTimestamp(long context);

    private native long flacGetNextFrameFirstSampleIndex(long context);

    private native boolean flacGetSeekPoints(long context, long timeUs, long[] outSeekPoints);

    private native String flacGetStateString(long context);

    private native long flacInit();

    private native boolean flacIsDecoderAtEndOfStream(long context);

    private native void flacRelease(long context);

    private native void flacReset(long context, long newPosition);

    public static final class FlacFrameDecodeException extends Exception {
        public final int errorCode;

        public FlacFrameDecodeException(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }
    }

    public FlacDecoderJni() throws FlacDecoderException {
        long jFlacInit = flacInit();
        this.nativeDecoderContext = jFlacInit;
        if (jFlacInit == 0) {
            throw new FlacDecoderException("Failed to initialize decoder");
        }
    }

    public void setData(ByteBuffer byteBufferData) {
        this.byteBufferData = byteBufferData;
        this.extractorInput = null;
    }

    public void setData(ExtractorInput extractorInput) {
        this.byteBufferData = null;
        this.extractorInput = extractorInput;
        this.endOfExtractorInput = false;
        if (this.tempBuffer == null) {
            this.tempBuffer = new byte[TEMP_BUFFER_SIZE];
        }
    }

    public boolean isEndOfData() {
        ByteBuffer byteBuffer = this.byteBufferData;
        if (byteBuffer != null) {
            return byteBuffer.remaining() == 0;
        }
        if (this.extractorInput != null) {
            return this.endOfExtractorInput;
        }
        return true;
    }

    public void clearData() {
        this.byteBufferData = null;
        this.extractorInput = null;
    }

    public int read(ByteBuffer target) throws InterruptedException, IOException {
        int iRemaining = target.remaining();
        ByteBuffer byteBuffer = this.byteBufferData;
        if (byteBuffer != null) {
            int iMin = Math.min(iRemaining, byteBuffer.remaining());
            int iLimit = this.byteBufferData.limit();
            ByteBuffer byteBuffer2 = this.byteBufferData;
            byteBuffer2.limit(byteBuffer2.position() + iMin);
            target.put(this.byteBufferData);
            this.byteBufferData.limit(iLimit);
            return iMin;
        }
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return -1;
        }
        byte[] bArr = (byte[]) Util.castNonNull(this.tempBuffer);
        int iMin2 = Math.min(iRemaining, TEMP_BUFFER_SIZE);
        int fromExtractorInput = readFromExtractorInput(extractorInput, bArr, 0, iMin2);
        if (fromExtractorInput < 4) {
            fromExtractorInput += readFromExtractorInput(extractorInput, bArr, fromExtractorInput, iMin2 - fromExtractorInput);
        }
        int i = fromExtractorInput;
        target.put(bArr, 0, i);
        return i;
    }

    public FlacStreamMetadata decodeStreamMetadata() throws InterruptedException, IOException {
        FlacStreamMetadata flacStreamMetadataFlacDecodeMetadata = flacDecodeMetadata(this.nativeDecoderContext);
        if (flacStreamMetadataFlacDecodeMetadata != null) {
            return flacStreamMetadataFlacDecodeMetadata;
        }
        throw new ParserException("Failed to decode stream metadata");
    }

    public void decodeSampleWithBacktrackPosition(ByteBuffer output, long retryPosition) throws Throwable {
        try {
            decodeSample(output);
        } catch (IOException e) {
            if (retryPosition >= 0) {
                reset(retryPosition);
                ExtractorInput extractorInput = this.extractorInput;
                if (extractorInput != null) {
                    extractorInput.setRetryPosition(retryPosition, e);
                }
            }
            throw e;
        }
    }

    public void decodeSample(ByteBuffer output) throws FlacFrameDecodeException, InterruptedException, IOException {
        int iFlacDecodeToArray;
        output.clear();
        if (output.isDirect()) {
            iFlacDecodeToArray = flacDecodeToBuffer(this.nativeDecoderContext, output);
        } else {
            iFlacDecodeToArray = flacDecodeToArray(this.nativeDecoderContext, output.array());
        }
        if (iFlacDecodeToArray < 0) {
            if (!isDecoderAtEndOfInput()) {
                throw new FlacFrameDecodeException("Cannot decode FLAC frame", iFlacDecodeToArray);
            }
            output.limit(0);
            return;
        }
        output.limit(iFlacDecodeToArray);
    }

    public long getDecodePosition() {
        return flacGetDecodePosition(this.nativeDecoderContext);
    }

    public long getLastFrameTimestamp() {
        return flacGetLastFrameTimestamp(this.nativeDecoderContext);
    }

    public long getLastFrameFirstSampleIndex() {
        return flacGetLastFrameFirstSampleIndex(this.nativeDecoderContext);
    }

    public long getNextFrameFirstSampleIndex() {
        return flacGetNextFrameFirstSampleIndex(this.nativeDecoderContext);
    }

    public SeekMap.SeekPoints getSeekPoints(long timeUs) {
        long[] jArr = new long[4];
        if (!flacGetSeekPoints(this.nativeDecoderContext, timeUs, jArr)) {
            return null;
        }
        SeekPoint seekPoint = new SeekPoint(jArr[0], jArr[1]);
        return new SeekMap.SeekPoints(seekPoint, jArr[2] == jArr[0] ? seekPoint : new SeekPoint(jArr[2], jArr[3]));
    }

    public String getStateString() {
        return flacGetStateString(this.nativeDecoderContext);
    }

    public boolean isDecoderAtEndOfInput() {
        return flacIsDecoderAtEndOfStream(this.nativeDecoderContext);
    }

    public void flush() {
        flacFlush(this.nativeDecoderContext);
    }

    public void reset(long newPosition) {
        flacReset(this.nativeDecoderContext, newPosition);
    }

    public void release() {
        flacRelease(this.nativeDecoderContext);
    }

    private int readFromExtractorInput(ExtractorInput extractorInput, byte[] tempBuffer, int offset, int length) throws InterruptedException, IOException {
        int i = extractorInput.read(tempBuffer, offset, length);
        if (i != -1) {
            return i;
        }
        this.endOfExtractorInput = true;
        return 0;
    }
}
