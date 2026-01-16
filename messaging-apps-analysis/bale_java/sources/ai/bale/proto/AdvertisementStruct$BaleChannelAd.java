package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutExPeer;
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
public final class AdvertisementStruct$BaleChannelAd extends GeneratedMessageLite implements U64 {
    public static final int AD_TITLE_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$BaleChannelAd DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 5;
    public static final int LINK_FIELD_NUMBER = 4;
    public static final int LINK_TITLE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 9;
    public static final int TAG1_FIELD_NUMBER = 7;
    public static final int TAG2_FIELD_NUMBER = 8;
    private int bitField0_;
    private PeersStruct$OutExPeer peer_;
    private int tag1_;
    private int tag2_;
    private String adTitle_ = "";
    private String description_ = "";
    private String linkTitle_ = "";
    private String link_ = "";
    private String id_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$BaleChannelAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$BaleChannelAd advertisementStruct$BaleChannelAd = new AdvertisementStruct$BaleChannelAd();
        DEFAULT_INSTANCE = advertisementStruct$BaleChannelAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$BaleChannelAd.class, advertisementStruct$BaleChannelAd);
    }

    private AdvertisementStruct$BaleChannelAd() {
    }

    private void clearAdTitle() {
        this.adTitle_ = getDefaultInstance().getAdTitle();
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearLinkTitle() {
        this.linkTitle_ = getDefaultInstance().getLinkTitle();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTag1() {
        this.tag1_ = 0;
    }

    private void clearTag2() {
        this.tag2_ = 0;
    }

    public static AdvertisementStruct$BaleChannelAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.peer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutExPeer;
        } else {
            this.peer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.peer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$BaleChannelAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdTitle(String str) {
        str.getClass();
        this.adTitle_ = str;
    }

    private void setAdTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.adTitle_ = abstractC2383g.f0();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setLinkTitle(String str) {
        str.getClass();
        this.linkTitle_ = str;
    }

    private void setLinkTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.linkTitle_ = abstractC2383g.f0();
    }

    private void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    private void setTag1(int i) {
        this.tag1_ = i;
    }

    private void setTag2(int i) {
        this.tag2_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$BaleChannelAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\t\b\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0007\u0004\b\u0004\tဉ\u0000", new Object[]{"bitField0_", "adTitle_", "description_", "linkTitle_", "link_", "id_", "tag1_", "tag2_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$BaleChannelAd.class) {
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

    public String getAdTitle() {
        return this.adTitle_;
    }

    public AbstractC2383g getAdTitleBytes() {
        return AbstractC2383g.N(this.adTitle_);
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public String getLinkTitle() {
        return this.linkTitle_;
    }

    public AbstractC2383g getLinkTitleBytes() {
        return AbstractC2383g.N(this.linkTitle_);
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public int getTag1() {
        return this.tag1_;
    }

    public int getTag2() {
        return this.tag2_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$BaleChannelAd advertisementStruct$BaleChannelAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$BaleChannelAd);
    }

    public static AdvertisementStruct$BaleChannelAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(byte[] bArr) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$BaleChannelAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$BaleChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
