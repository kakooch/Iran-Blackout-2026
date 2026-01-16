package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.GroupsStruct$Permissions;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ai.bale.proto.PeersStruct$ExInfo;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.CS2;
import ir.nasim.EnumC24932zS2;
import ir.nasim.EnumC7089Qf4;
import ir.nasim.EnumC8025Uf;
import ir.nasim.GS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsStruct$FullGroup extends GeneratedMessageLite implements U64 {
    public static final int ABOUT_FIELD_NUMBER = 16;
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    public static final int ADVERTISEMENT_TYPE_FIELD_NUMBER = 21;
    public static final int AVAILABLE_REACTIONS_FIELD_NUMBER = 24;
    public static final int AVATAR_FIELD_NUMBER = 4;
    public static final int BECAME_ORPHANED_FIELD_NUMBER = 12;
    public static final int CHANNEL_BANNER_AD_TAG_ID_FIELD_NUMBER = 23;
    public static final int CHANNEL_NATIVE_AD_TAG_ID_FIELD_NUMBER = 22;
    public static final int CREATE_DATE_FIELD_NUMBER = 6;
    private static final GroupsStruct$FullGroup DEFAULT_INSTANCE;
    public static final int DEFAULT_PERMISSIONS_FIELD_NUMBER = 14;
    public static final int DISCUSSION_GROUP_ENABLED_FIELD_NUMBER = 27;
    public static final int EXT_FIELD_NUMBER = 9;
    public static final int EX_INFO_FIELD_NUMBER = 18;
    public static final int GROUP_TYPE_FIELD_NUMBER = 7;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_MEMBER_FIELD_NUMBER = 8;
    public static final int IS_SUSPEND_FIELD_NUMBER = 25;
    public static final int LINKED_GROUP_PEER_ID_FIELD_NUMBER = 26;
    public static final int MEMBERS_COUNT_FIELD_NUMBER = 10;
    public static final int MEMBERS_FIELD_NUMBER = 17;
    public static final int NICK_FIELD_NUMBER = 11;
    public static final int OWNER_UID_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PERMISSIONS_FIELD_NUMBER = 13;
    public static final int PIN_FIELD_NUMBER = 19;
    public static final int PRIVACY_BAR_MODE_FIELD_NUMBER = 28;
    public static final int RESTRICTION_FIELD_NUMBER = 20;
    public static final int THEME_FIELD_NUMBER = 15;
    public static final int TITLE_FIELD_NUMBER = 3;
    private StringValue about_;
    private long accessHash_;
    private int advertisementType_;
    private FilesStruct$Avatar avatar_;
    private BoolValue becameOrphaned_;
    private int bitField0_;
    private StringValue channelBannerAdTagId_;
    private StringValue channelNativeAdTagId_;
    private long createDate_;
    private GroupsStruct$Permissions defaultPermissions_;
    private BoolValue discussionGroupEnabled_;
    private PeersStruct$ExInfo exInfo_;
    private CollectionsStruct$MapValue ext_;
    private int groupType_;
    private int id_;
    private BoolValue isMember_;
    private BoolValue isSuspend_;
    private Int32Value linkedGroupPeerId_;
    private Int32Value membersCount10_;
    private StringValue nick_;
    private int ownerUid_;
    private GroupsStruct$Permissions permissions_;
    private MessagingStruct$MessageContainer pin_;
    private int privacyBarMode_;
    private int restriction_;
    private StringValue theme_;
    private String title_ = "";
    private B.j members17_ = GeneratedMessageLite.emptyProtobufList();
    private B.j availableReactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsStruct$FullGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$FullGroup groupsStruct$FullGroup = new GroupsStruct$FullGroup();
        DEFAULT_INSTANCE = groupsStruct$FullGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$FullGroup.class, groupsStruct$FullGroup);
    }

    private GroupsStruct$FullGroup() {
    }

    private void addAllAvailableReactions(Iterable<String> iterable) {
        ensureAvailableReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.availableReactions_);
    }

    private void addAllMembers17(Iterable<? extends GroupsStruct$Member> iterable) {
        ensureMembers17IsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.members17_);
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

    private void addMembers17(GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembers17IsMutable();
        this.members17_.add(groupsStruct$Member);
    }

    private void clearAbout() {
        this.about_ = null;
        this.bitField0_ &= -513;
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearAdvertisementType() {
        this.advertisementType_ = 0;
    }

    private void clearAvailableReactions() {
        this.availableReactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBecameOrphaned() {
        this.becameOrphaned_ = null;
        this.bitField0_ &= -33;
    }

    private void clearChannelBannerAdTagId() {
        this.channelBannerAdTagId_ = null;
        this.bitField0_ &= -8193;
    }

    private void clearChannelNativeAdTagId() {
        this.channelNativeAdTagId_ = null;
        this.bitField0_ &= -4097;
    }

    private void clearCreateDate() {
        this.createDate_ = 0L;
    }

    private void clearDefaultPermissions() {
        this.defaultPermissions_ = null;
        this.bitField0_ &= -129;
    }

    private void clearDiscussionGroupEnabled() {
        this.discussionGroupEnabled_ = null;
        this.bitField0_ &= -65537;
    }

    private void clearExInfo() {
        this.exInfo_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearExt() {
        this.ext_ = null;
        this.bitField0_ &= -5;
    }

    private void clearGroupType() {
        this.groupType_ = 0;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsMember() {
        this.isMember_ = null;
        this.bitField0_ &= -3;
    }

    private void clearIsSuspend() {
        this.isSuspend_ = null;
        this.bitField0_ &= -16385;
    }

    private void clearLinkedGroupPeerId() {
        this.linkedGroupPeerId_ = null;
        this.bitField0_ &= -32769;
    }

    private void clearMembers17() {
        this.members17_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMembersCount10() {
        this.membersCount10_ = null;
        this.bitField0_ &= -9;
    }

    private void clearNick() {
        this.nick_ = null;
        this.bitField0_ &= -17;
    }

    private void clearOwnerUid() {
        this.ownerUid_ = 0;
    }

    private void clearPermissions() {
        this.permissions_ = null;
        this.bitField0_ &= -65;
    }

    private void clearPin() {
        this.pin_ = null;
        this.bitField0_ &= -2049;
    }

    private void clearPrivacyBarMode() {
        this.privacyBarMode_ = 0;
    }

    private void clearRestriction() {
        this.restriction_ = 0;
    }

    private void clearTheme() {
        this.theme_ = null;
        this.bitField0_ &= -257;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void ensureAvailableReactionsIsMutable() {
        B.j jVar = this.availableReactions_;
        if (jVar.u()) {
            return;
        }
        this.availableReactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureMembers17IsMutable() {
        B.j jVar = this.members17_;
        if (jVar.u()) {
            return;
        }
        this.members17_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsStruct$FullGroup getDefaultInstance() {
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
        this.bitField0_ |= 512;
    }

    private void mergeAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        FilesStruct$Avatar filesStruct$Avatar2 = this.avatar_;
        if (filesStruct$Avatar2 == null || filesStruct$Avatar2 == FilesStruct$Avatar.getDefaultInstance()) {
            this.avatar_ = filesStruct$Avatar;
        } else {
            this.avatar_ = (FilesStruct$Avatar) ((FilesStruct$Avatar.a) FilesStruct$Avatar.newBuilder(this.avatar_).v(filesStruct$Avatar)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeBecameOrphaned(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.becameOrphaned_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.becameOrphaned_ = boolValue;
        } else {
            this.becameOrphaned_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.becameOrphaned_).v(boolValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeChannelBannerAdTagId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.channelBannerAdTagId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.channelBannerAdTagId_ = stringValue;
        } else {
            this.channelBannerAdTagId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.channelBannerAdTagId_).v(stringValue)).j();
        }
        this.bitField0_ |= 8192;
    }

    private void mergeChannelNativeAdTagId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.channelNativeAdTagId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.channelNativeAdTagId_ = stringValue;
        } else {
            this.channelNativeAdTagId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.channelNativeAdTagId_).v(stringValue)).j();
        }
        this.bitField0_ |= 4096;
    }

    private void mergeDefaultPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        GroupsStruct$Permissions groupsStruct$Permissions2 = this.defaultPermissions_;
        if (groupsStruct$Permissions2 == null || groupsStruct$Permissions2 == GroupsStruct$Permissions.getDefaultInstance()) {
            this.defaultPermissions_ = groupsStruct$Permissions;
        } else {
            this.defaultPermissions_ = (GroupsStruct$Permissions) ((GroupsStruct$Permissions.a) GroupsStruct$Permissions.newBuilder(this.defaultPermissions_).v(groupsStruct$Permissions)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeDiscussionGroupEnabled(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.discussionGroupEnabled_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.discussionGroupEnabled_ = boolValue;
        } else {
            this.discussionGroupEnabled_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.discussionGroupEnabled_).v(boolValue)).j();
        }
        this.bitField0_ |= 65536;
    }

    private void mergeExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        PeersStruct$ExInfo peersStruct$ExInfo2 = this.exInfo_;
        if (peersStruct$ExInfo2 == null || peersStruct$ExInfo2 == PeersStruct$ExInfo.getDefaultInstance()) {
            this.exInfo_ = peersStruct$ExInfo;
        } else {
            this.exInfo_ = (PeersStruct$ExInfo) ((PeersStruct$ExInfo.a) PeersStruct$ExInfo.newBuilder(this.exInfo_).v(peersStruct$ExInfo)).j();
        }
        this.bitField0_ |= 1024;
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

    private void mergeIsMember(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isMember_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isMember_ = boolValue;
        } else {
            this.isMember_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isMember_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeIsSuspend(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isSuspend_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isSuspend_ = boolValue;
        } else {
            this.isSuspend_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isSuspend_).v(boolValue)).j();
        }
        this.bitField0_ |= 16384;
    }

    private void mergeLinkedGroupPeerId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.linkedGroupPeerId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.linkedGroupPeerId_ = int32Value;
        } else {
            this.linkedGroupPeerId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.linkedGroupPeerId_).v(int32Value)).j();
        }
        this.bitField0_ |= 32768;
    }

    private void mergeMembersCount10(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.membersCount10_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.membersCount10_ = int32Value;
        } else {
            this.membersCount10_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.membersCount10_).v(int32Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeNick(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nick_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nick_ = stringValue;
        } else {
            this.nick_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nick_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergePermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        GroupsStruct$Permissions groupsStruct$Permissions2 = this.permissions_;
        if (groupsStruct$Permissions2 == null || groupsStruct$Permissions2 == GroupsStruct$Permissions.getDefaultInstance()) {
            this.permissions_ = groupsStruct$Permissions;
        } else {
            this.permissions_ = (GroupsStruct$Permissions) ((GroupsStruct$Permissions.a) GroupsStruct$Permissions.newBuilder(this.permissions_).v(groupsStruct$Permissions)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergePin(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        MessagingStruct$MessageContainer messagingStruct$MessageContainer2 = this.pin_;
        if (messagingStruct$MessageContainer2 == null || messagingStruct$MessageContainer2 == MessagingStruct$MessageContainer.getDefaultInstance()) {
            this.pin_ = messagingStruct$MessageContainer;
        } else {
            this.pin_ = (MessagingStruct$MessageContainer) ((MessagingStruct$MessageContainer.a) MessagingStruct$MessageContainer.newBuilder(this.pin_).v(messagingStruct$MessageContainer)).j();
        }
        this.bitField0_ |= 2048;
    }

    private void mergeTheme(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.theme_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.theme_ = stringValue;
        } else {
            this.theme_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.theme_).v(stringValue)).j();
        }
        this.bitField0_ |= 256;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$FullGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$FullGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMembers17(int i) {
        ensureMembers17IsMutable();
        this.members17_.remove(i);
    }

    private void setAbout(StringValue stringValue) {
        stringValue.getClass();
        this.about_ = stringValue;
        this.bitField0_ |= 512;
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
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

    private void setAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.avatar_ = filesStruct$Avatar;
        this.bitField0_ |= 1;
    }

    private void setBecameOrphaned(BoolValue boolValue) {
        boolValue.getClass();
        this.becameOrphaned_ = boolValue;
        this.bitField0_ |= 32;
    }

    private void setChannelBannerAdTagId(StringValue stringValue) {
        stringValue.getClass();
        this.channelBannerAdTagId_ = stringValue;
        this.bitField0_ |= 8192;
    }

    private void setChannelNativeAdTagId(StringValue stringValue) {
        stringValue.getClass();
        this.channelNativeAdTagId_ = stringValue;
        this.bitField0_ |= 4096;
    }

    private void setCreateDate(long j) {
        this.createDate_ = j;
    }

    private void setDefaultPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        this.defaultPermissions_ = groupsStruct$Permissions;
        this.bitField0_ |= 128;
    }

    private void setDiscussionGroupEnabled(BoolValue boolValue) {
        boolValue.getClass();
        this.discussionGroupEnabled_ = boolValue;
        this.bitField0_ |= 65536;
    }

    private void setExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        this.exInfo_ = peersStruct$ExInfo;
        this.bitField0_ |= 1024;
    }

    private void setExt(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.ext_ = collectionsStruct$MapValue;
        this.bitField0_ |= 4;
    }

    private void setGroupType(EnumC24932zS2 enumC24932zS2) {
        this.groupType_ = enumC24932zS2.getNumber();
    }

    private void setGroupTypeValue(int i) {
        this.groupType_ = i;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsMember(BoolValue boolValue) {
        boolValue.getClass();
        this.isMember_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setIsSuspend(BoolValue boolValue) {
        boolValue.getClass();
        this.isSuspend_ = boolValue;
        this.bitField0_ |= 16384;
    }

    private void setLinkedGroupPeerId(Int32Value int32Value) {
        int32Value.getClass();
        this.linkedGroupPeerId_ = int32Value;
        this.bitField0_ |= 32768;
    }

    private void setMembers17(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembers17IsMutable();
        this.members17_.set(i, groupsStruct$Member);
    }

    private void setMembersCount10(Int32Value int32Value) {
        int32Value.getClass();
        this.membersCount10_ = int32Value;
        this.bitField0_ |= 8;
    }

    private void setNick(StringValue stringValue) {
        stringValue.getClass();
        this.nick_ = stringValue;
        this.bitField0_ |= 16;
    }

    private void setOwnerUid(int i) {
        this.ownerUid_ = i;
    }

    private void setPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        this.permissions_ = groupsStruct$Permissions;
        this.bitField0_ |= 64;
    }

    private void setPin(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        this.pin_ = messagingStruct$MessageContainer;
        this.bitField0_ |= 2048;
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
        this.bitField0_ |= 256;
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
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$FullGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u001c\u0000\u0001\u0001\u001c\u001c\u0000\u0002\u0000\u0001\u0004\u0002\u0002\u0003Ȉ\u0004ဉ\u0000\u0005\u0004\u0006\u0002\u0007\f\bဉ\u0001\tဉ\u0002\nဉ\u0003\u000bဉ\u0004\fဉ\u0005\rဉ\u0006\u000eဉ\u0007\u000fဉ\b\u0010ဉ\t\u0011\u001b\u0012ဉ\n\u0013ဉ\u000b\u0014\f\u0015\f\u0016ဉ\f\u0017ဉ\r\u0018Ț\u0019ဉ\u000e\u001aဉ\u000f\u001bဉ\u0010\u001c\f", new Object[]{"bitField0_", "id_", "accessHash_", "title_", "avatar_", "ownerUid_", "createDate_", "groupType_", "isMember_", "ext_", "membersCount10_", "nick_", "becameOrphaned_", "permissions_", "defaultPermissions_", "theme_", "about_", "members17_", GroupsStruct$Member.class, "exInfo_", "pin_", "restriction_", "advertisementType_", "channelNativeAdTagId_", "channelBannerAdTagId_", "availableReactions_", "isSuspend_", "linkedGroupPeerId_", "discussionGroupEnabled_", "privacyBarMode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$FullGroup.class) {
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

    public StringValue getAbout() {
        StringValue stringValue = this.about_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getAccessHash() {
        return this.accessHash_;
    }

    public EnumC8025Uf getAdvertisementType() {
        EnumC8025Uf enumC8025UfJ = EnumC8025Uf.j(this.advertisementType_);
        return enumC8025UfJ == null ? EnumC8025Uf.UNRECOGNIZED : enumC8025UfJ;
    }

    public int getAdvertisementTypeValue() {
        return this.advertisementType_;
    }

    public String getAvailableReactions(int i) {
        return (String) this.availableReactions_.get(i);
    }

    public AbstractC2383g getAvailableReactionsBytes(int i) {
        return AbstractC2383g.N((String) this.availableReactions_.get(i));
    }

    public int getAvailableReactionsCount() {
        return this.availableReactions_.size();
    }

    public List<String> getAvailableReactionsList() {
        return this.availableReactions_;
    }

    public FilesStruct$Avatar getAvatar() {
        FilesStruct$Avatar filesStruct$Avatar = this.avatar_;
        return filesStruct$Avatar == null ? FilesStruct$Avatar.getDefaultInstance() : filesStruct$Avatar;
    }

    public BoolValue getBecameOrphaned() {
        BoolValue boolValue = this.becameOrphaned_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public StringValue getChannelBannerAdTagId() {
        StringValue stringValue = this.channelBannerAdTagId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getChannelNativeAdTagId() {
        StringValue stringValue = this.channelNativeAdTagId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getCreateDate() {
        return this.createDate_;
    }

    public GroupsStruct$Permissions getDefaultPermissions() {
        GroupsStruct$Permissions groupsStruct$Permissions = this.defaultPermissions_;
        return groupsStruct$Permissions == null ? GroupsStruct$Permissions.getDefaultInstance() : groupsStruct$Permissions;
    }

    public BoolValue getDiscussionGroupEnabled() {
        BoolValue boolValue = this.discussionGroupEnabled_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public PeersStruct$ExInfo getExInfo() {
        PeersStruct$ExInfo peersStruct$ExInfo = this.exInfo_;
        return peersStruct$ExInfo == null ? PeersStruct$ExInfo.getDefaultInstance() : peersStruct$ExInfo;
    }

    public CollectionsStruct$MapValue getExt() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.ext_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public EnumC24932zS2 getGroupType() {
        EnumC24932zS2 enumC24932zS2J = EnumC24932zS2.j(this.groupType_);
        return enumC24932zS2J == null ? EnumC24932zS2.UNRECOGNIZED : enumC24932zS2J;
    }

    public int getGroupTypeValue() {
        return this.groupType_;
    }

    public int getId() {
        return this.id_;
    }

    public BoolValue getIsMember() {
        BoolValue boolValue = this.isMember_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsSuspend() {
        BoolValue boolValue = this.isSuspend_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public Int32Value getLinkedGroupPeerId() {
        Int32Value int32Value = this.linkedGroupPeerId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public GroupsStruct$Member getMembers17(int i) {
        return (GroupsStruct$Member) this.members17_.get(i);
    }

    public int getMembers17Count() {
        return this.members17_.size();
    }

    public List<GroupsStruct$Member> getMembers17List() {
        return this.members17_;
    }

    public CS2 getMembers17OrBuilder(int i) {
        return (CS2) this.members17_.get(i);
    }

    public List<? extends CS2> getMembers17OrBuilderList() {
        return this.members17_;
    }

    public Int32Value getMembersCount10() {
        Int32Value int32Value = this.membersCount10_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public StringValue getNick() {
        StringValue stringValue = this.nick_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getOwnerUid() {
        return this.ownerUid_;
    }

    public GroupsStruct$Permissions getPermissions() {
        GroupsStruct$Permissions groupsStruct$Permissions = this.permissions_;
        return groupsStruct$Permissions == null ? GroupsStruct$Permissions.getDefaultInstance() : groupsStruct$Permissions;
    }

    public MessagingStruct$MessageContainer getPin() {
        MessagingStruct$MessageContainer messagingStruct$MessageContainer = this.pin_;
        return messagingStruct$MessageContainer == null ? MessagingStruct$MessageContainer.getDefaultInstance() : messagingStruct$MessageContainer;
    }

    public EnumC7089Qf4 getPrivacyBarMode() {
        EnumC7089Qf4 enumC7089Qf4J = EnumC7089Qf4.j(this.privacyBarMode_);
        return enumC7089Qf4J == null ? EnumC7089Qf4.UNRECOGNIZED : enumC7089Qf4J;
    }

    public int getPrivacyBarModeValue() {
        return this.privacyBarMode_;
    }

    public GS2 getRestriction() {
        GS2 gs2J = GS2.j(this.restriction_);
        return gs2J == null ? GS2.UNRECOGNIZED : gs2J;
    }

    public int getRestrictionValue() {
        return this.restriction_;
    }

    public StringValue getTheme() {
        StringValue stringValue = this.theme_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasAbout() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasBecameOrphaned() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasChannelBannerAdTagId() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasChannelNativeAdTagId() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasDefaultPermissions() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasDiscussionGroupEnabled() {
        return (this.bitField0_ & 65536) != 0;
    }

    public boolean hasExInfo() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasExt() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIsMember() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasIsSuspend() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasLinkedGroupPeerId() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasMembersCount10() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasNick() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasPermissions() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasPin() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasTheme() {
        return (this.bitField0_ & 256) != 0;
    }

    public static a newBuilder(GroupsStruct$FullGroup groupsStruct$FullGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$FullGroup);
    }

    public static GroupsStruct$FullGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$FullGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$FullGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMembers17(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembers17IsMutable();
        this.members17_.add(i, groupsStruct$Member);
    }

    public static GroupsStruct$FullGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$FullGroup parseFrom(byte[] bArr) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$FullGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$FullGroup parseFrom(InputStream inputStream) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$FullGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$FullGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$FullGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$FullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
