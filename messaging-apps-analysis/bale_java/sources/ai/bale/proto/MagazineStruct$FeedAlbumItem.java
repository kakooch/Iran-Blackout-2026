package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.MessagingStruct$MessageId;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23695xM3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MagazineStruct$FeedAlbumItem extends GeneratedMessageLite implements InterfaceC23695xM3 {
    private static final MagazineStruct$FeedAlbumItem DEFAULT_INSTANCE;
    public static final int DOCUMENT_MESSAGE_FIELD_NUMBER = 1;
    public static final int MESSAGEID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$DocumentMessage documentMessage_;
    private MessagingStruct$MessageId messageId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23695xM3 {
        private a() {
            super(MagazineStruct$FeedAlbumItem.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineStruct$FeedAlbumItem magazineStruct$FeedAlbumItem = new MagazineStruct$FeedAlbumItem();
        DEFAULT_INSTANCE = magazineStruct$FeedAlbumItem;
        GeneratedMessageLite.registerDefaultInstance(MagazineStruct$FeedAlbumItem.class, magazineStruct$FeedAlbumItem);
    }

    private MagazineStruct$FeedAlbumItem() {
    }

    private void clearDocumentMessage() {
        this.documentMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -3;
    }

    public static MagazineStruct$FeedAlbumItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage2 = this.documentMessage_;
        if (messagingStruct$DocumentMessage2 == null || messagingStruct$DocumentMessage2 == MessagingStruct$DocumentMessage.getDefaultInstance()) {
            this.documentMessage_ = messagingStruct$DocumentMessage;
        } else {
            this.documentMessage_ = (MessagingStruct$DocumentMessage) ((MessagingStruct$DocumentMessage.a) MessagingStruct$DocumentMessage.newBuilder(this.documentMessage_).v(messagingStruct$DocumentMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.messageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.messageId_ = messagingStruct$MessageId;
        } else {
            this.messageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.messageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineStruct$FeedAlbumItem parseDelimitedFrom(InputStream inputStream) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(ByteBuffer byteBuffer) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.documentMessage_ = messagingStruct$DocumentMessage;
        this.bitField0_ |= 1;
    }

    private void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineStruct$FeedAlbumItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "documentMessage_", "messageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineStruct$FeedAlbumItem.class) {
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

    public MessagingStruct$DocumentMessage getDocumentMessage() {
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = this.documentMessage_;
        return messagingStruct$DocumentMessage == null ? MessagingStruct$DocumentMessage.getDefaultInstance() : messagingStruct$DocumentMessage;
    }

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public boolean hasDocumentMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MagazineStruct$FeedAlbumItem magazineStruct$FeedAlbumItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineStruct$FeedAlbumItem);
    }

    public static MagazineStruct$FeedAlbumItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(byte[] bArr) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(InputStream inputStream) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineStruct$FeedAlbumItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
