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
public final class LivekitRtc$ParticipantUpdate extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$ParticipantUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANTS_FIELD_NUMBER = 1;
    private B.j participants_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$ParticipantUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$ParticipantUpdate livekitRtc$ParticipantUpdate = new LivekitRtc$ParticipantUpdate();
        DEFAULT_INSTANCE = livekitRtc$ParticipantUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$ParticipantUpdate.class, livekitRtc$ParticipantUpdate);
    }

    private LivekitRtc$ParticipantUpdate() {
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

    public static LivekitRtc$ParticipantUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$ParticipantUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$ParticipantUpdate();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"participants_", LivekitModels$ParticipantInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$ParticipantUpdate.class) {
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

    public static a newBuilder(LivekitRtc$ParticipantUpdate livekitRtc$ParticipantUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$ParticipantUpdate);
    }

    public static LivekitRtc$ParticipantUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipants(int i, LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(i, livekitModels$ParticipantInfo);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(byte[] bArr) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(InputStream inputStream) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$ParticipantUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$ParticipantUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
