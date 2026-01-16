package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16088kh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetChannelIncomeReport extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetChannelIncomeReport DEFAULT_INSTANCE;
    public static final int INCOME_REPORTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j incomeReports_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetChannelIncomeReport.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetChannelIncomeReport advertisementOuterClass$ResponseGetChannelIncomeReport = new AdvertisementOuterClass$ResponseGetChannelIncomeReport();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetChannelIncomeReport;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetChannelIncomeReport.class, advertisementOuterClass$ResponseGetChannelIncomeReport);
    }

    private AdvertisementOuterClass$ResponseGetChannelIncomeReport() {
    }

    private void addAllIncomeReports(Iterable<? extends AdvertisementStruct$IncomeReport> iterable) {
        ensureIncomeReportsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.incomeReports_);
    }

    private void addIncomeReports(AdvertisementStruct$IncomeReport advertisementStruct$IncomeReport) {
        advertisementStruct$IncomeReport.getClass();
        ensureIncomeReportsIsMutable();
        this.incomeReports_.add(advertisementStruct$IncomeReport);
    }

    private void clearIncomeReports() {
        this.incomeReports_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureIncomeReportsIsMutable() {
        B.j jVar = this.incomeReports_;
        if (jVar.u()) {
            return;
        }
        this.incomeReports_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeIncomeReports(int i) {
        ensureIncomeReportsIsMutable();
        this.incomeReports_.remove(i);
    }

    private void setIncomeReports(int i, AdvertisementStruct$IncomeReport advertisementStruct$IncomeReport) {
        advertisementStruct$IncomeReport.getClass();
        ensureIncomeReportsIsMutable();
        this.incomeReports_.set(i, advertisementStruct$IncomeReport);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetChannelIncomeReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"incomeReports_", AdvertisementStruct$IncomeReport.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetChannelIncomeReport.class) {
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

    public AdvertisementStruct$IncomeReport getIncomeReports(int i) {
        return (AdvertisementStruct$IncomeReport) this.incomeReports_.get(i);
    }

    public int getIncomeReportsCount() {
        return this.incomeReports_.size();
    }

    public List<AdvertisementStruct$IncomeReport> getIncomeReportsList() {
        return this.incomeReports_;
    }

    public InterfaceC16088kh getIncomeReportsOrBuilder(int i) {
        return (InterfaceC16088kh) this.incomeReports_.get(i);
    }

    public List<? extends InterfaceC16088kh> getIncomeReportsOrBuilderList() {
        return this.incomeReports_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetChannelIncomeReport advertisementOuterClass$ResponseGetChannelIncomeReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetChannelIncomeReport);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addIncomeReports(int i, AdvertisementStruct$IncomeReport advertisementStruct$IncomeReport) {
        advertisementStruct$IncomeReport.getClass();
        ensureIncomeReportsIsMutable();
        this.incomeReports_.add(i, advertisementStruct$IncomeReport);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetChannelIncomeReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelIncomeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
