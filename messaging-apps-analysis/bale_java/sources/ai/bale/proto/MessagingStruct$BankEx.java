package ai.bale.proto;

import ai.bale.proto.MessagingStruct$BankMoneyTransfer;
import ai.bale.proto.MessagingStruct$BankRemain;
import ai.bale.proto.MessagingStruct$BankTransaction;
import ai.bale.proto.MessagingStruct$DeprecatedReceipt;
import ai.bale.proto.MessagingStruct$DeprecatedReceiptMessage;
import ai.bale.proto.MessagingStruct$ReceiptMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$BankEx extends GeneratedMessageLite implements U64 {
    public static final int BANK_MONEY_TRANSFER_FIELD_NUMBER = 1;
    public static final int BANK_REMAIN_FIELD_NUMBER = 2;
    public static final int BANK_TRANSACTION_FIELD_NUMBER = 3;
    private static final MessagingStruct$BankEx DEFAULT_INSTANCE;
    public static final int DEPRECATED_RECEIPT_FIELD_NUMBER = 5;
    public static final int DEPRECATED_RECEIPT_MESSAGE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int RECEIPT_MESSAGE_FIELD_NUMBER = 4;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BankEx.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        BANK_MONEY_TRANSFER(1),
        BANK_REMAIN(2),
        BANK_TRANSACTION(3),
        RECEIPT_MESSAGE(4),
        DEPRECATED_RECEIPT(5),
        DEPRECATED_RECEIPT_MESSAGE(6),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i2) {
            this.a = i2;
        }

        public static b j(int i2) {
            switch (i2) {
                case 0:
                    return TRAIT_NOT_SET;
                case 1:
                    return BANK_MONEY_TRANSFER;
                case 2:
                    return BANK_REMAIN;
                case 3:
                    return BANK_TRANSACTION;
                case 4:
                    return RECEIPT_MESSAGE;
                case 5:
                    return DEPRECATED_RECEIPT;
                case 6:
                    return DEPRECATED_RECEIPT_MESSAGE;
                default:
                    return null;
            }
        }
    }

    static {
        MessagingStruct$BankEx messagingStruct$BankEx = new MessagingStruct$BankEx();
        DEFAULT_INSTANCE = messagingStruct$BankEx;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BankEx.class, messagingStruct$BankEx);
    }

    private MessagingStruct$BankEx() {
    }

    private void clearBankMoneyTransfer() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBankRemain() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBankTransaction() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeprecatedReceipt() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeprecatedReceiptMessage() {
        if (this.traitCase_ == 6) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearReceiptMessage() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static MessagingStruct$BankEx getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBankMoneyTransfer(MessagingStruct$BankMoneyTransfer messagingStruct$BankMoneyTransfer) {
        messagingStruct$BankMoneyTransfer.getClass();
        if (this.traitCase_ != 1 || this.trait_ == MessagingStruct$BankMoneyTransfer.getDefaultInstance()) {
            this.trait_ = messagingStruct$BankMoneyTransfer;
        } else {
            this.trait_ = ((MessagingStruct$BankMoneyTransfer.a) MessagingStruct$BankMoneyTransfer.newBuilder((MessagingStruct$BankMoneyTransfer) this.trait_).v(messagingStruct$BankMoneyTransfer)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeBankRemain(MessagingStruct$BankRemain messagingStruct$BankRemain) {
        messagingStruct$BankRemain.getClass();
        if (this.traitCase_ != 2 || this.trait_ == MessagingStruct$BankRemain.getDefaultInstance()) {
            this.trait_ = messagingStruct$BankRemain;
        } else {
            this.trait_ = ((MessagingStruct$BankRemain.a) MessagingStruct$BankRemain.newBuilder((MessagingStruct$BankRemain) this.trait_).v(messagingStruct$BankRemain)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeBankTransaction(MessagingStruct$BankTransaction messagingStruct$BankTransaction) {
        messagingStruct$BankTransaction.getClass();
        if (this.traitCase_ != 3 || this.trait_ == MessagingStruct$BankTransaction.getDefaultInstance()) {
            this.trait_ = messagingStruct$BankTransaction;
        } else {
            this.trait_ = ((MessagingStruct$BankTransaction.a) MessagingStruct$BankTransaction.newBuilder((MessagingStruct$BankTransaction) this.trait_).v(messagingStruct$BankTransaction)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeDeprecatedReceipt(MessagingStruct$DeprecatedReceipt messagingStruct$DeprecatedReceipt) {
        messagingStruct$DeprecatedReceipt.getClass();
        if (this.traitCase_ != 5 || this.trait_ == MessagingStruct$DeprecatedReceipt.getDefaultInstance()) {
            this.trait_ = messagingStruct$DeprecatedReceipt;
        } else {
            this.trait_ = ((MessagingStruct$DeprecatedReceipt.a) MessagingStruct$DeprecatedReceipt.newBuilder((MessagingStruct$DeprecatedReceipt) this.trait_).v(messagingStruct$DeprecatedReceipt)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeDeprecatedReceiptMessage(MessagingStruct$DeprecatedReceiptMessage messagingStruct$DeprecatedReceiptMessage) {
        messagingStruct$DeprecatedReceiptMessage.getClass();
        if (this.traitCase_ != 6 || this.trait_ == MessagingStruct$DeprecatedReceiptMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$DeprecatedReceiptMessage;
        } else {
            this.trait_ = ((MessagingStruct$DeprecatedReceiptMessage.a) MessagingStruct$DeprecatedReceiptMessage.newBuilder((MessagingStruct$DeprecatedReceiptMessage) this.trait_).v(messagingStruct$DeprecatedReceiptMessage)).j();
        }
        this.traitCase_ = 6;
    }

    private void mergeReceiptMessage(MessagingStruct$ReceiptMessage messagingStruct$ReceiptMessage) {
        messagingStruct$ReceiptMessage.getClass();
        if (this.traitCase_ != 4 || this.trait_ == MessagingStruct$ReceiptMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$ReceiptMessage;
        } else {
            this.trait_ = ((MessagingStruct$ReceiptMessage.a) MessagingStruct$ReceiptMessage.newBuilder((MessagingStruct$ReceiptMessage) this.trait_).v(messagingStruct$ReceiptMessage)).j();
        }
        this.traitCase_ = 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BankEx parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankEx parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankMoneyTransfer(MessagingStruct$BankMoneyTransfer messagingStruct$BankMoneyTransfer) {
        messagingStruct$BankMoneyTransfer.getClass();
        this.trait_ = messagingStruct$BankMoneyTransfer;
        this.traitCase_ = 1;
    }

    private void setBankRemain(MessagingStruct$BankRemain messagingStruct$BankRemain) {
        messagingStruct$BankRemain.getClass();
        this.trait_ = messagingStruct$BankRemain;
        this.traitCase_ = 2;
    }

    private void setBankTransaction(MessagingStruct$BankTransaction messagingStruct$BankTransaction) {
        messagingStruct$BankTransaction.getClass();
        this.trait_ = messagingStruct$BankTransaction;
        this.traitCase_ = 3;
    }

    private void setDeprecatedReceipt(MessagingStruct$DeprecatedReceipt messagingStruct$DeprecatedReceipt) {
        messagingStruct$DeprecatedReceipt.getClass();
        this.trait_ = messagingStruct$DeprecatedReceipt;
        this.traitCase_ = 5;
    }

    private void setDeprecatedReceiptMessage(MessagingStruct$DeprecatedReceiptMessage messagingStruct$DeprecatedReceiptMessage) {
        messagingStruct$DeprecatedReceiptMessage.getClass();
        this.trait_ = messagingStruct$DeprecatedReceiptMessage;
        this.traitCase_ = 6;
    }

    private void setReceiptMessage(MessagingStruct$ReceiptMessage messagingStruct$ReceiptMessage) {
        messagingStruct$ReceiptMessage.getClass();
        this.trait_ = messagingStruct$ReceiptMessage;
        this.traitCase_ = 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BankEx();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"trait_", "traitCase_", MessagingStruct$BankMoneyTransfer.class, MessagingStruct$BankRemain.class, MessagingStruct$BankTransaction.class, MessagingStruct$ReceiptMessage.class, MessagingStruct$DeprecatedReceipt.class, MessagingStruct$DeprecatedReceiptMessage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BankEx.class) {
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

    public MessagingStruct$BankMoneyTransfer getBankMoneyTransfer() {
        return this.traitCase_ == 1 ? (MessagingStruct$BankMoneyTransfer) this.trait_ : MessagingStruct$BankMoneyTransfer.getDefaultInstance();
    }

    public MessagingStruct$BankRemain getBankRemain() {
        return this.traitCase_ == 2 ? (MessagingStruct$BankRemain) this.trait_ : MessagingStruct$BankRemain.getDefaultInstance();
    }

    public MessagingStruct$BankTransaction getBankTransaction() {
        return this.traitCase_ == 3 ? (MessagingStruct$BankTransaction) this.trait_ : MessagingStruct$BankTransaction.getDefaultInstance();
    }

    public MessagingStruct$DeprecatedReceipt getDeprecatedReceipt() {
        return this.traitCase_ == 5 ? (MessagingStruct$DeprecatedReceipt) this.trait_ : MessagingStruct$DeprecatedReceipt.getDefaultInstance();
    }

    public MessagingStruct$DeprecatedReceiptMessage getDeprecatedReceiptMessage() {
        return this.traitCase_ == 6 ? (MessagingStruct$DeprecatedReceiptMessage) this.trait_ : MessagingStruct$DeprecatedReceiptMessage.getDefaultInstance();
    }

    public MessagingStruct$ReceiptMessage getReceiptMessage() {
        return this.traitCase_ == 4 ? (MessagingStruct$ReceiptMessage) this.trait_ : MessagingStruct$ReceiptMessage.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasBankMoneyTransfer() {
        return this.traitCase_ == 1;
    }

    public boolean hasBankRemain() {
        return this.traitCase_ == 2;
    }

    public boolean hasBankTransaction() {
        return this.traitCase_ == 3;
    }

    public boolean hasDeprecatedReceipt() {
        return this.traitCase_ == 5;
    }

    public boolean hasDeprecatedReceiptMessage() {
        return this.traitCase_ == 6;
    }

    public boolean hasReceiptMessage() {
        return this.traitCase_ == 4;
    }

    public static a newBuilder(MessagingStruct$BankEx messagingStruct$BankEx) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BankEx);
    }

    public static MessagingStruct$BankEx parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankEx parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BankEx parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BankEx parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BankEx parseFrom(byte[] bArr) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BankEx parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BankEx parseFrom(InputStream inputStream) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankEx parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankEx parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BankEx parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BankEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
