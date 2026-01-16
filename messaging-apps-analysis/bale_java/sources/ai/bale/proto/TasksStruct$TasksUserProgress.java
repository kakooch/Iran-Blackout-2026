package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12517ek7;
import ir.nasim.EnumC13744gk7;
import ir.nasim.InterfaceC14945ik7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TasksStruct$TasksUserProgress extends GeneratedMessageLite implements InterfaceC14945ik7 {
    private static final TasksStruct$TasksUserProgress DEFAULT_INSTANCE;
    public static final int LEVEL_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TASK_PROGRESS_FIELD_NUMBER = 2;
    public static final int TASK_TYPE_FIELD_NUMBER = 1;
    private int level_;
    private int taskProgress_;
    private int taskType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC14945ik7 {
        private a() {
            super(TasksStruct$TasksUserProgress.DEFAULT_INSTANCE);
        }
    }

    static {
        TasksStruct$TasksUserProgress tasksStruct$TasksUserProgress = new TasksStruct$TasksUserProgress();
        DEFAULT_INSTANCE = tasksStruct$TasksUserProgress;
        GeneratedMessageLite.registerDefaultInstance(TasksStruct$TasksUserProgress.class, tasksStruct$TasksUserProgress);
    }

    private TasksStruct$TasksUserProgress() {
    }

    private void clearLevel() {
        this.level_ = 0;
    }

    private void clearTaskProgress() {
        this.taskProgress_ = 0;
    }

    private void clearTaskType() {
        this.taskType_ = 0;
    }

    public static TasksStruct$TasksUserProgress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TasksStruct$TasksUserProgress parseDelimitedFrom(InputStream inputStream) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TasksStruct$TasksUserProgress parseFrom(ByteBuffer byteBuffer) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLevel(EnumC13744gk7 enumC13744gk7) {
        this.level_ = enumC13744gk7.getNumber();
    }

    private void setLevelValue(int i) {
        this.level_ = i;
    }

    private void setTaskProgress(int i) {
        this.taskProgress_ = i;
    }

    private void setTaskType(EnumC12517ek7 enumC12517ek7) {
        this.taskType_ = enumC12517ek7.getNumber();
    }

    private void setTaskTypeValue(int i) {
        this.taskType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (h2.a[gVar.ordinal()]) {
            case 1:
                return new TasksStruct$TasksUserProgress();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003\f", new Object[]{"taskType_", "taskProgress_", "level_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TasksStruct$TasksUserProgress.class) {
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

    public EnumC13744gk7 getLevel() {
        EnumC13744gk7 enumC13744gk7J = EnumC13744gk7.j(this.level_);
        return enumC13744gk7J == null ? EnumC13744gk7.UNRECOGNIZED : enumC13744gk7J;
    }

    public int getLevelValue() {
        return this.level_;
    }

    public int getTaskProgress() {
        return this.taskProgress_;
    }

    public EnumC12517ek7 getTaskType() {
        EnumC12517ek7 enumC12517ek7J = EnumC12517ek7.j(this.taskType_);
        return enumC12517ek7J == null ? EnumC12517ek7.UNRECOGNIZED : enumC12517ek7J;
    }

    public int getTaskTypeValue() {
        return this.taskType_;
    }

    public static a newBuilder(TasksStruct$TasksUserProgress tasksStruct$TasksUserProgress) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasksStruct$TasksUserProgress);
    }

    public static TasksStruct$TasksUserProgress parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TasksStruct$TasksUserProgress parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TasksStruct$TasksUserProgress parseFrom(AbstractC2383g abstractC2383g) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TasksStruct$TasksUserProgress parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TasksStruct$TasksUserProgress parseFrom(byte[] bArr) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TasksStruct$TasksUserProgress parseFrom(byte[] bArr, C2394s c2394s) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TasksStruct$TasksUserProgress parseFrom(InputStream inputStream) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TasksStruct$TasksUserProgress parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TasksStruct$TasksUserProgress parseFrom(AbstractC2384h abstractC2384h) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TasksStruct$TasksUserProgress parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TasksStruct$TasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
