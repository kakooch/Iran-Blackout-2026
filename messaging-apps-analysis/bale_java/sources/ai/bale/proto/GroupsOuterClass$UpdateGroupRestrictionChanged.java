package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.GS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupRestrictionChanged extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateGroupRestrictionChanged DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RESTRICTION_FIELD_NUMBER = 2;
    private int groupId_;
    private int restriction_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupRestrictionChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupRestrictionChanged groupsOuterClass$UpdateGroupRestrictionChanged = new GroupsOuterClass$UpdateGroupRestrictionChanged();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupRestrictionChanged;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupRestrictionChanged.class, groupsOuterClass$UpdateGroupRestrictionChanged);
    }

    private GroupsOuterClass$UpdateGroupRestrictionChanged() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearRestriction() {
        this.restriction_ = 0;
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setRestriction(GS2 gs2) {
        this.restriction_ = gs2.getNumber();
    }

    private void setRestrictionValue(int i) {
        this.restriction_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupRestrictionChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\f", new Object[]{"groupId_", "restriction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupRestrictionChanged.class) {
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

    public int getGroupId() {
        return this.groupId_;
    }

    public GS2 getRestriction() {
        GS2 gs2J = GS2.j(this.restriction_);
        return gs2J == null ? GS2.UNRECOGNIZED : gs2J;
    }

    public int getRestrictionValue() {
        return this.restriction_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupRestrictionChanged groupsOuterClass$UpdateGroupRestrictionChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupRestrictionChanged);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupRestrictionChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupRestrictionChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
