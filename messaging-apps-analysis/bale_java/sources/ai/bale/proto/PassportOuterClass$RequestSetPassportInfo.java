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
public final class PassportOuterClass$RequestSetPassportInfo extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$RequestSetPassportInfo DEFAULT_INSTANCE;
    public static final int LANGUAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue language_;
    private B.j values_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportOuterClass$RequestSetPassportInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$RequestSetPassportInfo passportOuterClass$RequestSetPassportInfo = new PassportOuterClass$RequestSetPassportInfo();
        DEFAULT_INSTANCE = passportOuterClass$RequestSetPassportInfo;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$RequestSetPassportInfo.class, passportOuterClass$RequestSetPassportInfo);
    }

    private PassportOuterClass$RequestSetPassportInfo() {
    }

    private void addAllValues(Iterable<? extends PassportStruct$PassportFieldValue> iterable) {
        ensureValuesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.values_);
    }

    private void addValues(PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        ensureValuesIsMutable();
        this.values_.add(passportStruct$PassportFieldValue);
    }

    private void clearLanguage() {
        this.language_ = null;
        this.bitField0_ &= -2;
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

    public static PassportOuterClass$RequestSetPassportInfo getDefaultInstance() {
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

    public static PassportOuterClass$RequestSetPassportInfo parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setValues(int i, PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        ensureValuesIsMutable();
        this.values_.set(i, passportStruct$PassportFieldValue);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$RequestSetPassportInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"bitField0_", "values_", PassportStruct$PassportFieldValue.class, "language_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$RequestSetPassportInfo.class) {
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

    public static a newBuilder(PassportOuterClass$RequestSetPassportInfo passportOuterClass$RequestSetPassportInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$RequestSetPassportInfo);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addValues(int i, PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        ensureValuesIsMutable();
        this.values_.add(i, passportStruct$PassportFieldValue);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(byte[] bArr) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$RequestSetPassportInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
