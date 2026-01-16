package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestJoinGroupCall extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestJoinGroupCall DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private long callId_;
    private CollectionsStruct$StringValue name_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((MeetOuterClass$RequestJoinGroupCall) this.b).setCallId(j);
            return this;
        }

        public a B(CollectionsStruct$StringValue collectionsStruct$StringValue) {
            q();
            ((MeetOuterClass$RequestJoinGroupCall) this.b).setName(collectionsStruct$StringValue);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestJoinGroupCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestJoinGroupCall meetOuterClass$RequestJoinGroupCall = new MeetOuterClass$RequestJoinGroupCall();
        DEFAULT_INSTANCE = meetOuterClass$RequestJoinGroupCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestJoinGroupCall.class, meetOuterClass$RequestJoinGroupCall);
    }

    private MeetOuterClass$RequestJoinGroupCall() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearName() {
        this.name_ = null;
        this.bitField0_ &= -2;
    }

    public static MeetOuterClass$RequestJoinGroupCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeName(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.name_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.name_ = collectionsStruct$StringValue;
        } else {
            this.name_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.name_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestJoinGroupCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(long j) {
        this.callId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.name_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestJoinGroupCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000", new Object[]{"bitField0_", "callId_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestJoinGroupCall.class) {
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

    public CollectionsStruct$StringValue getName() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.name_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestJoinGroupCall meetOuterClass$RequestJoinGroupCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestJoinGroupCall);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestJoinGroupCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestJoinGroupCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
