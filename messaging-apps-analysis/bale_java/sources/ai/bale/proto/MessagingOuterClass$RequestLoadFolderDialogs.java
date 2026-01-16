package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5834La4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestLoadFolderDialogs extends GeneratedMessageLite implements U64 {
    public static final int ARCHIVE_FILTER_FIELD_NUMBER = 4;
    private static final MessagingOuterClass$RequestLoadFolderDialogs DEFAULT_INSTANCE;
    public static final int FOLDER_ID_FIELD_NUMBER = 3;
    public static final int LIMIT_FIELD_NUMBER = 2;
    public static final int MIN_DATE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int archiveFilter_;
    private int folderId_;
    private int limit_;
    private long minDate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((MessagingOuterClass$RequestLoadFolderDialogs) this.b).setFolderId(i);
            return this;
        }

        public a B(int i) {
            q();
            ((MessagingOuterClass$RequestLoadFolderDialogs) this.b).setLimit(i);
            return this;
        }

        public a C(long j) {
            q();
            ((MessagingOuterClass$RequestLoadFolderDialogs) this.b).setMinDate(j);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestLoadFolderDialogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestLoadFolderDialogs messagingOuterClass$RequestLoadFolderDialogs = new MessagingOuterClass$RequestLoadFolderDialogs();
        DEFAULT_INSTANCE = messagingOuterClass$RequestLoadFolderDialogs;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestLoadFolderDialogs.class, messagingOuterClass$RequestLoadFolderDialogs);
    }

    private MessagingOuterClass$RequestLoadFolderDialogs() {
    }

    private void clearArchiveFilter() {
        this.archiveFilter_ = 0;
    }

    private void clearFolderId() {
        this.folderId_ = 0;
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearMinDate() {
        this.minDate_ = 0L;
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setArchiveFilter(EnumC5834La4 enumC5834La4) {
        this.archiveFilter_ = enumC5834La4.getNumber();
    }

    private void setArchiveFilterValue(int i) {
        this.archiveFilter_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFolderId(int i) {
        this.folderId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinDate(long j) {
        this.minDate_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestLoadFolderDialogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003\u0004\u0004\f", new Object[]{"minDate_", "limit_", "folderId_", "archiveFilter_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestLoadFolderDialogs.class) {
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

    public EnumC5834La4 getArchiveFilter() {
        EnumC5834La4 enumC5834La4J = EnumC5834La4.j(this.archiveFilter_);
        return enumC5834La4J == null ? EnumC5834La4.UNRECOGNIZED : enumC5834La4J;
    }

    public int getArchiveFilterValue() {
        return this.archiveFilter_;
    }

    public int getFolderId() {
        return this.folderId_;
    }

    public int getLimit() {
        return this.limit_;
    }

    public long getMinDate() {
        return this.minDate_;
    }

    public static a newBuilder(MessagingOuterClass$RequestLoadFolderDialogs messagingOuterClass$RequestLoadFolderDialogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestLoadFolderDialogs);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestLoadFolderDialogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadFolderDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
