package ai.bale.proto;

import ai.bale.proto.FilesStruct$ImageLocation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.K33;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ImagesStruct$AnimatedStickerDescriptor extends GeneratedMessageLite implements K33 {
    private static final ImagesStruct$AnimatedStickerDescriptor DEFAULT_INSTANCE;
    public static final int EMOJI_FIELD_NUMBER = 2;
    public static final int FILE_LOCATION_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue emoji_;
    private FilesStruct$ImageLocation fileLocation_;
    private int id_;

    public static final class a extends GeneratedMessageLite.b implements K33 {
        private a() {
            super(ImagesStruct$AnimatedStickerDescriptor.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesStruct$AnimatedStickerDescriptor imagesStruct$AnimatedStickerDescriptor = new ImagesStruct$AnimatedStickerDescriptor();
        DEFAULT_INSTANCE = imagesStruct$AnimatedStickerDescriptor;
        GeneratedMessageLite.registerDefaultInstance(ImagesStruct$AnimatedStickerDescriptor.class, imagesStruct$AnimatedStickerDescriptor);
    }

    private ImagesStruct$AnimatedStickerDescriptor() {
    }

    private void clearEmoji() {
        this.emoji_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileLocation() {
        this.fileLocation_ = null;
        this.bitField0_ &= -3;
    }

    private void clearId() {
        this.id_ = 0;
    }

    public static ImagesStruct$AnimatedStickerDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeEmoji(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.emoji_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.emoji_ = stringValue;
        } else {
            this.emoji_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.emoji_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeFileLocation(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.fileLocation_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.fileLocation_ = filesStruct$ImageLocation;
        } else {
            this.fileLocation_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.fileLocation_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseDelimitedFrom(InputStream inputStream) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(ByteBuffer byteBuffer) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEmoji(StringValue stringValue) {
        stringValue.getClass();
        this.emoji_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setFileLocation(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.fileLocation_ = filesStruct$ImageLocation;
        this.bitField0_ |= 2;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1886q0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesStruct$AnimatedStickerDescriptor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "id_", "emoji_", "fileLocation_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesStruct$AnimatedStickerDescriptor.class) {
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

    public StringValue getEmoji() {
        StringValue stringValue = this.emoji_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public FilesStruct$ImageLocation getFileLocation() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.fileLocation_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public int getId() {
        return this.id_;
    }

    public boolean hasEmoji() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasFileLocation() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(ImagesStruct$AnimatedStickerDescriptor imagesStruct$AnimatedStickerDescriptor) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesStruct$AnimatedStickerDescriptor);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(byte[] bArr) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(InputStream inputStream) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesStruct$AnimatedStickerDescriptor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesStruct$AnimatedStickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
