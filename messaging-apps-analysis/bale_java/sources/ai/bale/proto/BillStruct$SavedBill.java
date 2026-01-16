package ai.bale.proto;

import ai.bale.proto.BillStruct$BillParameters;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5398Je0;
import ir.nasim.InterfaceC5866Le0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BillStruct$SavedBill extends GeneratedMessageLite implements InterfaceC5866Le0 {
    public static final int BILL_PARAMETERS_FIELD_NUMBER = 4;
    public static final int BILL_TYPE_FIELD_NUMBER = 3;
    private static final BillStruct$SavedBill DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private BillStruct$BillParameters billParameters_;
    private int billType_;
    private int bitField0_;
    private long id_;
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5866Le0 {
        private a() {
            super(BillStruct$SavedBill.DEFAULT_INSTANCE);
        }
    }

    static {
        BillStruct$SavedBill billStruct$SavedBill = new BillStruct$SavedBill();
        DEFAULT_INSTANCE = billStruct$SavedBill;
        GeneratedMessageLite.registerDefaultInstance(BillStruct$SavedBill.class, billStruct$SavedBill);
    }

    private BillStruct$SavedBill() {
    }

    private void clearBillParameters() {
        this.billParameters_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBillType() {
        this.billType_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    public static BillStruct$SavedBill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBillParameters(BillStruct$BillParameters billStruct$BillParameters) {
        billStruct$BillParameters.getClass();
        BillStruct$BillParameters billStruct$BillParameters2 = this.billParameters_;
        if (billStruct$BillParameters2 == null || billStruct$BillParameters2 == BillStruct$BillParameters.getDefaultInstance()) {
            this.billParameters_ = billStruct$BillParameters;
        } else {
            this.billParameters_ = (BillStruct$BillParameters) ((BillStruct$BillParameters.a) BillStruct$BillParameters.newBuilder(this.billParameters_).v(billStruct$BillParameters)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillStruct$SavedBill parseDelimitedFrom(InputStream inputStream) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillStruct$SavedBill parseFrom(ByteBuffer byteBuffer) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBillParameters(BillStruct$BillParameters billStruct$BillParameters) {
        billStruct$BillParameters.getClass();
        this.billParameters_ = billStruct$BillParameters;
        this.bitField0_ |= 1;
    }

    private void setBillType(EnumC5398Je0 enumC5398Je0) {
        this.billType_ = enumC5398Je0.getNumber();
    }

    private void setBillTypeValue(int i) {
        this.billType_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1890s.a[gVar.ordinal()]) {
            case 1:
                return new BillStruct$SavedBill();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\f\u0004ဉ\u0000", new Object[]{"bitField0_", "id_", "name_", "billType_", "billParameters_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillStruct$SavedBill.class) {
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

    public BillStruct$BillParameters getBillParameters() {
        BillStruct$BillParameters billStruct$BillParameters = this.billParameters_;
        return billStruct$BillParameters == null ? BillStruct$BillParameters.getDefaultInstance() : billStruct$BillParameters;
    }

    public EnumC5398Je0 getBillType() {
        EnumC5398Je0 enumC5398Je0J = EnumC5398Je0.j(this.billType_);
        return enumC5398Je0J == null ? EnumC5398Je0.UNRECOGNIZED : enumC5398Je0J;
    }

    public int getBillTypeValue() {
        return this.billType_;
    }

    public long getId() {
        return this.id_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public boolean hasBillParameters() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BillStruct$SavedBill billStruct$SavedBill) {
        return (a) DEFAULT_INSTANCE.createBuilder(billStruct$SavedBill);
    }

    public static BillStruct$SavedBill parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillStruct$SavedBill parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillStruct$SavedBill parseFrom(AbstractC2383g abstractC2383g) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillStruct$SavedBill parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillStruct$SavedBill parseFrom(byte[] bArr) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillStruct$SavedBill parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillStruct$SavedBill parseFrom(InputStream inputStream) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillStruct$SavedBill parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillStruct$SavedBill parseFrom(AbstractC2384h abstractC2384h) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillStruct$SavedBill parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillStruct$SavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
