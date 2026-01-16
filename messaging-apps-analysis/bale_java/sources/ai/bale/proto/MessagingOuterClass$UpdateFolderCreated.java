package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Folder;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateFolderCreated extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateFolderCreated DEFAULT_INSTANCE;
    public static final int FOLDER_FIELD_NUMBER = 1;
    public static final int INDEX_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$Folder folder_;
    private int index_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateFolderCreated.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateFolderCreated messagingOuterClass$UpdateFolderCreated = new MessagingOuterClass$UpdateFolderCreated();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateFolderCreated;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateFolderCreated.class, messagingOuterClass$UpdateFolderCreated);
    }

    private MessagingOuterClass$UpdateFolderCreated() {
    }

    private void clearFolder() {
        this.folder_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIndex() {
        this.index_ = 0;
    }

    public static MessagingOuterClass$UpdateFolderCreated getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFolder(MessagingStruct$Folder messagingStruct$Folder) {
        messagingStruct$Folder.getClass();
        MessagingStruct$Folder messagingStruct$Folder2 = this.folder_;
        if (messagingStruct$Folder2 == null || messagingStruct$Folder2 == MessagingStruct$Folder.getDefaultInstance()) {
            this.folder_ = messagingStruct$Folder;
        } else {
            this.folder_ = (MessagingStruct$Folder) ((MessagingStruct$Folder.a) MessagingStruct$Folder.newBuilder(this.folder_).v(messagingStruct$Folder)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateFolderCreated parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFolder(MessagingStruct$Folder messagingStruct$Folder) {
        messagingStruct$Folder.getClass();
        this.folder_ = messagingStruct$Folder;
        this.bitField0_ |= 1;
    }

    private void setIndex(int i) {
        this.index_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateFolderCreated();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"bitField0_", "folder_", "index_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateFolderCreated.class) {
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

    public MessagingStruct$Folder getFolder() {
        MessagingStruct$Folder messagingStruct$Folder = this.folder_;
        return messagingStruct$Folder == null ? MessagingStruct$Folder.getDefaultInstance() : messagingStruct$Folder;
    }

    public int getIndex() {
        return this.index_;
    }

    public boolean hasFolder() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateFolderCreated messagingOuterClass$UpdateFolderCreated) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateFolderCreated);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateFolderCreated parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderCreated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
