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
public final class RamzOuterClass$RequestSendOtp extends GeneratedMessageLite implements U64 {
    private static final RamzOuterClass$RequestSendOtp DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RamzOuterClass$RequestSendOtp.DEFAULT_INSTANCE);
        }
    }

    static {
        RamzOuterClass$RequestSendOtp ramzOuterClass$RequestSendOtp = new RamzOuterClass$RequestSendOtp();
        DEFAULT_INSTANCE = ramzOuterClass$RequestSendOtp;
        GeneratedMessageLite.registerDefaultInstance(RamzOuterClass$RequestSendOtp.class, ramzOuterClass$RequestSendOtp);
    }

    private RamzOuterClass$RequestSendOtp() {
    }

    public static RamzOuterClass$RequestSendOtp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RamzOuterClass$RequestSendOtp parseDelimitedFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(ByteBuffer byteBuffer) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1887q1.a[gVar.ordinal()]) {
            case 1:
                return new RamzOuterClass$RequestSendOtp();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RamzOuterClass$RequestSendOtp.class) {
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

    public static a newBuilder(RamzOuterClass$RequestSendOtp ramzOuterClass$RequestSendOtp) {
        return (a) DEFAULT_INSTANCE.createBuilder(ramzOuterClass$RequestSendOtp);
    }

    public static RamzOuterClass$RequestSendOtp parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(AbstractC2383g abstractC2383g) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(byte[] bArr) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(byte[] bArr, C2394s c2394s) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(AbstractC2384h abstractC2384h) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RamzOuterClass$RequestSendOtp parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RamzOuterClass$RequestSendOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
