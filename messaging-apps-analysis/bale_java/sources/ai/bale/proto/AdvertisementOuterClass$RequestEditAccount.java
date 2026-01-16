package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AccountData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestEditAccount extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestEditAccount DEFAULT_INSTANCE;
    public static final int IS_RESTORE_EXPIRED_CREDIT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private AdvertisementStruct$AccountData account_;
    private int bitField0_;
    private boolean isRestoreExpiredCredit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestEditAccount.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestEditAccount advertisementOuterClass$RequestEditAccount = new AdvertisementOuterClass$RequestEditAccount();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestEditAccount;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestEditAccount.class, advertisementOuterClass$RequestEditAccount);
    }

    private AdvertisementOuterClass$RequestEditAccount() {
    }

    private void clearAccount() {
        this.account_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsRestoreExpiredCredit() {
        this.isRestoreExpiredCredit_ = false;
    }

    public static AdvertisementOuterClass$RequestEditAccount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAccount(AdvertisementStruct$AccountData advertisementStruct$AccountData) {
        advertisementStruct$AccountData.getClass();
        AdvertisementStruct$AccountData advertisementStruct$AccountData2 = this.account_;
        if (advertisementStruct$AccountData2 == null || advertisementStruct$AccountData2 == AdvertisementStruct$AccountData.getDefaultInstance()) {
            this.account_ = advertisementStruct$AccountData;
        } else {
            this.account_ = (AdvertisementStruct$AccountData) ((AdvertisementStruct$AccountData.b) AdvertisementStruct$AccountData.newBuilder(this.account_).v(advertisementStruct$AccountData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestEditAccount parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccount(AdvertisementStruct$AccountData advertisementStruct$AccountData) {
        advertisementStruct$AccountData.getClass();
        this.account_ = advertisementStruct$AccountData;
        this.bitField0_ |= 1;
    }

    private void setIsRestoreExpiredCredit(boolean z) {
        this.isRestoreExpiredCredit_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestEditAccount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0007", new Object[]{"bitField0_", "account_", "isRestoreExpiredCredit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestEditAccount.class) {
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

    public AdvertisementStruct$AccountData getAccount() {
        AdvertisementStruct$AccountData advertisementStruct$AccountData = this.account_;
        return advertisementStruct$AccountData == null ? AdvertisementStruct$AccountData.getDefaultInstance() : advertisementStruct$AccountData;
    }

    public boolean getIsRestoreExpiredCredit() {
        return this.isRestoreExpiredCredit_;
    }

    public boolean hasAccount() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestEditAccount advertisementOuterClass$RequestEditAccount) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestEditAccount);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestEditAccount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
