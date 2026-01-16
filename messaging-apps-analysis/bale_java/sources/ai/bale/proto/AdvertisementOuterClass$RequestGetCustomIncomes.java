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
public final class AdvertisementOuterClass$RequestGetCustomIncomes extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetCustomIncomes DEFAULT_INSTANCE;
    public static final int END_TIME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int START_TIME_FIELD_NUMBER = 1;
    private long endTime_;
    private long startTime_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetCustomIncomes.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetCustomIncomes advertisementOuterClass$RequestGetCustomIncomes = new AdvertisementOuterClass$RequestGetCustomIncomes();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetCustomIncomes;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetCustomIncomes.class, advertisementOuterClass$RequestGetCustomIncomes);
    }

    private AdvertisementOuterClass$RequestGetCustomIncomes() {
    }

    private void clearEndTime() {
        this.endTime_ = 0L;
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEndTime(long j) {
        this.endTime_ = j;
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetCustomIncomes();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"startTime_", "endTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetCustomIncomes.class) {
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

    public long getEndTime() {
        return this.endTime_;
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetCustomIncomes advertisementOuterClass$RequestGetCustomIncomes) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetCustomIncomes);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetCustomIncomes parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
