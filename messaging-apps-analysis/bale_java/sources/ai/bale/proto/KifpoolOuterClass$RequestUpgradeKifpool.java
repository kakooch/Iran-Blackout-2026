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
public final class KifpoolOuterClass$RequestUpgradeKifpool extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_NO_FIELD_NUMBER = 4;
    public static final int CARD_NO_FIELD_NUMBER = 3;
    private static final KifpoolOuterClass$RequestUpgradeKifpool DEFAULT_INSTANCE;
    public static final int NATIONAL_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REMAIN_REFERENCE_NUMBER_FIELD_NUMBER = 5;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private StringValue accountNo_;
    private int bitField0_;
    private StringValue cardNo_;
    private StringValue nationalId_;
    private String token_ = "";
    private String remainReferenceNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestUpgradeKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestUpgradeKifpool kifpoolOuterClass$RequestUpgradeKifpool = new KifpoolOuterClass$RequestUpgradeKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestUpgradeKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestUpgradeKifpool.class, kifpoolOuterClass$RequestUpgradeKifpool);
    }

    private KifpoolOuterClass$RequestUpgradeKifpool() {
    }

    private void clearAccountNo() {
        this.accountNo_ = null;
        this.bitField0_ &= -5;
    }

    private void clearCardNo() {
        this.cardNo_ = null;
        this.bitField0_ &= -3;
    }

    private void clearNationalId() {
        this.nationalId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRemainReferenceNumber() {
        this.remainReferenceNumber_ = getDefaultInstance().getRemainReferenceNumber();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAccountNo(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.accountNo_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.accountNo_ = stringValue;
        } else {
            this.accountNo_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.accountNo_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeCardNo(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.cardNo_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.cardNo_ = stringValue;
        } else {
            this.cardNo_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.cardNo_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeNationalId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nationalId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nationalId_ = stringValue;
        } else {
            this.nationalId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nationalId_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountNo(StringValue stringValue) {
        stringValue.getClass();
        this.accountNo_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setCardNo(StringValue stringValue) {
        stringValue.getClass();
        this.cardNo_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setNationalId(StringValue stringValue) {
        stringValue.getClass();
        this.nationalId_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setRemainReferenceNumber(String str) {
        str.getClass();
        this.remainReferenceNumber_ = str;
    }

    private void setRemainReferenceNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.remainReferenceNumber_ = abstractC2383g.f0();
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
                return new KifpoolOuterClass$RequestUpgradeKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005Ȉ", new Object[]{"bitField0_", "token_", "nationalId_", "cardNo_", "accountNo_", "remainReferenceNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestUpgradeKifpool.class) {
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

    public StringValue getAccountNo() {
        StringValue stringValue = this.accountNo_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getCardNo() {
        StringValue stringValue = this.cardNo_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getNationalId() {
        StringValue stringValue = this.nationalId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getRemainReferenceNumber() {
        return this.remainReferenceNumber_;
    }

    public AbstractC2383g getRemainReferenceNumberBytes() {
        return AbstractC2383g.N(this.remainReferenceNumber_);
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasAccountNo() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasCardNo() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasNationalId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestUpgradeKifpool kifpoolOuterClass$RequestUpgradeKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestUpgradeKifpool);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestUpgradeKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
