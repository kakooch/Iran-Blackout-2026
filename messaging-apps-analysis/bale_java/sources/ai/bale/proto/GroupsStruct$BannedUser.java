package ai.bale.proto;

import ai.bale.proto.PeersStruct$UserOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16540lS2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsStruct$BannedUser extends GeneratedMessageLite implements InterfaceC16540lS2 {
    public static final int BANNED_USER_FIELD_NUMBER = 1;
    public static final int BANNER_USER_FIELD_NUMBER = 2;
    private static final GroupsStruct$BannedUser DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private PeersStruct$UserOutPeer bannedUser_;
    private PeersStruct$UserOutPeer bannerUser_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC16540lS2 {
        private a() {
            super(GroupsStruct$BannedUser.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$BannedUser groupsStruct$BannedUser = new GroupsStruct$BannedUser();
        DEFAULT_INSTANCE = groupsStruct$BannedUser;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$BannedUser.class, groupsStruct$BannedUser);
    }

    private GroupsStruct$BannedUser() {
    }

    private void clearBannedUser() {
        this.bannedUser_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBannerUser() {
        this.bannerUser_ = null;
        this.bitField0_ &= -3;
    }

    public static GroupsStruct$BannedUser getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBannedUser(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.bannedUser_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.bannedUser_ = peersStruct$UserOutPeer;
        } else {
            this.bannedUser_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.bannedUser_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeBannerUser(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.bannerUser_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.bannerUser_ = peersStruct$UserOutPeer;
        } else {
            this.bannerUser_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.bannerUser_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$BannedUser parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$BannedUser parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBannedUser(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.bannedUser_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 1;
    }

    private void setBannerUser(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.bannerUser_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$BannedUser();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "bannedUser_", "bannerUser_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$BannedUser.class) {
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

    public PeersStruct$UserOutPeer getBannedUser() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.bannedUser_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public PeersStruct$UserOutPeer getBannerUser() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.bannerUser_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public boolean hasBannedUser() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasBannerUser() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsStruct$BannedUser groupsStruct$BannedUser) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$BannedUser);
    }

    public static GroupsStruct$BannedUser parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$BannedUser parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$BannedUser parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$BannedUser parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$BannedUser parseFrom(byte[] bArr) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$BannedUser parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$BannedUser parseFrom(InputStream inputStream) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$BannedUser parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$BannedUser parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$BannedUser parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$BannedUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
