package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
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
public final class PushStruct$WebRegister extends GeneratedMessageLite implements U64 {
    public static final int AUTH_FIELD_NUMBER = 2;
    private static final PushStruct$WebRegister DEFAULT_INSTANCE;
    public static final int ENDPOINT_FIELD_NUMBER = 1;
    public static final int EXPIRATION_TIME_FIELD_NUMBER = 4;
    public static final int P256DH_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CollectionsStruct$Int64Value expirationTime_;
    private String endpoint_ = "";
    private String auth_ = "";
    private String p256Dh_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$WebRegister.DEFAULT_INSTANCE);
        }
    }

    static {
        PushStruct$WebRegister pushStruct$WebRegister = new PushStruct$WebRegister();
        DEFAULT_INSTANCE = pushStruct$WebRegister;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$WebRegister.class, pushStruct$WebRegister);
    }

    private PushStruct$WebRegister() {
    }

    private void clearAuth() {
        this.auth_ = getDefaultInstance().getAuth();
    }

    private void clearEndpoint() {
        this.endpoint_ = getDefaultInstance().getEndpoint();
    }

    private void clearExpirationTime() {
        this.expirationTime_ = null;
        this.bitField0_ &= -2;
    }

    private void clearP256Dh() {
        this.p256Dh_ = getDefaultInstance().getP256Dh();
    }

    public static PushStruct$WebRegister getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExpirationTime(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.expirationTime_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.expirationTime_ = collectionsStruct$Int64Value;
        } else {
            this.expirationTime_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.expirationTime_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$WebRegister parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$WebRegister parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setEndpoint(String str) {
        str.getClass();
        this.endpoint_ = str;
    }

    private void setEndpointBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.endpoint_ = abstractC2383g.f0();
    }

    private void setExpirationTime(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.expirationTime_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
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
                return new PushStruct$WebRegister();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000", new Object[]{"bitField0_", "endpoint_", "auth_", "p256Dh_", "expirationTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$WebRegister.class) {
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

    public String getEndpoint() {
        return this.endpoint_;
    }

    public AbstractC2383g getEndpointBytes() {
        return AbstractC2383g.N(this.endpoint_);
    }

    public CollectionsStruct$Int64Value getExpirationTime() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.expirationTime_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public String getP256Dh() {
        return this.p256Dh_;
    }

    public AbstractC2383g getP256DhBytes() {
        return AbstractC2383g.N(this.p256Dh_);
    }

    public boolean hasExpirationTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PushStruct$WebRegister pushStruct$WebRegister) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$WebRegister);
    }

    public static PushStruct$WebRegister parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$WebRegister parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$WebRegister parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$WebRegister parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$WebRegister parseFrom(byte[] bArr) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$WebRegister parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$WebRegister parseFrom(InputStream inputStream) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$WebRegister parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$WebRegister parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$WebRegister parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$WebRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
