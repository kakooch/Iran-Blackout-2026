package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestGetCallLogs extends GeneratedMessageLite implements U64 {
    public static final int AFTER_DATE_FIELD_NUMBER = 3;
    public static final int BEFORE_DATE_FIELD_NUMBER = 4;
    private static final MeetOuterClass$RequestGetCallLogs DEFAULT_INSTANCE;
    public static final int PAGE_NUMBER_FIELD_NUMBER = 1;
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private CollectionsStruct$Int64Value afterDate_;
    private CollectionsStruct$Int64Value beforeDate_;
    private int bitField0_;
    private CollectionsStruct$Int64Value pageNumber_;
    private CollectionsStruct$Int64Value pageSize_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((MeetOuterClass$RequestGetCallLogs) this.b).setPageNumber(collectionsStruct$Int64Value);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestGetCallLogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestGetCallLogs meetOuterClass$RequestGetCallLogs = new MeetOuterClass$RequestGetCallLogs();
        DEFAULT_INSTANCE = meetOuterClass$RequestGetCallLogs;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestGetCallLogs.class, meetOuterClass$RequestGetCallLogs);
    }

    private MeetOuterClass$RequestGetCallLogs() {
    }

    private void clearAfterDate() {
        this.afterDate_ = null;
        this.bitField0_ &= -5;
    }

    private void clearBeforeDate() {
        this.beforeDate_ = null;
        this.bitField0_ &= -9;
    }

    private void clearPageNumber() {
        this.pageNumber_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPageSize() {
        this.pageSize_ = null;
        this.bitField0_ &= -3;
    }

    public static MeetOuterClass$RequestGetCallLogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAfterDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.afterDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.afterDate_ = collectionsStruct$Int64Value;
        } else {
            this.afterDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.afterDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeBeforeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.beforeDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.beforeDate_ = collectionsStruct$Int64Value;
        } else {
            this.beforeDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.beforeDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergePageNumber(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.pageNumber_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.pageNumber_ = collectionsStruct$Int64Value;
        } else {
            this.pageNumber_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.pageNumber_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePageSize(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.pageSize_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.pageSize_ = collectionsStruct$Int64Value;
        } else {
            this.pageSize_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.pageSize_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestGetCallLogs parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAfterDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.afterDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setBeforeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.beforeDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageNumber(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.pageNumber_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setPageSize(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.pageSize_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestGetCallLogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"bitField0_", "pageNumber_", "pageSize_", "afterDate_", "beforeDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestGetCallLogs.class) {
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

    @Deprecated
    public CollectionsStruct$Int64Value getAfterDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.afterDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$Int64Value getBeforeDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.beforeDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$Int64Value getPageNumber() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.pageNumber_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$Int64Value getPageSize() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.pageSize_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    @Deprecated
    public boolean hasAfterDate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasBeforeDate() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPageNumber() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPageSize() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestGetCallLogs meetOuterClass$RequestGetCallLogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestGetCallLogs);
    }

    public static MeetOuterClass$RequestGetCallLogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestGetCallLogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
