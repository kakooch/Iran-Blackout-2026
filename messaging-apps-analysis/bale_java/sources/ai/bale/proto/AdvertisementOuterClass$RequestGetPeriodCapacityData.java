package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetPeriodCapacityData extends GeneratedMessageLite implements U64 {
    public static final int BEGIN_DATE_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestGetPeriodCapacityData DEFAULT_INSTANCE;
    public static final int END_DATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private long beginDate_;
    private long endDate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetPeriodCapacityData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetPeriodCapacityData advertisementOuterClass$RequestGetPeriodCapacityData = new AdvertisementOuterClass$RequestGetPeriodCapacityData();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetPeriodCapacityData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetPeriodCapacityData.class, advertisementOuterClass$RequestGetPeriodCapacityData);
    }

    private AdvertisementOuterClass$RequestGetPeriodCapacityData() {
    }

    private void clearBeginDate() {
        this.beginDate_ = 0L;
    }

    private void clearEndDate() {
        this.endDate_ = 0L;
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBeginDate(long j) {
        this.beginDate_ = j;
    }

    private void setEndDate(long j) {
        this.endDate_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetPeriodCapacityData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"beginDate_", "endDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetPeriodCapacityData.class) {
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

    public long getBeginDate() {
        return this.beginDate_;
    }

    public long getEndDate() {
        return this.endDate_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetPeriodCapacityData advertisementOuterClass$RequestGetPeriodCapacityData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetPeriodCapacityData);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetPeriodCapacityData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
