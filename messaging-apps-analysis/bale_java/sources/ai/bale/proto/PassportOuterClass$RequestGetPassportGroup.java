package ai.bale.proto;

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
public final class PassportOuterClass$RequestGetPassportGroup extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$RequestGetPassportGroup DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int LANGUAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int groupId_;
    private StringValue language_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((PassportOuterClass$RequestGetPassportGroup) this.b).setGroupId(i);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((PassportOuterClass$RequestGetPassportGroup) this.b).setLanguage(stringValue);
            return this;
        }

        private a() {
            super(PassportOuterClass$RequestGetPassportGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$RequestGetPassportGroup passportOuterClass$RequestGetPassportGroup = new PassportOuterClass$RequestGetPassportGroup();
        DEFAULT_INSTANCE = passportOuterClass$RequestGetPassportGroup;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$RequestGetPassportGroup.class, passportOuterClass$RequestGetPassportGroup);
    }

    private PassportOuterClass$RequestGetPassportGroup() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearLanguage() {
        this.language_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportOuterClass$RequestGetPassportGroup getDefaultInstance() {
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

    public static PassportOuterClass$RequestGetPassportGroup parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$RequestGetPassportGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "groupId_", "language_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$RequestGetPassportGroup.class) {
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

    public boolean hasLanguage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportOuterClass$RequestGetPassportGroup passportOuterClass$RequestGetPassportGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$RequestGetPassportGroup);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(byte[] bArr) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$RequestGetPassportGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$RequestGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
