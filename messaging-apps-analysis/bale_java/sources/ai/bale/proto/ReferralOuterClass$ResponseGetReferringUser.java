package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ReferralOuterClass$ResponseGetReferringUser extends GeneratedMessageLite implements U64 {
    public static final int CAN_BE_REFERRED_FIELD_NUMBER = 3;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final ReferralOuterClass$ResponseGetReferringUser DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean canBeReferred_;
    private long createdAt_;
    private Int32Value userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ReferralOuterClass$ResponseGetReferringUser.DEFAULT_INSTANCE);
        }
    }

    static {
        ReferralOuterClass$ResponseGetReferringUser referralOuterClass$ResponseGetReferringUser = new ReferralOuterClass$ResponseGetReferringUser();
        DEFAULT_INSTANCE = referralOuterClass$ResponseGetReferringUser;
        GeneratedMessageLite.registerDefaultInstance(ReferralOuterClass$ResponseGetReferringUser.class, referralOuterClass$ResponseGetReferringUser);
    }

    private ReferralOuterClass$ResponseGetReferringUser() {
    }

    private void clearCanBeReferred() {
        this.canBeReferred_ = false;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearUserId() {
        this.userId_ = null;
        this.bitField0_ &= -2;
    }

    public static ReferralOuterClass$ResponseGetReferringUser getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUserId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.userId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.userId_ = int32Value;
        } else {
            this.userId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.userId_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseDelimitedFrom(InputStream inputStream) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(ByteBuffer byteBuffer) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCanBeReferred(boolean z) {
        this.canBeReferred_ = z;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.userId_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1898u1.a[gVar.ordinal()]) {
            case 1:
                return new ReferralOuterClass$ResponseGetReferringUser();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0007", new Object[]{"bitField0_", "userId_", "createdAt_", "canBeReferred_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReferralOuterClass$ResponseGetReferringUser.class) {
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

    public boolean getCanBeReferred() {
        return this.canBeReferred_;
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public Int32Value getUserId() {
        Int32Value int32Value = this.userId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ReferralOuterClass$ResponseGetReferringUser referralOuterClass$ResponseGetReferringUser) {
        return (a) DEFAULT_INSTANCE.createBuilder(referralOuterClass$ResponseGetReferringUser);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(AbstractC2383g abstractC2383g) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(byte[] bArr) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(InputStream inputStream) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(AbstractC2384h abstractC2384h) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReferralOuterClass$ResponseGetReferringUser parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferringUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
