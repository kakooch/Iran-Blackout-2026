package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes8.dex */
public final class LivekitAgent$AvailabilityResponse extends GeneratedMessageLite implements U64 {
    public static final int AVAILABLE_FIELD_NUMBER = 2;
    private static final LivekitAgent$AvailabilityResponse DEFAULT_INSTANCE;
    public static final int JOB_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_ATTRIBUTES_FIELD_NUMBER = 7;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 5;
    public static final int PARTICIPANT_METADATA_FIELD_NUMBER = 6;
    public static final int PARTICIPANT_NAME_FIELD_NUMBER = 4;
    public static final int SUPPORTS_RESUME_FIELD_NUMBER = 3;
    public static final int TERMINATE_FIELD_NUMBER = 8;
    private boolean available_;
    private boolean supportsResume_;
    private boolean terminate_;
    private J participantAttributes_ = J.e();
    private String jobId_ = "";
    private String participantName_ = "";
    private String participantIdentity_ = "";
    private String participantMetadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$AvailabilityResponse.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    static {
        LivekitAgent$AvailabilityResponse livekitAgent$AvailabilityResponse = new LivekitAgent$AvailabilityResponse();
        DEFAULT_INSTANCE = livekitAgent$AvailabilityResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$AvailabilityResponse.class, livekitAgent$AvailabilityResponse);
    }

    private LivekitAgent$AvailabilityResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAvailable() {
        this.available_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJobId() {
        this.jobId_ = getDefaultInstance().getJobId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantMetadata() {
        this.participantMetadata_ = getDefaultInstance().getParticipantMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantName() {
        this.participantName_ = getDefaultInstance().getParticipantName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSupportsResume() {
        this.supportsResume_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTerminate() {
        this.terminate_ = false;
    }

    public static LivekitAgent$AvailabilityResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableParticipantAttributesMap() {
        return internalGetMutableParticipantAttributes();
    }

    private J internalGetMutableParticipantAttributes() {
        if (!this.participantAttributes_.n()) {
            this.participantAttributes_ = this.participantAttributes_.s();
        }
        return this.participantAttributes_;
    }

    private J internalGetParticipantAttributes() {
        return this.participantAttributes_;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$AvailabilityResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAvailable(boolean z) {
        this.available_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobId(String str) {
        str.getClass();
        this.jobId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.jobId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentity(String str) {
        str.getClass();
        this.participantIdentity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantIdentity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantMetadata(String str) {
        str.getClass();
        this.participantMetadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantMetadata_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantName(String str) {
        str.getClass();
        this.participantName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSupportsResume(boolean z) {
        this.supportsResume_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTerminate(boolean z) {
        this.terminate_ = z;
    }

    public boolean containsParticipantAttributes(String str) {
        str.getClass();
        return internalGetParticipantAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$AvailabilityResponse();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0001\u0000\u0000\u0001Ȉ\u0002\u0007\u0003\u0007\u0004Ȉ\u0005Ȉ\u0006Ȉ\u00072\b\u0007", new Object[]{"jobId_", "available_", "supportsResume_", "participantName_", "participantIdentity_", "participantMetadata_", "participantAttributes_", b.a, "terminate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$AvailabilityResponse.class) {
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

    public boolean getAvailable() {
        return this.available_;
    }

    public String getJobId() {
        return this.jobId_;
    }

    public AbstractC2383g getJobIdBytes() {
        return AbstractC2383g.N(this.jobId_);
    }

    @Deprecated
    public Map<String, String> getParticipantAttributes() {
        return getParticipantAttributesMap();
    }

    public int getParticipantAttributesCount() {
        return internalGetParticipantAttributes().size();
    }

    public Map<String, String> getParticipantAttributesMap() {
        return Collections.unmodifiableMap(internalGetParticipantAttributes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getParticipantAttributesOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetParticipantAttributes = internalGetParticipantAttributes();
        return jInternalGetParticipantAttributes.containsKey(str) ? (String) jInternalGetParticipantAttributes.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getParticipantAttributesOrThrow(String str) {
        str.getClass();
        J jInternalGetParticipantAttributes = internalGetParticipantAttributes();
        if (jInternalGetParticipantAttributes.containsKey(str)) {
            return (String) jInternalGetParticipantAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public String getParticipantMetadata() {
        return this.participantMetadata_;
    }

    public AbstractC2383g getParticipantMetadataBytes() {
        return AbstractC2383g.N(this.participantMetadata_);
    }

    public String getParticipantName() {
        return this.participantName_;
    }

    public AbstractC2383g getParticipantNameBytes() {
        return AbstractC2383g.N(this.participantName_);
    }

    public boolean getSupportsResume() {
        return this.supportsResume_;
    }

    public boolean getTerminate() {
        return this.terminate_;
    }

    public static a newBuilder(LivekitAgent$AvailabilityResponse livekitAgent$AvailabilityResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$AvailabilityResponse);
    }

    public static LivekitAgent$AvailabilityResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(byte[] bArr) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(InputStream inputStream) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$AvailabilityResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$AvailabilityResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
