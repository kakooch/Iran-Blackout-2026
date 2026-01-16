package ai.bale.proto;

import ai.bale.proto.GroupsStruct$FullGroup;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseGetFullGroup extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$ResponseGetFullGroup DEFAULT_INSTANCE;
    public static final int FULL_GROUP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private GroupsStruct$FullGroup fullGroup_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseGetFullGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseGetFullGroup groupsOuterClass$ResponseGetFullGroup = new GroupsOuterClass$ResponseGetFullGroup();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseGetFullGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseGetFullGroup.class, groupsOuterClass$ResponseGetFullGroup);
    }

    private GroupsOuterClass$ResponseGetFullGroup() {
    }

    private void clearFullGroup() {
        this.fullGroup_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$ResponseGetFullGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFullGroup(GroupsStruct$FullGroup groupsStruct$FullGroup) {
        groupsStruct$FullGroup.getClass();
        GroupsStruct$FullGroup groupsStruct$FullGroup2 = this.fullGroup_;
        if (groupsStruct$FullGroup2 == null || groupsStruct$FullGroup2 == GroupsStruct$FullGroup.getDefaultInstance()) {
            this.fullGroup_ = groupsStruct$FullGroup;
        } else {
            this.fullGroup_ = (GroupsStruct$FullGroup) ((GroupsStruct$FullGroup.a) GroupsStruct$FullGroup.newBuilder(this.fullGroup_).v(groupsStruct$FullGroup)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFullGroup(GroupsStruct$FullGroup groupsStruct$FullGroup) {
        groupsStruct$FullGroup.getClass();
        this.fullGroup_ = groupsStruct$FullGroup;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseGetFullGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "fullGroup_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseGetFullGroup.class) {
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

    public GroupsStruct$FullGroup getFullGroup() {
        GroupsStruct$FullGroup groupsStruct$FullGroup = this.fullGroup_;
        return groupsStruct$FullGroup == null ? GroupsStruct$FullGroup.getDefaultInstance() : groupsStruct$FullGroup;
    }

    public boolean hasFullGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$ResponseGetFullGroup groupsOuterClass$ResponseGetFullGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseGetFullGroup);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseGetFullGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetFullGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
