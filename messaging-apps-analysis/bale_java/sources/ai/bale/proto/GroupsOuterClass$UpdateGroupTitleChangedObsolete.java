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
public final class GroupsOuterClass$UpdateGroupTitleChangedObsolete extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 4;
    private static final GroupsOuterClass$UpdateGroupTitleChangedObsolete DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 2;
    private long date_;
    private int groupId_;
    private long rid_;
    private String title_ = "";
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupTitleChangedObsolete.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupTitleChangedObsolete groupsOuterClass$UpdateGroupTitleChangedObsolete = new GroupsOuterClass$UpdateGroupTitleChangedObsolete();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupTitleChangedObsolete;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupTitleChangedObsolete.class, groupsOuterClass$UpdateGroupTitleChangedObsolete);
    }

    private GroupsOuterClass$UpdateGroupTitleChangedObsolete() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupTitleChangedObsolete();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003Ȉ\u0004\u0002\u0005\u0002", new Object[]{"groupId_", "uid_", "title_", "date_", "rid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupTitleChangedObsolete.class) {
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

    public long getDate() {
        return this.date_;
    }

    public int getGroupId() {
        return this.groupId_;
    }

    public long getRid() {
        return this.rid_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupTitleChangedObsolete groupsOuterClass$UpdateGroupTitleChangedObsolete) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupTitleChangedObsolete);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupTitleChangedObsolete parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupTitleChangedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
