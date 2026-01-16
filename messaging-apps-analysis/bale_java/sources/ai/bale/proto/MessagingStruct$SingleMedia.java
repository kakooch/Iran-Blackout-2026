package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DocumentMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22666vd4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$SingleMedia extends GeneratedMessageLite implements InterfaceC22666vd4 {
    private static final MessagingStruct$SingleMedia DEFAULT_INSTANCE;
    public static final int MEDIA_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RANDOM_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private MessagingStruct$DocumentMessage media_;
    private long randomId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22666vd4 {
        private a() {
            super(MessagingStruct$SingleMedia.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$SingleMedia messagingStruct$SingleMedia = new MessagingStruct$SingleMedia();
        DEFAULT_INSTANCE = messagingStruct$SingleMedia;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$SingleMedia.class, messagingStruct$SingleMedia);
    }

    private MessagingStruct$SingleMedia() {
    }

    private void clearMedia() {
        this.media_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRandomId() {
        this.randomId_ = 0L;
    }

    public static MessagingStruct$SingleMedia getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMedia(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage2 = this.media_;
        if (messagingStruct$DocumentMessage2 == null || messagingStruct$DocumentMessage2 == MessagingStruct$DocumentMessage.getDefaultInstance()) {
            this.media_ = messagingStruct$DocumentMessage;
        } else {
            this.media_ = (MessagingStruct$DocumentMessage) ((MessagingStruct$DocumentMessage.a) MessagingStruct$DocumentMessage.newBuilder(this.media_).v(messagingStruct$DocumentMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$SingleMedia parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$SingleMedia parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMedia(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.media_ = messagingStruct$DocumentMessage;
        this.bitField0_ |= 1;
    }

    private void setRandomId(long j) {
        this.randomId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$SingleMedia();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000", new Object[]{"bitField0_", "randomId_", "media_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$SingleMedia.class) {
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

    public MessagingStruct$DocumentMessage getMedia() {
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = this.media_;
        return messagingStruct$DocumentMessage == null ? MessagingStruct$DocumentMessage.getDefaultInstance() : messagingStruct$DocumentMessage;
    }

    public long getRandomId() {
        return this.randomId_;
    }

    public boolean hasMedia() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$SingleMedia messagingStruct$SingleMedia) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$SingleMedia);
    }

    public static MessagingStruct$SingleMedia parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$SingleMedia parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$SingleMedia parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$SingleMedia parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$SingleMedia parseFrom(byte[] bArr) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$SingleMedia parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$SingleMedia parseFrom(InputStream inputStream) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$SingleMedia parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$SingleMedia parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$SingleMedia parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$SingleMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
