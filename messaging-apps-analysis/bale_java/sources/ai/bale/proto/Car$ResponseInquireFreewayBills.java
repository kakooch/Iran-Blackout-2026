package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.GG0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Car$ResponseInquireFreewayBills extends GeneratedMessageLite implements U64 {
    public static final int BILLS_FIELD_NUMBER = 1;
    private static final Car$ResponseInquireFreewayBills DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j bills_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Car$ResponseInquireFreewayBills.DEFAULT_INSTANCE);
        }
    }

    static {
        Car$ResponseInquireFreewayBills car$ResponseInquireFreewayBills = new Car$ResponseInquireFreewayBills();
        DEFAULT_INSTANCE = car$ResponseInquireFreewayBills;
        GeneratedMessageLite.registerDefaultInstance(Car$ResponseInquireFreewayBills.class, car$ResponseInquireFreewayBills);
    }

    private Car$ResponseInquireFreewayBills() {
    }

    private void addAllBills(Iterable<? extends CarStruct$FreewayBillInfo> iterable) {
        ensureBillsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bills_);
    }

    private void addBills(CarStruct$FreewayBillInfo carStruct$FreewayBillInfo) {
        carStruct$FreewayBillInfo.getClass();
        ensureBillsIsMutable();
        this.bills_.add(carStruct$FreewayBillInfo);
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

    public static Car$ResponseInquireFreewayBills getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Car$ResponseInquireFreewayBills parseDelimitedFrom(InputStream inputStream) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(ByteBuffer byteBuffer) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBills(int i) {
        ensureBillsIsMutable();
        this.bills_.remove(i);
    }

    private void setBills(int i, CarStruct$FreewayBillInfo carStruct$FreewayBillInfo) {
        carStruct$FreewayBillInfo.getClass();
        ensureBillsIsMutable();
        this.bills_.set(i, carStruct$FreewayBillInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1905x.a[gVar.ordinal()]) {
            case 1:
                return new Car$ResponseInquireFreewayBills();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"bills_", CarStruct$FreewayBillInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Car$ResponseInquireFreewayBills.class) {
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

    public CarStruct$FreewayBillInfo getBills(int i) {
        return (CarStruct$FreewayBillInfo) this.bills_.get(i);
    }

    public int getBillsCount() {
        return this.bills_.size();
    }

    public List<CarStruct$FreewayBillInfo> getBillsList() {
        return this.bills_;
    }

    public GG0 getBillsOrBuilder(int i) {
        return (GG0) this.bills_.get(i);
    }

    public List<? extends GG0> getBillsOrBuilderList() {
        return this.bills_;
    }

    public static a newBuilder(Car$ResponseInquireFreewayBills car$ResponseInquireFreewayBills) {
        return (a) DEFAULT_INSTANCE.createBuilder(car$ResponseInquireFreewayBills);
    }

    public static Car$ResponseInquireFreewayBills parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(AbstractC2383g abstractC2383g) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBills(int i, CarStruct$FreewayBillInfo carStruct$FreewayBillInfo) {
        carStruct$FreewayBillInfo.getClass();
        ensureBillsIsMutable();
        this.bills_.add(i, carStruct$FreewayBillInfo);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(byte[] bArr) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(byte[] bArr, C2394s c2394s) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(InputStream inputStream) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(AbstractC2384h abstractC2384h) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Car$ResponseInquireFreewayBills parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Car$ResponseInquireFreewayBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
