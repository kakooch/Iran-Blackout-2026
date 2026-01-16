package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$ArrayValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CollectionsStruct$RawValue extends GeneratedMessageLite implements E {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 6;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 2;
    private static final CollectionsStruct$RawValue DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 5;
    public static final int INT32_VALUE_FIELD_NUMBER = 3;
    public static final int INT64_VALUE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements E {
        public a A(CollectionsStruct$ArrayValue collectionsStruct$ArrayValue) {
            q();
            ((CollectionsStruct$RawValue) this.b).setArrayValue(collectionsStruct$ArrayValue);
            return this;
        }

        public a B(boolean z) {
            q();
            ((CollectionsStruct$RawValue) this.b).setBooleanValue(z);
            return this;
        }

        public a C(int i) {
            q();
            ((CollectionsStruct$RawValue) this.b).setInt32Value(i);
            return this;
        }

        public a D(long j) {
            q();
            ((CollectionsStruct$RawValue) this.b).setInt64Value(j);
            return this;
        }

        public a E(String str) {
            q();
            ((CollectionsStruct$RawValue) this.b).setStringValue(str);
            return this;
        }

        private a() {
            super(CollectionsStruct$RawValue.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        STRING_VALUE(1),
        BOOLEAN_VALUE(2),
        INT32_VALUE(3),
        INT64_VALUE(4),
        DOUBLE_VALUE(5),
        ARRAY_VALUE(6),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i2) {
            this.a = i2;
        }

        public static b j(int i2) {
            switch (i2) {
                case 0:
                    return TRAIT_NOT_SET;
                case 1:
                    return STRING_VALUE;
                case 2:
                    return BOOLEAN_VALUE;
                case 3:
                    return INT32_VALUE;
                case 4:
                    return INT64_VALUE;
                case 5:
                    return DOUBLE_VALUE;
                case 6:
                    return ARRAY_VALUE;
                default:
                    return null;
            }
        }
    }

    static {
        CollectionsStruct$RawValue collectionsStruct$RawValue = new CollectionsStruct$RawValue();
        DEFAULT_INSTANCE = collectionsStruct$RawValue;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$RawValue.class, collectionsStruct$RawValue);
    }

    private CollectionsStruct$RawValue() {
    }

    private void clearArrayValue() {
        if (this.traitCase_ == 6) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBooleanValue() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDoubleValue() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearInt32Value() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearInt64Value() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStringValue() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static CollectionsStruct$RawValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeArrayValue(CollectionsStruct$ArrayValue collectionsStruct$ArrayValue) {
        collectionsStruct$ArrayValue.getClass();
        if (this.traitCase_ != 6 || this.trait_ == CollectionsStruct$ArrayValue.getDefaultInstance()) {
            this.trait_ = collectionsStruct$ArrayValue;
        } else {
            this.trait_ = ((CollectionsStruct$ArrayValue.a) CollectionsStruct$ArrayValue.newBuilder((CollectionsStruct$ArrayValue) this.trait_).v(collectionsStruct$ArrayValue)).j();
        }
        this.traitCase_ = 6;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$RawValue parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$RawValue parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArrayValue(CollectionsStruct$ArrayValue collectionsStruct$ArrayValue) {
        collectionsStruct$ArrayValue.getClass();
        this.trait_ = collectionsStruct$ArrayValue;
        this.traitCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBooleanValue(boolean z) {
        this.traitCase_ = 2;
        this.trait_ = Boolean.valueOf(z);
    }

    private void setDoubleValue(double d) {
        this.traitCase_ = 5;
        this.trait_ = Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInt32Value(int i) {
        this.traitCase_ = 3;
        this.trait_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInt64Value(long j) {
        this.traitCase_ = 4;
        this.trait_ = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStringValue(String str) {
        str.getClass();
        this.traitCase_ = 1;
        this.trait_ = str;
    }

    private void setStringValueBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trait_ = abstractC2383g.f0();
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$RawValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȼ\u0000\u0002:\u0000\u00037\u0000\u00045\u0000\u00053\u0000\u0006<\u0000", new Object[]{"trait_", "traitCase_", CollectionsStruct$ArrayValue.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$RawValue.class) {
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

    public CollectionsStruct$ArrayValue getArrayValue() {
        return this.traitCase_ == 6 ? (CollectionsStruct$ArrayValue) this.trait_ : CollectionsStruct$ArrayValue.getDefaultInstance();
    }

    public boolean getBooleanValue() {
        if (this.traitCase_ == 2) {
            return ((Boolean) this.trait_).booleanValue();
        }
        return false;
    }

    public double getDoubleValue() {
        if (this.traitCase_ == 5) {
            return ((Double) this.trait_).doubleValue();
        }
        return 0.0d;
    }

    public int getInt32Value() {
        if (this.traitCase_ == 3) {
            return ((Integer) this.trait_).intValue();
        }
        return 0;
    }

    public long getInt64Value() {
        if (this.traitCase_ == 4) {
            return ((Long) this.trait_).longValue();
        }
        return 0L;
    }

    public String getStringValue() {
        return this.traitCase_ == 1 ? (String) this.trait_ : "";
    }

    public AbstractC2383g getStringValueBytes() {
        return AbstractC2383g.N(this.traitCase_ == 1 ? (String) this.trait_ : "");
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasArrayValue() {
        return this.traitCase_ == 6;
    }

    public boolean hasBooleanValue() {
        return this.traitCase_ == 2;
    }

    public boolean hasDoubleValue() {
        return this.traitCase_ == 5;
    }

    public boolean hasInt32Value() {
        return this.traitCase_ == 3;
    }

    public boolean hasInt64Value() {
        return this.traitCase_ == 4;
    }

    public boolean hasStringValue() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(CollectionsStruct$RawValue collectionsStruct$RawValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$RawValue);
    }

    public static CollectionsStruct$RawValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$RawValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$RawValue parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$RawValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$RawValue parseFrom(byte[] bArr) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$RawValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$RawValue parseFrom(InputStream inputStream) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$RawValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$RawValue parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$RawValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$RawValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
