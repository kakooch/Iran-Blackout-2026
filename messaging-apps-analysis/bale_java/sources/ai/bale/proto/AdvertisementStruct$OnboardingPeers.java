package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC15129j35;
import ir.nasim.InterfaceC21521th;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$OnboardingPeers extends GeneratedMessageLite implements InterfaceC21521th {
    public static final int CALL_TO_ACTION_TXT_FIELD_NUMBER = 5;
    private static final AdvertisementStruct$OnboardingPeers DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int IS_STARTED_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int PEER_IDENTITY_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int bitField0_;
    private boolean isStarted_;
    private int peerIdentity_;
    private PeersStruct$ExPeer peer_;
    private String title_ = "";
    private String description_ = "";
    private String callToActionTxt_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC21521th {
        private a() {
            super(AdvertisementStruct$OnboardingPeers.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$OnboardingPeers advertisementStruct$OnboardingPeers = new AdvertisementStruct$OnboardingPeers();
        DEFAULT_INSTANCE = advertisementStruct$OnboardingPeers;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$OnboardingPeers.class, advertisementStruct$OnboardingPeers);
    }

    private AdvertisementStruct$OnboardingPeers() {
    }

    private void clearCallToActionTxt() {
        this.callToActionTxt_ = getDefaultInstance().getCallToActionTxt();
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearIsStarted() {
        this.isStarted_ = false;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPeerIdentity() {
        this.peerIdentity_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static AdvertisementStruct$OnboardingPeers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$ExPeer;
        } else {
            this.peer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$OnboardingPeers parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallToActionTxt(String str) {
        str.getClass();
        this.callToActionTxt_ = str;
    }

    private void setCallToActionTxtBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.callToActionTxt_ = abstractC2383g.f0();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setIsStarted(boolean z) {
        this.isStarted_ = z;
    }

    private void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setPeerIdentity(EnumC15129j35 enumC15129j35) {
        this.peerIdentity_ = enumC15129j35.getNumber();
    }

    private void setPeerIdentityValue(int i) {
        this.peerIdentity_ = i;
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
                return new AdvertisementStruct$OnboardingPeers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0007", new Object[]{"bitField0_", "peer_", "peerIdentity_", "title_", "description_", "callToActionTxt_", "isStarted_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$OnboardingPeers.class) {
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

    public String getCallToActionTxt() {
        return this.callToActionTxt_;
    }

    public AbstractC2383g getCallToActionTxtBytes() {
        return AbstractC2383g.N(this.callToActionTxt_);
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public boolean getIsStarted() {
        return this.isStarted_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public EnumC15129j35 getPeerIdentity() {
        EnumC15129j35 enumC15129j35J = EnumC15129j35.j(this.peerIdentity_);
        return enumC15129j35J == null ? EnumC15129j35.UNRECOGNIZED : enumC15129j35J;
    }

    public int getPeerIdentityValue() {
        return this.peerIdentity_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$OnboardingPeers advertisementStruct$OnboardingPeers) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$OnboardingPeers);
    }

    public static AdvertisementStruct$OnboardingPeers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(byte[] bArr) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$OnboardingPeers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
