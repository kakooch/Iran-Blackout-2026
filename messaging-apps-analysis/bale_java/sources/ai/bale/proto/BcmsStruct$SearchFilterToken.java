package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13677ge0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BcmsStruct$SearchFilterToken extends GeneratedMessageLite implements InterfaceC13677ge0 {
    private static final BcmsStruct$SearchFilterToken DEFAULT_INSTANCE;
    public static final int IS_ENGLISH_FIELD_NUMBER = 2;
    public static final int IS_STRICT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private boolean isEnglish_;
    private boolean isStrict_;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13677ge0 {
        private a() {
            super(BcmsStruct$SearchFilterToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BcmsStruct$SearchFilterToken bcmsStruct$SearchFilterToken = new BcmsStruct$SearchFilterToken();
        DEFAULT_INSTANCE = bcmsStruct$SearchFilterToken;
        GeneratedMessageLite.registerDefaultInstance(BcmsStruct$SearchFilterToken.class, bcmsStruct$SearchFilterToken);
    }

    private BcmsStruct$SearchFilterToken() {
    }

    private void clearIsEnglish() {
        this.isEnglish_ = false;
    }

    private void clearIsStrict() {
        this.isStrict_ = false;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static BcmsStruct$SearchFilterToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BcmsStruct$SearchFilterToken parseDelimitedFrom(InputStream inputStream) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(ByteBuffer byteBuffer) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsEnglish(boolean z) {
        this.isEnglish_ = z;
    }

    private void setIsStrict(boolean z) {
        this.isStrict_ = z;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1885q.a[gVar.ordinal()]) {
            case 1:
                return new BcmsStruct$SearchFilterToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0007\u0003\u0007", new Object[]{"token_", "isEnglish_", "isStrict_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BcmsStruct$SearchFilterToken.class) {
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

    public boolean getIsEnglish() {
        return this.isEnglish_;
    }

    public boolean getIsStrict() {
        return this.isStrict_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(BcmsStruct$SearchFilterToken bcmsStruct$SearchFilterToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bcmsStruct$SearchFilterToken);
    }

    public static BcmsStruct$SearchFilterToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(byte[] bArr) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(InputStream inputStream) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BcmsStruct$SearchFilterToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BcmsStruct$SearchFilterToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
