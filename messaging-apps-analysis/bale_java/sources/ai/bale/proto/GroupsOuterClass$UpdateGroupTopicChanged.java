package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupTopicChanged extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateGroupTopicChanged DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TOPIC_FIELD_NUMBER = 2;
    private int bitField0_;
    private int groupId_;
    private StringValue topic_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupTopicChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupTopicChanged groupsOuterClass$UpdateGroupTopicChanged = new GroupsOuterClass$UpdateGroupTopicChanged();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupTopicChanged;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupTopicChanged.class, groupsOuterClass$UpdateGroupTopicChanged);
    }

    private GroupsOuterClass$UpdateGroupTopicChanged() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearTopic() {
        this.topic_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTopic(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.topic_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.topic_ = stringValue;
        } else {
            this.topic_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.topic_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setTopic(StringValue stringValue) {
        stringValue.getClass();
        this.topic_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupTopicChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "groupId_", "topic_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupTopicChanged.class) {
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

    public StringValue getTopic() {
        StringValue stringValue = this.topic_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasTopic() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupTopicChanged groupsOuterClass$UpdateGroupTopicChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupTopicChanged);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupTopicChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTopicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
