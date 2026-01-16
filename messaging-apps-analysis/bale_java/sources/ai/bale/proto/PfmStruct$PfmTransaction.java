package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.B75;
import ir.nasim.C75;
import ir.nasim.EnumC24739z75;
import ir.nasim.InterfaceC24149y75;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PfmStruct$PfmTransaction extends GeneratedMessageLite implements InterfaceC24149y75 {
    public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 5;
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 2;
    private static final PfmStruct$PfmTransaction DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DETAIL_FIELD_NUMBER = 8;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SHREDDING_TYPE_FIELD_NUMBER = 11;
    public static final int TAGS_FIELD_NUMBER = 7;
    public static final int TRANSACTION_TYPE_FIELD_NUMBER = 4;
    public static final int USER_TRANSACTION_DATE_FIELD_NUMBER = 9;
    public static final int USER_TRANSACTION_TIMESTAMP_FIELD_NUMBER = 10;
    private long accountNumber_;
    private int bitField0_;
    private long date_;
    private StringValue description_;
    private long id_;
    private int shreddingType_;
    private int transactionType_;
    private StringValue userTransactionDate_;
    private CollectionsStruct$Int64Value userTransactionTimestamp_;
    private String amount_ = "";
    private B.j tags_ = GeneratedMessageLite.emptyProtobufList();
    private String detail_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC24149y75 {
        private a() {
            super(PfmStruct$PfmTransaction.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmStruct$PfmTransaction pfmStruct$PfmTransaction = new PfmStruct$PfmTransaction();
        DEFAULT_INSTANCE = pfmStruct$PfmTransaction;
        GeneratedMessageLite.registerDefaultInstance(PfmStruct$PfmTransaction.class, pfmStruct$PfmTransaction);
    }

    private PfmStruct$PfmTransaction() {
    }

    private void addAllTags(Iterable<? extends PfmStruct$PfmTransactionTag> iterable) {
        ensureTagsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tags_);
    }

    private void addTags(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(pfmStruct$PfmTransactionTag);
    }

    private void clearAccountNumber() {
        this.accountNumber_ = 0L;
    }

    private void clearAmount() {
        this.amount_ = getDefaultInstance().getAmount();
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDetail() {
        this.detail_ = getDefaultInstance().getDetail();
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearShreddingType() {
        this.shreddingType_ = 0;
    }

    private void clearTags() {
        this.tags_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTransactionType() {
        this.transactionType_ = 0;
    }

    private void clearUserTransactionDate() {
        this.userTransactionDate_ = null;
        this.bitField0_ &= -3;
    }

    private void clearUserTransactionTimestamp() {
        this.userTransactionTimestamp_ = null;
        this.bitField0_ &= -5;
    }

    private void ensureTagsIsMutable() {
        B.j jVar = this.tags_;
        if (jVar.u()) {
            return;
        }
        this.tags_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmStruct$PfmTransaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeUserTransactionDate(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.userTransactionDate_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.userTransactionDate_ = stringValue;
        } else {
            this.userTransactionDate_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.userTransactionDate_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeUserTransactionTimestamp(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.userTransactionTimestamp_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.userTransactionTimestamp_ = collectionsStruct$Int64Value;
        } else {
            this.userTransactionTimestamp_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.userTransactionTimestamp_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmStruct$PfmTransaction parseDelimitedFrom(InputStream inputStream) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTransaction parseFrom(ByteBuffer byteBuffer) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTags(int i) {
        ensureTagsIsMutable();
        this.tags_.remove(i);
    }

    private void setAccountNumber(long j) {
        this.accountNumber_ = j;
    }

    private void setAmount(String str) {
        str.getClass();
        this.amount_ = str;
    }

    private void setAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.amount_ = abstractC2383g.f0();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setDetail(String str) {
        str.getClass();
        this.detail_ = str;
    }

    private void setDetailBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.detail_ = abstractC2383g.f0();
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setShreddingType(EnumC24739z75 enumC24739z75) {
        this.shreddingType_ = enumC24739z75.getNumber();
    }

    private void setShreddingTypeValue(int i) {
        this.shreddingType_ = i;
    }

    private void setTags(int i, PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureTagsIsMutable();
        this.tags_.set(i, pfmStruct$PfmTransactionTag);
    }

    private void setTransactionType(C75 c75) {
        this.transactionType_ = c75.getNumber();
    }

    private void setTransactionTypeValue(int i) {
        this.transactionType_ = i;
    }

    private void setUserTransactionDate(StringValue stringValue) {
        stringValue.getClass();
        this.userTransactionDate_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setUserTransactionTimestamp(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.userTransactionTimestamp_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1851e1.a[gVar.ordinal()]) {
            case 1:
                return new PfmStruct$PfmTransaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003Ȉ\u0004\f\u0005\u0002\u0006ဉ\u0000\u0007\u001b\bȈ\tဉ\u0001\nဉ\u0002\u000b\f", new Object[]{"bitField0_", "id_", "date_", "amount_", "transactionType_", "accountNumber_", "description_", "tags_", PfmStruct$PfmTransactionTag.class, "detail_", "userTransactionDate_", "userTransactionTimestamp_", "shreddingType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmStruct$PfmTransaction.class) {
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

    public String getAmount() {
        return this.amount_;
    }

    public AbstractC2383g getAmountBytes() {
        return AbstractC2383g.N(this.amount_);
    }

    public long getDate() {
        return this.date_;
    }

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getDetail() {
        return this.detail_;
    }

    public AbstractC2383g getDetailBytes() {
        return AbstractC2383g.N(this.detail_);
    }

    public long getId() {
        return this.id_;
    }

    public EnumC24739z75 getShreddingType() {
        EnumC24739z75 enumC24739z75J = EnumC24739z75.j(this.shreddingType_);
        return enumC24739z75J == null ? EnumC24739z75.UNRECOGNIZED : enumC24739z75J;
    }

    public int getShreddingTypeValue() {
        return this.shreddingType_;
    }

    public PfmStruct$PfmTransactionTag getTags(int i) {
        return (PfmStruct$PfmTransactionTag) this.tags_.get(i);
    }

    public int getTagsCount() {
        return this.tags_.size();
    }

    public List<PfmStruct$PfmTransactionTag> getTagsList() {
        return this.tags_;
    }

    public B75 getTagsOrBuilder(int i) {
        return (B75) this.tags_.get(i);
    }

    public List<? extends B75> getTagsOrBuilderList() {
        return this.tags_;
    }

    public C75 getTransactionType() {
        C75 c75J = C75.j(this.transactionType_);
        return c75J == null ? C75.UNRECOGNIZED : c75J;
    }

    public int getTransactionTypeValue() {
        return this.transactionType_;
    }

    public StringValue getUserTransactionDate() {
        StringValue stringValue = this.userTransactionDate_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public CollectionsStruct$Int64Value getUserTransactionTimestamp() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.userTransactionTimestamp_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUserTransactionDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUserTransactionTimestamp() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(PfmStruct$PfmTransaction pfmStruct$PfmTransaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmStruct$PfmTransaction);
    }

    public static PfmStruct$PfmTransaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTransaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmStruct$PfmTransaction parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTags(int i, PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(i, pfmStruct$PfmTransactionTag);
    }

    public static PfmStruct$PfmTransaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmStruct$PfmTransaction parseFrom(byte[] bArr) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmStruct$PfmTransaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmStruct$PfmTransaction parseFrom(InputStream inputStream) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTransaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTransaction parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmStruct$PfmTransaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmStruct$PfmTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
