package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC8100Un2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesStruct$SendTypeValue extends GeneratedMessageLite implements U64 {
    private static final FilesStruct$SendTypeValue DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(EnumC8100Un2 enumC8100Un2) {
            q();
            ((FilesStruct$SendTypeValue) this.b).setType(enumC8100Un2);
            return this;
        }

        private a() {
            super(FilesStruct$SendTypeValue.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$SendTypeValue filesStruct$SendTypeValue = new FilesStruct$SendTypeValue();
        DEFAULT_INSTANCE = filesStruct$SendTypeValue;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$SendTypeValue.class, filesStruct$SendTypeValue);
    }

    private FilesStruct$SendTypeValue() {
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static FilesStruct$SendTypeValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$SendTypeValue parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$SendTypeValue parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(EnumC8100Un2 enumC8100Un2) {
        this.type_ = enumC8100Un2.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$SendTypeValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$SendTypeValue.class) {
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

    public EnumC8100Un2 getType() {
        EnumC8100Un2 enumC8100Un2J = EnumC8100Un2.j(this.type_);
        return enumC8100Un2J == null ? EnumC8100Un2.UNRECOGNIZED : enumC8100Un2J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(FilesStruct$SendTypeValue filesStruct$SendTypeValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$SendTypeValue);
    }

    public static FilesStruct$SendTypeValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$SendTypeValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$SendTypeValue parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesStruct$SendTypeValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$SendTypeValue parseFrom(byte[] bArr) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$SendTypeValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$SendTypeValue parseFrom(InputStream inputStream) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$SendTypeValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$SendTypeValue parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$SendTypeValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$SendTypeValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
