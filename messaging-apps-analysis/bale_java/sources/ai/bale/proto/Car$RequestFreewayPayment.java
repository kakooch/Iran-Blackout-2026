package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Car$RequestFreewayPayment extends GeneratedMessageLite implements U64 {
    public static final int BILL_IDS_FIELD_NUMBER = 1;
    private static final Car$RequestFreewayPayment DEFAULT_INSTANCE;
    public static final int MOBILE_NO_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j billIds_ = GeneratedMessageLite.emptyProtobufList();
    private String mobileNo_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Car$RequestFreewayPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        Car$RequestFreewayPayment car$RequestFreewayPayment = new Car$RequestFreewayPayment();
        DEFAULT_INSTANCE = car$RequestFreewayPayment;
        GeneratedMessageLite.registerDefaultInstance(Car$RequestFreewayPayment.class, car$RequestFreewayPayment);
    }

    private Car$RequestFreewayPayment() {
    }

    private void addAllBillIds(Iterable<String> iterable) {
        ensureBillIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.billIds_);
    }

    private void addBillIds(String str) {
        str.getClass();
        ensureBillIdsIsMutable();
        this.billIds_.add(str);
    }

    private void addBillIdsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureBillIdsIsMutable();
        this.billIds_.add(abstractC2383g.f0());
    }

    private void clearBillIds() {
        this.billIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMobileNo() {
        this.mobileNo_ = getDefaultInstance().getMobileNo();
    }

    private void ensureBillIdsIsMutable() {
        B.j jVar = this.billIds_;
        if (jVar.u()) {
            return;
        }
        this.billIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Car$RequestFreewayPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Car$RequestFreewayPayment parseDelimitedFrom(InputStream inputStream) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$RequestFreewayPayment parseFrom(ByteBuffer byteBuffer) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBillIds(int i, String str) {
        str.getClass();
        ensureBillIdsIsMutable();
        this.billIds_.set(i, str);
    }

    private void setMobileNo(String str) {
        str.getClass();
        this.mobileNo_ = str;
    }

    private void setMobileNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mobileNo_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1905x.a[gVar.ordinal()]) {
            case 1:
                return new Car$RequestFreewayPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002Ȉ", new Object[]{"billIds_", "mobileNo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Car$RequestFreewayPayment.class) {
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

    public String getBillIds(int i) {
        return (String) this.billIds_.get(i);
    }

    public AbstractC2383g getBillIdsBytes(int i) {
        return AbstractC2383g.N((String) this.billIds_.get(i));
    }

    public int getBillIdsCount() {
        return this.billIds_.size();
    }

    public List<String> getBillIdsList() {
        return this.billIds_;
    }

    public String getMobileNo() {
        return this.mobileNo_;
    }

    public AbstractC2383g getMobileNoBytes() {
        return AbstractC2383g.N(this.mobileNo_);
    }

    public static a newBuilder(Car$RequestFreewayPayment car$RequestFreewayPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(car$RequestFreewayPayment);
    }

    public static Car$RequestFreewayPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$RequestFreewayPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Car$RequestFreewayPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Car$RequestFreewayPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Car$RequestFreewayPayment parseFrom(byte[] bArr) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Car$RequestFreewayPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Car$RequestFreewayPayment parseFrom(InputStream inputStream) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$RequestFreewayPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$RequestFreewayPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Car$RequestFreewayPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Car$RequestFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
