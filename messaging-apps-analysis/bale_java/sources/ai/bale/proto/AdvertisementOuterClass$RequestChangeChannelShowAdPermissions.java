package ai.bale.proto;

import ai.bale.proto.AdvertisementOuterClass$RequestCategoryFilter;
import ai.bale.proto.AdvertisementOuterClass$RequestShowAds;
import ai.bale.proto.AdvertisementOuterClass$RequestTimeRestrict;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestChangeChannelShowAdPermissions extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_FILTER_FIELD_NUMBER = 4;
    private static final AdvertisementOuterClass$RequestChangeChannelShowAdPermissions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 1;
    public static final int SHOW_ADS_FIELD_NUMBER = 2;
    public static final int TIME_RESTRICT_FIELD_NUMBER = 3;
    private int bitField0_;
    private PeersStruct$GroupOutPeer peerId_;
    private int requestCase_ = 0;
    private Object request_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestChangeChannelShowAdPermissions.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SHOW_ADS(2),
        TIME_RESTRICT(3),
        CATEGORY_FILTER(4),
        REQUEST_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return REQUEST_NOT_SET;
            }
            if (i == 2) {
                return SHOW_ADS;
            }
            if (i == 3) {
                return TIME_RESTRICT;
            }
            if (i != 4) {
                return null;
            }
            return CATEGORY_FILTER;
        }
    }

    static {
        AdvertisementOuterClass$RequestChangeChannelShowAdPermissions advertisementOuterClass$RequestChangeChannelShowAdPermissions = new AdvertisementOuterClass$RequestChangeChannelShowAdPermissions();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestChangeChannelShowAdPermissions;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestChangeChannelShowAdPermissions.class, advertisementOuterClass$RequestChangeChannelShowAdPermissions);
    }

    private AdvertisementOuterClass$RequestChangeChannelShowAdPermissions() {
    }

    private void clearCategoryFilter() {
        if (this.requestCase_ == 4) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    private void clearPeerId() {
        this.peerId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRequest() {
        this.requestCase_ = 0;
        this.request_ = null;
    }

    private void clearShowAds() {
        if (this.requestCase_ == 2) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    private void clearTimeRestrict() {
        if (this.requestCase_ == 3) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCategoryFilter(AdvertisementOuterClass$RequestCategoryFilter advertisementOuterClass$RequestCategoryFilter) {
        advertisementOuterClass$RequestCategoryFilter.getClass();
        if (this.requestCase_ != 4 || this.request_ == AdvertisementOuterClass$RequestCategoryFilter.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestCategoryFilter;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestCategoryFilter.a) AdvertisementOuterClass$RequestCategoryFilter.newBuilder((AdvertisementOuterClass$RequestCategoryFilter) this.request_).v(advertisementOuterClass$RequestCategoryFilter)).j();
        }
        this.requestCase_ = 4;
    }

    private void mergePeerId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.peerId_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.peerId_ = peersStruct$GroupOutPeer;
        } else {
            this.peerId_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.peerId_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeShowAds(AdvertisementOuterClass$RequestShowAds advertisementOuterClass$RequestShowAds) {
        advertisementOuterClass$RequestShowAds.getClass();
        if (this.requestCase_ != 2 || this.request_ == AdvertisementOuterClass$RequestShowAds.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestShowAds;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestShowAds.a) AdvertisementOuterClass$RequestShowAds.newBuilder((AdvertisementOuterClass$RequestShowAds) this.request_).v(advertisementOuterClass$RequestShowAds)).j();
        }
        this.requestCase_ = 2;
    }

    private void mergeTimeRestrict(AdvertisementOuterClass$RequestTimeRestrict advertisementOuterClass$RequestTimeRestrict) {
        advertisementOuterClass$RequestTimeRestrict.getClass();
        if (this.requestCase_ != 3 || this.request_ == AdvertisementOuterClass$RequestTimeRestrict.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestTimeRestrict;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestTimeRestrict.a) AdvertisementOuterClass$RequestTimeRestrict.newBuilder((AdvertisementOuterClass$RequestTimeRestrict) this.request_).v(advertisementOuterClass$RequestTimeRestrict)).j();
        }
        this.requestCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryFilter(AdvertisementOuterClass$RequestCategoryFilter advertisementOuterClass$RequestCategoryFilter) {
        advertisementOuterClass$RequestCategoryFilter.getClass();
        this.request_ = advertisementOuterClass$RequestCategoryFilter;
        this.requestCase_ = 4;
    }

    private void setPeerId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.peerId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setShowAds(AdvertisementOuterClass$RequestShowAds advertisementOuterClass$RequestShowAds) {
        advertisementOuterClass$RequestShowAds.getClass();
        this.request_ = advertisementOuterClass$RequestShowAds;
        this.requestCase_ = 2;
    }

    private void setTimeRestrict(AdvertisementOuterClass$RequestTimeRestrict advertisementOuterClass$RequestTimeRestrict) {
        advertisementOuterClass$RequestTimeRestrict.getClass();
        this.request_ = advertisementOuterClass$RequestTimeRestrict;
        this.requestCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestChangeChannelShowAdPermissions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"request_", "requestCase_", "bitField0_", "peerId_", AdvertisementOuterClass$RequestShowAds.class, AdvertisementOuterClass$RequestTimeRestrict.class, AdvertisementOuterClass$RequestCategoryFilter.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions.class) {
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

    public AdvertisementOuterClass$RequestCategoryFilter getCategoryFilter() {
        return this.requestCase_ == 4 ? (AdvertisementOuterClass$RequestCategoryFilter) this.request_ : AdvertisementOuterClass$RequestCategoryFilter.getDefaultInstance();
    }

    public PeersStruct$GroupOutPeer getPeerId() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.peerId_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public b getRequestCase() {
        return b.j(this.requestCase_);
    }

    public AdvertisementOuterClass$RequestShowAds getShowAds() {
        return this.requestCase_ == 2 ? (AdvertisementOuterClass$RequestShowAds) this.request_ : AdvertisementOuterClass$RequestShowAds.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestTimeRestrict getTimeRestrict() {
        return this.requestCase_ == 3 ? (AdvertisementOuterClass$RequestTimeRestrict) this.request_ : AdvertisementOuterClass$RequestTimeRestrict.getDefaultInstance();
    }

    public boolean hasCategoryFilter() {
        return this.requestCase_ == 4;
    }

    public boolean hasPeerId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasShowAds() {
        return this.requestCase_ == 2;
    }

    public boolean hasTimeRestrict() {
        return this.requestCase_ == 3;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestChangeChannelShowAdPermissions advertisementOuterClass$RequestChangeChannelShowAdPermissions) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestChangeChannelShowAdPermissions);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestChangeChannelShowAdPermissions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
