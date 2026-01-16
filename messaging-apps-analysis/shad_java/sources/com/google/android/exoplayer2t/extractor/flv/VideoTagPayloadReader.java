package com.google.android.exoplayer2t.extractor.flv;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.ParserException;
import com.google.android.exoplayer2t.extractor.TrackOutput;
import com.google.android.exoplayer2t.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2t.util.NalUnitUtil;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import com.google.android.exoplayer2t.video.AvcConfig;
import org.rbmain.messenger.MediaController;

/* loaded from: classes.dex */
final class VideoTagPayloadReader extends TagPayloadReader {
    private int frameType;
    private boolean hasOutputFormat;
    private boolean hasOutputKeyframe;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int nalUnitLengthFieldLength;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2t.extractor.flv.TagPayloadReader
    protected boolean parseHeader(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = (unsignedByte >> 4) & 15;
        int i2 = unsignedByte & 15;
        if (i2 != 7) {
            throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i2);
        }
        this.frameType = i;
        return i != 5;
    }

    @Override // com.google.android.exoplayer2t.extractor.flv.TagPayloadReader
    protected boolean parsePayload(ParsableByteArray parsableByteArray, long j) throws ParserException {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        long int24 = j + (parsableByteArray.readInt24() * 1000);
        if (unsignedByte == 0 && !this.hasOutputFormat) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.bytesLeft()]);
            parsableByteArray.readBytes(parsableByteArray2.data, 0, parsableByteArray.bytesLeft());
            AvcConfig avcConfig = AvcConfig.parse(parsableByteArray2);
            this.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
            this.output.format(Format.createVideoSampleFormat(null, MediaController.VIDEO_MIME_TYPE, null, -1, -1, avcConfig.width, avcConfig.height, -1.0f, avcConfig.initializationData, -1, avcConfig.pixelWidthAspectRatio, null));
            this.hasOutputFormat = true;
            return false;
        }
        if (unsignedByte != 1 || !this.hasOutputFormat) {
            return false;
        }
        int i = this.frameType == 1 ? 1 : 0;
        if (!this.hasOutputKeyframe && i == 0) {
            return false;
        }
        byte[] bArr = this.nalLength.data;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        int i2 = 4 - this.nalUnitLengthFieldLength;
        int i3 = 0;
        while (parsableByteArray.bytesLeft() > 0) {
            parsableByteArray.readBytes(this.nalLength.data, i2, this.nalUnitLengthFieldLength);
            this.nalLength.setPosition(0);
            int unsignedIntToInt = this.nalLength.readUnsignedIntToInt();
            this.nalStartCode.setPosition(0);
            this.output.sampleData(this.nalStartCode, 4);
            this.output.sampleData(parsableByteArray, unsignedIntToInt);
            i3 = i3 + 4 + unsignedIntToInt;
        }
        this.output.sampleMetadata(int24, i, i3, 0, null);
        this.hasOutputKeyframe = true;
        return true;
    }
}
