package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20695sS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestGetMyGroups extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestGetMyGroups DEFAULT_INSTANCE;
    public static final int FILTERS_FIELD_NUMBER = 3;
    public static final int IS_OWNER_FIELD_NUMBER = 2;
    public static final int MODE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j filters_ = GeneratedMessageLite.emptyProtobufList();
    private boolean isOwner_;
    private int mode_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((GroupsOuterClass$RequestGetMyGroups) this.b).addAllFilters(iterable);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestGetMyGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestGetMyGroups groupsOuterClass$RequestGetMyGroups = new GroupsOuterClass$RequestGetMyGroups();
        DEFAULT_INSTANCE = groupsOuterClass$RequestGetMyGroups;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestGetMyGroups.class, groupsOuterClass$RequestGetMyGroups);
    }

    private GroupsOuterClass$RequestGetMyGroups() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFilters(Iterable<? extends GroupsStruct$GetMyGroupsFilter> iterable) {
        ensureFiltersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.filters_);
    }

    private void addFilters(GroupsStruct$GetMyGroupsFilter groupsStruct$GetMyGroupsFilter) {
        groupsStruct$GetMyGroupsFilter.getClass();
        ensureFiltersIsMutable();
        this.filters_.add(groupsStruct$GetMyGroupsFilter);
    }

    private void clearFilters() {
        this.filters_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIsOwner() {
        this.isOwner_ = false;
    }

    private void clearMode() {
        this.mode_ = 0;
    }

    private void ensureFiltersIsMutable() {
        B.j jVar = this.filters_;
        if (jVar.u()) {
            return;
        }
        this.filters_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$RequestGetMyGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestGetMyGroups parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFilters(int i) {
        ensureFiltersIsMutable();
        this.filters_.remove(i);
    }

    private void setFilters(int i, GroupsStruct$GetMyGroupsFilter groupsStruct$GetMyGroupsFilter) {
        groupsStruct$GetMyGroupsFilter.getClass();
        ensureFiltersIsMutable();
        this.filters_.set(i, groupsStruct$GetMyGroupsFilter);
    }

    private void setIsOwner(boolean z) {
        this.isOwner_ = z;
    }

    private void setMode(EnumC20695sS2 enumC20695sS2) {
        this.mode_ = enumC20695sS2.getNumber();
    }

    private void setModeValue(int i) {
        this.mode_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestGetMyGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\u0007\u0003\u001b", new Object[]{"mode_", "isOwner_", "filters_", GroupsStruct$GetMyGroupsFilter.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestGetMyGroups.class) {
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

    public GroupsStruct$GetMyGroupsFilter getFilters(int i) {
        return (GroupsStruct$GetMyGroupsFilter) this.filters_.get(i);
    }

    public int getFiltersCount() {
        return this.filters_.size();
    }

    public List<GroupsStruct$GetMyGroupsFilter> getFiltersList() {
        return this.filters_;
    }

    public InterfaceC1880o0 getFiltersOrBuilder(int i) {
        return (InterfaceC1880o0) this.filters_.get(i);
    }

    public List<? extends InterfaceC1880o0> getFiltersOrBuilderList() {
        return this.filters_;
    }

    @Deprecated
    public boolean getIsOwner() {
        return this.isOwner_;
    }

    @Deprecated
    public EnumC20695sS2 getMode() {
        EnumC20695sS2 enumC20695sS2J = EnumC20695sS2.j(this.mode_);
        return enumC20695sS2J == null ? EnumC20695sS2.UNRECOGNIZED : enumC20695sS2J;
    }

    @Deprecated
    public int getModeValue() {
        return this.mode_;
    }

    public static a newBuilder(GroupsOuterClass$RequestGetMyGroups groupsOuterClass$RequestGetMyGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestGetMyGroups);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFilters(int i, GroupsStruct$GetMyGroupsFilter groupsStruct$GetMyGroupsFilter) {
        groupsStruct$GetMyGroupsFilter.getClass();
        ensureFiltersIsMutable();
        this.filters_.add(i, groupsStruct$GetMyGroupsFilter);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestGetMyGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMyGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
