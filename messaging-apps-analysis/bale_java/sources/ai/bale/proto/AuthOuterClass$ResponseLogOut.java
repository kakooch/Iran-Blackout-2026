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
public final class AuthOuterClass$ResponseLogOut extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$ResponseLogOut DEFAULT_INSTANCE;
    public static final int FUTURE_AUTH_TOKEN_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue futureAuthToken_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$ResponseLogOut.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseLogOut authOuterClass$ResponseLogOut = new AuthOuterClass$ResponseLogOut();
        DEFAULT_INSTANCE = authOuterClass$ResponseLogOut;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseLogOut.class, authOuterClass$ResponseLogOut);
    }

    private AuthOuterClass$ResponseLogOut() {
    }

    private void clearFutureAuthToken() {
        this.futureAuthToken_ = null;
        this.bitField0_ &= -2;
    }

    public static AuthOuterClass$ResponseLogOut getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFutureAuthToken(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.futureAuthToken_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.futureAuthToken_ = stringValue;
        } else {
            this.futureAuthToken_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.futureAuthToken_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseLogOut parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFutureAuthToken(StringValue stringValue) {
        stringValue.getClass();
        this.futureAuthToken_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseLogOut();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "futureAuthToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseLogOut.class) {
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

    public StringValue getFutureAuthToken() {
        StringValue stringValue = this.futureAuthToken_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasFutureAuthToken() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AuthOuterClass$ResponseLogOut authOuterClass$ResponseLogOut) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseLogOut);
    }

    public static AuthOuterClass$ResponseLogOut parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseLogOut parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
