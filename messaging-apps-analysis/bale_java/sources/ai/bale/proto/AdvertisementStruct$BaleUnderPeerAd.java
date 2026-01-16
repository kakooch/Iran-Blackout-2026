package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
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
public final class AdvertisementStruct$BaleUnderPeerAd extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$BaleUnderPeerAd DEFAULT_INSTANCE;
    public static final int EXPIRE_TIME_FIELD_NUMBER = 4;
    public static final int FILE_LOCATION_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LINK_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private long expireTime_;
    private FilesStruct$FileLocation fileLocation_;
    private String id_ = "";
    private String link_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$BaleUnderPeerAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$BaleUnderPeerAd advertisementStruct$BaleUnderPeerAd = new AdvertisementStruct$BaleUnderPeerAd();
        DEFAULT_INSTANCE = advertisementStruct$BaleUnderPeerAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$BaleUnderPeerAd.class, advertisementStruct$BaleUnderPeerAd);
    }

    private AdvertisementStruct$BaleUnderPeerAd() {
    }

    private void clearExpireTime() {
        this.expireTime_ = 0L;
    }

    private void clearFileLocation() {
        this.fileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    public static AdvertisementStruct$BaleUnderPeerAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.fileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.fileLocation_ = filesStruct$FileLocation;
        } else {
            this.fileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.fileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExpireTime(long j) {
        this.expireTime_ = j;
    }

    private void setFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.fileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$BaleUnderPeerAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003Ȉ\u0004\u0002", new Object[]{"bitField0_", "id_", "fileLocation_", "link_", "expireTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$BaleUnderPeerAd.class) {
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

    public long getExpireTime() {
        return this.expireTime_;
    }

    public FilesStruct$FileLocation getFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.fileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
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

    public boolean hasFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$BaleUnderPeerAd advertisementStruct$BaleUnderPeerAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$BaleUnderPeerAd);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(byte[] bArr) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$BaleUnderPeerAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$BaleUnderPeerAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
