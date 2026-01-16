package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.GroupsStruct$Permissions;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.CS2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsStruct$Member extends GeneratedMessageLite implements CS2 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final GroupsStruct$Member DEFAULT_INSTANCE;
    public static final int INVITER_UID_FIELD_NUMBER = 2;
    public static final int IS_ADMIN_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PERMISSIONS_FIELD_NUMBER = 7;
    public static final int PROMOTED_AT_FIELD_NUMBER = 6;
    public static final int PROMOTER_USER_ID_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 8;
    public static final int UID_FIELD_NUMBER = 1;
    private int bitField0_;
    private long date_;
    private int inviterUid_;
    private BoolValue isAdmin_;
    private GroupsStruct$Permissions permissions_;
    private CollectionsStruct$Int64Value promotedAt_;
    private Int32Value promoterUserId_;
    private StringValue title_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements CS2 {
        private a() {
            super(GroupsStruct$Member.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$Member groupsStruct$Member = new GroupsStruct$Member();
        DEFAULT_INSTANCE = groupsStruct$Member;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$Member.class, groupsStruct$Member);
    }

    private GroupsStruct$Member() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearInviterUid() {
        this.inviterUid_ = 0;
    }

    private void clearIsAdmin() {
        this.isAdmin_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPermissions() {
        this.permissions_ = null;
        this.bitField0_ &= -9;
    }

    private void clearPromotedAt() {
        this.promotedAt_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPromoterUserId() {
        this.promoterUserId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -17;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static GroupsStruct$Member getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsAdmin(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isAdmin_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isAdmin_ = boolValue;
        } else {
            this.isAdmin_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isAdmin_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        GroupsStruct$Permissions groupsStruct$Permissions2 = this.permissions_;
        if (groupsStruct$Permissions2 == null || groupsStruct$Permissions2 == GroupsStruct$Permissions.getDefaultInstance()) {
            this.permissions_ = groupsStruct$Permissions;
        } else {
            this.permissions_ = (GroupsStruct$Permissions) ((GroupsStruct$Permissions.a) GroupsStruct$Permissions.newBuilder(this.permissions_).v(groupsStruct$Permissions)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergePromotedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.promotedAt_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.promotedAt_ = collectionsStruct$Int64Value;
        } else {
            this.promotedAt_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.promotedAt_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergePromoterUserId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.promoterUserId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.promoterUserId_ = int32Value;
        } else {
            this.promoterUserId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.promoterUserId_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeTitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.title_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.title_ = stringValue;
        } else {
            this.title_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.title_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$Member parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$Member parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setInviterUid(int i) {
        this.inviterUid_ = i;
    }

    private void setIsAdmin(BoolValue boolValue) {
        boolValue.getClass();
        this.isAdmin_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        this.permissions_ = groupsStruct$Permissions;
        this.bitField0_ |= 8;
    }

    private void setPromotedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.promotedAt_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setPromoterUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.promoterUserId_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setTitle(StringValue stringValue) {
        stringValue.getClass();
        this.title_ = stringValue;
        this.bitField0_ |= 16;
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$Member();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0002\u0004ဉ\u0000\u0005ဉ\u0001\u0006ဉ\u0002\u0007ဉ\u0003\bဉ\u0004", new Object[]{"bitField0_", "uid_", "inviterUid_", "date_", "isAdmin_", "promoterUserId_", "promotedAt_", "permissions_", "title_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$Member.class) {
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

    public long getDate() {
        return this.date_;
    }

    public int getInviterUid() {
        return this.inviterUid_;
    }

    public BoolValue getIsAdmin() {
        BoolValue boolValue = this.isAdmin_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public GroupsStruct$Permissions getPermissions() {
        GroupsStruct$Permissions groupsStruct$Permissions = this.permissions_;
        return groupsStruct$Permissions == null ? GroupsStruct$Permissions.getDefaultInstance() : groupsStruct$Permissions;
    }

    public CollectionsStruct$Int64Value getPromotedAt() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.promotedAt_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public Int32Value getPromoterUserId() {
        Int32Value int32Value = this.promoterUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public StringValue getTitle() {
        StringValue stringValue = this.title_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getUid() {
        return this.uid_;
    }

    public boolean hasIsAdmin() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPermissions() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPromotedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPromoterUserId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(GroupsStruct$Member groupsStruct$Member) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$Member);
    }

    public static GroupsStruct$Member parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$Member parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$Member parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$Member parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$Member parseFrom(byte[] bArr) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$Member parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$Member parseFrom(InputStream inputStream) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$Member parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$Member parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$Member parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$Member) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
