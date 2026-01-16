package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.ext.flac.FlacDecoderJni;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
final class FlacDecoder extends SimpleDecoder<DecoderInputBuffer, SimpleOutputBuffer, FlacDecoderException> {
    private final FlacDecoderJni decoderJni;
    private final FlacStreamMetadata streamMetadata;

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "libflac";
    }

    public FlacDecoder(int numInputBuffers, int numOutputBuffers, int maxInputBufferSize, List<byte[]> initializationData) throws FlacDecoderException {
        super(new DecoderInputBuffer[numInputBuffers], new SimpleOutputBuffer[numOutputBuffers]);
        if (initializationData.size() != 1) {
            throw new FlacDecoderException("Initialization data must be of length 1");
        }
        FlacDecoderJni flacDecoderJni = new FlacDecoderJni();
        this.decoderJni = flacDecoderJni;
        flacDecoderJni.setData(ByteBuffer.wrap(initializationData.get(0)));
        try {
            FlacStreamMetadata flacStreamMetadataDecodeStreamMetadata = flacDecoderJni.decodeStreamMetadata();
            this.streamMetadata = flacStreamMetadataDecodeStreamMetadata;
            setInitialInputBufferSize(maxInputBufferSize == -1 ? flacStreamMetadataDecodeStreamMetadata.maxFrameSize : maxInputBufferSize);
        } catch (ParserException e) {
            throw new FlacDecoderException("Failed to decode StreamInfo", e);
        } catch (IOException e2) {
            e = e2;
            throw new IllegalStateException(e);
        } catch (InterruptedException e3) {
            e = e3;
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    protected DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public SimpleOutputBuffer createOutputBuffer() {
        return new SimpleOutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public FlacDecoderException createUnexpectedDecodeException(Throwable error) {
        return new FlacDecoderException("Unexpected decode error", error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public FlacDecoderException decode(DecoderInputBuffer inputBuffer, SimpleOutputBuffer outputBuffer, boolean reset) {
        if (reset) {
            this.decoderJni.flush();
        }
        this.decoderJni.setData((ByteBuffer) Util.castNonNull(inputBuffer.data));
        try {
            this.decoderJni.decodeSample(outputBuffer.init(inputBuffer.timeUs, this.streamMetadata.getMaxDecodedFrameSize()));
            return null;
        } catch (FlacDecoderJni.FlacFrameDecodeException e) {
            return new FlacDecoderException("Frame decoding failed", e);
        } catch (IOException e2) {
            e = e2;
            throw new IllegalStateException(e);
        } catch (InterruptedException e3) {
            e = e3;
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() throws InterruptedException {
        super.release();
        this.decoderJni.release();
    }

    public FlacStreamMetadata getStreamMetadata() {
        return this.streamMetadata;
    }
}
