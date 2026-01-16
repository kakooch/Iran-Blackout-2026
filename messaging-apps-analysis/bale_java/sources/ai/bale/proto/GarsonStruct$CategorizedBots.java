package ai.bale.proto;

import ai.bale.proto.GarsonStruct$BotCategory;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC10191bE2;
import ir.nasim.InterfaceC15232jE2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonStruct$CategorizedBots extends GeneratedMessageLite implements InterfaceC10191bE2 {
    public static final int BOTS_FIELD_NUMBER = 2;
    public static final int CATEGORY_FIELD_NUMBER = 1;
    private static final GarsonStruct$CategorizedBots DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private B.j bots_ = GeneratedMessageLite.emptyProtobufList();
    private GarsonStruct$BotCategory category_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC10191bE2 {
        private a() {
            super(GarsonStruct$CategorizedBots.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$CategorizedBots garsonStruct$CategorizedBots = new GarsonStruct$CategorizedBots();
        DEFAULT_INSTANCE = garsonStruct$CategorizedBots;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$CategorizedBots.class, garsonStruct$CategorizedBots);
    }

    private GarsonStruct$CategorizedBots() {
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

    private void clearCategory() {
        this.category_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureBotsIsMutable() {
        B.j jVar = this.bots_;
        if (jVar.u()) {
            return;
        }
        this.bots_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GarsonStruct$CategorizedBots getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCategory(GarsonStruct$BotCategory garsonStruct$BotCategory) {
        garsonStruct$BotCategory.getClass();
        GarsonStruct$BotCategory garsonStruct$BotCategory2 = this.category_;
        if (garsonStruct$BotCategory2 == null || garsonStruct$BotCategory2 == GarsonStruct$BotCategory.getDefaultInstance()) {
            this.category_ = garsonStruct$BotCategory;
        } else {
            this.category_ = (GarsonStruct$BotCategory) ((GarsonStruct$BotCategory.a) GarsonStruct$BotCategory.newBuilder(this.category_).v(garsonStruct$BotCategory)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$CategorizedBots parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$CategorizedBots parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setCategory(GarsonStruct$BotCategory garsonStruct$BotCategory) {
        garsonStruct$BotCategory.getClass();
        this.category_ = garsonStruct$BotCategory;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$CategorizedBots();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "category_", "bots_", GarsonStruct$GarsonBot.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$CategorizedBots.class) {
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

    public GarsonStruct$BotCategory getCategory() {
        GarsonStruct$BotCategory garsonStruct$BotCategory = this.category_;
        return garsonStruct$BotCategory == null ? GarsonStruct$BotCategory.getDefaultInstance() : garsonStruct$BotCategory;
    }

    public boolean hasCategory() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonStruct$CategorizedBots garsonStruct$CategorizedBots) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$CategorizedBots);
    }

    public static GarsonStruct$CategorizedBots parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$CategorizedBots parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$CategorizedBots parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBots(int i, GarsonStruct$GarsonBot garsonStruct$GarsonBot) {
        garsonStruct$GarsonBot.getClass();
        ensureBotsIsMutable();
        this.bots_.add(i, garsonStruct$GarsonBot);
    }

    public static GarsonStruct$CategorizedBots parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$CategorizedBots parseFrom(byte[] bArr) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$CategorizedBots parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$CategorizedBots parseFrom(InputStream inputStream) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$CategorizedBots parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$CategorizedBots parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$CategorizedBots parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$CategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
