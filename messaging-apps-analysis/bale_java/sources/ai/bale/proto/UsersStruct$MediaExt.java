package ai.bale.proto;

import ai.bale.proto.UsersStruct$IntroGif;
import ai.bale.proto.UsersStruct$IntroPhoto;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$MediaExt extends GeneratedMessageLite implements U64 {
    private static final UsersStruct$MediaExt DEFAULT_INSTANCE;
    public static final int INTRO_GIF_FIELD_NUMBER = 1;
    public static final int INTRO_PHOTO_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$MediaExt.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        INTRO_GIF(1),
        INTRO_PHOTO(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return INTRO_GIF;
            }
            if (i != 2) {
                return null;
            }
            return INTRO_PHOTO;
        }
    }

    static {
        UsersStruct$MediaExt usersStruct$MediaExt = new UsersStruct$MediaExt();
        DEFAULT_INSTANCE = usersStruct$MediaExt;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$MediaExt.class, usersStruct$MediaExt);
    }

    private UsersStruct$MediaExt() {
    }

    private void clearIntroGif() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearIntroPhoto() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static UsersStruct$MediaExt getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIntroGif(UsersStruct$IntroGif usersStruct$IntroGif) {
        usersStruct$IntroGif.getClass();
        if (this.traitCase_ != 1 || this.trait_ == UsersStruct$IntroGif.getDefaultInstance()) {
            this.trait_ = usersStruct$IntroGif;
        } else {
            this.trait_ = ((UsersStruct$IntroGif.a) UsersStruct$IntroGif.newBuilder((UsersStruct$IntroGif) this.trait_).v(usersStruct$IntroGif)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeIntroPhoto(UsersStruct$IntroPhoto usersStruct$IntroPhoto) {
        usersStruct$IntroPhoto.getClass();
        if (this.traitCase_ != 2 || this.trait_ == UsersStruct$IntroPhoto.getDefaultInstance()) {
            this.trait_ = usersStruct$IntroPhoto;
        } else {
            this.trait_ = ((UsersStruct$IntroPhoto.a) UsersStruct$IntroPhoto.newBuilder((UsersStruct$IntroPhoto) this.trait_).v(usersStruct$IntroPhoto)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$MediaExt parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$MediaExt parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIntroGif(UsersStruct$IntroGif usersStruct$IntroGif) {
        usersStruct$IntroGif.getClass();
        this.trait_ = usersStruct$IntroGif;
        this.traitCase_ = 1;
    }

    private void setIntroPhoto(UsersStruct$IntroPhoto usersStruct$IntroPhoto) {
        usersStruct$IntroPhoto.getClass();
        this.trait_ = usersStruct$IntroPhoto;
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$MediaExt();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", UsersStruct$IntroGif.class, UsersStruct$IntroPhoto.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$MediaExt.class) {
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

    public UsersStruct$IntroGif getIntroGif() {
        return this.traitCase_ == 1 ? (UsersStruct$IntroGif) this.trait_ : UsersStruct$IntroGif.getDefaultInstance();
    }

    public UsersStruct$IntroPhoto getIntroPhoto() {
        return this.traitCase_ == 2 ? (UsersStruct$IntroPhoto) this.trait_ : UsersStruct$IntroPhoto.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasIntroGif() {
        return this.traitCase_ == 1;
    }

    public boolean hasIntroPhoto() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(UsersStruct$MediaExt usersStruct$MediaExt) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$MediaExt);
    }

    public static UsersStruct$MediaExt parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$MediaExt parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$MediaExt parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$MediaExt parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$MediaExt parseFrom(byte[] bArr) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$MediaExt parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$MediaExt parseFrom(InputStream inputStream) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$MediaExt parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$MediaExt parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$MediaExt parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$MediaExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
