package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16679lh;
import ir.nasim.EnumC3298Ah;
import ir.nasim.InterfaceC16088kh;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$IncomeReport extends GeneratedMessageLite implements InterfaceC16088kh {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final AdvertisementStruct$IncomeReport DEFAULT_INSTANCE;
    public static final int IS_PAYABLE_FIELD_NUMBER = 5;
    public static final int IS_PAYED_FIELD_NUMBER = 4;
    public static final int MONTH_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PAYED_AT_FIELD_NUMBER = 6;
    public static final int STATE_FIELD_NUMBER = 7;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int YEAR_FIELD_NUMBER = 1;
    private long amount_;
    private int bitField0_;
    private boolean isPayable_;
    private boolean isPayed_;
    private int month_;
    private CollectionsStruct$Int64Value payedAt_;
    private int state_;
    private int type_;
    private int year_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC16088kh {
        private a() {
            super(AdvertisementStruct$IncomeReport.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$IncomeReport advertisementStruct$IncomeReport = new AdvertisementStruct$IncomeReport();
        DEFAULT_INSTANCE = advertisementStruct$IncomeReport;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$IncomeReport.class, advertisementStruct$IncomeReport);
    }

    private AdvertisementStruct$IncomeReport() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearIsPayable() {
        this.isPayable_ = false;
    }

    private void clearIsPayed() {
        this.isPayed_ = false;
    }

    private void clearMonth() {
        this.month_ = 0;
    }

    private void clearPayedAt() {
        this.payedAt_ = null;
        this.bitField0_ &= -2;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearYear() {
        this.year_ = 0;
    }

    public static AdvertisementStruct$IncomeReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePayedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.payedAt_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.payedAt_ = collectionsStruct$Int64Value;
        } else {
            this.payedAt_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.payedAt_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$IncomeReport parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setIsPayable(boolean z) {
        this.isPayable_ = z;
    }

    private void setIsPayed(boolean z) {
        this.isPayed_ = z;
    }

    private void setMonth(int i) {
        this.month_ = i;
    }

    private void setPayedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.payedAt_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setState(EnumC16679lh enumC16679lh) {
        this.state_ = enumC16679lh.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    private void setType(EnumC3298Ah enumC3298Ah) {
        this.type_ = enumC3298Ah.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setYear(int i) {
        this.year_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$IncomeReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0002\u0004\u0007\u0005\u0007\u0006ဉ\u0000\u0007\f\b\f", new Object[]{"bitField0_", "year_", "month_", "amount_", "isPayed_", "isPayable_", "payedAt_", "state_", "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$IncomeReport.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public boolean getIsPayable() {
        return this.isPayable_;
    }

    public boolean getIsPayed() {
        return this.isPayed_;
    }

    public int getMonth() {
        return this.month_;
    }

    public CollectionsStruct$Int64Value getPayedAt() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.payedAt_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public EnumC16679lh getState() {
        EnumC16679lh enumC16679lhJ = EnumC16679lh.j(this.state_);
        return enumC16679lhJ == null ? EnumC16679lh.UNRECOGNIZED : enumC16679lhJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public EnumC3298Ah getType() {
        EnumC3298Ah enumC3298AhJ = EnumC3298Ah.j(this.type_);
        return enumC3298AhJ == null ? EnumC3298Ah.UNRECOGNIZED : enumC3298AhJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public int getYear() {
        return this.year_;
    }

    public boolean hasPayedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$IncomeReport advertisementStruct$IncomeReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$IncomeReport);
    }

    public static AdvertisementStruct$IncomeReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(byte[] bArr) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$IncomeReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$IncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
