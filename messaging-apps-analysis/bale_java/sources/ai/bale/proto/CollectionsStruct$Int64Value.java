package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20129rX0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CollectionsStruct$Int64Value extends GeneratedMessageLite implements InterfaceC20129rX0 {
    private static final CollectionsStruct$Int64Value DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20129rX0 {
        public a A(long j) {
            q();
            ((CollectionsStruct$Int64Value) this.b).setValue(j);
            return this;
        }

        private a() {
            super(CollectionsStruct$Int64Value.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = new CollectionsStruct$Int64Value();
        DEFAULT_INSTANCE = collectionsStruct$Int64Value;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$Int64Value.class, collectionsStruct$Int64Value);
    }

    private CollectionsStruct$Int64Value() {
    }

    private void clearValue() {
        this.value_ = 0L;
    }

    public static CollectionsStruct$Int64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$Int64Value parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$Int64Value parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(long j) {
        this.value_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$Int64Value();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$Int64Value.class) {
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

    public long getValue() {
        return this.value_;
    }

    public static a newBuilder(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$Int64Value);
    }

    public static CollectionsStruct$Int64Value parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$Int64Value parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$Int64Value parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$Int64Value parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$Int64Value parseFrom(byte[] bArr) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$Int64Value parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$Int64Value parseFrom(InputStream inputStream) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$Int64Value parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$Int64Value parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$Int64Value parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$Int64Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
