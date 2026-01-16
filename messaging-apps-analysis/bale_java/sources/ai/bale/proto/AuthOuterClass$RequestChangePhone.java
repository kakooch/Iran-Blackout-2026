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
public final class AuthOuterClass$RequestChangePhone extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 2;
    private static final AuthOuterClass$RequestChangePhone DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 1;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 3;
    private long phoneNumber_;
    private String code_ = "";
    private String transactionHash_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$RequestChangePhone.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestChangePhone authOuterClass$RequestChangePhone = new AuthOuterClass$RequestChangePhone();
        DEFAULT_INSTANCE = authOuterClass$RequestChangePhone;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestChangePhone.class, authOuterClass$RequestChangePhone);
    }

    private AuthOuterClass$RequestChangePhone() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = 0L;
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    public static AuthOuterClass$RequestChangePhone getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestChangePhone parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    private void setPhoneNumber(long j) {
        this.phoneNumber_ = j;
    }

    private void setTransactionHash(String str) {
        str.getClass();
        this.transactionHash_ = str;
    }

    private void setTransactionHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionHash_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestChangePhone();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ", new Object[]{"phoneNumber_", "code_", "transactionHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestChangePhone.class) {
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

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public long getPhoneNumber() {
        return this.phoneNumber_;
    }

    public String getTransactionHash() {
        return this.transactionHash_;
    }

    public AbstractC2383g getTransactionHashBytes() {
        return AbstractC2383g.N(this.transactionHash_);
    }

    public static a newBuilder(AuthOuterClass$RequestChangePhone authOuterClass$RequestChangePhone) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestChangePhone);
    }

    public static AuthOuterClass$RequestChangePhone parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestChangePhone parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestChangePhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
