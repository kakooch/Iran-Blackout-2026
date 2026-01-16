package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes.dex */
final class OggPageHeader {
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public int pageSegmentCount;
    public int revision;
    public int type;
    public final int[] laces = new int[255];
    private final ParsableByteArray scratch = new ParsableByteArray(255);

    OggPageHeader() {
    }

    public void reset() {
        this.revision = 0;
        this.type = 0;
        this.granulePosition = 0L;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }

    public boolean skipToNextPage(ExtractorInput extractorInput) throws IOException {
        return skipToNextPage(extractorInput, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
    
        if (r10 == (-1)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        if (r9.getPosition() >= r10) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        if (r9.skip(1) == (-1)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean skipToNextPage(com.google.android.exoplayer2.extractor.ExtractorInput r9, long r10) throws java.io.IOException {
        /*
            r8 = this;
            long r0 = r9.getPosition()
            long r2 = r9.getPeekPosition()
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r0)
        L14:
            r0 = -1
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 == 0) goto L25
            long r2 = r9.getPosition()
            r6 = 4
            long r2 = r2 + r6
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 >= 0) goto L4c
        L25:
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r8.scratch
            byte[] r2 = r2.getData()
            r3 = 4
            boolean r2 = peekSafely(r9, r2, r4, r3, r5)
            if (r2 == 0) goto L4c
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r8.scratch
            r0.reset(r3)
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r8.scratch
            long r0 = r0.readUnsignedInt()
            r2 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L48
            r9.resetPeekPosition()
            return r5
        L48:
            r9.skipFully(r5)
            goto L14
        L4c:
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 == 0) goto L58
            long r2 = r9.getPosition()
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 >= 0) goto L60
        L58:
            int r2 = r9.skip(r5)
            r3 = -1
            if (r2 == r3) goto L60
            goto L4c
        L60:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ogg.OggPageHeader.skipToNextPage(com.google.android.exoplayer2.extractor.ExtractorInput, long):boolean");
    }

    public boolean populate(ExtractorInput extractorInput, boolean z) throws IOException {
        reset();
        this.scratch.reset(27);
        if (!peekSafely(extractorInput, this.scratch.getData(), 0, 27, z) || this.scratch.readUnsignedInt() != 1332176723) {
            return false;
        }
        int unsignedByte = this.scratch.readUnsignedByte();
        this.revision = unsignedByte;
        if (unsignedByte != 0) {
            if (z) {
                return false;
            }
            throw new ParserException("unsupported bit stream revision");
        }
        this.type = this.scratch.readUnsignedByte();
        this.granulePosition = this.scratch.readLittleEndianLong();
        this.scratch.readLittleEndianUnsignedInt();
        this.scratch.readLittleEndianUnsignedInt();
        this.scratch.readLittleEndianUnsignedInt();
        int unsignedByte2 = this.scratch.readUnsignedByte();
        this.pageSegmentCount = unsignedByte2;
        this.headerSize = unsignedByte2 + 27;
        this.scratch.reset(unsignedByte2);
        extractorInput.peekFully(this.scratch.getData(), 0, this.pageSegmentCount);
        for (int i = 0; i < this.pageSegmentCount; i++) {
            this.laces[i] = this.scratch.readUnsignedByte();
            this.bodySize += this.laces[i];
        }
        return true;
    }

    private static boolean peekSafely(ExtractorInput extractorInput, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return extractorInput.peekFully(bArr, i, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }
}
