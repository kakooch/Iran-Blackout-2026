package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC25132zn0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$ResponseGetPaymentGatewayReport extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$ResponseGetPaymentGatewayReport DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PG_REPORT_FIELD_NUMBER = 1;
    private B.j pgReport_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$ResponseGetPaymentGatewayReport.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$ResponseGetPaymentGatewayReport businessAdminOuterClass$ResponseGetPaymentGatewayReport = new BusinessAdminOuterClass$ResponseGetPaymentGatewayReport();
        DEFAULT_INSTANCE = businessAdminOuterClass$ResponseGetPaymentGatewayReport;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$ResponseGetPaymentGatewayReport.class, businessAdminOuterClass$ResponseGetPaymentGatewayReport);
    }

    private BusinessAdminOuterClass$ResponseGetPaymentGatewayReport() {
    }

    private void addAllPgReport(Iterable<? extends BusinessStruct$PaymentGatewayReport> iterable) {
        ensurePgReportIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pgReport_);
    }

    private void addPgReport(BusinessStruct$PaymentGatewayReport businessStruct$PaymentGatewayReport) {
        businessStruct$PaymentGatewayReport.getClass();
        ensurePgReportIsMutable();
        this.pgReport_.add(businessStruct$PaymentGatewayReport);
    }

    private void clearPgReport() {
        this.pgReport_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePgReportIsMutable() {
        B.j jVar = this.pgReport_;
        if (jVar.u()) {
            return;
        }
        this.pgReport_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePgReport(int i) {
        ensurePgReportIsMutable();
        this.pgReport_.remove(i);
    }

    private void setPgReport(int i, BusinessStruct$PaymentGatewayReport businessStruct$PaymentGatewayReport) {
        businessStruct$PaymentGatewayReport.getClass();
        ensurePgReportIsMutable();
        this.pgReport_.set(i, businessStruct$PaymentGatewayReport);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$ResponseGetPaymentGatewayReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"pgReport_", BusinessStruct$PaymentGatewayReport.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport.class) {
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

    public BusinessStruct$PaymentGatewayReport getPgReport(int i) {
        return (BusinessStruct$PaymentGatewayReport) this.pgReport_.get(i);
    }

    public int getPgReportCount() {
        return this.pgReport_.size();
    }

    public List<BusinessStruct$PaymentGatewayReport> getPgReportList() {
        return this.pgReport_;
    }

    public InterfaceC25132zn0 getPgReportOrBuilder(int i) {
        return (InterfaceC25132zn0) this.pgReport_.get(i);
    }

    public List<? extends InterfaceC25132zn0> getPgReportOrBuilderList() {
        return this.pgReport_;
    }

    public static a newBuilder(BusinessAdminOuterClass$ResponseGetPaymentGatewayReport businessAdminOuterClass$ResponseGetPaymentGatewayReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$ResponseGetPaymentGatewayReport);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPgReport(int i, BusinessStruct$PaymentGatewayReport businessStruct$PaymentGatewayReport) {
        businessStruct$PaymentGatewayReport.getClass();
        ensurePgReportIsMutable();
        this.pgReport_.add(i, businessStruct$PaymentGatewayReport);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$ResponseGetPaymentGatewayReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
