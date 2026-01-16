package ai.bale.proto;

import ai.bale.proto.FilesStruct$ImageLocation;
import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4704Gf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$BaleCustomAd extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 6;
    private static final AdvertisementStruct$BaleCustomAd DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 5;
    public static final int IMAGE_LOCATION_FIELD_NUMBER = 12;
    public static final int LINK_FIELD_NUMBER = 4;
    public static final int LINK_TITLE_FIELD_NUMBER = 9;
    public static final int OWNER_TYPE_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 10;
    public static final int PIC_FIELD_NUMBER = 1;
    public static final int TAG1_FIELD_NUMBER = 7;
    public static final int TAG2_FIELD_NUMBER = 8;
    public static final int TITLE_FIELD_NUMBER = 2;
    private long accessHash_;
    private int bitField0_;
    private FilesStruct$ImageLocation imageLocation_;
    private int ownerType_;
    private PeersStruct$OutExPeer peer_;
    private int tag1_;
    private int tag2_;
    private String pic_ = "";
    private String title_ = "";
    private String description_ = "";
    private String link_ = "";
    private String id_ = "";
    private String linkTitle_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$BaleCustomAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$BaleCustomAd advertisementStruct$BaleCustomAd = new AdvertisementStruct$BaleCustomAd();
        DEFAULT_INSTANCE = advertisementStruct$BaleCustomAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$BaleCustomAd.class, advertisementStruct$BaleCustomAd);
    }

    private AdvertisementStruct$BaleCustomAd() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearImageLocation() {
        this.imageLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearLinkTitle() {
        this.linkTitle_ = getDefaultInstance().getLinkTitle();
    }

    private void clearOwnerType() {
        this.ownerType_ = 0;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPic() {
        this.pic_ = getDefaultInstance().getPic();
    }

    private void clearTag1() {
        this.tag1_ = 0;
    }

    private void clearTag2() {
        this.tag2_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static AdvertisementStruct$BaleCustomAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeImageLocation(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.imageLocation_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.imageLocation_ = filesStruct$ImageLocation;
        } else {
            this.imageLocation_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.imageLocation_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.peer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutExPeer;
        } else {
            this.peer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.peer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$BaleCustomAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
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

    private void setImageLocation(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.imageLocation_ = filesStruct$ImageLocation;
        this.bitField0_ |= 1;
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

    private void setOwnerType(EnumC4704Gf enumC4704Gf) {
        this.ownerType_ = enumC4704Gf.getNumber();
    }

    private void setOwnerTypeValue(int i) {
        this.ownerType_ = i;
    }

    private void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 2;
    }

    private void setPic(String str) {
        str.getClass();
        this.pic_ = str;
    }

    private void setPicBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.pic_ = abstractC2383g.f0();
    }

    private void setTag1(int i) {
        this.tag1_ = i;
    }

    private void setTag2(int i) {
        this.tag2_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$BaleCustomAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0002\u0007\u0004\b\u0004\tȈ\nဉ\u0001\u000b\f\fဉ\u0000", new Object[]{"bitField0_", "pic_", "title_", "description_", "link_", "id_", "accessHash_", "tag1_", "tag2_", "linkTitle_", "peer_", "ownerType_", "imageLocation_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$BaleCustomAd.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
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

    public FilesStruct$ImageLocation getImageLocation() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.imageLocation_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
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

    public EnumC4704Gf getOwnerType() {
        EnumC4704Gf enumC4704GfJ = EnumC4704Gf.j(this.ownerType_);
        return enumC4704GfJ == null ? EnumC4704Gf.UNRECOGNIZED : enumC4704GfJ;
    }

    public int getOwnerTypeValue() {
        return this.ownerType_;
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public String getPic() {
        return this.pic_;
    }

    public AbstractC2383g getPicBytes() {
        return AbstractC2383g.N(this.pic_);
    }

    public int getTag1() {
        return this.tag1_;
    }

    public int getTag2() {
        return this.tag2_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasImageLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(AdvertisementStruct$BaleCustomAd advertisementStruct$BaleCustomAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$BaleCustomAd);
    }

    public static AdvertisementStruct$BaleCustomAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(byte[] bArr) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$BaleCustomAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
