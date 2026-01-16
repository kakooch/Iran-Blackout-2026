package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportStruct$PassportFieldNumber extends GeneratedMessageLite implements U64 {
    private static final PassportStruct$PassportFieldNumber DEFAULT_INSTANCE;
    public static final int MAX_VALUE_FIELD_NUMBER = 3;
    public static final int MIN_VALUE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Int32Value maxValue_;
    private Int32Value minValue_;
    private Int32Value value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportStruct$PassportFieldNumber.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportStruct$PassportFieldNumber passportStruct$PassportFieldNumber = new PassportStruct$PassportFieldNumber();
        DEFAULT_INSTANCE = passportStruct$PassportFieldNumber;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportFieldNumber.class, passportStruct$PassportFieldNumber);
    }

    private PassportStruct$PassportFieldNumber() {
    }

    private void clearMaxValue() {
        this.maxValue_ = null;
        this.bitField0_ &= -5;
    }

    private void clearMinValue() {
        this.minValue_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportStruct$PassportFieldNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMaxValue(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.maxValue_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.maxValue_ = int32Value;
        } else {
            this.maxValue_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.maxValue_).v(int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeMinValue(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.minValue_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.minValue_ = int32Value;
        } else {
            this.minValue_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.minValue_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeValue(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.value_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.value_ = int32Value;
        } else {
            this.value_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.value_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportFieldNumber parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMaxValue(Int32Value int32Value) {
        int32Value.getClass();
        this.maxValue_ = int32Value;
        this.bitField0_ |= 4;
    }

    private void setMinValue(Int32Value int32Value) {
        int32Value.getClass();
        this.minValue_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setValue(Int32Value int32Value) {
        int32Value.getClass();
        this.value_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportFieldNumber();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "value_", "minValue_", "maxValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportFieldNumber.class) {
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

    public Int32Value getMaxValue() {
        Int32Value int32Value = this.maxValue_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public Int32Value getMinValue() {
        Int32Value int32Value = this.minValue_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public Int32Value getValue() {
        Int32Value int32Value = this.value_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasMaxValue() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMinValue() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportStruct$PassportFieldNumber passportStruct$PassportFieldNumber) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportFieldNumber);
    }

    public static PassportStruct$PassportFieldNumber parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(byte[] bArr) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportFieldNumber parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportFieldNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
