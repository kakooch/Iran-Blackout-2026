package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6845Pf4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SharedMediaOuterClass$RequestLoadMedia extends GeneratedMessageLite implements U64 {
    public static final int CONTENT_TYPE_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 2;
    private static final SharedMediaOuterClass$RequestLoadMedia DEFAULT_INSTANCE;
    public static final int LOAD_MODE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private int contentType_;
    private CollectionsStruct$Int64Value date_;
    private int loadMode_;
    private PeersStruct$OutExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SharedMediaOuterClass$RequestLoadMedia.DEFAULT_INSTANCE);
        }
    }

    static {
        SharedMediaOuterClass$RequestLoadMedia sharedMediaOuterClass$RequestLoadMedia = new SharedMediaOuterClass$RequestLoadMedia();
        DEFAULT_INSTANCE = sharedMediaOuterClass$RequestLoadMedia;
        GeneratedMessageLite.registerDefaultInstance(SharedMediaOuterClass$RequestLoadMedia.class, sharedMediaOuterClass$RequestLoadMedia);
    }

    private SharedMediaOuterClass$RequestLoadMedia() {
    }

    private void clearContentType() {
        this.contentType_ = 0;
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -3;
    }

    private void clearLoadMode() {
        this.loadMode_ = 0;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static SharedMediaOuterClass$RequestLoadMedia getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.date_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.date_ = collectionsStruct$Int64Value;
        } else {
            this.date_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.date_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.peer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutExPeer;
        } else {
            this.peer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.peer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseDelimitedFrom(InputStream inputStream) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(ByteBuffer byteBuffer) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContentType(int i) {
        this.contentType_ = i;
    }

    private void setDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.date_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setLoadMode(EnumC6845Pf4 enumC6845Pf4) {
        this.loadMode_ = enumC6845Pf4.getNumber();
    }

    private void setLoadModeValue(int i) {
        this.loadMode_ = i;
    }

    private void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (a2.a[gVar.ordinal()]) {
            case 1:
                return new SharedMediaOuterClass$RequestLoadMedia();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0004\u0004\f", new Object[]{"bitField0_", "peer_", "date_", "contentType_", "loadMode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SharedMediaOuterClass$RequestLoadMedia.class) {
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

    public int getContentType() {
        return this.contentType_;
    }

    public CollectionsStruct$Int64Value getDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.date_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public EnumC6845Pf4 getLoadMode() {
        EnumC6845Pf4 enumC6845Pf4J = EnumC6845Pf4.j(this.loadMode_);
        return enumC6845Pf4J == null ? EnumC6845Pf4.UNRECOGNIZED : enumC6845Pf4J;
    }

    public int getLoadModeValue() {
        return this.loadMode_;
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SharedMediaOuterClass$RequestLoadMedia sharedMediaOuterClass$RequestLoadMedia) {
        return (a) DEFAULT_INSTANCE.createBuilder(sharedMediaOuterClass$RequestLoadMedia);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(AbstractC2383g abstractC2383g) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(byte[] bArr) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(byte[] bArr, C2394s c2394s) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(InputStream inputStream) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(AbstractC2384h abstractC2384h) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SharedMediaOuterClass$RequestLoadMedia parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SharedMediaOuterClass$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
