package ai.bale.proto;

import ai.bale.proto.FilesStruct$FastThumb;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$IntroGif extends GeneratedMessageLite implements U64 {
    private static final UsersStruct$IntroGif DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int THUMB_FIELD_NUMBER = 1;
    public static final int WIDTH_FIELD_NUMBER = 2;
    private int bitField0_;
    private int height_;
    private FilesStruct$FastThumb thumb_;
    private int width_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$IntroGif.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$IntroGif usersStruct$IntroGif = new UsersStruct$IntroGif();
        DEFAULT_INSTANCE = usersStruct$IntroGif;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$IntroGif.class, usersStruct$IntroGif);
    }

    private UsersStruct$IntroGif() {
    }

    private void clearHeight() {
        this.height_ = 0;
    }

    private void clearThumb() {
        this.thumb_ = null;
        this.bitField0_ &= -2;
    }

    private void clearWidth() {
        this.width_ = 0;
    }

    public static UsersStruct$IntroGif getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static UsersStruct$IntroGif parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$IntroGif parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHeight(int i) {
        this.height_ = i;
    }

    private void setThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        this.thumb_ = filesStruct$FastThumb;
        this.bitField0_ |= 1;
    }

    private void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$IntroGif();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0004", new Object[]{"bitField0_", "thumb_", "width_", "height_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$IntroGif.class) {
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

    public int getHeight() {
        return this.height_;
    }

    public FilesStruct$FastThumb getThumb() {
        FilesStruct$FastThumb filesStruct$FastThumb = this.thumb_;
        return filesStruct$FastThumb == null ? FilesStruct$FastThumb.getDefaultInstance() : filesStruct$FastThumb;
    }

    public int getWidth() {
        return this.width_;
    }

    public boolean hasThumb() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersStruct$IntroGif usersStruct$IntroGif) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$IntroGif);
    }

    public static UsersStruct$IntroGif parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$IntroGif parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$IntroGif parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$IntroGif parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$IntroGif parseFrom(byte[] bArr) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$IntroGif parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$IntroGif parseFrom(InputStream inputStream) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$IntroGif parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$IntroGif parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$IntroGif parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$IntroGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
