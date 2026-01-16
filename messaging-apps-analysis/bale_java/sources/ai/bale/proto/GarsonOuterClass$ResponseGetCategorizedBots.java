package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC10191bE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonOuterClass$ResponseGetCategorizedBots extends GeneratedMessageLite implements U64 {
    public static final int CATEGORIZED_BOTS_FIELD_NUMBER = 1;
    private static final GarsonOuterClass$ResponseGetCategorizedBots DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j categorizedBots_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonOuterClass$ResponseGetCategorizedBots.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$ResponseGetCategorizedBots garsonOuterClass$ResponseGetCategorizedBots = new GarsonOuterClass$ResponseGetCategorizedBots();
        DEFAULT_INSTANCE = garsonOuterClass$ResponseGetCategorizedBots;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$ResponseGetCategorizedBots.class, garsonOuterClass$ResponseGetCategorizedBots);
    }

    private GarsonOuterClass$ResponseGetCategorizedBots() {
    }

    private void addAllCategorizedBots(Iterable<? extends GarsonStruct$CategorizedBots> iterable) {
        ensureCategorizedBotsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.categorizedBots_);
    }

    private void addCategorizedBots(GarsonStruct$CategorizedBots garsonStruct$CategorizedBots) {
        garsonStruct$CategorizedBots.getClass();
        ensureCategorizedBotsIsMutable();
        this.categorizedBots_.add(garsonStruct$CategorizedBots);
    }

    private void clearCategorizedBots() {
        this.categorizedBots_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCategorizedBotsIsMutable() {
        B.j jVar = this.categorizedBots_;
        if (jVar.u()) {
            return;
        }
        this.categorizedBots_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCategorizedBots(int i) {
        ensureCategorizedBotsIsMutable();
        this.categorizedBots_.remove(i);
    }

    private void setCategorizedBots(int i, GarsonStruct$CategorizedBots garsonStruct$CategorizedBots) {
        garsonStruct$CategorizedBots.getClass();
        ensureCategorizedBotsIsMutable();
        this.categorizedBots_.set(i, garsonStruct$CategorizedBots);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$ResponseGetCategorizedBots();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"categorizedBots_", GarsonStruct$CategorizedBots.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$ResponseGetCategorizedBots.class) {
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

    public GarsonStruct$CategorizedBots getCategorizedBots(int i) {
        return (GarsonStruct$CategorizedBots) this.categorizedBots_.get(i);
    }

    public int getCategorizedBotsCount() {
        return this.categorizedBots_.size();
    }

    public List<GarsonStruct$CategorizedBots> getCategorizedBotsList() {
        return this.categorizedBots_;
    }

    public InterfaceC10191bE2 getCategorizedBotsOrBuilder(int i) {
        return (InterfaceC10191bE2) this.categorizedBots_.get(i);
    }

    public List<? extends InterfaceC10191bE2> getCategorizedBotsOrBuilderList() {
        return this.categorizedBots_;
    }

    public static a newBuilder(GarsonOuterClass$ResponseGetCategorizedBots garsonOuterClass$ResponseGetCategorizedBots) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$ResponseGetCategorizedBots);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCategorizedBots(int i, GarsonStruct$CategorizedBots garsonStruct$CategorizedBots) {
        garsonStruct$CategorizedBots.getClass();
        ensureCategorizedBotsIsMutable();
        this.categorizedBots_.add(i, garsonStruct$CategorizedBots);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(byte[] bArr) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$ResponseGetCategorizedBots parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCategorizedBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
