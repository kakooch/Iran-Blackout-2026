package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6681On2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class FilesOuterClass$ResponseGetNasimFileUrls extends GeneratedMessageLite implements U64 {
    private static final FilesOuterClass$ResponseGetNasimFileUrls DEFAULT_INSTANCE;
    public static final int FILE_URLS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j fileUrls_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesOuterClass$ResponseGetNasimFileUrls.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesOuterClass$ResponseGetNasimFileUrls filesOuterClass$ResponseGetNasimFileUrls = new FilesOuterClass$ResponseGetNasimFileUrls();
        DEFAULT_INSTANCE = filesOuterClass$ResponseGetNasimFileUrls;
        GeneratedMessageLite.registerDefaultInstance(FilesOuterClass$ResponseGetNasimFileUrls.class, filesOuterClass$ResponseGetNasimFileUrls);
    }

    private FilesOuterClass$ResponseGetNasimFileUrls() {
    }

    private void addAllFileUrls(Iterable<? extends FilesStruct$FileUrlDescription> iterable) {
        ensureFileUrlsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.fileUrls_);
    }

    private void addFileUrls(FilesStruct$FileUrlDescription filesStruct$FileUrlDescription) {
        filesStruct$FileUrlDescription.getClass();
        ensureFileUrlsIsMutable();
        this.fileUrls_.add(filesStruct$FileUrlDescription);
    }

    private void clearFileUrls() {
        this.fileUrls_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFileUrlsIsMutable() {
        B.j jVar = this.fileUrls_;
        if (jVar.u()) {
            return;
        }
        this.fileUrls_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseDelimitedFrom(InputStream inputStream) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(ByteBuffer byteBuffer) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFileUrls(int i) {
        ensureFileUrlsIsMutable();
        this.fileUrls_.remove(i);
    }

    private void setFileUrls(int i, FilesStruct$FileUrlDescription filesStruct$FileUrlDescription) {
        filesStruct$FileUrlDescription.getClass();
        ensureFileUrlsIsMutable();
        this.fileUrls_.set(i, filesStruct$FileUrlDescription);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1841b0.a[gVar.ordinal()]) {
            case 1:
                return new FilesOuterClass$ResponseGetNasimFileUrls();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"fileUrls_", FilesStruct$FileUrlDescription.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesOuterClass$ResponseGetNasimFileUrls.class) {
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

    public FilesStruct$FileUrlDescription getFileUrls(int i) {
        return (FilesStruct$FileUrlDescription) this.fileUrls_.get(i);
    }

    public int getFileUrlsCount() {
        return this.fileUrls_.size();
    }

    public List<FilesStruct$FileUrlDescription> getFileUrlsList() {
        return this.fileUrls_;
    }

    public InterfaceC6681On2 getFileUrlsOrBuilder(int i) {
        return (InterfaceC6681On2) this.fileUrls_.get(i);
    }

    public List<? extends InterfaceC6681On2> getFileUrlsOrBuilderList() {
        return this.fileUrls_;
    }

    public static a newBuilder(FilesOuterClass$ResponseGetNasimFileUrls filesOuterClass$ResponseGetNasimFileUrls) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesOuterClass$ResponseGetNasimFileUrls);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFileUrls(int i, FilesStruct$FileUrlDescription filesStruct$FileUrlDescription) {
        filesStruct$FileUrlDescription.getClass();
        ensureFileUrlsIsMutable();
        this.fileUrls_.add(i, filesStruct$FileUrlDescription);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(byte[] bArr) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(InputStream inputStream) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesOuterClass$ResponseGetNasimFileUrls parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
