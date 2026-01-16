package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$RequestGetPaymentGatewayReport extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$RequestGetPaymentGatewayReport DEFAULT_INSTANCE;
    public static final int FROM_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TO_FIELD_NUMBER = 2;
    private long from_;
    private long to_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$RequestGetPaymentGatewayReport.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$RequestGetPaymentGatewayReport businessAdminOuterClass$RequestGetPaymentGatewayReport = new BusinessAdminOuterClass$RequestGetPaymentGatewayReport();
        DEFAULT_INSTANCE = businessAdminOuterClass$RequestGetPaymentGatewayReport;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$RequestGetPaymentGatewayReport.class, businessAdminOuterClass$RequestGetPaymentGatewayReport);
    }

    private BusinessAdminOuterClass$RequestGetPaymentGatewayReport() {
    }

    private void clearFrom() {
        this.from_ = 0L;
    }

    private void clearTo() {
        this.to_ = 0L;
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFrom(long j) {
        this.from_ = j;
    }

    private void setTo(long j) {
        this.to_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$RequestGetPaymentGatewayReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"from_", "to_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$RequestGetPaymentGatewayReport.class) {
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

    public long getFrom() {
        return this.from_;
    }

    public long getTo() {
        return this.to_;
    }

    public static a newBuilder(BusinessAdminOuterClass$RequestGetPaymentGatewayReport businessAdminOuterClass$RequestGetPaymentGatewayReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$RequestGetPaymentGatewayReport);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$RequestGetPaymentGatewayReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetPaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
