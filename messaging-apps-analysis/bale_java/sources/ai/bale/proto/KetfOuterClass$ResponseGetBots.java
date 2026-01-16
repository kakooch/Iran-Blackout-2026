package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4780Gn3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KetfOuterClass$ResponseGetBots extends GeneratedMessageLite implements U64 {
    public static final int BOTS_FIELD_NUMBER = 2;
    private static final KetfOuterClass$ResponseGetBots DEFAULT_INSTANCE;
    public static final int PAGE_COUNT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j bots_ = GeneratedMessageLite.emptyProtobufList();
    private int pageCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseGetBots.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$ResponseGetBots ketfOuterClass$ResponseGetBots = new KetfOuterClass$ResponseGetBots();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseGetBots;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseGetBots.class, ketfOuterClass$ResponseGetBots);
    }

    private KetfOuterClass$ResponseGetBots() {
    }

    private void addAllBots(Iterable<? extends KetfStruct$Bot> iterable) {
        ensureBotsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bots_);
    }

    private void addBots(KetfStruct$Bot ketfStruct$Bot) {
        ketfStruct$Bot.getClass();
        ensureBotsIsMutable();
        this.bots_.add(ketfStruct$Bot);
    }

    private void clearBots() {
        this.bots_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPageCount() {
        this.pageCount_ = 0;
    }

    private void ensureBotsIsMutable() {
        B.j jVar = this.bots_;
        if (jVar.u()) {
            return;
        }
        this.bots_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KetfOuterClass$ResponseGetBots getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseGetBots parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBots(int i) {
        ensureBotsIsMutable();
        this.bots_.remove(i);
    }

    private void setBots(int i, KetfStruct$Bot ketfStruct$Bot) {
        ketfStruct$Bot.getClass();
        ensureBotsIsMutable();
        this.bots_.set(i, ketfStruct$Bot);
    }

    private void setPageCount(int i) {
        this.pageCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseGetBots();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002\u001b", new Object[]{"pageCount_", "bots_", KetfStruct$Bot.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseGetBots.class) {
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

    public KetfStruct$Bot getBots(int i) {
        return (KetfStruct$Bot) this.bots_.get(i);
    }

    public int getBotsCount() {
        return this.bots_.size();
    }

    public List<KetfStruct$Bot> getBotsList() {
        return this.bots_;
    }

    public InterfaceC4780Gn3 getBotsOrBuilder(int i) {
        return (InterfaceC4780Gn3) this.bots_.get(i);
    }

    public List<? extends InterfaceC4780Gn3> getBotsOrBuilderList() {
        return this.bots_;
    }

    public int getPageCount() {
        return this.pageCount_;
    }

    public static a newBuilder(KetfOuterClass$ResponseGetBots ketfOuterClass$ResponseGetBots) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseGetBots);
    }

    public static KetfOuterClass$ResponseGetBots parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBots(int i, KetfStruct$Bot ketfStruct$Bot) {
        ketfStruct$Bot.getClass();
        ensureBotsIsMutable();
        this.bots_.add(i, ketfStruct$Bot);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseGetBots parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
