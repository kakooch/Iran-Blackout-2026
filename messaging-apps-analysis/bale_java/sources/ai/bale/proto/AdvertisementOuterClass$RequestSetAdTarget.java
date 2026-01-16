package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AdTargeting;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestSetAdTarget extends GeneratedMessageLite implements U64 {
    public static final int AD_ID_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestSetAdTarget DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TARGETING_FIELD_NUMBER = 2;
    private String adId_ = "";
    private int bitField0_;
    private AdvertisementStruct$AdTargeting targeting_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestSetAdTarget.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestSetAdTarget advertisementOuterClass$RequestSetAdTarget = new AdvertisementOuterClass$RequestSetAdTarget();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestSetAdTarget;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestSetAdTarget.class, advertisementOuterClass$RequestSetAdTarget);
    }

    private AdvertisementOuterClass$RequestSetAdTarget() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearTargeting() {
        this.targeting_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestSetAdTarget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTargeting(AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting) {
        advertisementStruct$AdTargeting.getClass();
        AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting2 = this.targeting_;
        if (advertisementStruct$AdTargeting2 == null || advertisementStruct$AdTargeting2 == AdvertisementStruct$AdTargeting.getDefaultInstance()) {
            this.targeting_ = advertisementStruct$AdTargeting;
        } else {
            this.targeting_ = (AdvertisementStruct$AdTargeting) ((AdvertisementStruct$AdTargeting.a) AdvertisementStruct$AdTargeting.newBuilder(this.targeting_).v(advertisementStruct$AdTargeting)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setTargeting(AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting) {
        advertisementStruct$AdTargeting.getClass();
        this.targeting_ = advertisementStruct$AdTargeting;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestSetAdTarget();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "adId_", "targeting_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestSetAdTarget.class) {
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

    public AdvertisementStruct$AdTargeting getTargeting() {
        AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting = this.targeting_;
        return advertisementStruct$AdTargeting == null ? AdvertisementStruct$AdTargeting.getDefaultInstance() : advertisementStruct$AdTargeting;
    }

    public boolean hasTargeting() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestSetAdTarget advertisementOuterClass$RequestSetAdTarget) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestSetAdTarget);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestSetAdTarget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetAdTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
