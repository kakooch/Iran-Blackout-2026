package ai.bale.proto;

import ai.bale.proto.MessagingStruct$ServiceEx;
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
public final class MessagingStruct$ServiceMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceMessage DEFAULT_INSTANCE;
    public static final int EXT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private int bitField0_;
    private MessagingStruct$ServiceEx ext_;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceMessage messagingStruct$ServiceMessage = new MessagingStruct$ServiceMessage();
        DEFAULT_INSTANCE = messagingStruct$ServiceMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceMessage.class, messagingStruct$ServiceMessage);
    }

    private MessagingStruct$ServiceMessage() {
    }

    private void clearExt() {
        this.ext_ = null;
        this.bitField0_ &= -2;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static MessagingStruct$ServiceMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExt(MessagingStruct$ServiceEx messagingStruct$ServiceEx) {
        messagingStruct$ServiceEx.getClass();
        MessagingStruct$ServiceEx messagingStruct$ServiceEx2 = this.ext_;
        if (messagingStruct$ServiceEx2 == null || messagingStruct$ServiceEx2 == MessagingStruct$ServiceEx.getDefaultInstance()) {
            this.ext_ = messagingStruct$ServiceEx;
        } else {
            this.ext_ = (MessagingStruct$ServiceEx) ((MessagingStruct$ServiceEx.a) MessagingStruct$ServiceEx.newBuilder(this.ext_).v(messagingStruct$ServiceEx)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExt(MessagingStruct$ServiceEx messagingStruct$ServiceEx) {
        messagingStruct$ServiceEx.getClass();
        this.ext_ = messagingStruct$ServiceEx;
        this.bitField0_ |= 1;
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "text_", "ext_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceMessage.class) {
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

    public MessagingStruct$ServiceEx getExt() {
        MessagingStruct$ServiceEx messagingStruct$ServiceEx = this.ext_;
        return messagingStruct$ServiceEx == null ? MessagingStruct$ServiceEx.getDefaultInstance() : messagingStruct$ServiceEx;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public boolean hasExt() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ServiceMessage messagingStruct$ServiceMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceMessage);
    }

    public static MessagingStruct$ServiceMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
