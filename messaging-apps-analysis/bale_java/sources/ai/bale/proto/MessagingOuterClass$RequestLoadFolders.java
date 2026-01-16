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
public final class MessagingOuterClass$RequestLoadFolders extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestLoadFolders DEFAULT_INSTANCE;
    public static final int INCLUDE_MUTED_UNREAD_PEERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean includeMutedUnreadPeers_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((MessagingOuterClass$RequestLoadFolders) this.b).setIncludeMutedUnreadPeers(z);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestLoadFolders.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestLoadFolders messagingOuterClass$RequestLoadFolders = new MessagingOuterClass$RequestLoadFolders();
        DEFAULT_INSTANCE = messagingOuterClass$RequestLoadFolders;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestLoadFolders.class, messagingOuterClass$RequestLoadFolders);
    }

    private MessagingOuterClass$RequestLoadFolders() {
    }

    private void clearIncludeMutedUnreadPeers() {
        this.includeMutedUnreadPeers_ = false;
    }

    public static MessagingOuterClass$RequestLoadFolders getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestLoadFolders parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncludeMutedUnreadPeers(boolean z) {
        this.includeMutedUnreadPeers_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestLoadFolders();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"includeMutedUnreadPeers_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestLoadFolders.class) {
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

    public boolean getIncludeMutedUnreadPeers() {
        return this.includeMutedUnreadPeers_;
    }

    public static a newBuilder(MessagingOuterClass$RequestLoadFolders messagingOuterClass$RequestLoadFolders) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestLoadFolders);
    }

    public static MessagingOuterClass$RequestLoadFolders parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestLoadFolders parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
