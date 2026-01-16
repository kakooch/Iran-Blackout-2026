package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC13153fk7;
import ir.nasim.EnumC13744gk7;
import ir.nasim.InterfaceC10520bk7;
import ir.nasim.InterfaceC14945ik7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Tasks$ResponseGetTasksUserProgress extends GeneratedMessageLite implements U64 {
    private static final Tasks$ResponseGetTasksUserProgress DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PROGRESS_FIELD_NUMBER = 3;
    public static final int REWARDS_FIELD_NUMBER = 4;
    public static final int USER_LEVEL_FIELD_NUMBER = 2;
    public static final int USER_TYPE_FIELD_NUMBER = 1;
    private B.j progress_ = GeneratedMessageLite.emptyProtobufList();
    private B.j rewards_ = GeneratedMessageLite.emptyProtobufList();
    private int userLevel_;
    private int userType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tasks$ResponseGetTasksUserProgress.DEFAULT_INSTANCE);
        }
    }

    static {
        Tasks$ResponseGetTasksUserProgress tasks$ResponseGetTasksUserProgress = new Tasks$ResponseGetTasksUserProgress();
        DEFAULT_INSTANCE = tasks$ResponseGetTasksUserProgress;
        GeneratedMessageLite.registerDefaultInstance(Tasks$ResponseGetTasksUserProgress.class, tasks$ResponseGetTasksUserProgress);
    }

    private Tasks$ResponseGetTasksUserProgress() {
    }

    private void addAllProgress(Iterable<? extends TasksStruct$TasksUserProgress> iterable) {
        ensureProgressIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.progress_);
    }

    private void addAllRewards(Iterable<? extends TasksStruct$TaskReward> iterable) {
        ensureRewardsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.rewards_);
    }

    private void addProgress(TasksStruct$TasksUserProgress tasksStruct$TasksUserProgress) {
        tasksStruct$TasksUserProgress.getClass();
        ensureProgressIsMutable();
        this.progress_.add(tasksStruct$TasksUserProgress);
    }

    private void addRewards(TasksStruct$TaskReward tasksStruct$TaskReward) {
        tasksStruct$TaskReward.getClass();
        ensureRewardsIsMutable();
        this.rewards_.add(tasksStruct$TaskReward);
    }

    private void clearProgress() {
        this.progress_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRewards() {
        this.rewards_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUserLevel() {
        this.userLevel_ = 0;
    }

    private void clearUserType() {
        this.userType_ = 0;
    }

    private void ensureProgressIsMutable() {
        B.j jVar = this.progress_;
        if (jVar.u()) {
            return;
        }
        this.progress_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureRewardsIsMutable() {
        B.j jVar = this.rewards_;
        if (jVar.u()) {
            return;
        }
        this.rewards_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Tasks$ResponseGetTasksUserProgress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tasks$ResponseGetTasksUserProgress parseDelimitedFrom(InputStream inputStream) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(ByteBuffer byteBuffer) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeProgress(int i) {
        ensureProgressIsMutable();
        this.progress_.remove(i);
    }

    private void removeRewards(int i) {
        ensureRewardsIsMutable();
        this.rewards_.remove(i);
    }

    private void setProgress(int i, TasksStruct$TasksUserProgress tasksStruct$TasksUserProgress) {
        tasksStruct$TasksUserProgress.getClass();
        ensureProgressIsMutable();
        this.progress_.set(i, tasksStruct$TasksUserProgress);
    }

    private void setRewards(int i, TasksStruct$TaskReward tasksStruct$TaskReward) {
        tasksStruct$TaskReward.getClass();
        ensureRewardsIsMutable();
        this.rewards_.set(i, tasksStruct$TaskReward);
    }

    private void setUserLevel(EnumC13744gk7 enumC13744gk7) {
        this.userLevel_ = enumC13744gk7.getNumber();
    }

    private void setUserLevelValue(int i) {
        this.userLevel_ = i;
    }

    private void setUserType(EnumC13153fk7 enumC13153fk7) {
        this.userType_ = enumC13153fk7.getNumber();
    }

    private void setUserTypeValue(int i) {
        this.userType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (g2.a[gVar.ordinal()]) {
            case 1:
                return new Tasks$ResponseGetTasksUserProgress();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001\f\u0002\f\u0003\u001b\u0004\u001b", new Object[]{"userType_", "userLevel_", "progress_", TasksStruct$TasksUserProgress.class, "rewards_", TasksStruct$TaskReward.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tasks$ResponseGetTasksUserProgress.class) {
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

    public TasksStruct$TasksUserProgress getProgress(int i) {
        return (TasksStruct$TasksUserProgress) this.progress_.get(i);
    }

    public int getProgressCount() {
        return this.progress_.size();
    }

    public List<TasksStruct$TasksUserProgress> getProgressList() {
        return this.progress_;
    }

    public InterfaceC14945ik7 getProgressOrBuilder(int i) {
        return (InterfaceC14945ik7) this.progress_.get(i);
    }

    public List<? extends InterfaceC14945ik7> getProgressOrBuilderList() {
        return this.progress_;
    }

    public TasksStruct$TaskReward getRewards(int i) {
        return (TasksStruct$TaskReward) this.rewards_.get(i);
    }

    public int getRewardsCount() {
        return this.rewards_.size();
    }

    public List<TasksStruct$TaskReward> getRewardsList() {
        return this.rewards_;
    }

    public InterfaceC10520bk7 getRewardsOrBuilder(int i) {
        return (InterfaceC10520bk7) this.rewards_.get(i);
    }

    public List<? extends InterfaceC10520bk7> getRewardsOrBuilderList() {
        return this.rewards_;
    }

    public EnumC13744gk7 getUserLevel() {
        EnumC13744gk7 enumC13744gk7J = EnumC13744gk7.j(this.userLevel_);
        return enumC13744gk7J == null ? EnumC13744gk7.UNRECOGNIZED : enumC13744gk7J;
    }

    public int getUserLevelValue() {
        return this.userLevel_;
    }

    public EnumC13153fk7 getUserType() {
        EnumC13153fk7 enumC13153fk7J = EnumC13153fk7.j(this.userType_);
        return enumC13153fk7J == null ? EnumC13153fk7.UNRECOGNIZED : enumC13153fk7J;
    }

    public int getUserTypeValue() {
        return this.userType_;
    }

    public static a newBuilder(Tasks$ResponseGetTasksUserProgress tasks$ResponseGetTasksUserProgress) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasks$ResponseGetTasksUserProgress);
    }

    public static Tasks$ResponseGetTasksUserProgress parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(AbstractC2383g abstractC2383g) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addProgress(int i, TasksStruct$TasksUserProgress tasksStruct$TasksUserProgress) {
        tasksStruct$TasksUserProgress.getClass();
        ensureProgressIsMutable();
        this.progress_.add(i, tasksStruct$TasksUserProgress);
    }

    private void addRewards(int i, TasksStruct$TaskReward tasksStruct$TaskReward) {
        tasksStruct$TaskReward.getClass();
        ensureRewardsIsMutable();
        this.rewards_.add(i, tasksStruct$TaskReward);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(byte[] bArr) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(InputStream inputStream) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(AbstractC2384h abstractC2384h) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tasks$ResponseGetTasksUserProgress parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tasks$ResponseGetTasksUserProgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
