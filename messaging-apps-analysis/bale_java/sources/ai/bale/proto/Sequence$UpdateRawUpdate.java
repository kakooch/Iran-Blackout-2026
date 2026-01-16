package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Sequence$UpdateRawUpdate extends GeneratedMessageLite implements U64 {
    public static final int BYTES_FIELD_NUMBER = 2;
    private static final Sequence$UpdateRawUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private AbstractC2383g bytes_ = AbstractC2383g.b;
    private StringValue type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Sequence$UpdateRawUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        Sequence$UpdateRawUpdate sequence$UpdateRawUpdate = new Sequence$UpdateRawUpdate();
        DEFAULT_INSTANCE = sequence$UpdateRawUpdate;
        GeneratedMessageLite.registerDefaultInstance(Sequence$UpdateRawUpdate.class, sequence$UpdateRawUpdate);
    }

    private Sequence$UpdateRawUpdate() {
    }

    private void clearBytes() {
        this.bytes_ = getDefaultInstance().getBytes();
    }

    private void clearType() {
        this.type_ = null;
        this.bitField0_ &= -2;
    }

    public static Sequence$UpdateRawUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeType(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.type_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.type_ = stringValue;
        } else {
            this.type_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.type_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sequence$UpdateRawUpdate parseDelimitedFrom(InputStream inputStream) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$UpdateRawUpdate parseFrom(ByteBuffer byteBuffer) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBytes(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.bytes_ = abstractC2383g;
    }

    private void setType(StringValue stringValue) {
        stringValue.getClass();
        this.type_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S1.a[gVar.ordinal()]) {
            case 1:
                return new Sequence$UpdateRawUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\n", new Object[]{"bitField0_", "type_", "bytes_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sequence$UpdateRawUpdate.class) {
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

    public AbstractC2383g getBytes() {
        return this.bytes_;
    }

    public StringValue getType() {
        StringValue stringValue = this.type_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Sequence$UpdateRawUpdate sequence$UpdateRawUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequence$UpdateRawUpdate);
    }

    public static Sequence$UpdateRawUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$UpdateRawUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Sequence$UpdateRawUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Sequence$UpdateRawUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Sequence$UpdateRawUpdate parseFrom(byte[] bArr) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sequence$UpdateRawUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Sequence$UpdateRawUpdate parseFrom(InputStream inputStream) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$UpdateRawUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$UpdateRawUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Sequence$UpdateRawUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Sequence$UpdateRawUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
