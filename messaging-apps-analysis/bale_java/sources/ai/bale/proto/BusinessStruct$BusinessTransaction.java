package ai.bale.proto;

import ai.bale.proto.BusinessStruct$Description;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC19695qn0;
import ir.nasim.EnumC20895sn0;
import ir.nasim.InterfaceC20304rn0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessStruct$BusinessTransaction extends GeneratedMessageLite implements InterfaceC20304rn0 {
    public static final int DATE_FIELD_NUMBER = 5;
    private static final BusinessStruct$BusinessTransaction DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 2;
    public static final int TX_ACTION_FIELD_NUMBER = 4;
    public static final int TX_TYPE_FIELD_NUMBER = 3;
    private int bitField0_;
    private long date_;
    private BusinessStruct$Description description_;
    private String id_ = "";
    private long price_;
    private int txAction_;
    private int txType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20304rn0 {
        private a() {
            super(BusinessStruct$BusinessTransaction.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessStruct$BusinessTransaction businessStruct$BusinessTransaction = new BusinessStruct$BusinessTransaction();
        DEFAULT_INSTANCE = businessStruct$BusinessTransaction;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$BusinessTransaction.class, businessStruct$BusinessTransaction);
    }

    private BusinessStruct$BusinessTransaction() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -2;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearPrice() {
        this.price_ = 0L;
    }

    private void clearTxAction() {
        this.txAction_ = 0;
    }

    private void clearTxType() {
        this.txType_ = 0;
    }

    public static BusinessStruct$BusinessTransaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(BusinessStruct$Description businessStruct$Description) {
        businessStruct$Description.getClass();
        BusinessStruct$Description businessStruct$Description2 = this.description_;
        if (businessStruct$Description2 == null || businessStruct$Description2 == BusinessStruct$Description.getDefaultInstance()) {
            this.description_ = businessStruct$Description;
        } else {
            this.description_ = (BusinessStruct$Description) ((BusinessStruct$Description.a) BusinessStruct$Description.newBuilder(this.description_).v(businessStruct$Description)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$BusinessTransaction parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setDescription(BusinessStruct$Description businessStruct$Description) {
        businessStruct$Description.getClass();
        this.description_ = businessStruct$Description;
        this.bitField0_ |= 1;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setPrice(long j) {
        this.price_ = j;
    }

    private void setTxAction(EnumC19695qn0 enumC19695qn0) {
        this.txAction_ = enumC19695qn0.getNumber();
    }

    private void setTxActionValue(int i) {
        this.txAction_ = i;
    }

    private void setTxType(EnumC20895sn0 enumC20895sn0) {
        this.txType_ = enumC20895sn0.getNumber();
    }

    private void setTxTypeValue(int i) {
        this.txType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$BusinessTransaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\f\u0004\f\u0005\u0002\u0006ဉ\u0000", new Object[]{"bitField0_", "id_", "price_", "txType_", "txAction_", "date_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$BusinessTransaction.class) {
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

    public long getDate() {
        return this.date_;
    }

    public BusinessStruct$Description getDescription() {
        BusinessStruct$Description businessStruct$Description = this.description_;
        return businessStruct$Description == null ? BusinessStruct$Description.getDefaultInstance() : businessStruct$Description;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public long getPrice() {
        return this.price_;
    }

    public EnumC19695qn0 getTxAction() {
        EnumC19695qn0 enumC19695qn0J = EnumC19695qn0.j(this.txAction_);
        return enumC19695qn0J == null ? EnumC19695qn0.UNRECOGNIZED : enumC19695qn0J;
    }

    public int getTxActionValue() {
        return this.txAction_;
    }

    public EnumC20895sn0 getTxType() {
        EnumC20895sn0 enumC20895sn0J = EnumC20895sn0.j(this.txType_);
        return enumC20895sn0J == null ? EnumC20895sn0.UNRECOGNIZED : enumC20895sn0J;
    }

    public int getTxTypeValue() {
        return this.txType_;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessStruct$BusinessTransaction businessStruct$BusinessTransaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$BusinessTransaction);
    }

    public static BusinessStruct$BusinessTransaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(byte[] bArr) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(InputStream inputStream) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$BusinessTransaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$BusinessTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
