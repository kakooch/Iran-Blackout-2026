package ai.bale.proto;

import ai.bale.proto.ReportStruct$InappropriateContentReport;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ReportOuterClass$RequestReportInappropriateContent extends GeneratedMessageLite implements U64 {
    private static final ReportOuterClass$RequestReportInappropriateContent DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPORT_FIELD_NUMBER = 1;
    private int bitField0_;
    private ReportStruct$InappropriateContentReport report_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport) {
            q();
            ((ReportOuterClass$RequestReportInappropriateContent) this.b).setReport(reportStruct$InappropriateContentReport);
            return this;
        }

        private a() {
            super(ReportOuterClass$RequestReportInappropriateContent.DEFAULT_INSTANCE);
        }
    }

    static {
        ReportOuterClass$RequestReportInappropriateContent reportOuterClass$RequestReportInappropriateContent = new ReportOuterClass$RequestReportInappropriateContent();
        DEFAULT_INSTANCE = reportOuterClass$RequestReportInappropriateContent;
        GeneratedMessageLite.registerDefaultInstance(ReportOuterClass$RequestReportInappropriateContent.class, reportOuterClass$RequestReportInappropriateContent);
    }

    private ReportOuterClass$RequestReportInappropriateContent() {
    }

    private void clearReport() {
        this.report_ = null;
        this.bitField0_ &= -2;
    }

    public static ReportOuterClass$RequestReportInappropriateContent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeReport(ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport) {
        reportStruct$InappropriateContentReport.getClass();
        ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport2 = this.report_;
        if (reportStruct$InappropriateContentReport2 == null || reportStruct$InappropriateContentReport2 == ReportStruct$InappropriateContentReport.getDefaultInstance()) {
            this.report_ = reportStruct$InappropriateContentReport;
        } else {
            this.report_ = (ReportStruct$InappropriateContentReport) ((ReportStruct$InappropriateContentReport.a) ReportStruct$InappropriateContentReport.newBuilder(this.report_).v(reportStruct$InappropriateContentReport)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseDelimitedFrom(InputStream inputStream) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(ByteBuffer byteBuffer) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReport(ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport) {
        reportStruct$InappropriateContentReport.getClass();
        this.report_ = reportStruct$InappropriateContentReport;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1910y1.a[gVar.ordinal()]) {
            case 1:
                return new ReportOuterClass$RequestReportInappropriateContent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "report_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReportOuterClass$RequestReportInappropriateContent.class) {
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

    public ReportStruct$InappropriateContentReport getReport() {
        ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport = this.report_;
        return reportStruct$InappropriateContentReport == null ? ReportStruct$InappropriateContentReport.getDefaultInstance() : reportStruct$InappropriateContentReport;
    }

    public boolean hasReport() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ReportOuterClass$RequestReportInappropriateContent reportOuterClass$RequestReportInappropriateContent) {
        return (a) DEFAULT_INSTANCE.createBuilder(reportOuterClass$RequestReportInappropriateContent);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(AbstractC2383g abstractC2383g) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(byte[] bArr) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(InputStream inputStream) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(AbstractC2384h abstractC2384h) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReportOuterClass$RequestReportInappropriateContent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReportOuterClass$RequestReportInappropriateContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
