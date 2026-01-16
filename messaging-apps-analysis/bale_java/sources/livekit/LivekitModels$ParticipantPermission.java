package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC9607aF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitModels$ParticipantPermission extends GeneratedMessageLite implements U64 {
    public static final int AGENT_FIELD_NUMBER = 11;
    public static final int CAN_PUBLISH_DATA_FIELD_NUMBER = 3;
    public static final int CAN_PUBLISH_FIELD_NUMBER = 2;
    public static final int CAN_PUBLISH_SOURCES_FIELD_NUMBER = 9;
    public static final int CAN_SUBSCRIBE_FIELD_NUMBER = 1;
    public static final int CAN_SUBSCRIBE_METRICS_FIELD_NUMBER = 12;
    public static final int CAN_UPDATE_METADATA_FIELD_NUMBER = 10;
    private static final LivekitModels$ParticipantPermission DEFAULT_INSTANCE;
    public static final int HIDDEN_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int RECORDER_FIELD_NUMBER = 8;
    private static final B.h.a canPublishSources_converter_ = new a();
    private boolean agent_;
    private boolean canPublishData_;
    private int canPublishSourcesMemoizedSerializedSize;
    private B.g canPublishSources_ = GeneratedMessageLite.emptyIntList();
    private boolean canPublish_;
    private boolean canSubscribeMetrics_;
    private boolean canSubscribe_;
    private boolean canUpdateMetadata_;
    private boolean hidden_;
    private boolean recorder_;

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9607aF3 a(Integer num) {
            EnumC9607aF3 enumC9607aF3J = EnumC9607aF3.j(num.intValue());
            return enumC9607aF3J == null ? EnumC9607aF3.UNRECOGNIZED : enumC9607aF3J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(o oVar) {
            this();
        }

        private b() {
            super(LivekitModels$ParticipantPermission.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$ParticipantPermission livekitModels$ParticipantPermission = new LivekitModels$ParticipantPermission();
        DEFAULT_INSTANCE = livekitModels$ParticipantPermission;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$ParticipantPermission.class, livekitModels$ParticipantPermission);
    }

    private LivekitModels$ParticipantPermission() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCanPublishSources(Iterable<? extends EnumC9607aF3> iterable) {
        ensureCanPublishSourcesIsMutable();
        Iterator<? extends EnumC9607aF3> it = iterable.iterator();
        while (it.hasNext()) {
            this.canPublishSources_.b1(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCanPublishSourcesValue(Iterable<Integer> iterable) {
        ensureCanPublishSourcesIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.canPublishSources_.b1(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCanPublishSources(EnumC9607aF3 enumC9607aF3) {
        enumC9607aF3.getClass();
        ensureCanPublishSourcesIsMutable();
        this.canPublishSources_.b1(enumC9607aF3.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCanPublishSourcesValue(int i) {
        ensureCanPublishSourcesIsMutable();
        this.canPublishSources_.b1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgent() {
        this.agent_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanPublish() {
        this.canPublish_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanPublishData() {
        this.canPublishData_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanPublishSources() {
        this.canPublishSources_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanSubscribe() {
        this.canSubscribe_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanSubscribeMetrics() {
        this.canSubscribeMetrics_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanUpdateMetadata() {
        this.canUpdateMetadata_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHidden() {
        this.hidden_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRecorder() {
        this.recorder_ = false;
    }

    private void ensureCanPublishSourcesIsMutable() {
        B.g gVar = this.canPublishSources_;
        if (gVar.u()) {
            return;
        }
        this.canPublishSources_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static LivekitModels$ParticipantPermission getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$ParticipantPermission parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ParticipantPermission parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgent(boolean z) {
        this.agent_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanPublish(boolean z) {
        this.canPublish_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanPublishData(boolean z) {
        this.canPublishData_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanPublishSources(int i, EnumC9607aF3 enumC9607aF3) {
        enumC9607aF3.getClass();
        ensureCanPublishSourcesIsMutable();
        this.canPublishSources_.U(i, enumC9607aF3.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanPublishSourcesValue(int i, int i2) {
        ensureCanPublishSourcesIsMutable();
        this.canPublishSources_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanSubscribe(boolean z) {
        this.canSubscribe_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanSubscribeMetrics(boolean z) {
        this.canSubscribeMetrics_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanUpdateMetadata(boolean z) {
        this.canUpdateMetadata_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHidden(boolean z) {
        this.hidden_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecorder(boolean z) {
        this.recorder_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$ParticipantPermission();
            case 2:
                return new b(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\f\t\u0000\u0001\u0000\u0001\u0007\u0002\u0007\u0003\u0007\u0007\u0007\b\u0007\t,\n\u0007\u000b\u0007\f\u0007", new Object[]{"canSubscribe_", "canPublish_", "canPublishData_", "hidden_", "recorder_", "canPublishSources_", "canUpdateMetadata_", "agent_", "canSubscribeMetrics_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$ParticipantPermission.class) {
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

    @Deprecated
    public boolean getAgent() {
        return this.agent_;
    }

    public boolean getCanPublish() {
        return this.canPublish_;
    }

    public boolean getCanPublishData() {
        return this.canPublishData_;
    }

    public EnumC9607aF3 getCanPublishSources(int i) {
        EnumC9607aF3 enumC9607aF3J = EnumC9607aF3.j(this.canPublishSources_.getInt(i));
        return enumC9607aF3J == null ? EnumC9607aF3.UNRECOGNIZED : enumC9607aF3J;
    }

    public int getCanPublishSourcesCount() {
        return this.canPublishSources_.size();
    }

    public List<EnumC9607aF3> getCanPublishSourcesList() {
        return new B.h(this.canPublishSources_, canPublishSources_converter_);
    }

    public int getCanPublishSourcesValue(int i) {
        return this.canPublishSources_.getInt(i);
    }

    public List<Integer> getCanPublishSourcesValueList() {
        return this.canPublishSources_;
    }

    public boolean getCanSubscribe() {
        return this.canSubscribe_;
    }

    public boolean getCanSubscribeMetrics() {
        return this.canSubscribeMetrics_;
    }

    public boolean getCanUpdateMetadata() {
        return this.canUpdateMetadata_;
    }

    public boolean getHidden() {
        return this.hidden_;
    }

    @Deprecated
    public boolean getRecorder() {
        return this.recorder_;
    }

    public static b newBuilder(LivekitModels$ParticipantPermission livekitModels$ParticipantPermission) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitModels$ParticipantPermission);
    }

    public static LivekitModels$ParticipantPermission parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ParticipantPermission parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$ParticipantPermission parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$ParticipantPermission parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$ParticipantPermission parseFrom(byte[] bArr) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$ParticipantPermission parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$ParticipantPermission parseFrom(InputStream inputStream) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ParticipantPermission parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ParticipantPermission parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$ParticipantPermission parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$ParticipantPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
