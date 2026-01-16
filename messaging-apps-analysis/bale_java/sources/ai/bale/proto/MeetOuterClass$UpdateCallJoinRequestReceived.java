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
public final class MeetOuterClass$UpdateCallJoinRequestReceived extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$UpdateCallJoinRequestReceived DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REQUESTER_IDENTIFIER_FIELD_NUMBER = 2;
    private long callId_;
    private String requesterIdentifier_ = "";
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateCallJoinRequestReceived.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdateCallJoinRequestReceived meetOuterClass$UpdateCallJoinRequestReceived = new MeetOuterClass$UpdateCallJoinRequestReceived();
        DEFAULT_INSTANCE = meetOuterClass$UpdateCallJoinRequestReceived;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateCallJoinRequestReceived.class, meetOuterClass$UpdateCallJoinRequestReceived);
    }

    private MeetOuterClass$UpdateCallJoinRequestReceived() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearRequesterIdentifier() {
        this.requesterIdentifier_ = getDefaultInstance().getRequesterIdentifier();
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
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
                return new MeetOuterClass$UpdateCallJoinRequestReceived();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ", new Object[]{"callId_", "requesterIdentifier_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateCallJoinRequestReceived.class) {
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

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getRequesterIdentifier() {
        return this.requesterIdentifier_;
    }

    public AbstractC2383g getRequesterIdentifierBytes() {
        return AbstractC2383g.N(this.requesterIdentifier_);
    }

    public static a newBuilder(MeetOuterClass$UpdateCallJoinRequestReceived meetOuterClass$UpdateCallJoinRequestReceived) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateCallJoinRequestReceived);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateCallJoinRequestReceived parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallJoinRequestReceived) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
