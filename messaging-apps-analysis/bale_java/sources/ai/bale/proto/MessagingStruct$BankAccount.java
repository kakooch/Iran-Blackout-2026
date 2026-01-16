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
public final class MessagingStruct$BankAccount extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 1;
    public static final int AVAILABLE_BALANCE_FIELD_NUMBER = 5;
    public static final int BRANCH_CODE_FIELD_NUMBER = 2;
    private static final MessagingStruct$BankAccount DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 7;
    public static final int LAST_MONEY_TRANSFER_DATE_FIELD_NUMBER = 6;
    public static final int LAST_NAME_FIELD_NUMBER = 8;
    public static final int OPEN_DATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RATE_FIELD_NUMBER = 4;
    private long availableBalance_;
    private int branchCode_;
    private long lastMoneyTransferDate_;
    private long openDate_;
    private int rate_;
    private String accountNumber_ = "";
    private String firstName_ = "";
    private String lastName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BankAccount.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BankAccount messagingStruct$BankAccount = new MessagingStruct$BankAccount();
        DEFAULT_INSTANCE = messagingStruct$BankAccount;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BankAccount.class, messagingStruct$BankAccount);
    }

    private MessagingStruct$BankAccount() {
    }

    private void clearAccountNumber() {
        this.accountNumber_ = getDefaultInstance().getAccountNumber();
    }

    private void clearAvailableBalance() {
        this.availableBalance_ = 0L;
    }

    private void clearBranchCode() {
        this.branchCode_ = 0;
    }

    private void clearFirstName() {
        this.firstName_ = getDefaultInstance().getFirstName();
    }

    private void clearLastMoneyTransferDate() {
        this.lastMoneyTransferDate_ = 0L;
    }

    private void clearLastName() {
        this.lastName_ = getDefaultInstance().getLastName();
    }

    private void clearOpenDate() {
        this.openDate_ = 0L;
    }

    private void clearRate() {
        this.rate_ = 0;
    }

    public static MessagingStruct$BankAccount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BankAccount parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankAccount parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setAvailableBalance(long j) {
        this.availableBalance_ = j;
    }

    private void setBranchCode(int i) {
        this.branchCode_ = i;
    }

    private void setFirstName(String str) {
        str.getClass();
        this.firstName_ = str;
    }

    private void setFirstNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.firstName_ = abstractC2383g.f0();
    }

    private void setLastMoneyTransferDate(long j) {
        this.lastMoneyTransferDate_ = j;
    }

    private void setLastName(String str) {
        str.getClass();
        this.lastName_ = str;
    }

    private void setLastNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.lastName_ = abstractC2383g.f0();
    }

    private void setOpenDate(long j) {
        this.openDate_ = j;
    }

    private void setRate(int i) {
        this.rate_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BankAccount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0002\u0004\u0004\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ", new Object[]{"accountNumber_", "branchCode_", "openDate_", "rate_", "availableBalance_", "lastMoneyTransferDate_", "firstName_", "lastName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BankAccount.class) {
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

    public long getAvailableBalance() {
        return this.availableBalance_;
    }

    public int getBranchCode() {
        return this.branchCode_;
    }

    public String getFirstName() {
        return this.firstName_;
    }

    public AbstractC2383g getFirstNameBytes() {
        return AbstractC2383g.N(this.firstName_);
    }

    public long getLastMoneyTransferDate() {
        return this.lastMoneyTransferDate_;
    }

    public String getLastName() {
        return this.lastName_;
    }

    public AbstractC2383g getLastNameBytes() {
        return AbstractC2383g.N(this.lastName_);
    }

    public long getOpenDate() {
        return this.openDate_;
    }

    public int getRate() {
        return this.rate_;
    }

    public static a newBuilder(MessagingStruct$BankAccount messagingStruct$BankAccount) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BankAccount);
    }

    public static MessagingStruct$BankAccount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankAccount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BankAccount parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BankAccount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BankAccount parseFrom(byte[] bArr) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BankAccount parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BankAccount parseFrom(InputStream inputStream) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankAccount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankAccount parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BankAccount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BankAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
