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
import livekit.LivekitModels$ParticipantPermission;

/* loaded from: classes8.dex */
public final class LivekitRoom$UpdateParticipantRequest extends GeneratedMessageLite implements U64 {
    public static final int ATTRIBUTES_FIELD_NUMBER = 6;
    private static final LivekitRoom$UpdateParticipantRequest DEFAULT_INSTANCE;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    public static final int METADATA_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PERMISSION_FIELD_NUMBER = 4;
    public static final int ROOM_FIELD_NUMBER = 1;
    private LivekitModels$ParticipantPermission permission_;
    private J attributes_ = J.e();
    private String room_ = "";
    private String identity_ = "";
    private String metadata_ = "";
    private String name_ = "";

    private static final class a {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(r rVar) {
            this();
        }

        private b() {
            super(LivekitRoom$UpdateParticipantRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$UpdateParticipantRequest livekitRoom$UpdateParticipantRequest = new LivekitRoom$UpdateParticipantRequest();
        DEFAULT_INSTANCE = livekitRoom$UpdateParticipantRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$UpdateParticipantRequest.class, livekitRoom$UpdateParticipantRequest);
    }

    private LivekitRoom$UpdateParticipantRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
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
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    public static LivekitRoom$UpdateParticipantRequest getDefaultInstance() {
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

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$UpdateParticipantRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setRoom(String str) {
        str.getClass();
        this.room_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.room_ = abstractC2383g.f0();
    }

    public boolean containsAttributes(String str) {
        str.getClass();
        return internalGetAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$UpdateParticipantRequest();
            case 2:
                return new b(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\t\u0005Ȉ\u00062", new Object[]{"room_", "identity_", "metadata_", "permission_", "name_", "attributes_", a.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$UpdateParticipantRequest.class) {
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

    public String getIdentity() {
        return this.identity_;
    }

    public AbstractC2383g getIdentityBytes() {
        return AbstractC2383g.N(this.identity_);
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

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public boolean hasPermission() {
        return this.permission_ != null;
    }

    public static b newBuilder(LivekitRoom$UpdateParticipantRequest livekitRoom$UpdateParticipantRequest) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitRoom$UpdateParticipantRequest);
    }

    public static LivekitRoom$UpdateParticipantRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(byte[] bArr) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(InputStream inputStream) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$UpdateParticipantRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$UpdateParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
