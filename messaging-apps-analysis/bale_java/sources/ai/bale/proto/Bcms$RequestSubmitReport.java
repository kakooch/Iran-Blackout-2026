package ai.bale.proto;

import ai.bale.proto.BcmsStruct$Report;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Bcms$RequestSubmitReport extends GeneratedMessageLite implements U64 {
    private static final Bcms$RequestSubmitReport DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPORT_FIELD_NUMBER = 1;
    private int bitField0_;
    private BcmsStruct$Report report_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Bcms$RequestSubmitReport.DEFAULT_INSTANCE);
        }
    }

    static {
        Bcms$RequestSubmitReport bcms$RequestSubmitReport = new Bcms$RequestSubmitReport();
        DEFAULT_INSTANCE = bcms$RequestSubmitReport;
        GeneratedMessageLite.registerDefaultInstance(Bcms$RequestSubmitReport.class, bcms$RequestSubmitReport);
    }

    private Bcms$RequestSubmitReport() {
    }

    private void clearReport() {
        this.report_ = null;
        this.bitField0_ &= -2;
    }

    public static Bcms$RequestSubmitReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeReport(BcmsStruct$Report bcmsStruct$Report) {
        bcmsStruct$Report.getClass();
        BcmsStruct$Report bcmsStruct$Report2 = this.report_;
        if (bcmsStruct$Report2 == null || bcmsStruct$Report2 == BcmsStruct$Report.getDefaultInstance()) {
            this.report_ = bcmsStruct$Report;
        } else {
            this.report_ = (BcmsStruct$Report) ((BcmsStruct$Report.a) BcmsStruct$Report.newBuilder(this.report_).v(bcmsStruct$Report)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Bcms$RequestSubmitReport parseDelimitedFrom(InputStream inputStream) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Bcms$RequestSubmitReport parseFrom(ByteBuffer byteBuffer) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setReport(BcmsStruct$Report bcmsStruct$Report) {
        bcmsStruct$Report.getClass();
        this.report_ = bcmsStruct$Report;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1882p.a[gVar.ordinal()]) {
            case 1:
                return new Bcms$RequestSubmitReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "report_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Bcms$RequestSubmitReport.class) {
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

    public BcmsStruct$Report getReport() {
        BcmsStruct$Report bcmsStruct$Report = this.report_;
        return bcmsStruct$Report == null ? BcmsStruct$Report.getDefaultInstance() : bcmsStruct$Report;
    }

    public boolean hasReport() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Bcms$RequestSubmitReport bcms$RequestSubmitReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(bcms$RequestSubmitReport);
    }

    public static Bcms$RequestSubmitReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Bcms$RequestSubmitReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Bcms$RequestSubmitReport parseFrom(AbstractC2383g abstractC2383g) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Bcms$RequestSubmitReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Bcms$RequestSubmitReport parseFrom(byte[] bArr) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Bcms$RequestSubmitReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Bcms$RequestSubmitReport parseFrom(InputStream inputStream) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Bcms$RequestSubmitReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Bcms$RequestSubmitReport parseFrom(AbstractC2384h abstractC2384h) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Bcms$RequestSubmitReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Bcms$RequestSubmitReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
