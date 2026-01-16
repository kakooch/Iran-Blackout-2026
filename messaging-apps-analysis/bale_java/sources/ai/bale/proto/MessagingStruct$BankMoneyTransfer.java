package ai.bale.proto;

import ai.bale.proto.MessagingStruct$BankAccount;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$BankMoneyTransfer extends GeneratedMessageLite implements U64 {
    public static final int BRANCH_FIELD_NUMBER = 8;
    private static final MessagingStruct$BankMoneyTransfer DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DEST_ACCOUNT_FIELD_NUMBER = 2;
    public static final int MONEY_TRANSFER_DATE_FIELD_NUMBER = 7;
    public static final int MONEY_TRANSFER_VAL_FIELD_NUMBER = 3;
    public static final int ORIGIN_ACCOUNT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_CODE_FIELD_NUMBER = 5;
    public static final int REFERENCE_NUMBER_FIELD_NUMBER = 4;
    private int bitField0_;
    private Int32Value branch_;
    private StringValue description_;
    private MessagingStruct$BankAccount destAccount_;
    private long moneyTransferDate_;
    private long moneyTransferVal_;
    private MessagingStruct$BankAccount originAccount_;
    private long paymentCode_;
    private long referenceNumber_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BankMoneyTransfer.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BankMoneyTransfer messagingStruct$BankMoneyTransfer = new MessagingStruct$BankMoneyTransfer();
        DEFAULT_INSTANCE = messagingStruct$BankMoneyTransfer;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BankMoneyTransfer.class, messagingStruct$BankMoneyTransfer);
    }

    private MessagingStruct$BankMoneyTransfer() {
    }

    private void clearBranch() {
        this.branch_ = null;
        this.bitField0_ &= -9;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -5;
    }

    private void clearDestAccount() {
        this.destAccount_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMoneyTransferDate() {
        this.moneyTransferDate_ = 0L;
    }

    private void clearMoneyTransferVal() {
        this.moneyTransferVal_ = 0L;
    }

    private void clearOriginAccount() {
        this.originAccount_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPaymentCode() {
        this.paymentCode_ = 0L;
    }

    private void clearReferenceNumber() {
        this.referenceNumber_ = 0L;
    }

    public static MessagingStruct$BankMoneyTransfer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBranch(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.branch_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.branch_ = int32Value;
        } else {
            this.branch_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.branch_).v(int32Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeDestAccount(MessagingStruct$BankAccount messagingStruct$BankAccount) {
        messagingStruct$BankAccount.getClass();
        MessagingStruct$BankAccount messagingStruct$BankAccount2 = this.destAccount_;
        if (messagingStruct$BankAccount2 == null || messagingStruct$BankAccount2 == MessagingStruct$BankAccount.getDefaultInstance()) {
            this.destAccount_ = messagingStruct$BankAccount;
        } else {
            this.destAccount_ = (MessagingStruct$BankAccount) ((MessagingStruct$BankAccount.a) MessagingStruct$BankAccount.newBuilder(this.destAccount_).v(messagingStruct$BankAccount)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeOriginAccount(MessagingStruct$BankAccount messagingStruct$BankAccount) {
        messagingStruct$BankAccount.getClass();
        MessagingStruct$BankAccount messagingStruct$BankAccount2 = this.originAccount_;
        if (messagingStruct$BankAccount2 == null || messagingStruct$BankAccount2 == MessagingStruct$BankAccount.getDefaultInstance()) {
            this.originAccount_ = messagingStruct$BankAccount;
        } else {
            this.originAccount_ = (MessagingStruct$BankAccount) ((MessagingStruct$BankAccount.a) MessagingStruct$BankAccount.newBuilder(this.originAccount_).v(messagingStruct$BankAccount)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BankMoneyTransfer parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBranch(Int32Value int32Value) {
        int32Value.getClass();
        this.branch_ = int32Value;
        this.bitField0_ |= 8;
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setDestAccount(MessagingStruct$BankAccount messagingStruct$BankAccount) {
        messagingStruct$BankAccount.getClass();
        this.destAccount_ = messagingStruct$BankAccount;
        this.bitField0_ |= 2;
    }

    private void setMoneyTransferDate(long j) {
        this.moneyTransferDate_ = j;
    }

    private void setMoneyTransferVal(long j) {
        this.moneyTransferVal_ = j;
    }

    private void setOriginAccount(MessagingStruct$BankAccount messagingStruct$BankAccount) {
        messagingStruct$BankAccount.getClass();
        this.originAccount_ = messagingStruct$BankAccount;
        this.bitField0_ |= 1;
    }

    private void setPaymentCode(long j) {
        this.paymentCode_ = j;
    }

    private void setReferenceNumber(long j) {
        this.referenceNumber_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BankMoneyTransfer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0002\u0004\u0002\u0005\u0002\u0006ဉ\u0002\u0007\u0002\bဉ\u0003", new Object[]{"bitField0_", "originAccount_", "destAccount_", "moneyTransferVal_", "referenceNumber_", "paymentCode_", "description_", "moneyTransferDate_", "branch_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BankMoneyTransfer.class) {
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

    public Int32Value getBranch() {
        Int32Value int32Value = this.branch_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$BankAccount getDestAccount() {
        MessagingStruct$BankAccount messagingStruct$BankAccount = this.destAccount_;
        return messagingStruct$BankAccount == null ? MessagingStruct$BankAccount.getDefaultInstance() : messagingStruct$BankAccount;
    }

    public long getMoneyTransferDate() {
        return this.moneyTransferDate_;
    }

    public long getMoneyTransferVal() {
        return this.moneyTransferVal_;
    }

    public MessagingStruct$BankAccount getOriginAccount() {
        MessagingStruct$BankAccount messagingStruct$BankAccount = this.originAccount_;
        return messagingStruct$BankAccount == null ? MessagingStruct$BankAccount.getDefaultInstance() : messagingStruct$BankAccount;
    }

    public long getPaymentCode() {
        return this.paymentCode_;
    }

    public long getReferenceNumber() {
        return this.referenceNumber_;
    }

    public boolean hasBranch() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasDestAccount() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOriginAccount() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$BankMoneyTransfer messagingStruct$BankMoneyTransfer) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BankMoneyTransfer);
    }

    public static MessagingStruct$BankMoneyTransfer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(byte[] bArr) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(InputStream inputStream) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BankMoneyTransfer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BankMoneyTransfer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
