package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UpdateBoxStruct$SeqUpdateTooLong extends GeneratedMessageLite implements U64 {
    private static final UpdateBoxStruct$SeqUpdateTooLong DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UpdateBoxStruct$SeqUpdateTooLong.DEFAULT_INSTANCE);
        }
    }

    static {
        UpdateBoxStruct$SeqUpdateTooLong updateBoxStruct$SeqUpdateTooLong = new UpdateBoxStruct$SeqUpdateTooLong();
        DEFAULT_INSTANCE = updateBoxStruct$SeqUpdateTooLong;
        GeneratedMessageLite.registerDefaultInstance(UpdateBoxStruct$SeqUpdateTooLong.class, updateBoxStruct$SeqUpdateTooLong);
    }

    private UpdateBoxStruct$SeqUpdateTooLong() {
    }

    public static UpdateBoxStruct$SeqUpdateTooLong getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseDelimitedFrom(InputStream inputStream) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(ByteBuffer byteBuffer) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (o2.a[gVar.ordinal()]) {
            case 1:
                return new UpdateBoxStruct$SeqUpdateTooLong();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UpdateBoxStruct$SeqUpdateTooLong.class) {
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

    public static a newBuilder(UpdateBoxStruct$SeqUpdateTooLong updateBoxStruct$SeqUpdateTooLong) {
        return (a) DEFAULT_INSTANCE.createBuilder(updateBoxStruct$SeqUpdateTooLong);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(AbstractC2383g abstractC2383g) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(byte[] bArr) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(byte[] bArr, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(InputStream inputStream) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(AbstractC2384h abstractC2384h) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UpdateBoxStruct$SeqUpdateTooLong parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UpdateBoxStruct$SeqUpdateTooLong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
