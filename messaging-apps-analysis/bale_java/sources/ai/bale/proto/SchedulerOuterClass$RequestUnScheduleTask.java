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
public final class SchedulerOuterClass$RequestUnScheduleTask extends GeneratedMessageLite implements U64 {
    private static final SchedulerOuterClass$RequestUnScheduleTask DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    private long taskID_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerOuterClass$RequestUnScheduleTask.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerOuterClass$RequestUnScheduleTask schedulerOuterClass$RequestUnScheduleTask = new SchedulerOuterClass$RequestUnScheduleTask();
        DEFAULT_INSTANCE = schedulerOuterClass$RequestUnScheduleTask;
        GeneratedMessageLite.registerDefaultInstance(SchedulerOuterClass$RequestUnScheduleTask.class, schedulerOuterClass$RequestUnScheduleTask);
    }

    private SchedulerOuterClass$RequestUnScheduleTask() {
    }

    private void clearTaskID() {
        this.taskID_ = 0L;
    }

    public static SchedulerOuterClass$RequestUnScheduleTask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new SchedulerOuterClass$RequestUnScheduleTask();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"taskID_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerOuterClass$RequestUnScheduleTask.class) {
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

    public static a newBuilder(SchedulerOuterClass$RequestUnScheduleTask schedulerOuterClass$RequestUnScheduleTask) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerOuterClass$RequestUnScheduleTask);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(byte[] bArr) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(InputStream inputStream) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerOuterClass$RequestUnScheduleTask parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerOuterClass$RequestUnScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
