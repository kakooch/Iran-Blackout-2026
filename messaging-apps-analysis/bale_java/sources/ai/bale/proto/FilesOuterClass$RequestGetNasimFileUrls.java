package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6182Mn2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class FilesOuterClass$RequestGetNasimFileUrls extends GeneratedMessageLite implements U64 {
    private static final FilesOuterClass$RequestGetNasimFileUrls DEFAULT_INSTANCE;
    public static final int FILES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j files_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesOuterClass$RequestGetNasimFileUrls.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesOuterClass$RequestGetNasimFileUrls filesOuterClass$RequestGetNasimFileUrls = new FilesOuterClass$RequestGetNasimFileUrls();
        DEFAULT_INSTANCE = filesOuterClass$RequestGetNasimFileUrls;
        GeneratedMessageLite.registerDefaultInstance(FilesOuterClass$RequestGetNasimFileUrls.class, filesOuterClass$RequestGetNasimFileUrls);
    }

    private FilesOuterClass$RequestGetNasimFileUrls() {
    }

    private void addAllFiles(Iterable<? extends FilesStruct$FileLocation> iterable) {
        ensureFilesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.files_);
    }

    private void addFiles(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        ensureFilesIsMutable();
        this.files_.add(filesStruct$FileLocation);
    }

    private void clearFiles() {
        this.files_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFilesIsMutable() {
        B.j jVar = this.files_;
        if (jVar.u()) {
            return;
        }
        this.files_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseDelimitedFrom(InputStream inputStream) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(ByteBuffer byteBuffer) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFiles(int i) {
        ensureFilesIsMutable();
        this.files_.remove(i);
    }

    private void setFiles(int i, FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        ensureFilesIsMutable();
        this.files_.set(i, filesStruct$FileLocation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1841b0.a[gVar.ordinal()]) {
            case 1:
                return new FilesOuterClass$RequestGetNasimFileUrls();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"files_", FilesStruct$FileLocation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesOuterClass$RequestGetNasimFileUrls.class) {
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

    public FilesStruct$FileLocation getFiles(int i) {
        return (FilesStruct$FileLocation) this.files_.get(i);
    }

    public int getFilesCount() {
        return this.files_.size();
    }

    public List<FilesStruct$FileLocation> getFilesList() {
        return this.files_;
    }

    public InterfaceC6182Mn2 getFilesOrBuilder(int i) {
        return (InterfaceC6182Mn2) this.files_.get(i);
    }

    public List<? extends InterfaceC6182Mn2> getFilesOrBuilderList() {
        return this.files_;
    }

    public static a newBuilder(FilesOuterClass$RequestGetNasimFileUrls filesOuterClass$RequestGetNasimFileUrls) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesOuterClass$RequestGetNasimFileUrls);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFiles(int i, FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        ensureFilesIsMutable();
        this.files_.add(i, filesStruct$FileLocation);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(byte[] bArr) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(InputStream inputStream) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesOuterClass$RequestGetNasimFileUrls parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUrls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
