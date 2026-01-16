package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DocumentMessage;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$LiveMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$LiveMessage DEFAULT_INSTANCE;
    public static final int IS_LIVE_FIELD_NUMBER = 3;
    public static final int KEY_FIELD_NUMBER = 5;
    public static final int LINK_FIELD_NUMBER = 1;
    public static final int MEDIA_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int USER_COUNT_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean isLive_;
    private long key_;
    private String link_ = "";
    private MessagingStruct$DocumentMessage media_;
    private int userCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$LiveMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$LiveMessage messagingStruct$LiveMessage = new MessagingStruct$LiveMessage();
        DEFAULT_INSTANCE = messagingStruct$LiveMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$LiveMessage.class, messagingStruct$LiveMessage);
    }

    private MessagingStruct$LiveMessage() {
    }

    private void clearIsLive() {
        this.isLive_ = false;
    }

    private void clearKey() {
        this.key_ = 0L;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearMedia() {
        this.media_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUserCount() {
        this.userCount_ = 0;
    }

    public static MessagingStruct$LiveMessage getDefaultInstance() {
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

    public static MessagingStruct$LiveMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$LiveMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsLive(boolean z) {
        this.isLive_ = z;
    }

    private void setKey(long j) {
        this.key_ = j;
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setMedia(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.media_ = messagingStruct$DocumentMessage;
        this.bitField0_ |= 1;
    }

    private void setUserCount(int i) {
        this.userCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$LiveMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0007\u0004ဉ\u0000\u0005\u0002", new Object[]{"bitField0_", "link_", "userCount_", "isLive_", "media_", "key_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$LiveMessage.class) {
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

    public boolean getIsLive() {
        return this.isLive_;
    }

    public long getKey() {
        return this.key_;
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public MessagingStruct$DocumentMessage getMedia() {
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = this.media_;
        return messagingStruct$DocumentMessage == null ? MessagingStruct$DocumentMessage.getDefaultInstance() : messagingStruct$DocumentMessage;
    }

    public int getUserCount() {
        return this.userCount_;
    }

    public boolean hasMedia() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$LiveMessage messagingStruct$LiveMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$LiveMessage);
    }

    public static MessagingStruct$LiveMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$LiveMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$LiveMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$LiveMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$LiveMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$LiveMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$LiveMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$LiveMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$LiveMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$LiveMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$LiveMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
