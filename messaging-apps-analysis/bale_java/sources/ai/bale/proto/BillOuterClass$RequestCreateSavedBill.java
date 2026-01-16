package ai.bale.proto;

import ai.bale.proto.BillStruct$BillParameters;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5398Je0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BillOuterClass$RequestCreateSavedBill extends GeneratedMessageLite implements U64 {
    public static final int BILL_PARAMETER_FIELD_NUMBER = 3;
    public static final int BILL_TYPE_FIELD_NUMBER = 2;
    private static final BillOuterClass$RequestCreateSavedBill DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private BillStruct$BillParameters billParameter_;
    private int billType_;
    private int bitField0_;
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$RequestCreateSavedBill.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$RequestCreateSavedBill billOuterClass$RequestCreateSavedBill = new BillOuterClass$RequestCreateSavedBill();
        DEFAULT_INSTANCE = billOuterClass$RequestCreateSavedBill;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$RequestCreateSavedBill.class, billOuterClass$RequestCreateSavedBill);
    }

    private BillOuterClass$RequestCreateSavedBill() {
    }

    private void clearBillParameter() {
        this.billParameter_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBillType() {
        this.billType_ = 0;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    public static BillOuterClass$RequestCreateSavedBill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBillParameter(BillStruct$BillParameters billStruct$BillParameters) {
        billStruct$BillParameters.getClass();
        BillStruct$BillParameters billStruct$BillParameters2 = this.billParameter_;
        if (billStruct$BillParameters2 == null || billStruct$BillParameters2 == BillStruct$BillParameters.getDefaultInstance()) {
            this.billParameter_ = billStruct$BillParameters;
        } else {
            this.billParameter_ = (BillStruct$BillParameters) ((BillStruct$BillParameters.a) BillStruct$BillParameters.newBuilder(this.billParameter_).v(billStruct$BillParameters)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillOuterClass$RequestCreateSavedBill parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBillParameter(BillStruct$BillParameters billStruct$BillParameters) {
        billStruct$BillParameters.getClass();
        this.billParameter_ = billStruct$BillParameters;
        this.bitField0_ |= 1;
    }

    private void setBillType(EnumC5398Je0 enumC5398Je0) {
        this.billType_ = enumC5398Je0.getNumber();
    }

    private void setBillTypeValue(int i) {
        this.billType_ = i;
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
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$RequestCreateSavedBill();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003ဉ\u0000", new Object[]{"bitField0_", "name_", "billType_", "billParameter_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$RequestCreateSavedBill.class) {
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

    public BillStruct$BillParameters getBillParameter() {
        BillStruct$BillParameters billStruct$BillParameters = this.billParameter_;
        return billStruct$BillParameters == null ? BillStruct$BillParameters.getDefaultInstance() : billStruct$BillParameters;
    }

    public EnumC5398Je0 getBillType() {
        EnumC5398Je0 enumC5398Je0J = EnumC5398Je0.j(this.billType_);
        return enumC5398Je0J == null ? EnumC5398Je0.UNRECOGNIZED : enumC5398Je0J;
    }

    public int getBillTypeValue() {
        return this.billType_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public boolean hasBillParameter() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BillOuterClass$RequestCreateSavedBill billOuterClass$RequestCreateSavedBill) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$RequestCreateSavedBill);
    }

    public static BillOuterClass$RequestCreateSavedBill parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(byte[] bArr) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(InputStream inputStream) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$RequestCreateSavedBill parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$RequestCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
