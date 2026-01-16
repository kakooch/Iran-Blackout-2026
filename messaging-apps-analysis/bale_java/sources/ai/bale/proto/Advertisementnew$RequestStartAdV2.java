package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC25081zi;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestStartAdV2 extends GeneratedMessageLite implements U64 {
    public static final int AD_ID_FIELD_NUMBER = 1;
    public static final int AUTO_FINISH_FIELD_NUMBER = 4;
    private static final Advertisementnew$RequestStartAdV2 DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PLATFORM_FIELD_NUMBER = 3;
    public static final int START_TIME_FIELD_NUMBER = 2;
    private String adId_ = "";
    private boolean autoFinish_;
    private int platform_;
    private long startTime_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestStartAdV2.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestStartAdV2 advertisementnew$RequestStartAdV2 = new Advertisementnew$RequestStartAdV2();
        DEFAULT_INSTANCE = advertisementnew$RequestStartAdV2;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestStartAdV2.class, advertisementnew$RequestStartAdV2);
    }

    private Advertisementnew$RequestStartAdV2() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearAutoFinish() {
        this.autoFinish_ = false;
    }

    private void clearPlatform() {
        this.platform_ = 0;
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    public static Advertisementnew$RequestStartAdV2 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestStartAdV2 parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdId(String str) {
        str.getClass();
        this.adId_ = str;
    }

    private void setAdIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.adId_ = abstractC2383g.f0();
    }

    private void setAutoFinish(boolean z) {
        this.autoFinish_ = z;
    }

    private void setPlatform(EnumC25081zi enumC25081zi) {
        this.platform_ = enumC25081zi.getNumber();
    }

    private void setPlatformValue(int i) {
        this.platform_ = i;
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestStartAdV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\f\u0004\u0007", new Object[]{"adId_", "startTime_", "platform_", "autoFinish_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestStartAdV2.class) {
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

    public String getAdId() {
        return this.adId_;
    }

    public AbstractC2383g getAdIdBytes() {
        return AbstractC2383g.N(this.adId_);
    }

    public boolean getAutoFinish() {
        return this.autoFinish_;
    }

    public EnumC25081zi getPlatform() {
        EnumC25081zi enumC25081ziJ = EnumC25081zi.j(this.platform_);
        return enumC25081ziJ == null ? EnumC25081zi.UNRECOGNIZED : enumC25081ziJ;
    }

    public int getPlatformValue() {
        return this.platform_;
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public static a newBuilder(Advertisementnew$RequestStartAdV2 advertisementnew$RequestStartAdV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestStartAdV2);
    }

    public static Advertisementnew$RequestStartAdV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestStartAdV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestStartAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
