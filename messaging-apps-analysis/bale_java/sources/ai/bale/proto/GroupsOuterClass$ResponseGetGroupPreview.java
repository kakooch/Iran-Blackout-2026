package ai.bale.proto;

import ai.bale.proto.GroupsStruct$FullGroup;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC24338yS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseGetGroupPreview extends GeneratedMessageLite implements U64 {
    public static final int ACTION_FIELD_NUMBER = 2;
    private static final GroupsOuterClass$ResponseGetGroupPreview DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int action_;
    private int bitField0_;
    private GroupsStruct$FullGroup group_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseGetGroupPreview.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseGetGroupPreview groupsOuterClass$ResponseGetGroupPreview = new GroupsOuterClass$ResponseGetGroupPreview();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseGetGroupPreview;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseGetGroupPreview.class, groupsOuterClass$ResponseGetGroupPreview);
    }

    private GroupsOuterClass$ResponseGetGroupPreview() {
    }

    private void clearAction() {
        this.action_ = 0;
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$ResponseGetGroupPreview getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroup(GroupsStruct$FullGroup groupsStruct$FullGroup) {
        groupsStruct$FullGroup.getClass();
        GroupsStruct$FullGroup groupsStruct$FullGroup2 = this.group_;
        if (groupsStruct$FullGroup2 == null || groupsStruct$FullGroup2 == GroupsStruct$FullGroup.getDefaultInstance()) {
            this.group_ = groupsStruct$FullGroup;
        } else {
            this.group_ = (GroupsStruct$FullGroup) ((GroupsStruct$FullGroup.a) GroupsStruct$FullGroup.newBuilder(this.group_).v(groupsStruct$FullGroup)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(EnumC24338yS2 enumC24338yS2) {
        this.action_ = enumC24338yS2.getNumber();
    }

    private void setActionValue(int i) {
        this.action_ = i;
    }

    private void setGroup(GroupsStruct$FullGroup groupsStruct$FullGroup) {
        groupsStruct$FullGroup.getClass();
        this.group_ = groupsStruct$FullGroup;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseGetGroupPreview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "group_", "action_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseGetGroupPreview.class) {
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

    public EnumC24338yS2 getAction() {
        EnumC24338yS2 enumC24338yS2J = EnumC24338yS2.j(this.action_);
        return enumC24338yS2J == null ? EnumC24338yS2.UNRECOGNIZED : enumC24338yS2J;
    }

    public int getActionValue() {
        return this.action_;
    }

    public GroupsStruct$FullGroup getGroup() {
        GroupsStruct$FullGroup groupsStruct$FullGroup = this.group_;
        return groupsStruct$FullGroup == null ? GroupsStruct$FullGroup.getDefaultInstance() : groupsStruct$FullGroup;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$ResponseGetGroupPreview groupsOuterClass$ResponseGetGroupPreview) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseGetGroupPreview);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseGetGroupPreview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
