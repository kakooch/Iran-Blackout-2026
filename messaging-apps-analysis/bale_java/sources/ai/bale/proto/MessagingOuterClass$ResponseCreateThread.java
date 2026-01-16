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
public final class MessagingOuterClass$ResponseCreateThread extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseCreateThread DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int THREAD_ID_FIELD_NUMBER = 1;
    private int threadId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseCreateThread.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseCreateThread messagingOuterClass$ResponseCreateThread = new MessagingOuterClass$ResponseCreateThread();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseCreateThread;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseCreateThread.class, messagingOuterClass$ResponseCreateThread);
    }

    private MessagingOuterClass$ResponseCreateThread() {
    }

    private void clearThreadId() {
        this.threadId_ = 0;
    }

    public static MessagingOuterClass$ResponseCreateThread getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseCreateThread parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setThreadId(int i) {
        this.threadId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseCreateThread();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"threadId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseCreateThread.class) {
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

    public int getThreadId() {
        return this.threadId_;
    }

    public static a newBuilder(MessagingOuterClass$ResponseCreateThread messagingOuterClass$ResponseCreateThread) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseCreateThread);
    }

    public static MessagingOuterClass$ResponseCreateThread parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseCreateThread parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseCreateThread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
