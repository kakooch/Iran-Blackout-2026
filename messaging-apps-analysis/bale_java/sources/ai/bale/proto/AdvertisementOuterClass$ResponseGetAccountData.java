package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AccountData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetAccountData extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetAccountData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$AccountData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetAccountData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetAccountData advertisementOuterClass$ResponseGetAccountData = new AdvertisementOuterClass$ResponseGetAccountData();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetAccountData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetAccountData.class, advertisementOuterClass$ResponseGetAccountData);
    }

    private AdvertisementOuterClass$ResponseGetAccountData() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$ResponseGetAccountData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementStruct$AccountData advertisementStruct$AccountData) {
        advertisementStruct$AccountData.getClass();
        AdvertisementStruct$AccountData advertisementStruct$AccountData2 = this.data_;
        if (advertisementStruct$AccountData2 == null || advertisementStruct$AccountData2 == AdvertisementStruct$AccountData.getDefaultInstance()) {
            this.data_ = advertisementStruct$AccountData;
        } else {
            this.data_ = (AdvertisementStruct$AccountData) ((AdvertisementStruct$AccountData.b) AdvertisementStruct$AccountData.newBuilder(this.data_).v(advertisementStruct$AccountData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementStruct$AccountData advertisementStruct$AccountData) {
        advertisementStruct$AccountData.getClass();
        this.data_ = advertisementStruct$AccountData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetAccountData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetAccountData.class) {
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

    public AdvertisementStruct$AccountData getData() {
        AdvertisementStruct$AccountData advertisementStruct$AccountData = this.data_;
        return advertisementStruct$AccountData == null ? AdvertisementStruct$AccountData.getDefaultInstance() : advertisementStruct$AccountData;
    }

    public boolean hasData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetAccountData advertisementOuterClass$ResponseGetAccountData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetAccountData);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetAccountData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
