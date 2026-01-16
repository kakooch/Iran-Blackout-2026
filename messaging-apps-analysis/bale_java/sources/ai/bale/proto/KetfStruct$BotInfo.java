package ai.bale.proto;

import ai.bale.proto.KetfStruct$InlineMode;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13189fo3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KetfStruct$BotInfo extends GeneratedMessageLite implements U64 {
    private static final KetfStruct$BotInfo DEFAULT_INSTANCE;
    public static final int INLINE_MODE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int WEB_APP_FIELD_NUMBER = 2;
    private int bitField0_;
    private KetfStruct$InlineMode inlineMode_;
    private B.j webApp_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$BotInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$BotInfo ketfStruct$BotInfo = new KetfStruct$BotInfo();
        DEFAULT_INSTANCE = ketfStruct$BotInfo;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$BotInfo.class, ketfStruct$BotInfo);
    }

    private KetfStruct$BotInfo() {
    }

    private void addAllWebApp(Iterable<? extends KetfStruct$WebApp> iterable) {
        ensureWebAppIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.webApp_);
    }

    private void addWebApp(KetfStruct$WebApp ketfStruct$WebApp) {
        ketfStruct$WebApp.getClass();
        ensureWebAppIsMutable();
        this.webApp_.add(ketfStruct$WebApp);
    }

    private void clearInlineMode() {
        this.inlineMode_ = null;
        this.bitField0_ &= -2;
    }

    private void clearWebApp() {
        this.webApp_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureWebAppIsMutable() {
        B.j jVar = this.webApp_;
        if (jVar.u()) {
            return;
        }
        this.webApp_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KetfStruct$BotInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInlineMode(KetfStruct$InlineMode ketfStruct$InlineMode) {
        ketfStruct$InlineMode.getClass();
        KetfStruct$InlineMode ketfStruct$InlineMode2 = this.inlineMode_;
        if (ketfStruct$InlineMode2 == null || ketfStruct$InlineMode2 == KetfStruct$InlineMode.getDefaultInstance()) {
            this.inlineMode_ = ketfStruct$InlineMode;
        } else {
            this.inlineMode_ = (KetfStruct$InlineMode) ((KetfStruct$InlineMode.a) KetfStruct$InlineMode.newBuilder(this.inlineMode_).v(ketfStruct$InlineMode)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$BotInfo parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$BotInfo parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeWebApp(int i) {
        ensureWebAppIsMutable();
        this.webApp_.remove(i);
    }

    private void setInlineMode(KetfStruct$InlineMode ketfStruct$InlineMode) {
        ketfStruct$InlineMode.getClass();
        this.inlineMode_ = ketfStruct$InlineMode;
        this.bitField0_ |= 1;
    }

    private void setWebApp(int i, KetfStruct$WebApp ketfStruct$WebApp) {
        ketfStruct$WebApp.getClass();
        ensureWebAppIsMutable();
        this.webApp_.set(i, ketfStruct$WebApp);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$BotInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0001\u0000\u0002\u001b\u0003ဉ\u0000", new Object[]{"bitField0_", "webApp_", KetfStruct$WebApp.class, "inlineMode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$BotInfo.class) {
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

    public KetfStruct$InlineMode getInlineMode() {
        KetfStruct$InlineMode ketfStruct$InlineMode = this.inlineMode_;
        return ketfStruct$InlineMode == null ? KetfStruct$InlineMode.getDefaultInstance() : ketfStruct$InlineMode;
    }

    public KetfStruct$WebApp getWebApp(int i) {
        return (KetfStruct$WebApp) this.webApp_.get(i);
    }

    public int getWebAppCount() {
        return this.webApp_.size();
    }

    public List<KetfStruct$WebApp> getWebAppList() {
        return this.webApp_;
    }

    public InterfaceC13189fo3 getWebAppOrBuilder(int i) {
        return (InterfaceC13189fo3) this.webApp_.get(i);
    }

    public List<? extends InterfaceC13189fo3> getWebAppOrBuilderList() {
        return this.webApp_;
    }

    public boolean hasInlineMode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfStruct$BotInfo ketfStruct$BotInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$BotInfo);
    }

    public static KetfStruct$BotInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$BotInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$BotInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addWebApp(int i, KetfStruct$WebApp ketfStruct$WebApp) {
        ketfStruct$WebApp.getClass();
        ensureWebAppIsMutable();
        this.webApp_.add(i, ketfStruct$WebApp);
    }

    public static KetfStruct$BotInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$BotInfo parseFrom(byte[] bArr) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$BotInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$BotInfo parseFrom(InputStream inputStream) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$BotInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$BotInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$BotInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$BotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
