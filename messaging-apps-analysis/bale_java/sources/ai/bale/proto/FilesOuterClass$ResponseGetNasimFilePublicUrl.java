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
public final class FilesOuterClass$ResponseGetNasimFilePublicUrl extends GeneratedMessageLite implements U64 {
    private static final FilesOuterClass$ResponseGetNasimFilePublicUrl DEFAULT_INSTANCE;
    public static final int FILE_URL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private FilesStruct$FileUrlDescription fileUrl_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesOuterClass$ResponseGetNasimFilePublicUrl.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesOuterClass$ResponseGetNasimFilePublicUrl filesOuterClass$ResponseGetNasimFilePublicUrl = new FilesOuterClass$ResponseGetNasimFilePublicUrl();
        DEFAULT_INSTANCE = filesOuterClass$ResponseGetNasimFilePublicUrl;
        GeneratedMessageLite.registerDefaultInstance(FilesOuterClass$ResponseGetNasimFilePublicUrl.class, filesOuterClass$ResponseGetNasimFilePublicUrl);
    }

    private FilesOuterClass$ResponseGetNasimFilePublicUrl() {
    }

    private void clearFileUrl() {
        this.fileUrl_ = null;
        this.bitField0_ &= -2;
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl getDefaultInstance() {
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

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseDelimitedFrom(InputStream inputStream) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(ByteBuffer byteBuffer) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new FilesOuterClass$ResponseGetNasimFilePublicUrl();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "fileUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesOuterClass$ResponseGetNasimFilePublicUrl.class) {
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

    public static a newBuilder(FilesOuterClass$ResponseGetNasimFilePublicUrl filesOuterClass$ResponseGetNasimFilePublicUrl) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesOuterClass$ResponseGetNasimFilePublicUrl);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(byte[] bArr) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(InputStream inputStream) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesOuterClass$ResponseGetNasimFilePublicUrl parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFilePublicUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
