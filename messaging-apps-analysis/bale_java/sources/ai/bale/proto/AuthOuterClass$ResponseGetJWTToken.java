package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthOuterClass$ResponseGetJWTToken extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$ResponseGetJWTToken DEFAULT_INSTANCE;
    public static final int JWT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue jwt_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$ResponseGetJWTToken.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseGetJWTToken authOuterClass$ResponseGetJWTToken = new AuthOuterClass$ResponseGetJWTToken();
        DEFAULT_INSTANCE = authOuterClass$ResponseGetJWTToken;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseGetJWTToken.class, authOuterClass$ResponseGetJWTToken);
    }

    private AuthOuterClass$ResponseGetJWTToken() {
    }

    private void clearJwt() {
        this.jwt_ = null;
        this.bitField0_ &= -2;
    }

    public static AuthOuterClass$ResponseGetJWTToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeJwt(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.jwt_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.jwt_ = stringValue;
        } else {
            this.jwt_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.jwt_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseGetJWTToken parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setJwt(StringValue stringValue) {
        stringValue.getClass();
        this.jwt_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseGetJWTToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "jwt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseGetJWTToken.class) {
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

    public StringValue getJwt() {
        StringValue stringValue = this.jwt_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasJwt() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AuthOuterClass$ResponseGetJWTToken authOuterClass$ResponseGetJWTToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseGetJWTToken);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseGetJWTToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
