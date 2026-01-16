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
public final class GroupsOuterClass$UpdateGroupCanSendMessagesChanged extends GeneratedMessageLite implements U64 {
    public static final int CAN_SEND_MESSAGES_FIELD_NUMBER = 2;
    private static final GroupsOuterClass$UpdateGroupCanSendMessagesChanged DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean canSendMessages_;
    private int groupId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupCanSendMessagesChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupCanSendMessagesChanged groupsOuterClass$UpdateGroupCanSendMessagesChanged = new GroupsOuterClass$UpdateGroupCanSendMessagesChanged();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupCanSendMessagesChanged;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupCanSendMessagesChanged.class, groupsOuterClass$UpdateGroupCanSendMessagesChanged);
    }

    private GroupsOuterClass$UpdateGroupCanSendMessagesChanged() {
    }

    private void clearCanSendMessages() {
        this.canSendMessages_ = false;
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCanSendMessages(boolean z) {
        this.canSendMessages_ = z;
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupCanSendMessagesChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0007", new Object[]{"groupId_", "canSendMessages_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupCanSendMessagesChanged.class) {
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

    public boolean getCanSendMessages() {
        return this.canSendMessages_;
    }

    public int getGroupId() {
        return this.groupId_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupCanSendMessagesChanged groupsOuterClass$UpdateGroupCanSendMessagesChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupCanSendMessagesChanged);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupCanSendMessagesChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
