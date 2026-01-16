package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
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
public final class AdvertisementOuterClass$RequestSetChannelInvoiceInfo extends GeneratedMessageLite implements U64 {
    public static final int ADDRESS_FIELD_NUMBER = 3;
    public static final int BIRTH_DATE_FIELD_NUMBER = 8;
    private static final AdvertisementOuterClass$RequestSetChannelInvoiceInfo DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 5;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 1;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int TAG1_FIELD_NUMBER = 6;
    public static final int TAG2_FIELD_NUMBER = 7;
    private int bitField0_;
    private PeersStruct$GroupOutPeer peerId_;
    private int tag1_;
    private int tag2_;
    private String nationalCode_ = "";
    private String address_ = "";
    private String postalCode_ = "";
    private String name_ = "";
    private String birthDate_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestSetChannelInvoiceInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestSetChannelInvoiceInfo advertisementOuterClass$RequestSetChannelInvoiceInfo = new AdvertisementOuterClass$RequestSetChannelInvoiceInfo();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestSetChannelInvoiceInfo;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestSetChannelInvoiceInfo.class, advertisementOuterClass$RequestSetChannelInvoiceInfo);
    }

    private AdvertisementOuterClass$RequestSetChannelInvoiceInfo() {
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearBirthDate() {
        this.birthDate_ = getDefaultInstance().getBirthDate();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearPeerId() {
        this.peerId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    private void clearTag1() {
        this.tag1_ = 0;
    }

    private void clearTag2() {
        this.tag2_ = 0;
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    private void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
    }

    private void setBirthDate(String str) {
        str.getClass();
        this.birthDate_ = str;
    }

    private void setBirthDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.birthDate_ = abstractC2383g.f0();
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setPeerId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.peerId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setPostalCode(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    private void setPostalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.postalCode_ = abstractC2383g.f0();
    }

    private void setTag1(int i) {
        this.tag1_ = i;
    }

    private void setTag2(int i) {
        this.tag2_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestSetChannelInvoiceInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007\u0004\bȈ", new Object[]{"bitField0_", "peerId_", "nationalCode_", "address_", "postalCode_", "name_", "tag1_", "tag2_", "birthDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestSetChannelInvoiceInfo.class) {
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

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    public String getBirthDate() {
        return this.birthDate_;
    }

    public AbstractC2383g getBirthDateBytes() {
        return AbstractC2383g.N(this.birthDate_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public PeersStruct$GroupOutPeer getPeerId() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.peerId_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public AbstractC2383g getPostalCodeBytes() {
        return AbstractC2383g.N(this.postalCode_);
    }

    public int getTag1() {
        return this.tag1_;
    }

    public int getTag2() {
        return this.tag2_;
    }

    public boolean hasPeerId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestSetChannelInvoiceInfo advertisementOuterClass$RequestSetChannelInvoiceInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestSetChannelInvoiceInfo);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestSetChannelInvoiceInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelInvoiceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
