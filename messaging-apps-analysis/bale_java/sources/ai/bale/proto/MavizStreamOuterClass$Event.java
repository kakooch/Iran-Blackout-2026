package ai.bale.proto;

import ai.bale.proto.MavizStreamOuterClass$CombinedProtoUpdate;
import ai.bale.proto.MavizStreamOuterClass$SerializedUpdate;
import ai.bale.proto.MavizStreamOuterClass$WeakEvent;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MavizStreamOuterClass$Event extends GeneratedMessageLite implements U64 {
    private static final MavizStreamOuterClass$Event DEFAULT_INSTANCE;
    public static final int MTUPDATE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int ROUTE_ID_FIELD_NUMBER = 2;
    public static final int SEQUENCE_FIELD_NUMBER = 3;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    public static final int UPDATES_FIELD_NUMBER = 7;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int WEAK_EVENT_FIELD_NUMBER = 5;
    private int bitField0_;
    private MavizStreamOuterClass$SerializedUpdate mtupdate_;
    private int routeId_;
    private int sequence_;
    private long timestamp_;
    private SetUpdatesStruct$ComposedUpdates update_;
    private MavizStreamOuterClass$CombinedProtoUpdate updates_;
    private MavizStreamOuterClass$WeakEvent weakEvent_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MavizStreamOuterClass$Event.DEFAULT_INSTANCE);
        }
    }

    static {
        MavizStreamOuterClass$Event mavizStreamOuterClass$Event = new MavizStreamOuterClass$Event();
        DEFAULT_INSTANCE = mavizStreamOuterClass$Event;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$Event.class, mavizStreamOuterClass$Event);
    }

    private MavizStreamOuterClass$Event() {
    }

    private void clearMtupdate() {
        this.mtupdate_ = null;
        this.bitField0_ &= -5;
    }

    private void clearRouteId() {
        this.routeId_ = 0;
    }

    private void clearSequence() {
        this.sequence_ = 0;
    }

    private void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    private void clearUpdate() {
        this.update_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUpdates() {
        this.updates_ = null;
        this.bitField0_ &= -9;
    }

    private void clearWeakEvent() {
        this.weakEvent_ = null;
        this.bitField0_ &= -3;
    }

    public static MavizStreamOuterClass$Event getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMtupdate(MavizStreamOuterClass$SerializedUpdate mavizStreamOuterClass$SerializedUpdate) {
        mavizStreamOuterClass$SerializedUpdate.getClass();
        MavizStreamOuterClass$SerializedUpdate mavizStreamOuterClass$SerializedUpdate2 = this.mtupdate_;
        if (mavizStreamOuterClass$SerializedUpdate2 == null || mavizStreamOuterClass$SerializedUpdate2 == MavizStreamOuterClass$SerializedUpdate.getDefaultInstance()) {
            this.mtupdate_ = mavizStreamOuterClass$SerializedUpdate;
        } else {
            this.mtupdate_ = (MavizStreamOuterClass$SerializedUpdate) ((MavizStreamOuterClass$SerializedUpdate.a) MavizStreamOuterClass$SerializedUpdate.newBuilder(this.mtupdate_).v(mavizStreamOuterClass$SerializedUpdate)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeUpdate(SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        setUpdatesStruct$ComposedUpdates.getClass();
        SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates2 = this.update_;
        if (setUpdatesStruct$ComposedUpdates2 == null || setUpdatesStruct$ComposedUpdates2 == SetUpdatesStruct$ComposedUpdates.getDefaultInstance()) {
            this.update_ = setUpdatesStruct$ComposedUpdates;
        } else {
            this.update_ = (SetUpdatesStruct$ComposedUpdates) ((SetUpdatesStruct$ComposedUpdates.a) SetUpdatesStruct$ComposedUpdates.newBuilder(this.update_).v(setUpdatesStruct$ComposedUpdates)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeUpdates(MavizStreamOuterClass$CombinedProtoUpdate mavizStreamOuterClass$CombinedProtoUpdate) {
        mavizStreamOuterClass$CombinedProtoUpdate.getClass();
        MavizStreamOuterClass$CombinedProtoUpdate mavizStreamOuterClass$CombinedProtoUpdate2 = this.updates_;
        if (mavizStreamOuterClass$CombinedProtoUpdate2 == null || mavizStreamOuterClass$CombinedProtoUpdate2 == MavizStreamOuterClass$CombinedProtoUpdate.getDefaultInstance()) {
            this.updates_ = mavizStreamOuterClass$CombinedProtoUpdate;
        } else {
            this.updates_ = (MavizStreamOuterClass$CombinedProtoUpdate) ((MavizStreamOuterClass$CombinedProtoUpdate.a) MavizStreamOuterClass$CombinedProtoUpdate.newBuilder(this.updates_).v(mavizStreamOuterClass$CombinedProtoUpdate)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeWeakEvent(MavizStreamOuterClass$WeakEvent mavizStreamOuterClass$WeakEvent) {
        mavizStreamOuterClass$WeakEvent.getClass();
        MavizStreamOuterClass$WeakEvent mavizStreamOuterClass$WeakEvent2 = this.weakEvent_;
        if (mavizStreamOuterClass$WeakEvent2 == null || mavizStreamOuterClass$WeakEvent2 == MavizStreamOuterClass$WeakEvent.getDefaultInstance()) {
            this.weakEvent_ = mavizStreamOuterClass$WeakEvent;
        } else {
            this.weakEvent_ = (MavizStreamOuterClass$WeakEvent) ((MavizStreamOuterClass$WeakEvent.a) MavizStreamOuterClass$WeakEvent.newBuilder(this.weakEvent_).v(mavizStreamOuterClass$WeakEvent)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$Event parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$Event parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMtupdate(MavizStreamOuterClass$SerializedUpdate mavizStreamOuterClass$SerializedUpdate) {
        mavizStreamOuterClass$SerializedUpdate.getClass();
        this.mtupdate_ = mavizStreamOuterClass$SerializedUpdate;
        this.bitField0_ |= 4;
    }

    private void setRouteId(int i) {
        this.routeId_ = i;
    }

    private void setSequence(int i) {
        this.sequence_ = i;
    }

    private void setTimestamp(long j) {
        this.timestamp_ = j;
    }

    private void setUpdate(SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        setUpdatesStruct$ComposedUpdates.getClass();
        this.update_ = setUpdatesStruct$ComposedUpdates;
        this.bitField0_ |= 1;
    }

    private void setUpdates(MavizStreamOuterClass$CombinedProtoUpdate mavizStreamOuterClass$CombinedProtoUpdate) {
        mavizStreamOuterClass$CombinedProtoUpdate.getClass();
        this.updates_ = mavizStreamOuterClass$CombinedProtoUpdate;
        this.bitField0_ |= 8;
    }

    private void setWeakEvent(MavizStreamOuterClass$WeakEvent mavizStreamOuterClass$WeakEvent) {
        mavizStreamOuterClass$WeakEvent.getClass();
        this.weakEvent_ = mavizStreamOuterClass$WeakEvent;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$Event();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0004\u0004\u0002\u0005ဉ\u0001\u0006ဉ\u0002\u0007ဉ\u0003", new Object[]{"bitField0_", "update_", "routeId_", "sequence_", "timestamp_", "weakEvent_", "mtupdate_", "updates_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$Event.class) {
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

    public MavizStreamOuterClass$SerializedUpdate getMtupdate() {
        MavizStreamOuterClass$SerializedUpdate mavizStreamOuterClass$SerializedUpdate = this.mtupdate_;
        return mavizStreamOuterClass$SerializedUpdate == null ? MavizStreamOuterClass$SerializedUpdate.getDefaultInstance() : mavizStreamOuterClass$SerializedUpdate;
    }

    public int getRouteId() {
        return this.routeId_;
    }

    public int getSequence() {
        return this.sequence_;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public SetUpdatesStruct$ComposedUpdates getUpdate() {
        SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates = this.update_;
        return setUpdatesStruct$ComposedUpdates == null ? SetUpdatesStruct$ComposedUpdates.getDefaultInstance() : setUpdatesStruct$ComposedUpdates;
    }

    public MavizStreamOuterClass$CombinedProtoUpdate getUpdates() {
        MavizStreamOuterClass$CombinedProtoUpdate mavizStreamOuterClass$CombinedProtoUpdate = this.updates_;
        return mavizStreamOuterClass$CombinedProtoUpdate == null ? MavizStreamOuterClass$CombinedProtoUpdate.getDefaultInstance() : mavizStreamOuterClass$CombinedProtoUpdate;
    }

    public MavizStreamOuterClass$WeakEvent getWeakEvent() {
        MavizStreamOuterClass$WeakEvent mavizStreamOuterClass$WeakEvent = this.weakEvent_;
        return mavizStreamOuterClass$WeakEvent == null ? MavizStreamOuterClass$WeakEvent.getDefaultInstance() : mavizStreamOuterClass$WeakEvent;
    }

    public boolean hasMtupdate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasUpdate() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUpdates() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasWeakEvent() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MavizStreamOuterClass$Event mavizStreamOuterClass$Event) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$Event);
    }

    public static MavizStreamOuterClass$Event parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$Event parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$Event parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MavizStreamOuterClass$Event parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$Event parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$Event parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$Event parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$Event parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$Event parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$Event parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
