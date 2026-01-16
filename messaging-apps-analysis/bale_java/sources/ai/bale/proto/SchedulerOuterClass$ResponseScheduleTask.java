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
public final class SchedulerOuterClass$ResponseScheduleTask extends GeneratedMessageLite implements U64 {
    private static final SchedulerOuterClass$ResponseScheduleTask DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    private long taskId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerOuterClass$ResponseScheduleTask.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerOuterClass$ResponseScheduleTask schedulerOuterClass$ResponseScheduleTask = new SchedulerOuterClass$ResponseScheduleTask();
        DEFAULT_INSTANCE = schedulerOuterClass$ResponseScheduleTask;
        GeneratedMessageLite.registerDefaultInstance(SchedulerOuterClass$ResponseScheduleTask.class, schedulerOuterClass$ResponseScheduleTask);
    }

    private SchedulerOuterClass$ResponseScheduleTask() {
    }

    private void clearTaskId() {
        this.taskId_ = 0L;
    }

    public static SchedulerOuterClass$ResponseScheduleTask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTaskId(long j) {
        this.taskId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (J1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerOuterClass$ResponseScheduleTask();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"taskId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerOuterClass$ResponseScheduleTask.class) {
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

    public long getTaskId() {
        return this.taskId_;
    }

    public static a newBuilder(SchedulerOuterClass$ResponseScheduleTask schedulerOuterClass$ResponseScheduleTask) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerOuterClass$ResponseScheduleTask);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(byte[] bArr) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(InputStream inputStream) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerOuterClass$ResponseScheduleTask parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
