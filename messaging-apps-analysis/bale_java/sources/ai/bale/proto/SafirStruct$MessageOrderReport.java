package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirStruct$MessageOrderReport extends GeneratedMessageLite implements U64 {
    public static final int BLOCKED_COUNT_FIELD_NUMBER = 5;
    private static final SafirStruct$MessageOrderReport DEFAULT_INSTANCE;
    public static final int DELIVERED_COUNT_FIELD_NUMBER = 4;
    public static final int FAILED_COUNT_FIELD_NUMBER = 6;
    public static final int MESSAGE_SENT_COUNT_FIELD_NUMBER = 1;
    public static final int NOT_BALE_COUNT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SEEN_COUNT_FIELD_NUMBER = 3;
    public static final int TOTAL_COUNT_FIELD_NUMBER = 7;
    private int blockedCount_;
    private int deliveredCount_;
    private int failedCount_;
    private int messageSentCount_;
    private int notBaleCount_;
    private int seenCount_;
    private int totalCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirStruct$MessageOrderReport.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirStruct$MessageOrderReport safirStruct$MessageOrderReport = new SafirStruct$MessageOrderReport();
        DEFAULT_INSTANCE = safirStruct$MessageOrderReport;
        GeneratedMessageLite.registerDefaultInstance(SafirStruct$MessageOrderReport.class, safirStruct$MessageOrderReport);
    }

    private SafirStruct$MessageOrderReport() {
    }

    private void clearBlockedCount() {
        this.blockedCount_ = 0;
    }

    private void clearDeliveredCount() {
        this.deliveredCount_ = 0;
    }

    private void clearFailedCount() {
        this.failedCount_ = 0;
    }

    private void clearMessageSentCount() {
        this.messageSentCount_ = 0;
    }

    private void clearNotBaleCount() {
        this.notBaleCount_ = 0;
    }

    private void clearSeenCount() {
        this.seenCount_ = 0;
    }

    private void clearTotalCount() {
        this.totalCount_ = 0;
    }

    public static SafirStruct$MessageOrderReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirStruct$MessageOrderReport parseDelimitedFrom(InputStream inputStream) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$MessageOrderReport parseFrom(ByteBuffer byteBuffer) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBlockedCount(int i) {
        this.blockedCount_ = i;
    }

    private void setDeliveredCount(int i) {
        this.deliveredCount_ = i;
    }

    private void setFailedCount(int i) {
        this.failedCount_ = i;
    }

    private void setMessageSentCount(int i) {
        this.messageSentCount_ = i;
    }

    private void setNotBaleCount(int i) {
        this.notBaleCount_ = i;
    }

    private void setSeenCount(int i) {
        this.seenCount_ = i;
    }

    private void setTotalCount(int i) {
        this.totalCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G1.a[gVar.ordinal()]) {
            case 1:
                return new SafirStruct$MessageOrderReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0004", new Object[]{"messageSentCount_", "notBaleCount_", "seenCount_", "deliveredCount_", "blockedCount_", "failedCount_", "totalCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirStruct$MessageOrderReport.class) {
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

    public int getBlockedCount() {
        return this.blockedCount_;
    }

    public int getDeliveredCount() {
        return this.deliveredCount_;
    }

    public int getFailedCount() {
        return this.failedCount_;
    }

    public int getMessageSentCount() {
        return this.messageSentCount_;
    }

    public int getNotBaleCount() {
        return this.notBaleCount_;
    }

    public int getSeenCount() {
        return this.seenCount_;
    }

    public int getTotalCount() {
        return this.totalCount_;
    }

    public static a newBuilder(SafirStruct$MessageOrderReport safirStruct$MessageOrderReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirStruct$MessageOrderReport);
    }

    public static SafirStruct$MessageOrderReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$MessageOrderReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirStruct$MessageOrderReport parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirStruct$MessageOrderReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirStruct$MessageOrderReport parseFrom(byte[] bArr) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirStruct$MessageOrderReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirStruct$MessageOrderReport parseFrom(InputStream inputStream) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$MessageOrderReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$MessageOrderReport parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirStruct$MessageOrderReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirStruct$MessageOrderReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
