package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportRegexValidation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC13308g05;
import ir.nasim.EnumC13899h05;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportStruct$PassportFieldText extends GeneratedMessageLite implements U64 {
    public static final int BUILT_IN_VALIDATION_FIELD_NUMBER = 5;
    public static final int CUSTOM_REGEX_FIELD_NUMBER = 6;
    private static final PassportStruct$PassportFieldText DEFAULT_INSTANCE;
    public static final int INPUT_MODE_FIELD_NUMBER = 2;
    public static final int MAX_LENGTH_FIELD_NUMBER = 4;
    public static final int MIN_LENGTH_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private int inputMode_;
    private Int32Value maxLength_;
    private Int32Value minLength_;
    private int validationRuleCase_ = 0;
    private Object validationRule_;
    private StringValue value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportStruct$PassportFieldText.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        BUILT_IN_VALIDATION(5),
        CUSTOM_REGEX(6),
        VALIDATIONRULE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return VALIDATIONRULE_NOT_SET;
            }
            if (i == 5) {
                return BUILT_IN_VALIDATION;
            }
            if (i != 6) {
                return null;
            }
            return CUSTOM_REGEX;
        }
    }

    static {
        PassportStruct$PassportFieldText passportStruct$PassportFieldText = new PassportStruct$PassportFieldText();
        DEFAULT_INSTANCE = passportStruct$PassportFieldText;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportFieldText.class, passportStruct$PassportFieldText);
    }

    private PassportStruct$PassportFieldText() {
    }

    private void clearBuiltInValidation() {
        if (this.validationRuleCase_ == 5) {
            this.validationRuleCase_ = 0;
            this.validationRule_ = null;
        }
    }

    private void clearCustomRegex() {
        if (this.validationRuleCase_ == 6) {
            this.validationRuleCase_ = 0;
            this.validationRule_ = null;
        }
    }

    private void clearInputMode() {
        this.inputMode_ = 0;
    }

    private void clearMaxLength() {
        this.maxLength_ = null;
        this.bitField0_ &= -5;
    }

    private void clearMinLength() {
        this.minLength_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValidationRule() {
        this.validationRuleCase_ = 0;
        this.validationRule_ = null;
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportStruct$PassportFieldText getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCustomRegex(PassportStruct$PassportRegexValidation passportStruct$PassportRegexValidation) {
        passportStruct$PassportRegexValidation.getClass();
        if (this.validationRuleCase_ != 6 || this.validationRule_ == PassportStruct$PassportRegexValidation.getDefaultInstance()) {
            this.validationRule_ = passportStruct$PassportRegexValidation;
        } else {
            this.validationRule_ = ((PassportStruct$PassportRegexValidation.a) PassportStruct$PassportRegexValidation.newBuilder((PassportStruct$PassportRegexValidation) this.validationRule_).v(passportStruct$PassportRegexValidation)).j();
        }
        this.validationRuleCase_ = 6;
    }

    private void mergeMaxLength(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.maxLength_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.maxLength_ = int32Value;
        } else {
            this.maxLength_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.maxLength_).v(int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeMinLength(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.minLength_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.minLength_ = int32Value;
        } else {
            this.minLength_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.minLength_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeValue(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.value_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.value_ = stringValue;
        } else {
            this.value_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.value_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportFieldText parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldText parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBuiltInValidation(EnumC13899h05 enumC13899h05) {
        this.validationRule_ = Integer.valueOf(enumC13899h05.getNumber());
        this.validationRuleCase_ = 5;
    }

    private void setBuiltInValidationValue(int i) {
        this.validationRuleCase_ = 5;
        this.validationRule_ = Integer.valueOf(i);
    }

    private void setCustomRegex(PassportStruct$PassportRegexValidation passportStruct$PassportRegexValidation) {
        passportStruct$PassportRegexValidation.getClass();
        this.validationRule_ = passportStruct$PassportRegexValidation;
        this.validationRuleCase_ = 6;
    }

    private void setInputMode(EnumC13308g05 enumC13308g05) {
        this.inputMode_ = enumC13308g05.getNumber();
    }

    private void setInputModeValue(int i) {
        this.inputMode_ = i;
    }

    private void setMaxLength(Int32Value int32Value) {
        int32Value.getClass();
        this.maxLength_ = int32Value;
        this.bitField0_ |= 4;
    }

    private void setMinLength(Int32Value int32Value) {
        int32Value.getClass();
        this.minLength_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setValue(StringValue stringValue) {
        stringValue.getClass();
        this.value_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportFieldText();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003ဉ\u0001\u0004ဉ\u0002\u0005?\u0000\u0006<\u0000", new Object[]{"validationRule_", "validationRuleCase_", "bitField0_", "value_", "inputMode_", "minLength_", "maxLength_", PassportStruct$PassportRegexValidation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportFieldText.class) {
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

    public EnumC13899h05 getBuiltInValidation() {
        if (this.validationRuleCase_ != 5) {
            return EnumC13899h05.NONE;
        }
        EnumC13899h05 enumC13899h05J = EnumC13899h05.j(((Integer) this.validationRule_).intValue());
        return enumC13899h05J == null ? EnumC13899h05.UNRECOGNIZED : enumC13899h05J;
    }

    public int getBuiltInValidationValue() {
        if (this.validationRuleCase_ == 5) {
            return ((Integer) this.validationRule_).intValue();
        }
        return 0;
    }

    public PassportStruct$PassportRegexValidation getCustomRegex() {
        return this.validationRuleCase_ == 6 ? (PassportStruct$PassportRegexValidation) this.validationRule_ : PassportStruct$PassportRegexValidation.getDefaultInstance();
    }

    public EnumC13308g05 getInputMode() {
        EnumC13308g05 enumC13308g05J = EnumC13308g05.j(this.inputMode_);
        return enumC13308g05J == null ? EnumC13308g05.UNRECOGNIZED : enumC13308g05J;
    }

    public int getInputModeValue() {
        return this.inputMode_;
    }

    public Int32Value getMaxLength() {
        Int32Value int32Value = this.maxLength_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public Int32Value getMinLength() {
        Int32Value int32Value = this.minLength_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public b getValidationRuleCase() {
        return b.j(this.validationRuleCase_);
    }

    public StringValue getValue() {
        StringValue stringValue = this.value_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasBuiltInValidation() {
        return this.validationRuleCase_ == 5;
    }

    public boolean hasCustomRegex() {
        return this.validationRuleCase_ == 6;
    }

    public boolean hasMaxLength() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMinLength() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportStruct$PassportFieldText passportStruct$PassportFieldText) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportFieldText);
    }

    public static PassportStruct$PassportFieldText parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldText parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportFieldText parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportStruct$PassportFieldText parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportFieldText parseFrom(byte[] bArr) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportFieldText parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportFieldText parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldText parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldText parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportFieldText parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportFieldText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
