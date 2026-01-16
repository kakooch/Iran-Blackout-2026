package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportFieldValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportOuterClass$RequestValidateField extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$RequestValidateField DEFAULT_INSTANCE;
    public static final int LANGUAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue language_;
    private PassportStruct$PassportFieldValue value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((PassportOuterClass$RequestValidateField) this.b).setLanguage(stringValue);
            return this;
        }

        public a B(PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
            q();
            ((PassportOuterClass$RequestValidateField) this.b).setValue(passportStruct$PassportFieldValue);
            return this;
        }

        private a() {
            super(PassportOuterClass$RequestValidateField.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$RequestValidateField passportOuterClass$RequestValidateField = new PassportOuterClass$RequestValidateField();
        DEFAULT_INSTANCE = passportOuterClass$RequestValidateField;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$RequestValidateField.class, passportOuterClass$RequestValidateField);
    }

    private PassportOuterClass$RequestValidateField() {
    }

    private void clearLanguage() {
        this.language_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportOuterClass$RequestValidateField getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLanguage(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.language_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.language_ = stringValue;
        } else {
            this.language_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.language_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeValue(PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        PassportStruct$PassportFieldValue passportStruct$PassportFieldValue2 = this.value_;
        if (passportStruct$PassportFieldValue2 == null || passportStruct$PassportFieldValue2 == PassportStruct$PassportFieldValue.getDefaultInstance()) {
            this.value_ = passportStruct$PassportFieldValue;
        } else {
            this.value_ = (PassportStruct$PassportFieldValue) ((PassportStruct$PassportFieldValue.a) PassportStruct$PassportFieldValue.newBuilder(this.value_).v(passportStruct$PassportFieldValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$RequestValidateField parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguage(StringValue stringValue) {
        stringValue.getClass();
        this.language_ = stringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        this.value_ = passportStruct$PassportFieldValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$RequestValidateField();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "value_", "language_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$RequestValidateField.class) {
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

    public StringValue getLanguage() {
        StringValue stringValue = this.language_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public PassportStruct$PassportFieldValue getValue() {
        PassportStruct$PassportFieldValue passportStruct$PassportFieldValue = this.value_;
        return passportStruct$PassportFieldValue == null ? PassportStruct$PassportFieldValue.getDefaultInstance() : passportStruct$PassportFieldValue;
    }

    public boolean hasLanguage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportOuterClass$RequestValidateField passportOuterClass$RequestValidateField) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$RequestValidateField);
    }

    public static PassportOuterClass$RequestValidateField parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(byte[] bArr) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$RequestValidateField parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$RequestValidateField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
