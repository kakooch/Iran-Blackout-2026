package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC9799aa6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirOuterClass$RequestGetSendMessageReports extends GeneratedMessageLite implements U64 {
    private static final SafirOuterClass$RequestGetSendMessageReports DEFAULT_INSTANCE;
    public static final int END_TIME_FIELD_NUMBER = 3;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int START_TIME_FIELD_NUMBER = 2;
    public static final int TIME_GROUP_FIELD_NUMBER = 4;
    private long endTime_;
    private int organizationId_;
    private long startTime_;
    private int timeGroup_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirOuterClass$RequestGetSendMessageReports.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirOuterClass$RequestGetSendMessageReports safirOuterClass$RequestGetSendMessageReports = new SafirOuterClass$RequestGetSendMessageReports();
        DEFAULT_INSTANCE = safirOuterClass$RequestGetSendMessageReports;
        GeneratedMessageLite.registerDefaultInstance(SafirOuterClass$RequestGetSendMessageReports.class, safirOuterClass$RequestGetSendMessageReports);
    }

    private SafirOuterClass$RequestGetSendMessageReports() {
    }

    private void clearEndTime() {
        this.endTime_ = 0L;
    }

    private void clearOrganizationId() {
        this.organizationId_ = 0;
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    private void clearTimeGroup() {
        this.timeGroup_ = 0;
    }

    public static SafirOuterClass$RequestGetSendMessageReports getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseDelimitedFrom(InputStream inputStream) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(ByteBuffer byteBuffer) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEndTime(long j) {
        this.endTime_ = j;
    }

    private void setOrganizationId(int i) {
        this.organizationId_ = i;
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    private void setTimeGroup(EnumC9799aa6 enumC9799aa6) {
        this.timeGroup_ = enumC9799aa6.getNumber();
    }

    private void setTimeGroupValue(int i) {
        this.timeGroup_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E1.a[gVar.ordinal()]) {
            case 1:
                return new SafirOuterClass$RequestGetSendMessageReports();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002\u0004\f", new Object[]{"organizationId_", "startTime_", "endTime_", "timeGroup_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirOuterClass$RequestGetSendMessageReports.class) {
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

    public long getEndTime() {
        return this.endTime_;
    }

    public int getOrganizationId() {
        return this.organizationId_;
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public EnumC9799aa6 getTimeGroup() {
        EnumC9799aa6 enumC9799aa6J = EnumC9799aa6.j(this.timeGroup_);
        return enumC9799aa6J == null ? EnumC9799aa6.UNRECOGNIZED : enumC9799aa6J;
    }

    public int getTimeGroupValue() {
        return this.timeGroup_;
    }

    public static a newBuilder(SafirOuterClass$RequestGetSendMessageReports safirOuterClass$RequestGetSendMessageReports) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirOuterClass$RequestGetSendMessageReports);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(byte[] bArr) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(InputStream inputStream) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirOuterClass$RequestGetSendMessageReports parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSendMessageReports) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
