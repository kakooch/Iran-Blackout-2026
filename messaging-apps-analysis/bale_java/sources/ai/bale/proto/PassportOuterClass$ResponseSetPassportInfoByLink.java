package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportOuterClass$ResponseSetPassportInfoByLink extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$ResponseSetPassportInfoByLink DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportOuterClass$ResponseSetPassportInfoByLink.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$ResponseSetPassportInfoByLink passportOuterClass$ResponseSetPassportInfoByLink = new PassportOuterClass$ResponseSetPassportInfoByLink();
        DEFAULT_INSTANCE = passportOuterClass$ResponseSetPassportInfoByLink;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$ResponseSetPassportInfoByLink.class, passportOuterClass$ResponseSetPassportInfoByLink);
    }

    private PassportOuterClass$ResponseSetPassportInfoByLink() {
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$ResponseSetPassportInfoByLink();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$ResponseSetPassportInfoByLink.class) {
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

    public static a newBuilder(PassportOuterClass$ResponseSetPassportInfoByLink passportOuterClass$ResponseSetPassportInfoByLink) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$ResponseSetPassportInfoByLink);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(byte[] bArr) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$ResponseSetPassportInfoByLink parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$ResponseSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
