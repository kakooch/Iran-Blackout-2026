package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
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
public final class AdvertisementOuterClass$RequestUpdateClick extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final AdvertisementOuterClass$RequestUpdateClick DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 3;
    private int bitField0_;
    private int count_;
    private String id_ = "";
    private PeersStruct$ExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((AdvertisementOuterClass$RequestUpdateClick) this.b).setCount(i);
            return this;
        }

        public a B(String str) {
            q();
            ((AdvertisementOuterClass$RequestUpdateClick) this.b).setId(str);
            return this;
        }

        public a C(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((AdvertisementOuterClass$RequestUpdateClick) this.b).setPeer(peersStruct$ExPeer);
            return this;
        }

        private a() {
            super(AdvertisementOuterClass$RequestUpdateClick.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestUpdateClick advertisementOuterClass$RequestUpdateClick = new AdvertisementOuterClass$RequestUpdateClick();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestUpdateClick;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestUpdateClick.class, advertisementOuterClass$RequestUpdateClick);
    }

    private AdvertisementOuterClass$RequestUpdateClick() {
    }

    private void clearCount() {
        this.count_ = 0;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestUpdateClick getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$ExPeer;
        } else {
            this.peer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCount(int i) {
        this.count_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestUpdateClick();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003ဉ\u0000", new Object[]{"bitField0_", "id_", "count_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestUpdateClick.class) {
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

    public int getCount() {
        return this.count_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestUpdateClick advertisementOuterClass$RequestUpdateClick) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestUpdateClick);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestUpdateClick parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
