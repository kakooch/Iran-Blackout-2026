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
public final class AdvertisementOuterClass$RequestGetAllChannelIncomesFactor extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetAllChannelIncomesFactor DEFAULT_INSTANCE;
    public static final int MONTH_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int month_;
    private int year_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetAllChannelIncomesFactor.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetAllChannelIncomesFactor advertisementOuterClass$RequestGetAllChannelIncomesFactor = new AdvertisementOuterClass$RequestGetAllChannelIncomesFactor();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetAllChannelIncomesFactor;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetAllChannelIncomesFactor.class, advertisementOuterClass$RequestGetAllChannelIncomesFactor);
    }

    private AdvertisementOuterClass$RequestGetAllChannelIncomesFactor() {
    }

    private void clearMonth() {
        this.month_ = 0;
    }

    private void clearYear() {
        this.year_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMonth(int i) {
        this.month_ = i;
    }

    private void setYear(int i) {
        this.year_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetAllChannelIncomesFactor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"year_", "month_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor.class) {
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

    public int getMonth() {
        return this.month_;
    }

    public int getYear() {
        return this.year_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetAllChannelIncomesFactor advertisementOuterClass$RequestGetAllChannelIncomesFactor) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetAllChannelIncomesFactor);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetAllChannelIncomesFactor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
