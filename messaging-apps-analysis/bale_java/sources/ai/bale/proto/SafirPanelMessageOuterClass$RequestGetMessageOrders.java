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
public final class SafirPanelMessageOuterClass$RequestGetMessageOrders extends GeneratedMessageLite implements U64 {
    private static final SafirPanelMessageOuterClass$RequestGetMessageOrders DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 1;
    public static final int OFFSET_FIELD_NUMBER = 2;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int limit_;
    private int offset_;
    private int organizationId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirPanelMessageOuterClass$RequestGetMessageOrders.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirPanelMessageOuterClass$RequestGetMessageOrders safirPanelMessageOuterClass$RequestGetMessageOrders = new SafirPanelMessageOuterClass$RequestGetMessageOrders();
        DEFAULT_INSTANCE = safirPanelMessageOuterClass$RequestGetMessageOrders;
        GeneratedMessageLite.registerDefaultInstance(SafirPanelMessageOuterClass$RequestGetMessageOrders.class, safirPanelMessageOuterClass$RequestGetMessageOrders);
    }

    private SafirPanelMessageOuterClass$RequestGetMessageOrders() {
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearOffset() {
        this.offset_ = 0;
    }

    private void clearOrganizationId() {
        this.organizationId_ = 0;
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseDelimitedFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(ByteBuffer byteBuffer) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLimit(int i) {
        this.limit_ = i;
    }

    private void setOffset(int i) {
        this.offset_ = i;
    }

    private void setOrganizationId(int i) {
        this.organizationId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F1.a[gVar.ordinal()]) {
            case 1:
                return new SafirPanelMessageOuterClass$RequestGetMessageOrders();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"limit_", "offset_", "organizationId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirPanelMessageOuterClass$RequestGetMessageOrders.class) {
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

    public int getLimit() {
        return this.limit_;
    }

    public int getOffset() {
        return this.offset_;
    }

    public int getOrganizationId() {
        return this.organizationId_;
    }

    public static a newBuilder(SafirPanelMessageOuterClass$RequestGetMessageOrders safirPanelMessageOuterClass$RequestGetMessageOrders) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirPanelMessageOuterClass$RequestGetMessageOrders);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(byte[] bArr) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirPanelMessageOuterClass$RequestGetMessageOrders parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
