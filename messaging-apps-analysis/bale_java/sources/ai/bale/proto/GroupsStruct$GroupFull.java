package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ai.bale.proto.PeersStruct$ExInfo;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.CS2;
import ir.nasim.EnumC7089Qf4;
import ir.nasim.EnumC8025Uf;
import ir.nasim.GS2;
import ir.nasim.InterfaceC23158wS2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@Deprecated
/* loaded from: classes9.dex */
public final class GroupsStruct$GroupFull extends GeneratedMessageLite implements InterfaceC23158wS2 {
    public static final int ABOUT_FIELD_NUMBER = 3;
    public static final int ADVERTISEMENT_TYPE_FIELD_NUMBER = 15;
    public static final int AVAILABLE_REACTIONS_FIELD_NUMBER = 19;
    public static final int CAN_INVITE_PEOPLE_FIELD_NUMBER = 8;
    public static final int CAN_VIEW_MEMBERS_FIELD_NUMBER = 7;
    public static final int CHANNEL_BANNER_AD_TAG_ID_FIELD_NUMBER = 18;
    public static final int CHANNEL_NATIVE_AD_TAG_ID_FIELD_NUMBER = 17;
    public static final int CREATE_DATE_FIELD_NUMBER = 5;
    private static final GroupsStruct$GroupFull DEFAULT_INSTANCE;
    public static final int EXT_FIELD_NUMBER = 6;
    public static final int EX_INFO_FIELD_NUMBER = 12;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_ASYNC_MEMBERS_FIELD_NUMBER = 10;
    public static final int IS_SHARED_HISTORY_FIELD_NUMBER = 9;
    public static final int IS_SUSPEND_FIELD_NUMBER = 20;
    public static final int MEMBERS_FIELD_NUMBER = 11;
    public static final int OWNER_UID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PIN_FIELD_NUMBER = 13;
    public static final int PRIVACY_BAR_MODE_FIELD_NUMBER = 21;
    public static final int RESTRICTION_FIELD_NUMBER = 14;
    public static final int THEME_FIELD_NUMBER = 2;
    private StringValue about_;
    private int advertisementType_;
    private int bitField0_;
    private BoolValue canInvitePeople_;
    private BoolValue canViewMembers_;
    private StringValue channelBannerAdTagId_;
    private StringValue channelNativeAdTagId_;
    private long createDate_;
    private PeersStruct$ExInfo exInfo_;
    private CollectionsStruct$MapValue ext_;
    private int id_;
    private BoolValue isAsyncMembers_;
    private BoolValue isSharedHistory_;
    private BoolValue isSuspend_;
    private int ownerUid_;
    private MessagingStruct$MessageContainer pin_;
    private int privacyBarMode_;
    private int restriction_;
    private StringValue theme_;
    private B.j members_ = GeneratedMessageLite.emptyProtobufList();
    private B.j availableReactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23158wS2 {
        private a() {
            super(GroupsStruct$GroupFull.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$GroupFull groupsStruct$GroupFull = new GroupsStruct$GroupFull();
        DEFAULT_INSTANCE = groupsStruct$GroupFull;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$GroupFull.class, groupsStruct$GroupFull);
    }

    private GroupsStruct$GroupFull() {
    }

    private void addAllAvailableReactions(Iterable<String> iterable) {
        ensureAvailableReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.availableReactions_);
    }

    private void addAllMembers(Iterable<? extends GroupsStruct$Member> iterable) {
        ensureMembersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.members_);
    }

    private void addAvailableReactions(String str) {
        str.getClass();
        ensureAvailableReactionsIsMutable();
        this.availableReactions_.add(str);
    }

    private void addAvailableReactionsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureAvailableReactionsIsMutable();
        this.availableReactions_.add(abstractC2383g.f0());
    }

    private void addMembers(GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembersIsMutable();
        this.members_.add(groupsStruct$Member);
    }

    private void clearAbout() {
        this.about_ = null;
        this.bitField0_ &= -3;
    }

    private void clearAdvertisementType() {
        this.advertisementType_ = 0;
    }

    private void clearAvailableReactions() {
        this.availableReactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearCanInvitePeople() {
        this.canInvitePeople_ = null;
        this.bitField0_ &= -17;
    }

    private void clearCanViewMembers() {
        this.canViewMembers_ = null;
        this.bitField0_ &= -9;
    }

    private void clearChannelBannerAdTagId() {
        this.channelBannerAdTagId_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearChannelNativeAdTagId() {
        this.channelNativeAdTagId_ = null;
        this.bitField0_ &= -513;
    }

    private void clearCreateDate() {
        this.createDate_ = 0L;
    }

    private void clearExInfo() {
        this.exInfo_ = null;
        this.bitField0_ &= -129;
    }

    private void clearExt() {
        this.ext_ = null;
        this.bitField0_ &= -5;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsAsyncMembers() {
        this.isAsyncMembers_ = null;
        this.bitField0_ &= -65;
    }

    private void clearIsSharedHistory() {
        this.isSharedHistory_ = null;
        this.bitField0_ &= -33;
    }

    private void clearIsSuspend() {
        this.isSuspend_ = null;
        this.bitField0_ &= -2049;
    }

    private void clearMembers() {
        this.members_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOwnerUid() {
        this.ownerUid_ = 0;
    }

    private void clearPin() {
        this.pin_ = null;
        this.bitField0_ &= -257;
    }

    private void clearPrivacyBarMode() {
        this.privacyBarMode_ = 0;
    }

    private void clearRestriction() {
        this.restriction_ = 0;
    }

    private void clearTheme() {
        this.theme_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureAvailableReactionsIsMutable() {
        B.j jVar = this.availableReactions_;
        if (jVar.u()) {
            return;
        }
        this.availableReactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureMembersIsMutable() {
        B.j jVar = this.members_;
        if (jVar.u()) {
            return;
        }
        this.members_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsStruct$GroupFull getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAbout(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.about_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.about_ = stringValue;
        } else {
            this.about_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.about_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeCanInvitePeople(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.canInvitePeople_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.canInvitePeople_ = boolValue;
        } else {
            this.canInvitePeople_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.canInvitePeople_).v(boolValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeCanViewMembers(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.canViewMembers_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.canViewMembers_ = boolValue;
        } else {
            this.canViewMembers_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.canViewMembers_).v(boolValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeChannelBannerAdTagId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.channelBannerAdTagId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.channelBannerAdTagId_ = stringValue;
        } else {
            this.channelBannerAdTagId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.channelBannerAdTagId_).v(stringValue)).j();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeChannelNativeAdTagId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.channelNativeAdTagId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.channelNativeAdTagId_ = stringValue;
        } else {
            this.channelNativeAdTagId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.channelNativeAdTagId_).v(stringValue)).j();
        }
        this.bitField0_ |= 512;
    }

    private void mergeExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        PeersStruct$ExInfo peersStruct$ExInfo2 = this.exInfo_;
        if (peersStruct$ExInfo2 == null || peersStruct$ExInfo2 == PeersStruct$ExInfo.getDefaultInstance()) {
            this.exInfo_ = peersStruct$ExInfo;
        } else {
            this.exInfo_ = (PeersStruct$ExInfo) ((PeersStruct$ExInfo.a) PeersStruct$ExInfo.newBuilder(this.exInfo_).v(peersStruct$ExInfo)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeExt(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.ext_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.ext_ = collectionsStruct$MapValue;
        } else {
            this.ext_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.ext_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeIsAsyncMembers(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isAsyncMembers_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isAsyncMembers_ = boolValue;
        } else {
            this.isAsyncMembers_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isAsyncMembers_).v(boolValue)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeIsSharedHistory(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isSharedHistory_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isSharedHistory_ = boolValue;
        } else {
            this.isSharedHistory_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isSharedHistory_).v(boolValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeIsSuspend(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isSuspend_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isSuspend_ = boolValue;
        } else {
            this.isSuspend_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isSuspend_).v(boolValue)).j();
        }
        this.bitField0_ |= 2048;
    }

    private void mergePin(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        MessagingStruct$MessageContainer messagingStruct$MessageContainer2 = this.pin_;
        if (messagingStruct$MessageContainer2 == null || messagingStruct$MessageContainer2 == MessagingStruct$MessageContainer.getDefaultInstance()) {
            this.pin_ = messagingStruct$MessageContainer;
        } else {
            this.pin_ = (MessagingStruct$MessageContainer) ((MessagingStruct$MessageContainer.a) MessagingStruct$MessageContainer.newBuilder(this.pin_).v(messagingStruct$MessageContainer)).j();
        }
        this.bitField0_ |= 256;
    }

    private void mergeTheme(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.theme_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.theme_ = stringValue;
        } else {
            this.theme_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.theme_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$GroupFull parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$GroupFull parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMembers(int i) {
        ensureMembersIsMutable();
        this.members_.remove(i);
    }

    private void setAbout(StringValue stringValue) {
        stringValue.getClass();
        this.about_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setAdvertisementType(EnumC8025Uf enumC8025Uf) {
        this.advertisementType_ = enumC8025Uf.getNumber();
    }

    private void setAdvertisementTypeValue(int i) {
        this.advertisementType_ = i;
    }

    private void setAvailableReactions(int i, String str) {
        str.getClass();
        ensureAvailableReactionsIsMutable();
        this.availableReactions_.set(i, str);
    }

    private void setCanInvitePeople(BoolValue boolValue) {
        boolValue.getClass();
        this.canInvitePeople_ = boolValue;
        this.bitField0_ |= 16;
    }

    private void setCanViewMembers(BoolValue boolValue) {
        boolValue.getClass();
        this.canViewMembers_ = boolValue;
        this.bitField0_ |= 8;
    }

    private void setChannelBannerAdTagId(StringValue stringValue) {
        stringValue.getClass();
        this.channelBannerAdTagId_ = stringValue;
        this.bitField0_ |= 1024;
    }

    private void setChannelNativeAdTagId(StringValue stringValue) {
        stringValue.getClass();
        this.channelNativeAdTagId_ = stringValue;
        this.bitField0_ |= 512;
    }

    private void setCreateDate(long j) {
        this.createDate_ = j;
    }

    private void setExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        this.exInfo_ = peersStruct$ExInfo;
        this.bitField0_ |= 128;
    }

    private void setExt(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.ext_ = collectionsStruct$MapValue;
        this.bitField0_ |= 4;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsAsyncMembers(BoolValue boolValue) {
        boolValue.getClass();
        this.isAsyncMembers_ = boolValue;
        this.bitField0_ |= 64;
    }

    private void setIsSharedHistory(BoolValue boolValue) {
        boolValue.getClass();
        this.isSharedHistory_ = boolValue;
        this.bitField0_ |= 32;
    }

    private void setIsSuspend(BoolValue boolValue) {
        boolValue.getClass();
        this.isSuspend_ = boolValue;
        this.bitField0_ |= 2048;
    }

    private void setMembers(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembersIsMutable();
        this.members_.set(i, groupsStruct$Member);
    }

    private void setOwnerUid(int i) {
        this.ownerUid_ = i;
    }

    private void setPin(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        this.pin_ = messagingStruct$MessageContainer;
        this.bitField0_ |= 256;
    }

    private void setPrivacyBarMode(EnumC7089Qf4 enumC7089Qf4) {
        this.privacyBarMode_ = enumC7089Qf4.getNumber();
    }

    private void setPrivacyBarModeValue(int i) {
        this.privacyBarMode_ = i;
    }

    private void setRestriction(GS2 gs2) {
        this.restriction_ = gs2.getNumber();
    }

    private void setRestrictionValue(int i) {
        this.restriction_ = i;
    }

    private void setTheme(StringValue stringValue) {
        stringValue.getClass();
        this.theme_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$GroupFull();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0014\u0000\u0001\u0001\u0015\u0014\u0000\u0002\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004\u0004\u0005\u0002\u0006ဉ\u0002\u0007ဉ\u0003\bဉ\u0004\tဉ\u0005\nဉ\u0006\u000b\u001b\fဉ\u0007\rဉ\b\u000e\f\u000f\f\u0011ဉ\t\u0012ဉ\n\u0013Ț\u0014ဉ\u000b\u0015\f", new Object[]{"bitField0_", "id_", "theme_", "about_", "ownerUid_", "createDate_", "ext_", "canViewMembers_", "canInvitePeople_", "isSharedHistory_", "isAsyncMembers_", "members_", GroupsStruct$Member.class, "exInfo_", "pin_", "restriction_", "advertisementType_", "channelNativeAdTagId_", "channelBannerAdTagId_", "availableReactions_", "isSuspend_", "privacyBarMode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$GroupFull.class) {
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

    @Deprecated
    public StringValue getAbout() {
        StringValue stringValue = this.about_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Deprecated
    public EnumC8025Uf getAdvertisementType() {
        EnumC8025Uf enumC8025UfJ = EnumC8025Uf.j(this.advertisementType_);
        return enumC8025UfJ == null ? EnumC8025Uf.UNRECOGNIZED : enumC8025UfJ;
    }

    @Deprecated
    public int getAdvertisementTypeValue() {
        return this.advertisementType_;
    }

    @Deprecated
    public String getAvailableReactions(int i) {
        return (String) this.availableReactions_.get(i);
    }

    @Deprecated
    public AbstractC2383g getAvailableReactionsBytes(int i) {
        return AbstractC2383g.N((String) this.availableReactions_.get(i));
    }

    @Deprecated
    public int getAvailableReactionsCount() {
        return this.availableReactions_.size();
    }

    @Deprecated
    public List<String> getAvailableReactionsList() {
        return this.availableReactions_;
    }

    @Deprecated
    public BoolValue getCanInvitePeople() {
        BoolValue boolValue = this.canInvitePeople_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    @Deprecated
    public BoolValue getCanViewMembers() {
        BoolValue boolValue = this.canViewMembers_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    @Deprecated
    public StringValue getChannelBannerAdTagId() {
        StringValue stringValue = this.channelBannerAdTagId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Deprecated
    public StringValue getChannelNativeAdTagId() {
        StringValue stringValue = this.channelNativeAdTagId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Deprecated
    public long getCreateDate() {
        return this.createDate_;
    }

    @Deprecated
    public PeersStruct$ExInfo getExInfo() {
        PeersStruct$ExInfo peersStruct$ExInfo = this.exInfo_;
        return peersStruct$ExInfo == null ? PeersStruct$ExInfo.getDefaultInstance() : peersStruct$ExInfo;
    }

    @Deprecated
    public CollectionsStruct$MapValue getExt() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.ext_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    @Deprecated
    public int getId() {
        return this.id_;
    }

    @Deprecated
    public BoolValue getIsAsyncMembers() {
        BoolValue boolValue = this.isAsyncMembers_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    @Deprecated
    public BoolValue getIsSharedHistory() {
        BoolValue boolValue = this.isSharedHistory_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    @Deprecated
    public BoolValue getIsSuspend() {
        BoolValue boolValue = this.isSuspend_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    @Deprecated
    public GroupsStruct$Member getMembers(int i) {
        return (GroupsStruct$Member) this.members_.get(i);
    }

    @Deprecated
    public int getMembersCount() {
        return this.members_.size();
    }

    @Deprecated
    public List<GroupsStruct$Member> getMembersList() {
        return this.members_;
    }

    @Deprecated
    public CS2 getMembersOrBuilder(int i) {
        return (CS2) this.members_.get(i);
    }

    @Deprecated
    public List<? extends CS2> getMembersOrBuilderList() {
        return this.members_;
    }

    @Deprecated
    public int getOwnerUid() {
        return this.ownerUid_;
    }

    @Deprecated
    public MessagingStruct$MessageContainer getPin() {
        MessagingStruct$MessageContainer messagingStruct$MessageContainer = this.pin_;
        return messagingStruct$MessageContainer == null ? MessagingStruct$MessageContainer.getDefaultInstance() : messagingStruct$MessageContainer;
    }

    @Deprecated
    public EnumC7089Qf4 getPrivacyBarMode() {
        EnumC7089Qf4 enumC7089Qf4J = EnumC7089Qf4.j(this.privacyBarMode_);
        return enumC7089Qf4J == null ? EnumC7089Qf4.UNRECOGNIZED : enumC7089Qf4J;
    }

    @Deprecated
    public int getPrivacyBarModeValue() {
        return this.privacyBarMode_;
    }

    @Deprecated
    public GS2 getRestriction() {
        GS2 gs2J = GS2.j(this.restriction_);
        return gs2J == null ? GS2.UNRECOGNIZED : gs2J;
    }

    @Deprecated
    public int getRestrictionValue() {
        return this.restriction_;
    }

    @Deprecated
    public StringValue getTheme() {
        StringValue stringValue = this.theme_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Deprecated
    public boolean hasAbout() {
        return (this.bitField0_ & 2) != 0;
    }

    @Deprecated
    public boolean hasCanInvitePeople() {
        return (this.bitField0_ & 16) != 0;
    }

    @Deprecated
    public boolean hasCanViewMembers() {
        return (this.bitField0_ & 8) != 0;
    }

    @Deprecated
    public boolean hasChannelBannerAdTagId() {
        return (this.bitField0_ & 1024) != 0;
    }

    @Deprecated
    public boolean hasChannelNativeAdTagId() {
        return (this.bitField0_ & 512) != 0;
    }

    @Deprecated
    public boolean hasExInfo() {
        return (this.bitField0_ & 128) != 0;
    }

    @Deprecated
    public boolean hasExt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Deprecated
    public boolean hasIsAsyncMembers() {
        return (this.bitField0_ & 64) != 0;
    }

    @Deprecated
    public boolean hasIsSharedHistory() {
        return (this.bitField0_ & 32) != 0;
    }

    @Deprecated
    public boolean hasIsSuspend() {
        return (this.bitField0_ & 2048) != 0;
    }

    @Deprecated
    public boolean hasPin() {
        return (this.bitField0_ & 256) != 0;
    }

    @Deprecated
    public boolean hasTheme() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsStruct$GroupFull groupsStruct$GroupFull) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$GroupFull);
    }

    public static GroupsStruct$GroupFull parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$GroupFull parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$GroupFull parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMembers(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembersIsMutable();
        this.members_.add(i, groupsStruct$Member);
    }

    public static GroupsStruct$GroupFull parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$GroupFull parseFrom(byte[] bArr) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$GroupFull parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$GroupFull parseFrom(InputStream inputStream) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$GroupFull parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$GroupFull parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$GroupFull parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$GroupFull) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
