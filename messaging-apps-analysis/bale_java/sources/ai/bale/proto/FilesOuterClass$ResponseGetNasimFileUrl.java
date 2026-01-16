package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileUrlDescription;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesOuterClass$ResponseGetNasimFileUrl extends GeneratedMessageLite implements U64 {
    private static final FilesOuterClass$ResponseGetNasimFileUrl DEFAULT_INSTANCE;
    public static final int FILE_URL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private FilesStruct$FileUrlDescription fileUrl_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesOuterClass$ResponseGetNasimFileUrl.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesOuterClass$ResponseGetNasimFileUrl filesOuterClass$ResponseGetNasimFileUrl = new FilesOuterClass$ResponseGetNasimFileUrl();
        DEFAULT_INSTANCE = filesOuterClass$ResponseGetNasimFileUrl;
        GeneratedMessageLite.registerDefaultInstance(FilesOuterClass$ResponseGetNasimFileUrl.class, filesOuterClass$ResponseGetNasimFileUrl);
    }

    private FilesOuterClass$ResponseGetNasimFileUrl() {
    }

    private void clearFileUrl() {
        this.fileUrl_ = null;
        this.bitField0_ &= -2;
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFileUrl(FilesStruct$FileUrlDescription filesStruct$FileUrlDescription) {
        filesStruct$FileUrlDescription.getClass();
        FilesStruct$FileUrlDescription filesStruct$FileUrlDescription2 = this.fileUrl_;
        if (filesStruct$FileUrlDescription2 == null || filesStruct$FileUrlDescription2 == FilesStruct$FileUrlDescription.getDefaultInstance()) {
            this.fileUrl_ = filesStruct$FileUrlDescription;
        } else {
            this.fileUrl_ = (FilesStruct$FileUrlDescription) ((FilesStruct$FileUrlDescription.a) FilesStruct$FileUrlDescription.newBuilder(this.fileUrl_).v(filesStruct$FileUrlDescription)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseDelimitedFrom(InputStream inputStream) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(ByteBuffer byteBuffer) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFileUrl(FilesStruct$FileUrlDescription filesStruct$FileUrlDescription) {
        filesStruct$FileUrlDescription.getClass();
        this.fileUrl_ = filesStruct$FileUrlDescription;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1841b0.a[gVar.ordinal()]) {
            case 1:
                return new FilesOuterClass$ResponseGetNasimFileUrl();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "fileUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesOuterClass$ResponseGetNasimFileUrl.class) {
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

    public FilesStruct$FileUrlDescription getFileUrl() {
        FilesStruct$FileUrlDescription filesStruct$FileUrlDescription = this.fileUrl_;
        return filesStruct$FileUrlDescription == null ? FilesStruct$FileUrlDescription.getDefaultInstance() : filesStruct$FileUrlDescription;
    }

    public boolean hasFileUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(FilesOuterClass$ResponseGetNasimFileUrl filesOuterClass$ResponseGetNasimFileUrl) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesOuterClass$ResponseGetNasimFileUrl);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(byte[] bArr) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(InputStream inputStream) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrl parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
