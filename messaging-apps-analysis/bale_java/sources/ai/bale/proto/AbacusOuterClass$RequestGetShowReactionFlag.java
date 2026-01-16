package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AbacusOuterClass$RequestGetShowReactionFlag extends GeneratedMessageLite implements U64 {
    private static final AbacusOuterClass$RequestGetShowReactionFlag DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AbacusOuterClass$RequestGetShowReactionFlag.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$RequestGetShowReactionFlag abacusOuterClass$RequestGetShowReactionFlag = new AbacusOuterClass$RequestGetShowReactionFlag();
        DEFAULT_INSTANCE = abacusOuterClass$RequestGetShowReactionFlag;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$RequestGetShowReactionFlag.class, abacusOuterClass$RequestGetShowReactionFlag);
    }

    private AbacusOuterClass$RequestGetShowReactionFlag() {
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$RequestGetShowReactionFlag();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$RequestGetShowReactionFlag.class) {
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

    public static a newBuilder(AbacusOuterClass$RequestGetShowReactionFlag abacusOuterClass$RequestGetShowReactionFlag) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$RequestGetShowReactionFlag);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(byte[] bArr) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$RequestGetShowReactionFlag parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
