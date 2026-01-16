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
public final class AbacusOuterClass$ResponseGetShowReactionFlag extends GeneratedMessageLite implements U64 {
    private static final AbacusOuterClass$ResponseGetShowReactionFlag DEFAULT_INSTANCE;
    public static final int IS_ENABLE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private boolean isEnable_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AbacusOuterClass$ResponseGetShowReactionFlag.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$ResponseGetShowReactionFlag abacusOuterClass$ResponseGetShowReactionFlag = new AbacusOuterClass$ResponseGetShowReactionFlag();
        DEFAULT_INSTANCE = abacusOuterClass$ResponseGetShowReactionFlag;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$ResponseGetShowReactionFlag.class, abacusOuterClass$ResponseGetShowReactionFlag);
    }

    private AbacusOuterClass$ResponseGetShowReactionFlag() {
    }

    private void clearIsEnable() {
        this.isEnable_ = false;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsEnable(boolean z) {
        this.isEnable_ = z;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$ResponseGetShowReactionFlag();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0007", new Object[]{"userId_", "isEnable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$ResponseGetShowReactionFlag.class) {
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

    public boolean getIsEnable() {
        return this.isEnable_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AbacusOuterClass$ResponseGetShowReactionFlag abacusOuterClass$ResponseGetShowReactionFlag) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$ResponseGetShowReactionFlag);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(byte[] bArr) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$ResponseGetShowReactionFlag parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetShowReactionFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
