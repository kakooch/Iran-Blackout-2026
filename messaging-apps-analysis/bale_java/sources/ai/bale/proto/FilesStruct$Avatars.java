package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4779Gn2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class FilesStruct$Avatars extends GeneratedMessageLite implements U64 {
    public static final int AVATARS_FIELD_NUMBER = 1;
    private static final FilesStruct$Avatars DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j avatars_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesStruct$Avatars.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$Avatars filesStruct$Avatars = new FilesStruct$Avatars();
        DEFAULT_INSTANCE = filesStruct$Avatars;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$Avatars.class, filesStruct$Avatars);
    }

    private FilesStruct$Avatars() {
    }

    private void addAllAvatars(Iterable<? extends FilesStruct$Avatar> iterable) {
        ensureAvatarsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.avatars_);
    }

    private void addAvatars(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        ensureAvatarsIsMutable();
        this.avatars_.add(filesStruct$Avatar);
    }

    private void clearAvatars() {
        this.avatars_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAvatarsIsMutable() {
        B.j jVar = this.avatars_;
        if (jVar.u()) {
            return;
        }
        this.avatars_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static FilesStruct$Avatars getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$Avatars parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$Avatars parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAvatars(int i) {
        ensureAvatarsIsMutable();
        this.avatars_.remove(i);
    }

    private void setAvatars(int i, FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        ensureAvatarsIsMutable();
        this.avatars_.set(i, filesStruct$Avatar);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$Avatars();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"avatars_", FilesStruct$Avatar.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$Avatars.class) {
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

    public FilesStruct$Avatar getAvatars(int i) {
        return (FilesStruct$Avatar) this.avatars_.get(i);
    }

    public int getAvatarsCount() {
        return this.avatars_.size();
    }

    public List<FilesStruct$Avatar> getAvatarsList() {
        return this.avatars_;
    }

    public InterfaceC4779Gn2 getAvatarsOrBuilder(int i) {
        return (InterfaceC4779Gn2) this.avatars_.get(i);
    }

    public List<? extends InterfaceC4779Gn2> getAvatarsOrBuilderList() {
        return this.avatars_;
    }

    public static a newBuilder(FilesStruct$Avatars filesStruct$Avatars) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$Avatars);
    }

    public static FilesStruct$Avatars parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$Avatars parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$Avatars parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAvatars(int i, FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        ensureAvatarsIsMutable();
        this.avatars_.add(i, filesStruct$Avatar);
    }

    public static FilesStruct$Avatars parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$Avatars parseFrom(byte[] bArr) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$Avatars parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$Avatars parseFrom(InputStream inputStream) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$Avatars parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$Avatars parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$Avatars parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$Avatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
