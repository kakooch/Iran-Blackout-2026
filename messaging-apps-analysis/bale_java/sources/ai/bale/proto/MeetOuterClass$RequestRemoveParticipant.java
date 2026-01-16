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
public final class MeetOuterClass$RequestRemoveParticipant extends GeneratedMessageLite implements U64 {
    public static final int BLOCK_FROM_CALL_FIELD_NUMBER = 3;
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestRemoveParticipant DEFAULT_INSTANCE;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private boolean blockFromCall_;
    private long callId_;
    private String identity_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((MeetOuterClass$RequestRemoveParticipant) this.b).setBlockFromCall(z);
            return this;
        }

        public a B(long j) {
            q();
            ((MeetOuterClass$RequestRemoveParticipant) this.b).setCallId(j);
            return this;
        }

        public a C(String str) {
            q();
            ((MeetOuterClass$RequestRemoveParticipant) this.b).setIdentity(str);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestRemoveParticipant.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestRemoveParticipant meetOuterClass$RequestRemoveParticipant = new MeetOuterClass$RequestRemoveParticipant();
        DEFAULT_INSTANCE = meetOuterClass$RequestRemoveParticipant;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestRemoveParticipant.class, meetOuterClass$RequestRemoveParticipant);
    }

    private MeetOuterClass$RequestRemoveParticipant() {
    }

    private void clearBlockFromCall() {
        this.blockFromCall_ = false;
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    public static MeetOuterClass$RequestRemoveParticipant getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestRemoveParticipant parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBlockFromCall(boolean z) {
        this.blockFromCall_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(long j) {
        this.callId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentity(String str) {
        str.getClass();
        this.identity_ = str;
    }

    private void setIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.identity_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestRemoveParticipant();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0007", new Object[]{"callId_", "identity_", "blockFromCall_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestRemoveParticipant.class) {
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

    public boolean getBlockFromCall() {
        return this.blockFromCall_;
    }

    public long getCallId() {
        return this.callId_;
    }

    public String getIdentity() {
        return this.identity_;
    }

    public AbstractC2383g getIdentityBytes() {
        return AbstractC2383g.N(this.identity_);
    }

    public static a newBuilder(MeetOuterClass$RequestRemoveParticipant meetOuterClass$RequestRemoveParticipant) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestRemoveParticipant);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestRemoveParticipant parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestRemoveParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
