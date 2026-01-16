package ai.bale.proto;

import ai.bale.proto.PremiumStruct$WithDetailOption;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumOuterClass$RequestIsPremium extends GeneratedMessageLite implements U64 {
    private static final PremiumOuterClass$RequestIsPremium DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    public static final int WITH_DETAIL_OPTION_FIELD_NUMBER = 2;
    private int bitField0_;
    private int userId_;
    private PremiumStruct$WithDetailOption withDetailOption_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((PremiumOuterClass$RequestIsPremium) this.b).setUserId(i);
            return this;
        }

        public a B(PremiumStruct$WithDetailOption premiumStruct$WithDetailOption) {
            q();
            ((PremiumOuterClass$RequestIsPremium) this.b).setWithDetailOption(premiumStruct$WithDetailOption);
            return this;
        }

        private a() {
            super(PremiumOuterClass$RequestIsPremium.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$RequestIsPremium premiumOuterClass$RequestIsPremium = new PremiumOuterClass$RequestIsPremium();
        DEFAULT_INSTANCE = premiumOuterClass$RequestIsPremium;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$RequestIsPremium.class, premiumOuterClass$RequestIsPremium);
    }

    private PremiumOuterClass$RequestIsPremium() {
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    private void clearWithDetailOption() {
        this.withDetailOption_ = null;
        this.bitField0_ &= -2;
    }

    public static PremiumOuterClass$RequestIsPremium getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeWithDetailOption(PremiumStruct$WithDetailOption premiumStruct$WithDetailOption) {
        premiumStruct$WithDetailOption.getClass();
        PremiumStruct$WithDetailOption premiumStruct$WithDetailOption2 = this.withDetailOption_;
        if (premiumStruct$WithDetailOption2 == null || premiumStruct$WithDetailOption2 == PremiumStruct$WithDetailOption.getDefaultInstance()) {
            this.withDetailOption_ = premiumStruct$WithDetailOption;
        } else {
            this.withDetailOption_ = (PremiumStruct$WithDetailOption) ((PremiumStruct$WithDetailOption.a) PremiumStruct$WithDetailOption.newBuilder(this.withDetailOption_).v(premiumStruct$WithDetailOption)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$RequestIsPremium parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserId(int i) {
        this.userId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWithDetailOption(PremiumStruct$WithDetailOption premiumStruct$WithDetailOption) {
        premiumStruct$WithDetailOption.getClass();
        this.withDetailOption_ = premiumStruct$WithDetailOption;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$RequestIsPremium();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "userId_", "withDetailOption_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$RequestIsPremium.class) {
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

    public int getUserId() {
        return this.userId_;
    }

    public PremiumStruct$WithDetailOption getWithDetailOption() {
        PremiumStruct$WithDetailOption premiumStruct$WithDetailOption = this.withDetailOption_;
        return premiumStruct$WithDetailOption == null ? PremiumStruct$WithDetailOption.getDefaultInstance() : premiumStruct$WithDetailOption;
    }

    public boolean hasWithDetailOption() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PremiumOuterClass$RequestIsPremium premiumOuterClass$RequestIsPremium) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$RequestIsPremium);
    }

    public static PremiumOuterClass$RequestIsPremium parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(byte[] bArr) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$RequestIsPremium parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremium) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
