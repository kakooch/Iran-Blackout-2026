package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupBecameOrphaned extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateGroupBecameOrphaned DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int groupId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupBecameOrphaned.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupBecameOrphaned groupsOuterClass$UpdateGroupBecameOrphaned = new GroupsOuterClass$UpdateGroupBecameOrphaned();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupBecameOrphaned;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupBecameOrphaned.class, groupsOuterClass$UpdateGroupBecameOrphaned);
    }

    private GroupsOuterClass$UpdateGroupBecameOrphaned() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupBecameOrphaned();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"groupId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupBecameOrphaned.class) {
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

    public static a newBuilder(GroupsOuterClass$UpdateGroupBecameOrphaned groupsOuterClass$UpdateGroupBecameOrphaned) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupBecameOrphaned);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupBecameOrphaned parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupBecameOrphaned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
