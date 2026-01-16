package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8005Uc6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SchedulerOuterClass$ResponseListTasks extends GeneratedMessageLite implements U64 {
    private static final SchedulerOuterClass$ResponseListTasks DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TASKS_FIELD_NUMBER = 1;
    private B.j tasks_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerOuterClass$ResponseListTasks.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerOuterClass$ResponseListTasks schedulerOuterClass$ResponseListTasks = new SchedulerOuterClass$ResponseListTasks();
        DEFAULT_INSTANCE = schedulerOuterClass$ResponseListTasks;
        GeneratedMessageLite.registerDefaultInstance(SchedulerOuterClass$ResponseListTasks.class, schedulerOuterClass$ResponseListTasks);
    }

    private SchedulerOuterClass$ResponseListTasks() {
    }

    private void addAllTasks(Iterable<? extends SchedulerStruct$ScheduledTask> iterable) {
        ensureTasksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tasks_);
    }

    private void addTasks(SchedulerStruct$ScheduledTask schedulerStruct$ScheduledTask) {
        schedulerStruct$ScheduledTask.getClass();
        ensureTasksIsMutable();
        this.tasks_.add(schedulerStruct$ScheduledTask);
    }

    private void clearTasks() {
        this.tasks_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTasksIsMutable() {
        B.j jVar = this.tasks_;
        if (jVar.u()) {
            return;
        }
        this.tasks_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SchedulerOuterClass$ResponseListTasks getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerOuterClass$ResponseListTasks parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTasks(int i) {
        ensureTasksIsMutable();
        this.tasks_.remove(i);
    }

    private void setTasks(int i, SchedulerStruct$ScheduledTask schedulerStruct$ScheduledTask) {
        schedulerStruct$ScheduledTask.getClass();
        ensureTasksIsMutable();
        this.tasks_.set(i, schedulerStruct$ScheduledTask);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (J1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerOuterClass$ResponseListTasks();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"tasks_", SchedulerStruct$ScheduledTask.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerOuterClass$ResponseListTasks.class) {
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

    public SchedulerStruct$ScheduledTask getTasks(int i) {
        return (SchedulerStruct$ScheduledTask) this.tasks_.get(i);
    }

    public int getTasksCount() {
        return this.tasks_.size();
    }

    public List<SchedulerStruct$ScheduledTask> getTasksList() {
        return this.tasks_;
    }

    public InterfaceC8005Uc6 getTasksOrBuilder(int i) {
        return (InterfaceC8005Uc6) this.tasks_.get(i);
    }

    public List<? extends InterfaceC8005Uc6> getTasksOrBuilderList() {
        return this.tasks_;
    }

    public static a newBuilder(SchedulerOuterClass$ResponseListTasks schedulerOuterClass$ResponseListTasks) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerOuterClass$ResponseListTasks);
    }

    public static SchedulerOuterClass$ResponseListTasks parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTasks(int i, SchedulerStruct$ScheduledTask schedulerStruct$ScheduledTask) {
        schedulerStruct$ScheduledTask.getClass();
        ensureTasksIsMutable();
        this.tasks_.add(i, schedulerStruct$ScheduledTask);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(byte[] bArr) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(InputStream inputStream) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerOuterClass$ResponseListTasks parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerOuterClass$ResponseListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
