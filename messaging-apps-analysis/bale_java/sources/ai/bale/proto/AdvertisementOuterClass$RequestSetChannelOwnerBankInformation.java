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
public final class AdvertisementOuterClass$RequestSetChannelOwnerBankInformation extends GeneratedMessageLite implements U64 {
    public static final int ADDRESS_FIELD_NUMBER = 4;
    public static final int BIRTH_DATE_FIELD_NUMBER = 3;
    public static final int CHANNEL_ID_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestSetChannelOwnerBankInformation DEFAULT_INSTANCE;
    public static final int MELLI_ACCOUNT_NUMBER_FIELD_NUMBER = 6;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 5;
    private int bitField0_;
    private PeersStruct$GroupOutPeer channelId_;
    private String nationalCode_ = "";
    private String birthDate_ = "";
    private String address_ = "";
    private String postalCode_ = "";
    private String melliAccountNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestSetChannelOwnerBankInformation.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestSetChannelOwnerBankInformation advertisementOuterClass$RequestSetChannelOwnerBankInformation = new AdvertisementOuterClass$RequestSetChannelOwnerBankInformation();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestSetChannelOwnerBankInformation;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestSetChannelOwnerBankInformation.class, advertisementOuterClass$RequestSetChannelOwnerBankInformation);
    }

    private AdvertisementOuterClass$RequestSetChannelOwnerBankInformation() {
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearBirthDate() {
        this.birthDate_ = getDefaultInstance().getBirthDate();
    }

    private void clearChannelId() {
        this.channelId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMelliAccountNumber() {
        this.melliAccountNumber_ = getDefaultInstance().getMelliAccountNumber();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeChannelId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.channelId_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.channelId_ = peersStruct$GroupOutPeer;
        } else {
            this.channelId_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.channelId_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setChannelId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.channelId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setMelliAccountNumber(String str) {
        str.getClass();
        this.melliAccountNumber_ = str;
    }

    private void setMelliAccountNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.melliAccountNumber_ = abstractC2383g.f0();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setPostalCode(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    private void setPostalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.postalCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestSetChannelOwnerBankInformation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ", new Object[]{"bitField0_", "channelId_", "nationalCode_", "birthDate_", "address_", "postalCode_", "melliAccountNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation.class) {
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

    public PeersStruct$GroupOutPeer getChannelId() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.channelId_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public String getMelliAccountNumber() {
        return this.melliAccountNumber_;
    }

    public AbstractC2383g getMelliAccountNumberBytes() {
        return AbstractC2383g.N(this.melliAccountNumber_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public AbstractC2383g getPostalCodeBytes() {
        return AbstractC2383g.N(this.postalCode_);
    }

    public boolean hasChannelId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestSetChannelOwnerBankInformation advertisementOuterClass$RequestSetChannelOwnerBankInformation) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestSetChannelOwnerBankInformation);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestSetChannelOwnerBankInformation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSetChannelOwnerBankInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
