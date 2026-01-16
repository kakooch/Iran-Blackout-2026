package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC24932zS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsStruct$FilterGroupType extends GeneratedMessageLite implements U64 {
    private static final GroupsStruct$FilterGroupType DEFAULT_INSTANCE;
    public static final int GROUP_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int groupType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(EnumC24932zS2 enumC24932zS2) {
            q();
            ((GroupsStruct$FilterGroupType) this.b).setGroupType(enumC24932zS2);
            return this;
        }

        private a() {
            super(GroupsStruct$FilterGroupType.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$FilterGroupType groupsStruct$FilterGroupType = new GroupsStruct$FilterGroupType();
        DEFAULT_INSTANCE = groupsStruct$FilterGroupType;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$FilterGroupType.class, groupsStruct$FilterGroupType);
    }

    private GroupsStruct$FilterGroupType() {
    }

    private void clearGroupType() {
        this.groupType_ = 0;
    }

    public static GroupsStruct$FilterGroupType getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$FilterGroupType parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$FilterGroupType parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupType(EnumC24932zS2 enumC24932zS2) {
        this.groupType_ = enumC24932zS2.getNumber();
    }

    private void setGroupTypeValue(int i) {
        this.groupType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$FilterGroupType();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"groupType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$FilterGroupType.class) {
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

    public EnumC24932zS2 getGroupType() {
        EnumC24932zS2 enumC24932zS2J = EnumC24932zS2.j(this.groupType_);
        return enumC24932zS2J == null ? EnumC24932zS2.UNRECOGNIZED : enumC24932zS2J;
    }

    public int getGroupTypeValue() {
        return this.groupType_;
    }

    public static a newBuilder(GroupsStruct$FilterGroupType groupsStruct$FilterGroupType) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$FilterGroupType);
    }

    public static GroupsStruct$FilterGroupType parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$FilterGroupType parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$FilterGroupType parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$FilterGroupType parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$FilterGroupType parseFrom(byte[] bArr) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$FilterGroupType parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$FilterGroupType parseFrom(InputStream inputStream) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$FilterGroupType parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$FilterGroupType parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$FilterGroupType parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$FilterGroupType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
