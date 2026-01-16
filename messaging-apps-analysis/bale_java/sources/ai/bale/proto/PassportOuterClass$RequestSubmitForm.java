package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PassportOuterClass$RequestSubmitForm extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$RequestSubmitForm DEFAULT_INSTANCE;
    public static final int LANGUAGE_FIELD_NUMBER = 3;
    public static final int LINK_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 2;
    private int bitField0_;
    private StringValue language_;
    private String linkId_ = "";
    private B.j values_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
            q();
            ((PassportOuterClass$RequestSubmitForm) this.b).addValues(passportStruct$PassportFieldValue);
            return this;
        }

        public a B(String str) {
            q();
            ((PassportOuterClass$RequestSubmitForm) this.b).setLinkId(str);
            return this;
        }

        private a() {
            super(PassportOuterClass$RequestSubmitForm.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$RequestSubmitForm passportOuterClass$RequestSubmitForm = new PassportOuterClass$RequestSubmitForm();
        DEFAULT_INSTANCE = passportOuterClass$RequestSubmitForm;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$RequestSubmitForm.class, passportOuterClass$RequestSubmitForm);
    }

    private PassportOuterClass$RequestSubmitForm() {
    }

    private void addAllValues(Iterable<? extends PassportStruct$PassportFieldValue> iterable) {
        ensureValuesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.values_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValues(PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        ensureValuesIsMutable();
        this.values_.add(passportStruct$PassportFieldValue);
    }

    private void clearLanguage() {
        this.language_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLinkId() {
        this.linkId_ = getDefaultInstance().getLinkId();
    }

    private void clearValues() {
        this.values_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureValuesIsMutable() {
        B.j jVar = this.values_;
        if (jVar.u()) {
            return;
        }
        this.values_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PassportOuterClass$RequestSubmitForm getDefaultInstance() {
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
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$RequestSubmitForm parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeValues(int i) {
        ensureValuesIsMutable();
        this.values_.remove(i);
    }

    private void setLanguage(StringValue stringValue) {
        stringValue.getClass();
        this.language_ = stringValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLinkId(String str) {
        str.getClass();
        this.linkId_ = str;
    }

    private void setLinkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.linkId_ = abstractC2383g.f0();
    }

    private void setValues(int i, PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        ensureValuesIsMutable();
        this.values_.set(i, passportStruct$PassportFieldValue);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$RequestSubmitForm();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003ဉ\u0000", new Object[]{"bitField0_", "linkId_", "values_", PassportStruct$PassportFieldValue.class, "language_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$RequestSubmitForm.class) {
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

    public String getLinkId() {
        return this.linkId_;
    }

    public AbstractC2383g getLinkIdBytes() {
        return AbstractC2383g.N(this.linkId_);
    }

    public PassportStruct$PassportFieldValue getValues(int i) {
        return (PassportStruct$PassportFieldValue) this.values_.get(i);
    }

    public int getValuesCount() {
        return this.values_.size();
    }

    public List<PassportStruct$PassportFieldValue> getValuesList() {
        return this.values_;
    }

    public InterfaceC1842b1 getValuesOrBuilder(int i) {
        return (InterfaceC1842b1) this.values_.get(i);
    }

    public List<? extends InterfaceC1842b1> getValuesOrBuilderList() {
        return this.values_;
    }

    public boolean hasLanguage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportOuterClass$RequestSubmitForm passportOuterClass$RequestSubmitForm) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$RequestSubmitForm);
    }

    public static PassportOuterClass$RequestSubmitForm parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addValues(int i, PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        ensureValuesIsMutable();
        this.values_.add(i, passportStruct$PassportFieldValue);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(byte[] bArr) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$RequestSubmitForm parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$RequestSubmitForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
