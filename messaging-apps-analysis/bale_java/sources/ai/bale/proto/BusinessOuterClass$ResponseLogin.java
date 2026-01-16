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
public final class BusinessOuterClass$ResponseLogin extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$ResponseLogin DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 2;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private String transactionHash_ = "";
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$ResponseLogin.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$ResponseLogin businessOuterClass$ResponseLogin = new BusinessOuterClass$ResponseLogin();
        DEFAULT_INSTANCE = businessOuterClass$ResponseLogin;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$ResponseLogin.class, businessOuterClass$ResponseLogin);
    }

    private BusinessOuterClass$ResponseLogin() {
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static BusinessOuterClass$ResponseLogin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$ResponseLogin parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTransactionHash(String str) {
        str.getClass();
        this.transactionHash_ = str;
    }

    private void setTransactionHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionHash_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$ResponseLogin();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"userId_", "transactionHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$ResponseLogin.class) {
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

    public String getTransactionHash() {
        return this.transactionHash_;
    }

    public AbstractC2383g getTransactionHashBytes() {
        return AbstractC2383g.N(this.transactionHash_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(BusinessOuterClass$ResponseLogin businessOuterClass$ResponseLogin) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$ResponseLogin);
    }

    public static BusinessOuterClass$ResponseLogin parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(byte[] bArr) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$ResponseLogin parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$ResponseLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
