package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TuringStruct$TranscriptReactionEvent extends GeneratedMessageLite implements U64 {
    private static final TuringStruct$TranscriptReactionEvent DEFAULT_INSTANCE;
    public static final int OUT_PEER_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int REACTION_TYPE_FIELD_NUMBER = 3;
    public static final int VOICE_ACCESS_HASH_FIELD_NUMBER = 2;
    public static final int VOICE_FILE_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$OutExPeer outPeer_;
    private int reactionType_;
    private long voiceAccessHash_;
    private long voiceFileId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$OutExPeer peersStruct$OutExPeer) {
            q();
            ((TuringStruct$TranscriptReactionEvent) this.b).setOutPeer(peersStruct$OutExPeer);
            return this;
        }

        public a B(int i) {
            q();
            ((TuringStruct$TranscriptReactionEvent) this.b).setReactionType(i);
            return this;
        }

        public a C(long j) {
            q();
            ((TuringStruct$TranscriptReactionEvent) this.b).setVoiceAccessHash(j);
            return this;
        }

        public a D(long j) {
            q();
            ((TuringStruct$TranscriptReactionEvent) this.b).setVoiceFileId(j);
            return this;
        }

        private a() {
            super(TuringStruct$TranscriptReactionEvent.DEFAULT_INSTANCE);
        }
    }

    static {
        TuringStruct$TranscriptReactionEvent turingStruct$TranscriptReactionEvent = new TuringStruct$TranscriptReactionEvent();
        DEFAULT_INSTANCE = turingStruct$TranscriptReactionEvent;
        GeneratedMessageLite.registerDefaultInstance(TuringStruct$TranscriptReactionEvent.class, turingStruct$TranscriptReactionEvent);
    }

    private TuringStruct$TranscriptReactionEvent() {
    }

    private void clearOutPeer() {
        this.outPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReactionType() {
        this.reactionType_ = 0;
    }

    private void clearVoiceAccessHash() {
        this.voiceAccessHash_ = 0L;
    }

    private void clearVoiceFileId() {
        this.voiceFileId_ = 0L;
    }

    public static TuringStruct$TranscriptReactionEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOutPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.outPeer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.outPeer_ = peersStruct$OutExPeer;
        } else {
            this.outPeer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.outPeer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TuringStruct$TranscriptReactionEvent parseDelimitedFrom(InputStream inputStream) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(ByteBuffer byteBuffer) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.outPeer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReactionType(int i) {
        this.reactionType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVoiceAccessHash(long j) {
        this.voiceAccessHash_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVoiceFileId(long j) {
        this.voiceFileId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (n2.a[gVar.ordinal()]) {
            case 1:
                return new TuringStruct$TranscriptReactionEvent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0004\u0004ဉ\u0000", new Object[]{"bitField0_", "voiceFileId_", "voiceAccessHash_", "reactionType_", "outPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TuringStruct$TranscriptReactionEvent.class) {
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

    public PeersStruct$OutExPeer getOutPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.outPeer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public int getReactionType() {
        return this.reactionType_;
    }

    public long getVoiceAccessHash() {
        return this.voiceAccessHash_;
    }

    public long getVoiceFileId() {
        return this.voiceFileId_;
    }

    public boolean hasOutPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(TuringStruct$TranscriptReactionEvent turingStruct$TranscriptReactionEvent) {
        return (a) DEFAULT_INSTANCE.createBuilder(turingStruct$TranscriptReactionEvent);
    }

    public static TuringStruct$TranscriptReactionEvent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(AbstractC2383g abstractC2383g) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(byte[] bArr) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(byte[] bArr, C2394s c2394s) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(InputStream inputStream) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(AbstractC2384h abstractC2384h) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TuringStruct$TranscriptReactionEvent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TuringStruct$TranscriptReactionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
