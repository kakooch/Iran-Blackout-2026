package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import ir.eitaa.messenger.R;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public final class WavExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.wav.-$$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return WavExtractor.lambda$static$0();
        }
    };
    private ExtractorOutput extractorOutput;
    private OutputWriter outputWriter;
    private TrackOutput trackOutput;
    private int dataStartPosition = -1;
    private long dataEndPosition = -1;

    private interface OutputWriter {
        void init(int dataStartPosition, long dataEndPosition) throws ParserException;

        void reset(long timeUs);

        boolean sampleData(ExtractorInput input, long bytesLeft) throws InterruptedException, IOException;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new WavExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput input) throws InterruptedException, IOException {
        return WavHeaderReader.peek(input) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput output) {
        this.extractorOutput = output;
        this.trackOutput = output.track(0, 1);
        output.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        OutputWriter outputWriter = this.outputWriter;
        if (outputWriter != null) {
            outputWriter.reset(timeUs);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput input, PositionHolder seekPosition) throws InterruptedException, IOException {
        assertInitialized();
        if (this.outputWriter == null) {
            WavHeader wavHeaderPeek = WavHeaderReader.peek(input);
            if (wavHeaderPeek == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            int i = wavHeaderPeek.formatType;
            if (i == 17) {
                this.outputWriter = new ImaAdPcmOutputWriter(this.extractorOutput, this.trackOutput, wavHeaderPeek);
            } else if (i == 6) {
                this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavHeaderPeek, "audio/g711-alaw", -1);
            } else if (i == 7) {
                this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavHeaderPeek, "audio/g711-mlaw", -1);
            } else {
                int pcmEncodingForType = WavUtil.getPcmEncodingForType(i, wavHeaderPeek.bitsPerSample);
                if (pcmEncodingForType == 0) {
                    throw new ParserException("Unsupported WAV format type: " + wavHeaderPeek.formatType);
                }
                this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavHeaderPeek, "audio/raw", pcmEncodingForType);
            }
        }
        if (this.dataStartPosition == -1) {
            Pair<Long, Long> pairSkipToData = WavHeaderReader.skipToData(input);
            this.dataStartPosition = ((Long) pairSkipToData.first).intValue();
            long jLongValue = ((Long) pairSkipToData.second).longValue();
            this.dataEndPosition = jLongValue;
            this.outputWriter.init(this.dataStartPosition, jLongValue);
        } else if (input.getPosition() == 0) {
            input.skipFully(this.dataStartPosition);
        }
        Assertions.checkState(this.dataEndPosition != -1);
        return this.outputWriter.sampleData(input, this.dataEndPosition - input.getPosition()) ? -1 : 0;
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    private static final class PassthroughOutputWriter implements OutputWriter {
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final WavHeader header;
        private long outputFrameCount;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeBytes;
        private final TrackOutput trackOutput;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavHeader header, String mimeType, int pcmEncoding) throws ParserException {
            this.extractorOutput = extractorOutput;
            this.trackOutput = trackOutput;
            this.header = header;
            int i = (header.numChannels * header.bitsPerSample) / 8;
            if (header.blockSize != i) {
                throw new ParserException("Expected block size: " + i + "; got: " + header.blockSize);
            }
            int iMax = Math.max(i, (header.frameRateHz * i) / 10);
            this.targetSampleSizeBytes = iMax;
            int i2 = header.frameRateHz;
            this.format = Format.createAudioSampleFormat(null, mimeType, null, i * i2 * 8, iMax, header.numChannels, i2, pcmEncoding, null, null, 0, null);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void reset(long timeUs) {
            this.startTimeUs = timeUs;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0L;
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void init(int dataStartPosition, long dataEndPosition) {
            this.extractorOutput.seekMap(new WavSeekMap(this.header, 1, dataStartPosition, dataEndPosition));
            this.trackOutput.format(this.format);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public boolean sampleData(ExtractorInput input, long bytesLeft) throws InterruptedException, IOException {
            long j;
            int i;
            int i2;
            long j2 = bytesLeft;
            while (j2 > 0 && (i = this.pendingOutputBytes) < (i2 = this.targetSampleSizeBytes)) {
                int iSampleData = this.trackOutput.sampleData(input, (int) Math.min(i2 - i, j2), true);
                if (iSampleData == -1) {
                    j2 = 0;
                } else {
                    this.pendingOutputBytes += iSampleData;
                    j2 -= iSampleData;
                }
            }
            int i3 = this.header.blockSize;
            int i4 = this.pendingOutputBytes / i3;
            if (i4 > 0) {
                long jScaleLargeTimestamp = this.startTimeUs + Util.scaleLargeTimestamp(this.outputFrameCount, 1000000L, r6.frameRateHz);
                int i5 = i4 * i3;
                int i6 = this.pendingOutputBytes - i5;
                this.trackOutput.sampleMetadata(jScaleLargeTimestamp, 1, i5, i6, null);
                this.outputFrameCount += i4;
                this.pendingOutputBytes = i6;
                j = 0;
            } else {
                j = 0;
            }
            return j2 <= j;
        }
    }

    private static final class ImaAdPcmOutputWriter implements OutputWriter {
        private static final int[] INDEX_TABLE = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] STEP_TABLE = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, R.styleable.AppCompatTheme_toolbarStyle, R.styleable.AppCompatTheme_windowMinWidthMajor, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        private final ParsableByteArray decodedData;
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final int framesPerBlock;
        private final WavHeader header;
        private final byte[] inputData;
        private long outputFrameCount;
        private int pendingInputBytes;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeFrames;
        private final TrackOutput trackOutput;

        private static int numOutputFramesToBytes(int frames, int numChannels) {
            return frames * 2 * numChannels;
        }

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavHeader header) throws ParserException {
            this.extractorOutput = extractorOutput;
            this.trackOutput = trackOutput;
            this.header = header;
            int iMax = Math.max(1, header.frameRateHz / 10);
            this.targetSampleSizeFrames = iMax;
            ParsableByteArray parsableByteArray = new ParsableByteArray(header.extraData);
            parsableByteArray.readLittleEndianUnsignedShort();
            int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
            this.framesPerBlock = littleEndianUnsignedShort;
            int i = header.numChannels;
            int i2 = (((header.blockSize - (i * 4)) * 8) / (header.bitsPerSample * i)) + 1;
            if (littleEndianUnsignedShort != i2) {
                throw new ParserException("Expected frames per block: " + i2 + "; got: " + littleEndianUnsignedShort);
            }
            int iCeilDivide = Util.ceilDivide(iMax, littleEndianUnsignedShort);
            this.inputData = new byte[header.blockSize * iCeilDivide];
            this.decodedData = new ParsableByteArray(iCeilDivide * numOutputFramesToBytes(littleEndianUnsignedShort, i));
            this.format = Format.createAudioSampleFormat(null, "audio/raw", null, ((header.frameRateHz * header.blockSize) * 8) / littleEndianUnsignedShort, numOutputFramesToBytes(iMax, i), header.numChannels, header.frameRateHz, 2, null, null, 0, null);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void reset(long timeUs) {
            this.pendingInputBytes = 0;
            this.startTimeUs = timeUs;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0L;
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void init(int dataStartPosition, long dataEndPosition) {
            this.extractorOutput.seekMap(new WavSeekMap(this.header, this.framesPerBlock, dataStartPosition, dataEndPosition));
            this.trackOutput.format(this.format);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:4:0x001c). Please report as a decompilation issue!!! */
        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean sampleData(com.google.android.exoplayer2.extractor.ExtractorInput r7, long r8) throws java.lang.InterruptedException, java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.targetSampleSizeFrames
                int r1 = r6.pendingOutputBytes
                int r1 = r6.numOutputBytesToFrames(r1)
                int r0 = r0 - r1
                int r1 = r6.framesPerBlock
                int r0 = com.google.android.exoplayer2.util.Util.ceilDivide(r0, r1)
                com.google.android.exoplayer2.extractor.wav.WavHeader r1 = r6.header
                int r1 = r1.blockSize
                int r0 = r0 * r1
                r1 = 1
                r2 = 0
                int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r4 != 0) goto L1e
            L1c:
                r2 = 1
                goto L1f
            L1e:
                r2 = 0
            L1f:
                if (r2 != 0) goto L3f
                int r3 = r6.pendingInputBytes
                if (r3 >= r0) goto L3f
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r4 = (int) r3
                byte[] r3 = r6.inputData
                int r5 = r6.pendingInputBytes
                int r3 = r7.read(r3, r5, r4)
                r4 = -1
                if (r3 != r4) goto L39
                goto L1c
            L39:
                int r4 = r6.pendingInputBytes
                int r4 = r4 + r3
                r6.pendingInputBytes = r4
                goto L1f
            L3f:
                int r7 = r6.pendingInputBytes
                com.google.android.exoplayer2.extractor.wav.WavHeader r8 = r6.header
                int r8 = r8.blockSize
                int r7 = r7 / r8
                if (r7 <= 0) goto L77
                byte[] r8 = r6.inputData
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.decodedData
                r6.decode(r8, r7, r9)
                int r8 = r6.pendingInputBytes
                com.google.android.exoplayer2.extractor.wav.WavHeader r9 = r6.header
                int r9 = r9.blockSize
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.pendingInputBytes = r8
                com.google.android.exoplayer2.util.ParsableByteArray r7 = r6.decodedData
                int r7 = r7.limit()
                com.google.android.exoplayer2.extractor.TrackOutput r8 = r6.trackOutput
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.decodedData
                r8.sampleData(r9, r7)
                int r8 = r6.pendingOutputBytes
                int r8 = r8 + r7
                r6.pendingOutputBytes = r8
                int r7 = r6.numOutputBytesToFrames(r8)
                int r8 = r6.targetSampleSizeFrames
                if (r7 < r8) goto L77
                r6.writeSampleMetadata(r8)
            L77:
                if (r2 == 0) goto L84
                int r7 = r6.pendingOutputBytes
                int r7 = r6.numOutputBytesToFrames(r7)
                if (r7 <= 0) goto L84
                r6.writeSampleMetadata(r7)
            L84:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.wav.WavExtractor.ImaAdPcmOutputWriter.sampleData(com.google.android.exoplayer2.extractor.ExtractorInput, long):boolean");
        }

        private void writeSampleMetadata(int sampleFrames) {
            long jScaleLargeTimestamp = this.startTimeUs + Util.scaleLargeTimestamp(this.outputFrameCount, 1000000L, this.header.frameRateHz);
            int iNumOutputFramesToBytes = numOutputFramesToBytes(sampleFrames);
            this.trackOutput.sampleMetadata(jScaleLargeTimestamp, 1, iNumOutputFramesToBytes, this.pendingOutputBytes - iNumOutputFramesToBytes, null);
            this.outputFrameCount += sampleFrames;
            this.pendingOutputBytes -= iNumOutputFramesToBytes;
        }

        private void decode(byte[] input, int blockCount, ParsableByteArray output) {
            for (int i = 0; i < blockCount; i++) {
                for (int i2 = 0; i2 < this.header.numChannels; i2++) {
                    decodeBlockForChannel(input, i, i2, output.data);
                }
            }
            output.reset(numOutputFramesToBytes(this.framesPerBlock * blockCount));
        }

        private void decodeBlockForChannel(byte[] input, int blockIndex, int channelIndex, byte[] output) {
            WavHeader wavHeader = this.header;
            int i = wavHeader.blockSize;
            int i2 = wavHeader.numChannels;
            int i3 = (blockIndex * i) + (channelIndex * 4);
            int i4 = (i2 * 4) + i3;
            int i5 = (i / i2) - 4;
            int iConstrainValue = (short) (((input[i3 + 1] & 255) << 8) | (input[i3] & 255));
            int iMin = Math.min(input[i3 + 2] & 255, 88);
            int i6 = STEP_TABLE[iMin];
            int i7 = ((blockIndex * this.framesPerBlock * i2) + channelIndex) * 2;
            output[i7] = (byte) (iConstrainValue & 255);
            output[i7 + 1] = (byte) (iConstrainValue >> 8);
            for (int i8 = 0; i8 < i5 * 2; i8++) {
                int i9 = input[((i8 / 8) * i2 * 4) + i4 + ((i8 / 2) % 4)] & 255;
                int i10 = i8 % 2 == 0 ? i9 & 15 : i9 >> 4;
                int i11 = ((((i10 & 7) * 2) + 1) * i6) >> 3;
                if ((i10 & 8) != 0) {
                    i11 = -i11;
                }
                iConstrainValue = Util.constrainValue(iConstrainValue + i11, -32768, 32767);
                i7 += i2 * 2;
                output[i7] = (byte) (iConstrainValue & 255);
                output[i7 + 1] = (byte) (iConstrainValue >> 8);
                int i12 = iMin + INDEX_TABLE[i10];
                int[] iArr = STEP_TABLE;
                iMin = Util.constrainValue(i12, 0, iArr.length - 1);
                i6 = iArr[iMin];
            }
        }

        private int numOutputBytesToFrames(int bytes) {
            return bytes / (this.header.numChannels * 2);
        }

        private int numOutputFramesToBytes(int frames) {
            return numOutputFramesToBytes(frames, this.header.numChannels);
        }
    }
}
