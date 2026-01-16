package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    private final List<Format> closedCaptionFormats;
    private final int flags;

    public DefaultTsPayloadReaderFactory(int i) {
        this(i, ImmutableList.of());
    }

    public DefaultTsPayloadReaderFactory(int i, List<Format> list) {
        this.flags = i;
        this.closedCaptionFormats = list;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public TsPayloadReader createPayloadReader(int i, TsPayloadReader.EsInfo esInfo) {
        if (i == 2) {
            return new PesReader(new H262Reader(buildUserDataReader(esInfo)));
        }
        if (i == 3 || i == 4) {
            return new PesReader(new MpegAudioReader(esInfo.language));
        }
        if (i == 21) {
            return new PesReader(new Id3Reader());
        }
        if (i == 27) {
            if (isSet(4)) {
                return null;
            }
            return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
        }
        if (i == 36) {
            return new PesReader(new H265Reader(buildSeiReader(esInfo)));
        }
        if (i != 89) {
            if (i != 138) {
                if (i == 172) {
                    return new PesReader(new Ac4Reader(esInfo.language));
                }
                if (i != 257) {
                    if (i != 129) {
                        if (i != 130) {
                            if (i == 134) {
                                if (isSet(16)) {
                                    return null;
                                }
                                return new SectionReader(new PassthroughSectionPayloadReader("application/x-scte35"));
                            }
                            if (i != 135) {
                                switch (i) {
                                    case 15:
                                        if (isSet(2)) {
                                            return null;
                                        }
                                        return new PesReader(new AdtsReader(false, esInfo.language));
                                    case 16:
                                        return new PesReader(new H263Reader(buildUserDataReader(esInfo)));
                                    case 17:
                                        if (isSet(2)) {
                                            return null;
                                        }
                                        return new PesReader(new LatmReader(esInfo.language));
                                    default:
                                        return null;
                                }
                            }
                        } else if (!isSet(64)) {
                            return null;
                        }
                    }
                    return new PesReader(new Ac3Reader(esInfo.language));
                }
                return new SectionReader(new PassthroughSectionPayloadReader("application/vnd.dvb.ait"));
            }
            return new PesReader(new DtsReader(esInfo.language));
        }
        return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(getClosedCaptionFormats(esInfo));
    }

    private UserDataReader buildUserDataReader(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(getClosedCaptionFormats(esInfo));
    }

    private List<Format> getClosedCaptionFormats(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i;
        if (isSet(32)) {
            return this.closedCaptionFormats;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        List<Format> arrayList = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (unsignedByte == 134) {
                arrayList = new ArrayList<>();
                int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < unsignedByte2; i2++) {
                    String string = parsableByteArray.readString(3);
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z = (unsignedByte3 & 128) != 0;
                    if (z) {
                        i = unsignedByte3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte unsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    List<byte[]> listBuildCea708InitializationData = null;
                    if (z) {
                        listBuildCea708InitializationData = CodecSpecificDataUtil.buildCea708InitializationData((unsignedByte4 & 64) != 0);
                    }
                    arrayList.add(new Format.Builder().setSampleMimeType(str).setLanguage(string).setAccessibilityChannel(i).setInitializationData(listBuildCea708InitializationData).build());
                }
            }
            parsableByteArray.setPosition(position);
        }
        return arrayList;
    }

    private boolean isSet(int i) {
        return (i & this.flags) != 0;
    }
}
