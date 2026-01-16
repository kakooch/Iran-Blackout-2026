package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitMetrics$MetricsBatch;
import livekit.LivekitModels$ActiveSpeakerUpdate;
import livekit.LivekitModels$ChatMessage;
import livekit.LivekitModels$DataStream;
import livekit.LivekitModels$RpcAck;
import livekit.LivekitModels$RpcRequest;
import livekit.LivekitModels$RpcResponse;
import livekit.LivekitModels$SipDTMF;
import livekit.LivekitModels$Transcription;
import livekit.LivekitModels$UserPacket;

/* loaded from: classes8.dex */
public final class LivekitModels$DataPacket extends GeneratedMessageLite implements U64 {
    public static final int CHAT_MESSAGE_FIELD_NUMBER = 9;
    private static final LivekitModels$DataPacket DEFAULT_INSTANCE;
    public static final int DESTINATION_IDENTITIES_FIELD_NUMBER = 5;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int METRICS_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 4;
    public static final int PARTICIPANT_SID_FIELD_NUMBER = 17;
    public static final int RPC_ACK_FIELD_NUMBER = 11;
    public static final int RPC_REQUEST_FIELD_NUMBER = 10;
    public static final int RPC_RESPONSE_FIELD_NUMBER = 12;
    public static final int SEQUENCE_FIELD_NUMBER = 16;
    public static final int SIP_DTMF_FIELD_NUMBER = 6;
    public static final int SPEAKER_FIELD_NUMBER = 3;
    public static final int STREAM_CHUNK_FIELD_NUMBER = 14;
    public static final int STREAM_HEADER_FIELD_NUMBER = 13;
    public static final int STREAM_TRAILER_FIELD_NUMBER = 15;
    public static final int TRANSCRIPTION_FIELD_NUMBER = 7;
    public static final int USER_FIELD_NUMBER = 2;
    private int kind_;
    private int sequence_;
    private Object value_;
    private int valueCase_ = 0;
    private String participantIdentity_ = "";
    private B.j destinationIdentities_ = GeneratedMessageLite.emptyProtobufList();
    private String participantSid_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitModels$DataPacket) this.b).addDestinationIdentities(str);
            return this;
        }

        public a B(b bVar) {
            q();
            ((LivekitModels$DataPacket) this.b).setKind(bVar);
            return this;
        }

        public a C(LivekitMetrics$MetricsBatch livekitMetrics$MetricsBatch) {
            q();
            ((LivekitModels$DataPacket) this.b).setMetrics(livekitMetrics$MetricsBatch);
            return this;
        }

        public a D(LivekitModels$RpcAck livekitModels$RpcAck) {
            q();
            ((LivekitModels$DataPacket) this.b).setRpcAck(livekitModels$RpcAck);
            return this;
        }

        public a E(LivekitModels$RpcResponse livekitModels$RpcResponse) {
            q();
            ((LivekitModels$DataPacket) this.b).setRpcResponse(livekitModels$RpcResponse);
            return this;
        }

        public a F(int i) {
            q();
            ((LivekitModels$DataPacket) this.b).setSequence(i);
            return this;
        }

        private a() {
            super(LivekitModels$DataPacket.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        RELIABLE(0),
        LOSSY(1),
        UNRECOGNIZED(-1);

        private static final B.d e = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.j(i);
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return RELIABLE;
            }
            if (i != 1) {
                return null;
            }
            return LOSSY;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public enum c {
        USER(2),
        SPEAKER(3),
        SIP_DTMF(6),
        TRANSCRIPTION(7),
        METRICS(8),
        CHAT_MESSAGE(9),
        RPC_REQUEST(10),
        RPC_ACK(11),
        RPC_RESPONSE(12),
        STREAM_HEADER(13),
        STREAM_CHUNK(14),
        STREAM_TRAILER(15),
        VALUE_NOT_SET(0);

        private final int a;

        c(int i) {
            this.a = i;
        }

        public static c j(int i) {
            if (i == 0) {
                return VALUE_NOT_SET;
            }
            if (i == 2) {
                return USER;
            }
            if (i == 3) {
                return SPEAKER;
            }
            switch (i) {
                case 6:
                    return SIP_DTMF;
                case 7:
                    return TRANSCRIPTION;
                case 8:
                    return METRICS;
                case 9:
                    return CHAT_MESSAGE;
                case 10:
                    return RPC_REQUEST;
                case 11:
                    return RPC_ACK;
                case 12:
                    return RPC_RESPONSE;
                case 13:
                    return STREAM_HEADER;
                case 14:
                    return STREAM_CHUNK;
                case 15:
                    return STREAM_TRAILER;
                default:
                    return null;
            }
        }
    }

    static {
        LivekitModels$DataPacket livekitModels$DataPacket = new LivekitModels$DataPacket();
        DEFAULT_INSTANCE = livekitModels$DataPacket;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$DataPacket.class, livekitModels$DataPacket);
    }

    private LivekitModels$DataPacket() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDestinationIdentities(Iterable<String> iterable) {
        ensureDestinationIdentitiesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.destinationIdentities_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationIdentities(String str) {
        str.getClass();
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationIdentitiesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChatMessage() {
        if (this.valueCase_ == 9) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationIdentities() {
        this.destinationIdentities_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetrics() {
        if (this.valueCase_ == 8) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSid() {
        this.participantSid_ = getDefaultInstance().getParticipantSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRpcAck() {
        if (this.valueCase_ == 11) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRpcRequest() {
        if (this.valueCase_ == 10) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRpcResponse() {
        if (this.valueCase_ == 12) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSequence() {
        this.sequence_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipDtmf() {
        if (this.valueCase_ == 6) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpeaker() {
        if (this.valueCase_ == 3) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamChunk() {
        if (this.valueCase_ == 14) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamHeader() {
        if (this.valueCase_ == 13) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamTrailer() {
        if (this.valueCase_ == 15) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTranscription() {
        if (this.valueCase_ == 7) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUser() {
        if (this.valueCase_ == 2) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.valueCase_ = 0;
        this.value_ = null;
    }

    private void ensureDestinationIdentitiesIsMutable() {
        B.j jVar = this.destinationIdentities_;
        if (jVar.u()) {
            return;
        }
        this.destinationIdentities_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$DataPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeChatMessage(LivekitModels$ChatMessage livekitModels$ChatMessage) {
        livekitModels$ChatMessage.getClass();
        if (this.valueCase_ != 9 || this.value_ == LivekitModels$ChatMessage.getDefaultInstance()) {
            this.value_ = livekitModels$ChatMessage;
        } else {
            this.value_ = ((LivekitModels$ChatMessage.a) LivekitModels$ChatMessage.newBuilder((LivekitModels$ChatMessage) this.value_).v(livekitModels$ChatMessage)).j();
        }
        this.valueCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMetrics(LivekitMetrics$MetricsBatch livekitMetrics$MetricsBatch) {
        livekitMetrics$MetricsBatch.getClass();
        if (this.valueCase_ != 8 || this.value_ == LivekitMetrics$MetricsBatch.getDefaultInstance()) {
            this.value_ = livekitMetrics$MetricsBatch;
        } else {
            this.value_ = ((LivekitMetrics$MetricsBatch.a) LivekitMetrics$MetricsBatch.newBuilder((LivekitMetrics$MetricsBatch) this.value_).v(livekitMetrics$MetricsBatch)).j();
        }
        this.valueCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRpcAck(LivekitModels$RpcAck livekitModels$RpcAck) {
        livekitModels$RpcAck.getClass();
        if (this.valueCase_ != 11 || this.value_ == LivekitModels$RpcAck.getDefaultInstance()) {
            this.value_ = livekitModels$RpcAck;
        } else {
            this.value_ = ((LivekitModels$RpcAck.a) LivekitModels$RpcAck.newBuilder((LivekitModels$RpcAck) this.value_).v(livekitModels$RpcAck)).j();
        }
        this.valueCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRpcRequest(LivekitModels$RpcRequest livekitModels$RpcRequest) {
        livekitModels$RpcRequest.getClass();
        if (this.valueCase_ != 10 || this.value_ == LivekitModels$RpcRequest.getDefaultInstance()) {
            this.value_ = livekitModels$RpcRequest;
        } else {
            this.value_ = ((LivekitModels$RpcRequest.a) LivekitModels$RpcRequest.newBuilder((LivekitModels$RpcRequest) this.value_).v(livekitModels$RpcRequest)).j();
        }
        this.valueCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRpcResponse(LivekitModels$RpcResponse livekitModels$RpcResponse) {
        livekitModels$RpcResponse.getClass();
        if (this.valueCase_ != 12 || this.value_ == LivekitModels$RpcResponse.getDefaultInstance()) {
            this.value_ = livekitModels$RpcResponse;
        } else {
            this.value_ = ((LivekitModels$RpcResponse.a) LivekitModels$RpcResponse.newBuilder((LivekitModels$RpcResponse) this.value_).v(livekitModels$RpcResponse)).j();
        }
        this.valueCase_ = 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSipDtmf(LivekitModels$SipDTMF livekitModels$SipDTMF) {
        livekitModels$SipDTMF.getClass();
        if (this.valueCase_ != 6 || this.value_ == LivekitModels$SipDTMF.getDefaultInstance()) {
            this.value_ = livekitModels$SipDTMF;
        } else {
            this.value_ = ((LivekitModels$SipDTMF.a) LivekitModels$SipDTMF.newBuilder((LivekitModels$SipDTMF) this.value_).v(livekitModels$SipDTMF)).j();
        }
        this.valueCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSpeaker(LivekitModels$ActiveSpeakerUpdate livekitModels$ActiveSpeakerUpdate) {
        livekitModels$ActiveSpeakerUpdate.getClass();
        if (this.valueCase_ != 3 || this.value_ == LivekitModels$ActiveSpeakerUpdate.getDefaultInstance()) {
            this.value_ = livekitModels$ActiveSpeakerUpdate;
        } else {
            this.value_ = ((LivekitModels$ActiveSpeakerUpdate.a) LivekitModels$ActiveSpeakerUpdate.newBuilder((LivekitModels$ActiveSpeakerUpdate) this.value_).v(livekitModels$ActiveSpeakerUpdate)).j();
        }
        this.valueCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStreamChunk(LivekitModels$DataStream.Chunk chunk) {
        chunk.getClass();
        if (this.valueCase_ != 14 || this.value_ == LivekitModels$DataStream.Chunk.getDefaultInstance()) {
            this.value_ = chunk;
        } else {
            this.value_ = ((LivekitModels$DataStream.Chunk.a) LivekitModels$DataStream.Chunk.newBuilder((LivekitModels$DataStream.Chunk) this.value_).v(chunk)).j();
        }
        this.valueCase_ = 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStreamHeader(LivekitModels$DataStream.Header header) {
        header.getClass();
        if (this.valueCase_ != 13 || this.value_ == LivekitModels$DataStream.Header.getDefaultInstance()) {
            this.value_ = header;
        } else {
            this.value_ = ((LivekitModels$DataStream.Header.b) LivekitModels$DataStream.Header.newBuilder((LivekitModels$DataStream.Header) this.value_).v(header)).j();
        }
        this.valueCase_ = 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStreamTrailer(LivekitModels$DataStream.Trailer trailer) {
        trailer.getClass();
        if (this.valueCase_ != 15 || this.value_ == LivekitModels$DataStream.Trailer.getDefaultInstance()) {
            this.value_ = trailer;
        } else {
            this.value_ = ((LivekitModels$DataStream.Trailer.b) LivekitModels$DataStream.Trailer.newBuilder((LivekitModels$DataStream.Trailer) this.value_).v(trailer)).j();
        }
        this.valueCase_ = 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTranscription(LivekitModels$Transcription livekitModels$Transcription) {
        livekitModels$Transcription.getClass();
        if (this.valueCase_ != 7 || this.value_ == LivekitModels$Transcription.getDefaultInstance()) {
            this.value_ = livekitModels$Transcription;
        } else {
            this.value_ = ((LivekitModels$Transcription.a) LivekitModels$Transcription.newBuilder((LivekitModels$Transcription) this.value_).v(livekitModels$Transcription)).j();
        }
        this.valueCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUser(LivekitModels$UserPacket livekitModels$UserPacket) {
        livekitModels$UserPacket.getClass();
        if (this.valueCase_ != 2 || this.value_ == LivekitModels$UserPacket.getDefaultInstance()) {
            this.value_ = livekitModels$UserPacket;
        } else {
            this.value_ = ((LivekitModels$UserPacket.a) LivekitModels$UserPacket.newBuilder((LivekitModels$UserPacket) this.value_).v(livekitModels$UserPacket)).j();
        }
        this.valueCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$DataPacket parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$DataPacket parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChatMessage(LivekitModels$ChatMessage livekitModels$ChatMessage) {
        livekitModels$ChatMessage.getClass();
        this.value_ = livekitModels$ChatMessage;
        this.valueCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationIdentities(int i, String str) {
        str.getClass();
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(b bVar) {
        this.kind_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindValue(int i) {
        this.kind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetrics(LivekitMetrics$MetricsBatch livekitMetrics$MetricsBatch) {
        livekitMetrics$MetricsBatch.getClass();
        this.value_ = livekitMetrics$MetricsBatch;
        this.valueCase_ = 8;
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
    public void setParticipantSid(String str) {
        str.getClass();
        this.participantSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantSid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRpcAck(LivekitModels$RpcAck livekitModels$RpcAck) {
        livekitModels$RpcAck.getClass();
        this.value_ = livekitModels$RpcAck;
        this.valueCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRpcRequest(LivekitModels$RpcRequest livekitModels$RpcRequest) {
        livekitModels$RpcRequest.getClass();
        this.value_ = livekitModels$RpcRequest;
        this.valueCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRpcResponse(LivekitModels$RpcResponse livekitModels$RpcResponse) {
        livekitModels$RpcResponse.getClass();
        this.value_ = livekitModels$RpcResponse;
        this.valueCase_ = 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSequence(int i) {
        this.sequence_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipDtmf(LivekitModels$SipDTMF livekitModels$SipDTMF) {
        livekitModels$SipDTMF.getClass();
        this.value_ = livekitModels$SipDTMF;
        this.valueCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeaker(LivekitModels$ActiveSpeakerUpdate livekitModels$ActiveSpeakerUpdate) {
        livekitModels$ActiveSpeakerUpdate.getClass();
        this.value_ = livekitModels$ActiveSpeakerUpdate;
        this.valueCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamChunk(LivekitModels$DataStream.Chunk chunk) {
        chunk.getClass();
        this.value_ = chunk;
        this.valueCase_ = 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamHeader(LivekitModels$DataStream.Header header) {
        header.getClass();
        this.value_ = header;
        this.valueCase_ = 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamTrailer(LivekitModels$DataStream.Trailer trailer) {
        trailer.getClass();
        this.value_ = trailer;
        this.valueCase_ = 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranscription(LivekitModels$Transcription livekitModels$Transcription) {
        livekitModels$Transcription.getClass();
        this.value_ = livekitModels$Transcription;
        this.valueCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUser(LivekitModels$UserPacket livekitModels$UserPacket) {
        livekitModels$UserPacket.getClass();
        this.value_ = livekitModels$UserPacket;
        this.valueCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$DataPacket();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0001\u0000\u0001\u0011\u0011\u0000\u0001\u0000\u0001\f\u0002<\u0000\u0003<\u0000\u0004Ȉ\u0005Ț\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010\u000b\u0011Ȉ", new Object[]{"value_", "valueCase_", "kind_", LivekitModels$UserPacket.class, LivekitModels$ActiveSpeakerUpdate.class, "participantIdentity_", "destinationIdentities_", LivekitModels$SipDTMF.class, LivekitModels$Transcription.class, LivekitMetrics$MetricsBatch.class, LivekitModels$ChatMessage.class, LivekitModels$RpcRequest.class, LivekitModels$RpcAck.class, LivekitModels$RpcResponse.class, LivekitModels$DataStream.Header.class, LivekitModels$DataStream.Chunk.class, LivekitModels$DataStream.Trailer.class, "sequence_", "participantSid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$DataPacket.class) {
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

    public LivekitModels$ChatMessage getChatMessage() {
        return this.valueCase_ == 9 ? (LivekitModels$ChatMessage) this.value_ : LivekitModels$ChatMessage.getDefaultInstance();
    }

    public String getDestinationIdentities(int i) {
        return (String) this.destinationIdentities_.get(i);
    }

    public AbstractC2383g getDestinationIdentitiesBytes(int i) {
        return AbstractC2383g.N((String) this.destinationIdentities_.get(i));
    }

    public int getDestinationIdentitiesCount() {
        return this.destinationIdentities_.size();
    }

    public List<String> getDestinationIdentitiesList() {
        return this.destinationIdentities_;
    }

    @Deprecated
    public b getKind() {
        b bVarJ = b.j(this.kind_);
        return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
    }

    @Deprecated
    public int getKindValue() {
        return this.kind_;
    }

    public LivekitMetrics$MetricsBatch getMetrics() {
        return this.valueCase_ == 8 ? (LivekitMetrics$MetricsBatch) this.value_ : LivekitMetrics$MetricsBatch.getDefaultInstance();
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public String getParticipantSid() {
        return this.participantSid_;
    }

    public AbstractC2383g getParticipantSidBytes() {
        return AbstractC2383g.N(this.participantSid_);
    }

    public LivekitModels$RpcAck getRpcAck() {
        return this.valueCase_ == 11 ? (LivekitModels$RpcAck) this.value_ : LivekitModels$RpcAck.getDefaultInstance();
    }

    public LivekitModels$RpcRequest getRpcRequest() {
        return this.valueCase_ == 10 ? (LivekitModels$RpcRequest) this.value_ : LivekitModels$RpcRequest.getDefaultInstance();
    }

    public LivekitModels$RpcResponse getRpcResponse() {
        return this.valueCase_ == 12 ? (LivekitModels$RpcResponse) this.value_ : LivekitModels$RpcResponse.getDefaultInstance();
    }

    public int getSequence() {
        return this.sequence_;
    }

    public LivekitModels$SipDTMF getSipDtmf() {
        return this.valueCase_ == 6 ? (LivekitModels$SipDTMF) this.value_ : LivekitModels$SipDTMF.getDefaultInstance();
    }

    @Deprecated
    public LivekitModels$ActiveSpeakerUpdate getSpeaker() {
        return this.valueCase_ == 3 ? (LivekitModels$ActiveSpeakerUpdate) this.value_ : LivekitModels$ActiveSpeakerUpdate.getDefaultInstance();
    }

    public LivekitModels$DataStream.Chunk getStreamChunk() {
        return this.valueCase_ == 14 ? (LivekitModels$DataStream.Chunk) this.value_ : LivekitModels$DataStream.Chunk.getDefaultInstance();
    }

    public LivekitModels$DataStream.Header getStreamHeader() {
        return this.valueCase_ == 13 ? (LivekitModels$DataStream.Header) this.value_ : LivekitModels$DataStream.Header.getDefaultInstance();
    }

    public LivekitModels$DataStream.Trailer getStreamTrailer() {
        return this.valueCase_ == 15 ? (LivekitModels$DataStream.Trailer) this.value_ : LivekitModels$DataStream.Trailer.getDefaultInstance();
    }

    public LivekitModels$Transcription getTranscription() {
        return this.valueCase_ == 7 ? (LivekitModels$Transcription) this.value_ : LivekitModels$Transcription.getDefaultInstance();
    }

    public LivekitModels$UserPacket getUser() {
        return this.valueCase_ == 2 ? (LivekitModels$UserPacket) this.value_ : LivekitModels$UserPacket.getDefaultInstance();
    }

    public c getValueCase() {
        return c.j(this.valueCase_);
    }

    public boolean hasChatMessage() {
        return this.valueCase_ == 9;
    }

    public boolean hasMetrics() {
        return this.valueCase_ == 8;
    }

    public boolean hasRpcAck() {
        return this.valueCase_ == 11;
    }

    public boolean hasRpcRequest() {
        return this.valueCase_ == 10;
    }

    public boolean hasRpcResponse() {
        return this.valueCase_ == 12;
    }

    public boolean hasSipDtmf() {
        return this.valueCase_ == 6;
    }

    @Deprecated
    public boolean hasSpeaker() {
        return this.valueCase_ == 3;
    }

    public boolean hasStreamChunk() {
        return this.valueCase_ == 14;
    }

    public boolean hasStreamHeader() {
        return this.valueCase_ == 13;
    }

    public boolean hasStreamTrailer() {
        return this.valueCase_ == 15;
    }

    public boolean hasTranscription() {
        return this.valueCase_ == 7;
    }

    public boolean hasUser() {
        return this.valueCase_ == 2;
    }

    public static a newBuilder(LivekitModels$DataPacket livekitModels$DataPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$DataPacket);
    }

    public static LivekitModels$DataPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$DataPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$DataPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$DataPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$DataPacket parseFrom(byte[] bArr) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$DataPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$DataPacket parseFrom(InputStream inputStream) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$DataPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$DataPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$DataPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$DataPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
