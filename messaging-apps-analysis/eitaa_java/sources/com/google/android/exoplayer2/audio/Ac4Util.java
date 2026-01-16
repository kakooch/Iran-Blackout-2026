package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public final class Ac4Util {
    private static final int[] SAMPLE_COUNT = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS};

    public static final class SyncFrameInfo {
        public final int bitstreamVersion;
        public final int channelCount;
        public final int frameSize;
        public final int sampleCount;
        public final int sampleRate;

        private SyncFrameInfo(int bitstreamVersion, int channelCount, int sampleRate, int frameSize, int sampleCount) {
            this.bitstreamVersion = bitstreamVersion;
            this.channelCount = channelCount;
            this.sampleRate = sampleRate;
            this.frameSize = frameSize;
            this.sampleCount = sampleCount;
        }
    }

    public static Format parseAc4AnnexEFormat(ParsableByteArray data, String trackId, String language, DrmInitData drmInitData) {
        data.skipBytes(1);
        return Format.createAudioSampleFormat(trackId, "audio/ac4", null, -1, -1, 2, ((data.readUnsignedByte() & 32) >> 5) == 1 ? 48000 : 44100, null, drmInitData, 0, language);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.audio.Ac4Util.SyncFrameInfo parseAc4SyncframeInfo(com.google.android.exoplayer2.util.ParsableBitArray r10) {
        /*
            r0 = 16
            int r1 = r10.readBits(r0)
            int r0 = r10.readBits(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L18
            r0 = 24
            int r0 = r10.readBits(r0)
            r3 = 7
            goto L19
        L18:
            r3 = 4
        L19:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L21
            int r0 = r0 + 2
        L21:
            r7 = r0
            r0 = 2
            int r1 = r10.readBits(r0)
            r3 = 3
            if (r1 != r3) goto L2f
            int r4 = readVariableBits(r10, r0)
            int r1 = r1 + r4
        L2f:
            r4 = r1
            r1 = 10
            int r1 = r10.readBits(r1)
            boolean r5 = r10.readBit()
            if (r5 == 0) goto L45
            int r5 = r10.readBits(r3)
            if (r5 <= 0) goto L45
            r10.skipBits(r0)
        L45:
            boolean r5 = r10.readBit()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r8 = 44100(0xac44, float:6.1797E-41)
            if (r5 == 0) goto L55
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L58
        L55:
            r9 = 44100(0xac44, float:6.1797E-41)
        L58:
            int r10 = r10.readBits(r2)
            r5 = 0
            if (r9 != r8) goto L69
            r8 = 13
            if (r10 != r8) goto L69
            int[] r0 = com.google.android.exoplayer2.audio.Ac4Util.SAMPLE_COUNT
            r10 = r0[r10]
            r8 = r10
            goto L99
        L69:
            if (r9 != r6) goto L98
            int[] r6 = com.google.android.exoplayer2.audio.Ac4Util.SAMPLE_COUNT
            int r8 = r6.length
            if (r10 >= r8) goto L98
            r5 = r6[r10]
            int r1 = r1 % 5
            r6 = 8
            r8 = 1
            if (r1 == r8) goto L8e
            r8 = 11
            if (r1 == r0) goto L89
            if (r1 == r3) goto L8e
            if (r1 == r2) goto L82
            goto L93
        L82:
            if (r10 == r3) goto L95
            if (r10 == r6) goto L95
            if (r10 != r8) goto L93
            goto L95
        L89:
            if (r10 == r6) goto L95
            if (r10 != r8) goto L93
            goto L95
        L8e:
            if (r10 == r3) goto L95
            if (r10 != r6) goto L93
            goto L95
        L93:
            r8 = r5
            goto L99
        L95:
            int r5 = r5 + 1
            goto L93
        L98:
            r8 = 0
        L99:
            com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo r10 = new com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo
            r5 = 2
            r0 = 0
            r3 = r10
            r6 = r9
            r9 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeInfo(com.google.android.exoplayer2.util.ParsableBitArray):com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo");
    }

    public static int parseAc4SyncframeSize(byte[] data, int syncword) {
        int i = 7;
        if (data.length < 7) {
            return -1;
        }
        int i2 = ((data[2] & 255) << 8) | (data[3] & 255);
        if (i2 == 65535) {
            i2 = ((data[4] & 255) << 16) | ((data[5] & 255) << 8) | (data[6] & 255);
        } else {
            i = 4;
        }
        if (syncword == 44097) {
            i += 2;
        }
        return i2 + i;
    }

    public static int parseAc4SyncframeAudioSampleCount(ByteBuffer buffer) {
        byte[] bArr = new byte[16];
        int iPosition = buffer.position();
        buffer.get(bArr);
        buffer.position(iPosition);
        return parseAc4SyncframeInfo(new ParsableBitArray(bArr)).sampleCount;
    }

    public static void getAc4SampleHeader(int size, ParsableByteArray buffer) {
        buffer.reset(7);
        byte[] bArr = buffer.data;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((size >> 16) & 255);
        bArr[5] = (byte) ((size >> 8) & 255);
        bArr[6] = (byte) (size & 255);
    }

    private static int readVariableBits(ParsableBitArray data, int bitsPerRead) {
        int i = 0;
        while (true) {
            int bits = i + data.readBits(bitsPerRead);
            if (!data.readBit()) {
                return bits;
            }
            i = (bits + 1) << bitsPerRead;
        }
    }
}
