package ai.bale.proto;

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
public final class UsersOuterClass$ResponseLoadAvatars extends GeneratedMessageLite implements U64 {
    public static final int AVATARS_FIELD_NUMBER = 1;
    private static final UsersOuterClass$ResponseLoadAvatars DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private FilesStruct$Avatars avatars_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$ResponseLoadAvatars.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$ResponseLoadAvatars usersOuterClass$ResponseLoadAvatars = new UsersOuterClass$ResponseLoadAvatars();
        DEFAULT_INSTANCE = usersOuterClass$ResponseLoadAvatars;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$ResponseLoadAvatars.class, usersOuterClass$ResponseLoadAvatars);
    }

    private UsersOuterClass$ResponseLoadAvatars() {
    }

    private void clearAvatars() {
        this.avatars_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersOuterClass$ResponseLoadAvatars getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAvatars(FilesStruct$Avatars filesStruct$Avatars) {
        filesStruct$Avatars.getClass();
        FilesStruct$Avatars filesStruct$Avatars2 = this.avatars_;
        if (filesStruct$Avatars2 == null || filesStruct$Avatars2 == FilesStruct$Avatars.getDefaultInstance()) {
            this.avatars_ = filesStruct$Avatars;
        } else {
            this.avatars_ = (FilesStruct$Avatars) ((FilesStruct$Avatars.a) FilesStruct$Avatars.newBuilder(this.avatars_).v(filesStruct$Avatars)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$ResponseLoadAvatars parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvatars(FilesStruct$Avatars filesStruct$Avatars) {
        filesStruct$Avatars.getClass();
        this.avatars_ = filesStruct$Avatars;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$ResponseLoadAvatars();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "avatars_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$ResponseLoadAvatars.class) {
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

    public FilesStruct$Avatars getAvatars() {
        FilesStruct$Avatars filesStruct$Avatars = this.avatars_;
        return filesStruct$Avatars == null ? FilesStruct$Avatars.getDefaultInstance() : filesStruct$Avatars;
    }

    public boolean hasAvatars() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$ResponseLoadAvatars usersOuterClass$ResponseLoadAvatars) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$ResponseLoadAvatars);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(byte[] bArr) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$ResponseLoadAvatars parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
