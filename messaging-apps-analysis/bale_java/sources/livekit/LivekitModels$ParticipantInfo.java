package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.RE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import livekit.LivekitModels$ParticipantPermission;

/* loaded from: classes8.dex */
public final class LivekitModels$ParticipantInfo extends GeneratedMessageLite implements p {
    public static final int ATTRIBUTES_FIELD_NUMBER = 15;
    private static final LivekitModels$ParticipantInfo DEFAULT_INSTANCE;
    public static final int DISCONNECT_REASON_FIELD_NUMBER = 16;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    public static final int IS_PUBLISHER_FIELD_NUMBER = 13;
    public static final int JOINED_AT_FIELD_NUMBER = 6;
    public static final int JOINED_AT_MS_FIELD_NUMBER = 17;
    public static final int KIND_DETAILS_FIELD_NUMBER = 18;
    public static final int KIND_FIELD_NUMBER = 14;
    public static final int METADATA_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int PERMISSION_FIELD_NUMBER = 11;
    public static final int REGION_FIELD_NUMBER = 12;
    public static final int SID_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 3;
    public static final int TRACKS_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 10;
    private static final B.h.a kindDetails_converter_ = new a();
    private int disconnectReason_;
    private boolean isPublisher_;
    private long joinedAtMs_;
    private long joinedAt_;
    private int kindDetailsMemoizedSerializedSize;
    private int kind_;
    private LivekitModels$ParticipantPermission permission_;
    private int state_;
    private int version_;
    private J attributes_ = J.e();
    private String sid_ = "";
    private String identity_ = "";
    private B.j tracks_ = GeneratedMessageLite.emptyProtobufList();
    private String metadata_ = "";
    private String name_ = "";
    private String region_ = "";
    private B.g kindDetails_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(Integer num) {
            e eVarJ = e.j(num.intValue());
            return eVarJ == null ? e.UNRECOGNIZED : eVarJ;
        }
    }

    private static final class b {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    public static final class c extends GeneratedMessageLite.b implements p {
        /* synthetic */ c(o oVar) {
            this();
        }

        public c A(String str) {
            q();
            ((LivekitModels$ParticipantInfo) this.b).setIdentity(str);
            return this;
        }

        private c() {
            super(LivekitModels$ParticipantInfo.DEFAULT_INSTANCE);
        }
    }

    public enum d implements B.c {
        STANDARD(0),
        INGRESS(1),
        EGRESS(2),
        SIP(3),
        AGENT(4),
        UNRECOGNIZED(-1);

        private static final B.d h = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i) {
                return d.j(i);
            }
        }

        d(int i2) {
            this.a = i2;
        }

        public static d j(int i2) {
            if (i2 == 0) {
                return STANDARD;
            }
            if (i2 == 1) {
                return INGRESS;
            }
            if (i2 == 2) {
                return EGRESS;
            }
            if (i2 == 3) {
                return SIP;
            }
            if (i2 != 4) {
                return null;
            }
            return AGENT;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public enum e implements B.c {
        CLOUD_AGENT(0),
        FORWARDED(1),
        UNRECOGNIZED(-1);

        private static final B.d e = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e a(int i) {
                return e.j(i);
            }
        }

        e(int i) {
            this.a = i;
        }

        public static e j(int i) {
            if (i == 0) {
                return CLOUD_AGENT;
            }
            if (i != 1) {
                return null;
            }
            return FORWARDED;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public enum f implements B.c {
        JOINING(0),
        JOINED(1),
        ACTIVE(2),
        DISCONNECTED(3),
        UNRECOGNIZED(-1);

        private static final B.d g = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f a(int i) {
                return f.j(i);
            }
        }

        f(int i) {
            this.a = i;
        }

        public static f j(int i) {
            if (i == 0) {
                return JOINING;
            }
            if (i == 1) {
                return JOINED;
            }
            if (i == 2) {
                return ACTIVE;
            }
            if (i != 3) {
                return null;
            }
            return DISCONNECTED;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = new LivekitModels$ParticipantInfo();
        DEFAULT_INSTANCE = livekitModels$ParticipantInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$ParticipantInfo.class, livekitModels$ParticipantInfo);
    }

    private LivekitModels$ParticipantInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKindDetails(Iterable<? extends e> iterable) {
        ensureKindDetailsIsMutable();
        Iterator<? extends e> it = iterable.iterator();
        while (it.hasNext()) {
            this.kindDetails_.b1(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKindDetailsValue(Iterable<Integer> iterable) {
        ensureKindDetailsIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.kindDetails_.b1(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTracks(Iterable<? extends LivekitModels$TrackInfo> iterable) {
        ensureTracksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tracks_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKindDetails(e eVar) {
        eVar.getClass();
        ensureKindDetailsIsMutable();
        this.kindDetails_.b1(eVar.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKindDetailsValue(int i) {
        ensureKindDetailsIsMutable();
        this.kindDetails_.b1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTracks(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        ensureTracksIsMutable();
        this.tracks_.add(livekitModels$TrackInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisconnectReason() {
        this.disconnectReason_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsPublisher() {
        this.isPublisher_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJoinedAt() {
        this.joinedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJoinedAtMs() {
        this.joinedAtMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKindDetails() {
        this.kindDetails_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPermission() {
        this.permission_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSid() {
        this.sid_ = getDefaultInstance().getSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTracks() {
        this.tracks_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    private void ensureKindDetailsIsMutable() {
        B.g gVar = this.kindDetails_;
        if (gVar.u()) {
            return;
        }
        this.kindDetails_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureTracksIsMutable() {
        B.j jVar = this.tracks_;
        if (jVar.u()) {
            return;
        }
        this.tracks_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$ParticipantInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableAttributesMap() {
        return internalGetMutableAttributes();
    }

    private J internalGetAttributes() {
        return this.attributes_;
    }

    private J internalGetMutableAttributes() {
        if (!this.attributes_.n()) {
            this.attributes_ = this.attributes_.s();
        }
        return this.attributes_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePermission(LivekitModels$ParticipantPermission livekitModels$ParticipantPermission) {
        livekitModels$ParticipantPermission.getClass();
        LivekitModels$ParticipantPermission livekitModels$ParticipantPermission2 = this.permission_;
        if (livekitModels$ParticipantPermission2 == null || livekitModels$ParticipantPermission2 == LivekitModels$ParticipantPermission.getDefaultInstance()) {
            this.permission_ = livekitModels$ParticipantPermission;
        } else {
            this.permission_ = (LivekitModels$ParticipantPermission) ((LivekitModels$ParticipantPermission.b) LivekitModels$ParticipantPermission.newBuilder(this.permission_).v(livekitModels$ParticipantPermission)).j();
        }
    }

    public static c newBuilder() {
        return (c) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$ParticipantInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ParticipantInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTracks(int i) {
        ensureTracksIsMutable();
        this.tracks_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisconnectReason(RE3 re3) {
        this.disconnectReason_ = re3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisconnectReasonValue(int i) {
        this.disconnectReason_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentity(String str) {
        str.getClass();
        this.identity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.identity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsPublisher(boolean z) {
        this.isPublisher_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJoinedAt(long j) {
        this.joinedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJoinedAtMs(long j) {
        this.joinedAtMs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(d dVar) {
        this.kind_ = dVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindDetails(int i, e eVar) {
        eVar.getClass();
        ensureKindDetailsIsMutable();
        this.kindDetails_.U(i, eVar.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindDetailsValue(int i, int i2) {
        ensureKindDetailsIsMutable();
        this.kindDetails_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindValue(int i) {
        this.kind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermission(LivekitModels$ParticipantPermission livekitModels$ParticipantPermission) {
        livekitModels$ParticipantPermission.getClass();
        this.permission_ = livekitModels$ParticipantPermission;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegion(String str) {
        str.getClass();
        this.region_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.region_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSid(String str) {
        str.getClass();
        this.sid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(f fVar) {
        this.state_ = fVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateValue(int i) {
        this.state_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTracks(int i, LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        ensureTracksIsMutable();
        this.tracks_.set(i, livekitModels$TrackInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    public boolean containsAttributes(String str) {
        str.getClass();
        return internalGetAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$ParticipantInfo();
            case 2:
                return new c(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0000\u0001\u0012\u0010\u0001\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\u001b\u0005Ȉ\u0006\u0002\tȈ\n\u000b\u000b\t\fȈ\r\u0007\u000e\f\u000f2\u0010\f\u0011\u0002\u0012,", new Object[]{"sid_", "identity_", "state_", "tracks_", LivekitModels$TrackInfo.class, "metadata_", "joinedAt_", "name_", "version_", "permission_", "region_", "isPublisher_", "kind_", "attributes_", b.a, "disconnectReason_", "joinedAtMs_", "kindDetails_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$ParticipantInfo.class) {
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

    @Deprecated
    public Map<String, String> getAttributes() {
        return getAttributesMap();
    }

    public int getAttributesCount() {
        return internalGetAttributes().size();
    }

    public Map<String, String> getAttributesMap() {
        return Collections.unmodifiableMap(internalGetAttributes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getAttributesOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetAttributes = internalGetAttributes();
        return jInternalGetAttributes.containsKey(str) ? (String) jInternalGetAttributes.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getAttributesOrThrow(String str) {
        str.getClass();
        J jInternalGetAttributes = internalGetAttributes();
        if (jInternalGetAttributes.containsKey(str)) {
            return (String) jInternalGetAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    public RE3 getDisconnectReason() {
        RE3 re3J = RE3.j(this.disconnectReason_);
        return re3J == null ? RE3.UNRECOGNIZED : re3J;
    }

    public int getDisconnectReasonValue() {
        return this.disconnectReason_;
    }

    public String getIdentity() {
        return this.identity_;
    }

    public AbstractC2383g getIdentityBytes() {
        return AbstractC2383g.N(this.identity_);
    }

    public boolean getIsPublisher() {
        return this.isPublisher_;
    }

    public long getJoinedAt() {
        return this.joinedAt_;
    }

    public long getJoinedAtMs() {
        return this.joinedAtMs_;
    }

    public d getKind() {
        d dVarJ = d.j(this.kind_);
        return dVarJ == null ? d.UNRECOGNIZED : dVarJ;
    }

    public e getKindDetails(int i) {
        e eVarJ = e.j(this.kindDetails_.getInt(i));
        return eVarJ == null ? e.UNRECOGNIZED : eVarJ;
    }

    public int getKindDetailsCount() {
        return this.kindDetails_.size();
    }

    public List<e> getKindDetailsList() {
        return new B.h(this.kindDetails_, kindDetails_converter_);
    }

    public int getKindDetailsValue(int i) {
        return this.kindDetails_.getInt(i);
    }

    public List<Integer> getKindDetailsValueList() {
        return this.kindDetails_;
    }

    public int getKindValue() {
        return this.kind_;
    }

    public String getMetadata() {
        return this.metadata_;
    }

    public AbstractC2383g getMetadataBytes() {
        return AbstractC2383g.N(this.metadata_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public LivekitModels$ParticipantPermission getPermission() {
        LivekitModels$ParticipantPermission livekitModels$ParticipantPermission = this.permission_;
        return livekitModels$ParticipantPermission == null ? LivekitModels$ParticipantPermission.getDefaultInstance() : livekitModels$ParticipantPermission;
    }

    public String getRegion() {
        return this.region_;
    }

    public AbstractC2383g getRegionBytes() {
        return AbstractC2383g.N(this.region_);
    }

    public String getSid() {
        return this.sid_;
    }

    public AbstractC2383g getSidBytes() {
        return AbstractC2383g.N(this.sid_);
    }

    public f getState() {
        f fVarJ = f.j(this.state_);
        return fVarJ == null ? f.UNRECOGNIZED : fVarJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public LivekitModels$TrackInfo getTracks(int i) {
        return (LivekitModels$TrackInfo) this.tracks_.get(i);
    }

    public int getTracksCount() {
        return this.tracks_.size();
    }

    public List<LivekitModels$TrackInfo> getTracksList() {
        return this.tracks_;
    }

    public q getTracksOrBuilder(int i) {
        return (q) this.tracks_.get(i);
    }

    public List<? extends q> getTracksOrBuilderList() {
        return this.tracks_;
    }

    public int getVersion() {
        return this.version_;
    }

    public boolean hasPermission() {
        return this.permission_ != null;
    }

    public static c newBuilder(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        return (c) DEFAULT_INSTANCE.createBuilder(livekitModels$ParticipantInfo);
    }

    public static LivekitModels$ParticipantInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ParticipantInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$ParticipantInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTracks(int i, LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        ensureTracksIsMutable();
        this.tracks_.add(i, livekitModels$TrackInfo);
    }

    public static LivekitModels$ParticipantInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$ParticipantInfo parseFrom(byte[] bArr) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$ParticipantInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$ParticipantInfo parseFrom(InputStream inputStream) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ParticipantInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ParticipantInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$ParticipantInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$ParticipantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
