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
public final class PfmOuterClass$ResponseFilterTaggedTransactions extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$ResponseFilterTaggedTransactions DEFAULT_INSTANCE;
    public static final int IDS_WITH_TAG_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j idsWithTag_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$ResponseFilterTaggedTransactions.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$ResponseFilterTaggedTransactions pfmOuterClass$ResponseFilterTaggedTransactions = new PfmOuterClass$ResponseFilterTaggedTransactions();
        DEFAULT_INSTANCE = pfmOuterClass$ResponseFilterTaggedTransactions;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$ResponseFilterTaggedTransactions.class, pfmOuterClass$ResponseFilterTaggedTransactions);
    }

    private PfmOuterClass$ResponseFilterTaggedTransactions() {
    }

    private void addAllIdsWithTag(Iterable<? extends PfmStruct$PfmTransactionId> iterable) {
        ensureIdsWithTagIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.idsWithTag_);
    }

    private void addIdsWithTag(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureIdsWithTagIsMutable();
        this.idsWithTag_.add(pfmStruct$PfmTransactionId);
    }

    private void clearIdsWithTag() {
        this.idsWithTag_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureIdsWithTagIsMutable() {
        B.j jVar = this.idsWithTag_;
        if (jVar.u()) {
            return;
        }
        this.idsWithTag_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeIdsWithTag(int i) {
        ensureIdsWithTagIsMutable();
        this.idsWithTag_.remove(i);
    }

    private void setIdsWithTag(int i, PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureIdsWithTagIsMutable();
        this.idsWithTag_.set(i, pfmStruct$PfmTransactionId);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$ResponseFilterTaggedTransactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"idsWithTag_", PfmStruct$PfmTransactionId.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$ResponseFilterTaggedTransactions.class) {
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

    public PfmStruct$PfmTransactionId getIdsWithTag(int i) {
        return (PfmStruct$PfmTransactionId) this.idsWithTag_.get(i);
    }

    public int getIdsWithTagCount() {
        return this.idsWithTag_.size();
    }

    public List<PfmStruct$PfmTransactionId> getIdsWithTagList() {
        return this.idsWithTag_;
    }

    public InterfaceC23559x75 getIdsWithTagOrBuilder(int i) {
        return (InterfaceC23559x75) this.idsWithTag_.get(i);
    }

    public List<? extends InterfaceC23559x75> getIdsWithTagOrBuilderList() {
        return this.idsWithTag_;
    }

    public static a newBuilder(PfmOuterClass$ResponseFilterTaggedTransactions pfmOuterClass$ResponseFilterTaggedTransactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$ResponseFilterTaggedTransactions);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addIdsWithTag(int i, PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureIdsWithTagIsMutable();
        this.idsWithTag_.add(i, pfmStruct$PfmTransactionId);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(byte[] bArr) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$ResponseFilterTaggedTransactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$ResponseFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
