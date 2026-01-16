package ai.bale.proto;

import ai.bale.proto.GroupsStruct$FilterAdmin;
import ai.bale.proto.GroupsStruct$FilterGroupType;
import ai.bale.proto.GroupsStruct$FilterMembersCount;
import ai.bale.proto.GroupsStruct$FilterOwner;
import ai.bale.proto.GroupsStruct$FilterRestriction;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsStruct$GetMyGroupsFilter extends GeneratedMessageLite implements InterfaceC1880o0 {
    private static final GroupsStruct$GetMyGroupsFilter DEFAULT_INSTANCE;
    public static final int FILTER_ADMIN_FIELD_NUMBER = 2;
    public static final int FILTER_GROUP_TYPE_FIELD_NUMBER = 3;
    public static final int FILTER_MEMBERS_COUNT_FIELD_NUMBER = 5;
    public static final int FILTER_OWNER_FIELD_NUMBER = 1;
    public static final int FILTER_RESTRICTION_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1880o0 {
        public a A(GroupsStruct$FilterGroupType groupsStruct$FilterGroupType) {
            q();
            ((GroupsStruct$GetMyGroupsFilter) this.b).setFilterGroupType(groupsStruct$FilterGroupType);
            return this;
        }

        public a B(GroupsStruct$FilterOwner groupsStruct$FilterOwner) {
            q();
            ((GroupsStruct$GetMyGroupsFilter) this.b).setFilterOwner(groupsStruct$FilterOwner);
            return this;
        }

        private a() {
            super(GroupsStruct$GetMyGroupsFilter.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        FILTER_OWNER(1),
        FILTER_ADMIN(2),
        FILTER_GROUP_TYPE(3),
        FILTER_RESTRICTION(4),
        FILTER_MEMBERS_COUNT(5),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return FILTER_OWNER;
            }
            if (i == 2) {
                return FILTER_ADMIN;
            }
            if (i == 3) {
                return FILTER_GROUP_TYPE;
            }
            if (i == 4) {
                return FILTER_RESTRICTION;
            }
            if (i != 5) {
                return null;
            }
            return FILTER_MEMBERS_COUNT;
        }
    }

    static {
        GroupsStruct$GetMyGroupsFilter groupsStruct$GetMyGroupsFilter = new GroupsStruct$GetMyGroupsFilter();
        DEFAULT_INSTANCE = groupsStruct$GetMyGroupsFilter;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$GetMyGroupsFilter.class, groupsStruct$GetMyGroupsFilter);
    }

    private GroupsStruct$GetMyGroupsFilter() {
    }

    private void clearFilterAdmin() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFilterGroupType() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFilterMembersCount() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFilterOwner() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFilterRestriction() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static GroupsStruct$GetMyGroupsFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFilterAdmin(GroupsStruct$FilterAdmin groupsStruct$FilterAdmin) {
        groupsStruct$FilterAdmin.getClass();
        if (this.traitCase_ != 2 || this.trait_ == GroupsStruct$FilterAdmin.getDefaultInstance()) {
            this.trait_ = groupsStruct$FilterAdmin;
        } else {
            this.trait_ = ((GroupsStruct$FilterAdmin.a) GroupsStruct$FilterAdmin.newBuilder((GroupsStruct$FilterAdmin) this.trait_).v(groupsStruct$FilterAdmin)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeFilterGroupType(GroupsStruct$FilterGroupType groupsStruct$FilterGroupType) {
        groupsStruct$FilterGroupType.getClass();
        if (this.traitCase_ != 3 || this.trait_ == GroupsStruct$FilterGroupType.getDefaultInstance()) {
            this.trait_ = groupsStruct$FilterGroupType;
        } else {
            this.trait_ = ((GroupsStruct$FilterGroupType.a) GroupsStruct$FilterGroupType.newBuilder((GroupsStruct$FilterGroupType) this.trait_).v(groupsStruct$FilterGroupType)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeFilterMembersCount(GroupsStruct$FilterMembersCount groupsStruct$FilterMembersCount) {
        groupsStruct$FilterMembersCount.getClass();
        if (this.traitCase_ != 5 || this.trait_ == GroupsStruct$FilterMembersCount.getDefaultInstance()) {
            this.trait_ = groupsStruct$FilterMembersCount;
        } else {
            this.trait_ = ((GroupsStruct$FilterMembersCount.a) GroupsStruct$FilterMembersCount.newBuilder((GroupsStruct$FilterMembersCount) this.trait_).v(groupsStruct$FilterMembersCount)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeFilterOwner(GroupsStruct$FilterOwner groupsStruct$FilterOwner) {
        groupsStruct$FilterOwner.getClass();
        if (this.traitCase_ != 1 || this.trait_ == GroupsStruct$FilterOwner.getDefaultInstance()) {
            this.trait_ = groupsStruct$FilterOwner;
        } else {
            this.trait_ = ((GroupsStruct$FilterOwner.a) GroupsStruct$FilterOwner.newBuilder((GroupsStruct$FilterOwner) this.trait_).v(groupsStruct$FilterOwner)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeFilterRestriction(GroupsStruct$FilterRestriction groupsStruct$FilterRestriction) {
        groupsStruct$FilterRestriction.getClass();
        if (this.traitCase_ != 4 || this.trait_ == GroupsStruct$FilterRestriction.getDefaultInstance()) {
            this.trait_ = groupsStruct$FilterRestriction;
        } else {
            this.trait_ = ((GroupsStruct$FilterRestriction.a) GroupsStruct$FilterRestriction.newBuilder((GroupsStruct$FilterRestriction) this.trait_).v(groupsStruct$FilterRestriction)).j();
        }
        this.traitCase_ = 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$GetMyGroupsFilter parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFilterAdmin(GroupsStruct$FilterAdmin groupsStruct$FilterAdmin) {
        groupsStruct$FilterAdmin.getClass();
        this.trait_ = groupsStruct$FilterAdmin;
        this.traitCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilterGroupType(GroupsStruct$FilterGroupType groupsStruct$FilterGroupType) {
        groupsStruct$FilterGroupType.getClass();
        this.trait_ = groupsStruct$FilterGroupType;
        this.traitCase_ = 3;
    }

    private void setFilterMembersCount(GroupsStruct$FilterMembersCount groupsStruct$FilterMembersCount) {
        groupsStruct$FilterMembersCount.getClass();
        this.trait_ = groupsStruct$FilterMembersCount;
        this.traitCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilterOwner(GroupsStruct$FilterOwner groupsStruct$FilterOwner) {
        groupsStruct$FilterOwner.getClass();
        this.trait_ = groupsStruct$FilterOwner;
        this.traitCase_ = 1;
    }

    private void setFilterRestriction(GroupsStruct$FilterRestriction groupsStruct$FilterRestriction) {
        groupsStruct$FilterRestriction.getClass();
        this.trait_ = groupsStruct$FilterRestriction;
        this.traitCase_ = 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$GetMyGroupsFilter();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"trait_", "traitCase_", GroupsStruct$FilterOwner.class, GroupsStruct$FilterAdmin.class, GroupsStruct$FilterGroupType.class, GroupsStruct$FilterRestriction.class, GroupsStruct$FilterMembersCount.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$GetMyGroupsFilter.class) {
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

    public GroupsStruct$FilterAdmin getFilterAdmin() {
        return this.traitCase_ == 2 ? (GroupsStruct$FilterAdmin) this.trait_ : GroupsStruct$FilterAdmin.getDefaultInstance();
    }

    public GroupsStruct$FilterGroupType getFilterGroupType() {
        return this.traitCase_ == 3 ? (GroupsStruct$FilterGroupType) this.trait_ : GroupsStruct$FilterGroupType.getDefaultInstance();
    }

    public GroupsStruct$FilterMembersCount getFilterMembersCount() {
        return this.traitCase_ == 5 ? (GroupsStruct$FilterMembersCount) this.trait_ : GroupsStruct$FilterMembersCount.getDefaultInstance();
    }

    public GroupsStruct$FilterOwner getFilterOwner() {
        return this.traitCase_ == 1 ? (GroupsStruct$FilterOwner) this.trait_ : GroupsStruct$FilterOwner.getDefaultInstance();
    }

    public GroupsStruct$FilterRestriction getFilterRestriction() {
        return this.traitCase_ == 4 ? (GroupsStruct$FilterRestriction) this.trait_ : GroupsStruct$FilterRestriction.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasFilterAdmin() {
        return this.traitCase_ == 2;
    }

    public boolean hasFilterGroupType() {
        return this.traitCase_ == 3;
    }

    public boolean hasFilterMembersCount() {
        return this.traitCase_ == 5;
    }

    public boolean hasFilterOwner() {
        return this.traitCase_ == 1;
    }

    public boolean hasFilterRestriction() {
        return this.traitCase_ == 4;
    }

    public static a newBuilder(GroupsStruct$GetMyGroupsFilter groupsStruct$GetMyGroupsFilter) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$GetMyGroupsFilter);
    }

    public static GroupsStruct$GetMyGroupsFilter parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(byte[] bArr) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(InputStream inputStream) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$GetMyGroupsFilter parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$GetMyGroupsFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
