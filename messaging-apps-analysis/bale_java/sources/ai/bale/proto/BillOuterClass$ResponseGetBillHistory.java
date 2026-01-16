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
public final class BillOuterClass$ResponseGetBillHistory extends GeneratedMessageLite implements U64 {
    public static final int BILLS_FIELD_NUMBER = 1;
    private static final BillOuterClass$ResponseGetBillHistory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j bills_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$ResponseGetBillHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$ResponseGetBillHistory billOuterClass$ResponseGetBillHistory = new BillOuterClass$ResponseGetBillHistory();
        DEFAULT_INSTANCE = billOuterClass$ResponseGetBillHistory;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$ResponseGetBillHistory.class, billOuterClass$ResponseGetBillHistory);
    }

    private BillOuterClass$ResponseGetBillHistory() {
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

    private void ensureBillsIsMutable() {
        B.j jVar = this.bills_;
        if (jVar.u()) {
            return;
        }
        this.bills_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BillOuterClass$ResponseGetBillHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillOuterClass$ResponseGetBillHistory parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$ResponseGetBillHistory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"bills_", BillStruct$Bill.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$ResponseGetBillHistory.class) {
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

    public static a newBuilder(BillOuterClass$ResponseGetBillHistory billOuterClass$ResponseGetBillHistory) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$ResponseGetBillHistory);
    }

    public static BillOuterClass$ResponseGetBillHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBills(int i, BillStruct$Bill billStruct$Bill) {
        billStruct$Bill.getClass();
        ensureBillsIsMutable();
        this.bills_.add(i, billStruct$Bill);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(byte[] bArr) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(InputStream inputStream) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$ResponseGetBillHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$ResponseGetBillHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
