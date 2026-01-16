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
public final class MeetOuterClass$ResponseTakeCallAction extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$ResponseTakeCallAction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$ResponseTakeCallAction.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$ResponseTakeCallAction meetOuterClass$ResponseTakeCallAction = new MeetOuterClass$ResponseTakeCallAction();
        DEFAULT_INSTANCE = meetOuterClass$ResponseTakeCallAction;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$ResponseTakeCallAction.class, meetOuterClass$ResponseTakeCallAction);
    }

    private MeetOuterClass$ResponseTakeCallAction() {
    }

    public static MeetOuterClass$ResponseTakeCallAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$ResponseTakeCallAction parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$ResponseTakeCallAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$ResponseTakeCallAction.class) {
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

    public static a newBuilder(MeetOuterClass$ResponseTakeCallAction meetOuterClass$ResponseTakeCallAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$ResponseTakeCallAction);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(byte[] bArr) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$ResponseTakeCallAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$ResponseTakeCallAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
