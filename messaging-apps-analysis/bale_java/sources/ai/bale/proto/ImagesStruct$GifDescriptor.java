package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.M33;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ImagesStruct$GifDescriptor extends GeneratedMessageLite implements M33 {
    private static final ImagesStruct$GifDescriptor DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 5;
    public static final int FILE_SIZE_FIELD_NUMBER = 4;
    public static final int GIF_LOCATION_FIELD_NUMBER = 1;
    public static final int HEIGHT_FIELD_NUMBER = 3;
    public static final int MIME_TYPE_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int THUMB_FIELD_NUMBER = 7;
    public static final int USED_AT_FIELD_NUMBER = 6;
    public static final int WIDTH_FIELD_NUMBER = 2;
    private int bitField0_;
    private int duration_;
    private long fileSize_;
    private FilesStruct$FileLocation gifLocation_;
    private int height_;
    private StringValue mimeType_;
    private AbstractC2383g thumb_ = AbstractC2383g.b;
    private long usedAt_;
    private int width_;

    public static final class a extends GeneratedMessageLite.b implements M33 {
        private a() {
            super(ImagesStruct$GifDescriptor.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesStruct$GifDescriptor imagesStruct$GifDescriptor = new ImagesStruct$GifDescriptor();
        DEFAULT_INSTANCE = imagesStruct$GifDescriptor;
        GeneratedMessageLite.registerDefaultInstance(ImagesStruct$GifDescriptor.class, imagesStruct$GifDescriptor);
    }

    private ImagesStruct$GifDescriptor() {
    }

    private void clearDuration() {
        this.duration_ = 0;
    }

    private void clearFileSize() {
        this.fileSize_ = 0L;
    }

    private void clearGifLocation() {
        this.gifLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearHeight() {
        this.height_ = 0;
    }

    private void clearMimeType() {
        this.mimeType_ = null;
        this.bitField0_ &= -3;
    }

    private void clearThumb() {
        this.thumb_ = getDefaultInstance().getThumb();
    }

    private void clearUsedAt() {
        this.usedAt_ = 0L;
    }

    private void clearWidth() {
        this.width_ = 0;
    }

    public static ImagesStruct$GifDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGifLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.gifLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.gifLocation_ = filesStruct$FileLocation;
        } else {
            this.gifLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.gifLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMimeType(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.mimeType_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.mimeType_ = stringValue;
        } else {
            this.mimeType_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.mimeType_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesStruct$GifDescriptor parseDelimitedFrom(InputStream inputStream) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesStruct$GifDescriptor parseFrom(ByteBuffer byteBuffer) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDuration(int i) {
        this.duration_ = i;
    }

    private void setFileSize(long j) {
        this.fileSize_ = j;
    }

    private void setGifLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.gifLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setHeight(int i) {
        this.height_ = i;
    }

    private void setMimeType(StringValue stringValue) {
        stringValue.getClass();
        this.mimeType_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setThumb(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.thumb_ = abstractC2383g;
    }

    private void setUsedAt(long j) {
        this.usedAt_ = j;
    }

    private void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1886q0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesStruct$GifDescriptor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0004\u0004\u0002\u0005\u0004\u0006\u0002\u0007\n\bဉ\u0001", new Object[]{"bitField0_", "gifLocation_", "width_", "height_", "fileSize_", "duration_", "usedAt_", "thumb_", "mimeType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesStruct$GifDescriptor.class) {
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

    public int getDuration() {
        return this.duration_;
    }

    public long getFileSize() {
        return this.fileSize_;
    }

    public FilesStruct$FileLocation getGifLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.gifLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public int getHeight() {
        return this.height_;
    }

    public StringValue getMimeType() {
        StringValue stringValue = this.mimeType_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public AbstractC2383g getThumb() {
        return this.thumb_;
    }

    public long getUsedAt() {
        return this.usedAt_;
    }

    public int getWidth() {
        return this.width_;
    }

    public boolean hasGifLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMimeType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(ImagesStruct$GifDescriptor imagesStruct$GifDescriptor) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesStruct$GifDescriptor);
    }

    public static ImagesStruct$GifDescriptor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesStruct$GifDescriptor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesStruct$GifDescriptor parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesStruct$GifDescriptor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesStruct$GifDescriptor parseFrom(byte[] bArr) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesStruct$GifDescriptor parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesStruct$GifDescriptor parseFrom(InputStream inputStream) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesStruct$GifDescriptor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesStruct$GifDescriptor parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesStruct$GifDescriptor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesStruct$GifDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
