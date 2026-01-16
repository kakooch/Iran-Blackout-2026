package com.google.android.exoplayer2.ext.opus;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.drm.DecryptionException;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* loaded from: classes.dex */
final class OpusDecoder extends SimpleDecoder<DecoderInputBuffer, SimpleOutputBuffer, OpusDecoderException> {
    private static final int DECODE_ERROR = -1;
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int DRM_ERROR = -2;
    private static final int NO_ERROR = 0;
    private static final int SAMPLE_RATE = 48000;
    private final int channelCount;
    private final ExoMediaCrypto exoMediaCrypto;
    private final int headerSeekPreRollSamples;
    private final int headerSkipSamples;
    private final long nativeDecoderContext;
    private int skipSamples;

    private native void opusClose(long decoder);

    private native int opusDecode(long decoder, long timeUs, ByteBuffer inputBuffer, int inputSize, SimpleOutputBuffer outputBuffer);

    private native int opusGetErrorCode(long decoder);

    private native String opusGetErrorMessage(long decoder);

    private native long opusInit(int sampleRate, int channelCount, int numStreams, int numCoupled, int gain, byte[] streamMap);

    private native void opusReset(long decoder);

    private native int opusSecureDecode(long decoder, long timeUs, ByteBuffer inputBuffer, int inputSize, SimpleOutputBuffer outputBuffer, int sampleRate, ExoMediaCrypto mediaCrypto, int inputMode, byte[] key, byte[] iv, int numSubSamples, int[] numBytesOfClearData, int[] numBytesOfEncryptedData);

    public int getSampleRate() {
        return SAMPLE_RATE;
    }

    public OpusDecoder(int numInputBuffers, int numOutputBuffers, int initialInputBufferSize, List<byte[]> initializationData, ExoMediaCrypto exoMediaCrypto) throws OpusDecoderException {
        int i;
        int i2;
        super(new DecoderInputBuffer[numInputBuffers], new SimpleOutputBuffer[numOutputBuffers]);
        this.exoMediaCrypto = exoMediaCrypto;
        if (exoMediaCrypto != null && !OpusLibrary.opusIsSecureDecodeSupported()) {
            throw new OpusDecoderException("Opus decoder does not support secure decode.");
        }
        byte[] bArr = initializationData.get(0);
        if (bArr.length < 19) {
            throw new OpusDecoderException("Header size is too small.");
        }
        int i3 = bArr[9] & 255;
        this.channelCount = i3;
        if (i3 > 8) {
            throw new OpusDecoderException("Invalid channel count: " + i3);
        }
        int unsignedLittleEndian16 = readUnsignedLittleEndian16(bArr, 10);
        int signedLittleEndian16 = readSignedLittleEndian16(bArr, 16);
        byte[] bArr2 = new byte[8];
        if (bArr[18] == 0) {
            if (i3 > 2) {
                throw new OpusDecoderException("Invalid Header, missing stream map.");
            }
            i2 = i3 == 2 ? 1 : 0;
            bArr2[0] = 0;
            bArr2[1] = 1;
            i = 1;
        } else {
            if (bArr.length < i3 + 21) {
                throw new OpusDecoderException("Header size is too small.");
            }
            i = bArr[19] & 255;
            int i4 = bArr[20] & 255;
            System.arraycopy(bArr, 21, bArr2, 0, i3);
            i2 = i4;
        }
        if (initializationData.size() == 3) {
            if (initializationData.get(1).length != 8 || initializationData.get(2).length != 8) {
                throw new OpusDecoderException("Invalid Codec Delay or Seek Preroll");
            }
            long j = ByteBuffer.wrap(initializationData.get(1)).order(ByteOrder.nativeOrder()).getLong();
            long j2 = ByteBuffer.wrap(initializationData.get(2)).order(ByteOrder.nativeOrder()).getLong();
            this.headerSkipSamples = nsToSamples(j);
            this.headerSeekPreRollSamples = nsToSamples(j2);
        } else {
            this.headerSkipSamples = unsignedLittleEndian16;
            this.headerSeekPreRollSamples = DEFAULT_SEEK_PRE_ROLL_SAMPLES;
        }
        long jOpusInit = opusInit(SAMPLE_RATE, i3, i, i2, signedLittleEndian16, bArr2);
        this.nativeDecoderContext = jOpusInit;
        if (jOpusInit == 0) {
            throw new OpusDecoderException("Failed to initialize decoder");
        }
        setInitialInputBufferSize(initialInputBufferSize);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "libopus" + OpusLibrary.getVersion();
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    protected DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public SimpleOutputBuffer createOutputBuffer() {
        return new SimpleOutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public OpusDecoderException createUnexpectedDecodeException(Throwable error) {
        return new OpusDecoderException("Unexpected decode error", error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public OpusDecoderException decode(DecoderInputBuffer inputBuffer, SimpleOutputBuffer outputBuffer, boolean reset) {
        OpusDecoder opusDecoder;
        int iOpusDecode;
        if (reset) {
            opusReset(this.nativeDecoderContext);
            this.skipSamples = inputBuffer.timeUs == 0 ? this.headerSkipSamples : this.headerSeekPreRollSamples;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(inputBuffer.data);
        CryptoInfo cryptoInfo = inputBuffer.cryptoInfo;
        if (inputBuffer.isEncrypted()) {
            iOpusDecode = opusSecureDecode(this.nativeDecoderContext, inputBuffer.timeUs, byteBuffer, byteBuffer.limit(), outputBuffer, SAMPLE_RATE, this.exoMediaCrypto, cryptoInfo.mode, cryptoInfo.key, cryptoInfo.iv, cryptoInfo.numSubSamples, cryptoInfo.numBytesOfClearData, cryptoInfo.numBytesOfEncryptedData);
            opusDecoder = this;
        } else {
            opusDecoder = this;
            iOpusDecode = opusDecode(opusDecoder.nativeDecoderContext, inputBuffer.timeUs, byteBuffer, byteBuffer.limit(), outputBuffer);
        }
        if (iOpusDecode < 0) {
            if (iOpusDecode == -2) {
                String str = "Drm error: " + opusDecoder.opusGetErrorMessage(opusDecoder.nativeDecoderContext);
                return new OpusDecoderException(str, new DecryptionException(opusDecoder.opusGetErrorCode(opusDecoder.nativeDecoderContext), str));
            }
            return new OpusDecoderException("Decode error: " + opusDecoder.opusGetErrorMessage(iOpusDecode));
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) Util.castNonNull(outputBuffer.data);
        byteBuffer2.position(0);
        byteBuffer2.limit(iOpusDecode);
        int i = opusDecoder.skipSamples;
        if (i <= 0) {
            return null;
        }
        int i2 = opusDecoder.channelCount * 2;
        int i3 = i * i2;
        if (iOpusDecode <= i3) {
            opusDecoder.skipSamples = i - (iOpusDecode / i2);
            outputBuffer.addFlag(Integer.MIN_VALUE);
            byteBuffer2.position(iOpusDecode);
            return null;
        }
        opusDecoder.skipSamples = 0;
        byteBuffer2.position(i3);
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() throws InterruptedException {
        super.release();
        opusClose(this.nativeDecoderContext);
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    private static int nsToSamples(long ns) {
        return (int) ((ns * 48000) / 1000000000);
    }

    private static int readUnsignedLittleEndian16(byte[] input, int offset) {
        return ((input[offset + 1] & 255) << 8) | (input[offset] & 255);
    }

    private static int readSignedLittleEndian16(byte[] input, int offset) {
        return (short) readUnsignedLittleEndian16(input, offset);
    }
}
