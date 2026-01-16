package ai.bale.proto;

import ai.bale.proto.FilesStruct$FastThumb;
import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.MessagingStruct$DocumentEx;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$BotInlineMediaResult extends GeneratedMessageLite implements U64 {
    private static final KetfStruct$BotInlineMediaResult DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 3;
    public static final int FILE_FIELD_NUMBER = 1;
    public static final int FILE_NAME_FIELD_NUMBER = 5;
    public static final int FILE_SIZE_FIELD_NUMBER = 4;
    public static final int MIME_TYPE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int THUMB_FIELD_NUMBER = 6;
    private int bitField0_;
    private MessagingStruct$DocumentEx extra_;
    private int fileSize_;
    private FilesStruct$FileLocation file_;
    private FilesStruct$FastThumb thumb_;
    private String mimeType_ = "";
    private String fileName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$BotInlineMediaResult.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$BotInlineMediaResult ketfStruct$BotInlineMediaResult = new KetfStruct$BotInlineMediaResult();
        DEFAULT_INSTANCE = ketfStruct$BotInlineMediaResult;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$BotInlineMediaResult.class, ketfStruct$BotInlineMediaResult);
    }

    private KetfStruct$BotInlineMediaResult() {
    }

    private void clearExtra() {
        this.extra_ = null;
        this.bitField0_ &= -3;
    }

    private void clearFile() {
        this.file_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileName() {
        this.fileName_ = getDefaultInstance().getFileName();
    }

    private void clearFileSize() {
        this.fileSize_ = 0;
    }

    private void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    private void clearThumb() {
        this.thumb_ = null;
        this.bitField0_ &= -5;
    }

    public static KetfStruct$BotInlineMediaResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExtra(MessagingStruct$DocumentEx messagingStruct$DocumentEx) {
        messagingStruct$DocumentEx.getClass();
        MessagingStruct$DocumentEx messagingStruct$DocumentEx2 = this.extra_;
        if (messagingStruct$DocumentEx2 == null || messagingStruct$DocumentEx2 == MessagingStruct$DocumentEx.getDefaultInstance()) {
            this.extra_ = messagingStruct$DocumentEx;
        } else {
            this.extra_ = (MessagingStruct$DocumentEx) ((MessagingStruct$DocumentEx.a) MessagingStruct$DocumentEx.newBuilder(this.extra_).v(messagingStruct$DocumentEx)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeFile(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.file_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.file_ = filesStruct$FileLocation;
        } else {
            this.file_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.file_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        FilesStruct$FastThumb filesStruct$FastThumb2 = this.thumb_;
        if (filesStruct$FastThumb2 == null || filesStruct$FastThumb2 == FilesStruct$FastThumb.getDefaultInstance()) {
            this.thumb_ = filesStruct$FastThumb;
        } else {
            this.thumb_ = (FilesStruct$FastThumb) ((FilesStruct$FastThumb.a) FilesStruct$FastThumb.newBuilder(this.thumb_).v(filesStruct$FastThumb)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$BotInlineMediaResult parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExtra(MessagingStruct$DocumentEx messagingStruct$DocumentEx) {
        messagingStruct$DocumentEx.getClass();
        this.extra_ = messagingStruct$DocumentEx;
        this.bitField0_ |= 2;
    }

    private void setFile(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.file_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setFileName(String str) {
        str.getClass();
        this.fileName_ = str;
    }

    private void setFileNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fileName_ = abstractC2383g.f0();
    }

    private void setFileSize(int i) {
        this.fileSize_ = i;
    }

    private void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    private void setMimeTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mimeType_ = abstractC2383g.f0();
    }

    private void setThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        this.thumb_ = filesStruct$FastThumb;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$BotInlineMediaResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003ဉ\u0001\u0004\u0004\u0005Ȉ\u0006ဉ\u0002", new Object[]{"bitField0_", "file_", "mimeType_", "extra_", "fileSize_", "fileName_", "thumb_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$BotInlineMediaResult.class) {
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

    public MessagingStruct$DocumentEx getExtra() {
        MessagingStruct$DocumentEx messagingStruct$DocumentEx = this.extra_;
        return messagingStruct$DocumentEx == null ? MessagingStruct$DocumentEx.getDefaultInstance() : messagingStruct$DocumentEx;
    }

    public FilesStruct$FileLocation getFile() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.file_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public String getFileName() {
        return this.fileName_;
    }

    public AbstractC2383g getFileNameBytes() {
        return AbstractC2383g.N(this.fileName_);
    }

    public int getFileSize() {
        return this.fileSize_;
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
    }

    public FilesStruct$FastThumb getThumb() {
        FilesStruct$FastThumb filesStruct$FastThumb = this.thumb_;
        return filesStruct$FastThumb == null ? FilesStruct$FastThumb.getDefaultInstance() : filesStruct$FastThumb;
    }

    public boolean hasExtra() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFile() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasThumb() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(KetfStruct$BotInlineMediaResult ketfStruct$BotInlineMediaResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$BotInlineMediaResult);
    }

    public static KetfStruct$BotInlineMediaResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(byte[] bArr) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(InputStream inputStream) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$BotInlineMediaResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$BotInlineMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
