package ai.bale.proto;

import ai.bale.proto.MessagingStruct$OrderExt;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$OrderMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$OrderMessage DEFAULT_INSTANCE;
    public static final int ORDER_EXT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$OrderExt orderExt_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$OrderMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$OrderMessage messagingStruct$OrderMessage = new MessagingStruct$OrderMessage();
        DEFAULT_INSTANCE = messagingStruct$OrderMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$OrderMessage.class, messagingStruct$OrderMessage);
    }

    private MessagingStruct$OrderMessage() {
    }

    private void clearOrderExt() {
        this.orderExt_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$OrderMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOrderExt(MessagingStruct$OrderExt messagingStruct$OrderExt) {
        messagingStruct$OrderExt.getClass();
        MessagingStruct$OrderExt messagingStruct$OrderExt2 = this.orderExt_;
        if (messagingStruct$OrderExt2 == null || messagingStruct$OrderExt2 == MessagingStruct$OrderExt.getDefaultInstance()) {
            this.orderExt_ = messagingStruct$OrderExt;
        } else {
            this.orderExt_ = (MessagingStruct$OrderExt) ((MessagingStruct$OrderExt.a) MessagingStruct$OrderExt.newBuilder(this.orderExt_).v(messagingStruct$OrderExt)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$OrderMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$OrderMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrderExt(MessagingStruct$OrderExt messagingStruct$OrderExt) {
        messagingStruct$OrderExt.getClass();
        this.orderExt_ = messagingStruct$OrderExt;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$OrderMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "orderExt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$OrderMessage.class) {
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

    public MessagingStruct$OrderExt getOrderExt() {
        MessagingStruct$OrderExt messagingStruct$OrderExt = this.orderExt_;
        return messagingStruct$OrderExt == null ? MessagingStruct$OrderExt.getDefaultInstance() : messagingStruct$OrderExt;
    }

    public boolean hasOrderExt() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$OrderMessage messagingStruct$OrderMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$OrderMessage);
    }

    public static MessagingStruct$OrderMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$OrderMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$OrderMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$OrderMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$OrderMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$OrderMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$OrderMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$OrderMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$OrderMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$OrderMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$OrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
