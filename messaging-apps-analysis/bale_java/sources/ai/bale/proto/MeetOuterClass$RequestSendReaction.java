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
public final class MeetOuterClass$RequestSendReaction extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestSendReaction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTION_FIELD_NUMBER = 2;
    private long callId_;
    private String reaction_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((MeetOuterClass$RequestSendReaction) this.b).setCallId(j);
            return this;
        }

        public a B(String str) {
            q();
            ((MeetOuterClass$RequestSendReaction) this.b).setReaction(str);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestSendReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestSendReaction meetOuterClass$RequestSendReaction = new MeetOuterClass$RequestSendReaction();
        DEFAULT_INSTANCE = meetOuterClass$RequestSendReaction;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestSendReaction.class, meetOuterClass$RequestSendReaction);
    }

    private MeetOuterClass$RequestSendReaction() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearReaction() {
        this.reaction_ = getDefaultInstance().getReaction();
    }

    public static MeetOuterClass$RequestSendReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestSendReaction parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(long j) {
        this.callId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReaction(String str) {
        str.getClass();
        this.reaction_ = str;
    }

    private void setReactionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reaction_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestSendReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"callId_", "reaction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestSendReaction.class) {
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

    public String getReaction() {
        return this.reaction_;
    }

    public AbstractC2383g getReactionBytes() {
        return AbstractC2383g.N(this.reaction_);
    }

    public static a newBuilder(MeetOuterClass$RequestSendReaction meetOuterClass$RequestSendReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestSendReaction);
    }

    public static MeetOuterClass$RequestSendReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestSendReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestSendReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
