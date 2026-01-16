package ai.bale.proto;

import ai.bale.proto.MessagingOuterClass$RequestDeleteMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SchedulerStruct$TaskDeleteMessage extends GeneratedMessageLite implements U64 {
    private static final SchedulerStruct$TaskDeleteMessage DEFAULT_INSTANCE;
    public static final int DELETE_MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingOuterClass$RequestDeleteMessage deleteMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerStruct$TaskDeleteMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerStruct$TaskDeleteMessage schedulerStruct$TaskDeleteMessage = new SchedulerStruct$TaskDeleteMessage();
        DEFAULT_INSTANCE = schedulerStruct$TaskDeleteMessage;
        GeneratedMessageLite.registerDefaultInstance(SchedulerStruct$TaskDeleteMessage.class, schedulerStruct$TaskDeleteMessage);
    }

    private SchedulerStruct$TaskDeleteMessage() {
    }

    private void clearDeleteMessage() {
        this.deleteMessage_ = null;
        this.bitField0_ &= -2;
    }

    public static SchedulerStruct$TaskDeleteMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDeleteMessage(MessagingOuterClass$RequestDeleteMessage messagingOuterClass$RequestDeleteMessage) {
        messagingOuterClass$RequestDeleteMessage.getClass();
        MessagingOuterClass$RequestDeleteMessage messagingOuterClass$RequestDeleteMessage2 = this.deleteMessage_;
        if (messagingOuterClass$RequestDeleteMessage2 == null || messagingOuterClass$RequestDeleteMessage2 == MessagingOuterClass$RequestDeleteMessage.getDefaultInstance()) {
            this.deleteMessage_ = messagingOuterClass$RequestDeleteMessage;
        } else {
            this.deleteMessage_ = (MessagingOuterClass$RequestDeleteMessage) ((MessagingOuterClass$RequestDeleteMessage.a) MessagingOuterClass$RequestDeleteMessage.newBuilder(this.deleteMessage_).v(messagingOuterClass$RequestDeleteMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerStruct$TaskDeleteMessage parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDeleteMessage(MessagingOuterClass$RequestDeleteMessage messagingOuterClass$RequestDeleteMessage) {
        messagingOuterClass$RequestDeleteMessage.getClass();
        this.deleteMessage_ = messagingOuterClass$RequestDeleteMessage;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerStruct$TaskDeleteMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "deleteMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerStruct$TaskDeleteMessage.class) {
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

    public MessagingOuterClass$RequestDeleteMessage getDeleteMessage() {
        MessagingOuterClass$RequestDeleteMessage messagingOuterClass$RequestDeleteMessage = this.deleteMessage_;
        return messagingOuterClass$RequestDeleteMessage == null ? MessagingOuterClass$RequestDeleteMessage.getDefaultInstance() : messagingOuterClass$RequestDeleteMessage;
    }

    public boolean hasDeleteMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SchedulerStruct$TaskDeleteMessage schedulerStruct$TaskDeleteMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerStruct$TaskDeleteMessage);
    }

    public static SchedulerStruct$TaskDeleteMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(byte[] bArr) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(InputStream inputStream) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerStruct$TaskDeleteMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerStruct$TaskDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
