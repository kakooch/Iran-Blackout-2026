package ai.bale.proto;

import ai.bale.proto.FilesStruct$FastThumb;
import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$Intro extends GeneratedMessageLite implements U64 {
    private static final UsersStruct$Intro DEFAULT_INSTANCE;
    public static final int FILE_LOCATION_FIELD_NUMBER = 2;
    public static final int FILE_NAME_FIELD_NUMBER = 7;
    public static final int FILE_SIZE_FIELD_NUMBER = 5;
    public static final int HEIGHT_FIELD_NUMBER = 4;
    public static final int MIME_TYPE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    public static final int THUMB_FIELD_NUMBER = 8;
    public static final int WIDTH_FIELD_NUMBER = 3;
    private int bitField0_;
    private FilesStruct$FileLocation fileLocation_;
    private int fileSize_;
    private int height_;
    private StringValue text_;
    private FilesStruct$FastThumb thumb_;
    private int width_;
    private String mimeType_ = "";
    private String fileName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$Intro.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$Intro usersStruct$Intro = new UsersStruct$Intro();
        DEFAULT_INSTANCE = usersStruct$Intro;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$Intro.class, usersStruct$Intro);
    }

    private UsersStruct$Intro() {
    }

    private void clearFileLocation() {
        this.fileLocation_ = null;
        this.bitField0_ &= -3;
    }

    private void clearFileName() {
        this.fileName_ = getDefaultInstance().getFileName();
    }

    private void clearFileSize() {
        this.fileSize_ = 0;
    }

    private void clearHeight() {
        this.height_ = 0;
    }

    private void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    private void clearText() {
        this.text_ = null;
        this.bitField0_ &= -2;
    }

    private void clearThumb() {
        this.thumb_ = null;
        this.bitField0_ &= -5;
    }

    private void clearWidth() {
        this.width_ = 0;
    }

    public static UsersStruct$Intro getDefaultInstance() {
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
        this.bitField0_ |= 2;
    }

    private void mergeText(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.text_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.text_ = stringValue;
        } else {
            this.text_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.text_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        FilesStruct$FastThumb filesStruct$FastThumb2 = this.thumb_;
        if (filesStruct$FastThumb2 == null || filesStruct$FastThumb2 == FilesStruct$FastThumb.getDefaultInstance()) {
            this.thumb_ = filesStruct$FastThumb;
        } else {
            this.thumb_ = (FilesStruct$FastThumb) ((FilesStruct$FastThumb.a) FilesStruct$FastThumb.newBuilder(this.thumb_).v(filesStruct$FastThumb)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$Intro parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$Intro parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.fileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 2;
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

    private void setHeight(int i) {
        this.height_ = i;
    }

    private void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    private void setMimeTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mimeType_ = abstractC2383g.f0();
    }

    private void setText(StringValue stringValue) {
        stringValue.getClass();
        this.text_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        this.thumb_ = filesStruct$FastThumb;
        this.bitField0_ |= 4;
    }

    private void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$Intro();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0004\u0004\u0004\u0005\u0004\u0006Ȉ\u0007Ȉ\bဉ\u0002", new Object[]{"bitField0_", "text_", "fileLocation_", "width_", "height_", "fileSize_", "mimeType_", "fileName_", "thumb_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$Intro.class) {
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

    public int getHeight() {
        return this.height_;
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
    }

    public StringValue getText() {
        StringValue stringValue = this.text_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public FilesStruct$FastThumb getThumb() {
        FilesStruct$FastThumb filesStruct$FastThumb = this.thumb_;
        return filesStruct$FastThumb == null ? FilesStruct$FastThumb.getDefaultInstance() : filesStruct$FastThumb;
    }

    public int getWidth() {
        return this.width_;
    }

    public boolean hasFileLocation() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasText() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasThumb() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(UsersStruct$Intro usersStruct$Intro) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$Intro);
    }

    public static UsersStruct$Intro parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$Intro parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$Intro parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$Intro parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$Intro parseFrom(byte[] bArr) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$Intro parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$Intro parseFrom(InputStream inputStream) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$Intro parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$Intro parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$Intro parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$Intro) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
