package ai.bale.proto;

import ai.bale.proto.TasksStruct$TaskReward;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Tasks$RequestGetTasksReward extends GeneratedMessageLite implements U64 {
    private static final Tasks$RequestGetTasksReward DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REWARDS_TO_GET_FIELD_NUMBER = 1;
    private int bitField0_;
    private TasksStruct$TaskReward rewardsToGet_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tasks$RequestGetTasksReward.DEFAULT_INSTANCE);
        }
    }

    static {
        Tasks$RequestGetTasksReward tasks$RequestGetTasksReward = new Tasks$RequestGetTasksReward();
        DEFAULT_INSTANCE = tasks$RequestGetTasksReward;
        GeneratedMessageLite.registerDefaultInstance(Tasks$RequestGetTasksReward.class, tasks$RequestGetTasksReward);
    }

    private Tasks$RequestGetTasksReward() {
    }

    private void clearRewardsToGet() {
        this.rewardsToGet_ = null;
        this.bitField0_ &= -2;
    }

    public static Tasks$RequestGetTasksReward getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRewardsToGet(TasksStruct$TaskReward tasksStruct$TaskReward) {
        tasksStruct$TaskReward.getClass();
        TasksStruct$TaskReward tasksStruct$TaskReward2 = this.rewardsToGet_;
        if (tasksStruct$TaskReward2 == null || tasksStruct$TaskReward2 == TasksStruct$TaskReward.getDefaultInstance()) {
            this.rewardsToGet_ = tasksStruct$TaskReward;
        } else {
            this.rewardsToGet_ = (TasksStruct$TaskReward) ((TasksStruct$TaskReward.a) TasksStruct$TaskReward.newBuilder(this.rewardsToGet_).v(tasksStruct$TaskReward)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tasks$RequestGetTasksReward parseDelimitedFrom(InputStream inputStream) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$RequestGetTasksReward parseFrom(ByteBuffer byteBuffer) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRewardsToGet(TasksStruct$TaskReward tasksStruct$TaskReward) {
        tasksStruct$TaskReward.getClass();
        this.rewardsToGet_ = tasksStruct$TaskReward;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (g2.a[gVar.ordinal()]) {
            case 1:
                return new Tasks$RequestGetTasksReward();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "rewardsToGet_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tasks$RequestGetTasksReward.class) {
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

    public TasksStruct$TaskReward getRewardsToGet() {
        TasksStruct$TaskReward tasksStruct$TaskReward = this.rewardsToGet_;
        return tasksStruct$TaskReward == null ? TasksStruct$TaskReward.getDefaultInstance() : tasksStruct$TaskReward;
    }

    public boolean hasRewardsToGet() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Tasks$RequestGetTasksReward tasks$RequestGetTasksReward) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasks$RequestGetTasksReward);
    }

    public static Tasks$RequestGetTasksReward parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$RequestGetTasksReward parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tasks$RequestGetTasksReward parseFrom(AbstractC2383g abstractC2383g) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Tasks$RequestGetTasksReward parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tasks$RequestGetTasksReward parseFrom(byte[] bArr) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tasks$RequestGetTasksReward parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tasks$RequestGetTasksReward parseFrom(InputStream inputStream) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$RequestGetTasksReward parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$RequestGetTasksReward parseFrom(AbstractC2384h abstractC2384h) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tasks$RequestGetTasksReward parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tasks$RequestGetTasksReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
