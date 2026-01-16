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
public final class LivekitRtc$UpdateParticipantMetadata extends GeneratedMessageLite implements U64 {
    public static final int ATTRIBUTES_FIELD_NUMBER = 3;
    private static final LivekitRtc$UpdateParticipantMetadata DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 4;
    private J attributes_ = J.e();
    private String metadata_ = "";
    private String name_ = "";
    private int requestId_;

    private static final class a {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(s sVar) {
            this();
        }

        private b() {
            super(LivekitRtc$UpdateParticipantMetadata.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$UpdateParticipantMetadata livekitRtc$UpdateParticipantMetadata = new LivekitRtc$UpdateParticipantMetadata();
        DEFAULT_INSTANCE = livekitRtc$UpdateParticipantMetadata;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$UpdateParticipantMetadata.class, livekitRtc$UpdateParticipantMetadata);
    }

    private LivekitRtc$UpdateParticipantMetadata() {
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
    public void clearRequestId() {
        this.requestId_ = 0;
    }

    public static LivekitRtc$UpdateParticipantMetadata getDefaultInstance() {
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

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$UpdateParticipantMetadata parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setRequestId(int i) {
        this.requestId_ = i;
    }

    public boolean containsAttributes(String str) {
        str.getClass();
        return internalGetAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$UpdateParticipantMetadata();
            case 2:
                return new b(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032\u0004\u000b", new Object[]{"metadata_", "name_", "attributes_", a.a, "requestId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$UpdateParticipantMetadata.class) {
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

    public int getRequestId() {
        return this.requestId_;
    }

    public static b newBuilder(LivekitRtc$UpdateParticipantMetadata livekitRtc$UpdateParticipantMetadata) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitRtc$UpdateParticipantMetadata);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(byte[] bArr) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(InputStream inputStream) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$UpdateParticipantMetadata parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$UpdateParticipantMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
