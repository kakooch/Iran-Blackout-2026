package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11283ck7;
import ir.nasim.EnumC11905dk7;
import ir.nasim.EnumC13744gk7;
import ir.nasim.InterfaceC10520bk7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TasksStruct$TaskReward extends GeneratedMessageLite implements InterfaceC10520bk7 {
    private static final TasksStruct$TaskReward DEFAULT_INSTANCE;
    public static final int LEVEL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REWARD_TYPE_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 3;
    private int level_;
    private int rewardType_;
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC10520bk7 {
        private a() {
            super(TasksStruct$TaskReward.DEFAULT_INSTANCE);
        }
    }

    static {
        TasksStruct$TaskReward tasksStruct$TaskReward = new TasksStruct$TaskReward();
        DEFAULT_INSTANCE = tasksStruct$TaskReward;
        GeneratedMessageLite.registerDefaultInstance(TasksStruct$TaskReward.class, tasksStruct$TaskReward);
    }

    private TasksStruct$TaskReward() {
    }

    private void clearLevel() {
        this.level_ = 0;
    }

    private void clearRewardType() {
        this.rewardType_ = 0;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    public static TasksStruct$TaskReward getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TasksStruct$TaskReward parseDelimitedFrom(InputStream inputStream) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TasksStruct$TaskReward parseFrom(ByteBuffer byteBuffer) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setRewardType(EnumC11905dk7 enumC11905dk7) {
        this.rewardType_ = enumC11905dk7.getNumber();
    }

    private void setRewardTypeValue(int i) {
        this.rewardType_ = i;
    }

    private void setStatus(EnumC11283ck7 enumC11283ck7) {
        this.status_ = enumC11283ck7.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (h2.a[gVar.ordinal()]) {
            case 1:
                return new TasksStruct$TaskReward();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"level_", "rewardType_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TasksStruct$TaskReward.class) {
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

    public EnumC11905dk7 getRewardType() {
        EnumC11905dk7 enumC11905dk7J = EnumC11905dk7.j(this.rewardType_);
        return enumC11905dk7J == null ? EnumC11905dk7.UNRECOGNIZED : enumC11905dk7J;
    }

    public int getRewardTypeValue() {
        return this.rewardType_;
    }

    public EnumC11283ck7 getStatus() {
        EnumC11283ck7 enumC11283ck7J = EnumC11283ck7.j(this.status_);
        return enumC11283ck7J == null ? EnumC11283ck7.UNRECOGNIZED : enumC11283ck7J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(TasksStruct$TaskReward tasksStruct$TaskReward) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasksStruct$TaskReward);
    }

    public static TasksStruct$TaskReward parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TasksStruct$TaskReward parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TasksStruct$TaskReward parseFrom(AbstractC2383g abstractC2383g) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TasksStruct$TaskReward parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TasksStruct$TaskReward parseFrom(byte[] bArr) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TasksStruct$TaskReward parseFrom(byte[] bArr, C2394s c2394s) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TasksStruct$TaskReward parseFrom(InputStream inputStream) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TasksStruct$TaskReward parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TasksStruct$TaskReward parseFrom(AbstractC2384h abstractC2384h) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TasksStruct$TaskReward parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TasksStruct$TaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
