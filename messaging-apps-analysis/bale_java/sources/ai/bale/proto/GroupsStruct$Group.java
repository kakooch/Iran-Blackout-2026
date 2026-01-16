package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$MapValue;
import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.GroupsStruct$Permissions;
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
import ir.nasim.EnumC24932zS2;
import ir.nasim.GS2;
import ir.nasim.InterfaceC23748xS2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsStruct$Group extends GeneratedMessageLite implements InterfaceC23748xS2 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    public static final int AVAILABLE_REACTIONS_FIELD_NUMBER = 33;
    public static final int AVATAR_FIELD_NUMBER = 4;
    public static final int BECAME_ORPHANED_FIELD_NUMBER = 18;
    public static final int CAN_SEND_MESSAGE_FIELD_NUMBER = 16;
    private static final GroupsStruct$Group DEFAULT_INSTANCE;
    public static final int DEFAULT_PERMISSIONS_FIELD_NUMBER = 31;
    public static final int DISCUSSION_GROUP_ENABLED_FIELD_NUMBER = 39;
    public static final int EXT_FIELD_NUMBER = 13;
    public static final int EX_INFO_FIELD_NUMBER = 37;
    public static final int GROUP_TYPE_FIELD_NUMBER = 15;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_HIDDEN_FIELD_NUMBER = 12;
    public static final int IS_MEMBER_FIELD_NUMBER = 5;
    public static final int IS_SUSPEND_FIELD_NUMBER = 36;
    public static final int LINKED_GROUP_PEER_ID_FIELD_NUMBER = 38;
    public static final int MEMBERS_COUNT_FIELD_NUMBER = 20;
    public static final int NICK_FIELD_NUMBER = 17;
    public static final int OWNER_UID_FIELD_NUMBER = 32;
    private static volatile KW4 PARSER = null;
    public static final int PERMISSIONS_FIELD_NUMBER = 30;
    public static final int RESTRICTION_FIELD_NUMBER = 40;
    public static final int STATE_VERSION_FIELD_NUMBER = 19;
    public static final int TITLE_FIELD_NUMBER = 3;
    private long accessHash_;
    private FilesStruct$Avatar avatar_;
    private BoolValue becameOrphaned_;
    private int bitField0_;
    private BoolValue canSendMessage_;
    private GroupsStruct$Permissions defaultPermissions_;
    private BoolValue discussionGroupEnabled_;
    private PeersStruct$ExInfo exInfo_;
    private CollectionsStruct$MapValue ext_;
    private int groupType_;
    private int id_;
    private BoolValue isHidden_;
    private BoolValue isMember_;
    private BoolValue isSuspend_;
    private Int32Value linkedGroupPeerId_;
    private Int32Value membersCount_;
    private StringValue nick_;
    private Int32Value ownerUid_;
    private GroupsStruct$Permissions permissions_;
    private int restriction_;
    private CollectionsStruct$Int64Value stateVersion_;
    private String title_ = "";
    private B.j availableReactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23748xS2 {
        private a() {
            super(GroupsStruct$Group.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$Group groupsStruct$Group = new GroupsStruct$Group();
        DEFAULT_INSTANCE = groupsStruct$Group;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$Group.class, groupsStruct$Group);
    }

    private GroupsStruct$Group() {
    }

    private void addAllAvailableReactions(Iterable<String> iterable) {
        ensureAvailableReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.availableReactions_);
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

    private void clearAccessHash() {
        this.accessHash_ = 0L;
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
        this.bitField0_ &= -129;
    }

    private void clearCanSendMessage() {
        this.canSendMessage_ = null;
        this.bitField0_ &= -33;
    }

    private void clearDefaultPermissions() {
        this.defaultPermissions_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearDiscussionGroupEnabled() {
        this.discussionGroupEnabled_ = null;
        this.bitField0_ &= -32769;
    }

    private void clearExInfo() {
        this.exInfo_ = null;
        this.bitField0_ &= -8193;
    }

    private void clearExt() {
        this.ext_ = null;
        this.bitField0_ &= -9;
    }

    private void clearGroupType() {
        this.groupType_ = 0;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsHidden() {
        this.isHidden_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIsMember() {
        this.isMember_ = null;
        this.bitField0_ &= -3;
    }

    private void clearIsSuspend() {
        this.isSuspend_ = null;
        this.bitField0_ &= -4097;
    }

    private void clearLinkedGroupPeerId() {
        this.linkedGroupPeerId_ = null;
        this.bitField0_ &= -16385;
    }

    private void clearMembersCount() {
        this.membersCount_ = null;
        this.bitField0_ &= -17;
    }

    private void clearNick() {
        this.nick_ = null;
        this.bitField0_ &= -65;
    }

    private void clearOwnerUid() {
        this.ownerUid_ = null;
        this.bitField0_ &= -2049;
    }

    private void clearPermissions() {
        this.permissions_ = null;
        this.bitField0_ &= -513;
    }

    private void clearRestriction() {
        this.restriction_ = 0;
    }

    private void clearStateVersion() {
        this.stateVersion_ = null;
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

    public static GroupsStruct$Group getDefaultInstance() {
        return DEFAULT_INSTANCE;
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
        this.bitField0_ |= 128;
    }

    private void mergeCanSendMessage(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.canSendMessage_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.canSendMessage_ = boolValue;
        } else {
            this.canSendMessage_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.canSendMessage_).v(boolValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeDefaultPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        GroupsStruct$Permissions groupsStruct$Permissions2 = this.defaultPermissions_;
        if (groupsStruct$Permissions2 == null || groupsStruct$Permissions2 == GroupsStruct$Permissions.getDefaultInstance()) {
            this.defaultPermissions_ = groupsStruct$Permissions;
        } else {
            this.defaultPermissions_ = (GroupsStruct$Permissions) ((GroupsStruct$Permissions.a) GroupsStruct$Permissions.newBuilder(this.defaultPermissions_).v(groupsStruct$Permissions)).j();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeDiscussionGroupEnabled(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.discussionGroupEnabled_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.discussionGroupEnabled_ = boolValue;
        } else {
            this.discussionGroupEnabled_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.discussionGroupEnabled_).v(boolValue)).j();
        }
        this.bitField0_ |= 32768;
    }

    private void mergeExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        PeersStruct$ExInfo peersStruct$ExInfo2 = this.exInfo_;
        if (peersStruct$ExInfo2 == null || peersStruct$ExInfo2 == PeersStruct$ExInfo.getDefaultInstance()) {
            this.exInfo_ = peersStruct$ExInfo;
        } else {
            this.exInfo_ = (PeersStruct$ExInfo) ((PeersStruct$ExInfo.a) PeersStruct$ExInfo.newBuilder(this.exInfo_).v(peersStruct$ExInfo)).j();
        }
        this.bitField0_ |= 8192;
    }

    private void mergeExt(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.ext_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.ext_ = collectionsStruct$MapValue;
        } else {
            this.ext_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.ext_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeIsHidden(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isHidden_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isHidden_ = boolValue;
        } else {
            this.isHidden_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isHidden_).v(boolValue)).j();
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
        this.bitField0_ |= 4096;
    }

    private void mergeLinkedGroupPeerId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.linkedGroupPeerId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.linkedGroupPeerId_ = int32Value;
        } else {
            this.linkedGroupPeerId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.linkedGroupPeerId_).v(int32Value)).j();
        }
        this.bitField0_ |= 16384;
    }

    private void mergeMembersCount(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.membersCount_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.membersCount_ = int32Value;
        } else {
            this.membersCount_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.membersCount_).v(int32Value)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeNick(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nick_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nick_ = stringValue;
        } else {
            this.nick_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nick_).v(stringValue)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeOwnerUid(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.ownerUid_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.ownerUid_ = int32Value;
        } else {
            this.ownerUid_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.ownerUid_).v(int32Value)).j();
        }
        this.bitField0_ |= 2048;
    }

    private void mergePermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        GroupsStruct$Permissions groupsStruct$Permissions2 = this.permissions_;
        if (groupsStruct$Permissions2 == null || groupsStruct$Permissions2 == GroupsStruct$Permissions.getDefaultInstance()) {
            this.permissions_ = groupsStruct$Permissions;
        } else {
            this.permissions_ = (GroupsStruct$Permissions) ((GroupsStruct$Permissions.a) GroupsStruct$Permissions.newBuilder(this.permissions_).v(groupsStruct$Permissions)).j();
        }
        this.bitField0_ |= 512;
    }

    private void mergeStateVersion(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.stateVersion_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.stateVersion_ = collectionsStruct$Int64Value;
        } else {
            this.stateVersion_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.stateVersion_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 256;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$Group parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$Group parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
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
        this.bitField0_ |= 128;
    }

    private void setCanSendMessage(BoolValue boolValue) {
        boolValue.getClass();
        this.canSendMessage_ = boolValue;
        this.bitField0_ |= 32;
    }

    private void setDefaultPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        this.defaultPermissions_ = groupsStruct$Permissions;
        this.bitField0_ |= 1024;
    }

    private void setDiscussionGroupEnabled(BoolValue boolValue) {
        boolValue.getClass();
        this.discussionGroupEnabled_ = boolValue;
        this.bitField0_ |= 32768;
    }

    private void setExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        this.exInfo_ = peersStruct$ExInfo;
        this.bitField0_ |= 8192;
    }

    private void setExt(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.ext_ = collectionsStruct$MapValue;
        this.bitField0_ |= 8;
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

    private void setIsHidden(BoolValue boolValue) {
        boolValue.getClass();
        this.isHidden_ = boolValue;
        this.bitField0_ |= 4;
    }

    private void setIsMember(BoolValue boolValue) {
        boolValue.getClass();
        this.isMember_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setIsSuspend(BoolValue boolValue) {
        boolValue.getClass();
        this.isSuspend_ = boolValue;
        this.bitField0_ |= 4096;
    }

    private void setLinkedGroupPeerId(Int32Value int32Value) {
        int32Value.getClass();
        this.linkedGroupPeerId_ = int32Value;
        this.bitField0_ |= 16384;
    }

    private void setMembersCount(Int32Value int32Value) {
        int32Value.getClass();
        this.membersCount_ = int32Value;
        this.bitField0_ |= 16;
    }

    private void setNick(StringValue stringValue) {
        stringValue.getClass();
        this.nick_ = stringValue;
        this.bitField0_ |= 64;
    }

    private void setOwnerUid(Int32Value int32Value) {
        int32Value.getClass();
        this.ownerUid_ = int32Value;
        this.bitField0_ |= 2048;
    }

    private void setPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        this.permissions_ = groupsStruct$Permissions;
        this.bitField0_ |= 512;
    }

    private void setRestriction(GS2 gs2) {
        this.restriction_ = gs2.getNumber();
    }

    private void setRestrictionValue(int i) {
        this.restriction_ = i;
    }

    private void setStateVersion(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.stateVersion_ = collectionsStruct$Int64Value;
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
                return new GroupsStruct$Group();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0016\u0000\u0001\u0001(\u0016\u0000\u0001\u0000\u0001\u0004\u0002\u0002\u0003Ȉ\u0004ဉ\u0000\u0005ဉ\u0001\fဉ\u0002\rဉ\u0003\u000f\f\u0010ဉ\u0005\u0011ဉ\u0006\u0012ဉ\u0007\u0013ဉ\b\u0014ဉ\u0004\u001eဉ\t\u001fဉ\n ဉ\u000b!Ț$ဉ\f%ဉ\r&ဉ\u000e'ဉ\u000f(\f", new Object[]{"bitField0_", "id_", "accessHash_", "title_", "avatar_", "isMember_", "isHidden_", "ext_", "groupType_", "canSendMessage_", "nick_", "becameOrphaned_", "stateVersion_", "membersCount_", "permissions_", "defaultPermissions_", "ownerUid_", "availableReactions_", "isSuspend_", "exInfo_", "linkedGroupPeerId_", "discussionGroupEnabled_", "restriction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$Group.class) {
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

    public BoolValue getCanSendMessage() {
        BoolValue boolValue = this.canSendMessage_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
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

    public BoolValue getIsHidden() {
        BoolValue boolValue = this.isHidden_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
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

    public Int32Value getMembersCount() {
        Int32Value int32Value = this.membersCount_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public StringValue getNick() {
        StringValue stringValue = this.nick_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public Int32Value getOwnerUid() {
        Int32Value int32Value = this.ownerUid_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public GroupsStruct$Permissions getPermissions() {
        GroupsStruct$Permissions groupsStruct$Permissions = this.permissions_;
        return groupsStruct$Permissions == null ? GroupsStruct$Permissions.getDefaultInstance() : groupsStruct$Permissions;
    }

    public GS2 getRestriction() {
        GS2 gs2J = GS2.j(this.restriction_);
        return gs2J == null ? GS2.UNRECOGNIZED : gs2J;
    }

    public int getRestrictionValue() {
        return this.restriction_;
    }

    public CollectionsStruct$Int64Value getStateVersion() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.stateVersion_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasBecameOrphaned() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasCanSendMessage() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasDefaultPermissions() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasDiscussionGroupEnabled() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasExInfo() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasExt() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasIsHidden() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIsMember() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasIsSuspend() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasLinkedGroupPeerId() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasMembersCount() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasNick() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasOwnerUid() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasPermissions() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasStateVersion() {
        return (this.bitField0_ & 256) != 0;
    }

    public static a newBuilder(GroupsStruct$Group groupsStruct$Group) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$Group);
    }

    public static GroupsStruct$Group parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$Group parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$Group parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$Group parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$Group parseFrom(byte[] bArr) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$Group parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$Group parseFrom(InputStream inputStream) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$Group parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$Group parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$Group parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$Group) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
