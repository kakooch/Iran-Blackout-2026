package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MagazineOuterClass$RequestRevokeUpvotedPost extends GeneratedMessageLite implements U64 {
    public static final int ALBUM_ID_FIELD_NUMBER = 2;
    private static final MagazineOuterClass$RequestRevokeUpvotedPost DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private CollectionsStruct$Int64Value albumId_;
    private int bitField0_;
    private MessagingStruct$HistoryMessageIdentifier message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
            q();
            ((MagazineOuterClass$RequestRevokeUpvotedPost) this.b).setMessage(messagingStruct$HistoryMessageIdentifier);
            return this;
        }

        private a() {
            super(MagazineOuterClass$RequestRevokeUpvotedPost.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineOuterClass$RequestRevokeUpvotedPost magazineOuterClass$RequestRevokeUpvotedPost = new MagazineOuterClass$RequestRevokeUpvotedPost();
        DEFAULT_INSTANCE = magazineOuterClass$RequestRevokeUpvotedPost;
        GeneratedMessageLite.registerDefaultInstance(MagazineOuterClass$RequestRevokeUpvotedPost.class, magazineOuterClass$RequestRevokeUpvotedPost);
    }

    private MagazineOuterClass$RequestRevokeUpvotedPost() {
    }

    private void clearAlbumId() {
        this.albumId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAlbumId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.albumId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.albumId_ = collectionsStruct$Int64Value;
        } else {
            this.albumId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.albumId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeMessage(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.message_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.message_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.message_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.message_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseDelimitedFrom(InputStream inputStream) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(ByteBuffer byteBuffer) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAlbumId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.albumId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.message_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineOuterClass$RequestRevokeUpvotedPost();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "message_", "albumId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineOuterClass$RequestRevokeUpvotedPost.class) {
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

    public CollectionsStruct$Int64Value getAlbumId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.albumId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public MessagingStruct$HistoryMessageIdentifier getMessage() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.message_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public boolean hasAlbumId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MagazineOuterClass$RequestRevokeUpvotedPost magazineOuterClass$RequestRevokeUpvotedPost) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineOuterClass$RequestRevokeUpvotedPost);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(byte[] bArr) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(InputStream inputStream) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineOuterClass$RequestRevokeUpvotedPost parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineOuterClass$RequestRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
