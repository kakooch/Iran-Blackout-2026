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
public final class ClubOuterClass$RequestGetAcquiredVouchers extends GeneratedMessageLite implements U64 {
    private static final ClubOuterClass$RequestGetAcquiredVouchers DEFAULT_INSTANCE;
    public static final int PAGE_FIELD_NUMBER = 1;
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int pageSize_;
    private int page_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ClubOuterClass$RequestGetAcquiredVouchers.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubOuterClass$RequestGetAcquiredVouchers clubOuterClass$RequestGetAcquiredVouchers = new ClubOuterClass$RequestGetAcquiredVouchers();
        DEFAULT_INSTANCE = clubOuterClass$RequestGetAcquiredVouchers;
        GeneratedMessageLite.registerDefaultInstance(ClubOuterClass$RequestGetAcquiredVouchers.class, clubOuterClass$RequestGetAcquiredVouchers);
    }

    private ClubOuterClass$RequestGetAcquiredVouchers() {
    }

    private void clearPage() {
        this.page_ = 0;
    }

    private void clearPageSize() {
        this.pageSize_ = 0;
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseDelimitedFrom(InputStream inputStream) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(ByteBuffer byteBuffer) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPage(int i) {
        this.page_ = i;
    }

    private void setPageSize(int i) {
        this.pageSize_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B.a[gVar.ordinal()]) {
            case 1:
                return new ClubOuterClass$RequestGetAcquiredVouchers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"page_", "pageSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubOuterClass$RequestGetAcquiredVouchers.class) {
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

    public int getPage() {
        return this.page_;
    }

    public int getPageSize() {
        return this.pageSize_;
    }

    public static a newBuilder(ClubOuterClass$RequestGetAcquiredVouchers clubOuterClass$RequestGetAcquiredVouchers) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubOuterClass$RequestGetAcquiredVouchers);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(byte[] bArr) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(InputStream inputStream) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubOuterClass$RequestGetAcquiredVouchers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubOuterClass$RequestGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
