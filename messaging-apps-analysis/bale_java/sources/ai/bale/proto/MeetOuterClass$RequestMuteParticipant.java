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
public final class MeetOuterClass$RequestMuteParticipant extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestMuteParticipant DEFAULT_INSTANCE;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REVOKE_PUBLISH_PERMISSION_FIELD_NUMBER = 4;
    public static final int TRACK_ID_FIELD_NUMBER = 3;
    private long callId_;
    private boolean revokePublishPermission_;
    private String identity_ = "";
    private String trackId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((MeetOuterClass$RequestMuteParticipant) this.b).setCallId(j);
            return this;
        }

        public a B(String str) {
            q();
            ((MeetOuterClass$RequestMuteParticipant) this.b).setIdentity(str);
            return this;
        }

        public a C(String str) {
            q();
            ((MeetOuterClass$RequestMuteParticipant) this.b).setTrackId(str);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestMuteParticipant.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestMuteParticipant meetOuterClass$RequestMuteParticipant = new MeetOuterClass$RequestMuteParticipant();
        DEFAULT_INSTANCE = meetOuterClass$RequestMuteParticipant;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestMuteParticipant.class, meetOuterClass$RequestMuteParticipant);
    }

    private MeetOuterClass$RequestMuteParticipant() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    private void clearRevokePublishPermission() {
        this.revokePublishPermission_ = false;
    }

    private void clearTrackId() {
        this.trackId_ = getDefaultInstance().getTrackId();
    }

    public static MeetOuterClass$RequestMuteParticipant getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestMuteParticipant parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    private void setRevokePublishPermission(boolean z) {
        this.revokePublishPermission_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackId(String str) {
        str.getClass();
        this.trackId_ = str;
    }

    private void setTrackIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestMuteParticipant();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004\u0007", new Object[]{"callId_", "identity_", "trackId_", "revokePublishPermission_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestMuteParticipant.class) {
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

    public String getIdentity() {
        return this.identity_;
    }

    public AbstractC2383g getIdentityBytes() {
        return AbstractC2383g.N(this.identity_);
    }

    public boolean getRevokePublishPermission() {
        return this.revokePublishPermission_;
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public AbstractC2383g getTrackIdBytes() {
        return AbstractC2383g.N(this.trackId_);
    }

    public static a newBuilder(MeetOuterClass$RequestMuteParticipant meetOuterClass$RequestMuteParticipant) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestMuteParticipant);
    }

    public static MeetOuterClass$RequestMuteParticipant parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestMuteParticipant parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestMuteParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
