package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.UsersStruct$MediaExt;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$IntroMedia extends GeneratedMessageLite implements U64 {
    private static final UsersStruct$IntroMedia DEFAULT_INSTANCE;
    public static final int FILE_LOCATION_FIELD_NUMBER = 1;
    public static final int FILE_NAME_FIELD_NUMBER = 4;
    public static final int FILE_SIZE_FIELD_NUMBER = 2;
    public static final int MEDIA_EXTRA_FIELD_NUMBER = 5;
    public static final int MIME_TYPE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private FilesStruct$FileLocation fileLocation_;
    private int fileSize_;
    private UsersStruct$MediaExt mediaExtra_;
    private String mimeType_ = "";
    private String fileName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$IntroMedia.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$IntroMedia usersStruct$IntroMedia = new UsersStruct$IntroMedia();
        DEFAULT_INSTANCE = usersStruct$IntroMedia;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$IntroMedia.class, usersStruct$IntroMedia);
    }

    private UsersStruct$IntroMedia() {
    }

    private void clearFileLocation() {
        this.fileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileName() {
        this.fileName_ = getDefaultInstance().getFileName();
    }

    private void clearFileSize() {
        this.fileSize_ = 0;
    }

    private void clearMediaExtra() {
        this.mediaExtra_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    public static UsersStruct$IntroMedia getDefaultInstance() {
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

    private void mergeMediaExtra(UsersStruct$MediaExt usersStruct$MediaExt) {
        usersStruct$MediaExt.getClass();
        UsersStruct$MediaExt usersStruct$MediaExt2 = this.mediaExtra_;
        if (usersStruct$MediaExt2 == null || usersStruct$MediaExt2 == UsersStruct$MediaExt.getDefaultInstance()) {
            this.mediaExtra_ = usersStruct$MediaExt;
        } else {
            this.mediaExtra_ = (UsersStruct$MediaExt) ((UsersStruct$MediaExt.a) UsersStruct$MediaExt.newBuilder(this.mediaExtra_).v(usersStruct$MediaExt)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$IntroMedia parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$IntroMedia parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.fileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setFileName(String str) {
        str.getClass();
        this.fileName_ = str;
    }

    private void setFileNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fileName_ = abstractC2383g.f0();
    }

    private void setFileSize(int i) {
        this.fileSize_ = i;
    }

    private void setMediaExtra(UsersStruct$MediaExt usersStruct$MediaExt) {
        usersStruct$MediaExt.getClass();
        this.mediaExtra_ = usersStruct$MediaExt;
        this.bitField0_ |= 2;
    }

    private void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    private void setMimeTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mimeType_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$IntroMedia();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003Ȉ\u0004Ȉ\u0005ဉ\u0001", new Object[]{"bitField0_", "fileLocation_", "fileSize_", "mimeType_", "fileName_", "mediaExtra_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$IntroMedia.class) {
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

    public String getFileName() {
        return this.fileName_;
    }

    public AbstractC2383g getFileNameBytes() {
        return AbstractC2383g.N(this.fileName_);
    }

    public int getFileSize() {
        return this.fileSize_;
    }

    public UsersStruct$MediaExt getMediaExtra() {
        UsersStruct$MediaExt usersStruct$MediaExt = this.mediaExtra_;
        return usersStruct$MediaExt == null ? UsersStruct$MediaExt.getDefaultInstance() : usersStruct$MediaExt;
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
    }

    public boolean hasFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMediaExtra() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(UsersStruct$IntroMedia usersStruct$IntroMedia) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$IntroMedia);
    }

    public static UsersStruct$IntroMedia parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$IntroMedia parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$IntroMedia parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$IntroMedia parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$IntroMedia parseFrom(byte[] bArr) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$IntroMedia parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$IntroMedia parseFrom(InputStream inputStream) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$IntroMedia parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$IntroMedia parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$IntroMedia parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$IntroMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
