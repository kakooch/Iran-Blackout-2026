package ai.bale.proto;

import ai.bale.proto.BillStruct$Bill;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BillOuterClass$RequestPayBill extends GeneratedMessageLite implements U64 {
    public static final int BILL_FIELD_NUMBER = 1;
    private static final BillOuterClass$RequestPayBill DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private BillStruct$Bill bill_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$RequestPayBill.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$RequestPayBill billOuterClass$RequestPayBill = new BillOuterClass$RequestPayBill();
        DEFAULT_INSTANCE = billOuterClass$RequestPayBill;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$RequestPayBill.class, billOuterClass$RequestPayBill);
    }

    private BillOuterClass$RequestPayBill() {
    }

    private void clearBill() {
        this.bill_ = null;
        this.bitField0_ &= -2;
    }

    public static BillOuterClass$RequestPayBill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBill(BillStruct$Bill billStruct$Bill) {
        billStruct$Bill.getClass();
        BillStruct$Bill billStruct$Bill2 = this.bill_;
        if (billStruct$Bill2 == null || billStruct$Bill2 == BillStruct$Bill.getDefaultInstance()) {
            this.bill_ = billStruct$Bill;
        } else {
            this.bill_ = (BillStruct$Bill) ((BillStruct$Bill.a) BillStruct$Bill.newBuilder(this.bill_).v(billStruct$Bill)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillOuterClass$RequestPayBill parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$RequestPayBill parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBill(BillStruct$Bill billStruct$Bill) {
        billStruct$Bill.getClass();
        this.bill_ = billStruct$Bill;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$RequestPayBill();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "bill_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$RequestPayBill.class) {
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

    public BillStruct$Bill getBill() {
        BillStruct$Bill billStruct$Bill = this.bill_;
        return billStruct$Bill == null ? BillStruct$Bill.getDefaultInstance() : billStruct$Bill;
    }

    public boolean hasBill() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BillOuterClass$RequestPayBill billOuterClass$RequestPayBill) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$RequestPayBill);
    }

    public static BillOuterClass$RequestPayBill parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$RequestPayBill parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$RequestPayBill parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillOuterClass$RequestPayBill parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$RequestPayBill parseFrom(byte[] bArr) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$RequestPayBill parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$RequestPayBill parseFrom(InputStream inputStream) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$RequestPayBill parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$RequestPayBill parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$RequestPayBill parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$RequestPayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
