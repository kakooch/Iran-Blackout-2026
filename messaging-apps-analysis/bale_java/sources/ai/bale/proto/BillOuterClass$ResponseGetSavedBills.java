package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5866Le0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BillOuterClass$ResponseGetSavedBills extends GeneratedMessageLite implements U64 {
    public static final int BILLS_FIELD_NUMBER = 1;
    private static final BillOuterClass$ResponseGetSavedBills DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j bills_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$ResponseGetSavedBills.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$ResponseGetSavedBills billOuterClass$ResponseGetSavedBills = new BillOuterClass$ResponseGetSavedBills();
        DEFAULT_INSTANCE = billOuterClass$ResponseGetSavedBills;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$ResponseGetSavedBills.class, billOuterClass$ResponseGetSavedBills);
    }

    private BillOuterClass$ResponseGetSavedBills() {
    }

    private void addAllBills(Iterable<? extends BillStruct$SavedBill> iterable) {
        ensureBillsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bills_);
    }

    private void addBills(BillStruct$SavedBill billStruct$SavedBill) {
        billStruct$SavedBill.getClass();
        ensureBillsIsMutable();
        this.bills_.add(billStruct$SavedBill);
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

    public static BillOuterClass$ResponseGetSavedBills getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillOuterClass$ResponseGetSavedBills parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBills(int i) {
        ensureBillsIsMutable();
        this.bills_.remove(i);
    }

    private void setBills(int i, BillStruct$SavedBill billStruct$SavedBill) {
        billStruct$SavedBill.getClass();
        ensureBillsIsMutable();
        this.bills_.set(i, billStruct$SavedBill);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$ResponseGetSavedBills();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"bills_", BillStruct$SavedBill.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$ResponseGetSavedBills.class) {
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

    public BillStruct$SavedBill getBills(int i) {
        return (BillStruct$SavedBill) this.bills_.get(i);
    }

    public int getBillsCount() {
        return this.bills_.size();
    }

    public List<BillStruct$SavedBill> getBillsList() {
        return this.bills_;
    }

    public InterfaceC5866Le0 getBillsOrBuilder(int i) {
        return (InterfaceC5866Le0) this.bills_.get(i);
    }

    public List<? extends InterfaceC5866Le0> getBillsOrBuilderList() {
        return this.bills_;
    }

    public static a newBuilder(BillOuterClass$ResponseGetSavedBills billOuterClass$ResponseGetSavedBills) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$ResponseGetSavedBills);
    }

    public static BillOuterClass$ResponseGetSavedBills parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBills(int i, BillStruct$SavedBill billStruct$SavedBill) {
        billStruct$SavedBill.getClass();
        ensureBillsIsMutable();
        this.bills_.add(i, billStruct$SavedBill);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(byte[] bArr) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(InputStream inputStream) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$ResponseGetSavedBills parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$ResponseGetSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
