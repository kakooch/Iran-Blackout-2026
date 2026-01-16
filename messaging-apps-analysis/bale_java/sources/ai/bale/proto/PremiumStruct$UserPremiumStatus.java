package ai.bale.proto;

import ai.bale.proto.PremiumStruct$UserPremiumDetail;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5484Jn5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumStruct$UserPremiumStatus extends GeneratedMessageLite implements InterfaceC5484Jn5 {
    private static final PremiumStruct$UserPremiumStatus DEFAULT_INSTANCE;
    public static final int DETAIL_FIELD_NUMBER = 4;
    public static final int EXPIRATION_TIME_FIELD_NUMBER = 3;
    public static final int IS_PREMIUM_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private PremiumStruct$UserPremiumDetail detail_;
    private long expirationTime_;
    private boolean isPremium_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5484Jn5 {
        private a() {
            super(PremiumStruct$UserPremiumStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus = new PremiumStruct$UserPremiumStatus();
        DEFAULT_INSTANCE = premiumStruct$UserPremiumStatus;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$UserPremiumStatus.class, premiumStruct$UserPremiumStatus);
    }

    private PremiumStruct$UserPremiumStatus() {
    }

    private void clearDetail() {
        this.detail_ = null;
        this.bitField0_ &= -2;
    }

    private void clearExpirationTime() {
        this.expirationTime_ = 0L;
    }

    private void clearIsPremium() {
        this.isPremium_ = false;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static PremiumStruct$UserPremiumStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDetail(PremiumStruct$UserPremiumDetail premiumStruct$UserPremiumDetail) {
        premiumStruct$UserPremiumDetail.getClass();
        PremiumStruct$UserPremiumDetail premiumStruct$UserPremiumDetail2 = this.detail_;
        if (premiumStruct$UserPremiumDetail2 == null || premiumStruct$UserPremiumDetail2 == PremiumStruct$UserPremiumDetail.getDefaultInstance()) {
            this.detail_ = premiumStruct$UserPremiumDetail;
        } else {
            this.detail_ = (PremiumStruct$UserPremiumDetail) ((PremiumStruct$UserPremiumDetail.a) PremiumStruct$UserPremiumDetail.newBuilder(this.detail_).v(premiumStruct$UserPremiumDetail)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$UserPremiumStatus parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDetail(PremiumStruct$UserPremiumDetail premiumStruct$UserPremiumDetail) {
        premiumStruct$UserPremiumDetail.getClass();
        this.detail_ = premiumStruct$UserPremiumDetail;
        this.bitField0_ |= 1;
    }

    private void setExpirationTime(long j) {
        this.expirationTime_ = j;
    }

    private void setIsPremium(boolean z) {
        this.isPremium_ = z;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1863i1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumStruct$UserPremiumStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0007\u0003\u0002\u0004ဉ\u0000", new Object[]{"bitField0_", "userId_", "isPremium_", "expirationTime_", "detail_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$UserPremiumStatus.class) {
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

    public PremiumStruct$UserPremiumDetail getDetail() {
        PremiumStruct$UserPremiumDetail premiumStruct$UserPremiumDetail = this.detail_;
        return premiumStruct$UserPremiumDetail == null ? PremiumStruct$UserPremiumDetail.getDefaultInstance() : premiumStruct$UserPremiumDetail;
    }

    public long getExpirationTime() {
        return this.expirationTime_;
    }

    public boolean getIsPremium() {
        return this.isPremium_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public boolean hasDetail() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$UserPremiumStatus);
    }

    public static PremiumStruct$UserPremiumStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(byte[] bArr) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(InputStream inputStream) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$UserPremiumStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$UserPremiumStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
