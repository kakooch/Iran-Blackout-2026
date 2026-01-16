package ai.bale.proto;

import ai.bale.proto.FilesStruct$Avatar;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseEditGroupAvatar extends GeneratedMessageLite implements U64 {
    public static final int AVATAR_FIELD_NUMBER = 1;
    public static final int DATE_FIELD_NUMBER = 4;
    private static final GroupsOuterClass$ResponseEditGroupAvatar DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 3;
    private FilesStruct$Avatar avatar_;
    private int bitField0_;
    private long date_;
    private int seq_;
    private AbstractC2383g state_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseEditGroupAvatar.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseEditGroupAvatar groupsOuterClass$ResponseEditGroupAvatar = new GroupsOuterClass$ResponseEditGroupAvatar();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseEditGroupAvatar;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseEditGroupAvatar.class, groupsOuterClass$ResponseEditGroupAvatar);
    }

    private GroupsOuterClass$ResponseEditGroupAvatar() {
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        FilesStruct$Avatar filesStruct$Avatar2 = this.avatar_;
        if (filesStruct$Avatar2 == null || filesStruct$Avatar2 == FilesStruct$Avatar.getDefaultInstance()) {
            this.avatar_ = filesStruct$Avatar;
        } else {
            this.avatar_ = (FilesStruct$Avatar) ((FilesStruct$Avatar.a) FilesStruct$Avatar.newBuilder(this.avatar_).v(filesStruct$Avatar)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.avatar_ = filesStruct$Avatar;
        this.bitField0_ |= 1;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseEditGroupAvatar();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\n\u0004\u0002", new Object[]{"bitField0_", "avatar_", "seq_", "state_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseEditGroupAvatar.class) {
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

    public FilesStruct$Avatar getAvatar() {
        FilesStruct$Avatar filesStruct$Avatar = this.avatar_;
        return filesStruct$Avatar == null ? FilesStruct$Avatar.getDefaultInstance() : filesStruct$Avatar;
    }

    public long getDate() {
        return this.date_;
    }

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$ResponseEditGroupAvatar groupsOuterClass$ResponseEditGroupAvatar) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseEditGroupAvatar);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseEditGroupAvatar parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseEditGroupAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
