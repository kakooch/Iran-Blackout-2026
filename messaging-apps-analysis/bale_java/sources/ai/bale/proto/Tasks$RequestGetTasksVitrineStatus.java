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
public final class Tasks$RequestGetTasksVitrineStatus extends GeneratedMessageLite implements U64 {
    private static final Tasks$RequestGetTasksVitrineStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tasks$RequestGetTasksVitrineStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        Tasks$RequestGetTasksVitrineStatus tasks$RequestGetTasksVitrineStatus = new Tasks$RequestGetTasksVitrineStatus();
        DEFAULT_INSTANCE = tasks$RequestGetTasksVitrineStatus;
        GeneratedMessageLite.registerDefaultInstance(Tasks$RequestGetTasksVitrineStatus.class, tasks$RequestGetTasksVitrineStatus);
    }

    private Tasks$RequestGetTasksVitrineStatus() {
    }

    public static Tasks$RequestGetTasksVitrineStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tasks$RequestGetTasksVitrineStatus parseDelimitedFrom(InputStream inputStream) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(ByteBuffer byteBuffer) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (g2.a[gVar.ordinal()]) {
            case 1:
                return new Tasks$RequestGetTasksVitrineStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tasks$RequestGetTasksVitrineStatus.class) {
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

    public static a newBuilder(Tasks$RequestGetTasksVitrineStatus tasks$RequestGetTasksVitrineStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasks$RequestGetTasksVitrineStatus);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(byte[] bArr) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(InputStream inputStream) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tasks$RequestGetTasksVitrineStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tasks$RequestGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
