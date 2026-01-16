package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateFoldersReordered extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateFoldersReordered DEFAULT_INSTANCE;
    public static final int FOLDER_IDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int folderIdsMemoizedSerializedSize = -1;
    private B.g folderIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateFoldersReordered.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateFoldersReordered messagingOuterClass$UpdateFoldersReordered = new MessagingOuterClass$UpdateFoldersReordered();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateFoldersReordered;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateFoldersReordered.class, messagingOuterClass$UpdateFoldersReordered);
    }

    private MessagingOuterClass$UpdateFoldersReordered() {
    }

    private void addAllFolderIds(Iterable<? extends Integer> iterable) {
        ensureFolderIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.folderIds_);
    }

    private void addFolderIds(int i) {
        ensureFolderIdsIsMutable();
        this.folderIds_.b1(i);
    }

    private void clearFolderIds() {
        this.folderIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureFolderIdsIsMutable() {
        B.g gVar = this.folderIds_;
        if (gVar.u()) {
            return;
        }
        this.folderIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MessagingOuterClass$UpdateFoldersReordered getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFolderIds(int i, int i2) {
        ensureFolderIdsIsMutable();
        this.folderIds_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateFoldersReordered();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"folderIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateFoldersReordered.class) {
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

    public int getFolderIds(int i) {
        return this.folderIds_.getInt(i);
    }

    public int getFolderIdsCount() {
        return this.folderIds_.size();
    }

    public List<Integer> getFolderIdsList() {
        return this.folderIds_;
    }

    public static a newBuilder(MessagingOuterClass$UpdateFoldersReordered messagingOuterClass$UpdateFoldersReordered) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateFoldersReordered);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateFoldersReordered parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFoldersReordered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
