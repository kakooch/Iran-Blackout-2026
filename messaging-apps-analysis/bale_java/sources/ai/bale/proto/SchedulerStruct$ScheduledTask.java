package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.SchedulerStruct$TaskPayload;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.EnumC7532Sc6;
import ir.nasim.EnumC9014Yc6;
import ir.nasim.InterfaceC8005Uc6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SchedulerStruct$ScheduledTask extends GeneratedMessageLite implements InterfaceC8005Uc6 {
    private static final SchedulerStruct$ScheduledTask DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 6;
    public static final int SCHEDULED_AT_FIELD_NUMBER = 5;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int TASK_TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private SchedulerStruct$TaskPayload payload_;
    private Timestamp scheduledAt_;
    private int status_;
    private long taskId_;
    private int taskType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8005Uc6 {
        private a() {
            super(SchedulerStruct$ScheduledTask.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerStruct$ScheduledTask schedulerStruct$ScheduledTask = new SchedulerStruct$ScheduledTask();
        DEFAULT_INSTANCE = schedulerStruct$ScheduledTask;
        GeneratedMessageLite.registerDefaultInstance(SchedulerStruct$ScheduledTask.class, schedulerStruct$ScheduledTask);
    }

    private SchedulerStruct$ScheduledTask() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPayload() {
        this.payload_ = null;
        this.bitField0_ &= -5;
    }

    private void clearScheduledAt() {
        this.scheduledAt_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTaskId() {
        this.taskId_ = 0L;
    }

    private void clearTaskType() {
        this.taskType_ = 0;
    }

    public static SchedulerStruct$ScheduledTask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePayload(SchedulerStruct$TaskPayload schedulerStruct$TaskPayload) {
        schedulerStruct$TaskPayload.getClass();
        SchedulerStruct$TaskPayload schedulerStruct$TaskPayload2 = this.payload_;
        if (schedulerStruct$TaskPayload2 == null || schedulerStruct$TaskPayload2 == SchedulerStruct$TaskPayload.getDefaultInstance()) {
            this.payload_ = schedulerStruct$TaskPayload;
        } else {
            this.payload_ = (SchedulerStruct$TaskPayload) ((SchedulerStruct$TaskPayload.a) SchedulerStruct$TaskPayload.newBuilder(this.payload_).v(schedulerStruct$TaskPayload)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeScheduledAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.scheduledAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.scheduledAt_ = timestamp;
        } else {
            this.scheduledAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.scheduledAt_).v(timestamp)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerStruct$ScheduledTask parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setPayload(SchedulerStruct$TaskPayload schedulerStruct$TaskPayload) {
        schedulerStruct$TaskPayload.getClass();
        this.payload_ = schedulerStruct$TaskPayload;
        this.bitField0_ |= 4;
    }

    private void setScheduledAt(Timestamp timestamp) {
        timestamp.getClass();
        this.scheduledAt_ = timestamp;
        this.bitField0_ |= 2;
    }

    private void setStatus(EnumC9014Yc6 enumC9014Yc6) {
        this.status_ = enumC9014Yc6.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setTaskId(long j) {
        this.taskId_ = j;
    }

    private void setTaskType(EnumC7532Sc6 enumC7532Sc6) {
        this.taskType_ = enumC7532Sc6.getNumber();
    }

    private void setTaskTypeValue(int i) {
        this.taskType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerStruct$ScheduledTask();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0002\f\u0003\f\u0004ဉ\u0000\u0005ဉ\u0001\u0006ဉ\u0002", new Object[]{"bitField0_", "taskId_", "taskType_", "status_", "exPeer_", "scheduledAt_", "payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerStruct$ScheduledTask.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public SchedulerStruct$TaskPayload getPayload() {
        SchedulerStruct$TaskPayload schedulerStruct$TaskPayload = this.payload_;
        return schedulerStruct$TaskPayload == null ? SchedulerStruct$TaskPayload.getDefaultInstance() : schedulerStruct$TaskPayload;
    }

    public Timestamp getScheduledAt() {
        Timestamp timestamp = this.scheduledAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public EnumC9014Yc6 getStatus() {
        EnumC9014Yc6 enumC9014Yc6J = EnumC9014Yc6.j(this.status_);
        return enumC9014Yc6J == null ? EnumC9014Yc6.UNRECOGNIZED : enumC9014Yc6J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public long getTaskId() {
        return this.taskId_;
    }

    public EnumC7532Sc6 getTaskType() {
        EnumC7532Sc6 enumC7532Sc6J = EnumC7532Sc6.j(this.taskType_);
        return enumC7532Sc6J == null ? EnumC7532Sc6.UNRECOGNIZED : enumC7532Sc6J;
    }

    public int getTaskTypeValue() {
        return this.taskType_;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPayload() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasScheduledAt() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(SchedulerStruct$ScheduledTask schedulerStruct$ScheduledTask) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerStruct$ScheduledTask);
    }

    public static SchedulerStruct$ScheduledTask parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(byte[] bArr) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(InputStream inputStream) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerStruct$ScheduledTask parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerStruct$ScheduledTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
