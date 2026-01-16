package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.SchedulerStruct$TaskPayload;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SchedulerOuterClass$RequestScheduleTask extends GeneratedMessageLite implements U64 {
    private static final SchedulerOuterClass$RequestScheduleTask DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 3;
    public static final int SCHEDULED_AT_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private SchedulerStruct$TaskPayload payload_;
    private Timestamp scheduledAt_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerOuterClass$RequestScheduleTask.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerOuterClass$RequestScheduleTask schedulerOuterClass$RequestScheduleTask = new SchedulerOuterClass$RequestScheduleTask();
        DEFAULT_INSTANCE = schedulerOuterClass$RequestScheduleTask;
        GeneratedMessageLite.registerDefaultInstance(SchedulerOuterClass$RequestScheduleTask.class, schedulerOuterClass$RequestScheduleTask);
    }

    private SchedulerOuterClass$RequestScheduleTask() {
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

    public static SchedulerOuterClass$RequestScheduleTask getDefaultInstance() {
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

    public static SchedulerOuterClass$RequestScheduleTask parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (J1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerOuterClass$RequestScheduleTask();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "exPeer_", "scheduledAt_", "payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerOuterClass$RequestScheduleTask.class) {
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

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPayload() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasScheduledAt() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(SchedulerOuterClass$RequestScheduleTask schedulerOuterClass$RequestScheduleTask) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerOuterClass$RequestScheduleTask);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(byte[] bArr) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(InputStream inputStream) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerOuterClass$RequestScheduleTask parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerOuterClass$RequestScheduleTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
