package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.IG0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Car$ResponseInquireFreewayPayment extends GeneratedMessageLite implements U64 {
    private static final Car$ResponseInquireFreewayPayment DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 1;
    public static final int GATEWAY_NAME_FIELD_NUMBER = 2;
    public static final int GATEWAY_PERSIAN_NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RECEIPTS_FIELD_NUMBER = 4;
    private String description_ = "";
    private String gatewayName_ = "";
    private String gatewayPersianName_ = "";
    private B.j receipts_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Car$ResponseInquireFreewayPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        Car$ResponseInquireFreewayPayment car$ResponseInquireFreewayPayment = new Car$ResponseInquireFreewayPayment();
        DEFAULT_INSTANCE = car$ResponseInquireFreewayPayment;
        GeneratedMessageLite.registerDefaultInstance(Car$ResponseInquireFreewayPayment.class, car$ResponseInquireFreewayPayment);
    }

    private Car$ResponseInquireFreewayPayment() {
    }

    private void addAllReceipts(Iterable<? extends CarStruct$FreewayPaymentReceipts> iterable) {
        ensureReceiptsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.receipts_);
    }

    private void addReceipts(CarStruct$FreewayPaymentReceipts carStruct$FreewayPaymentReceipts) {
        carStruct$FreewayPaymentReceipts.getClass();
        ensureReceiptsIsMutable();
        this.receipts_.add(carStruct$FreewayPaymentReceipts);
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearGatewayName() {
        this.gatewayName_ = getDefaultInstance().getGatewayName();
    }

    private void clearGatewayPersianName() {
        this.gatewayPersianName_ = getDefaultInstance().getGatewayPersianName();
    }

    private void clearReceipts() {
        this.receipts_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureReceiptsIsMutable() {
        B.j jVar = this.receipts_;
        if (jVar.u()) {
            return;
        }
        this.receipts_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Car$ResponseInquireFreewayPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Car$ResponseInquireFreewayPayment parseDelimitedFrom(InputStream inputStream) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(ByteBuffer byteBuffer) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReceipts(int i) {
        ensureReceiptsIsMutable();
        this.receipts_.remove(i);
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setGatewayName(String str) {
        str.getClass();
        this.gatewayName_ = str;
    }

    private void setGatewayNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.gatewayName_ = abstractC2383g.f0();
    }

    private void setGatewayPersianName(String str) {
        str.getClass();
        this.gatewayPersianName_ = str;
    }

    private void setGatewayPersianNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.gatewayPersianName_ = abstractC2383g.f0();
    }

    private void setReceipts(int i, CarStruct$FreewayPaymentReceipts carStruct$FreewayPaymentReceipts) {
        carStruct$FreewayPaymentReceipts.getClass();
        ensureReceiptsIsMutable();
        this.receipts_.set(i, carStruct$FreewayPaymentReceipts);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1905x.a[gVar.ordinal()]) {
            case 1:
                return new Car$ResponseInquireFreewayPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u001b", new Object[]{"description_", "gatewayName_", "gatewayPersianName_", "receipts_", CarStruct$FreewayPaymentReceipts.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Car$ResponseInquireFreewayPayment.class) {
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

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getGatewayName() {
        return this.gatewayName_;
    }

    public AbstractC2383g getGatewayNameBytes() {
        return AbstractC2383g.N(this.gatewayName_);
    }

    public String getGatewayPersianName() {
        return this.gatewayPersianName_;
    }

    public AbstractC2383g getGatewayPersianNameBytes() {
        return AbstractC2383g.N(this.gatewayPersianName_);
    }

    public CarStruct$FreewayPaymentReceipts getReceipts(int i) {
        return (CarStruct$FreewayPaymentReceipts) this.receipts_.get(i);
    }

    public int getReceiptsCount() {
        return this.receipts_.size();
    }

    public List<CarStruct$FreewayPaymentReceipts> getReceiptsList() {
        return this.receipts_;
    }

    public IG0 getReceiptsOrBuilder(int i) {
        return (IG0) this.receipts_.get(i);
    }

    public List<? extends IG0> getReceiptsOrBuilderList() {
        return this.receipts_;
    }

    public static a newBuilder(Car$ResponseInquireFreewayPayment car$ResponseInquireFreewayPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(car$ResponseInquireFreewayPayment);
    }

    public static Car$ResponseInquireFreewayPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReceipts(int i, CarStruct$FreewayPaymentReceipts carStruct$FreewayPaymentReceipts) {
        carStruct$FreewayPaymentReceipts.getClass();
        ensureReceiptsIsMutable();
        this.receipts_.add(i, carStruct$FreewayPaymentReceipts);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(byte[] bArr) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(InputStream inputStream) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Car$ResponseInquireFreewayPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Car$ResponseInquireFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
