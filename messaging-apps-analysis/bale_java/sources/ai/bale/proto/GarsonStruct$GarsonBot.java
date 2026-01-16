package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15232jE2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonBot extends GeneratedMessageLite implements InterfaceC15232jE2 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    private static final GarsonStruct$GarsonBot DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int botUserId_;
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15232jE2 {
        private a() {
            super(GarsonStruct$GarsonBot.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonBot garsonStruct$GarsonBot = new GarsonStruct$GarsonBot();
        DEFAULT_INSTANCE = garsonStruct$GarsonBot;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonBot.class, garsonStruct$GarsonBot);
    }

    private GarsonStruct$GarsonBot() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    public static GarsonStruct$GarsonBot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonBot parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonBot parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonBot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"botUserId_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonBot.class) {
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

    public int getBotUserId() {
        return this.botUserId_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public static a newBuilder(GarsonStruct$GarsonBot garsonStruct$GarsonBot) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonBot);
    }

    public static GarsonStruct$GarsonBot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonBot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonBot parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonBot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonBot parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonBot parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonBot parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonBot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonBot parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonBot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
