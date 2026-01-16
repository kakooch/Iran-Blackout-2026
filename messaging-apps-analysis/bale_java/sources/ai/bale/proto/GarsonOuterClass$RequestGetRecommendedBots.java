package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonPagination;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonOuterClass$RequestGetRecommendedBots extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final GarsonOuterClass$RequestGetRecommendedBots DEFAULT_INSTANCE;
    public static final int PAGINATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int botId_;
    private GarsonStruct$GarsonPagination pagination_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((GarsonOuterClass$RequestGetRecommendedBots) this.b).setBotId(i);
            return this;
        }

        public a B(GarsonStruct$GarsonPagination.a aVar) {
            q();
            ((GarsonOuterClass$RequestGetRecommendedBots) this.b).setPagination((GarsonStruct$GarsonPagination) aVar.a());
            return this;
        }

        private a() {
            super(GarsonOuterClass$RequestGetRecommendedBots.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$RequestGetRecommendedBots garsonOuterClass$RequestGetRecommendedBots = new GarsonOuterClass$RequestGetRecommendedBots();
        DEFAULT_INSTANCE = garsonOuterClass$RequestGetRecommendedBots;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$RequestGetRecommendedBots.class, garsonOuterClass$RequestGetRecommendedBots);
    }

    private GarsonOuterClass$RequestGetRecommendedBots() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearPagination() {
        this.pagination_ = null;
        this.bitField0_ &= -2;
    }

    public static GarsonOuterClass$RequestGetRecommendedBots getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePagination(GarsonStruct$GarsonPagination garsonStruct$GarsonPagination) {
        garsonStruct$GarsonPagination.getClass();
        GarsonStruct$GarsonPagination garsonStruct$GarsonPagination2 = this.pagination_;
        if (garsonStruct$GarsonPagination2 == null || garsonStruct$GarsonPagination2 == GarsonStruct$GarsonPagination.getDefaultInstance()) {
            this.pagination_ = garsonStruct$GarsonPagination;
        } else {
            this.pagination_ = (GarsonStruct$GarsonPagination) ((GarsonStruct$GarsonPagination.a) GarsonStruct$GarsonPagination.newBuilder(this.pagination_).v(garsonStruct$GarsonPagination)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBotId(int i) {
        this.botId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPagination(GarsonStruct$GarsonPagination garsonStruct$GarsonPagination) {
        garsonStruct$GarsonPagination.getClass();
        this.pagination_ = garsonStruct$GarsonPagination;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$RequestGetRecommendedBots();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "botId_", "pagination_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$RequestGetRecommendedBots.class) {
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

    public int getBotId() {
        return this.botId_;
    }

    public GarsonStruct$GarsonPagination getPagination() {
        GarsonStruct$GarsonPagination garsonStruct$GarsonPagination = this.pagination_;
        return garsonStruct$GarsonPagination == null ? GarsonStruct$GarsonPagination.getDefaultInstance() : garsonStruct$GarsonPagination;
    }

    public boolean hasPagination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonOuterClass$RequestGetRecommendedBots garsonOuterClass$RequestGetRecommendedBots) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$RequestGetRecommendedBots);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(byte[] bArr) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$RequestGetRecommendedBots parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
