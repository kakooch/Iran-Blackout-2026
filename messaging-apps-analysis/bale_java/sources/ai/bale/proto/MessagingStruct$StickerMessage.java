package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.FilesStruct$ImageLocation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$StickerMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$StickerMessage DEFAULT_INSTANCE;
    public static final int FAST_PREVIEW_FIELD_NUMBER = 2;
    public static final int IMAGE256_FIELD_NUMBER = 4;
    public static final int IMAGE512_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int STICKER_COLLECTION_ACCESS_HASH_FIELD_NUMBER = 6;
    public static final int STICKER_COLLECTION_ID_FIELD_NUMBER = 5;
    public static final int STICKER_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private BytesValue fastPreview_;
    private FilesStruct$ImageLocation image256_;
    private FilesStruct$ImageLocation image512_;
    private CollectionsStruct$Int64Value stickerCollectionAccessHash_;
    private Int32Value stickerCollectionId_;
    private Int32Value stickerId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$StickerMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$StickerMessage messagingStruct$StickerMessage = new MessagingStruct$StickerMessage();
        DEFAULT_INSTANCE = messagingStruct$StickerMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$StickerMessage.class, messagingStruct$StickerMessage);
    }

    private MessagingStruct$StickerMessage() {
    }

    private void clearFastPreview() {
        this.fastPreview_ = null;
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

    private void clearStickerCollectionAccessHash() {
        this.stickerCollectionAccessHash_ = null;
        this.bitField0_ &= -33;
    }

    private void clearStickerCollectionId() {
        this.stickerCollectionId_ = null;
        this.bitField0_ &= -17;
    }

    private void clearStickerId() {
        this.stickerId_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$StickerMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFastPreview(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.fastPreview_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.fastPreview_ = bytesValue;
        } else {
            this.fastPreview_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.fastPreview_).v(bytesValue)).j();
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

    private void mergeStickerCollectionAccessHash(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.stickerCollectionAccessHash_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.stickerCollectionAccessHash_ = collectionsStruct$Int64Value;
        } else {
            this.stickerCollectionAccessHash_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.stickerCollectionAccessHash_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeStickerCollectionId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.stickerCollectionId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.stickerCollectionId_ = int32Value;
        } else {
            this.stickerCollectionId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.stickerCollectionId_).v(int32Value)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeStickerId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.stickerId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.stickerId_ = int32Value;
        } else {
            this.stickerId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.stickerId_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$StickerMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$StickerMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFastPreview(BytesValue bytesValue) {
        bytesValue.getClass();
        this.fastPreview_ = bytesValue;
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

    private void setStickerCollectionAccessHash(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.stickerCollectionAccessHash_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 32;
    }

    private void setStickerCollectionId(Int32Value int32Value) {
        int32Value.getClass();
        this.stickerCollectionId_ = int32Value;
        this.bitField0_ |= 16;
    }

    private void setStickerId(Int32Value int32Value) {
        int32Value.getClass();
        this.stickerId_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$StickerMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005", new Object[]{"bitField0_", "stickerId_", "fastPreview_", "image512_", "image256_", "stickerCollectionId_", "stickerCollectionAccessHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$StickerMessage.class) {
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

    public BytesValue getFastPreview() {
        BytesValue bytesValue = this.fastPreview_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public FilesStruct$ImageLocation getImage256() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.image256_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public FilesStruct$ImageLocation getImage512() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.image512_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public CollectionsStruct$Int64Value getStickerCollectionAccessHash() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.stickerCollectionAccessHash_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public Int32Value getStickerCollectionId() {
        Int32Value int32Value = this.stickerCollectionId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public Int32Value getStickerId() {
        Int32Value int32Value = this.stickerId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasFastPreview() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasImage256() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasImage512() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasStickerCollectionAccessHash() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasStickerCollectionId() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasStickerId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$StickerMessage messagingStruct$StickerMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$StickerMessage);
    }

    public static MessagingStruct$StickerMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$StickerMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$StickerMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$StickerMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$StickerMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$StickerMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$StickerMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$StickerMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$StickerMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$StickerMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$StickerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
