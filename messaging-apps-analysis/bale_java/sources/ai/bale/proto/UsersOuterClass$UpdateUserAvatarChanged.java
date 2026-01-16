package ai.bale.proto;

import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.FilesStruct$Avatars;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$UpdateUserAvatarChanged extends GeneratedMessageLite implements U64 {
    public static final int AVATARS_FIELD_NUMBER = 3;
    public static final int AVATAR_FIELD_NUMBER = 2;
    private static final UsersOuterClass$UpdateUserAvatarChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private FilesStruct$Avatar avatar_;
    private FilesStruct$Avatars avatars_;
    private int bitField0_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateUserAvatarChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateUserAvatarChanged usersOuterClass$UpdateUserAvatarChanged = new UsersOuterClass$UpdateUserAvatarChanged();
        DEFAULT_INSTANCE = usersOuterClass$UpdateUserAvatarChanged;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateUserAvatarChanged.class, usersOuterClass$UpdateUserAvatarChanged);
    }

    private UsersOuterClass$UpdateUserAvatarChanged() {
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -2;
    }

    private void clearAvatars() {
        this.avatars_ = null;
        this.bitField0_ &= -3;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static UsersOuterClass$UpdateUserAvatarChanged getDefaultInstance() {
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

    private void mergeAvatars(FilesStruct$Avatars filesStruct$Avatars) {
        filesStruct$Avatars.getClass();
        FilesStruct$Avatars filesStruct$Avatars2 = this.avatars_;
        if (filesStruct$Avatars2 == null || filesStruct$Avatars2 == FilesStruct$Avatars.getDefaultInstance()) {
            this.avatars_ = filesStruct$Avatars;
        } else {
            this.avatars_ = (FilesStruct$Avatars) ((FilesStruct$Avatars.a) FilesStruct$Avatars.newBuilder(this.avatars_).v(filesStruct$Avatars)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.avatar_ = filesStruct$Avatar;
        this.bitField0_ |= 1;
    }

    private void setAvatars(FilesStruct$Avatars filesStruct$Avatars) {
        filesStruct$Avatars.getClass();
        this.avatars_ = filesStruct$Avatars;
        this.bitField0_ |= 2;
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateUserAvatarChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "uid_", "avatar_", "avatars_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateUserAvatarChanged.class) {
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

    public FilesStruct$Avatars getAvatars() {
        FilesStruct$Avatars filesStruct$Avatars = this.avatars_;
        return filesStruct$Avatars == null ? FilesStruct$Avatars.getDefaultInstance() : filesStruct$Avatars;
    }

    public int getUid() {
        return this.uid_;
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasAvatars() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(UsersOuterClass$UpdateUserAvatarChanged usersOuterClass$UpdateUserAvatarChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateUserAvatarChanged);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateUserAvatarChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserAvatarChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
