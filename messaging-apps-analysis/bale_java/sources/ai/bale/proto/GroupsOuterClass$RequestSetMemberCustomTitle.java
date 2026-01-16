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
public final class GroupsOuterClass$RequestSetMemberCustomTitle extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestSetMemberCustomTitle DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int MEMBER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int groupId_;
    private int memberId_;
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((GroupsOuterClass$RequestSetMemberCustomTitle) this.b).setGroupId(i);
            return this;
        }

        public a B(int i) {
            q();
            ((GroupsOuterClass$RequestSetMemberCustomTitle) this.b).setMemberId(i);
            return this;
        }

        public a C(String str) {
            q();
            ((GroupsOuterClass$RequestSetMemberCustomTitle) this.b).setTitle(str);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestSetMemberCustomTitle.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestSetMemberCustomTitle groupsOuterClass$RequestSetMemberCustomTitle = new GroupsOuterClass$RequestSetMemberCustomTitle();
        DEFAULT_INSTANCE = groupsOuterClass$RequestSetMemberCustomTitle;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestSetMemberCustomTitle.class, groupsOuterClass$RequestSetMemberCustomTitle);
    }

    private GroupsOuterClass$RequestSetMemberCustomTitle() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearMemberId() {
        this.memberId_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupId(int i) {
        this.groupId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemberId(int i) {
        this.memberId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestSetMemberCustomTitle();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003Ȉ", new Object[]{"groupId_", "memberId_", "title_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestSetMemberCustomTitle.class) {
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

    public int getMemberId() {
        return this.memberId_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(GroupsOuterClass$RequestSetMemberCustomTitle groupsOuterClass$RequestSetMemberCustomTitle) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestSetMemberCustomTitle);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestSetMemberCustomTitle parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetMemberCustomTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
