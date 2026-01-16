package ai.bale.proto;

import ai.bale.proto.FilesStruct$PredefinedColor;
import ai.bale.proto.FilesStruct$RgbColor;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesStruct$Color extends GeneratedMessageLite implements U64 {
    private static final FilesStruct$Color DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PREDEFINED_COLOR_FIELD_NUMBER = 2;
    public static final int RGB_COLOR_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesStruct$Color.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        RGB_COLOR(1),
        PREDEFINED_COLOR(2),
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
                return RGB_COLOR;
            }
            if (i != 2) {
                return null;
            }
            return PREDEFINED_COLOR;
        }
    }

    static {
        FilesStruct$Color filesStruct$Color = new FilesStruct$Color();
        DEFAULT_INSTANCE = filesStruct$Color;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$Color.class, filesStruct$Color);
    }

    private FilesStruct$Color() {
    }

    private void clearPredefinedColor() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRgbColor() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static FilesStruct$Color getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePredefinedColor(FilesStruct$PredefinedColor filesStruct$PredefinedColor) {
        filesStruct$PredefinedColor.getClass();
        if (this.traitCase_ != 2 || this.trait_ == FilesStruct$PredefinedColor.getDefaultInstance()) {
            this.trait_ = filesStruct$PredefinedColor;
        } else {
            this.trait_ = ((FilesStruct$PredefinedColor.a) FilesStruct$PredefinedColor.newBuilder((FilesStruct$PredefinedColor) this.trait_).v(filesStruct$PredefinedColor)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeRgbColor(FilesStruct$RgbColor filesStruct$RgbColor) {
        filesStruct$RgbColor.getClass();
        if (this.traitCase_ != 1 || this.trait_ == FilesStruct$RgbColor.getDefaultInstance()) {
            this.trait_ = filesStruct$RgbColor;
        } else {
            this.trait_ = ((FilesStruct$RgbColor.a) FilesStruct$RgbColor.newBuilder((FilesStruct$RgbColor) this.trait_).v(filesStruct$RgbColor)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$Color parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$Color) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$Color parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPredefinedColor(FilesStruct$PredefinedColor filesStruct$PredefinedColor) {
        filesStruct$PredefinedColor.getClass();
        this.trait_ = filesStruct$PredefinedColor;
        this.traitCase_ = 2;
    }

    private void setRgbColor(FilesStruct$RgbColor filesStruct$RgbColor) {
        filesStruct$RgbColor.getClass();
        this.trait_ = filesStruct$RgbColor;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$Color();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", FilesStruct$RgbColor.class, FilesStruct$PredefinedColor.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$Color.class) {
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

    public FilesStruct$PredefinedColor getPredefinedColor() {
        return this.traitCase_ == 2 ? (FilesStruct$PredefinedColor) this.trait_ : FilesStruct$PredefinedColor.getDefaultInstance();
    }

    public FilesStruct$RgbColor getRgbColor() {
        return this.traitCase_ == 1 ? (FilesStruct$RgbColor) this.trait_ : FilesStruct$RgbColor.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasPredefinedColor() {
        return this.traitCase_ == 2;
    }

    public boolean hasRgbColor() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(FilesStruct$Color filesStruct$Color) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$Color);
    }

    public static FilesStruct$Color parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$Color) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$Color parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$Color parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesStruct$Color parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$Color parseFrom(byte[] bArr) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$Color parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$Color parseFrom(InputStream inputStream) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$Color parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$Color parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$Color parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
