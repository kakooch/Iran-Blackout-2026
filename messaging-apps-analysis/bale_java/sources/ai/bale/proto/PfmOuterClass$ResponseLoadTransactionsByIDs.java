package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC24149y75;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PfmOuterClass$ResponseLoadTransactionsByIDs extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$ResponseLoadTransactionsByIDs DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTIONS_FIELD_NUMBER = 1;
    private B.j transactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$ResponseLoadTransactionsByIDs.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$ResponseLoadTransactionsByIDs pfmOuterClass$ResponseLoadTransactionsByIDs = new PfmOuterClass$ResponseLoadTransactionsByIDs();
        DEFAULT_INSTANCE = pfmOuterClass$ResponseLoadTransactionsByIDs;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$ResponseLoadTransactionsByIDs.class, pfmOuterClass$ResponseLoadTransactionsByIDs);
    }

    private PfmOuterClass$ResponseLoadTransactionsByIDs() {
    }

    private void addAllTransactions(Iterable<? extends PfmStruct$PfmTransaction> iterable) {
        ensureTransactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.transactions_);
    }

    private void addTransactions(PfmStruct$PfmTransaction pfmStruct$PfmTransaction) {
        pfmStruct$PfmTransaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.add(pfmStruct$PfmTransaction);
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

    public static PfmOuterClass$ResponseLoadTransactionsByIDs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTransactions(int i) {
        ensureTransactionsIsMutable();
        this.transactions_.remove(i);
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
                return new PfmOuterClass$ResponseLoadTransactionsByIDs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"transactions_", PfmStruct$PfmTransaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$ResponseLoadTransactionsByIDs.class) {
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

    public static a newBuilder(PfmOuterClass$ResponseLoadTransactionsByIDs pfmOuterClass$ResponseLoadTransactionsByIDs) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$ResponseLoadTransactionsByIDs);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTransactions(int i, PfmStruct$PfmTransaction pfmStruct$PfmTransaction) {
        pfmStruct$PfmTransaction.getClass();
        ensureTransactionsIsMutable();
        this.transactions_.add(i, pfmStruct$PfmTransaction);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(byte[] bArr) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$ResponseLoadTransactionsByIDs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$ResponseLoadTransactionsByIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
