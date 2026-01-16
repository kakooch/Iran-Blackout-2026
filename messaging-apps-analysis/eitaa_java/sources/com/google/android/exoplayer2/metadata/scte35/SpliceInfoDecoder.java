package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SpliceInfoDecoder implements MetadataDecoder {
    private final ParsableByteArray sectionData = new ParsableByteArray();
    private final ParsableBitArray sectionHeader = new ParsableBitArray();
    private TimestampAdjuster timestampAdjuster;

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer inputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(inputBuffer.data);
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster == null || inputBuffer.subsampleOffsetUs != timestampAdjuster.getTimestampOffsetUs()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(inputBuffer.timeUs);
            this.timestampAdjuster = timestampAdjuster2;
            timestampAdjuster2.adjustSampleTimestamp(inputBuffer.timeUs - inputBuffer.subsampleOffsetUs);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.sectionData.reset(bArrArray, iLimit);
        this.sectionHeader.reset(bArrArray, iLimit);
        this.sectionHeader.skipBits(39);
        long bits = (this.sectionHeader.readBits(1) << 32) | this.sectionHeader.readBits(32);
        this.sectionHeader.skipBits(20);
        int bits2 = this.sectionHeader.readBits(12);
        int bits3 = this.sectionHeader.readBits(8);
        Metadata.Entry spliceNullCommand = null;
        this.sectionData.skipBytes(14);
        if (bits3 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (bits3 == 255) {
            spliceNullCommand = PrivateCommand.parseFromSection(this.sectionData, bits2, bits);
        } else if (bits3 == 4) {
            spliceNullCommand = SpliceScheduleCommand.parseFromSection(this.sectionData);
        } else if (bits3 == 5) {
            spliceNullCommand = SpliceInsertCommand.parseFromSection(this.sectionData, bits, this.timestampAdjuster);
        } else if (bits3 == 6) {
            spliceNullCommand = TimeSignalCommand.parseFromSection(this.sectionData, bits, this.timestampAdjuster);
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
