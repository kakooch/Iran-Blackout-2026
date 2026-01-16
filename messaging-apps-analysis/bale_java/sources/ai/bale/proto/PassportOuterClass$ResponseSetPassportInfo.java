package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportForm;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportOuterClass$ResponseSetPassportInfo extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$ResponseSetPassportInfo DEFAULT_INSTANCE;
    public static final int INVALID_FORM_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PassportStruct$PassportForm invalidForm_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportOuterClass$ResponseSetPassportInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$ResponseSetPassportInfo passportOuterClass$ResponseSetPassportInfo = new PassportOuterClass$ResponseSetPassportInfo();
        DEFAULT_INSTANCE = passportOuterClass$ResponseSetPassportInfo;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$ResponseSetPassportInfo.class, passportOuterClass$ResponseSetPassportInfo);
    }

    private PassportOuterClass$ResponseSetPassportInfo() {
    }

    private void clearInvalidForm() {
        this.invalidForm_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportOuterClass$ResponseSetPassportInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInvalidForm(PassportStruct$PassportForm passportStruct$PassportForm) {
        passportStruct$PassportForm.getClass();
        PassportStruct$PassportForm passportStruct$PassportForm2 = this.invalidForm_;
        if (passportStruct$PassportForm2 == null || passportStruct$PassportForm2 == PassportStruct$PassportForm.getDefaultInstance()) {
            this.invalidForm_ = passportStruct$PassportForm;
        } else {
            this.invalidForm_ = (PassportStruct$PassportForm) ((PassportStruct$PassportForm.a) PassportStruct$PassportForm.newBuilder(this.invalidForm_).v(passportStruct$PassportForm)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInvalidForm(PassportStruct$PassportForm passportStruct$PassportForm) {
        passportStruct$PassportForm.getClass();
        this.invalidForm_ = passportStruct$PassportForm;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$ResponseSetPassportInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "invalidForm_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$ResponseSetPassportInfo.class) {
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

    public PassportStruct$PassportForm getInvalidForm() {
        PassportStruct$PassportForm passportStruct$PassportForm = this.invalidForm_;
        return passportStruct$PassportForm == null ? PassportStruct$PassportForm.getDefaultInstance() : passportStruct$PassportForm;
    }

    public boolean hasInvalidForm() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportOuterClass$ResponseSetPassportInfo passportOuterClass$ResponseSetPassportInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$ResponseSetPassportInfo);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(byte[] bArr) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$ResponseSetPassportInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
