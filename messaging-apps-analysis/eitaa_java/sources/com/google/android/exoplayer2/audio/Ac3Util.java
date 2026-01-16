package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import ir.eitaa.messenger.R;
import java.nio.ByteBuffer;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public final class Ac3Util {
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {48000, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, 16000};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, R.styleable.AppCompatTheme_windowActionBarOverlay, 128, 160, 192, 224, Factory.DEVICE_HAS_CRAPPY_OPENSLES, 320, 384, 448, Factory.DEVICE_USE_ANDROID_CAMCORDER, 576, 640};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, R.styleable.AppCompatTheme_textColorAlertDialogListItem, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class SyncFrameInfo {
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        private SyncFrameInfo(String mimeType, int streamType, int channelCount, int sampleRate, int frameSize, int sampleCount) {
            this.mimeType = mimeType;
            this.streamType = streamType;
            this.channelCount = channelCount;
            this.sampleRate = sampleRate;
            this.frameSize = frameSize;
            this.sampleCount = sampleCount;
        }
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray data, String trackId, String language, DrmInitData drmInitData) {
        int i = SAMPLE_RATE_BY_FSCOD[(data.readUnsignedByte() & 192) >> 6];
        int unsignedByte = data.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(unsignedByte & 56) >> 3];
        if ((unsignedByte & 4) != 0) {
            i2++;
        }
        return Format.createAudioSampleFormat(trackId, "audio/ac3", null, -1, -1, i2, i, null, drmInitData, 0, language);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray data, String trackId, String language, DrmInitData drmInitData) {
        data.skipBytes(2);
        int i = SAMPLE_RATE_BY_FSCOD[(data.readUnsignedByte() & 192) >> 6];
        int unsignedByte = data.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(unsignedByte & 14) >> 1];
        if ((unsignedByte & 1) != 0) {
            i2++;
        }
        if (((data.readUnsignedByte() & 30) >> 1) > 0 && (2 & data.readUnsignedByte()) != 0) {
            i2 += 2;
        }
        return Format.createAudioSampleFormat(trackId, (data.bytesLeft() <= 0 || (data.readUnsignedByte() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc", null, -1, -1, i2, i, null, drmInitData, 0, language);
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int bits;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int position = parsableBitArray.getPosition();
        parsableBitArray.skipBits(40);
        boolean z = parsableBitArray.readBits(5) > 10;
        parsableBitArray.setPosition(position);
        int i11 = -1;
        if (z) {
            parsableBitArray.skipBits(16);
            int bits2 = parsableBitArray.readBits(2);
            if (bits2 == 0) {
                i11 = 0;
            } else if (bits2 == 1) {
                i11 = 1;
            } else if (bits2 == 2) {
                i11 = 2;
            }
            parsableBitArray.skipBits(3);
            int bits3 = (parsableBitArray.readBits(11) + 1) * 2;
            int bits4 = parsableBitArray.readBits(2);
            if (bits4 == 3) {
                i7 = SAMPLE_RATE_BY_FSCOD2[parsableBitArray.readBits(2)];
                bits = 3;
                i6 = 6;
            } else {
                bits = parsableBitArray.readBits(2);
                i6 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[bits];
                i7 = SAMPLE_RATE_BY_FSCOD[bits4];
            }
            int i12 = i6 * Factory.DEVICE_HAS_CRAPPY_OPENSLES;
            int bits5 = parsableBitArray.readBits(3);
            boolean bit = parsableBitArray.readBit();
            int i13 = CHANNEL_COUNT_BY_ACMOD[bits5] + (bit ? 1 : 0);
            parsableBitArray.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(8);
            }
            if (bits5 == 0) {
                parsableBitArray.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
            }
            if (i11 == 1 && parsableBitArray.readBit()) {
                parsableBitArray.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (bits5 > 2) {
                    parsableBitArray.skipBits(2);
                }
                if ((bits5 & 1) == 0 || bits5 <= 2) {
                    i9 = 6;
                } else {
                    i9 = 6;
                    parsableBitArray.skipBits(6);
                }
                if ((bits5 & 4) != 0) {
                    parsableBitArray.skipBits(i9);
                }
                if (bit && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(5);
                }
                if (i11 == 0) {
                    if (parsableBitArray.readBit()) {
                        i10 = 6;
                        parsableBitArray.skipBits(6);
                    } else {
                        i10 = 6;
                    }
                    if (bits5 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(i10);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(i10);
                    }
                    int bits6 = parsableBitArray.readBits(2);
                    if (bits6 == 1) {
                        parsableBitArray.skipBits(5);
                    } else if (bits6 == 2) {
                        parsableBitArray.skipBits(12);
                    } else if (bits6 == 3) {
                        int bits7 = parsableBitArray.readBits(5);
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(7);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray.skipBits((bits7 + 2) * 8);
                        parsableBitArray.byteAlign();
                    }
                    if (bits5 < 2) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                        if (bits5 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (bits == 0) {
                            parsableBitArray.skipBits(5);
                        } else {
                            for (int i14 = 0; i14 < i6; i14++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(5);
                if (bits5 == 2) {
                    parsableBitArray.skipBits(4);
                }
                if (bits5 >= 6) {
                    parsableBitArray.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                if (bits5 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                if (bits4 < 3) {
                    parsableBitArray.skipBit();
                }
            }
            if (i11 == 0 && bits != 3) {
                parsableBitArray.skipBit();
            }
            if (i11 == 2 && (bits == 3 || parsableBitArray.readBit())) {
                i8 = 6;
                parsableBitArray.skipBits(6);
            } else {
                i8 = 6;
            }
            str = (parsableBitArray.readBit() && parsableBitArray.readBits(i8) == 1 && parsableBitArray.readBits(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i4 = i11;
            i5 = i12;
            i = bits3;
            i2 = i7;
            i3 = i13;
        } else {
            parsableBitArray.skipBits(32);
            int bits8 = parsableBitArray.readBits(2);
            String str2 = bits8 == 3 ? null : "audio/ac3";
            int ac3SyncframeSize = getAc3SyncframeSize(bits8, parsableBitArray.readBits(6));
            parsableBitArray.skipBits(8);
            int bits9 = parsableBitArray.readBits(3);
            if ((bits9 & 1) != 0 && bits9 != 1) {
                parsableBitArray.skipBits(2);
            }
            if ((bits9 & 4) != 0) {
                parsableBitArray.skipBits(2);
            }
            if (bits9 == 2) {
                parsableBitArray.skipBits(2);
            }
            int[] iArr = SAMPLE_RATE_BY_FSCOD;
            str = str2;
            i = ac3SyncframeSize;
            i2 = bits8 < iArr.length ? iArr[bits8] : -1;
            i3 = CHANNEL_COUNT_BY_ACMOD[bits9] + (parsableBitArray.readBit() ? 1 : 0);
            i4 = -1;
            i5 = 1536;
        }
        return new SyncFrameInfo(str, i4, i3, i2, i, i5);
    }

    public static int parseAc3SyncframeSize(byte[] data) {
        if (data.length < 6) {
            return -1;
        }
        if (((data[5] & 248) >> 3) > 10) {
            return (((data[3] & 255) | ((data[2] & 7) << 8)) + 1) * 2;
        }
        return getAc3SyncframeSize((data[4] & 192) >> 6, data[4] & 63);
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer buffer) {
        if (((buffer.get(buffer.position() + 5) & 248) >> 3) > 10) {
            return BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[((buffer.get(buffer.position() + 4) & 192) >> 6) != 3 ? (buffer.get(buffer.position() + 4) & 48) >> 4 : 3] * Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        }
        return 1536;
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer buffer) {
        int iPosition = buffer.position();
        int iLimit = buffer.limit() - 10;
        for (int i = iPosition; i <= iLimit; i++) {
            if ((buffer.getInt(i + 4) & (-16777217)) == -1167101192) {
                return i - iPosition;
            }
        }
        return -1;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] syncframe) {
        if (syncframe[4] == -8 && syncframe[5] == 114 && syncframe[6] == 111 && (syncframe[7] & 254) == 186) {
            return 40 << ((syncframe[(syncframe[7] & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer buffer, int offset) {
        return 40 << ((buffer.get((buffer.position() + offset) + ((buffer.get((buffer.position() + offset) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    private static int getAc3SyncframeSize(int fscod, int frmsizecod) {
        int i = frmsizecod / 2;
        if (fscod < 0) {
            return -1;
        }
        int[] iArr = SAMPLE_RATE_BY_FSCOD;
        if (fscod >= iArr.length || frmsizecod < 0) {
            return -1;
        }
        int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i >= iArr2.length) {
            return -1;
        }
        int i2 = iArr[fscod];
        if (i2 == 44100) {
            return (iArr2[i] + (frmsizecod % 2)) * 2;
        }
        int i3 = BITRATE_BY_HALF_FRMSIZECOD[i];
        return i2 == 32000 ? i3 * 6 : i3 * 4;
    }
}
