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
public final class PfmOuterClass$RequestFilterTaggedTransactions extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$RequestFilterTaggedTransactions DEFAULT_INSTANCE;
    public static final int IDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j ids_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PfmOuterClass$RequestFilterTaggedTransactions) this.b).addAllIds(iterable);
            return this;
        }

        private a() {
            super(PfmOuterClass$RequestFilterTaggedTransactions.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$RequestFilterTaggedTransactions pfmOuterClass$RequestFilterTaggedTransactions = new PfmOuterClass$RequestFilterTaggedTransactions();
        DEFAULT_INSTANCE = pfmOuterClass$RequestFilterTaggedTransactions;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$RequestFilterTaggedTransactions.class, pfmOuterClass$RequestFilterTaggedTransactions);
    }

    private PfmOuterClass$RequestFilterTaggedTransactions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIds(Iterable<? extends PfmStruct$PfmTransactionId> iterable) {
        ensureIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.ids_);
    }

    private void addIds(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureIdsIsMutable();
        this.ids_.add(pfmStruct$PfmTransactionId);
    }

    private void clearIds() {
        this.ids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureIdsIsMutable() {
        B.j jVar = this.ids_;
        if (jVar.u()) {
            return;
        }
        this.ids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeIds(int i) {
        ensureIdsIsMutable();
        this.ids_.remove(i);
    }

    private void setIds(int i, PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureIdsIsMutable();
        this.ids_.set(i, pfmStruct$PfmTransactionId);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$RequestFilterTaggedTransactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"ids_", PfmStruct$PfmTransactionId.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$RequestFilterTaggedTransactions.class) {
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

    public PfmStruct$PfmTransactionId getIds(int i) {
        return (PfmStruct$PfmTransactionId) this.ids_.get(i);
    }

    public int getIdsCount() {
        return this.ids_.size();
    }

    public List<PfmStruct$PfmTransactionId> getIdsList() {
        return this.ids_;
    }

    public InterfaceC23559x75 getIdsOrBuilder(int i) {
        return (InterfaceC23559x75) this.ids_.get(i);
    }

    public List<? extends InterfaceC23559x75> getIdsOrBuilderList() {
        return this.ids_;
    }

    public static a newBuilder(PfmOuterClass$RequestFilterTaggedTransactions pfmOuterClass$RequestFilterTaggedTransactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$RequestFilterTaggedTransactions);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addIds(int i, PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        ensureIdsIsMutable();
        this.ids_.add(i, pfmStruct$PfmTransactionId);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(byte[] bArr) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$RequestFilterTaggedTransactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$RequestFilterTaggedTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
