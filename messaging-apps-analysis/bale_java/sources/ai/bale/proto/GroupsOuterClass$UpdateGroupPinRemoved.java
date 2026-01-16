package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupPinRemoved extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateGroupPinRemoved DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int MESSAGE_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int groupId_;
    private MessagingStruct$MessageId messageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupPinRemoved.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupPinRemoved groupsOuterClass$UpdateGroupPinRemoved = new GroupsOuterClass$UpdateGroupPinRemoved();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupPinRemoved;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupPinRemoved.class, groupsOuterClass$UpdateGroupPinRemoved);
    }

    private GroupsOuterClass$UpdateGroupPinRemoved() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.messageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.messageId_ = messagingStruct$MessageId;
        } else {
            this.messageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.messageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupPinRemoved();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "groupId_", "messageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupPinRemoved.class) {
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

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupPinRemoved groupsOuterClass$UpdateGroupPinRemoved) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupPinRemoved);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupPinRemoved parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupPinRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
