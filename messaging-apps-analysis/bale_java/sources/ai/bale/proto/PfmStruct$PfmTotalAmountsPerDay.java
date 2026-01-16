package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PfmStruct$PfmTotalAmount;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21783u75;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmStruct$PfmTotalAmountsPerDay extends GeneratedMessageLite implements InterfaceC21783u75 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int DATE_FIELD_NUMBER = 2;
    private static final PfmStruct$PfmTotalAmountsPerDay DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private PfmStruct$PfmTotalAmount amount_;
    private int bitField0_;
    private CollectionsStruct$Int64Value date_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC21783u75 {
        private a() {
            super(PfmStruct$PfmTotalAmountsPerDay.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmStruct$PfmTotalAmountsPerDay pfmStruct$PfmTotalAmountsPerDay = new PfmStruct$PfmTotalAmountsPerDay();
        DEFAULT_INSTANCE = pfmStruct$PfmTotalAmountsPerDay;
        GeneratedMessageLite.registerDefaultInstance(PfmStruct$PfmTotalAmountsPerDay.class, pfmStruct$PfmTotalAmountsPerDay);
    }

    private PfmStruct$PfmTotalAmountsPerDay() {
    }

    private void clearAmount() {
        this.amount_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -3;
    }

    public static PfmStruct$PfmTotalAmountsPerDay getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAmount(PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount) {
        pfmStruct$PfmTotalAmount.getClass();
        PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount2 = this.amount_;
        if (pfmStruct$PfmTotalAmount2 == null || pfmStruct$PfmTotalAmount2 == PfmStruct$PfmTotalAmount.getDefaultInstance()) {
            this.amount_ = pfmStruct$PfmTotalAmount;
        } else {
            this.amount_ = (PfmStruct$PfmTotalAmount) ((PfmStruct$PfmTotalAmount.a) PfmStruct$PfmTotalAmount.newBuilder(this.amount_).v(pfmStruct$PfmTotalAmount)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.date_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.date_ = collectionsStruct$Int64Value;
        } else {
            this.date_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.date_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseDelimitedFrom(InputStream inputStream) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(ByteBuffer byteBuffer) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount) {
        pfmStruct$PfmTotalAmount.getClass();
        this.amount_ = pfmStruct$PfmTotalAmount;
        this.bitField0_ |= 1;
    }

    private void setDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.date_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1851e1.a[gVar.ordinal()]) {
            case 1:
                return new PfmStruct$PfmTotalAmountsPerDay();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "amount_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmStruct$PfmTotalAmountsPerDay.class) {
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

    public PfmStruct$PfmTotalAmount getAmount() {
        PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount = this.amount_;
        return pfmStruct$PfmTotalAmount == null ? PfmStruct$PfmTotalAmount.getDefaultInstance() : pfmStruct$PfmTotalAmount;
    }

    public CollectionsStruct$Int64Value getDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.date_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean hasAmount() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(PfmStruct$PfmTotalAmountsPerDay pfmStruct$PfmTotalAmountsPerDay) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmStruct$PfmTotalAmountsPerDay);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(byte[] bArr) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(InputStream inputStream) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmStruct$PfmTotalAmountsPerDay parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmountsPerDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
