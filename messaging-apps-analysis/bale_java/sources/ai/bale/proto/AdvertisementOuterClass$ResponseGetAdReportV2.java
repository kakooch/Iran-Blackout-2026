package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AdCountData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetAdReportV2 extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetAdReportV2 DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$AdCountData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetAdReportV2.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetAdReportV2 advertisementOuterClass$ResponseGetAdReportV2 = new AdvertisementOuterClass$ResponseGetAdReportV2();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetAdReportV2;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetAdReportV2.class, advertisementOuterClass$ResponseGetAdReportV2);
    }

    private AdvertisementOuterClass$ResponseGetAdReportV2() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementStruct$AdCountData advertisementStruct$AdCountData) {
        advertisementStruct$AdCountData.getClass();
        AdvertisementStruct$AdCountData advertisementStruct$AdCountData2 = this.data_;
        if (advertisementStruct$AdCountData2 == null || advertisementStruct$AdCountData2 == AdvertisementStruct$AdCountData.getDefaultInstance()) {
            this.data_ = advertisementStruct$AdCountData;
        } else {
            this.data_ = (AdvertisementStruct$AdCountData) ((AdvertisementStruct$AdCountData.a) AdvertisementStruct$AdCountData.newBuilder(this.data_).v(advertisementStruct$AdCountData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementStruct$AdCountData advertisementStruct$AdCountData) {
        advertisementStruct$AdCountData.getClass();
        this.data_ = advertisementStruct$AdCountData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetAdReportV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetAdReportV2.class) {
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

    public AdvertisementStruct$AdCountData getData() {
        AdvertisementStruct$AdCountData advertisementStruct$AdCountData = this.data_;
        return advertisementStruct$AdCountData == null ? AdvertisementStruct$AdCountData.getDefaultInstance() : advertisementStruct$AdCountData;
    }

    public boolean hasData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetAdReportV2 advertisementOuterClass$ResponseGetAdReportV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetAdReportV2);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetAdReportV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
