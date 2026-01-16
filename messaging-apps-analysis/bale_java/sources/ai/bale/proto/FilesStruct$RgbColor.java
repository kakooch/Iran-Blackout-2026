package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesStruct$RgbColor extends GeneratedMessageLite implements U64 {
    private static final FilesStruct$RgbColor DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RGB_FIELD_NUMBER = 1;
    private int rgb_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesStruct$RgbColor.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$RgbColor filesStruct$RgbColor = new FilesStruct$RgbColor();
        DEFAULT_INSTANCE = filesStruct$RgbColor;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$RgbColor.class, filesStruct$RgbColor);
    }

    private FilesStruct$RgbColor() {
    }

    private void clearRgb() {
        this.rgb_ = 0;
    }

    public static FilesStruct$RgbColor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$RgbColor parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$RgbColor parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRgb(int i) {
        this.rgb_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$RgbColor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"rgb_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$RgbColor.class) {
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

    public int getRgb() {
        return this.rgb_;
    }

    public static a newBuilder(FilesStruct$RgbColor filesStruct$RgbColor) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$RgbColor);
    }

    public static FilesStruct$RgbColor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$RgbColor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$RgbColor parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesStruct$RgbColor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$RgbColor parseFrom(byte[] bArr) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$RgbColor parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$RgbColor parseFrom(InputStream inputStream) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$RgbColor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$RgbColor parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$RgbColor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$RgbColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
