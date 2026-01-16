package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20506s75;
import ir.nasim.InterfaceC21783u75;
import ir.nasim.InterfaceC24149y75;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PfmOuterClass$ResponseLoadTransactions extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$ResponseLoadTransactions DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TOTAL_AMOUNTS_FIELD_NUMBER = 2;
    public static final int TOTAL_AMOUNTS_PER_DAY_FIELD_NUMBER = 4;
    public static final int TRANSACTIONS_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$StringValue loadMoreState_;
    private B.j transactions_ = GeneratedMessageLite.emptyProtobufList();
    private B.j totalAmounts_ = GeneratedMessageLite.emptyProtobufList();
    private B.j totalAmountsPerDay_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$ResponseLoadTransactions.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions = new PfmOuterClass$ResponseLoadTransactions();
        DEFAULT_INSTANCE = pfmOuterClass$ResponseLoadTransactions;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$ResponseLoadTransactions.class, pfmOuterClass$ResponseLoadTransactions);
    }

    private PfmOuterClass$ResponseLoadTransactions() {
    }

    private void addAllTotalAmounts(Iterable<? extends PfmStruct$PfmTotalAmount> iterable) {
        ensureTotalAmountsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.totalAmounts_);
    }

    private void addAllTotalAmountsPerDay(Iterable<? extends PfmStruct$PfmTotalAmountsPerDay> iterable) {
        ensureTotalAmountsPerDayIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.totalAmountsPerDay_);
    }

    private void addAllTransactions(Iterable<? extends PfmStruct$PfmTransaction> iterable) {
        ensureTransactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.transactions_);
    }

    private void addTotalAmounts(PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount) {
        pfmStruct$PfmTotalAmount.getClass();
        ensureTotalAmountsIsMutable();
        this.totalAmounts_.add(pfmStruct$PfmTotalAmount);
    }

    private void addTotalAmountsPerDay(PfmStruct$PfmTotalAmountsPerDay pfmStruct$PfmTotalAmountsPerDay) {
        pfmStruct$PfmTotalAmountsPerDay.getClass();
        ensureTotalAmountsPerDayIsMutable();
        this.totalAmountsPerDay_.add(pfmStruct$PfmTotalAmountsPerDay);
    }

    private void addTransactions(PfmStruct$PfmTransaction pfmStruct$PfmTransaction) {
        pfmStruct$PfmTransaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.add(pfmStruct$PfmTransaction);
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTotalAmounts() {
        this.totalAmounts_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTotalAmountsPerDay() {
        this.totalAmountsPerDay_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTransactions() {
        this.transactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTotalAmountsIsMutable() {
        B.j jVar = this.totalAmounts_;
        if (jVar.u()) {
            return;
        }
        this.totalAmounts_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTotalAmountsPerDayIsMutable() {
        B.j jVar = this.totalAmountsPerDay_;
        if (jVar.u()) {
            return;
        }
        this.totalAmountsPerDay_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTransactionsIsMutable() {
        B.j jVar = this.transactions_;
        if (jVar.u()) {
            return;
        }
        this.transactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$ResponseLoadTransactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLoadMoreState(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.loadMoreState_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.loadMoreState_ = collectionsStruct$StringValue;
        } else {
            this.loadMoreState_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.loadMoreState_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$ResponseLoadTransactions parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTotalAmounts(int i) {
        ensureTotalAmountsIsMutable();
        this.totalAmounts_.remove(i);
    }

    private void removeTotalAmountsPerDay(int i) {
        ensureTotalAmountsPerDayIsMutable();
        this.totalAmountsPerDay_.remove(i);
    }

    private void removeTransactions(int i) {
        ensureTransactionsIsMutable();
        this.transactions_.remove(i);
    }

    private void setLoadMoreState(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.loadMoreState_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    private void setTotalAmounts(int i, PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount) {
        pfmStruct$PfmTotalAmount.getClass();
        ensureTotalAmountsIsMutable();
        this.totalAmounts_.set(i, pfmStruct$PfmTotalAmount);
    }

    private void setTotalAmountsPerDay(int i, PfmStruct$PfmTotalAmountsPerDay pfmStruct$PfmTotalAmountsPerDay) {
        pfmStruct$PfmTotalAmountsPerDay.getClass();
        ensureTotalAmountsPerDayIsMutable();
        this.totalAmountsPerDay_.set(i, pfmStruct$PfmTotalAmountsPerDay);
    }

    private void setTransactions(int i, PfmStruct$PfmTransaction pfmStruct$PfmTransaction) {
        pfmStruct$PfmTransaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.set(i, pfmStruct$PfmTransaction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$ResponseLoadTransactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000\u0004\u001b", new Object[]{"bitField0_", "transactions_", PfmStruct$PfmTransaction.class, "totalAmounts_", PfmStruct$PfmTotalAmount.class, "loadMoreState_", "totalAmountsPerDay_", PfmStruct$PfmTotalAmountsPerDay.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$ResponseLoadTransactions.class) {
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

    public CollectionsStruct$StringValue getLoadMoreState() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.loadMoreState_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public PfmStruct$PfmTotalAmount getTotalAmounts(int i) {
        return (PfmStruct$PfmTotalAmount) this.totalAmounts_.get(i);
    }

    public int getTotalAmountsCount() {
        return this.totalAmounts_.size();
    }

    public List<PfmStruct$PfmTotalAmount> getTotalAmountsList() {
        return this.totalAmounts_;
    }

    public InterfaceC20506s75 getTotalAmountsOrBuilder(int i) {
        return (InterfaceC20506s75) this.totalAmounts_.get(i);
    }

    public List<? extends InterfaceC20506s75> getTotalAmountsOrBuilderList() {
        return this.totalAmounts_;
    }

    public PfmStruct$PfmTotalAmountsPerDay getTotalAmountsPerDay(int i) {
        return (PfmStruct$PfmTotalAmountsPerDay) this.totalAmountsPerDay_.get(i);
    }

    public int getTotalAmountsPerDayCount() {
        return this.totalAmountsPerDay_.size();
    }

    public List<PfmStruct$PfmTotalAmountsPerDay> getTotalAmountsPerDayList() {
        return this.totalAmountsPerDay_;
    }

    public InterfaceC21783u75 getTotalAmountsPerDayOrBuilder(int i) {
        return (InterfaceC21783u75) this.totalAmountsPerDay_.get(i);
    }

    public List<? extends InterfaceC21783u75> getTotalAmountsPerDayOrBuilderList() {
        return this.totalAmountsPerDay_;
    }

    public PfmStruct$PfmTransaction getTransactions(int i) {
        return (PfmStruct$PfmTransaction) this.transactions_.get(i);
    }

    public int getTransactionsCount() {
        return this.transactions_.size();
    }

    public List<PfmStruct$PfmTransaction> getTransactionsList() {
        return this.transactions_;
    }

    public InterfaceC24149y75 getTransactionsOrBuilder(int i) {
        return (InterfaceC24149y75) this.transactions_.get(i);
    }

    public List<? extends InterfaceC24149y75> getTransactionsOrBuilderList() {
        return this.transactions_;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$ResponseLoadTransactions);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTotalAmounts(int i, PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount) {
        pfmStruct$PfmTotalAmount.getClass();
        ensureTotalAmountsIsMutable();
        this.totalAmounts_.add(i, pfmStruct$PfmTotalAmount);
    }

    private void addTotalAmountsPerDay(int i, PfmStruct$PfmTotalAmountsPerDay pfmStruct$PfmTotalAmountsPerDay) {
        pfmStruct$PfmTotalAmountsPerDay.getClass();
        ensureTotalAmountsPerDayIsMutable();
        this.totalAmountsPerDay_.add(i, pfmStruct$PfmTotalAmountsPerDay);
    }

    private void addTransactions(int i, PfmStruct$PfmTransaction pfmStruct$PfmTransaction) {
        pfmStruct$PfmTransaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.add(i, pfmStruct$PfmTransaction);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(byte[] bArr) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$ResponseLoadTransactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
