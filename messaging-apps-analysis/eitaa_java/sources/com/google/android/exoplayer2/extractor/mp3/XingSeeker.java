package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class XingSeeker implements Seeker {
    private final long dataEndPosition;
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    public static XingSeeker create(long inputLength, long position, MpegAudioHeader mpegAudioHeader, ParsableByteArray frame) {
        int unsignedIntToInt;
        int i = mpegAudioHeader.samplesPerFrame;
        int i2 = mpegAudioHeader.sampleRate;
        int i3 = frame.readInt();
        if ((i3 & 1) != 1 || (unsignedIntToInt = frame.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(unsignedIntToInt, i * 1000000, i2);
        if ((i3 & 6) != 6) {
            return new XingSeeker(position, mpegAudioHeader.frameSize, jScaleLargeTimestamp);
        }
        long unsignedInt = frame.readUnsignedInt();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            jArr[i4] = frame.readUnsignedByte();
        }
        if (inputLength != -1) {
            long j = position + unsignedInt;
            if (inputLength != j) {
                Log.w("XingSeeker", "XING data size mismatch: " + inputLength + ", " + j);
            }
        }
        return new XingSeeker(position, mpegAudioHeader.frameSize, jScaleLargeTimestamp, unsignedInt, jArr);
    }

    private XingSeeker(long dataStartPosition, int xingFrameSize, long durationUs) {
        this(dataStartPosition, xingFrameSize, durationUs, -1L, null);
    }

    private XingSeeker(long dataStartPosition, int xingFrameSize, long durationUs, long dataSize, long[] tableOfContents) {
        this.dataStartPosition = dataStartPosition;
        this.xingFrameSize = xingFrameSize;
        this.durationUs = durationUs;
        this.tableOfContents = tableOfContents;
        this.dataSize = dataSize;
        this.dataEndPosition = dataSize != -1 ? dataStartPosition + dataSize : -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.tableOfContents != null;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long timeUs) {
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.dataStartPosition + this.xingFrameSize));
        }
        long jConstrainValue = Util.constrainValue(timeUs, 0L, this.durationUs);
        double d = jConstrainValue;
        Double.isNaN(d);
        double d2 = this.durationUs;
        Double.isNaN(d2);
        double d3 = (d * 100.0d) / d2;
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i = (int) d3;
                double d5 = ((long[]) Assertions.checkNotNull(this.tableOfContents))[i];
                double d6 = i == 99 ? 256.0d : r3[i + 1];
                double d7 = i;
                Double.isNaN(d7);
                Double.isNaN(d5);
                Double.isNaN(d5);
                d4 = d5 + ((d3 - d7) * (d6 - d5));
            }
        }
        double d8 = this.dataSize;
        Double.isNaN(d8);
        return new SeekMap.SeekPoints(new SeekPoint(jConstrainValue, this.dataStartPosition + Util.constrainValue(Math.round((d4 / 256.0d) * d8), this.xingFrameSize, this.dataSize - 1)));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long position) {
        double d;
        long j = position - this.dataStartPosition;
        if (!isSeekable() || j <= this.xingFrameSize) {
            return 0L;
        }
        long[] jArr = (long[]) Assertions.checkNotNull(this.tableOfContents);
        double d2 = j;
        Double.isNaN(d2);
        double d3 = this.dataSize;
        Double.isNaN(d3);
        double d4 = (d2 * 256.0d) / d3;
        int iBinarySearchFloor = Util.binarySearchFloor(jArr, (long) d4, true, true);
        long timeUsForTableIndex = getTimeUsForTableIndex(iBinarySearchFloor);
        long j2 = jArr[iBinarySearchFloor];
        int i = iBinarySearchFloor + 1;
        long timeUsForTableIndex2 = getTimeUsForTableIndex(i);
        long j3 = iBinarySearchFloor == 99 ? 256L : jArr[i];
        if (j2 == j3) {
            d = 0.0d;
        } else {
            double d5 = j2;
            Double.isNaN(d5);
            double d6 = j3 - j2;
            Double.isNaN(d6);
            d = (d4 - d5) / d6;
        }
        double d7 = timeUsForTableIndex2 - timeUsForTableIndex;
        Double.isNaN(d7);
        return timeUsForTableIndex + Math.round(d * d7);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    private long getTimeUsForTableIndex(int tableIndex) {
        return (this.durationUs * tableIndex) / 100;
    }
}
