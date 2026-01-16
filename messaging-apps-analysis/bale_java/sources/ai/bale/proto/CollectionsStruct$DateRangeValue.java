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
public final class CollectionsStruct$DateRangeValue extends GeneratedMessageLite implements U64 {
    private static final CollectionsStruct$DateRangeValue DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SINCE_FIELD_NUMBER = 1;
    public static final int UNTIL_FIELD_NUMBER = 2;
    private long since_;
    private long until_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CollectionsStruct$DateRangeValue.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$DateRangeValue collectionsStruct$DateRangeValue = new CollectionsStruct$DateRangeValue();
        DEFAULT_INSTANCE = collectionsStruct$DateRangeValue;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$DateRangeValue.class, collectionsStruct$DateRangeValue);
    }

    private CollectionsStruct$DateRangeValue() {
    }

    private void clearSince() {
        this.since_ = 0L;
    }

    private void clearUntil() {
        this.until_ = 0L;
    }

    public static CollectionsStruct$DateRangeValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$DateRangeValue parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSince(long j) {
        this.since_ = j;
    }

    private void setUntil(long j) {
        this.until_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$DateRangeValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"since_", "until_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$DateRangeValue.class) {
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

    public long getSince() {
        return this.since_;
    }

    public long getUntil() {
        return this.until_;
    }

    public static a newBuilder(CollectionsStruct$DateRangeValue collectionsStruct$DateRangeValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$DateRangeValue);
    }

    public static CollectionsStruct$DateRangeValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(byte[] bArr) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(InputStream inputStream) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$DateRangeValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$DateRangeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
