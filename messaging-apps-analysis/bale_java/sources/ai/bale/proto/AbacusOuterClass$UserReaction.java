package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13302g0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AbacusOuterClass$UserReaction extends GeneratedMessageLite implements InterfaceC13302g0 {
    public static final int CODE_FIELD_NUMBER = 2;
    private static final AbacusOuterClass$UserReaction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTION_TIME_FIELD_NUMBER = 3;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private String code_ = "";
    private long reactionTime_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13302g0 {
        private a() {
            super(AbacusOuterClass$UserReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$UserReaction abacusOuterClass$UserReaction = new AbacusOuterClass$UserReaction();
        DEFAULT_INSTANCE = abacusOuterClass$UserReaction;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$UserReaction.class, abacusOuterClass$UserReaction);
    }

    private AbacusOuterClass$UserReaction() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearReactionTime() {
        this.reactionTime_ = 0L;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AbacusOuterClass$UserReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$UserReaction parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$UserReaction parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    private void setReactionTime(long j) {
        this.reactionTime_ = j;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$UserReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0002", new Object[]{"userId_", "code_", "reactionTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$UserReaction.class) {
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

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public long getReactionTime() {
        return this.reactionTime_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AbacusOuterClass$UserReaction abacusOuterClass$UserReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$UserReaction);
    }

    public static AbacusOuterClass$UserReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$UserReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$UserReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AbacusOuterClass$UserReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$UserReaction parseFrom(byte[] bArr) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$UserReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$UserReaction parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$UserReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$UserReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$UserReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$UserReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
