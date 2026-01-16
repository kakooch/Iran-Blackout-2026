package ai.bale.proto;

import ai.bale.proto.PremiumStruct$UserPremiumStatus;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumOuterClass$ResponseIsPremium extends GeneratedMessageLite implements U64 {
    private static final PremiumOuterClass$ResponseIsPremium DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private PremiumStruct$UserPremiumStatus userStatus_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumOuterClass$ResponseIsPremium.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$ResponseIsPremium premiumOuterClass$ResponseIsPremium = new PremiumOuterClass$ResponseIsPremium();
        DEFAULT_INSTANCE = premiumOuterClass$ResponseIsPremium;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$ResponseIsPremium.class, premiumOuterClass$ResponseIsPremium);
    }

    private PremiumOuterClass$ResponseIsPremium() {
    }

    private void clearUserStatus() {
        this.userStatus_ = null;
        this.bitField0_ &= -2;
    }

    public static PremiumOuterClass$ResponseIsPremium getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUserStatus(PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus) {
        premiumStruct$UserPremiumStatus.getClass();
        PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus2 = this.userStatus_;
        if (premiumStruct$UserPremiumStatus2 == null || premiumStruct$UserPremiumStatus2 == PremiumStruct$UserPremiumStatus.getDefaultInstance()) {
            this.userStatus_ = premiumStruct$UserPremiumStatus;
        } else {
            this.userStatus_ = (PremiumStruct$UserPremiumStatus) ((PremiumStruct$UserPremiumStatus.a) PremiumStruct$UserPremiumStatus.newBuilder(this.userStatus_).v(premiumStruct$UserPremiumStatus)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$ResponseIsPremium parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserStatus(PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus) {
        premiumStruct$UserPremiumStatus.getClass();
        this.userStatus_ = premiumStruct$UserPremiumStatus;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$ResponseIsPremium();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "userStatus_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$ResponseIsPremium.class) {
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

    public PremiumStruct$UserPremiumStatus getUserStatus() {
        PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus = this.userStatus_;
        return premiumStruct$UserPremiumStatus == null ? PremiumStruct$UserPremiumStatus.getDefaultInstance() : premiumStruct$UserPremiumStatus;
    }

    public boolean hasUserStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PremiumOuterClass$ResponseIsPremium premiumOuterClass$ResponseIsPremium) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$ResponseIsPremium);
    }

    public static PremiumOuterClass$ResponseIsPremium parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(byte[] bArr) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$ResponseIsPremium parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
