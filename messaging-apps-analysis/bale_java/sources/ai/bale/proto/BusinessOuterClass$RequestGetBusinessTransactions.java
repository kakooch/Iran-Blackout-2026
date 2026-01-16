package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20895sn0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$RequestGetBusinessTransactions extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$RequestGetBusinessTransactions DEFAULT_INSTANCE;
    public static final int FROM_FIELD_NUMBER = 1;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TO_FIELD_NUMBER = 2;
    public static final int TRANSACTION_TYPES_FIELD_NUMBER = 3;
    private static final B.h.a transactionTypes_converter_ = new a();
    private long from_;
    private int limit_;
    private int offset_;
    private int organizationId_;
    private long to_;
    private int transactionTypesMemoizedSerializedSize;
    private B.g transactionTypes_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20895sn0 a(Integer num) {
            EnumC20895sn0 enumC20895sn0J = EnumC20895sn0.j(num.intValue());
            return enumC20895sn0J == null ? EnumC20895sn0.UNRECOGNIZED : enumC20895sn0J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(BusinessOuterClass$RequestGetBusinessTransactions.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$RequestGetBusinessTransactions businessOuterClass$RequestGetBusinessTransactions = new BusinessOuterClass$RequestGetBusinessTransactions();
        DEFAULT_INSTANCE = businessOuterClass$RequestGetBusinessTransactions;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestGetBusinessTransactions.class, businessOuterClass$RequestGetBusinessTransactions);
    }

    private BusinessOuterClass$RequestGetBusinessTransactions() {
    }

    private void addAllTransactionTypes(Iterable<? extends EnumC20895sn0> iterable) {
        ensureTransactionTypesIsMutable();
        Iterator<? extends EnumC20895sn0> it = iterable.iterator();
        while (it.hasNext()) {
            this.transactionTypes_.b1(it.next().getNumber());
        }
    }

    private void addAllTransactionTypesValue(Iterable<Integer> iterable) {
        ensureTransactionTypesIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.transactionTypes_.b1(it.next().intValue());
        }
    }

    private void addTransactionTypes(EnumC20895sn0 enumC20895sn0) {
        enumC20895sn0.getClass();
        ensureTransactionTypesIsMutable();
        this.transactionTypes_.b1(enumC20895sn0.getNumber());
    }

    private void addTransactionTypesValue(int i) {
        ensureTransactionTypesIsMutable();
        this.transactionTypes_.b1(i);
    }

    private void clearFrom() {
        this.from_ = 0L;
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearOffset() {
        this.offset_ = 0;
    }

    private void clearOrganizationId() {
        this.organizationId_ = 0;
    }

    private void clearTo() {
        this.to_ = 0L;
    }

    private void clearTransactionTypes() {
        this.transactionTypes_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureTransactionTypesIsMutable() {
        B.g gVar = this.transactionTypes_;
        if (gVar.u()) {
            return;
        }
        this.transactionTypes_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFrom(long j) {
        this.from_ = j;
    }

    private void setLimit(int i) {
        this.limit_ = i;
    }

    private void setOffset(int i) {
        this.offset_ = i;
    }

    private void setOrganizationId(int i) {
        this.organizationId_ = i;
    }

    private void setTo(long j) {
        this.to_ = j;
    }

    private void setTransactionTypes(int i, EnumC20895sn0 enumC20895sn0) {
        enumC20895sn0.getClass();
        ensureTransactionTypesIsMutable();
        this.transactionTypes_.U(i, enumC20895sn0.getNumber());
    }

    private void setTransactionTypesValue(int i, int i2) {
        ensureTransactionTypesIsMutable();
        this.transactionTypes_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestGetBusinessTransactions();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003,\u0004\u0004\u0005\u0004\u0006\u0004", new Object[]{"from_", "to_", "transactionTypes_", "organizationId_", "limit_", "offset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestGetBusinessTransactions.class) {
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

    public long getFrom() {
        return this.from_;
    }

    public int getLimit() {
        return this.limit_;
    }

    public int getOffset() {
        return this.offset_;
    }

    public int getOrganizationId() {
        return this.organizationId_;
    }

    public long getTo() {
        return this.to_;
    }

    public EnumC20895sn0 getTransactionTypes(int i) {
        EnumC20895sn0 enumC20895sn0J = EnumC20895sn0.j(this.transactionTypes_.getInt(i));
        return enumC20895sn0J == null ? EnumC20895sn0.UNRECOGNIZED : enumC20895sn0J;
    }

    public int getTransactionTypesCount() {
        return this.transactionTypes_.size();
    }

    public List<EnumC20895sn0> getTransactionTypesList() {
        return new B.h(this.transactionTypes_, transactionTypes_converter_);
    }

    public int getTransactionTypesValue(int i) {
        return this.transactionTypes_.getInt(i);
    }

    public List<Integer> getTransactionTypesValueList() {
        return this.transactionTypes_;
    }

    public static b newBuilder(BusinessOuterClass$RequestGetBusinessTransactions businessOuterClass$RequestGetBusinessTransactions) {
        return (b) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestGetBusinessTransactions);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestGetBusinessTransactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetBusinessTransactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
