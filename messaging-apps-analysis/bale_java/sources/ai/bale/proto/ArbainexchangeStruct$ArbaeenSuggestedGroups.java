package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.LI;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ArbainexchangeStruct$ArbaeenSuggestedGroups extends GeneratedMessageLite implements LI {
    public static final int CHANNEL_FIELD_NUMBER = 1;
    private static final ArbainexchangeStruct$ArbaeenSuggestedGroups DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$GroupOutPeer channel_;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements LI {
        private a() {
            super(ArbainexchangeStruct$ArbaeenSuggestedGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        ArbainexchangeStruct$ArbaeenSuggestedGroups arbainexchangeStruct$ArbaeenSuggestedGroups = new ArbainexchangeStruct$ArbaeenSuggestedGroups();
        DEFAULT_INSTANCE = arbainexchangeStruct$ArbaeenSuggestedGroups;
        GeneratedMessageLite.registerDefaultInstance(ArbainexchangeStruct$ArbaeenSuggestedGroups.class, arbainexchangeStruct$ArbaeenSuggestedGroups);
    }

    private ArbainexchangeStruct$ArbaeenSuggestedGroups() {
    }

    private void clearChannel() {
        this.channel_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeChannel(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.channel_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.channel_ = peersStruct$GroupOutPeer;
        } else {
            this.channel_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.channel_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseDelimitedFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(ByteBuffer byteBuffer) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannel(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.channel_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1864j.a[gVar.ordinal()]) {
            case 1:
                return new ArbainexchangeStruct$ArbaeenSuggestedGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ", new Object[]{"bitField0_", "channel_", "url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ArbainexchangeStruct$ArbaeenSuggestedGroups.class) {
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

    public PeersStruct$GroupOutPeer getChannel() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.channel_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasChannel() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ArbainexchangeStruct$ArbaeenSuggestedGroups arbainexchangeStruct$ArbaeenSuggestedGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchangeStruct$ArbaeenSuggestedGroups);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(byte[] bArr) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ArbainexchangeStruct$ArbaeenSuggestedGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
