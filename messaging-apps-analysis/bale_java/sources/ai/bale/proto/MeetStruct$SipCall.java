package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.K04;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetStruct$SipCall extends GeneratedMessageLite implements U64 {
    public static final int CALLEE_PHONE_FIELD_NUMBER = 10;
    public static final int CALLER_PHONE_FIELD_NUMBER = 6;
    public static final int CALLER_UID_FIELD_NUMBER = 5;
    public static final int CREATE_DATE_FIELD_NUMBER = 2;
    private static final MeetStruct$SipCall DEFAULT_INSTANCE;
    public static final int DISCARD_REASON_FIELD_NUMBER = 11;
    public static final int DURATION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int START_DATE_FIELD_NUMBER = 3;
    public static final int SWITCH_IP_FIELD_NUMBER = 7;
    public static final int SWITCH_PORT_FIELD_NUMBER = 8;
    public static final int TEMP_VOIP_TOKEN_FIELD_NUMBER = 9;
    private int callerUid_;
    private long createDate_;
    private int discardReason_;
    private int duration_;
    private long id_;
    private long startDate_;
    private String callerPhone_ = "";
    private String switchIp_ = "";
    private String switchPort_ = "";
    private String tempVoipToken_ = "";
    private String calleePhone_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$SipCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetStruct$SipCall meetStruct$SipCall = new MeetStruct$SipCall();
        DEFAULT_INSTANCE = meetStruct$SipCall;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$SipCall.class, meetStruct$SipCall);
    }

    private MeetStruct$SipCall() {
    }

    private void clearCalleePhone() {
        this.calleePhone_ = getDefaultInstance().getCalleePhone();
    }

    private void clearCallerPhone() {
        this.callerPhone_ = getDefaultInstance().getCallerPhone();
    }

    private void clearCallerUid() {
        this.callerUid_ = 0;
    }

    private void clearCreateDate() {
        this.createDate_ = 0L;
    }

    private void clearDiscardReason() {
        this.discardReason_ = 0;
    }

    private void clearDuration() {
        this.duration_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearStartDate() {
        this.startDate_ = 0L;
    }

    private void clearSwitchIp() {
        this.switchIp_ = getDefaultInstance().getSwitchIp();
    }

    private void clearSwitchPort() {
        this.switchPort_ = getDefaultInstance().getSwitchPort();
    }

    private void clearTempVoipToken() {
        this.tempVoipToken_ = getDefaultInstance().getTempVoipToken();
    }

    public static MeetStruct$SipCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$SipCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$SipCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCalleePhone(String str) {
        str.getClass();
        this.calleePhone_ = str;
    }

    private void setCalleePhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.calleePhone_ = abstractC2383g.f0();
    }

    private void setCallerPhone(String str) {
        str.getClass();
        this.callerPhone_ = str;
    }

    private void setCallerPhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.callerPhone_ = abstractC2383g.f0();
    }

    private void setCallerUid(int i) {
        this.callerUid_ = i;
    }

    private void setCreateDate(long j) {
        this.createDate_ = j;
    }

    private void setDiscardReason(K04 k04) {
        this.discardReason_ = k04.getNumber();
    }

    private void setDiscardReasonValue(int i) {
        this.discardReason_ = i;
    }

    private void setDuration(int i) {
        this.duration_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setStartDate(long j) {
        this.startDate_ = j;
    }

    private void setSwitchIp(String str) {
        str.getClass();
        this.switchIp_ = str;
    }

    private void setSwitchIpBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.switchIp_ = abstractC2383g.f0();
    }

    private void setSwitchPort(String str) {
        str.getClass();
        this.switchPort_ = str;
    }

    private void setSwitchPortBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.switchPort_ = abstractC2383g.f0();
    }

    private void setTempVoipToken(String str) {
        str.getClass();
        this.tempVoipToken_ = str;
    }

    private void setTempVoipTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.tempVoipToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$SipCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004\u0004\u0005\u0004\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000b\f", new Object[]{"id_", "createDate_", "startDate_", "duration_", "callerUid_", "callerPhone_", "switchIp_", "switchPort_", "tempVoipToken_", "calleePhone_", "discardReason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$SipCall.class) {
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

    public String getCalleePhone() {
        return this.calleePhone_;
    }

    public AbstractC2383g getCalleePhoneBytes() {
        return AbstractC2383g.N(this.calleePhone_);
    }

    public String getCallerPhone() {
        return this.callerPhone_;
    }

    public AbstractC2383g getCallerPhoneBytes() {
        return AbstractC2383g.N(this.callerPhone_);
    }

    public int getCallerUid() {
        return this.callerUid_;
    }

    public long getCreateDate() {
        return this.createDate_;
    }

    public K04 getDiscardReason() {
        K04 k04J = K04.j(this.discardReason_);
        return k04J == null ? K04.UNRECOGNIZED : k04J;
    }

    public int getDiscardReasonValue() {
        return this.discardReason_;
    }

    public int getDuration() {
        return this.duration_;
    }

    public long getId() {
        return this.id_;
    }

    public long getStartDate() {
        return this.startDate_;
    }

    public String getSwitchIp() {
        return this.switchIp_;
    }

    public AbstractC2383g getSwitchIpBytes() {
        return AbstractC2383g.N(this.switchIp_);
    }

    public String getSwitchPort() {
        return this.switchPort_;
    }

    public AbstractC2383g getSwitchPortBytes() {
        return AbstractC2383g.N(this.switchPort_);
    }

    public String getTempVoipToken() {
        return this.tempVoipToken_;
    }

    public AbstractC2383g getTempVoipTokenBytes() {
        return AbstractC2383g.N(this.tempVoipToken_);
    }

    public static a newBuilder(MeetStruct$SipCall meetStruct$SipCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$SipCall);
    }

    public static MeetStruct$SipCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$SipCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$SipCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$SipCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$SipCall parseFrom(byte[] bArr) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$SipCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$SipCall parseFrom(InputStream inputStream) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$SipCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$SipCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$SipCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$SipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
