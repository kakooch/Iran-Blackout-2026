package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC14042hF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$SimulateScenario extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$SimulateScenario DEFAULT_INSTANCE;
    public static final int DISCONNECT_SIGNAL_ON_RESUME_FIELD_NUMBER = 7;
    public static final int DISCONNECT_SIGNAL_ON_RESUME_NO_MESSAGES_FIELD_NUMBER = 8;
    public static final int LEAVE_REQUEST_FULL_RECONNECT_FIELD_NUMBER = 9;
    public static final int MIGRATION_FIELD_NUMBER = 3;
    public static final int NODE_FAILURE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SERVER_LEAVE_FIELD_NUMBER = 4;
    public static final int SPEAKER_UPDATE_FIELD_NUMBER = 1;
    public static final int SUBSCRIBER_BANDWIDTH_FIELD_NUMBER = 6;
    public static final int SWITCH_CANDIDATE_PROTOCOL_FIELD_NUMBER = 5;
    private int scenarioCase_ = 0;
    private Object scenario_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SimulateScenario.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SPEAKER_UPDATE(1),
        NODE_FAILURE(2),
        MIGRATION(3),
        SERVER_LEAVE(4),
        SWITCH_CANDIDATE_PROTOCOL(5),
        SUBSCRIBER_BANDWIDTH(6),
        DISCONNECT_SIGNAL_ON_RESUME(7),
        DISCONNECT_SIGNAL_ON_RESUME_NO_MESSAGES(8),
        LEAVE_REQUEST_FULL_RECONNECT(9),
        SCENARIO_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return SCENARIO_NOT_SET;
                case 1:
                    return SPEAKER_UPDATE;
                case 2:
                    return NODE_FAILURE;
                case 3:
                    return MIGRATION;
                case 4:
                    return SERVER_LEAVE;
                case 5:
                    return SWITCH_CANDIDATE_PROTOCOL;
                case 6:
                    return SUBSCRIBER_BANDWIDTH;
                case 7:
                    return DISCONNECT_SIGNAL_ON_RESUME;
                case 8:
                    return DISCONNECT_SIGNAL_ON_RESUME_NO_MESSAGES;
                case 9:
                    return LEAVE_REQUEST_FULL_RECONNECT;
                default:
                    return null;
            }
        }
    }

    static {
        LivekitRtc$SimulateScenario livekitRtc$SimulateScenario = new LivekitRtc$SimulateScenario();
        DEFAULT_INSTANCE = livekitRtc$SimulateScenario;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SimulateScenario.class, livekitRtc$SimulateScenario);
    }

    private LivekitRtc$SimulateScenario() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisconnectSignalOnResume() {
        if (this.scenarioCase_ == 7) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisconnectSignalOnResumeNoMessages() {
        if (this.scenarioCase_ == 8) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLeaveRequestFullReconnect() {
        if (this.scenarioCase_ == 9) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMigration() {
        if (this.scenarioCase_ == 3) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNodeFailure() {
        if (this.scenarioCase_ == 2) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScenario() {
        this.scenarioCase_ = 0;
        this.scenario_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerLeave() {
        if (this.scenarioCase_ == 4) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpeakerUpdate() {
        if (this.scenarioCase_ == 1) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscriberBandwidth() {
        if (this.scenarioCase_ == 6) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSwitchCandidateProtocol() {
        if (this.scenarioCase_ == 5) {
            this.scenarioCase_ = 0;
            this.scenario_ = null;
        }
    }

    public static LivekitRtc$SimulateScenario getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SimulateScenario parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SimulateScenario parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisconnectSignalOnResume(boolean z) {
        this.scenarioCase_ = 7;
        this.scenario_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisconnectSignalOnResumeNoMessages(boolean z) {
        this.scenarioCase_ = 8;
        this.scenario_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeaveRequestFullReconnect(boolean z) {
        this.scenarioCase_ = 9;
        this.scenario_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMigration(boolean z) {
        this.scenarioCase_ = 3;
        this.scenario_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeFailure(boolean z) {
        this.scenarioCase_ = 2;
        this.scenario_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerLeave(boolean z) {
        this.scenarioCase_ = 4;
        this.scenario_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakerUpdate(int i) {
        this.scenarioCase_ = 1;
        this.scenario_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscriberBandwidth(long j) {
        this.scenarioCase_ = 6;
        this.scenario_ = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwitchCandidateProtocol(EnumC14042hF3 enumC14042hF3) {
        this.scenario_ = Integer.valueOf(enumC14042hF3.getNumber());
        this.scenarioCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwitchCandidateProtocolValue(int i) {
        this.scenarioCase_ = 5;
        this.scenario_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SimulateScenario();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u00017\u0000\u0002:\u0000\u0003:\u0000\u0004:\u0000\u0005?\u0000\u00065\u0000\u0007:\u0000\b:\u0000\t:\u0000", new Object[]{"scenario_", "scenarioCase_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SimulateScenario.class) {
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

    public boolean getDisconnectSignalOnResume() {
        if (this.scenarioCase_ == 7) {
            return ((Boolean) this.scenario_).booleanValue();
        }
        return false;
    }

    public boolean getDisconnectSignalOnResumeNoMessages() {
        if (this.scenarioCase_ == 8) {
            return ((Boolean) this.scenario_).booleanValue();
        }
        return false;
    }

    public boolean getLeaveRequestFullReconnect() {
        if (this.scenarioCase_ == 9) {
            return ((Boolean) this.scenario_).booleanValue();
        }
        return false;
    }

    public boolean getMigration() {
        if (this.scenarioCase_ == 3) {
            return ((Boolean) this.scenario_).booleanValue();
        }
        return false;
    }

    public boolean getNodeFailure() {
        if (this.scenarioCase_ == 2) {
            return ((Boolean) this.scenario_).booleanValue();
        }
        return false;
    }

    public b getScenarioCase() {
        return b.j(this.scenarioCase_);
    }

    public boolean getServerLeave() {
        if (this.scenarioCase_ == 4) {
            return ((Boolean) this.scenario_).booleanValue();
        }
        return false;
    }

    public int getSpeakerUpdate() {
        if (this.scenarioCase_ == 1) {
            return ((Integer) this.scenario_).intValue();
        }
        return 0;
    }

    public long getSubscriberBandwidth() {
        if (this.scenarioCase_ == 6) {
            return ((Long) this.scenario_).longValue();
        }
        return 0L;
    }

    public EnumC14042hF3 getSwitchCandidateProtocol() {
        if (this.scenarioCase_ != 5) {
            return EnumC14042hF3.UDP;
        }
        EnumC14042hF3 enumC14042hF3J = EnumC14042hF3.j(((Integer) this.scenario_).intValue());
        return enumC14042hF3J == null ? EnumC14042hF3.UNRECOGNIZED : enumC14042hF3J;
    }

    public int getSwitchCandidateProtocolValue() {
        if (this.scenarioCase_ == 5) {
            return ((Integer) this.scenario_).intValue();
        }
        return 0;
    }

    public boolean hasDisconnectSignalOnResume() {
        return this.scenarioCase_ == 7;
    }

    public boolean hasDisconnectSignalOnResumeNoMessages() {
        return this.scenarioCase_ == 8;
    }

    public boolean hasLeaveRequestFullReconnect() {
        return this.scenarioCase_ == 9;
    }

    public boolean hasMigration() {
        return this.scenarioCase_ == 3;
    }

    public boolean hasNodeFailure() {
        return this.scenarioCase_ == 2;
    }

    public boolean hasServerLeave() {
        return this.scenarioCase_ == 4;
    }

    public boolean hasSpeakerUpdate() {
        return this.scenarioCase_ == 1;
    }

    public boolean hasSubscriberBandwidth() {
        return this.scenarioCase_ == 6;
    }

    public boolean hasSwitchCandidateProtocol() {
        return this.scenarioCase_ == 5;
    }

    public static a newBuilder(LivekitRtc$SimulateScenario livekitRtc$SimulateScenario) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SimulateScenario);
    }

    public static LivekitRtc$SimulateScenario parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SimulateScenario parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SimulateScenario parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$SimulateScenario parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SimulateScenario parseFrom(byte[] bArr) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SimulateScenario parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SimulateScenario parseFrom(InputStream inputStream) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SimulateScenario parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SimulateScenario parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SimulateScenario parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SimulateScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
