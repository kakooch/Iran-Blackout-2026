package ai.bale.proto;

import ai.bale.proto.GarsonStruct$CategorizedBots;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonOuterClass$ResponseGetBotsByCategory extends GeneratedMessageLite implements U64 {
    public static final int BOTS_FIELD_NUMBER = 1;
    private static final GarsonOuterClass$ResponseGetBotsByCategory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private GarsonStruct$CategorizedBots bots_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonOuterClass$ResponseGetBotsByCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$ResponseGetBotsByCategory garsonOuterClass$ResponseGetBotsByCategory = new GarsonOuterClass$ResponseGetBotsByCategory();
        DEFAULT_INSTANCE = garsonOuterClass$ResponseGetBotsByCategory;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$ResponseGetBotsByCategory.class, garsonOuterClass$ResponseGetBotsByCategory);
    }

    private GarsonOuterClass$ResponseGetBotsByCategory() {
    }

    private void clearBots() {
        this.bots_ = null;
        this.bitField0_ &= -2;
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBots(GarsonStruct$CategorizedBots garsonStruct$CategorizedBots) {
        garsonStruct$CategorizedBots.getClass();
        GarsonStruct$CategorizedBots garsonStruct$CategorizedBots2 = this.bots_;
        if (garsonStruct$CategorizedBots2 == null || garsonStruct$CategorizedBots2 == GarsonStruct$CategorizedBots.getDefaultInstance()) {
            this.bots_ = garsonStruct$CategorizedBots;
        } else {
            this.bots_ = (GarsonStruct$CategorizedBots) ((GarsonStruct$CategorizedBots.a) GarsonStruct$CategorizedBots.newBuilder(this.bots_).v(garsonStruct$CategorizedBots)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBots(GarsonStruct$CategorizedBots garsonStruct$CategorizedBots) {
        garsonStruct$CategorizedBots.getClass();
        this.bots_ = garsonStruct$CategorizedBots;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$ResponseGetBotsByCategory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "bots_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$ResponseGetBotsByCategory.class) {
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

    public GarsonStruct$CategorizedBots getBots() {
        GarsonStruct$CategorizedBots garsonStruct$CategorizedBots = this.bots_;
        return garsonStruct$CategorizedBots == null ? GarsonStruct$CategorizedBots.getDefaultInstance() : garsonStruct$CategorizedBots;
    }

    public boolean hasBots() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonOuterClass$ResponseGetBotsByCategory garsonOuterClass$ResponseGetBotsByCategory) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$ResponseGetBotsByCategory);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(byte[] bArr) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$ResponseGetBotsByCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
