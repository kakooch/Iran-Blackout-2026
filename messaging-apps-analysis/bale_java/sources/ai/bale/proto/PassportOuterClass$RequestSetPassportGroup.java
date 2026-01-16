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
public final class PassportOuterClass$RequestSetPassportGroup extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$RequestSetPassportGroup DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int LANGUAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 2;
    private int bitField0_;
    private int groupId_;
    private StringValue language_;
    private B.j values_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PassportOuterClass$RequestSetPassportGroup) this.b).addAllValues(iterable);
            return this;
        }

        public a B(int i) {
            q();
            ((PassportOuterClass$RequestSetPassportGroup) this.b).setGroupId(i);
            return this;
        }

        public a C(StringValue stringValue) {
            q();
            ((PassportOuterClass$RequestSetPassportGroup) this.b).setLanguage(stringValue);
            return this;
        }

        private a() {
            super(PassportOuterClass$RequestSetPassportGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$RequestSetPassportGroup passportOuterClass$RequestSetPassportGroup = new PassportOuterClass$RequestSetPassportGroup();
        DEFAULT_INSTANCE = passportOuterClass$RequestSetPassportGroup;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$RequestSetPassportGroup.class, passportOuterClass$RequestSetPassportGroup);
    }

    private PassportOuterClass$RequestSetPassportGroup() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllValues(Iterable<? extends PassportStruct$PassportFieldValue> iterable) {
        ensureValuesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.values_);
    }

    private void addValues(PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        ensureValuesIsMutable();
        this.values_.add(passportStruct$PassportFieldValue);
    }

    private void clearGroupId() {
        this.groupId_ = 0;
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

    public static PassportOuterClass$RequestSetPassportGroup getDefaultInstance() {
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

    public static PassportOuterClass$RequestSetPassportGroup parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeValues(int i) {
        ensureValuesIsMutable();
        this.values_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupId(int i) {
        this.groupId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguage(StringValue stringValue) {
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
                return new PassportOuterClass$RequestSetPassportGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002\u001b\u0003ဉ\u0000", new Object[]{"bitField0_", "groupId_", "values_", PassportStruct$PassportFieldValue.class, "language_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$RequestSetPassportGroup.class) {
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

    public int getGroupId() {
        return this.groupId_;
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

    public static a newBuilder(PassportOuterClass$RequestSetPassportGroup passportOuterClass$RequestSetPassportGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$RequestSetPassportGroup);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addValues(int i, PassportStruct$PassportFieldValue passportStruct$PassportFieldValue) {
        passportStruct$PassportFieldValue.getClass();
        ensureValuesIsMutable();
        this.values_.add(i, passportStruct$PassportFieldValue);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(byte[] bArr) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$RequestSetPassportGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
