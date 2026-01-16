package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportDate;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportStruct$PassportFieldValue extends GeneratedMessageLite implements InterfaceC1842b1 {
    public static final int DATE_FIELD_NUMBER = 4;
    private static final PassportStruct$PassportFieldValue DEFAULT_INSTANCE;
    public static final int FIELD_ID_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 3;
    private int fieldId_;
    private int valueCase_ = 0;
    private Object value_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1842b1 {
        public a A(PassportStruct$PassportDate passportStruct$PassportDate) {
            q();
            ((PassportStruct$PassportFieldValue) this.b).setDate(passportStruct$PassportDate);
            return this;
        }

        public a B(int i) {
            q();
            ((PassportStruct$PassportFieldValue) this.b).setFieldId(i);
            return this;
        }

        public a C(Int32Value int32Value) {
            q();
            ((PassportStruct$PassportFieldValue) this.b).setNumber(int32Value);
            return this;
        }

        public a D(StringValue stringValue) {
            q();
            ((PassportStruct$PassportFieldValue) this.b).setText(stringValue);
            return this;
        }

        private a() {
            super(PassportStruct$PassportFieldValue.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        NUMBER(2),
        TEXT(3),
        DATE(4),
        VALUE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return VALUE_NOT_SET;
            }
            if (i == 2) {
                return NUMBER;
            }
            if (i == 3) {
                return TEXT;
            }
            if (i != 4) {
                return null;
            }
            return DATE;
        }
    }

    static {
        PassportStruct$PassportFieldValue passportStruct$PassportFieldValue = new PassportStruct$PassportFieldValue();
        DEFAULT_INSTANCE = passportStruct$PassportFieldValue;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportFieldValue.class, passportStruct$PassportFieldValue);
    }

    private PassportStruct$PassportFieldValue() {
    }

    private void clearDate() {
        if (this.valueCase_ == 4) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearFieldId() {
        this.fieldId_ = 0;
    }

    private void clearNumber() {
        if (this.valueCase_ == 2) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearText() {
        if (this.valueCase_ == 3) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearValue() {
        this.valueCase_ = 0;
        this.value_ = null;
    }

    public static PassportStruct$PassportFieldValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(PassportStruct$PassportDate passportStruct$PassportDate) {
        passportStruct$PassportDate.getClass();
        if (this.valueCase_ != 4 || this.value_ == PassportStruct$PassportDate.getDefaultInstance()) {
            this.value_ = passportStruct$PassportDate;
        } else {
            this.value_ = ((PassportStruct$PassportDate.a) PassportStruct$PassportDate.newBuilder((PassportStruct$PassportDate) this.value_).v(passportStruct$PassportDate)).j();
        }
        this.valueCase_ = 4;
    }

    private void mergeNumber(Int32Value int32Value) {
        int32Value.getClass();
        if (this.valueCase_ != 2 || this.value_ == Int32Value.getDefaultInstance()) {
            this.value_ = int32Value;
        } else {
            this.value_ = ((Int32Value.b) Int32Value.newBuilder((Int32Value) this.value_).v(int32Value)).j();
        }
        this.valueCase_ = 2;
    }

    private void mergeText(StringValue stringValue) {
        stringValue.getClass();
        if (this.valueCase_ != 3 || this.value_ == StringValue.getDefaultInstance()) {
            this.value_ = stringValue;
        } else {
            this.value_ = ((StringValue.b) StringValue.newBuilder((StringValue) this.value_).v(stringValue)).j();
        }
        this.valueCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportFieldValue parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldValue parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(PassportStruct$PassportDate passportStruct$PassportDate) {
        passportStruct$PassportDate.getClass();
        this.value_ = passportStruct$PassportDate;
        this.valueCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFieldId(int i) {
        this.fieldId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumber(Int32Value int32Value) {
        int32Value.getClass();
        this.value_ = int32Value;
        this.valueCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(StringValue stringValue) {
        stringValue.getClass();
        this.value_ = stringValue;
        this.valueCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportFieldValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"value_", "valueCase_", "fieldId_", Int32Value.class, StringValue.class, PassportStruct$PassportDate.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportFieldValue.class) {
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

    public PassportStruct$PassportDate getDate() {
        return this.valueCase_ == 4 ? (PassportStruct$PassportDate) this.value_ : PassportStruct$PassportDate.getDefaultInstance();
    }

    public int getFieldId() {
        return this.fieldId_;
    }

    public Int32Value getNumber() {
        return this.valueCase_ == 2 ? (Int32Value) this.value_ : Int32Value.getDefaultInstance();
    }

    public StringValue getText() {
        return this.valueCase_ == 3 ? (StringValue) this.value_ : StringValue.getDefaultInstance();
    }

    public b getValueCase() {
        return b.j(this.valueCase_);
    }

    public boolean hasDate() {
        return this.valueCase_ == 4;
    }

    public boolean hasNumber() {
        return this.valueCase_ == 2;
    }

    public boolean hasText() {
        return this.valueCase_ == 3;
    }

    public static a newBuilder(PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportFieldValue);
    }

    public static PassportStruct$PassportFieldValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportFieldValue parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportStruct$PassportFieldValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportFieldValue parseFrom(byte[] bArr) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportFieldValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportFieldValue parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldValue parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportFieldValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportFieldValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
