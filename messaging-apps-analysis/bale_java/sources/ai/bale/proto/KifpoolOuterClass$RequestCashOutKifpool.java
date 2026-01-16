package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
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
public final class KifpoolOuterClass$RequestCashOutKifpool extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_FIELD_NUMBER = 4;
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final KifpoolOuterClass$RequestCashOutKifpool DEFAULT_INSTANCE;
    public static final int PAN_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int TOKEN_FIELD_NUMBER = 2;
    private StringValue account_;
    private long amount_;
    private int bitField0_;
    private StringValue pan_;
    private String requestId_ = "";
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestCashOutKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestCashOutKifpool kifpoolOuterClass$RequestCashOutKifpool = new KifpoolOuterClass$RequestCashOutKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestCashOutKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestCashOutKifpool.class, kifpoolOuterClass$RequestCashOutKifpool);
    }

    private KifpoolOuterClass$RequestCashOutKifpool() {
    }

    private void clearAccount() {
        this.account_ = null;
        this.bitField0_ &= -2;
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearPan() {
        this.pan_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static KifpoolOuterClass$RequestCashOutKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAccount(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.account_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.account_ = stringValue;
        } else {
            this.account_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.account_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePan(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.pan_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.pan_ = stringValue;
        } else {
            this.pan_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.pan_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccount(StringValue stringValue) {
        stringValue.getClass();
        this.account_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setPan(StringValue stringValue) {
        stringValue.getClass();
        this.pan_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setRequestId(String str) {
        str.getClass();
        this.requestId_ = str;
    }

    private void setRequestIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.requestId_ = abstractC2383g.f0();
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
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestCashOutKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004ဉ\u0000\u0005ဉ\u0001", new Object[]{"bitField0_", "requestId_", "token_", "amount_", "account_", "pan_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestCashOutKifpool.class) {
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

    public StringValue getAccount() {
        StringValue stringValue = this.account_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getAmount() {
        return this.amount_;
    }

    public StringValue getPan() {
        StringValue stringValue = this.pan_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getRequestId() {
        return this.requestId_;
    }

    public AbstractC2383g getRequestIdBytes() {
        return AbstractC2383g.N(this.requestId_);
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasAccount() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPan() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestCashOutKifpool kifpoolOuterClass$RequestCashOutKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestCashOutKifpool);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestCashOutKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
