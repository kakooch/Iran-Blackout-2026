package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22762vn0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$ResponseGetManualPaymentsReport extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$ResponseGetManualPaymentsReport DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPORT_FIELD_NUMBER = 1;
    private B.j report_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$ResponseGetManualPaymentsReport.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$ResponseGetManualPaymentsReport businessAdminOuterClass$ResponseGetManualPaymentsReport = new BusinessAdminOuterClass$ResponseGetManualPaymentsReport();
        DEFAULT_INSTANCE = businessAdminOuterClass$ResponseGetManualPaymentsReport;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$ResponseGetManualPaymentsReport.class, businessAdminOuterClass$ResponseGetManualPaymentsReport);
    }

    private BusinessAdminOuterClass$ResponseGetManualPaymentsReport() {
    }

    private void addAllReport(Iterable<? extends BusinessStruct$ManualPayment> iterable) {
        ensureReportIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.report_);
    }

    private void addReport(BusinessStruct$ManualPayment businessStruct$ManualPayment) {
        businessStruct$ManualPayment.getClass();
        ensureReportIsMutable();
        this.report_.add(businessStruct$ManualPayment);
    }

    private void clearReport() {
        this.report_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureReportIsMutable() {
        B.j jVar = this.report_;
        if (jVar.u()) {
            return;
        }
        this.report_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReport(int i) {
        ensureReportIsMutable();
        this.report_.remove(i);
    }

    private void setReport(int i, BusinessStruct$ManualPayment businessStruct$ManualPayment) {
        businessStruct$ManualPayment.getClass();
        ensureReportIsMutable();
        this.report_.set(i, businessStruct$ManualPayment);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$ResponseGetManualPaymentsReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"report_", BusinessStruct$ManualPayment.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$ResponseGetManualPaymentsReport.class) {
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

    public BusinessStruct$ManualPayment getReport(int i) {
        return (BusinessStruct$ManualPayment) this.report_.get(i);
    }

    public int getReportCount() {
        return this.report_.size();
    }

    public List<BusinessStruct$ManualPayment> getReportList() {
        return this.report_;
    }

    public InterfaceC22762vn0 getReportOrBuilder(int i) {
        return (InterfaceC22762vn0) this.report_.get(i);
    }

    public List<? extends InterfaceC22762vn0> getReportOrBuilderList() {
        return this.report_;
    }

    public static a newBuilder(BusinessAdminOuterClass$ResponseGetManualPaymentsReport businessAdminOuterClass$ResponseGetManualPaymentsReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$ResponseGetManualPaymentsReport);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReport(int i, BusinessStruct$ManualPayment businessStruct$ManualPayment) {
        businessStruct$ManualPayment.getClass();
        ensureReportIsMutable();
        this.report_.add(i, businessStruct$ManualPayment);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$ResponseGetManualPaymentsReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetManualPaymentsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
