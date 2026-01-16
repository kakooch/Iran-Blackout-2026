package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23559x75;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PfmOuterClass$ResponseGetSubTransactions extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$ResponseGetSubTransactions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_IDS_FIELD_NUMBER = 1;
    private B.j transactionIds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$ResponseGetSubTransactions.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$ResponseGetSubTransactions pfmOuterClass$ResponseGetSubTransactions = new PfmOuterClass$ResponseGetSubTransactions();
        DEFAULT_INSTANCE = pfmOuterClass$ResponseGetSubTransactions;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$ResponseGetSubTransactions.class, pfmOuterClass$ResponseGetSubTransactions);
    }

    private PfmOuterClass$ResponseGetSubTransactions() {
    }

    private void addAllTransactionIds(Iterable<? extends PfmStruct$PfmTransactionId> iterable) {
        ensureTransactionIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.transactionIds_);
    }

    private void addTransactionIds(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureTransactionIdsIsMutable();
        this.transactionIds_.add(pfmStruct$PfmTransactionId);
    }

    private void clearTransactionIds() {
        this.transactionIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTransactionIdsIsMutable() {
        B.j jVar = this.transactionIds_;
        if (jVar.u()) {
            return;
        }
        this.transactionIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$ResponseGetSubTransactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTransactionIds(int i) {
        ensureTransactionIdsIsMutable();
        this.transactionIds_.remove(i);
    }

    private void setTransactionIds(int i, PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureTransactionIdsIsMutable();
        this.transactionIds_.set(i, pfmStruct$PfmTransactionId);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$ResponseGetSubTransactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"transactionIds_", PfmStruct$PfmTransactionId.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$ResponseGetSubTransactions.class) {
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

    public PfmStruct$PfmTransactionId getTransactionIds(int i) {
        return (PfmStruct$PfmTransactionId) this.transactionIds_.get(i);
    }

    public int getTransactionIdsCount() {
        return this.transactionIds_.size();
    }

    public List<PfmStruct$PfmTransactionId> getTransactionIdsList() {
        return this.transactionIds_;
    }

    public InterfaceC23559x75 getTransactionIdsOrBuilder(int i) {
        return (InterfaceC23559x75) this.transactionIds_.get(i);
    }

    public List<? extends InterfaceC23559x75> getTransactionIdsOrBuilderList() {
        return this.transactionIds_;
    }

    public static a newBuilder(PfmOuterClass$ResponseGetSubTransactions pfmOuterClass$ResponseGetSubTransactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$ResponseGetSubTransactions);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTransactionIds(int i, PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureTransactionIdsIsMutable();
        this.transactionIds_.add(i, pfmStruct$PfmTransactionId);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(byte[] bArr) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$ResponseGetSubTransactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetSubTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
