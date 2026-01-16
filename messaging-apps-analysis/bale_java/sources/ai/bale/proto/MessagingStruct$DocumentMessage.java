package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.FilesStruct$FastThumb;
import ai.bale.proto.MessagingStruct$DocumentEx;
import ai.bale.proto.MessagingStruct$MessageTag;
import ai.bale.proto.MessagingStruct$TextMessage;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC3488Bb4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$DocumentMessage extends GeneratedMessageLite implements InterfaceC3488Bb4 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    public static final int ALGORITHM_FIELD_NUMBER = 10;
    public static final int CAPTION_FIELD_NUMBER = 8;
    public static final int CHECK_SUM_FIELD_NUMBER = 9;
    private static final MessagingStruct$DocumentMessage DEFAULT_INSTANCE;
    public static final int EXT_FIELD_NUMBER = 7;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int FILE_SIZE_FIELD_NUMBER = 3;
    public static final int FILE_STORAGE_VERSION_FIELD_NUMBER = 11;
    public static final int GROUPED_ID_FIELD_NUMBER = 12;
    public static final int MESSAGE_TAG_FIELD_NUMBER = 13;
    public static final int MIME_TYPE_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int THUMB_FIELD_NUMBER = 6;
    private long accessHash_;
    private StringValue algorithm_;
    private int bitField0_;
    private MessagingStruct$TextMessage caption_;
    private StringValue checkSum_;
    private MessagingStruct$DocumentEx ext_;
    private long fileId_;
    private int fileSize_;
    private Int32Value fileStorageVersion_;
    private CollectionsStruct$Int64Value groupedId_;
    private MessagingStruct$MessageTag messageTag_;
    private FilesStruct$FastThumb thumb_;
    private String name_ = "";
    private String mimeType_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3488Bb4 {
        public a A(long j) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setAccessHash(j);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setAlgorithm(stringValue);
            return this;
        }

        public a C(MessagingStruct$TextMessage messagingStruct$TextMessage) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setCaption(messagingStruct$TextMessage);
            return this;
        }

        public a D(StringValue stringValue) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setCheckSum(stringValue);
            return this;
        }

        public a E(MessagingStruct$DocumentEx messagingStruct$DocumentEx) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setExt(messagingStruct$DocumentEx);
            return this;
        }

        public a F(long j) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setFileId(j);
            return this;
        }

        public a G(int i) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setFileSize(i);
            return this;
        }

        public a H(Int32Value int32Value) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setFileStorageVersion(int32Value);
            return this;
        }

        public a I(String str) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setMimeType(str);
            return this;
        }

        public a J(String str) {
            q();
            ((MessagingStruct$DocumentMessage) this.b).setName(str);
            return this;
        }

        private a() {
            super(MessagingStruct$DocumentMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = new MessagingStruct$DocumentMessage();
        DEFAULT_INSTANCE = messagingStruct$DocumentMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DocumentMessage.class, messagingStruct$DocumentMessage);
    }

    private MessagingStruct$DocumentMessage() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearAlgorithm() {
        this.algorithm_ = null;
        this.bitField0_ &= -17;
    }

    private void clearCaption() {
        this.caption_ = null;
        this.bitField0_ &= -5;
    }

    private void clearCheckSum() {
        this.checkSum_ = null;
        this.bitField0_ &= -9;
    }

    private void clearExt() {
        this.ext_ = null;
        this.bitField0_ &= -3;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearFileSize() {
        this.fileSize_ = 0;
    }

    private void clearFileStorageVersion() {
        this.fileStorageVersion_ = null;
        this.bitField0_ &= -33;
    }

    private void clearGroupedId() {
        this.groupedId_ = null;
        this.bitField0_ &= -65;
    }

    private void clearMessageTag() {
        this.messageTag_ = null;
        this.bitField0_ &= -129;
    }

    private void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearThumb() {
        this.thumb_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$DocumentMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAlgorithm(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.algorithm_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.algorithm_ = stringValue;
        } else {
            this.algorithm_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.algorithm_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeCaption(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        messagingStruct$TextMessage.getClass();
        MessagingStruct$TextMessage messagingStruct$TextMessage2 = this.caption_;
        if (messagingStruct$TextMessage2 == null || messagingStruct$TextMessage2 == MessagingStruct$TextMessage.getDefaultInstance()) {
            this.caption_ = messagingStruct$TextMessage;
        } else {
            this.caption_ = (MessagingStruct$TextMessage) ((MessagingStruct$TextMessage.a) MessagingStruct$TextMessage.newBuilder(this.caption_).v(messagingStruct$TextMessage)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeCheckSum(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.checkSum_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.checkSum_ = stringValue;
        } else {
            this.checkSum_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.checkSum_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeExt(MessagingStruct$DocumentEx messagingStruct$DocumentEx) {
        messagingStruct$DocumentEx.getClass();
        MessagingStruct$DocumentEx messagingStruct$DocumentEx2 = this.ext_;
        if (messagingStruct$DocumentEx2 == null || messagingStruct$DocumentEx2 == MessagingStruct$DocumentEx.getDefaultInstance()) {
            this.ext_ = messagingStruct$DocumentEx;
        } else {
            this.ext_ = (MessagingStruct$DocumentEx) ((MessagingStruct$DocumentEx.a) MessagingStruct$DocumentEx.newBuilder(this.ext_).v(messagingStruct$DocumentEx)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeFileStorageVersion(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.fileStorageVersion_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.fileStorageVersion_ = int32Value;
        } else {
            this.fileStorageVersion_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.fileStorageVersion_).v(int32Value)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.groupedId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.groupedId_ = collectionsStruct$Int64Value;
        } else {
            this.groupedId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.groupedId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeMessageTag(MessagingStruct$MessageTag messagingStruct$MessageTag) {
        messagingStruct$MessageTag.getClass();
        MessagingStruct$MessageTag messagingStruct$MessageTag2 = this.messageTag_;
        if (messagingStruct$MessageTag2 == null || messagingStruct$MessageTag2 == MessagingStruct$MessageTag.getDefaultInstance()) {
            this.messageTag_ = messagingStruct$MessageTag;
        } else {
            this.messageTag_ = (MessagingStruct$MessageTag) ((MessagingStruct$MessageTag.a) MessagingStruct$MessageTag.newBuilder(this.messageTag_).v(messagingStruct$MessageTag)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        FilesStruct$FastThumb filesStruct$FastThumb2 = this.thumb_;
        if (filesStruct$FastThumb2 == null || filesStruct$FastThumb2 == FilesStruct$FastThumb.getDefaultInstance()) {
            this.thumb_ = filesStruct$FastThumb;
        } else {
            this.thumb_ = (FilesStruct$FastThumb) ((FilesStruct$FastThumb.a) FilesStruct$FastThumb.newBuilder(this.thumb_).v(filesStruct$FastThumb)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DocumentMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlgorithm(StringValue stringValue) {
        stringValue.getClass();
        this.algorithm_ = stringValue;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaption(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        messagingStruct$TextMessage.getClass();
        this.caption_ = messagingStruct$TextMessage;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckSum(StringValue stringValue) {
        stringValue.getClass();
        this.checkSum_ = stringValue;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExt(MessagingStruct$DocumentEx messagingStruct$DocumentEx) {
        messagingStruct$DocumentEx.getClass();
        this.ext_ = messagingStruct$DocumentEx;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileId(long j) {
        this.fileId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileSize(int i) {
        this.fileSize_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileStorageVersion(Int32Value int32Value) {
        int32Value.getClass();
        this.fileStorageVersion_ = int32Value;
        this.bitField0_ |= 32;
    }

    private void setGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.groupedId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 64;
    }

    private void setMessageTag(MessagingStruct$MessageTag messagingStruct$MessageTag) {
        messagingStruct$MessageTag.getClass();
        this.messageTag_ = messagingStruct$MessageTag;
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    private void setMimeTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mimeType_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        this.thumb_ = filesStruct$FastThumb;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$DocumentMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0001\u0001\r\r\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0004\u0004Ȉ\u0005Ȉ\u0006ဉ\u0000\u0007ဉ\u0001\bဉ\u0002\tဉ\u0003\nဉ\u0004\u000bဉ\u0005\fဉ\u0006\rဉ\u0007", new Object[]{"bitField0_", "fileId_", "accessHash_", "fileSize_", "name_", "mimeType_", "thumb_", "ext_", "caption_", "checkSum_", "algorithm_", "fileStorageVersion_", "groupedId_", "messageTag_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DocumentMessage.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
    }

    public StringValue getAlgorithm() {
        StringValue stringValue = this.algorithm_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$TextMessage getCaption() {
        MessagingStruct$TextMessage messagingStruct$TextMessage = this.caption_;
        return messagingStruct$TextMessage == null ? MessagingStruct$TextMessage.getDefaultInstance() : messagingStruct$TextMessage;
    }

    public StringValue getCheckSum() {
        StringValue stringValue = this.checkSum_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$DocumentEx getExt() {
        MessagingStruct$DocumentEx messagingStruct$DocumentEx = this.ext_;
        return messagingStruct$DocumentEx == null ? MessagingStruct$DocumentEx.getDefaultInstance() : messagingStruct$DocumentEx;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public int getFileSize() {
        return this.fileSize_;
    }

    public Int32Value getFileStorageVersion() {
        Int32Value int32Value = this.fileStorageVersion_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    @Deprecated
    public CollectionsStruct$Int64Value getGroupedId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.groupedId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public MessagingStruct$MessageTag getMessageTag() {
        MessagingStruct$MessageTag messagingStruct$MessageTag = this.messageTag_;
        return messagingStruct$MessageTag == null ? MessagingStruct$MessageTag.getDefaultInstance() : messagingStruct$MessageTag;
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public FilesStruct$FastThumb getThumb() {
        FilesStruct$FastThumb filesStruct$FastThumb = this.thumb_;
        return filesStruct$FastThumb == null ? FilesStruct$FastThumb.getDefaultInstance() : filesStruct$FastThumb;
    }

    public boolean hasAlgorithm() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasCaption() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasCheckSum() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasExt() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFileStorageVersion() {
        return (this.bitField0_ & 32) != 0;
    }

    @Deprecated
    public boolean hasGroupedId() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasMessageTag() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasThumb() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DocumentMessage);
    }

    public static MessagingStruct$DocumentMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DocumentMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$DocumentMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DocumentMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DocumentMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DocumentMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DocumentMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DocumentMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
