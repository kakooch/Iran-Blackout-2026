package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportFieldDate;
import ai.bale.proto.PassportStruct$PassportFieldNumber;
import ai.bale.proto.PassportStruct$PassportFieldText;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportStruct$PassportField extends GeneratedMessageLite implements InterfaceC1839a1 {
    public static final int DATE_FIELD_NUMBER = 8;
    private static final PassportStruct$PassportField DEFAULT_INSTANCE;
    public static final int ERROR_MESSAGE_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PLACEHOLDER_FIELD_NUMBER = 3;
    public static final int TEXT_FIELD_NUMBER = 7;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int UNEDITABLE_FIELD_NUMBER = 9;
    public static final int VALIDATE_WITH_BACKEND_FIELD_NUMBER = 5;
    private int bitField0_;
    private StringValue errorMessage_;
    private int id_;
    private Object kind_;
    private boolean uneditable_;
    private boolean validateWithBackend_;
    private int kindCase_ = 0;
    private String title_ = "";
    private String placeholder_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1839a1 {
        private a() {
            super(PassportStruct$PassportField.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        NUMBER(6),
        TEXT(7),
        DATE(8),
        KIND_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return KIND_NOT_SET;
            }
            if (i == 6) {
                return NUMBER;
            }
            if (i == 7) {
                return TEXT;
            }
            if (i != 8) {
                return null;
            }
            return DATE;
        }
    }

    static {
        PassportStruct$PassportField passportStruct$PassportField = new PassportStruct$PassportField();
        DEFAULT_INSTANCE = passportStruct$PassportField;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportField.class, passportStruct$PassportField);
    }

    private PassportStruct$PassportField() {
    }

    private void clearDate() {
        if (this.kindCase_ == 8) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    private void clearErrorMessage() {
        this.errorMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearKind() {
        this.kindCase_ = 0;
        this.kind_ = null;
    }

    private void clearNumber() {
        if (this.kindCase_ == 6) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    private void clearPlaceholder() {
        this.placeholder_ = getDefaultInstance().getPlaceholder();
    }

    private void clearText() {
        if (this.kindCase_ == 7) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUneditable() {
        this.uneditable_ = false;
    }

    private void clearValidateWithBackend() {
        this.validateWithBackend_ = false;
    }

    public static PassportStruct$PassportField getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(PassportStruct$PassportFieldDate passportStruct$PassportFieldDate) {
        passportStruct$PassportFieldDate.getClass();
        if (this.kindCase_ != 8 || this.kind_ == PassportStruct$PassportFieldDate.getDefaultInstance()) {
            this.kind_ = passportStruct$PassportFieldDate;
        } else {
            this.kind_ = ((PassportStruct$PassportFieldDate.a) PassportStruct$PassportFieldDate.newBuilder((PassportStruct$PassportFieldDate) this.kind_).v(passportStruct$PassportFieldDate)).j();
        }
        this.kindCase_ = 8;
    }

    private void mergeErrorMessage(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.errorMessage_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.errorMessage_ = stringValue;
        } else {
            this.errorMessage_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.errorMessage_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeNumber(PassportStruct$PassportFieldNumber passportStruct$PassportFieldNumber) {
        passportStruct$PassportFieldNumber.getClass();
        if (this.kindCase_ != 6 || this.kind_ == PassportStruct$PassportFieldNumber.getDefaultInstance()) {
            this.kind_ = passportStruct$PassportFieldNumber;
        } else {
            this.kind_ = ((PassportStruct$PassportFieldNumber.a) PassportStruct$PassportFieldNumber.newBuilder((PassportStruct$PassportFieldNumber) this.kind_).v(passportStruct$PassportFieldNumber)).j();
        }
        this.kindCase_ = 6;
    }

    private void mergeText(PassportStruct$PassportFieldText passportStruct$PassportFieldText) {
        passportStruct$PassportFieldText.getClass();
        if (this.kindCase_ != 7 || this.kind_ == PassportStruct$PassportFieldText.getDefaultInstance()) {
            this.kind_ = passportStruct$PassportFieldText;
        } else {
            this.kind_ = ((PassportStruct$PassportFieldText.a) PassportStruct$PassportFieldText.newBuilder((PassportStruct$PassportFieldText) this.kind_).v(passportStruct$PassportFieldText)).j();
        }
        this.kindCase_ = 7;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportField parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportField parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(PassportStruct$PassportFieldDate passportStruct$PassportFieldDate) {
        passportStruct$PassportFieldDate.getClass();
        this.kind_ = passportStruct$PassportFieldDate;
        this.kindCase_ = 8;
    }

    private void setErrorMessage(StringValue stringValue) {
        stringValue.getClass();
        this.errorMessage_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setNumber(PassportStruct$PassportFieldNumber passportStruct$PassportFieldNumber) {
        passportStruct$PassportFieldNumber.getClass();
        this.kind_ = passportStruct$PassportFieldNumber;
        this.kindCase_ = 6;
    }

    private void setPlaceholder(String str) {
        str.getClass();
        this.placeholder_ = str;
    }

    private void setPlaceholderBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.placeholder_ = abstractC2383g.f0();
    }

    private void setText(PassportStruct$PassportFieldText passportStruct$PassportFieldText) {
        passportStruct$PassportFieldText.getClass();
        this.kind_ = passportStruct$PassportFieldText;
        this.kindCase_ = 7;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setUneditable(boolean z) {
        this.uneditable_ = z;
    }

    private void setValidateWithBackend(boolean z) {
        this.validateWithBackend_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportField();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0001\u0001\t\t\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000\u0005\u0007\u0006<\u0000\u0007<\u0000\b<\u0000\t\u0007", new Object[]{"kind_", "kindCase_", "bitField0_", "id_", "title_", "placeholder_", "errorMessage_", "validateWithBackend_", PassportStruct$PassportFieldNumber.class, PassportStruct$PassportFieldText.class, PassportStruct$PassportFieldDate.class, "uneditable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportField.class) {
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

    public PassportStruct$PassportFieldDate getDate() {
        return this.kindCase_ == 8 ? (PassportStruct$PassportFieldDate) this.kind_ : PassportStruct$PassportFieldDate.getDefaultInstance();
    }

    public StringValue getErrorMessage() {
        StringValue stringValue = this.errorMessage_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getId() {
        return this.id_;
    }

    public b getKindCase() {
        return b.j(this.kindCase_);
    }

    public PassportStruct$PassportFieldNumber getNumber() {
        return this.kindCase_ == 6 ? (PassportStruct$PassportFieldNumber) this.kind_ : PassportStruct$PassportFieldNumber.getDefaultInstance();
    }

    public String getPlaceholder() {
        return this.placeholder_;
    }

    public AbstractC2383g getPlaceholderBytes() {
        return AbstractC2383g.N(this.placeholder_);
    }

    public PassportStruct$PassportFieldText getText() {
        return this.kindCase_ == 7 ? (PassportStruct$PassportFieldText) this.kind_ : PassportStruct$PassportFieldText.getDefaultInstance();
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean getUneditable() {
        return this.uneditable_;
    }

    public boolean getValidateWithBackend() {
        return this.validateWithBackend_;
    }

    public boolean hasDate() {
        return this.kindCase_ == 8;
    }

    public boolean hasErrorMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNumber() {
        return this.kindCase_ == 6;
    }

    public boolean hasText() {
        return this.kindCase_ == 7;
    }

    public static a newBuilder(PassportStruct$PassportField passportStruct$PassportField) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportField);
    }

    public static PassportStruct$PassportField parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportField parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportField parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportStruct$PassportField parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportField parseFrom(byte[] bArr) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportField parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportField parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportField parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportField parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportField parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
