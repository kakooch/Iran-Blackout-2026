package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitIngress$ListIngressRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitIngress$ListIngressRequest DEFAULT_INSTANCE;
    public static final int INGRESS_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_NAME_FIELD_NUMBER = 1;
    private String roomName_ = "";
    private String ingressId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$ListIngressRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitIngress$ListIngressRequest livekitIngress$ListIngressRequest = new LivekitIngress$ListIngressRequest();
        DEFAULT_INSTANCE = livekitIngress$ListIngressRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$ListIngressRequest.class, livekitIngress$ListIngressRequest);
    }

    private LivekitIngress$ListIngressRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIngressId() {
        this.ingressId_ = getDefaultInstance().getIngressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    public static LivekitIngress$ListIngressRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$ListIngressRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngressId(String str) {
        str.getClass();
        this.ingressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ingressId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomName(String str) {
        str.getClass();
        this.roomName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$ListIngressRequest();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"roomName_", "ingressId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$ListIngressRequest.class) {
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

    public String getIngressId() {
        return this.ingressId_;
    }

    public AbstractC2383g getIngressIdBytes() {
        return AbstractC2383g.N(this.ingressId_);
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public static a newBuilder(LivekitIngress$ListIngressRequest livekitIngress$ListIngressRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$ListIngressRequest);
    }

    public static LivekitIngress$ListIngressRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(byte[] bArr) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(InputStream inputStream) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$ListIngressRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$ListIngressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
