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
public final class AdvertisementOuterClass$RequestGetCreditHistory extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetCreditHistory DEFAULT_INSTANCE;
    public static final int END_TIME_FIELD_NUMBER = 3;
    public static final int OWNER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int START_TIME_FIELD_NUMBER = 2;
    private long endTime_;
    private int ownerId_;
    private long startTime_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetCreditHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetCreditHistory advertisementOuterClass$RequestGetCreditHistory = new AdvertisementOuterClass$RequestGetCreditHistory();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetCreditHistory;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetCreditHistory.class, advertisementOuterClass$RequestGetCreditHistory);
    }

    private AdvertisementOuterClass$RequestGetCreditHistory() {
    }

    private void clearEndTime() {
        this.endTime_ = 0L;
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEndTime(long j) {
        this.endTime_ = j;
    }

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetCreditHistory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"ownerId_", "startTime_", "endTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetCreditHistory.class) {
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

    public int getOwnerId() {
        return this.ownerId_;
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetCreditHistory advertisementOuterClass$RequestGetCreditHistory) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetCreditHistory);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetCreditHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
