package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
final class WavHeaderReader {
    public static WavHeader peek(ExtractorInput extractorInput) throws IOException {
        byte[] bArr;
        Assertions.checkNotNull(extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (ChunkHeader.peek(extractorInput, parsableByteArray).id != 1380533830) {
            return null;
        }
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        parsableByteArray.setPosition(0);
        int i = parsableByteArray.readInt();
        if (i != 1463899717) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + i);
            return null;
        }
        ChunkHeader chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (chunkHeaderPeek.id != 1718449184) {
            extractorInput.advancePeekPosition((int) chunkHeaderPeek.size);
            chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        Assertions.checkState(chunkHeaderPeek.size >= 16);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 16);
        parsableByteArray.setPosition(0);
        int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
        int i2 = ((int) chunkHeaderPeek.size) - 16;
        if (i2 > 0) {
            byte[] bArr2 = new byte[i2];
            extractorInput.peekFully(bArr2, 0, i2);
            bArr = bArr2;
        } else {
            bArr = Util.EMPTY_BYTE_ARRAY;
        }
        return new WavHeader(littleEndianUnsignedShort, littleEndianUnsignedShort2, littleEndianUnsignedIntToInt, littleEndianUnsignedIntToInt2, littleEndianUnsignedShort3, littleEndianUnsignedShort4, bArr);
    }

    public static Pair<Long, Long> skipToData(ExtractorInput extractorInput) throws IOException {
        Assertions.checkNotNull(extractorInput);
        extractorInput.resetPeekPosition();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (true) {
            int i = chunkHeaderPeek.id;
            if (i != 1684108385) {
                if (i != 1380533830 && i != 1718449184) {
                    Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + chunkHeaderPeek.id);
                }
                long j = chunkHeaderPeek.size + 8;
                if (chunkHeaderPeek.id == 1380533830) {
                    j = 12;
                }
                if (j > 2147483647L) {
                    throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + chunkHeaderPeek.id);
                }
                extractorInput.skipFully((int) j);
                chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
            } else {
                extractorInput.skipFully(8);
                long position = extractorInput.getPosition();
                long j2 = chunkHeaderPeek.size + position;
                long length = extractorInput.getLength();
                if (length != -1 && j2 > length) {
                    Log.w("WavHeaderReader", "Data exceeds input length: " + j2 + ", " + length);
                    j2 = length;
                }
                return Pair.create(Long.valueOf(position), Long.valueOf(j2));
            }
        }
    }

    private static final class ChunkHeader {
        public final int id;
        public final long size;

        private ChunkHeader(int i, long j) {
            this.id = i;
            this.size = j;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
            extractorInput.peekFully(parsableByteArray.getData(), 0, 8);
            parsableByteArray.setPosition(0);
            return new ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }
}
