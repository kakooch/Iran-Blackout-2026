package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.VitrineOuterClass$Action;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22040uZ7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineOuterClass$PeerItem extends GeneratedMessageLite implements InterfaceC22040uZ7 {
    public static final int ACTION_FIELD_NUMBER = 2;
    private static final VitrineOuterClass$PeerItem DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private VitrineOuterClass$Action action_;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22040uZ7 {
        private a() {
            super(VitrineOuterClass$PeerItem.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$PeerItem vitrineOuterClass$PeerItem = new VitrineOuterClass$PeerItem();
        DEFAULT_INSTANCE = vitrineOuterClass$PeerItem;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$PeerItem.class, vitrineOuterClass$PeerItem);
    }

    private VitrineOuterClass$PeerItem() {
    }

    private void clearAction() {
        this.action_ = null;
        this.bitField0_ &= -3;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    public static VitrineOuterClass$PeerItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAction(VitrineOuterClass$Action vitrineOuterClass$Action) {
        vitrineOuterClass$Action.getClass();
        VitrineOuterClass$Action vitrineOuterClass$Action2 = this.action_;
        if (vitrineOuterClass$Action2 == null || vitrineOuterClass$Action2 == VitrineOuterClass$Action.getDefaultInstance()) {
            this.action_ = vitrineOuterClass$Action;
        } else {
            this.action_ = (VitrineOuterClass$Action) ((VitrineOuterClass$Action.a) VitrineOuterClass$Action.newBuilder(this.action_).v(vitrineOuterClass$Action)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$PeerItem parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$PeerItem parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(VitrineOuterClass$Action vitrineOuterClass$Action) {
        vitrineOuterClass$Action.getClass();
        this.action_ = vitrineOuterClass$Action;
        this.bitField0_ |= 2;
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$PeerItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "exPeer_", "action_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$PeerItem.class) {
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

    public VitrineOuterClass$Action getAction() {
        VitrineOuterClass$Action vitrineOuterClass$Action = this.action_;
        return vitrineOuterClass$Action == null ? VitrineOuterClass$Action.getDefaultInstance() : vitrineOuterClass$Action;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasAction() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineOuterClass$PeerItem vitrineOuterClass$PeerItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$PeerItem);
    }

    public static VitrineOuterClass$PeerItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$PeerItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$PeerItem parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$PeerItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$PeerItem parseFrom(byte[] bArr) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$PeerItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$PeerItem parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$PeerItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$PeerItem parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$PeerItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$PeerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
