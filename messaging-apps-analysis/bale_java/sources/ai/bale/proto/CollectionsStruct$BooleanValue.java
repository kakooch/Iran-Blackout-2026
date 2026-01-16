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
public final class CollectionsStruct$BooleanValue extends GeneratedMessageLite implements U64 {
    private static final CollectionsStruct$BooleanValue DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private boolean value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((CollectionsStruct$BooleanValue) this.b).setValue(z);
            return this;
        }

        private a() {
            super(CollectionsStruct$BooleanValue.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = new CollectionsStruct$BooleanValue();
        DEFAULT_INSTANCE = collectionsStruct$BooleanValue;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$BooleanValue.class, collectionsStruct$BooleanValue);
    }

    private CollectionsStruct$BooleanValue() {
    }

    private void clearValue() {
        this.value_ = false;
    }

    public static CollectionsStruct$BooleanValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$BooleanValue parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$BooleanValue parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(boolean z) {
        this.value_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$BooleanValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$BooleanValue.class) {
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

    public boolean getValue() {
        return this.value_;
    }

    public static a newBuilder(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$BooleanValue);
    }

    public static CollectionsStruct$BooleanValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$BooleanValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$BooleanValue parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$BooleanValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$BooleanValue parseFrom(byte[] bArr) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$BooleanValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$BooleanValue parseFrom(InputStream inputStream) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$BooleanValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$BooleanValue parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$BooleanValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$BooleanValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
