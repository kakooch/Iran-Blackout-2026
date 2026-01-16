package ai.bale.proto;

import ai.bale.proto.MessagingOuterClass$RequestSendMessage;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4916Hc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SchedulerStruct$TaskSendMessage extends GeneratedMessageLite implements U64 {
    private static final SchedulerStruct$TaskSendMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int QUOTED_MESSAGE_FIELD_NUMBER = 2;
    public static final int SEND_MESSAGE_FIELD_NUMBER = 1;
    private int bitField0_;
    private B.j quotedMessage_ = GeneratedMessageLite.emptyProtobufList();
    private MessagingOuterClass$RequestSendMessage sendMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerStruct$TaskSendMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerStruct$TaskSendMessage schedulerStruct$TaskSendMessage = new SchedulerStruct$TaskSendMessage();
        DEFAULT_INSTANCE = schedulerStruct$TaskSendMessage;
        GeneratedMessageLite.registerDefaultInstance(SchedulerStruct$TaskSendMessage.class, schedulerStruct$TaskSendMessage);
    }

    private SchedulerStruct$TaskSendMessage() {
    }

    private void addAllQuotedMessage(Iterable<? extends MessagingStruct$QuotedMessage> iterable) {
        ensureQuotedMessageIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.quotedMessage_);
    }

    private void addQuotedMessage(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        messagingStruct$QuotedMessage.getClass();
        ensureQuotedMessageIsMutable();
        this.quotedMessage_.add(messagingStruct$QuotedMessage);
    }

    private void clearQuotedMessage() {
        this.quotedMessage_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSendMessage() {
        this.sendMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureQuotedMessageIsMutable() {
        B.j jVar = this.quotedMessage_;
        if (jVar.u()) {
            return;
        }
        this.quotedMessage_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SchedulerStruct$TaskSendMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSendMessage(MessagingOuterClass$RequestSendMessage messagingOuterClass$RequestSendMessage) {
        messagingOuterClass$RequestSendMessage.getClass();
        MessagingOuterClass$RequestSendMessage messagingOuterClass$RequestSendMessage2 = this.sendMessage_;
        if (messagingOuterClass$RequestSendMessage2 == null || messagingOuterClass$RequestSendMessage2 == MessagingOuterClass$RequestSendMessage.getDefaultInstance()) {
            this.sendMessage_ = messagingOuterClass$RequestSendMessage;
        } else {
            this.sendMessage_ = (MessagingOuterClass$RequestSendMessage) ((MessagingOuterClass$RequestSendMessage.a) MessagingOuterClass$RequestSendMessage.newBuilder(this.sendMessage_).v(messagingOuterClass$RequestSendMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerStruct$TaskSendMessage parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeQuotedMessage(int i) {
        ensureQuotedMessageIsMutable();
        this.quotedMessage_.remove(i);
    }

    private void setQuotedMessage(int i, MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        messagingStruct$QuotedMessage.getClass();
        ensureQuotedMessageIsMutable();
        this.quotedMessage_.set(i, messagingStruct$QuotedMessage);
    }

    private void setSendMessage(MessagingOuterClass$RequestSendMessage messagingOuterClass$RequestSendMessage) {
        messagingOuterClass$RequestSendMessage.getClass();
        this.sendMessage_ = messagingOuterClass$RequestSendMessage;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerStruct$TaskSendMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "sendMessage_", "quotedMessage_", MessagingStruct$QuotedMessage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerStruct$TaskSendMessage.class) {
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

    public MessagingStruct$QuotedMessage getQuotedMessage(int i) {
        return (MessagingStruct$QuotedMessage) this.quotedMessage_.get(i);
    }

    public int getQuotedMessageCount() {
        return this.quotedMessage_.size();
    }

    public List<MessagingStruct$QuotedMessage> getQuotedMessageList() {
        return this.quotedMessage_;
    }

    public InterfaceC4916Hc4 getQuotedMessageOrBuilder(int i) {
        return (InterfaceC4916Hc4) this.quotedMessage_.get(i);
    }

    public List<? extends InterfaceC4916Hc4> getQuotedMessageOrBuilderList() {
        return this.quotedMessage_;
    }

    public MessagingOuterClass$RequestSendMessage getSendMessage() {
        MessagingOuterClass$RequestSendMessage messagingOuterClass$RequestSendMessage = this.sendMessage_;
        return messagingOuterClass$RequestSendMessage == null ? MessagingOuterClass$RequestSendMessage.getDefaultInstance() : messagingOuterClass$RequestSendMessage;
    }

    public boolean hasSendMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SchedulerStruct$TaskSendMessage schedulerStruct$TaskSendMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerStruct$TaskSendMessage);
    }

    public static SchedulerStruct$TaskSendMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addQuotedMessage(int i, MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        messagingStruct$QuotedMessage.getClass();
        ensureQuotedMessageIsMutable();
        this.quotedMessage_.add(i, messagingStruct$QuotedMessage);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(byte[] bArr) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(InputStream inputStream) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerStruct$TaskSendMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerStruct$TaskSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
