package ai.bale.proto;

import ai.bale.proto.MagazineStruct$FeedAlbumMessage;
import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.MessagingStruct$TextMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MagazineStruct$FeedMessage extends GeneratedMessageLite implements U64 {
    public static final int ALBUM_MESSAGE_FIELD_NUMBER = 3;
    private static final MagazineStruct$FeedMessage DEFAULT_INSTANCE;
    public static final int DOCUMENT_MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_MESSAGE_FIELD_NUMBER = 2;
    private int valueCase_ = 0;
    private Object value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MagazineStruct$FeedMessage.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        DOCUMENT_MESSAGE(1),
        TEXT_MESSAGE(2),
        ALBUM_MESSAGE(3),
        VALUE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return VALUE_NOT_SET;
            }
            if (i == 1) {
                return DOCUMENT_MESSAGE;
            }
            if (i == 2) {
                return TEXT_MESSAGE;
            }
            if (i != 3) {
                return null;
            }
            return ALBUM_MESSAGE;
        }
    }

    static {
        MagazineStruct$FeedMessage magazineStruct$FeedMessage = new MagazineStruct$FeedMessage();
        DEFAULT_INSTANCE = magazineStruct$FeedMessage;
        GeneratedMessageLite.registerDefaultInstance(MagazineStruct$FeedMessage.class, magazineStruct$FeedMessage);
    }

    private MagazineStruct$FeedMessage() {
    }

    private void clearAlbumMessage() {
        if (this.valueCase_ == 3) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearDocumentMessage() {
        if (this.valueCase_ == 1) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearTextMessage() {
        if (this.valueCase_ == 2) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearValue() {
        this.valueCase_ = 0;
        this.value_ = null;
    }

    public static MagazineStruct$FeedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAlbumMessage(MagazineStruct$FeedAlbumMessage magazineStruct$FeedAlbumMessage) {
        magazineStruct$FeedAlbumMessage.getClass();
        if (this.valueCase_ != 3 || this.value_ == MagazineStruct$FeedAlbumMessage.getDefaultInstance()) {
            this.value_ = magazineStruct$FeedAlbumMessage;
        } else {
            this.value_ = ((MagazineStruct$FeedAlbumMessage.a) MagazineStruct$FeedAlbumMessage.newBuilder((MagazineStruct$FeedAlbumMessage) this.value_).v(magazineStruct$FeedAlbumMessage)).j();
        }
        this.valueCase_ = 3;
    }

    private void mergeDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        if (this.valueCase_ != 1 || this.value_ == MessagingStruct$DocumentMessage.getDefaultInstance()) {
            this.value_ = messagingStruct$DocumentMessage;
        } else {
            this.value_ = ((MessagingStruct$DocumentMessage.a) MessagingStruct$DocumentMessage.newBuilder((MessagingStruct$DocumentMessage) this.value_).v(messagingStruct$DocumentMessage)).j();
        }
        this.valueCase_ = 1;
    }

    private void mergeTextMessage(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        messagingStruct$TextMessage.getClass();
        if (this.valueCase_ != 2 || this.value_ == MessagingStruct$TextMessage.getDefaultInstance()) {
            this.value_ = messagingStruct$TextMessage;
        } else {
            this.value_ = ((MessagingStruct$TextMessage.a) MessagingStruct$TextMessage.newBuilder((MessagingStruct$TextMessage) this.value_).v(messagingStruct$TextMessage)).j();
        }
        this.valueCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineStruct$FeedMessage parseDelimitedFrom(InputStream inputStream) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$FeedMessage parseFrom(ByteBuffer byteBuffer) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAlbumMessage(MagazineStruct$FeedAlbumMessage magazineStruct$FeedAlbumMessage) {
        magazineStruct$FeedAlbumMessage.getClass();
        this.value_ = magazineStruct$FeedAlbumMessage;
        this.valueCase_ = 3;
    }

    private void setDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.value_ = messagingStruct$DocumentMessage;
        this.valueCase_ = 1;
    }

    private void setTextMessage(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        messagingStruct$TextMessage.getClass();
        this.value_ = messagingStruct$TextMessage;
        this.valueCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineStruct$FeedMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"value_", "valueCase_", MessagingStruct$DocumentMessage.class, MessagingStruct$TextMessage.class, MagazineStruct$FeedAlbumMessage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineStruct$FeedMessage.class) {
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

    public MagazineStruct$FeedAlbumMessage getAlbumMessage() {
        return this.valueCase_ == 3 ? (MagazineStruct$FeedAlbumMessage) this.value_ : MagazineStruct$FeedAlbumMessage.getDefaultInstance();
    }

    public MessagingStruct$DocumentMessage getDocumentMessage() {
        return this.valueCase_ == 1 ? (MessagingStruct$DocumentMessage) this.value_ : MessagingStruct$DocumentMessage.getDefaultInstance();
    }

    public MessagingStruct$TextMessage getTextMessage() {
        return this.valueCase_ == 2 ? (MessagingStruct$TextMessage) this.value_ : MessagingStruct$TextMessage.getDefaultInstance();
    }

    public b getValueCase() {
        return b.j(this.valueCase_);
    }

    public boolean hasAlbumMessage() {
        return this.valueCase_ == 3;
    }

    public boolean hasDocumentMessage() {
        return this.valueCase_ == 1;
    }

    public boolean hasTextMessage() {
        return this.valueCase_ == 2;
    }

    public static a newBuilder(MagazineStruct$FeedMessage magazineStruct$FeedMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineStruct$FeedMessage);
    }

    public static MagazineStruct$FeedMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$FeedMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineStruct$FeedMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MagazineStruct$FeedMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineStruct$FeedMessage parseFrom(byte[] bArr) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineStruct$FeedMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineStruct$FeedMessage parseFrom(InputStream inputStream) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$FeedMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$FeedMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineStruct$FeedMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineStruct$FeedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
