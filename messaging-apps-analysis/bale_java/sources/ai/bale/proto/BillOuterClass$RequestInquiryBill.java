package ai.bale.proto;

import ai.bale.proto.BillStruct$BillParameters;
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
public final class BillOuterClass$RequestInquiryBill extends GeneratedMessageLite implements U64 {
    public static final int BILL_PARAMETERS_FIELD_NUMBER = 2;
    public static final int BILL_TYPE_FIELD_NUMBER = 1;
    private static final BillOuterClass$RequestInquiryBill DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private BillStruct$BillParameters billParameters_;
    private int billType_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$RequestInquiryBill.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$RequestInquiryBill billOuterClass$RequestInquiryBill = new BillOuterClass$RequestInquiryBill();
        DEFAULT_INSTANCE = billOuterClass$RequestInquiryBill;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$RequestInquiryBill.class, billOuterClass$RequestInquiryBill);
    }

    private BillOuterClass$RequestInquiryBill() {
    }

    private void clearBillParameters() {
        this.billParameters_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBillType() {
        this.billType_ = 0;
    }

    public static BillOuterClass$RequestInquiryBill getDefaultInstance() {
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

    public static BillOuterClass$RequestInquiryBill parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$RequestInquiryBill();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "billType_", "billParameters_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$RequestInquiryBill.class) {
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

    public boolean hasBillParameters() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BillOuterClass$RequestInquiryBill billOuterClass$RequestInquiryBill) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$RequestInquiryBill);
    }

    public static BillOuterClass$RequestInquiryBill parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(byte[] bArr) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(InputStream inputStream) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$RequestInquiryBill parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$RequestInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
