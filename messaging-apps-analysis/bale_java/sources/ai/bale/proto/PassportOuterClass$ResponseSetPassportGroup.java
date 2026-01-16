package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportFieldGroup;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportOuterClass$ResponseSetPassportGroup extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$ResponseSetPassportGroup DEFAULT_INSTANCE;
    public static final int INVALID_GROUP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PassportStruct$PassportFieldGroup invalidGroup_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportOuterClass$ResponseSetPassportGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$ResponseSetPassportGroup passportOuterClass$ResponseSetPassportGroup = new PassportOuterClass$ResponseSetPassportGroup();
        DEFAULT_INSTANCE = passportOuterClass$ResponseSetPassportGroup;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$ResponseSetPassportGroup.class, passportOuterClass$ResponseSetPassportGroup);
    }

    private PassportOuterClass$ResponseSetPassportGroup() {
    }

    private void clearInvalidGroup() {
        this.invalidGroup_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportOuterClass$ResponseSetPassportGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInvalidGroup(PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        passportStruct$PassportFieldGroup.getClass();
        PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup2 = this.invalidGroup_;
        if (passportStruct$PassportFieldGroup2 == null || passportStruct$PassportFieldGroup2 == PassportStruct$PassportFieldGroup.getDefaultInstance()) {
            this.invalidGroup_ = passportStruct$PassportFieldGroup;
        } else {
            this.invalidGroup_ = (PassportStruct$PassportFieldGroup) ((PassportStruct$PassportFieldGroup.a) PassportStruct$PassportFieldGroup.newBuilder(this.invalidGroup_).v(passportStruct$PassportFieldGroup)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInvalidGroup(PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        passportStruct$PassportFieldGroup.getClass();
        this.invalidGroup_ = passportStruct$PassportFieldGroup;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$ResponseSetPassportGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "invalidGroup_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$ResponseSetPassportGroup.class) {
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

    public PassportStruct$PassportFieldGroup getInvalidGroup() {
        PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup = this.invalidGroup_;
        return passportStruct$PassportFieldGroup == null ? PassportStruct$PassportFieldGroup.getDefaultInstance() : passportStruct$PassportFieldGroup;
    }

    public boolean hasInvalidGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportOuterClass$ResponseSetPassportGroup passportOuterClass$ResponseSetPassportGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$ResponseSetPassportGroup);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(byte[] bArr) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$ResponseSetPassportGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
