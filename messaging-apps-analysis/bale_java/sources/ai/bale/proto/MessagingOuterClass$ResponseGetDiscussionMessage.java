package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageContainer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseGetDiscussionMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseGetDiscussionMessage DEFAULT_INSTANCE;
    public static final int DISCUSSION_MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$MessageContainer discussionMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseGetDiscussionMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseGetDiscussionMessage messagingOuterClass$ResponseGetDiscussionMessage = new MessagingOuterClass$ResponseGetDiscussionMessage();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseGetDiscussionMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseGetDiscussionMessage.class, messagingOuterClass$ResponseGetDiscussionMessage);
    }

    private MessagingOuterClass$ResponseGetDiscussionMessage() {
    }

    private void clearDiscussionMessage() {
        this.discussionMessage_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDiscussionMessage(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        MessagingStruct$MessageContainer messagingStruct$MessageContainer2 = this.discussionMessage_;
        if (messagingStruct$MessageContainer2 == null || messagingStruct$MessageContainer2 == MessagingStruct$MessageContainer.getDefaultInstance()) {
            this.discussionMessage_ = messagingStruct$MessageContainer;
        } else {
            this.discussionMessage_ = (MessagingStruct$MessageContainer) ((MessagingStruct$MessageContainer.a) MessagingStruct$MessageContainer.newBuilder(this.discussionMessage_).v(messagingStruct$MessageContainer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDiscussionMessage(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        this.discussionMessage_ = messagingStruct$MessageContainer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseGetDiscussionMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "discussionMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseGetDiscussionMessage.class) {
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

    public MessagingStruct$MessageContainer getDiscussionMessage() {
        MessagingStruct$MessageContainer messagingStruct$MessageContainer = this.discussionMessage_;
        return messagingStruct$MessageContainer == null ? MessagingStruct$MessageContainer.getDefaultInstance() : messagingStruct$MessageContainer;
    }

    public boolean hasDiscussionMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$ResponseGetDiscussionMessage messagingOuterClass$ResponseGetDiscussionMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseGetDiscussionMessage);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseGetDiscussionMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetDiscussionMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
