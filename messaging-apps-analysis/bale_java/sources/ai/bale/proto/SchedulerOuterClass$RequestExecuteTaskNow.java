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
public final class SchedulerOuterClass$RequestExecuteTaskNow extends GeneratedMessageLite implements U64 {
    private static final SchedulerOuterClass$RequestExecuteTaskNow DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    private long taskID_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerOuterClass$RequestExecuteTaskNow.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerOuterClass$RequestExecuteTaskNow schedulerOuterClass$RequestExecuteTaskNow = new SchedulerOuterClass$RequestExecuteTaskNow();
        DEFAULT_INSTANCE = schedulerOuterClass$RequestExecuteTaskNow;
        GeneratedMessageLite.registerDefaultInstance(SchedulerOuterClass$RequestExecuteTaskNow.class, schedulerOuterClass$RequestExecuteTaskNow);
    }

    private SchedulerOuterClass$RequestExecuteTaskNow() {
    }

    private void clearTaskID() {
        this.taskID_ = 0L;
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTaskID(long j) {
        this.taskID_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (J1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerOuterClass$RequestExecuteTaskNow();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"taskID_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerOuterClass$RequestExecuteTaskNow.class) {
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

    public long getTaskID() {
        return this.taskID_;
    }

    public static a newBuilder(SchedulerOuterClass$RequestExecuteTaskNow schedulerOuterClass$RequestExecuteTaskNow) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerOuterClass$RequestExecuteTaskNow);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(byte[] bArr) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(InputStream inputStream) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerOuterClass$RequestExecuteTaskNow parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerOuterClass$RequestExecuteTaskNow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
