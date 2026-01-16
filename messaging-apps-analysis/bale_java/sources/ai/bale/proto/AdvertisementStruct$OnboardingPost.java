package ai.bale.proto;

import ai.bale.proto.FilesStruct$ImageLocation;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22701vh;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$OnboardingPost extends GeneratedMessageLite implements InterfaceC22701vh {
    public static final int AVATAR_FIELD_NUMBER = 6;
    private static final AdvertisementStruct$OnboardingPost DEFAULT_INSTANCE;
    public static final int MEMBERS_COUNT_FIELD_NUMBER = 4;
    public static final int MESSAGE_FIELD_NUMBER = 5;
    public static final int NICKNAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int TITLE_FIELD_NUMBER = 3;
    private FilesStruct$ImageLocation avatar_;
    private int bitField0_;
    private int membersCount_;
    private MessagingStruct$MessageContainer message_;
    private PeersStruct$ExPeer peer_;
    private String nickname_ = "";
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22701vh {
        private a() {
            super(AdvertisementStruct$OnboardingPost.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$OnboardingPost advertisementStruct$OnboardingPost = new AdvertisementStruct$OnboardingPost();
        DEFAULT_INSTANCE = advertisementStruct$OnboardingPost;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$OnboardingPost.class, advertisementStruct$OnboardingPost);
    }

    private AdvertisementStruct$OnboardingPost() {
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -5;
    }

    private void clearMembersCount() {
        this.membersCount_ = 0;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    private void clearNickname() {
        this.nickname_ = getDefaultInstance().getNickname();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static AdvertisementStruct$OnboardingPost getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAvatar(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.avatar_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.avatar_ = filesStruct$ImageLocation;
        } else {
            this.avatar_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.avatar_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeMessage(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        MessagingStruct$MessageContainer messagingStruct$MessageContainer2 = this.message_;
        if (messagingStruct$MessageContainer2 == null || messagingStruct$MessageContainer2 == MessagingStruct$MessageContainer.getDefaultInstance()) {
            this.message_ = messagingStruct$MessageContainer;
        } else {
            this.message_ = (MessagingStruct$MessageContainer) ((MessagingStruct$MessageContainer.a) MessagingStruct$MessageContainer.newBuilder(this.message_).v(messagingStruct$MessageContainer)).j();
        }
        this.bitField0_ |= 2;
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

    public static AdvertisementStruct$OnboardingPost parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvatar(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.avatar_ = filesStruct$ImageLocation;
        this.bitField0_ |= 4;
    }

    private void setMembersCount(int i) {
        this.membersCount_ = i;
    }

    private void setMessage(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        this.message_ = messagingStruct$MessageContainer;
        this.bitField0_ |= 2;
    }

    private void setNickname(String str) {
        str.getClass();
        this.nickname_ = str;
    }

    private void setNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nickname_ = abstractC2383g.f0();
    }

    private void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
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
                return new AdvertisementStruct$OnboardingPost();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003Ȉ\u0004\u0004\u0005ဉ\u0001\u0006ဉ\u0002", new Object[]{"bitField0_", "peer_", "nickname_", "title_", "membersCount_", "message_", "avatar_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$OnboardingPost.class) {
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

    public FilesStruct$ImageLocation getAvatar() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.avatar_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public int getMembersCount() {
        return this.membersCount_;
    }

    public MessagingStruct$MessageContainer getMessage() {
        MessagingStruct$MessageContainer messagingStruct$MessageContainer = this.message_;
        return messagingStruct$MessageContainer == null ? MessagingStruct$MessageContainer.getDefaultInstance() : messagingStruct$MessageContainer;
    }

    public String getNickname() {
        return this.nickname_;
    }

    public AbstractC2383g getNicknameBytes() {
        return AbstractC2383g.N(this.nickname_);
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$OnboardingPost advertisementStruct$OnboardingPost) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$OnboardingPost);
    }

    public static AdvertisementStruct$OnboardingPost parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(byte[] bArr) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$OnboardingPost parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$OnboardingPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
