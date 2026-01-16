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
public final class ReferralOuterClass$ResponseRefer extends GeneratedMessageLite implements U64 {
    private static final ReferralOuterClass$ResponseRefer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ReferralOuterClass$ResponseRefer.DEFAULT_INSTANCE);
        }
    }

    static {
        ReferralOuterClass$ResponseRefer referralOuterClass$ResponseRefer = new ReferralOuterClass$ResponseRefer();
        DEFAULT_INSTANCE = referralOuterClass$ResponseRefer;
        GeneratedMessageLite.registerDefaultInstance(ReferralOuterClass$ResponseRefer.class, referralOuterClass$ResponseRefer);
    }

    private ReferralOuterClass$ResponseRefer() {
    }

    public static ReferralOuterClass$ResponseRefer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReferralOuterClass$ResponseRefer parseDelimitedFrom(InputStream inputStream) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(ByteBuffer byteBuffer) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1898u1.a[gVar.ordinal()]) {
            case 1:
                return new ReferralOuterClass$ResponseRefer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReferralOuterClass$ResponseRefer.class) {
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

    public static a newBuilder(ReferralOuterClass$ResponseRefer referralOuterClass$ResponseRefer) {
        return (a) DEFAULT_INSTANCE.createBuilder(referralOuterClass$ResponseRefer);
    }

    public static ReferralOuterClass$ResponseRefer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(AbstractC2383g abstractC2383g) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(byte[] bArr) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(InputStream inputStream) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(AbstractC2384h abstractC2384h) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReferralOuterClass$ResponseRefer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReferralOuterClass$ResponseRefer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
