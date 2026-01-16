package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AdTimeRestrictData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$AdTimeRestrictData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict advertisementOuterClass$ResponseGetChannelShowAdTimeRestrict = new AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetChannelShowAdTimeRestrict;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict.class, advertisementOuterClass$ResponseGetChannelShowAdTimeRestrict);
    }

    private AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementStruct$AdTimeRestrictData advertisementStruct$AdTimeRestrictData) {
        advertisementStruct$AdTimeRestrictData.getClass();
        AdvertisementStruct$AdTimeRestrictData advertisementStruct$AdTimeRestrictData2 = this.data_;
        if (advertisementStruct$AdTimeRestrictData2 == null || advertisementStruct$AdTimeRestrictData2 == AdvertisementStruct$AdTimeRestrictData.getDefaultInstance()) {
            this.data_ = advertisementStruct$AdTimeRestrictData;
        } else {
            this.data_ = (AdvertisementStruct$AdTimeRestrictData) ((AdvertisementStruct$AdTimeRestrictData.a) AdvertisementStruct$AdTimeRestrictData.newBuilder(this.data_).v(advertisementStruct$AdTimeRestrictData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementStruct$AdTimeRestrictData advertisementStruct$AdTimeRestrictData) {
        advertisementStruct$AdTimeRestrictData.getClass();
        this.data_ = advertisementStruct$AdTimeRestrictData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public AdvertisementStruct$AdTimeRestrictData getData() {
        AdvertisementStruct$AdTimeRestrictData advertisementStruct$AdTimeRestrictData = this.data_;
        return advertisementStruct$AdTimeRestrictData == null ? AdvertisementStruct$AdTimeRestrictData.getDefaultInstance() : advertisementStruct$AdTimeRestrictData;
    }

    public boolean hasData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict advertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetChannelShowAdTimeRestrict);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
