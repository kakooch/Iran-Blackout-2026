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
public final class PushStruct$FirebaseRegister extends GeneratedMessageLite implements U64 {
    private static final PushStruct$FirebaseRegister DEFAULT_INSTANCE;
    public static final int EXPIRATION_TIME_FIELD_NUMBER = 3;
    public static final int IS_WEB_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PROJECT_ID_FIELD_NUMBER = 2;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$Int64Value expirationTime_;
    private boolean isWeb_;
    private long projectId_;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((PushStruct$FirebaseRegister) this.b).setExpirationTime(collectionsStruct$Int64Value);
            return this;
        }

        public a B(boolean z) {
            q();
            ((PushStruct$FirebaseRegister) this.b).setIsWeb(z);
            return this;
        }

        public a C(long j) {
            q();
            ((PushStruct$FirebaseRegister) this.b).setProjectId(j);
            return this;
        }

        public a D(String str) {
            q();
            ((PushStruct$FirebaseRegister) this.b).setToken(str);
            return this;
        }

        private a() {
            super(PushStruct$FirebaseRegister.DEFAULT_INSTANCE);
        }
    }

    static {
        PushStruct$FirebaseRegister pushStruct$FirebaseRegister = new PushStruct$FirebaseRegister();
        DEFAULT_INSTANCE = pushStruct$FirebaseRegister;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$FirebaseRegister.class, pushStruct$FirebaseRegister);
    }

    private PushStruct$FirebaseRegister() {
    }

    private void clearExpirationTime() {
        this.expirationTime_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsWeb() {
        this.isWeb_ = false;
    }

    private void clearProjectId() {
        this.projectId_ = 0L;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static PushStruct$FirebaseRegister getDefaultInstance() {
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

    public static PushStruct$FirebaseRegister parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$FirebaseRegister parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpirationTime(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.expirationTime_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsWeb(boolean z) {
        this.isWeb_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectId(long j) {
        this.projectId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$FirebaseRegister();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003ဉ\u0000\u0004\u0007", new Object[]{"bitField0_", "token_", "projectId_", "expirationTime_", "isWeb_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$FirebaseRegister.class) {
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

    public CollectionsStruct$Int64Value getExpirationTime() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.expirationTime_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean getIsWeb() {
        return this.isWeb_;
    }

    public long getProjectId() {
        return this.projectId_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasExpirationTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PushStruct$FirebaseRegister pushStruct$FirebaseRegister) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$FirebaseRegister);
    }

    public static PushStruct$FirebaseRegister parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$FirebaseRegister parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$FirebaseRegister parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$FirebaseRegister parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$FirebaseRegister parseFrom(byte[] bArr) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$FirebaseRegister parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$FirebaseRegister parseFrom(InputStream inputStream) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$FirebaseRegister parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$FirebaseRegister parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$FirebaseRegister parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$FirebaseRegister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
