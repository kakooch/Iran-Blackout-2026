package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6588Od4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$BankTransaction extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$BankTransaction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTIONS_FIELD_NUMBER = 1;
    private B.j transactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BankTransaction.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BankTransaction messagingStruct$BankTransaction = new MessagingStruct$BankTransaction();
        DEFAULT_INSTANCE = messagingStruct$BankTransaction;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BankTransaction.class, messagingStruct$BankTransaction);
    }

    private MessagingStruct$BankTransaction() {
    }

    private void addAllTransactions(Iterable<? extends MessagingStruct$Transaction> iterable) {
        ensureTransactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.transactions_);
    }

    private void addTransactions(MessagingStruct$Transaction messagingStruct$Transaction) {
        messagingStruct$Transaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.add(messagingStruct$Transaction);
    }

    private void clearTransactions() {
        this.transactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTransactionsIsMutable() {
        B.j jVar = this.transactions_;
        if (jVar.u()) {
            return;
        }
        this.transactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$BankTransaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BankTransaction parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankTransaction parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTransactions(int i) {
        ensureTransactionsIsMutable();
        this.transactions_.remove(i);
    }

    private void setTransactions(int i, MessagingStruct$Transaction messagingStruct$Transaction) {
        messagingStruct$Transaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.set(i, messagingStruct$Transaction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BankTransaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"transactions_", MessagingStruct$Transaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BankTransaction.class) {
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

    public MessagingStruct$Transaction getTransactions(int i) {
        return (MessagingStruct$Transaction) this.transactions_.get(i);
    }

    public int getTransactionsCount() {
        return this.transactions_.size();
    }

    public List<MessagingStruct$Transaction> getTransactionsList() {
        return this.transactions_;
    }

    public InterfaceC6588Od4 getTransactionsOrBuilder(int i) {
        return (InterfaceC6588Od4) this.transactions_.get(i);
    }

    public List<? extends InterfaceC6588Od4> getTransactionsOrBuilderList() {
        return this.transactions_;
    }

    public static a newBuilder(MessagingStruct$BankTransaction messagingStruct$BankTransaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BankTransaction);
    }

    public static MessagingStruct$BankTransaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankTransaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BankTransaction parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTransactions(int i, MessagingStruct$Transaction messagingStruct$Transaction) {
        messagingStruct$Transaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.add(i, messagingStruct$Transaction);
    }

    public static MessagingStruct$BankTransaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BankTransaction parseFrom(byte[] bArr) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BankTransaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BankTransaction parseFrom(InputStream inputStream) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankTransaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankTransaction parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BankTransaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BankTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
