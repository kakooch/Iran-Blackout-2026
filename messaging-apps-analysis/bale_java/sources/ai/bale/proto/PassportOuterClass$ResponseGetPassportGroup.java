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
public final class PassportOuterClass$ResponseGetPassportGroup extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$ResponseGetPassportGroup DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PassportStruct$PassportFieldGroup group_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportOuterClass$ResponseGetPassportGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$ResponseGetPassportGroup passportOuterClass$ResponseGetPassportGroup = new PassportOuterClass$ResponseGetPassportGroup();
        DEFAULT_INSTANCE = passportOuterClass$ResponseGetPassportGroup;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$ResponseGetPassportGroup.class, passportOuterClass$ResponseGetPassportGroup);
    }

    private PassportOuterClass$ResponseGetPassportGroup() {
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportOuterClass$ResponseGetPassportGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroup(PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        passportStruct$PassportFieldGroup.getClass();
        PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup2 = this.group_;
        if (passportStruct$PassportFieldGroup2 == null || passportStruct$PassportFieldGroup2 == PassportStruct$PassportFieldGroup.getDefaultInstance()) {
            this.group_ = passportStruct$PassportFieldGroup;
        } else {
            this.group_ = (PassportStruct$PassportFieldGroup) ((PassportStruct$PassportFieldGroup.a) PassportStruct$PassportFieldGroup.newBuilder(this.group_).v(passportStruct$PassportFieldGroup)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroup(PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        passportStruct$PassportFieldGroup.getClass();
        this.group_ = passportStruct$PassportFieldGroup;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$ResponseGetPassportGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "group_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$ResponseGetPassportGroup.class) {
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

    public PassportStruct$PassportFieldGroup getGroup() {
        PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup = this.group_;
        return passportStruct$PassportFieldGroup == null ? PassportStruct$PassportFieldGroup.getDefaultInstance() : passportStruct$PassportFieldGroup;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportOuterClass$ResponseGetPassportGroup passportOuterClass$ResponseGetPassportGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$ResponseGetPassportGroup);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(byte[] bArr) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$ResponseGetPassportGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
