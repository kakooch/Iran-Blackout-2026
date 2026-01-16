package com.google.android.exoplayer2t.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2t.ParserException;
import com.google.android.exoplayer2t.extractor.Extractor;
import com.google.android.exoplayer2t.extractor.ExtractorInput;
import com.google.android.exoplayer2t.extractor.ExtractorOutput;
import com.google.android.exoplayer2t.extractor.PositionHolder;
import com.google.android.exoplayer2t.extractor.SeekMap;
import com.google.android.exoplayer2t.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.ParsableBitArray;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import com.google.android.exoplayer2t.util.TimestampAdjuster;
import com.google.android.exoplayer2t.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class TsExtractor implements Extractor {
    private int bytesSinceLastSync;
    private final SparseIntArray continuityCounters;
    private final TsDurationReader durationReader;
    private boolean hasOutputSeekMap;
    private TsPayloadReader id3Reader;
    private final int mode;
    private ExtractorOutput output;
    private final TsPayloadReader.Factory payloadReaderFactory;
    private int pcrPid;
    private boolean pendingSeekToStart;
    private int remainingPmts;
    private final List<TimestampAdjuster> timestampAdjusters;
    private final SparseBooleanArray trackIds;
    private final SparseBooleanArray trackPids;
    private boolean tracksEnded;
    private TsBinarySearchSeeker tsBinarySearchSeeker;
    private final ParsableByteArray tsPacketBuffer;
    private final SparseArray<TsPayloadReader> tsPayloadReaders;

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ int access$108(TsExtractor tsExtractor) {
        int i = tsExtractor.remainingPmts;
        tsExtractor.remainingPmts = i + 1;
        return i;
    }

    public TsExtractor(int i, int i2) {
        this(i, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(i2));
    }

    public TsExtractor(int i, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this.payloadReaderFactory = (TsPayloadReader.Factory) Assertions.checkNotNull(factory);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.timestampAdjusters = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.timestampAdjusters = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.tsPacketBuffer = new ParsableByteArray(new byte[9400], 0);
        this.trackIds = new SparseBooleanArray();
        this.trackPids = new SparseBooleanArray();
        this.tsPayloadReaders = new SparseArray<>();
        this.continuityCounters = new SparseIntArray();
        this.durationReader = new TsDurationReader();
        this.pcrPid = -1;
        resetPayloadReaders();
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        boolean z;
        byte[] bArr = this.tsPacketBuffer.data;
        extractorInput.peekFully(bArr, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z = true;
                    break;
                }
                if (bArr[(i2 * 188) + i] != 71) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                extractorInput.skipFully(i);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void seek(long j, long j2) {
        TsBinarySearchSeeker tsBinarySearchSeeker;
        Assertions.checkState(this.mode != 2);
        int size = this.timestampAdjusters.size();
        for (int i = 0; i < size; i++) {
            TimestampAdjuster timestampAdjuster = this.timestampAdjusters.get(i);
            if ((timestampAdjuster.getTimestampOffsetUs() == -9223372036854775807L) || (timestampAdjuster.getTimestampOffsetUs() != 0 && timestampAdjuster.getFirstSampleTimestampUs() != j2)) {
                timestampAdjuster.reset();
                timestampAdjuster.setFirstSampleTimestampUs(j2);
            }
        }
        if (j2 != 0 && (tsBinarySearchSeeker = this.tsBinarySearchSeeker) != null) {
            tsBinarySearchSeeker.setSeekTargetUs(j2);
        }
        this.tsPacketBuffer.reset();
        this.continuityCounters.clear();
        for (int i2 = 0; i2 < this.tsPayloadReaders.size(); i2++) {
            this.tsPayloadReaders.valueAt(i2).seek();
        }
        this.bytesSinceLastSync = 0;
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        long length = extractorInput.getLength();
        if (this.tracksEnded) {
            if (((length == -1 || this.mode == 2) ? false : true) && !this.durationReader.isDurationReadFinished()) {
                return this.durationReader.readDuration(extractorInput, positionHolder, this.pcrPid);
            }
            maybeOutputSeekMap(length);
            if (this.pendingSeekToStart) {
                this.pendingSeekToStart = false;
                seek(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    positionHolder.position = 0L;
                    return 1;
                }
            }
            TsBinarySearchSeeker tsBinarySearchSeeker = this.tsBinarySearchSeeker;
            if (tsBinarySearchSeeker != null && tsBinarySearchSeeker.isSeeking()) {
                return this.tsBinarySearchSeeker.handlePendingSeek(extractorInput, positionHolder);
            }
        }
        if (!fillBufferWithAtLeastOnePacket(extractorInput)) {
            return -1;
        }
        int iFindEndOfFirstTsPacketInBuffer = findEndOfFirstTsPacketInBuffer();
        int iLimit = this.tsPacketBuffer.limit();
        if (iFindEndOfFirstTsPacketInBuffer > iLimit) {
            return 0;
        }
        int i = this.tsPacketBuffer.readInt();
        if ((8388608 & i) != 0) {
            this.tsPacketBuffer.setPosition(iFindEndOfFirstTsPacketInBuffer);
            return 0;
        }
        int i2 = ((4194304 & i) != 0 ? 1 : 0) | 0;
        int i3 = (2096896 & i) >> 8;
        boolean z = (i & 32) != 0;
        TsPayloadReader tsPayloadReader = (i & 16) != 0 ? this.tsPayloadReaders.get(i3) : null;
        if (tsPayloadReader == null) {
            this.tsPacketBuffer.setPosition(iFindEndOfFirstTsPacketInBuffer);
            return 0;
        }
        if (this.mode != 2) {
            int i4 = i & 15;
            int i5 = this.continuityCounters.get(i3, i4 - 1);
            this.continuityCounters.put(i3, i4);
            if (i5 == i4) {
                this.tsPacketBuffer.setPosition(iFindEndOfFirstTsPacketInBuffer);
                return 0;
            }
            if (i4 != ((i5 + 1) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z) {
            int unsignedByte = this.tsPacketBuffer.readUnsignedByte();
            i2 |= (this.tsPacketBuffer.readUnsignedByte() & 64) != 0 ? 2 : 0;
            this.tsPacketBuffer.skipBytes(unsignedByte - 1);
        }
        boolean z2 = this.tracksEnded;
        if (shouldConsumePacketPayload(i3)) {
            this.tsPacketBuffer.setLimit(iFindEndOfFirstTsPacketInBuffer);
            tsPayloadReader.consume(this.tsPacketBuffer, i2);
            this.tsPacketBuffer.setLimit(iLimit);
        }
        if (this.mode != 2 && !z2 && this.tracksEnded && length != -1) {
            this.pendingSeekToStart = true;
        }
        this.tsPacketBuffer.setPosition(iFindEndOfFirstTsPacketInBuffer);
        return 0;
    }

    private void maybeOutputSeekMap(long j) {
        if (this.hasOutputSeekMap) {
            return;
        }
        this.hasOutputSeekMap = true;
        if (this.durationReader.getDurationUs() != -9223372036854775807L) {
            TsBinarySearchSeeker tsBinarySearchSeeker = new TsBinarySearchSeeker(this.durationReader.getPcrTimestampAdjuster(), this.durationReader.getDurationUs(), j, this.pcrPid);
            this.tsBinarySearchSeeker = tsBinarySearchSeeker;
            this.output.seekMap(tsBinarySearchSeeker.getSeekMap());
            return;
        }
        this.output.seekMap(new SeekMap.Unseekable(this.durationReader.getDurationUs()));
    }

    private boolean fillBufferWithAtLeastOnePacket(ExtractorInput extractorInput) throws InterruptedException, IOException {
        ParsableByteArray parsableByteArray = this.tsPacketBuffer;
        byte[] bArr = parsableByteArray.data;
        if (9400 - parsableByteArray.getPosition() < 188) {
            int iBytesLeft = this.tsPacketBuffer.bytesLeft();
            if (iBytesLeft > 0) {
                System.arraycopy(bArr, this.tsPacketBuffer.getPosition(), bArr, 0, iBytesLeft);
            }
            this.tsPacketBuffer.reset(bArr, iBytesLeft);
        }
        while (this.tsPacketBuffer.bytesLeft() < 188) {
            int iLimit = this.tsPacketBuffer.limit();
            int i = extractorInput.read(bArr, iLimit, 9400 - iLimit);
            if (i == -1) {
                return false;
            }
            this.tsPacketBuffer.setLimit(iLimit + i);
        }
        return true;
    }

    private int findEndOfFirstTsPacketInBuffer() throws ParserException {
        int position = this.tsPacketBuffer.getPosition();
        int iLimit = this.tsPacketBuffer.limit();
        int iFindSyncBytePosition = TsUtil.findSyncBytePosition(this.tsPacketBuffer.data, position, iLimit);
        this.tsPacketBuffer.setPosition(iFindSyncBytePosition);
        int i = iFindSyncBytePosition + 188;
        if (i > iLimit) {
            int i2 = this.bytesSinceLastSync + (iFindSyncBytePosition - position);
            this.bytesSinceLastSync = i2;
            if (this.mode == 2 && i2 > 376) {
                throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.bytesSinceLastSync = 0;
        }
        return i;
    }

    private boolean shouldConsumePacketPayload(int i) {
        return this.mode == 2 || this.tracksEnded || !this.trackPids.get(i, false);
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        SparseArray<TsPayloadReader> sparseArrayCreateInitialPayloadReaders = this.payloadReaderFactory.createInitialPayloadReaders();
        int size = sparseArrayCreateInitialPayloadReaders.size();
        for (int i = 0; i < size; i++) {
            this.tsPayloadReaders.put(sparseArrayCreateInitialPayloadReaders.keyAt(i), sparseArrayCreateInitialPayloadReaders.valueAt(i));
        }
        this.tsPayloadReaders.put(0, new SectionReader(new PatReader()));
        this.id3Reader = null;
    }

    private class PatReader implements SectionPayloadReader {
        private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);

        @Override // com.google.android.exoplayer2t.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }

        public PatReader() {
        }

        @Override // com.google.android.exoplayer2t.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.readUnsignedByte() == 0 && (parsableByteArray.readUnsignedByte() & 128) != 0) {
                parsableByteArray.skipBytes(6);
                int iBytesLeft = parsableByteArray.bytesLeft() / 4;
                for (int i = 0; i < iBytesLeft; i++) {
                    parsableByteArray.readBytes(this.patScratch, 4);
                    int bits = this.patScratch.readBits(16);
                    this.patScratch.skipBits(3);
                    if (bits == 0) {
                        this.patScratch.skipBits(13);
                    } else {
                        int bits2 = this.patScratch.readBits(13);
                        TsExtractor.this.tsPayloadReaders.put(bits2, new SectionReader(TsExtractor.this.new PmtReader(bits2)));
                        TsExtractor.access$108(TsExtractor.this);
                    }
                }
                if (TsExtractor.this.mode != 2) {
                    TsExtractor.this.tsPayloadReaders.remove(0);
                }
            }
        }
    }

    private class PmtReader implements SectionPayloadReader {
        private final int pid;
        private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
        private final SparseArray<TsPayloadReader> trackIdToReaderScratch = new SparseArray<>();
        private final SparseIntArray trackIdToPidScratch = new SparseIntArray();

        @Override // com.google.android.exoplayer2t.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }

        public PmtReader(int i) {
            this.pid = i;
        }

        @Override // com.google.android.exoplayer2t.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            if (parsableByteArray.readUnsignedByte() != 2) {
                return;
            }
            if (TsExtractor.this.mode == 1 || TsExtractor.this.mode == 2 || TsExtractor.this.remainingPmts == 1) {
                timestampAdjuster = (TimestampAdjuster) TsExtractor.this.timestampAdjusters.get(0);
            } else {
                timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) TsExtractor.this.timestampAdjusters.get(0)).getFirstSampleTimestampUs());
                TsExtractor.this.timestampAdjusters.add(timestampAdjuster);
            }
            if ((parsableByteArray.readUnsignedByte() & 128) == 0) {
                return;
            }
            parsableByteArray.skipBytes(1);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            int i = 3;
            parsableByteArray.skipBytes(3);
            parsableByteArray.readBytes(this.pmtScratch, 2);
            this.pmtScratch.skipBits(3);
            int i2 = 13;
            TsExtractor.this.pcrPid = this.pmtScratch.readBits(13);
            parsableByteArray.readBytes(this.pmtScratch, 2);
            int i3 = 4;
            this.pmtScratch.skipBits(4);
            parsableByteArray.skipBytes(this.pmtScratch.readBits(12));
            if (TsExtractor.this.mode == 2 && TsExtractor.this.id3Reader == null) {
                TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, null, null, Util.EMPTY_BYTE_ARRAY);
                TsExtractor tsExtractor = TsExtractor.this;
                tsExtractor.id3Reader = tsExtractor.payloadReaderFactory.createPayloadReader(21, esInfo);
                TsExtractor.this.id3Reader.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(unsignedShort, 21, 8192));
            }
            this.trackIdToReaderScratch.clear();
            this.trackIdToPidScratch.clear();
            int iBytesLeft = parsableByteArray.bytesLeft();
            while (iBytesLeft > 0) {
                parsableByteArray.readBytes(this.pmtScratch, 5);
                int bits = this.pmtScratch.readBits(8);
                this.pmtScratch.skipBits(i);
                int bits2 = this.pmtScratch.readBits(i2);
                this.pmtScratch.skipBits(i3);
                int bits3 = this.pmtScratch.readBits(12);
                TsPayloadReader.EsInfo esInfo2 = readEsInfo(parsableByteArray, bits3);
                if (bits == 6) {
                    bits = esInfo2.streamType;
                }
                iBytesLeft -= bits3 + 5;
                int i4 = TsExtractor.this.mode == 2 ? bits : bits2;
                if (!TsExtractor.this.trackIds.get(i4)) {
                    TsPayloadReader tsPayloadReaderCreatePayloadReader = (TsExtractor.this.mode == 2 && bits == 21) ? TsExtractor.this.id3Reader : TsExtractor.this.payloadReaderFactory.createPayloadReader(bits, esInfo2);
                    if (TsExtractor.this.mode != 2 || bits2 < this.trackIdToPidScratch.get(i4, 8192)) {
                        this.trackIdToPidScratch.put(i4, bits2);
                        this.trackIdToReaderScratch.put(i4, tsPayloadReaderCreatePayloadReader);
                    }
                }
                i = 3;
                i3 = 4;
                i2 = 13;
            }
            int size = this.trackIdToPidScratch.size();
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = this.trackIdToPidScratch.keyAt(i5);
                int iValueAt = this.trackIdToPidScratch.valueAt(i5);
                TsExtractor.this.trackIds.put(iKeyAt, true);
                TsExtractor.this.trackPids.put(iValueAt, true);
                TsPayloadReader tsPayloadReaderValueAt = this.trackIdToReaderScratch.valueAt(i5);
                if (tsPayloadReaderValueAt != null) {
                    if (tsPayloadReaderValueAt != TsExtractor.this.id3Reader) {
                        tsPayloadReaderValueAt.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(unsignedShort, iKeyAt, 8192));
                    }
                    TsExtractor.this.tsPayloadReaders.put(iValueAt, tsPayloadReaderValueAt);
                }
            }
            if (TsExtractor.this.mode == 2) {
                if (TsExtractor.this.tracksEnded) {
                    return;
                }
                TsExtractor.this.output.endTracks();
                TsExtractor.this.remainingPmts = 0;
                TsExtractor.this.tracksEnded = true;
                return;
            }
            TsExtractor.this.tsPayloadReaders.remove(this.pid);
            TsExtractor tsExtractor2 = TsExtractor.this;
            tsExtractor2.remainingPmts = tsExtractor2.mode != 1 ? TsExtractor.this.remainingPmts - 1 : 0;
            if (TsExtractor.this.remainingPmts == 0) {
                TsExtractor.this.output.endTracks();
                TsExtractor.this.tracksEnded = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.google.android.exoplayer2t.extractor.ts.TsPayloadReader.EsInfo readEsInfo(com.google.android.exoplayer2t.util.ParsableByteArray r14, int r15) {
            /*
                r13 = this;
                int r0 = r14.getPosition()
                int r15 = r15 + r0
                r1 = 0
                r2 = -1
                r2 = r1
                r3 = -1
            L9:
                int r4 = r14.getPosition()
                if (r4 >= r15) goto Lb4
                int r4 = r14.readUnsignedByte()
                int r5 = r14.readUnsignedByte()
                int r6 = r14.getPosition()
                int r6 = r6 + r5
                r5 = 5
                r7 = 89
                r8 = 172(0xac, float:2.41E-43)
                r9 = 135(0x87, float:1.89E-43)
                r10 = 129(0x81, float:1.81E-43)
                if (r4 != r5) goto L4f
                long r4 = r14.readUnsignedInt()
                r11 = 1094921523(0x41432d33, double:5.409631094E-315)
                int r7 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r7 != 0) goto L33
                goto L53
            L33:
                r10 = 1161904947(0x45414333, double:5.74057318E-315)
                int r7 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r7 != 0) goto L3b
                goto L5a
            L3b:
                r9 = 1094921524(0x41432d34, double:5.4096311E-315)
                int r7 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r7 != 0) goto L45
            L42:
                r3 = 172(0xac, float:2.41E-43)
                goto Laa
            L45:
                r7 = 1212503619(0x48455643, double:5.990563836E-315)
                int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                if (r9 != 0) goto Laa
                r3 = 36
                goto Laa
            L4f:
                r5 = 106(0x6a, float:1.49E-43)
                if (r4 != r5) goto L56
            L53:
                r3 = 129(0x81, float:1.81E-43)
                goto Laa
            L56:
                r5 = 122(0x7a, float:1.71E-43)
                if (r4 != r5) goto L5d
            L5a:
                r3 = 135(0x87, float:1.89E-43)
                goto Laa
            L5d:
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 != r5) goto L6a
                int r4 = r14.readUnsignedByte()
                r5 = 21
                if (r4 != r5) goto Laa
                goto L42
            L6a:
                r5 = 123(0x7b, float:1.72E-43)
                if (r4 != r5) goto L71
                r3 = 138(0x8a, float:1.93E-43)
                goto Laa
            L71:
                r5 = 10
                r8 = 3
                if (r4 != r5) goto L7f
                java.lang.String r1 = r14.readString(r8)
                java.lang.String r1 = r1.trim()
                goto Laa
            L7f:
                if (r4 != r7) goto Laa
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
            L86:
                int r3 = r14.getPosition()
                if (r3 >= r6) goto La8
                java.lang.String r3 = r14.readString(r8)
                java.lang.String r3 = r3.trim()
                int r4 = r14.readUnsignedByte()
                r5 = 4
                byte[] r9 = new byte[r5]
                r10 = 0
                r14.readBytes(r9, r10, r5)
                com.google.android.exoplayer2t.extractor.ts.TsPayloadReader$DvbSubtitleInfo r5 = new com.google.android.exoplayer2t.extractor.ts.TsPayloadReader$DvbSubtitleInfo
                r5.<init>(r3, r4, r9)
                r2.add(r5)
                goto L86
            La8:
                r3 = 89
            Laa:
                int r4 = r14.getPosition()
                int r6 = r6 - r4
                r14.skipBytes(r6)
                goto L9
            Lb4:
                r14.setPosition(r15)
                com.google.android.exoplayer2t.extractor.ts.TsPayloadReader$EsInfo r4 = new com.google.android.exoplayer2t.extractor.ts.TsPayloadReader$EsInfo
                byte[] r14 = r14.data
                byte[] r14 = java.util.Arrays.copyOfRange(r14, r0, r15)
                r4.<init>(r3, r1, r2, r14)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2t.extractor.ts.TsExtractor.PmtReader.readEsInfo(com.google.android.exoplayer2t.util.ParsableByteArray, int):com.google.android.exoplayer2t.extractor.ts.TsPayloadReader$EsInfo");
        }
    }
}
