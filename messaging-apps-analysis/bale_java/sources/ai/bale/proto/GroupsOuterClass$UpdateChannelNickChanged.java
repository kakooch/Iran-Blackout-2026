package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateChannelNickChanged extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateChannelNickChanged DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int NICK_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int groupId_;
    private String nick_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateChannelNickChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateChannelNickChanged groupsOuterClass$UpdateChannelNickChanged = new GroupsOuterClass$UpdateChannelNickChanged();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateChannelNickChanged;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateChannelNickChanged.class, groupsOuterClass$UpdateChannelNickChanged);
    }

    private GroupsOuterClass$UpdateChannelNickChanged() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearNick() {
        this.nick_ = getDefaultInstance().getNick();
    }

    public static GroupsOuterClass$UpdateChannelNickChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setNick(String str) {
        str.getClass();
        this.nick_ = str;
    }

    private void setNickBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nick_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateChannelNickChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"groupId_", "nick_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateChannelNickChanged.class) {
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

    public String getNick() {
        return this.nick_;
    }

    public AbstractC2383g getNickBytes() {
        return AbstractC2383g.N(this.nick_);
    }

    public static a newBuilder(GroupsOuterClass$UpdateChannelNickChanged groupsOuterClass$UpdateChannelNickChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateChannelNickChanged);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateChannelNickChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelNickChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
