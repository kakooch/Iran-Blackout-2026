package ai.bale.proto;

import ai.bale.proto.FilesStruct$Avatar;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.FS2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsStruct$PublicGroup extends GeneratedMessageLite implements FS2 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    public static final int AVATAR_FIELD_NUMBER = 7;
    private static final GroupsStruct$PublicGroup DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int FRIENDS_COUNT_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MEMBERS_COUNT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 3;
    private long accessHash_;
    private FilesStruct$Avatar avatar_;
    private int bitField0_;
    private int friendsCount_;
    private int id_;
    private int membersCount_;
    private String title_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements FS2 {
        private a() {
            super(GroupsStruct$PublicGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$PublicGroup groupsStruct$PublicGroup = new GroupsStruct$PublicGroup();
        DEFAULT_INSTANCE = groupsStruct$PublicGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$PublicGroup.class, groupsStruct$PublicGroup);
    }

    private GroupsStruct$PublicGroup() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearFriendsCount() {
        this.friendsCount_ = 0;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearMembersCount() {
        this.membersCount_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static GroupsStruct$PublicGroup getDefaultInstance() {
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$PublicGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$PublicGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    private void setAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.avatar_ = filesStruct$Avatar;
        this.bitField0_ |= 1;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setFriendsCount(int i) {
        this.friendsCount_ = i;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setMembersCount(int i) {
        this.membersCount_ = i;
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
                return new GroupsStruct$PublicGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003Ȉ\u0004\u0004\u0005\u0004\u0006Ȉ\u0007ဉ\u0000", new Object[]{"bitField0_", "id_", "accessHash_", "title_", "membersCount_", "friendsCount_", "description_", "avatar_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$PublicGroup.class) {
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

    public FilesStruct$Avatar getAvatar() {
        FilesStruct$Avatar filesStruct$Avatar = this.avatar_;
        return filesStruct$Avatar == null ? FilesStruct$Avatar.getDefaultInstance() : filesStruct$Avatar;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public int getFriendsCount() {
        return this.friendsCount_;
    }

    public int getId() {
        return this.id_;
    }

    public int getMembersCount() {
        return this.membersCount_;
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

    public static a newBuilder(GroupsStruct$PublicGroup groupsStruct$PublicGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$PublicGroup);
    }

    public static GroupsStruct$PublicGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$PublicGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$PublicGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$PublicGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$PublicGroup parseFrom(byte[] bArr) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$PublicGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$PublicGroup parseFrom(InputStream inputStream) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$PublicGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$PublicGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$PublicGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$PublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
