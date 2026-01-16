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
public final class MessagingOuterClass$RequestLoadPinnedDialogs extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestLoadPinnedDialogs DEFAULT_INSTANCE;
    public static final int FOLDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int folderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((MessagingOuterClass$RequestLoadPinnedDialogs) this.b).setFolderId(i);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestLoadPinnedDialogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestLoadPinnedDialogs messagingOuterClass$RequestLoadPinnedDialogs = new MessagingOuterClass$RequestLoadPinnedDialogs();
        DEFAULT_INSTANCE = messagingOuterClass$RequestLoadPinnedDialogs;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestLoadPinnedDialogs.class, messagingOuterClass$RequestLoadPinnedDialogs);
    }

    private MessagingOuterClass$RequestLoadPinnedDialogs() {
    }

    private void clearFolderId() {
        this.folderId_ = 0;
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFolderId(int i) {
        this.folderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestLoadPinnedDialogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"folderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestLoadPinnedDialogs.class) {
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

    public int getFolderId() {
        return this.folderId_;
    }

    public static a newBuilder(MessagingOuterClass$RequestLoadPinnedDialogs messagingOuterClass$RequestLoadPinnedDialogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestLoadPinnedDialogs);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestLoadPinnedDialogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
