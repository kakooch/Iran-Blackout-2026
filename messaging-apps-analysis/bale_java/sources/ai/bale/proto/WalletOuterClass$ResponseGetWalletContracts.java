package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.K38;
import ir.nasim.KW4;
import ir.nasim.P38;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class WalletOuterClass$ResponseGetWalletContracts extends GeneratedMessageLite implements U64 {
    public static final int AGREEMENT_ID_FIELD_NUMBER = 5;
    private static final WalletOuterClass$ResponseGetWalletContracts DEFAULT_INSTANCE;
    public static final int END_DATE_FIELD_NUMBER = 2;
    public static final int LIMITATIONS_FIELD_NUMBER = 4;
    public static final int MERCHANT_CUSTOMER_UNIQUE_VALUE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int START_DATE_FIELD_NUMBER = 1;
    public static final int STATUS_FIELD_NUMBER = 6;
    private long endDate_;
    private long startDate_;
    private int status_;
    private String merchantCustomerUniqueValue_ = "";
    private B.j limitations_ = GeneratedMessageLite.emptyProtobufList();
    private String agreementId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$ResponseGetWalletContracts.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$ResponseGetWalletContracts walletOuterClass$ResponseGetWalletContracts = new WalletOuterClass$ResponseGetWalletContracts();
        DEFAULT_INSTANCE = walletOuterClass$ResponseGetWalletContracts;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$ResponseGetWalletContracts.class, walletOuterClass$ResponseGetWalletContracts);
    }

    private WalletOuterClass$ResponseGetWalletContracts() {
    }

    private void addAllLimitations(Iterable<? extends WalletStruct$Limitation> iterable) {
        ensureLimitationsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.limitations_);
    }

    private void addLimitations(WalletStruct$Limitation walletStruct$Limitation) {
        walletStruct$Limitation.getClass();
        ensureLimitationsIsMutable();
        this.limitations_.add(walletStruct$Limitation);
    }

    private void clearAgreementId() {
        this.agreementId_ = getDefaultInstance().getAgreementId();
    }

    private void clearEndDate() {
        this.endDate_ = 0L;
    }

    private void clearLimitations() {
        this.limitations_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMerchantCustomerUniqueValue() {
        this.merchantCustomerUniqueValue_ = getDefaultInstance().getMerchantCustomerUniqueValue();
    }

    private void clearStartDate() {
        this.startDate_ = 0L;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void ensureLimitationsIsMutable() {
        B.j jVar = this.limitations_;
        if (jVar.u()) {
            return;
        }
        this.limitations_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static WalletOuterClass$ResponseGetWalletContracts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLimitations(int i) {
        ensureLimitationsIsMutable();
        this.limitations_.remove(i);
    }

    private void setAgreementId(String str) {
        str.getClass();
        this.agreementId_ = str;
    }

    private void setAgreementIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.agreementId_ = abstractC2383g.f0();
    }

    private void setEndDate(long j) {
        this.endDate_ = j;
    }

    private void setLimitations(int i, WalletStruct$Limitation walletStruct$Limitation) {
        walletStruct$Limitation.getClass();
        ensureLimitationsIsMutable();
        this.limitations_.set(i, walletStruct$Limitation);
    }

    private void setMerchantCustomerUniqueValue(String str) {
        str.getClass();
        this.merchantCustomerUniqueValue_ = str;
    }

    private void setMerchantCustomerUniqueValueBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.merchantCustomerUniqueValue_ = abstractC2383g.f0();
    }

    private void setStartDate(long j) {
        this.startDate_ = j;
    }

    private void setStatus(K38 k38) {
        this.status_ = k38.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$ResponseGetWalletContracts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003Ȉ\u0004\u001b\u0005Ȉ\u0006\f", new Object[]{"startDate_", "endDate_", "merchantCustomerUniqueValue_", "limitations_", WalletStruct$Limitation.class, "agreementId_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$ResponseGetWalletContracts.class) {
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

    public String getAgreementId() {
        return this.agreementId_;
    }

    public AbstractC2383g getAgreementIdBytes() {
        return AbstractC2383g.N(this.agreementId_);
    }

    public long getEndDate() {
        return this.endDate_;
    }

    public WalletStruct$Limitation getLimitations(int i) {
        return (WalletStruct$Limitation) this.limitations_.get(i);
    }

    public int getLimitationsCount() {
        return this.limitations_.size();
    }

    public List<WalletStruct$Limitation> getLimitationsList() {
        return this.limitations_;
    }

    public P38 getLimitationsOrBuilder(int i) {
        return (P38) this.limitations_.get(i);
    }

    public List<? extends P38> getLimitationsOrBuilderList() {
        return this.limitations_;
    }

    public String getMerchantCustomerUniqueValue() {
        return this.merchantCustomerUniqueValue_;
    }

    public AbstractC2383g getMerchantCustomerUniqueValueBytes() {
        return AbstractC2383g.N(this.merchantCustomerUniqueValue_);
    }

    public long getStartDate() {
        return this.startDate_;
    }

    public K38 getStatus() {
        K38 k38J = K38.j(this.status_);
        return k38J == null ? K38.UNRECOGNIZED : k38J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(WalletOuterClass$ResponseGetWalletContracts walletOuterClass$ResponseGetWalletContracts) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$ResponseGetWalletContracts);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addLimitations(int i, WalletStruct$Limitation walletStruct$Limitation) {
        walletStruct$Limitation.getClass();
        ensureLimitationsIsMutable();
        this.limitations_.add(i, walletStruct$Limitation);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(byte[] bArr) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$ResponseGetWalletContracts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletContracts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
