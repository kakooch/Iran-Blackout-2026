package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20304rn0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$ResponseGetBusinessTransactions extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final BusinessOuterClass$ResponseGetBusinessTransactions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTIONS_FIELD_NUMBER = 1;
    private long count_;
    private B.j transactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$ResponseGetBusinessTransactions.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$ResponseGetBusinessTransactions businessOuterClass$ResponseGetBusinessTransactions = new BusinessOuterClass$ResponseGetBusinessTransactions();
        DEFAULT_INSTANCE = businessOuterClass$ResponseGetBusinessTransactions;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$ResponseGetBusinessTransactions.class, businessOuterClass$ResponseGetBusinessTransactions);
    }

    private BusinessOuterClass$ResponseGetBusinessTransactions() {
    }

    private void addAllTransactions(Iterable<? extends BusinessStruct$BusinessTransaction> iterable) {
        ensureTransactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.transactions_);
    }

    private void addTransactions(BusinessStruct$BusinessTransaction businessStruct$BusinessTransaction) {
        businessStruct$BusinessTransaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.add(businessStruct$BusinessTransaction);
    }

    private void clearCount() {
        this.count_ = 0L;
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

    public static BusinessOuterClass$ResponseGetBusinessTransactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTransactions(int i) {
        ensureTransactionsIsMutable();
        this.transactions_.remove(i);
    }

    private void setCount(long j) {
        this.count_ = j;
    }

    private void setTransactions(int i, BusinessStruct$BusinessTransaction businessStruct$BusinessTransaction) {
        businessStruct$BusinessTransaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.set(i, businessStruct$BusinessTransaction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$ResponseGetBusinessTransactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", new Object[]{"transactions_", BusinessStruct$BusinessTransaction.class, "count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$ResponseGetBusinessTransactions.class) {
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

    public long getCount() {
        return this.count_;
    }

    public BusinessStruct$BusinessTransaction getTransactions(int i) {
        return (BusinessStruct$BusinessTransaction) this.transactions_.get(i);
    }

    public int getTransactionsCount() {
        return this.transactions_.size();
    }

    public List<BusinessStruct$BusinessTransaction> getTransactionsList() {
        return this.transactions_;
    }

    public InterfaceC20304rn0 getTransactionsOrBuilder(int i) {
        return (InterfaceC20304rn0) this.transactions_.get(i);
    }

    public List<? extends InterfaceC20304rn0> getTransactionsOrBuilderList() {
        return this.transactions_;
    }

    public static a newBuilder(BusinessOuterClass$ResponseGetBusinessTransactions businessOuterClass$ResponseGetBusinessTransactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$ResponseGetBusinessTransactions);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTransactions(int i, BusinessStruct$BusinessTransaction businessStruct$BusinessTransaction) {
        businessStruct$BusinessTransaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.add(i, businessStruct$BusinessTransaction);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(byte[] bArr) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$ResponseGetBusinessTransactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
