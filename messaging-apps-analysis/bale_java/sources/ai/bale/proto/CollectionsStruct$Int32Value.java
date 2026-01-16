package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18947pX0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CollectionsStruct$Int32Value extends GeneratedMessageLite implements InterfaceC18947pX0 {
    private static final CollectionsStruct$Int32Value DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC18947pX0 {
        public a A(int i) {
            q();
            ((CollectionsStruct$Int32Value) this.b).setValue(i);
            return this;
        }

        private a() {
            super(CollectionsStruct$Int32Value.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = new CollectionsStruct$Int32Value();
        DEFAULT_INSTANCE = collectionsStruct$Int32Value;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$Int32Value.class, collectionsStruct$Int32Value);
    }

    private CollectionsStruct$Int32Value() {
    }

    private void clearValue() {
        this.value_ = 0;
    }

    public static CollectionsStruct$Int32Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$Int32Value parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$Int32Value parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i) {
        this.value_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$Int32Value();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$Int32Value.class) {
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

    public int getValue() {
        return this.value_;
    }

    public static a newBuilder(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$Int32Value);
    }

    public static CollectionsStruct$Int32Value parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$Int32Value parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$Int32Value parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$Int32Value parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$Int32Value parseFrom(byte[] bArr) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$Int32Value parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$Int32Value parseFrom(InputStream inputStream) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$Int32Value parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$Int32Value parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$Int32Value parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
