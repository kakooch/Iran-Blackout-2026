package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageContainer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupMessagePinned extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateGroupMessagePinned DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int groupId_;
    private MessagingStruct$MessageContainer message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupMessagePinned.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupMessagePinned groupsOuterClass$UpdateGroupMessagePinned = new GroupsOuterClass$UpdateGroupMessagePinned();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupMessagePinned;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupMessagePinned.class, groupsOuterClass$UpdateGroupMessagePinned);
    }

    private GroupsOuterClass$UpdateGroupMessagePinned() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessage(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        MessagingStruct$MessageContainer messagingStruct$MessageContainer2 = this.message_;
        if (messagingStruct$MessageContainer2 == null || messagingStruct$MessageContainer2 == MessagingStruct$MessageContainer.getDefaultInstance()) {
            this.message_ = messagingStruct$MessageContainer;
        } else {
            this.message_ = (MessagingStruct$MessageContainer) ((MessagingStruct$MessageContainer.a) MessagingStruct$MessageContainer.newBuilder(this.message_).v(messagingStruct$MessageContainer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setMessage(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        this.message_ = messagingStruct$MessageContainer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupMessagePinned();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "groupId_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupMessagePinned.class) {
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

    public MessagingStruct$MessageContainer getMessage() {
        MessagingStruct$MessageContainer messagingStruct$MessageContainer = this.message_;
        return messagingStruct$MessageContainer == null ? MessagingStruct$MessageContainer.getDefaultInstance() : messagingStruct$MessageContainer;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupMessagePinned groupsOuterClass$UpdateGroupMessagePinned) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupMessagePinned);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupMessagePinned parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
