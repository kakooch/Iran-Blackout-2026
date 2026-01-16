package ai.bale.proto;

import ai.bale.proto.PfmStruct$PfmTransactionId;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19306q75;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PfmOuterClass$RequestSplitTransaction extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$RequestSplitTransaction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_ID_FIELD_NUMBER = 1;
    public static final int UNITS_FIELD_NUMBER = 2;
    private int bitField0_;
    private PfmStruct$PfmTransactionId transactionId_;
    private B.j units_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$RequestSplitTransaction.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$RequestSplitTransaction pfmOuterClass$RequestSplitTransaction = new PfmOuterClass$RequestSplitTransaction();
        DEFAULT_INSTANCE = pfmOuterClass$RequestSplitTransaction;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$RequestSplitTransaction.class, pfmOuterClass$RequestSplitTransaction);
    }

    private PfmOuterClass$RequestSplitTransaction() {
    }

    private void addAllUnits(Iterable<? extends PfmStruct$PfmSplitUnit> iterable) {
        ensureUnitsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.units_);
    }

    private void addUnits(PfmStruct$PfmSplitUnit pfmStruct$PfmSplitUnit) {
        pfmStruct$PfmSplitUnit.getClass();
        ensureUnitsIsMutable();
        this.units_.add(pfmStruct$PfmSplitUnit);
    }

    private void clearTransactionId() {
        this.transactionId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUnits() {
        this.units_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUnitsIsMutable() {
        B.j jVar = this.units_;
        if (jVar.u()) {
            return;
        }
        this.units_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$RequestSplitTransaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTransactionId(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId2 = this.transactionId_;
        if (pfmStruct$PfmTransactionId2 == null || pfmStruct$PfmTransactionId2 == PfmStruct$PfmTransactionId.getDefaultInstance()) {
            this.transactionId_ = pfmStruct$PfmTransactionId;
        } else {
            this.transactionId_ = (PfmStruct$PfmTransactionId) ((PfmStruct$PfmTransactionId.a) PfmStruct$PfmTransactionId.newBuilder(this.transactionId_).v(pfmStruct$PfmTransactionId)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$RequestSplitTransaction parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUnits(int i) {
        ensureUnitsIsMutable();
        this.units_.remove(i);
    }

    private void setTransactionId(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        this.transactionId_ = pfmStruct$PfmTransactionId;
        this.bitField0_ |= 1;
    }

    private void setUnits(int i, PfmStruct$PfmSplitUnit pfmStruct$PfmSplitUnit) {
        pfmStruct$PfmSplitUnit.getClass();
        ensureUnitsIsMutable();
        this.units_.set(i, pfmStruct$PfmSplitUnit);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$RequestSplitTransaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "transactionId_", "units_", PfmStruct$PfmSplitUnit.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$RequestSplitTransaction.class) {
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

    public PfmStruct$PfmTransactionId getTransactionId() {
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId = this.transactionId_;
        return pfmStruct$PfmTransactionId == null ? PfmStruct$PfmTransactionId.getDefaultInstance() : pfmStruct$PfmTransactionId;
    }

    public PfmStruct$PfmSplitUnit getUnits(int i) {
        return (PfmStruct$PfmSplitUnit) this.units_.get(i);
    }

    public int getUnitsCount() {
        return this.units_.size();
    }

    public List<PfmStruct$PfmSplitUnit> getUnitsList() {
        return this.units_;
    }

    public InterfaceC19306q75 getUnitsOrBuilder(int i) {
        return (InterfaceC19306q75) this.units_.get(i);
    }

    public List<? extends InterfaceC19306q75> getUnitsOrBuilderList() {
        return this.units_;
    }

    public boolean hasTransactionId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmOuterClass$RequestSplitTransaction pfmOuterClass$RequestSplitTransaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$RequestSplitTransaction);
    }

    public static PfmOuterClass$RequestSplitTransaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUnits(int i, PfmStruct$PfmSplitUnit pfmStruct$PfmSplitUnit) {
        pfmStruct$PfmSplitUnit.getClass();
        ensureUnitsIsMutable();
        this.units_.add(i, pfmStruct$PfmSplitUnit);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(byte[] bArr) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$RequestSplitTransaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$RequestSplitTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
