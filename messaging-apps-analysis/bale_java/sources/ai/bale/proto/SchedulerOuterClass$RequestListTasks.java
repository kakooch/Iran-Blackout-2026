package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC7532Sc6;
import ir.nasim.EnumC9014Yc6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SchedulerOuterClass$RequestListTasks extends GeneratedMessageLite implements U64 {
    private static final SchedulerOuterClass$RequestListTasks DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private int status_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerOuterClass$RequestListTasks.DEFAULT_INSTANCE);
        }
    }

    static {
        SchedulerOuterClass$RequestListTasks schedulerOuterClass$RequestListTasks = new SchedulerOuterClass$RequestListTasks();
        DEFAULT_INSTANCE = schedulerOuterClass$RequestListTasks;
        GeneratedMessageLite.registerDefaultInstance(SchedulerOuterClass$RequestListTasks.class, schedulerOuterClass$RequestListTasks);
    }

    private SchedulerOuterClass$RequestListTasks() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static SchedulerOuterClass$RequestListTasks getDefaultInstance() {
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerOuterClass$RequestListTasks parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setStatus(EnumC9014Yc6 enumC9014Yc6) {
        this.status_ = enumC9014Yc6.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setType(EnumC7532Sc6 enumC7532Sc6) {
        this.type_ = enumC7532Sc6.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (J1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerOuterClass$RequestListTasks();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\f", new Object[]{"bitField0_", "exPeer_", "type_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerOuterClass$RequestListTasks.class) {
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

    public EnumC9014Yc6 getStatus() {
        EnumC9014Yc6 enumC9014Yc6J = EnumC9014Yc6.j(this.status_);
        return enumC9014Yc6J == null ? EnumC9014Yc6.UNRECOGNIZED : enumC9014Yc6J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public EnumC7532Sc6 getType() {
        EnumC7532Sc6 enumC7532Sc6J = EnumC7532Sc6.j(this.type_);
        return enumC7532Sc6J == null ? EnumC7532Sc6.UNRECOGNIZED : enumC7532Sc6J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SchedulerOuterClass$RequestListTasks schedulerOuterClass$RequestListTasks) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerOuterClass$RequestListTasks);
    }

    public static SchedulerOuterClass$RequestListTasks parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(byte[] bArr) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(InputStream inputStream) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerOuterClass$RequestListTasks parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerOuterClass$RequestListTasks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
