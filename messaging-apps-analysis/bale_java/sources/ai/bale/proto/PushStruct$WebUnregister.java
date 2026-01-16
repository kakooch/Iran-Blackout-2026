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
public final class PushStruct$WebUnregister extends GeneratedMessageLite implements U64 {
    public static final int AUTH_FIELD_NUMBER = 1;
    private static final PushStruct$WebUnregister DEFAULT_INSTANCE;
    public static final int P256DH_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String auth_ = "";
    private String p256Dh_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$WebUnregister.DEFAULT_INSTANCE);
        }
    }

    static {
        PushStruct$WebUnregister pushStruct$WebUnregister = new PushStruct$WebUnregister();
        DEFAULT_INSTANCE = pushStruct$WebUnregister;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$WebUnregister.class, pushStruct$WebUnregister);
    }

    private PushStruct$WebUnregister() {
    }

    private void clearAuth() {
        this.auth_ = getDefaultInstance().getAuth();
    }

    private void clearP256Dh() {
        this.p256Dh_ = getDefaultInstance().getP256Dh();
    }

    public static PushStruct$WebUnregister getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$WebUnregister parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$WebUnregister parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAuth(String str) {
        str.getClass();
        this.auth_ = str;
    }

    private void setAuthBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.auth_ = abstractC2383g.f0();
    }

    private void setP256Dh(String str) {
        str.getClass();
        this.p256Dh_ = str;
    }

    private void setP256DhBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.p256Dh_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$WebUnregister();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"auth_", "p256Dh_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$WebUnregister.class) {
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

    public String getAuth() {
        return this.auth_;
    }

    public AbstractC2383g getAuthBytes() {
        return AbstractC2383g.N(this.auth_);
    }

    public String getP256Dh() {
        return this.p256Dh_;
    }

    public AbstractC2383g getP256DhBytes() {
        return AbstractC2383g.N(this.p256Dh_);
    }

    public static a newBuilder(PushStruct$WebUnregister pushStruct$WebUnregister) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$WebUnregister);
    }

    public static PushStruct$WebUnregister parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$WebUnregister parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$WebUnregister parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$WebUnregister parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$WebUnregister parseFrom(byte[] bArr) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$WebUnregister parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$WebUnregister parseFrom(InputStream inputStream) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$WebUnregister parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$WebUnregister parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$WebUnregister parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$WebUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
