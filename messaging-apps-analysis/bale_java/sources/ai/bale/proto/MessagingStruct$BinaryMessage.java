package ai.bale.proto;

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
public final class MessagingStruct$BinaryMessage extends GeneratedMessageLite implements U64 {
    public static final int CONTENT_TAG_FIELD_NUMBER = 1;
    private static final MessagingStruct$BinaryMessage DEFAULT_INSTANCE;
    public static final int MSG_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String contentTag_ = "";
    private AbstractC2383g msg_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BinaryMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BinaryMessage messagingStruct$BinaryMessage = new MessagingStruct$BinaryMessage();
        DEFAULT_INSTANCE = messagingStruct$BinaryMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BinaryMessage.class, messagingStruct$BinaryMessage);
    }

    private MessagingStruct$BinaryMessage() {
    }

    private void clearContentTag() {
        this.contentTag_ = getDefaultInstance().getContentTag();
    }

    private void clearMsg() {
        this.msg_ = getDefaultInstance().getMsg();
    }

    public static MessagingStruct$BinaryMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BinaryMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BinaryMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContentTag(String str) {
        str.getClass();
        this.contentTag_ = str;
    }

    private void setContentTagBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.contentTag_ = abstractC2383g.f0();
    }

    private void setMsg(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.msg_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BinaryMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"contentTag_", "msg_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BinaryMessage.class) {
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

    public String getContentTag() {
        return this.contentTag_;
    }

    public AbstractC2383g getContentTagBytes() {
        return AbstractC2383g.N(this.contentTag_);
    }

    public AbstractC2383g getMsg() {
        return this.msg_;
    }

    public static a newBuilder(MessagingStruct$BinaryMessage messagingStruct$BinaryMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BinaryMessage);
    }

    public static MessagingStruct$BinaryMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BinaryMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BinaryMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BinaryMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BinaryMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BinaryMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BinaryMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BinaryMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BinaryMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BinaryMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BinaryMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
