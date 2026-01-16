package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5481Jn2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesStruct$PredefinedColor extends GeneratedMessageLite implements U64 {
    public static final int COLOR_FIELD_NUMBER = 1;
    private static final FilesStruct$PredefinedColor DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int color_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesStruct$PredefinedColor.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$PredefinedColor filesStruct$PredefinedColor = new FilesStruct$PredefinedColor();
        DEFAULT_INSTANCE = filesStruct$PredefinedColor;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$PredefinedColor.class, filesStruct$PredefinedColor);
    }

    private FilesStruct$PredefinedColor() {
    }

    private void clearColor() {
        this.color_ = 0;
    }

    public static FilesStruct$PredefinedColor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$PredefinedColor parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$PredefinedColor parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setColor(EnumC5481Jn2 enumC5481Jn2) {
        this.color_ = enumC5481Jn2.getNumber();
    }

    private void setColorValue(int i) {
        this.color_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$PredefinedColor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"color_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$PredefinedColor.class) {
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

    public EnumC5481Jn2 getColor() {
        EnumC5481Jn2 enumC5481Jn2J = EnumC5481Jn2.j(this.color_);
        return enumC5481Jn2J == null ? EnumC5481Jn2.UNRECOGNIZED : enumC5481Jn2J;
    }

    public int getColorValue() {
        return this.color_;
    }

    public static a newBuilder(FilesStruct$PredefinedColor filesStruct$PredefinedColor) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$PredefinedColor);
    }

    public static FilesStruct$PredefinedColor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$PredefinedColor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$PredefinedColor parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesStruct$PredefinedColor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$PredefinedColor parseFrom(byte[] bArr) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$PredefinedColor parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$PredefinedColor parseFrom(InputStream inputStream) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$PredefinedColor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$PredefinedColor parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$PredefinedColor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$PredefinedColor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
