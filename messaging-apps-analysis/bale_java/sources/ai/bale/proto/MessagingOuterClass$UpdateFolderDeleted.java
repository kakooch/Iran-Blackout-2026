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
public final class MessagingOuterClass$UpdateFolderDeleted extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateFolderDeleted DEFAULT_INSTANCE;
    public static final int FOLDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int folderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateFolderDeleted.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateFolderDeleted messagingOuterClass$UpdateFolderDeleted = new MessagingOuterClass$UpdateFolderDeleted();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateFolderDeleted;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateFolderDeleted.class, messagingOuterClass$UpdateFolderDeleted);
    }

    private MessagingOuterClass$UpdateFolderDeleted() {
    }

    private void clearFolderId() {
        this.folderId_ = 0;
    }

    public static MessagingOuterClass$UpdateFolderDeleted getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFolderId(int i) {
        this.folderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateFolderDeleted();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"folderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateFolderDeleted.class) {
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

    public static a newBuilder(MessagingOuterClass$UpdateFolderDeleted messagingOuterClass$UpdateFolderDeleted) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateFolderDeleted);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateFolderDeleted parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
