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
public final class LivekitRtc$SessionDescription extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$SessionDescription DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SDP_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int id_;
    private String type_ = "";
    private String sdp_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitRtc$SessionDescription) this.b).setSdp(str);
            return this;
        }

        public a B(String str) {
            q();
            ((LivekitRtc$SessionDescription) this.b).setType(str);
            return this;
        }

        private a() {
            super(LivekitRtc$SessionDescription.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SessionDescription livekitRtc$SessionDescription = new LivekitRtc$SessionDescription();
        DEFAULT_INSTANCE = livekitRtc$SessionDescription;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SessionDescription.class, livekitRtc$SessionDescription);
    }

    private LivekitRtc$SessionDescription() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSdp() {
        this.sdp_ = getDefaultInstance().getSdp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    public static LivekitRtc$SessionDescription getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SessionDescription parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SessionDescription parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.id_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdp(String str) {
        str.getClass();
        this.sdp_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdpBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sdp_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.type_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SessionDescription();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b", new Object[]{"type_", "sdp_", "id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SessionDescription.class) {
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

    public int getId() {
        return this.id_;
    }

    public String getSdp() {
        return this.sdp_;
    }

    public AbstractC2383g getSdpBytes() {
        return AbstractC2383g.N(this.sdp_);
    }

    public String getType() {
        return this.type_;
    }

    public AbstractC2383g getTypeBytes() {
        return AbstractC2383g.N(this.type_);
    }

    public static a newBuilder(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SessionDescription);
    }

    public static LivekitRtc$SessionDescription parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SessionDescription parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SessionDescription parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$SessionDescription parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SessionDescription parseFrom(byte[] bArr) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SessionDescription parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SessionDescription parseFrom(InputStream inputStream) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SessionDescription parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SessionDescription parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SessionDescription parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SessionDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
