package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportField;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportOuterClass$ResponseValidateField extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$ResponseValidateField DEFAULT_INSTANCE;
    public static final int FIELD_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PassportStruct$PassportField field_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportOuterClass$ResponseValidateField.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$ResponseValidateField passportOuterClass$ResponseValidateField = new PassportOuterClass$ResponseValidateField();
        DEFAULT_INSTANCE = passportOuterClass$ResponseValidateField;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$ResponseValidateField.class, passportOuterClass$ResponseValidateField);
    }

    private PassportOuterClass$ResponseValidateField() {
    }

    private void clearField() {
        this.field_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportOuterClass$ResponseValidateField getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeField(PassportStruct$PassportField passportStruct$PassportField) {
        passportStruct$PassportField.getClass();
        PassportStruct$PassportField passportStruct$PassportField2 = this.field_;
        if (passportStruct$PassportField2 == null || passportStruct$PassportField2 == PassportStruct$PassportField.getDefaultInstance()) {
            this.field_ = passportStruct$PassportField;
        } else {
            this.field_ = (PassportStruct$PassportField) ((PassportStruct$PassportField.a) PassportStruct$PassportField.newBuilder(this.field_).v(passportStruct$PassportField)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$ResponseValidateField parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setField(PassportStruct$PassportField passportStruct$PassportField) {
        passportStruct$PassportField.getClass();
        this.field_ = passportStruct$PassportField;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$ResponseValidateField();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$ResponseValidateField.class) {
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

    public PassportStruct$PassportField getField() {
        PassportStruct$PassportField passportStruct$PassportField = this.field_;
        return passportStruct$PassportField == null ? PassportStruct$PassportField.getDefaultInstance() : passportStruct$PassportField;
    }

    public boolean hasField() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportOuterClass$ResponseValidateField passportOuterClass$ResponseValidateField) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$ResponseValidateField);
    }

    public static PassportOuterClass$ResponseValidateField parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(byte[] bArr) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$ResponseValidateField parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$ResponseValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
