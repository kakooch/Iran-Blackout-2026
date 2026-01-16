package ai.bale.proto;

import ai.bale.proto.MessagingStruct$BankAccount;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$BankRemain extends GeneratedMessageLite implements U64 {
    public static final int BANK_ACCOUNT_FIELD_NUMBER = 1;
    private static final MessagingStruct$BankRemain DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REMAIN_DATE_FIELD_NUMBER = 2;
    private MessagingStruct$BankAccount bankAccount_;
    private int bitField0_;
    private long remainDate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BankRemain.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BankRemain messagingStruct$BankRemain = new MessagingStruct$BankRemain();
        DEFAULT_INSTANCE = messagingStruct$BankRemain;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BankRemain.class, messagingStruct$BankRemain);
    }

    private MessagingStruct$BankRemain() {
    }

    private void clearBankAccount() {
        this.bankAccount_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRemainDate() {
        this.remainDate_ = 0L;
    }

    public static MessagingStruct$BankRemain getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBankAccount(MessagingStruct$BankAccount messagingStruct$BankAccount) {
        messagingStruct$BankAccount.getClass();
        MessagingStruct$BankAccount messagingStruct$BankAccount2 = this.bankAccount_;
        if (messagingStruct$BankAccount2 == null || messagingStruct$BankAccount2 == MessagingStruct$BankAccount.getDefaultInstance()) {
            this.bankAccount_ = messagingStruct$BankAccount;
        } else {
            this.bankAccount_ = (MessagingStruct$BankAccount) ((MessagingStruct$BankAccount.a) MessagingStruct$BankAccount.newBuilder(this.bankAccount_).v(messagingStruct$BankAccount)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BankRemain parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankRemain parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankAccount(MessagingStruct$BankAccount messagingStruct$BankAccount) {
        messagingStruct$BankAccount.getClass();
        this.bankAccount_ = messagingStruct$BankAccount;
        this.bitField0_ |= 1;
    }

    private void setRemainDate(long j) {
        this.remainDate_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BankRemain();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002", new Object[]{"bitField0_", "bankAccount_", "remainDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BankRemain.class) {
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

    public MessagingStruct$BankAccount getBankAccount() {
        MessagingStruct$BankAccount messagingStruct$BankAccount = this.bankAccount_;
        return messagingStruct$BankAccount == null ? MessagingStruct$BankAccount.getDefaultInstance() : messagingStruct$BankAccount;
    }

    public long getRemainDate() {
        return this.remainDate_;
    }

    public boolean hasBankAccount() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$BankRemain messagingStruct$BankRemain) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BankRemain);
    }

    public static MessagingStruct$BankRemain parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankRemain parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BankRemain parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BankRemain parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BankRemain parseFrom(byte[] bArr) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BankRemain parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BankRemain parseFrom(InputStream inputStream) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankRemain parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankRemain parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BankRemain parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BankRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
