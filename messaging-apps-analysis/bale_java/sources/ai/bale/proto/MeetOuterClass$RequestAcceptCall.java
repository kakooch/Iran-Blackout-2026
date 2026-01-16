package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestAcceptCall extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestAcceptCall DEFAULT_INSTANCE;
    public static final int INVITE_ENABLE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private long callId_;
    private CollectionsStruct$BooleanValue inviteEnable_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((MeetOuterClass$RequestAcceptCall) this.b).setCallId(j);
            return this;
        }

        public a B(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
            q();
            ((MeetOuterClass$RequestAcceptCall) this.b).setInviteEnable(collectionsStruct$BooleanValue);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestAcceptCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestAcceptCall meetOuterClass$RequestAcceptCall = new MeetOuterClass$RequestAcceptCall();
        DEFAULT_INSTANCE = meetOuterClass$RequestAcceptCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestAcceptCall.class, meetOuterClass$RequestAcceptCall);
    }

    private MeetOuterClass$RequestAcceptCall() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearInviteEnable() {
        this.inviteEnable_ = null;
        this.bitField0_ &= -2;
    }

    public static MeetOuterClass$RequestAcceptCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInviteEnable(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.inviteEnable_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.inviteEnable_ = collectionsStruct$BooleanValue;
        } else {
            this.inviteEnable_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.inviteEnable_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestAcceptCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(long j) {
        this.callId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInviteEnable(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.inviteEnable_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestAcceptCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000", new Object[]{"bitField0_", "callId_", "inviteEnable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestAcceptCall.class) {
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

    public long getCallId() {
        return this.callId_;
    }

    public CollectionsStruct$BooleanValue getInviteEnable() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.inviteEnable_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public boolean hasInviteEnable() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestAcceptCall meetOuterClass$RequestAcceptCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestAcceptCall);
    }

    public static MeetOuterClass$RequestAcceptCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestAcceptCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestAcceptCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
