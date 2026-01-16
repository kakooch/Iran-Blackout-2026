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
public final class WarriorOuterClass$RequestGetPacketsStatus extends GeneratedMessageLite implements U64 {
    private static final WarriorOuterClass$RequestGetPacketsStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$RequestGetPacketsStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$RequestGetPacketsStatus warriorOuterClass$RequestGetPacketsStatus = new WarriorOuterClass$RequestGetPacketsStatus();
        DEFAULT_INSTANCE = warriorOuterClass$RequestGetPacketsStatus;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$RequestGetPacketsStatus.class, warriorOuterClass$RequestGetPacketsStatus);
    }

    private WarriorOuterClass$RequestGetPacketsStatus() {
    }

    public static WarriorOuterClass$RequestGetPacketsStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$RequestGetPacketsStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$RequestGetPacketsStatus.class) {
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

    public static a newBuilder(WarriorOuterClass$RequestGetPacketsStatus warriorOuterClass$RequestGetPacketsStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$RequestGetPacketsStatus);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(byte[] bArr) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$RequestGetPacketsStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacketsStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
