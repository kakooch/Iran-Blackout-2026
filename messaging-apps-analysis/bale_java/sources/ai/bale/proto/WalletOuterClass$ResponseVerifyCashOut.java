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

/* loaded from: classes.dex */
public final class WalletOuterClass$ResponseVerifyCashOut extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$ResponseVerifyCashOut DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private String token_ = "";
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$ResponseVerifyCashOut.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$ResponseVerifyCashOut walletOuterClass$ResponseVerifyCashOut = new WalletOuterClass$ResponseVerifyCashOut();
        DEFAULT_INSTANCE = walletOuterClass$ResponseVerifyCashOut;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$ResponseVerifyCashOut.class, walletOuterClass$ResponseVerifyCashOut);
    }

    private WalletOuterClass$ResponseVerifyCashOut() {
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static WalletOuterClass$ResponseVerifyCashOut getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
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
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$ResponseVerifyCashOut();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"token_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$ResponseVerifyCashOut.class) {
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

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(WalletOuterClass$ResponseVerifyCashOut walletOuterClass$ResponseVerifyCashOut) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$ResponseVerifyCashOut);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(byte[] bArr) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$ResponseVerifyCashOut parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
