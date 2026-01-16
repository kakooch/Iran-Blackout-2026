package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.FilesStruct$AvatarImage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4779Gn2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesStruct$Avatar extends GeneratedMessageLite implements InterfaceC4779Gn2 {
    public static final int DATE_FIELD_NUMBER = 5;
    private static final FilesStruct$Avatar DEFAULT_INSTANCE;
    public static final int FULL_IMAGE_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 4;
    public static final int LARGE_IMAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SMALL_IMAGE_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$Int64Value date_;
    private FilesStruct$AvatarImage fullImage_;
    private CollectionsStruct$Int64Value id_;
    private FilesStruct$AvatarImage largeImage_;
    private FilesStruct$AvatarImage smallImage_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4779Gn2 {
        private a() {
            super(FilesStruct$Avatar.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$Avatar filesStruct$Avatar = new FilesStruct$Avatar();
        DEFAULT_INSTANCE = filesStruct$Avatar;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$Avatar.class, filesStruct$Avatar);
    }

    private FilesStruct$Avatar() {
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -17;
    }

    private void clearFullImage() {
        this.fullImage_ = null;
        this.bitField0_ &= -5;
    }

    private void clearId() {
        this.id_ = null;
        this.bitField0_ &= -9;
    }

    private void clearLargeImage() {
        this.largeImage_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSmallImage() {
        this.smallImage_ = null;
        this.bitField0_ &= -2;
    }

    public static FilesStruct$Avatar getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.date_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.date_ = collectionsStruct$Int64Value;
        } else {
            this.date_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.date_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeFullImage(FilesStruct$AvatarImage filesStruct$AvatarImage) {
        filesStruct$AvatarImage.getClass();
        FilesStruct$AvatarImage filesStruct$AvatarImage2 = this.fullImage_;
        if (filesStruct$AvatarImage2 == null || filesStruct$AvatarImage2 == FilesStruct$AvatarImage.getDefaultInstance()) {
            this.fullImage_ = filesStruct$AvatarImage;
        } else {
            this.fullImage_ = (FilesStruct$AvatarImage) ((FilesStruct$AvatarImage.a) FilesStruct$AvatarImage.newBuilder(this.fullImage_).v(filesStruct$AvatarImage)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.id_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.id_ = collectionsStruct$Int64Value;
        } else {
            this.id_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.id_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeLargeImage(FilesStruct$AvatarImage filesStruct$AvatarImage) {
        filesStruct$AvatarImage.getClass();
        FilesStruct$AvatarImage filesStruct$AvatarImage2 = this.largeImage_;
        if (filesStruct$AvatarImage2 == null || filesStruct$AvatarImage2 == FilesStruct$AvatarImage.getDefaultInstance()) {
            this.largeImage_ = filesStruct$AvatarImage;
        } else {
            this.largeImage_ = (FilesStruct$AvatarImage) ((FilesStruct$AvatarImage.a) FilesStruct$AvatarImage.newBuilder(this.largeImage_).v(filesStruct$AvatarImage)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSmallImage(FilesStruct$AvatarImage filesStruct$AvatarImage) {
        filesStruct$AvatarImage.getClass();
        FilesStruct$AvatarImage filesStruct$AvatarImage2 = this.smallImage_;
        if (filesStruct$AvatarImage2 == null || filesStruct$AvatarImage2 == FilesStruct$AvatarImage.getDefaultInstance()) {
            this.smallImage_ = filesStruct$AvatarImage;
        } else {
            this.smallImage_ = (FilesStruct$AvatarImage) ((FilesStruct$AvatarImage.a) FilesStruct$AvatarImage.newBuilder(this.smallImage_).v(filesStruct$AvatarImage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$Avatar parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$Avatar parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.date_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 16;
    }

    private void setFullImage(FilesStruct$AvatarImage filesStruct$AvatarImage) {
        filesStruct$AvatarImage.getClass();
        this.fullImage_ = filesStruct$AvatarImage;
        this.bitField0_ |= 4;
    }

    private void setId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.id_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 8;
    }

    private void setLargeImage(FilesStruct$AvatarImage filesStruct$AvatarImage) {
        filesStruct$AvatarImage.getClass();
        this.largeImage_ = filesStruct$AvatarImage;
        this.bitField0_ |= 2;
    }

    private void setSmallImage(FilesStruct$AvatarImage filesStruct$AvatarImage) {
        filesStruct$AvatarImage.getClass();
        this.smallImage_ = filesStruct$AvatarImage;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$Avatar();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"bitField0_", "smallImage_", "largeImage_", "fullImage_", "id_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$Avatar.class) {
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

    public CollectionsStruct$Int64Value getDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.date_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public FilesStruct$AvatarImage getFullImage() {
        FilesStruct$AvatarImage filesStruct$AvatarImage = this.fullImage_;
        return filesStruct$AvatarImage == null ? FilesStruct$AvatarImage.getDefaultInstance() : filesStruct$AvatarImage;
    }

    public CollectionsStruct$Int64Value getId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.id_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public FilesStruct$AvatarImage getLargeImage() {
        FilesStruct$AvatarImage filesStruct$AvatarImage = this.largeImage_;
        return filesStruct$AvatarImage == null ? FilesStruct$AvatarImage.getDefaultInstance() : filesStruct$AvatarImage;
    }

    public FilesStruct$AvatarImage getSmallImage() {
        FilesStruct$AvatarImage filesStruct$AvatarImage = this.smallImage_;
        return filesStruct$AvatarImage == null ? FilesStruct$AvatarImage.getDefaultInstance() : filesStruct$AvatarImage;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasFullImage() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasId() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasLargeImage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSmallImage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(FilesStruct$Avatar filesStruct$Avatar) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$Avatar);
    }

    public static FilesStruct$Avatar parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$Avatar parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$Avatar parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesStruct$Avatar parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$Avatar parseFrom(byte[] bArr) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$Avatar parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$Avatar parseFrom(InputStream inputStream) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$Avatar parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$Avatar parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$Avatar parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$Avatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
