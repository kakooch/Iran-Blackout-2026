package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

/* loaded from: classes.dex */
final class OpusReader extends StreamReader {
    private static final byte[] OPUS_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean headerRead;

    OpusReader() {
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        int iBytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = OPUS_SIGNATURE;
        if (iBytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.headerRead = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.getData()));
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(ParsableByteArray parsableByteArray, long j, StreamReader.SetupData setupData) {
        if (!this.headerRead) {
            byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit());
            setupData.format = new Format.Builder().setSampleMimeType("audio/opus").setChannelCount(OpusUtil.getChannelCount(bArrCopyOf)).setSampleRate(48000).setInitializationData(OpusUtil.buildInitializationData(bArrCopyOf)).build();
            this.headerRead = true;
            return true;
        }
        boolean z = parsableByteArray.readInt() == 1332770163;
        parsableByteArray.setPosition(0);
        return z;
    }

    private long getPacketDurationUs(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = i & 3;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (i2 != 1 && i2 != 2) {
            i3 = bArr[1] & 63;
        }
        int i4 = i >> 3;
        return i3 * (i4 >= 16 ? 2500 << r1 : i4 >= 12 ? 10000 << (r1 & 1) : (i4 & 3) == 3 ? 60000 : 10000 << r1);
    }
}
