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

/* loaded from: classes8.dex */
public final class LivekitRoom$ListParticipantsResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$ListParticipantsResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANTS_FIELD_NUMBER = 1;
    private B.j participants_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$ListParticipantsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$ListParticipantsResponse livekitRoom$ListParticipantsResponse = new LivekitRoom$ListParticipantsResponse();
        DEFAULT_INSTANCE = livekitRoom$ListParticipantsResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$ListParticipantsResponse.class, livekitRoom$ListParticipantsResponse);
    }

    private LivekitRoom$ListParticipantsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllParticipants(Iterable<? extends LivekitModels$ParticipantInfo> iterable) {
        ensureParticipantsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.participants_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipants(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(livekitModels$ParticipantInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipants() {
        this.participants_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureParticipantsIsMutable() {
        B.j jVar = this.participants_;
        if (jVar.u()) {
            return;
        }
        this.participants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRoom$ListParticipantsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$ListParticipantsResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParticipants(int i) {
        ensureParticipantsIsMutable();
        this.participants_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipants(int i, LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureParticipantsIsMutable();
        this.participants_.set(i, livekitModels$ParticipantInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$ListParticipantsResponse();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"participants_", LivekitModels$ParticipantInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$ListParticipantsResponse.class) {
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

    public LivekitModels$ParticipantInfo getParticipants(int i) {
        return (LivekitModels$ParticipantInfo) this.participants_.get(i);
    }

    public int getParticipantsCount() {
        return this.participants_.size();
    }

    public List<LivekitModels$ParticipantInfo> getParticipantsList() {
        return this.participants_;
    }

    public p getParticipantsOrBuilder(int i) {
        return (p) this.participants_.get(i);
    }

    public List<? extends p> getParticipantsOrBuilderList() {
        return this.participants_;
    }

    public static a newBuilder(LivekitRoom$ListParticipantsResponse livekitRoom$ListParticipantsResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$ListParticipantsResponse);
    }

    public static LivekitRoom$ListParticipantsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipants(int i, LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(i, livekitModels$ParticipantInfo);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(byte[] bArr) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(InputStream inputStream) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$ListParticipantsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$ListParticipantsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
