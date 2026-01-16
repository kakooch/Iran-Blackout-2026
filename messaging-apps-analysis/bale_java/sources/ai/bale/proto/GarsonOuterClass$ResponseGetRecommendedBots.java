package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC15232jE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonOuterClass$ResponseGetRecommendedBots extends GeneratedMessageLite implements U64 {
    public static final int BOTS_FIELD_NUMBER = 1;
    private static final GarsonOuterClass$ResponseGetRecommendedBots DEFAULT_INSTANCE;
    public static final int MORE_BOTS_URL_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private B.j bots_ = GeneratedMessageLite.emptyProtobufList();
    private StringValue moreBotsUrl_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonOuterClass$ResponseGetRecommendedBots.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$ResponseGetRecommendedBots garsonOuterClass$ResponseGetRecommendedBots = new GarsonOuterClass$ResponseGetRecommendedBots();
        DEFAULT_INSTANCE = garsonOuterClass$ResponseGetRecommendedBots;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$ResponseGetRecommendedBots.class, garsonOuterClass$ResponseGetRecommendedBots);
    }

    private GarsonOuterClass$ResponseGetRecommendedBots() {
    }

    private void addAllBots(Iterable<? extends GarsonStruct$GarsonBot> iterable) {
        ensureBotsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bots_);
    }

    private void addBots(GarsonStruct$GarsonBot garsonStruct$GarsonBot) {
        garsonStruct$GarsonBot.getClass();
        ensureBotsIsMutable();
        this.bots_.add(garsonStruct$GarsonBot);
    }

    private void clearBots() {
        this.bots_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMoreBotsUrl() {
        this.moreBotsUrl_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureBotsIsMutable() {
        B.j jVar = this.bots_;
        if (jVar.u()) {
            return;
        }
        this.bots_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMoreBotsUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.moreBotsUrl_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.moreBotsUrl_ = stringValue;
        } else {
            this.moreBotsUrl_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.moreBotsUrl_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBots(int i) {
        ensureBotsIsMutable();
        this.bots_.remove(i);
    }

    private void setBots(int i, GarsonStruct$GarsonBot garsonStruct$GarsonBot) {
        garsonStruct$GarsonBot.getClass();
        ensureBotsIsMutable();
        this.bots_.set(i, garsonStruct$GarsonBot);
    }

    private void setMoreBotsUrl(StringValue stringValue) {
        stringValue.getClass();
        this.moreBotsUrl_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$ResponseGetRecommendedBots();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"bitField0_", "bots_", GarsonStruct$GarsonBot.class, "moreBotsUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$ResponseGetRecommendedBots.class) {
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

    public GarsonStruct$GarsonBot getBots(int i) {
        return (GarsonStruct$GarsonBot) this.bots_.get(i);
    }

    public int getBotsCount() {
        return this.bots_.size();
    }

    public List<GarsonStruct$GarsonBot> getBotsList() {
        return this.bots_;
    }

    public InterfaceC15232jE2 getBotsOrBuilder(int i) {
        return (InterfaceC15232jE2) this.bots_.get(i);
    }

    public List<? extends InterfaceC15232jE2> getBotsOrBuilderList() {
        return this.bots_;
    }

    public StringValue getMoreBotsUrl() {
        StringValue stringValue = this.moreBotsUrl_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasMoreBotsUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonOuterClass$ResponseGetRecommendedBots garsonOuterClass$ResponseGetRecommendedBots) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$ResponseGetRecommendedBots);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBots(int i, GarsonStruct$GarsonBot garsonStruct$GarsonBot) {
        garsonStruct$GarsonBot.getClass();
        ensureBotsIsMutable();
        this.bots_.add(i, garsonStruct$GarsonBot);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(byte[] bArr) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$ResponseGetRecommendedBots parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetRecommendedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
