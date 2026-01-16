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
public final class Tasks$ResponseJoinTasksGroups extends GeneratedMessageLite implements U64 {
    private static final Tasks$ResponseJoinTasksGroups DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tasks$ResponseJoinTasksGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        Tasks$ResponseJoinTasksGroups tasks$ResponseJoinTasksGroups = new Tasks$ResponseJoinTasksGroups();
        DEFAULT_INSTANCE = tasks$ResponseJoinTasksGroups;
        GeneratedMessageLite.registerDefaultInstance(Tasks$ResponseJoinTasksGroups.class, tasks$ResponseJoinTasksGroups);
    }

    private Tasks$ResponseJoinTasksGroups() {
    }

    public static Tasks$ResponseJoinTasksGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tasks$ResponseJoinTasksGroups parseDelimitedFrom(InputStream inputStream) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(ByteBuffer byteBuffer) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (g2.a[gVar.ordinal()]) {
            case 1:
                return new Tasks$ResponseJoinTasksGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tasks$ResponseJoinTasksGroups.class) {
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

    public static a newBuilder(Tasks$ResponseJoinTasksGroups tasks$ResponseJoinTasksGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasks$ResponseJoinTasksGroups);
    }

    public static Tasks$ResponseJoinTasksGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(byte[] bArr) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(InputStream inputStream) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tasks$ResponseJoinTasksGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tasks$ResponseJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
