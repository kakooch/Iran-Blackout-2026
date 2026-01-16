package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ServiceExGiftPacketOpened extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExGiftPacketOpened DEFAULT_INSTANCE;
    public static final int MSG_DATE_FIELD_NUMBER = 3;
    public static final int MSG_RID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private long msgDate_;
    private long msgRid_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExGiftPacketOpened.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExGiftPacketOpened messagingStruct$ServiceExGiftPacketOpened = new MessagingStruct$ServiceExGiftPacketOpened();
        DEFAULT_INSTANCE = messagingStruct$ServiceExGiftPacketOpened;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExGiftPacketOpened.class, messagingStruct$ServiceExGiftPacketOpened);
    }

    private MessagingStruct$ServiceExGiftPacketOpened() {
    }

    private void clearMsgDate() {
        this.msgDate_ = 0L;
    }

    private void clearMsgRid() {
        this.msgRid_ = 0L;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static MessagingStruct$ServiceExGiftPacketOpened getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMsgDate(long j) {
        this.msgDate_ = j;
    }

    private void setMsgRid(long j) {
        this.msgRid_ = j;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExGiftPacketOpened();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"userId_", "msgRid_", "msgDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExGiftPacketOpened.class) {
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

    public long getMsgDate() {
        return this.msgDate_;
    }

    public long getMsgRid() {
        return this.msgRid_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(MessagingStruct$ServiceExGiftPacketOpened messagingStruct$ServiceExGiftPacketOpened) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExGiftPacketOpened);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExGiftPacketOpened parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExGiftPacketOpened) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
