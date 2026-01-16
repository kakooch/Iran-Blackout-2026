package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC9464a05;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PassportStruct$PassportFieldGroup extends GeneratedMessageLite implements InterfaceC9464a05 {
    private static final PassportStruct$PassportFieldGroup DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    public static final int INLINE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int bitField0_;
    private B.j fields_ = GeneratedMessageLite.emptyProtobufList();
    private boolean inline_;
    private StringValue title_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC9464a05 {
        private a() {
            super(PassportStruct$PassportFieldGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup = new PassportStruct$PassportFieldGroup();
        DEFAULT_INSTANCE = passportStruct$PassportFieldGroup;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportFieldGroup.class, passportStruct$PassportFieldGroup);
    }

    private PassportStruct$PassportFieldGroup() {
    }

    private void addAllFields(Iterable<? extends PassportStruct$PassportField> iterable) {
        ensureFieldsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.fields_);
    }

    private void addFields(PassportStruct$PassportField passportStruct$PassportField) {
        passportStruct$PassportField.getClass();
        ensureFieldsIsMutable();
        this.fields_.add(passportStruct$PassportField);
    }

    private void clearFields() {
        this.fields_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearInline() {
        this.inline_ = false;
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureFieldsIsMutable() {
        B.j jVar = this.fields_;
        if (jVar.u()) {
            return;
        }
        this.fields_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PassportStruct$PassportFieldGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.title_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.title_ = stringValue;
        } else {
            this.title_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.title_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportFieldGroup parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFields(int i) {
        ensureFieldsIsMutable();
        this.fields_.remove(i);
    }

    private void setFields(int i, PassportStruct$PassportField passportStruct$PassportField) {
        passportStruct$PassportField.getClass();
        ensureFieldsIsMutable();
        this.fields_.set(i, passportStruct$PassportField);
    }

    private void setInline(boolean z) {
        this.inline_ = z;
    }

    private void setTitle(StringValue stringValue) {
        stringValue.getClass();
        this.title_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportFieldGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003\u0007", new Object[]{"bitField0_", "fields_", PassportStruct$PassportField.class, "title_", "inline_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportFieldGroup.class) {
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

    public PassportStruct$PassportField getFields(int i) {
        return (PassportStruct$PassportField) this.fields_.get(i);
    }

    public int getFieldsCount() {
        return this.fields_.size();
    }

    public List<PassportStruct$PassportField> getFieldsList() {
        return this.fields_;
    }

    public InterfaceC1839a1 getFieldsOrBuilder(int i) {
        return (InterfaceC1839a1) this.fields_.get(i);
    }

    public List<? extends InterfaceC1839a1> getFieldsOrBuilderList() {
        return this.fields_;
    }

    public boolean getInline() {
        return this.inline_;
    }

    public StringValue getTitle() {
        StringValue stringValue = this.title_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportFieldGroup);
    }

    public static PassportStruct$PassportFieldGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFields(int i, PassportStruct$PassportField passportStruct$PassportField) {
        passportStruct$PassportField.getClass();
        ensureFieldsIsMutable();
        this.fields_.add(i, passportStruct$PassportField);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(byte[] bArr) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportFieldGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportFieldGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
