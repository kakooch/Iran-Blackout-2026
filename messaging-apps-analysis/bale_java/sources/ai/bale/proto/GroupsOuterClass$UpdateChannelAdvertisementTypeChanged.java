package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC8025Uf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateChannelAdvertisementTypeChanged extends GeneratedMessageLite implements U64 {
    public static final int ADVERTISEMENT_TYPE_FIELD_NUMBER = 2;
    private static final GroupsOuterClass$UpdateChannelAdvertisementTypeChanged DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int advertisementType_;
    private int groupId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateChannelAdvertisementTypeChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateChannelAdvertisementTypeChanged groupsOuterClass$UpdateChannelAdvertisementTypeChanged = new GroupsOuterClass$UpdateChannelAdvertisementTypeChanged();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateChannelAdvertisementTypeChanged;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateChannelAdvertisementTypeChanged.class, groupsOuterClass$UpdateChannelAdvertisementTypeChanged);
    }

    private GroupsOuterClass$UpdateChannelAdvertisementTypeChanged() {
    }

    private void clearAdvertisementType() {
        this.advertisementType_ = 0;
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdvertisementType(EnumC8025Uf enumC8025Uf) {
        this.advertisementType_ = enumC8025Uf.getNumber();
    }

    private void setAdvertisementTypeValue(int i) {
        this.advertisementType_ = i;
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateChannelAdvertisementTypeChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\f", new Object[]{"groupId_", "advertisementType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged.class) {
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

    public EnumC8025Uf getAdvertisementType() {
        EnumC8025Uf enumC8025UfJ = EnumC8025Uf.j(this.advertisementType_);
        return enumC8025UfJ == null ? EnumC8025Uf.UNRECOGNIZED : enumC8025UfJ;
    }

    public int getAdvertisementTypeValue() {
        return this.advertisementType_;
    }

    public int getGroupId() {
        return this.groupId_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateChannelAdvertisementTypeChanged groupsOuterClass$UpdateChannelAdvertisementTypeChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateChannelAdvertisementTypeChanged);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateChannelAdvertisementTypeChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
