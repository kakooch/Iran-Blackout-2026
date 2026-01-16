package ai.bale.proto;

import ai.bale.proto.FilesStruct$ImageLocation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.Q33;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ImagesStruct$StickerDescriptor extends GeneratedMessageLite implements Q33 {
    private static final ImagesStruct$StickerDescriptor DEFAULT_INSTANCE;
    public static final int EMOJI_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IMAGE128_FIELD_NUMBER = 3;
    public static final int IMAGE256_FIELD_NUMBER = 5;
    public static final int IMAGE512_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue emoji_;
    private int id_;
    private FilesStruct$ImageLocation image128_;
    private FilesStruct$ImageLocation image256_;
    private FilesStruct$ImageLocation image512_;

    public static final class a extends GeneratedMessageLite.b implements Q33 {
        private a() {
            super(ImagesStruct$StickerDescriptor.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesStruct$StickerDescriptor imagesStruct$StickerDescriptor = new ImagesStruct$StickerDescriptor();
        DEFAULT_INSTANCE = imagesStruct$StickerDescriptor;
        GeneratedMessageLite.registerDefaultInstance(ImagesStruct$StickerDescriptor.class, imagesStruct$StickerDescriptor);
    }

    private ImagesStruct$StickerDescriptor() {
    }

    private void clearEmoji() {
        this.emoji_ = null;
        this.bitField0_ &= -2;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearImage128() {
        this.image128_ = null;
        this.bitField0_ &= -3;
    }

    private void clearImage256() {
        this.image256_ = null;
        this.bitField0_ &= -9;
    }

    private void clearImage512() {
        this.image512_ = null;
        this.bitField0_ &= -5;
    }

    public static ImagesStruct$StickerDescriptor getDefaultInstance() {
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

    private void mergeImage128(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.image128_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.image128_ = filesStruct$ImageLocation;
        } else {
            this.image128_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.image128_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeImage256(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.image256_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.image256_ = filesStruct$ImageLocation;
        } else {
            this.image256_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.image256_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeImage512(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.image512_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.image512_ = filesStruct$ImageLocation;
        } else {
            this.image512_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.image512_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesStruct$StickerDescriptor parseDelimitedFrom(InputStream inputStream) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(ByteBuffer byteBuffer) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEmoji(StringValue stringValue) {
        stringValue.getClass();
        this.emoji_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setImage128(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.image128_ = filesStruct$ImageLocation;
        this.bitField0_ |= 2;
    }

    private void setImage256(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.image256_ = filesStruct$ImageLocation;
        this.bitField0_ |= 8;
    }

    private void setImage512(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.image512_ = filesStruct$ImageLocation;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1886q0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesStruct$StickerDescriptor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003", new Object[]{"bitField0_", "id_", "emoji_", "image128_", "image512_", "image256_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesStruct$StickerDescriptor.class) {
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

    public int getId() {
        return this.id_;
    }

    public FilesStruct$ImageLocation getImage128() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.image128_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public FilesStruct$ImageLocation getImage256() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.image256_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public FilesStruct$ImageLocation getImage512() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.image512_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public boolean hasEmoji() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasImage128() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasImage256() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasImage512() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(ImagesStruct$StickerDescriptor imagesStruct$StickerDescriptor) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesStruct$StickerDescriptor);
    }

    public static ImagesStruct$StickerDescriptor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(byte[] bArr) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(InputStream inputStream) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesStruct$StickerDescriptor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesStruct$StickerDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
