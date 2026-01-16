package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20241rh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetOnboardingPosts extends GeneratedMessageLite implements U64 {
    public static final int CATEGORYID_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestGetOnboardingPosts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int categoryId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetOnboardingPosts.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetOnboardingPosts advertisementOuterClass$RequestGetOnboardingPosts = new AdvertisementOuterClass$RequestGetOnboardingPosts();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetOnboardingPosts;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetOnboardingPosts.class, advertisementOuterClass$RequestGetOnboardingPosts);
    }

    private AdvertisementOuterClass$RequestGetOnboardingPosts() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryId(EnumC20241rh enumC20241rh) {
        this.categoryId_ = enumC20241rh.getNumber();
    }

    private void setCategoryIdValue(int i) {
        this.categoryId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetOnboardingPosts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"categoryId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetOnboardingPosts.class) {
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

    public EnumC20241rh getCategoryId() {
        EnumC20241rh enumC20241rhJ = EnumC20241rh.j(this.categoryId_);
        return enumC20241rhJ == null ? EnumC20241rh.UNRECOGNIZED : enumC20241rhJ;
    }

    public int getCategoryIdValue() {
        return this.categoryId_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetOnboardingPosts advertisementOuterClass$RequestGetOnboardingPosts) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetOnboardingPosts);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingPosts parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
