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
public final class PremiumOuterClass$RequestSetUserBadge extends GeneratedMessageLite implements U64 {
    public static final int BADGE_ID_FIELD_NUMBER = 1;
    private static final PremiumOuterClass$RequestSetUserBadge DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long badgeId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((PremiumOuterClass$RequestSetUserBadge) this.b).setBadgeId(j);
            return this;
        }

        private a() {
            super(PremiumOuterClass$RequestSetUserBadge.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$RequestSetUserBadge premiumOuterClass$RequestSetUserBadge = new PremiumOuterClass$RequestSetUserBadge();
        DEFAULT_INSTANCE = premiumOuterClass$RequestSetUserBadge;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$RequestSetUserBadge.class, premiumOuterClass$RequestSetUserBadge);
    }

    private PremiumOuterClass$RequestSetUserBadge() {
    }

    private void clearBadgeId() {
        this.badgeId_ = 0L;
    }

    public static PremiumOuterClass$RequestSetUserBadge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$RequestSetUserBadge parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBadgeId(long j) {
        this.badgeId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$RequestSetUserBadge();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"badgeId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$RequestSetUserBadge.class) {
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

    public long getBadgeId() {
        return this.badgeId_;
    }

    public static a newBuilder(PremiumOuterClass$RequestSetUserBadge premiumOuterClass$RequestSetUserBadge) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$RequestSetUserBadge);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(byte[] bArr) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$RequestSetUserBadge parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$RequestSetUserBadge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
