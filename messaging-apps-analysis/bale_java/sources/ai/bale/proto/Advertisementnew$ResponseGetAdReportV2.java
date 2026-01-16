package ai.bale.proto;

import ai.bale.proto.AdvertisementnewStruct$AdCountData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$ResponseGetAdReportV2 extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final Advertisementnew$ResponseGetAdReportV2 DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementnewStruct$AdCountData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$ResponseGetAdReportV2.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$ResponseGetAdReportV2 advertisementnew$ResponseGetAdReportV2 = new Advertisementnew$ResponseGetAdReportV2();
        DEFAULT_INSTANCE = advertisementnew$ResponseGetAdReportV2;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$ResponseGetAdReportV2.class, advertisementnew$ResponseGetAdReportV2);
    }

    private Advertisementnew$ResponseGetAdReportV2() {
    }

    private void clearData() {
        this.data_ = null;
    }

    public static Advertisementnew$ResponseGetAdReportV2 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementnewStruct$AdCountData advertisementnewStruct$AdCountData) {
        advertisementnewStruct$AdCountData.getClass();
        AdvertisementnewStruct$AdCountData advertisementnewStruct$AdCountData2 = this.data_;
        if (advertisementnewStruct$AdCountData2 == null || advertisementnewStruct$AdCountData2 == AdvertisementnewStruct$AdCountData.getDefaultInstance()) {
            this.data_ = advertisementnewStruct$AdCountData;
        } else {
            this.data_ = (AdvertisementnewStruct$AdCountData) ((AdvertisementnewStruct$AdCountData.a) AdvertisementnewStruct$AdCountData.newBuilder(this.data_).v(advertisementnewStruct$AdCountData)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementnewStruct$AdCountData advertisementnewStruct$AdCountData) {
        advertisementnewStruct$AdCountData.getClass();
        this.data_ = advertisementnewStruct$AdCountData;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$ResponseGetAdReportV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$ResponseGetAdReportV2.class) {
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

    public AdvertisementnewStruct$AdCountData getData() {
        AdvertisementnewStruct$AdCountData advertisementnewStruct$AdCountData = this.data_;
        return advertisementnewStruct$AdCountData == null ? AdvertisementnewStruct$AdCountData.getDefaultInstance() : advertisementnewStruct$AdCountData;
    }

    public boolean hasData() {
        return this.data_ != null;
    }

    public static a newBuilder(Advertisementnew$ResponseGetAdReportV2 advertisementnew$ResponseGetAdReportV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$ResponseGetAdReportV2);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(byte[] bArr) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$ResponseGetAdReportV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdReportV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
