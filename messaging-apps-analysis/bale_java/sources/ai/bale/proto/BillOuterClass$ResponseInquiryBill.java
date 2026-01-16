package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4696Ge0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BillOuterClass$ResponseInquiryBill extends GeneratedMessageLite implements U64 {
    public static final int BILLS_FIELD_NUMBER = 1;
    public static final int CUSTOMER_NAME_FIELD_NUMBER = 2;
    private static final BillOuterClass$ResponseInquiryBill DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j bills_ = GeneratedMessageLite.emptyProtobufList();
    private String customerName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$ResponseInquiryBill.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$ResponseInquiryBill billOuterClass$ResponseInquiryBill = new BillOuterClass$ResponseInquiryBill();
        DEFAULT_INSTANCE = billOuterClass$ResponseInquiryBill;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$ResponseInquiryBill.class, billOuterClass$ResponseInquiryBill);
    }

    private BillOuterClass$ResponseInquiryBill() {
    }

    private void addAllBills(Iterable<? extends BillStruct$Bill> iterable) {
        ensureBillsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bills_);
    }

    private void addBills(BillStruct$Bill billStruct$Bill) {
        billStruct$Bill.getClass();
        ensureBillsIsMutable();
        this.bills_.add(billStruct$Bill);
    }

    private void clearBills() {
        this.bills_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearCustomerName() {
        this.customerName_ = getDefaultInstance().getCustomerName();
    }

    private void ensureBillsIsMutable() {
        B.j jVar = this.bills_;
        if (jVar.u()) {
            return;
        }
        this.bills_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BillOuterClass$ResponseInquiryBill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillOuterClass$ResponseInquiryBill parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBills(int i) {
        ensureBillsIsMutable();
        this.bills_.remove(i);
    }

    private void setBills(int i, BillStruct$Bill billStruct$Bill) {
        billStruct$Bill.getClass();
        ensureBillsIsMutable();
        this.bills_.set(i, billStruct$Bill);
    }

    private void setCustomerName(String str) {
        str.getClass();
        this.customerName_ = str;
    }

    private void setCustomerNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.customerName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$ResponseInquiryBill();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"bills_", BillStruct$Bill.class, "customerName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$ResponseInquiryBill.class) {
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

    public BillStruct$Bill getBills(int i) {
        return (BillStruct$Bill) this.bills_.get(i);
    }

    public int getBillsCount() {
        return this.bills_.size();
    }

    public List<BillStruct$Bill> getBillsList() {
        return this.bills_;
    }

    public InterfaceC4696Ge0 getBillsOrBuilder(int i) {
        return (InterfaceC4696Ge0) this.bills_.get(i);
    }

    public List<? extends InterfaceC4696Ge0> getBillsOrBuilderList() {
        return this.bills_;
    }

    public String getCustomerName() {
        return this.customerName_;
    }

    public AbstractC2383g getCustomerNameBytes() {
        return AbstractC2383g.N(this.customerName_);
    }

    public static a newBuilder(BillOuterClass$ResponseInquiryBill billOuterClass$ResponseInquiryBill) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$ResponseInquiryBill);
    }

    public static BillOuterClass$ResponseInquiryBill parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBills(int i, BillStruct$Bill billStruct$Bill) {
        billStruct$Bill.getClass();
        ensureBillsIsMutable();
        this.bills_.add(i, billStruct$Bill);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(byte[] bArr) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(InputStream inputStream) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$ResponseInquiryBill parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$ResponseInquiryBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
