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
public final class CollectionsStruct$DoubleValue extends GeneratedMessageLite implements U64 {
    private static final CollectionsStruct$DoubleValue DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private double value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CollectionsStruct$DoubleValue.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$DoubleValue collectionsStruct$DoubleValue = new CollectionsStruct$DoubleValue();
        DEFAULT_INSTANCE = collectionsStruct$DoubleValue;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$DoubleValue.class, collectionsStruct$DoubleValue);
    }

    private CollectionsStruct$DoubleValue() {
    }

    private void clearValue() {
        this.value_ = 0.0d;
    }

    public static CollectionsStruct$DoubleValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$DoubleValue parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$DoubleValue parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(double d) {
        this.value_ = d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$DoubleValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$DoubleValue.class) {
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

    public double getValue() {
        return this.value_;
    }

    public static a newBuilder(CollectionsStruct$DoubleValue collectionsStruct$DoubleValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$DoubleValue);
    }

    public static CollectionsStruct$DoubleValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$DoubleValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$DoubleValue parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$DoubleValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$DoubleValue parseFrom(byte[] bArr) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$DoubleValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$DoubleValue parseFrom(InputStream inputStream) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$DoubleValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$DoubleValue parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$DoubleValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$DoubleValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
