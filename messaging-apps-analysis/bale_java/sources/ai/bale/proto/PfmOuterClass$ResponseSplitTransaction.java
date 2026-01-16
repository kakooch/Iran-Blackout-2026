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
public final class PfmOuterClass$ResponseSplitTransaction extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$ResponseSplitTransaction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SPLIT_TRANSACTION_IDS_FIELD_NUMBER = 1;
    private B.j splitTransactionIds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$ResponseSplitTransaction.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$ResponseSplitTransaction pfmOuterClass$ResponseSplitTransaction = new PfmOuterClass$ResponseSplitTransaction();
        DEFAULT_INSTANCE = pfmOuterClass$ResponseSplitTransaction;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$ResponseSplitTransaction.class, pfmOuterClass$ResponseSplitTransaction);
    }

    private PfmOuterClass$ResponseSplitTransaction() {
    }

    private void addAllSplitTransactionIds(Iterable<? extends PfmStruct$PfmTransactionId> iterable) {
        ensureSplitTransactionIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.splitTransactionIds_);
    }

    private void addSplitTransactionIds(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureSplitTransactionIdsIsMutable();
        this.splitTransactionIds_.add(pfmStruct$PfmTransactionId);
    }

    private void clearSplitTransactionIds() {
        this.splitTransactionIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSplitTransactionIdsIsMutable() {
        B.j jVar = this.splitTransactionIds_;
        if (jVar.u()) {
            return;
        }
        this.splitTransactionIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$ResponseSplitTransaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$ResponseSplitTransaction parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSplitTransactionIds(int i) {
        ensureSplitTransactionIdsIsMutable();
        this.splitTransactionIds_.remove(i);
    }

    private void setSplitTransactionIds(int i, PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureSplitTransactionIdsIsMutable();
        this.splitTransactionIds_.set(i, pfmStruct$PfmTransactionId);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$ResponseSplitTransaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"splitTransactionIds_", PfmStruct$PfmTransactionId.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$ResponseSplitTransaction.class) {
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

    public PfmStruct$PfmTransactionId getSplitTransactionIds(int i) {
        return (PfmStruct$PfmTransactionId) this.splitTransactionIds_.get(i);
    }

    public int getSplitTransactionIdsCount() {
        return this.splitTransactionIds_.size();
    }

    public List<PfmStruct$PfmTransactionId> getSplitTransactionIdsList() {
        return this.splitTransactionIds_;
    }

    public InterfaceC23559x75 getSplitTransactionIdsOrBuilder(int i) {
        return (InterfaceC23559x75) this.splitTransactionIds_.get(i);
    }

    public List<? extends InterfaceC23559x75> getSplitTransactionIdsOrBuilderList() {
        return this.splitTransactionIds_;
    }

    public static a newBuilder(PfmOuterClass$ResponseSplitTransaction pfmOuterClass$ResponseSplitTransaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$ResponseSplitTransaction);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSplitTransactionIds(int i, PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureSplitTransactionIdsIsMutable();
        this.splitTransactionIds_.add(i, pfmStruct$PfmTransactionId);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(byte[] bArr) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$ResponseSplitTransaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$ResponseSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
