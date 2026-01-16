package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestAnswerCallJoinRequest extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestAnswerCallJoinRequest DEFAULT_INSTANCE;
    public static final int IS_ALLOWED_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REQUESTER_IDENTIFIER_FIELD_NUMBER = 2;
    private long callId_;
    private boolean isAllowed_;
    private String requesterIdentifier_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$RequestAnswerCallJoinRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestAnswerCallJoinRequest meetOuterClass$RequestAnswerCallJoinRequest = new MeetOuterClass$RequestAnswerCallJoinRequest();
        DEFAULT_INSTANCE = meetOuterClass$RequestAnswerCallJoinRequest;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestAnswerCallJoinRequest.class, meetOuterClass$RequestAnswerCallJoinRequest);
    }

    private MeetOuterClass$RequestAnswerCallJoinRequest() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearIsAllowed() {
        this.isAllowed_ = false;
    }

    private void clearRequesterIdentifier() {
        this.requesterIdentifier_ = getDefaultInstance().getRequesterIdentifier();
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setIsAllowed(boolean z) {
        this.isAllowed_ = z;
    }

    private void setRequesterIdentifier(String str) {
        str.getClass();
        this.requesterIdentifier_ = str;
    }

    private void setRequesterIdentifierBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.requesterIdentifier_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestAnswerCallJoinRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0007", new Object[]{"callId_", "requesterIdentifier_", "isAllowed_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestAnswerCallJoinRequest.class) {
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

    public boolean getIsAllowed() {
        return this.isAllowed_;
    }

    public String getRequesterIdentifier() {
        return this.requesterIdentifier_;
    }

    public AbstractC2383g getRequesterIdentifierBytes() {
        return AbstractC2383g.N(this.requesterIdentifier_);
    }

    public static a newBuilder(MeetOuterClass$RequestAnswerCallJoinRequest meetOuterClass$RequestAnswerCallJoinRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestAnswerCallJoinRequest);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestAnswerCallJoinRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestAnswerCallJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
