package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Message;
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
public final class MessagingStruct$TemplateMessageResponse extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$TemplateMessageResponse DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TEMPLATE_MESSAGE_RESPONSE_ID_FIELD_NUMBER = 2;
    public static final int TMR_MESSAGE_FIELD_NUMBER = 1;
    private int bitField0_;
    private MessagingStruct$Message message_;
    private long templateMessageResponseId_;
    private String tmrMessage_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$TemplateMessageResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TemplateMessageResponse messagingStruct$TemplateMessageResponse = new MessagingStruct$TemplateMessageResponse();
        DEFAULT_INSTANCE = messagingStruct$TemplateMessageResponse;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TemplateMessageResponse.class, messagingStruct$TemplateMessageResponse);
    }

    private MessagingStruct$TemplateMessageResponse() {
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTemplateMessageResponseId() {
        this.templateMessageResponseId_ = 0L;
    }

    private void clearTmrMessage() {
        this.tmrMessage_ = getDefaultInstance().getTmrMessage();
    }

    public static MessagingStruct$TemplateMessageResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.message_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.message_ = messagingStruct$Message;
        } else {
            this.message_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.message_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TemplateMessageResponse parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.message_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    private void setTemplateMessageResponseId(long j) {
        this.templateMessageResponseId_ = j;
    }

    private void setTmrMessage(String str) {
        str.getClass();
        this.tmrMessage_ = str;
    }

    private void setTmrMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.tmrMessage_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TemplateMessageResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003ဉ\u0000", new Object[]{"bitField0_", "tmrMessage_", "templateMessageResponseId_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TemplateMessageResponse.class) {
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

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public long getTemplateMessageResponseId() {
        return this.templateMessageResponseId_;
    }

    public String getTmrMessage() {
        return this.tmrMessage_;
    }

    public AbstractC2383g getTmrMessageBytes() {
        return AbstractC2383g.N(this.tmrMessage_);
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$TemplateMessageResponse messagingStruct$TemplateMessageResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TemplateMessageResponse);
    }

    public static MessagingStruct$TemplateMessageResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(byte[] bArr) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(InputStream inputStream) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TemplateMessageResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
