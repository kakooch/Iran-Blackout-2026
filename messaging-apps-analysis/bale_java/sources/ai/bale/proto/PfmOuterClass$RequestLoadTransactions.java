package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.B75;
import ir.nasim.C75;
import ir.nasim.EnumC6845Pf4;
import ir.nasim.F75;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PfmOuterClass$RequestLoadTransactions extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 1;
    private static final PfmOuterClass$RequestLoadTransactions DEFAULT_INSTANCE;
    public static final int END_DATE_FIELD_NUMBER = 3;
    public static final int LABEL_FIELD_NUMBER = 5;
    public static final int LIMIT_FIELD_NUMBER = 6;
    public static final int LOAD_MODE_FIELD_NUMBER = 8;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int START_DATE_FIELD_NUMBER = 2;
    public static final int TRANSACTION_TYPE_FIELD_NUMBER = 4;
    public static final int USER_TAG_TYPE_FIELD_NUMBER = 9;
    private long accountNumber_;
    private int bitField0_;
    private CollectionsStruct$Int64Value endDate_;
    private B.j label_ = GeneratedMessageLite.emptyProtobufList();
    private int limit_;
    private int loadMode_;
    private CollectionsStruct$StringValue loadMoreState_;
    private CollectionsStruct$Int64Value startDate_;
    private int transactionType_;
    private int userTagType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PfmOuterClass$RequestLoadTransactions) this.b).addAllLabel(iterable);
            return this;
        }

        public a B(long j) {
            q();
            ((PfmOuterClass$RequestLoadTransactions) this.b).setAccountNumber(j);
            return this;
        }

        public a C(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((PfmOuterClass$RequestLoadTransactions) this.b).setEndDate(collectionsStruct$Int64Value);
            return this;
        }

        public a D(int i) {
            q();
            ((PfmOuterClass$RequestLoadTransactions) this.b).setLimit(i);
            return this;
        }

        public a E(EnumC6845Pf4 enumC6845Pf4) {
            q();
            ((PfmOuterClass$RequestLoadTransactions) this.b).setLoadMode(enumC6845Pf4);
            return this;
        }

        public a F(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((PfmOuterClass$RequestLoadTransactions) this.b).setStartDate(collectionsStruct$Int64Value);
            return this;
        }

        public a G(C75 c75) {
            q();
            ((PfmOuterClass$RequestLoadTransactions) this.b).setTransactionType(c75);
            return this;
        }

        public a H(F75 f75) {
            q();
            ((PfmOuterClass$RequestLoadTransactions) this.b).setUserTagType(f75);
            return this;
        }

        private a() {
            super(PfmOuterClass$RequestLoadTransactions.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$RequestLoadTransactions pfmOuterClass$RequestLoadTransactions = new PfmOuterClass$RequestLoadTransactions();
        DEFAULT_INSTANCE = pfmOuterClass$RequestLoadTransactions;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$RequestLoadTransactions.class, pfmOuterClass$RequestLoadTransactions);
    }

    private PfmOuterClass$RequestLoadTransactions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLabel(Iterable<? extends PfmStruct$PfmTransactionTag> iterable) {
        ensureLabelIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.label_);
    }

    private void addLabel(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureLabelIsMutable();
        this.label_.add(pfmStruct$PfmTransactionTag);
    }

    private void clearAccountNumber() {
        this.accountNumber_ = 0L;
    }

    private void clearEndDate() {
        this.endDate_ = null;
        this.bitField0_ &= -3;
    }

    private void clearLabel() {
        this.label_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearLoadMode() {
        this.loadMode_ = 0;
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -5;
    }

    private void clearStartDate() {
        this.startDate_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTransactionType() {
        this.transactionType_ = 0;
    }

    private void clearUserTagType() {
        this.userTagType_ = 0;
    }

    private void ensureLabelIsMutable() {
        B.j jVar = this.label_;
        if (jVar.u()) {
            return;
        }
        this.label_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$RequestLoadTransactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeEndDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.endDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.endDate_ = collectionsStruct$Int64Value;
        } else {
            this.endDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.endDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeLoadMoreState(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.loadMoreState_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.loadMoreState_ = collectionsStruct$StringValue;
        } else {
            this.loadMoreState_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.loadMoreState_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeStartDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.startDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.startDate_ = collectionsStruct$Int64Value;
        } else {
            this.startDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.startDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$RequestLoadTransactions parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLabel(int i) {
        ensureLabelIsMutable();
        this.label_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccountNumber(long j) {
        this.accountNumber_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.endDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setLabel(int i, PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureLabelIsMutable();
        this.label_.set(i, pfmStruct$PfmTransactionTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadMode(EnumC6845Pf4 enumC6845Pf4) {
        this.loadMode_ = enumC6845Pf4.getNumber();
    }

    private void setLoadModeValue(int i) {
        this.loadMode_ = i;
    }

    private void setLoadMoreState(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.loadMoreState_ = collectionsStruct$StringValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.startDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransactionType(C75 c75) {
        this.transactionType_ = c75.getNumber();
    }

    private void setTransactionTypeValue(int i) {
        this.transactionType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserTagType(F75 f75) {
        this.userTagType_ = f75.getNumber();
    }

    private void setUserTagTypeValue(int i) {
        this.userTagType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$RequestLoadTransactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001\u0002\u0002ဉ\u0000\u0003ဉ\u0001\u0004\f\u0005\u001b\u0006\u0004\u0007ဉ\u0002\b\f\t\f", new Object[]{"bitField0_", "accountNumber_", "startDate_", "endDate_", "transactionType_", "label_", PfmStruct$PfmTransactionTag.class, "limit_", "loadMoreState_", "loadMode_", "userTagType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$RequestLoadTransactions.class) {
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

    public long getAccountNumber() {
        return this.accountNumber_;
    }

    public CollectionsStruct$Int64Value getEndDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.endDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public PfmStruct$PfmTransactionTag getLabel(int i) {
        return (PfmStruct$PfmTransactionTag) this.label_.get(i);
    }

    public int getLabelCount() {
        return this.label_.size();
    }

    public List<PfmStruct$PfmTransactionTag> getLabelList() {
        return this.label_;
    }

    public B75 getLabelOrBuilder(int i) {
        return (B75) this.label_.get(i);
    }

    public List<? extends B75> getLabelOrBuilderList() {
        return this.label_;
    }

    public int getLimit() {
        return this.limit_;
    }

    public EnumC6845Pf4 getLoadMode() {
        EnumC6845Pf4 enumC6845Pf4J = EnumC6845Pf4.j(this.loadMode_);
        return enumC6845Pf4J == null ? EnumC6845Pf4.UNRECOGNIZED : enumC6845Pf4J;
    }

    public int getLoadModeValue() {
        return this.loadMode_;
    }

    public CollectionsStruct$StringValue getLoadMoreState() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.loadMoreState_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public CollectionsStruct$Int64Value getStartDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.startDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public C75 getTransactionType() {
        C75 c75J = C75.j(this.transactionType_);
        return c75J == null ? C75.UNRECOGNIZED : c75J;
    }

    public int getTransactionTypeValue() {
        return this.transactionType_;
    }

    public F75 getUserTagType() {
        F75 f75J = F75.j(this.userTagType_);
        return f75J == null ? F75.UNRECOGNIZED : f75J;
    }

    public int getUserTagTypeValue() {
        return this.userTagType_;
    }

    public boolean hasEndDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasStartDate() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmOuterClass$RequestLoadTransactions pfmOuterClass$RequestLoadTransactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$RequestLoadTransactions);
    }

    public static PfmOuterClass$RequestLoadTransactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addLabel(int i, PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureLabelIsMutable();
        this.label_.add(i, pfmStruct$PfmTransactionTag);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(byte[] bArr) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$RequestLoadTransactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$RequestLoadTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
