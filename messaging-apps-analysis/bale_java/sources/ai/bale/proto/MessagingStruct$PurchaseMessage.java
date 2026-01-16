package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$MultiplexingData;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC18998pc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$PurchaseMessage extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 2;
    public static final int ADDITIONAL_INFO_FIELD_NUMBER = 7;
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final MessagingStruct$PurchaseMessage DEFAULT_INSTANCE;
    public static final int MSG_FIELD_NUMBER = 1;
    public static final int MULTIPLEXING_DATA_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int REGEX_AMOUNT_FIELD_NUMBER = 4;
    public static final int REQUEST_TYPE_FIELD_NUMBER = 5;
    public static final int TARGET_WALLET_ID_FIELD_NUMBER = 8;
    private String accountNumber_ = "";
    private CollectionsStruct$MapValue additionalInfo_;
    private long amount_;
    private int bitField0_;
    private MessagingStruct$Message msg_;
    private MessagingStruct$MultiplexingData multiplexingData_;
    private StringValue regexAmount_;
    private int requestType_;
    private StringValue targetWalletId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$PurchaseMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$PurchaseMessage messagingStruct$PurchaseMessage = new MessagingStruct$PurchaseMessage();
        DEFAULT_INSTANCE = messagingStruct$PurchaseMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$PurchaseMessage.class, messagingStruct$PurchaseMessage);
    }

    private MessagingStruct$PurchaseMessage() {
    }

    private void clearAccountNumber() {
        this.accountNumber_ = getDefaultInstance().getAccountNumber();
    }

    private void clearAdditionalInfo() {
        this.additionalInfo_ = null;
        this.bitField0_ &= -9;
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearMsg() {
        this.msg_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMultiplexingData() {
        this.multiplexingData_ = null;
        this.bitField0_ &= -5;
    }

    private void clearRegexAmount() {
        this.regexAmount_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRequestType() {
        this.requestType_ = 0;
    }

    private void clearTargetWalletId() {
        this.targetWalletId_ = null;
        this.bitField0_ &= -17;
    }

    public static MessagingStruct$PurchaseMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAdditionalInfo(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.additionalInfo_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.additionalInfo_ = collectionsStruct$MapValue;
        } else {
            this.additionalInfo_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.additionalInfo_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeMsg(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.msg_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.msg_ = messagingStruct$Message;
        } else {
            this.msg_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.msg_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMultiplexingData(MessagingStruct$MultiplexingData messagingStruct$MultiplexingData) {
        messagingStruct$MultiplexingData.getClass();
        MessagingStruct$MultiplexingData messagingStruct$MultiplexingData2 = this.multiplexingData_;
        if (messagingStruct$MultiplexingData2 == null || messagingStruct$MultiplexingData2 == MessagingStruct$MultiplexingData.getDefaultInstance()) {
            this.multiplexingData_ = messagingStruct$MultiplexingData;
        } else {
            this.multiplexingData_ = (MessagingStruct$MultiplexingData) ((MessagingStruct$MultiplexingData.a) MessagingStruct$MultiplexingData.newBuilder(this.multiplexingData_).v(messagingStruct$MultiplexingData)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeRegexAmount(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.regexAmount_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.regexAmount_ = stringValue;
        } else {
            this.regexAmount_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.regexAmount_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeTargetWalletId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.targetWalletId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.targetWalletId_ = stringValue;
        } else {
            this.targetWalletId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.targetWalletId_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$PurchaseMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountNumber(String str) {
        str.getClass();
        this.accountNumber_ = str;
    }

    private void setAccountNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accountNumber_ = abstractC2383g.f0();
    }

    private void setAdditionalInfo(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.additionalInfo_ = collectionsStruct$MapValue;
        this.bitField0_ |= 8;
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setMsg(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.msg_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    private void setMultiplexingData(MessagingStruct$MultiplexingData messagingStruct$MultiplexingData) {
        messagingStruct$MultiplexingData.getClass();
        this.multiplexingData_ = messagingStruct$MultiplexingData;
        this.bitField0_ |= 4;
    }

    private void setRegexAmount(StringValue stringValue) {
        stringValue.getClass();
        this.regexAmount_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setRequestType(EnumC18998pc4 enumC18998pc4) {
        this.requestType_ = enumC18998pc4.getNumber();
    }

    private void setRequestTypeValue(int i) {
        this.requestType_ = i;
    }

    private void setTargetWalletId(StringValue stringValue) {
        stringValue.getClass();
        this.targetWalletId_ = stringValue;
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$PurchaseMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u0002\u0004ဉ\u0001\u0005\f\u0006ဉ\u0002\u0007ဉ\u0003\bဉ\u0004", new Object[]{"bitField0_", "msg_", "accountNumber_", "amount_", "regexAmount_", "requestType_", "multiplexingData_", "additionalInfo_", "targetWalletId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$PurchaseMessage.class) {
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

    public String getAccountNumber() {
        return this.accountNumber_;
    }

    public AbstractC2383g getAccountNumberBytes() {
        return AbstractC2383g.N(this.accountNumber_);
    }

    public CollectionsStruct$MapValue getAdditionalInfo() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.additionalInfo_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public long getAmount() {
        return this.amount_;
    }

    public MessagingStruct$Message getMsg() {
        MessagingStruct$Message messagingStruct$Message = this.msg_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public MessagingStruct$MultiplexingData getMultiplexingData() {
        MessagingStruct$MultiplexingData messagingStruct$MultiplexingData = this.multiplexingData_;
        return messagingStruct$MultiplexingData == null ? MessagingStruct$MultiplexingData.getDefaultInstance() : messagingStruct$MultiplexingData;
    }

    public StringValue getRegexAmount() {
        StringValue stringValue = this.regexAmount_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC18998pc4 getRequestType() {
        EnumC18998pc4 enumC18998pc4J = EnumC18998pc4.j(this.requestType_);
        return enumC18998pc4J == null ? EnumC18998pc4.UNRECOGNIZED : enumC18998pc4J;
    }

    public int getRequestTypeValue() {
        return this.requestType_;
    }

    public StringValue getTargetWalletId() {
        StringValue stringValue = this.targetWalletId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAdditionalInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMsg() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMultiplexingData() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasRegexAmount() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTargetWalletId() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(MessagingStruct$PurchaseMessage messagingStruct$PurchaseMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$PurchaseMessage);
    }

    public static MessagingStruct$PurchaseMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$PurchaseMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$PurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
