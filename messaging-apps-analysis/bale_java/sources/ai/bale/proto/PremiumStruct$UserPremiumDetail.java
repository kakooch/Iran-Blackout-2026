package ai.bale.proto;

import ai.bale.proto.PremiumStruct$Badge;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumStruct$UserPremiumDetail extends GeneratedMessageLite implements U64 {
    public static final int BADGE_FIELD_NUMBER = 1;
    private static final PremiumStruct$UserPremiumDetail DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private PremiumStruct$Badge badge_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumStruct$UserPremiumDetail.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$UserPremiumDetail premiumStruct$UserPremiumDetail = new PremiumStruct$UserPremiumDetail();
        DEFAULT_INSTANCE = premiumStruct$UserPremiumDetail;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$UserPremiumDetail.class, premiumStruct$UserPremiumDetail);
    }

    private PremiumStruct$UserPremiumDetail() {
    }

    private void clearBadge() {
        this.badge_ = null;
        this.bitField0_ &= -2;
    }

    public static PremiumStruct$UserPremiumDetail getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBadge(PremiumStruct$Badge premiumStruct$Badge) {
        premiumStruct$Badge.getClass();
        PremiumStruct$Badge premiumStruct$Badge2 = this.badge_;
        if (premiumStruct$Badge2 == null || premiumStruct$Badge2 == PremiumStruct$Badge.getDefaultInstance()) {
            this.badge_ = premiumStruct$Badge;
        } else {
            this.badge_ = (PremiumStruct$Badge) ((PremiumStruct$Badge.a) PremiumStruct$Badge.newBuilder(this.badge_).v(premiumStruct$Badge)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$UserPremiumDetail parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBadge(PremiumStruct$Badge premiumStruct$Badge) {
        premiumStruct$Badge.getClass();
        this.badge_ = premiumStruct$Badge;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1863i1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumStruct$UserPremiumDetail();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "badge_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$UserPremiumDetail.class) {
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

    public PremiumStruct$Badge getBadge() {
        PremiumStruct$Badge premiumStruct$Badge = this.badge_;
        return premiumStruct$Badge == null ? PremiumStruct$Badge.getDefaultInstance() : premiumStruct$Badge;
    }

    public boolean hasBadge() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PremiumStruct$UserPremiumDetail premiumStruct$UserPremiumDetail) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$UserPremiumDetail);
    }

    public static PremiumStruct$UserPremiumDetail parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(byte[] bArr) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(InputStream inputStream) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$UserPremiumDetail parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$UserPremiumDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
