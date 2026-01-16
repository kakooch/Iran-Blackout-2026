package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportForm;
import com.google.protobuf.AbstractC2377a;
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
public final class PassportOuterClass$ResponseLoadFormLink extends GeneratedMessageLite implements U64 {
    public static final int CANCEL_CALLBACK_URL_FIELD_NUMBER = 5;
    private static final PassportOuterClass$ResponseLoadFormLink DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int FORM_FIELD_NUMBER = 2;
    public static final int LINK_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SUCCESS_CALLBACK_URL_FIELD_NUMBER = 4;
    private int bitField0_;
    private StringValue cancelCallbackUrl_;
    private PassportStruct$PassportForm form_;
    private StringValue successCallbackUrl_;
    private String linkId_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportOuterClass$ResponseLoadFormLink.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$ResponseLoadFormLink passportOuterClass$ResponseLoadFormLink = new PassportOuterClass$ResponseLoadFormLink();
        DEFAULT_INSTANCE = passportOuterClass$ResponseLoadFormLink;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$ResponseLoadFormLink.class, passportOuterClass$ResponseLoadFormLink);
    }

    private PassportOuterClass$ResponseLoadFormLink() {
    }

    private void clearCancelCallbackUrl() {
        this.cancelCallbackUrl_ = null;
        this.bitField0_ &= -5;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearForm() {
        this.form_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLinkId() {
        this.linkId_ = getDefaultInstance().getLinkId();
    }

    private void clearSuccessCallbackUrl() {
        this.successCallbackUrl_ = null;
        this.bitField0_ &= -3;
    }

    public static PassportOuterClass$ResponseLoadFormLink getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCancelCallbackUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.cancelCallbackUrl_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.cancelCallbackUrl_ = stringValue;
        } else {
            this.cancelCallbackUrl_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.cancelCallbackUrl_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeForm(PassportStruct$PassportForm passportStruct$PassportForm) {
        passportStruct$PassportForm.getClass();
        PassportStruct$PassportForm passportStruct$PassportForm2 = this.form_;
        if (passportStruct$PassportForm2 == null || passportStruct$PassportForm2 == PassportStruct$PassportForm.getDefaultInstance()) {
            this.form_ = passportStruct$PassportForm;
        } else {
            this.form_ = (PassportStruct$PassportForm) ((PassportStruct$PassportForm.a) PassportStruct$PassportForm.newBuilder(this.form_).v(passportStruct$PassportForm)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeSuccessCallbackUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.successCallbackUrl_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.successCallbackUrl_ = stringValue;
        } else {
            this.successCallbackUrl_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.successCallbackUrl_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$ResponseLoadFormLink parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCancelCallbackUrl(StringValue stringValue) {
        stringValue.getClass();
        this.cancelCallbackUrl_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setForm(PassportStruct$PassportForm passportStruct$PassportForm) {
        passportStruct$PassportForm.getClass();
        this.form_ = passportStruct$PassportForm;
        this.bitField0_ |= 1;
    }

    private void setLinkId(String str) {
        str.getClass();
        this.linkId_ = str;
    }

    private void setLinkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.linkId_ = abstractC2383g.f0();
    }

    private void setSuccessCallbackUrl(StringValue stringValue) {
        stringValue.getClass();
        this.successCallbackUrl_ = stringValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$ResponseLoadFormLink();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003Ȉ\u0004ဉ\u0001\u0005ဉ\u0002", new Object[]{"bitField0_", "linkId_", "form_", "description_", "successCallbackUrl_", "cancelCallbackUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$ResponseLoadFormLink.class) {
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

    public StringValue getCancelCallbackUrl() {
        StringValue stringValue = this.cancelCallbackUrl_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public PassportStruct$PassportForm getForm() {
        PassportStruct$PassportForm passportStruct$PassportForm = this.form_;
        return passportStruct$PassportForm == null ? PassportStruct$PassportForm.getDefaultInstance() : passportStruct$PassportForm;
    }

    public String getLinkId() {
        return this.linkId_;
    }

    public AbstractC2383g getLinkIdBytes() {
        return AbstractC2383g.N(this.linkId_);
    }

    public StringValue getSuccessCallbackUrl() {
        StringValue stringValue = this.successCallbackUrl_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasCancelCallbackUrl() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasForm() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSuccessCallbackUrl() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(PassportOuterClass$ResponseLoadFormLink passportOuterClass$ResponseLoadFormLink) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$ResponseLoadFormLink);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(byte[] bArr) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$ResponseLoadFormLink parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$ResponseLoadFormLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
