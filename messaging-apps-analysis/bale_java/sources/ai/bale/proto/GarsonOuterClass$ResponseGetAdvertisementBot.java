package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15232jE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonOuterClass$ResponseGetAdvertisementBot extends GeneratedMessageLite implements U64 {
    public static final int BOTS_FIELD_NUMBER = 1;
    private static final GarsonOuterClass$ResponseGetAdvertisementBot DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j bots_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonOuterClass$ResponseGetAdvertisementBot.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$ResponseGetAdvertisementBot garsonOuterClass$ResponseGetAdvertisementBot = new GarsonOuterClass$ResponseGetAdvertisementBot();
        DEFAULT_INSTANCE = garsonOuterClass$ResponseGetAdvertisementBot;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$ResponseGetAdvertisementBot.class, garsonOuterClass$ResponseGetAdvertisementBot);
    }

    private GarsonOuterClass$ResponseGetAdvertisementBot() {
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

    private void ensureBotsIsMutable() {
        B.j jVar = this.bots_;
        if (jVar.u()) {
            return;
        }
        this.bots_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$ResponseGetAdvertisementBot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"bots_", GarsonStruct$GarsonBot.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$ResponseGetAdvertisementBot.class) {
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

    public static a newBuilder(GarsonOuterClass$ResponseGetAdvertisementBot garsonOuterClass$ResponseGetAdvertisementBot) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$ResponseGetAdvertisementBot);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBots(int i, GarsonStruct$GarsonBot garsonStruct$GarsonBot) {
        garsonStruct$GarsonBot.getClass();
        ensureBotsIsMutable();
        this.bots_.add(i, garsonStruct$GarsonBot);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(byte[] bArr) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$ResponseGetAdvertisementBot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetAdvertisementBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
