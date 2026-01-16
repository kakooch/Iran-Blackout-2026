package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.U96;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SafirOuterClass$ResponseGetSendMessageReports extends GeneratedMessageLite implements U64 {
    private static final SafirOuterClass$ResponseGetSendMessageReports DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPORT_GROUPS_FIELD_NUMBER = 1;
    private B.j reportGroups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirOuterClass$ResponseGetSendMessageReports.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirOuterClass$ResponseGetSendMessageReports safirOuterClass$ResponseGetSendMessageReports = new SafirOuterClass$ResponseGetSendMessageReports();
        DEFAULT_INSTANCE = safirOuterClass$ResponseGetSendMessageReports;
        GeneratedMessageLite.registerDefaultInstance(SafirOuterClass$ResponseGetSendMessageReports.class, safirOuterClass$ResponseGetSendMessageReports);
    }

    private SafirOuterClass$ResponseGetSendMessageReports() {
    }

    private void addAllReportGroups(Iterable<? extends SafirStruct$SafirBotSendMessageTimeGroupReport> iterable) {
        ensureReportGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reportGroups_);
    }

    private void addReportGroups(SafirStruct$SafirBotSendMessageTimeGroupReport safirStruct$SafirBotSendMessageTimeGroupReport) {
        safirStruct$SafirBotSendMessageTimeGroupReport.getClass();
        ensureReportGroupsIsMutable();
        this.reportGroups_.add(safirStruct$SafirBotSendMessageTimeGroupReport);
    }

    private void clearReportGroups() {
        this.reportGroups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureReportGroupsIsMutable() {
        B.j jVar = this.reportGroups_;
        if (jVar.u()) {
            return;
        }
        this.reportGroups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseDelimitedFrom(InputStream inputStream) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(ByteBuffer byteBuffer) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReportGroups(int i) {
        ensureReportGroupsIsMutable();
        this.reportGroups_.remove(i);
    }

    private void setReportGroups(int i, SafirStruct$SafirBotSendMessageTimeGroupReport safirStruct$SafirBotSendMessageTimeGroupReport) {
        safirStruct$SafirBotSendMessageTimeGroupReport.getClass();
        ensureReportGroupsIsMutable();
        this.reportGroups_.set(i, safirStruct$SafirBotSendMessageTimeGroupReport);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E1.a[gVar.ordinal()]) {
            case 1:
                return new SafirOuterClass$ResponseGetSendMessageReports();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"reportGroups_", SafirStruct$SafirBotSendMessageTimeGroupReport.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirOuterClass$ResponseGetSendMessageReports.class) {
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

    public SafirStruct$SafirBotSendMessageTimeGroupReport getReportGroups(int i) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) this.reportGroups_.get(i);
    }

    public int getReportGroupsCount() {
        return this.reportGroups_.size();
    }

    public List<SafirStruct$SafirBotSendMessageTimeGroupReport> getReportGroupsList() {
        return this.reportGroups_;
    }

    public U96 getReportGroupsOrBuilder(int i) {
        return (U96) this.reportGroups_.get(i);
    }

    public List<? extends U96> getReportGroupsOrBuilderList() {
        return this.reportGroups_;
    }

    public static a newBuilder(SafirOuterClass$ResponseGetSendMessageReports safirOuterClass$ResponseGetSendMessageReports) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirOuterClass$ResponseGetSendMessageReports);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReportGroups(int i, SafirStruct$SafirBotSendMessageTimeGroupReport safirStruct$SafirBotSendMessageTimeGroupReport) {
        safirStruct$SafirBotSendMessageTimeGroupReport.getClass();
        ensureReportGroupsIsMutable();
        this.reportGroups_.add(i, safirStruct$SafirBotSendMessageTimeGroupReport);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(byte[] bArr) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(InputStream inputStream) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirOuterClass$ResponseGetSendMessageReports parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
