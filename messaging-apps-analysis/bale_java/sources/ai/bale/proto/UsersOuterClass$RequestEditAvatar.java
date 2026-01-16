package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestEditAvatar extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestEditAvatar DEFAULT_INSTANCE;
    public static final int FILE_LOCATION_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private FilesStruct$FileLocation fileLocation_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(FilesStruct$FileLocation.a aVar) {
            q();
            ((UsersOuterClass$RequestEditAvatar) this.b).setFileLocation((FilesStruct$FileLocation) aVar.a());
            return this;
        }

        public a B(FilesStruct$FileLocation filesStruct$FileLocation) {
            q();
            ((UsersOuterClass$RequestEditAvatar) this.b).setFileLocation(filesStruct$FileLocation);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestEditAvatar.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestEditAvatar usersOuterClass$RequestEditAvatar = new UsersOuterClass$RequestEditAvatar();
        DEFAULT_INSTANCE = usersOuterClass$RequestEditAvatar;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestEditAvatar.class, usersOuterClass$RequestEditAvatar);
    }

    private UsersOuterClass$RequestEditAvatar() {
    }

    private void clearFileLocation() {
        this.fileLocation_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersOuterClass$RequestEditAvatar getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.fileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.fileLocation_ = filesStruct$FileLocation;
        } else {
            this.fileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.fileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestEditAvatar parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.fileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestEditAvatar();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "fileLocation_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestEditAvatar.class) {
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

    public FilesStruct$FileLocation getFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.fileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public boolean hasFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$RequestEditAvatar usersOuterClass$RequestEditAvatar) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestEditAvatar);
    }

    public static UsersOuterClass$RequestEditAvatar parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestEditAvatar parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
