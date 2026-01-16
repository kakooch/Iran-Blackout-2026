package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$RequestGetWebappHash extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    public static final int DATA_FIELD_NUMBER = 2;
    private static final KetfOuterClass$RequestGetWebappHash DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botUserId_;
    private String data_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$RequestGetWebappHash.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$RequestGetWebappHash ketfOuterClass$RequestGetWebappHash = new KetfOuterClass$RequestGetWebappHash();
        DEFAULT_INSTANCE = ketfOuterClass$RequestGetWebappHash;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestGetWebappHash.class, ketfOuterClass$RequestGetWebappHash);
    }

    private KetfOuterClass$RequestGetWebappHash() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    private void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    public static KetfOuterClass$RequestGetWebappHash getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestGetWebappHash parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    private void setData(String str) {
        str.getClass();
        this.data_ = str;
    }

    private void setDataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.data_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestGetWebappHash();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"botUserId_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestGetWebappHash.class) {
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

    public String getData() {
        return this.data_;
    }

    public AbstractC2383g getDataBytes() {
        return AbstractC2383g.N(this.data_);
    }

    public static a newBuilder(KetfOuterClass$RequestGetWebappHash ketfOuterClass$RequestGetWebappHash) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestGetWebappHash);
    }

    public static KetfOuterClass$RequestGetWebappHash parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestGetWebappHash parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
