package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PeersStruct$UserOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PresenceStruct$UserOffline extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final PresenceStruct$UserOffline DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int USER_LAST_SEEN_UNKNOWN_FIELD_NUMBER = 2;
    private int bitField0_;
    private CollectionsStruct$Int64Value date_;
    private PeersStruct$UserOutPeer peer_;
    private BoolValue userLastSeenUnknown_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceStruct$UserOffline.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceStruct$UserOffline presenceStruct$UserOffline = new PresenceStruct$UserOffline();
        DEFAULT_INSTANCE = presenceStruct$UserOffline;
        GeneratedMessageLite.registerDefaultInstance(PresenceStruct$UserOffline.class, presenceStruct$UserOffline);
    }

    private PresenceStruct$UserOffline() {
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUserLastSeenUnknown() {
        this.userLastSeenUnknown_ = null;
        this.bitField0_ &= -3;
    }

    public static PresenceStruct$UserOffline getDefaultInstance() {
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
        this.bitField0_ |= 4;
    }

    private void mergePeer(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.peer_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$UserOutPeer;
        } else {
            this.peer_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.peer_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeUserLastSeenUnknown(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.userLastSeenUnknown_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.userLastSeenUnknown_ = boolValue;
        } else {
            this.userLastSeenUnknown_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.userLastSeenUnknown_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceStruct$UserOffline parseDelimitedFrom(InputStream inputStream) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceStruct$UserOffline parseFrom(ByteBuffer byteBuffer) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.date_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setPeer(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.peer_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 1;
    }

    private void setUserLastSeenUnknown(BoolValue boolValue) {
        boolValue.getClass();
        this.userLastSeenUnknown_ = boolValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1869k1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceStruct$UserOffline();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "peer_", "userLastSeenUnknown_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceStruct$UserOffline.class) {
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

    public CollectionsStruct$Int64Value getDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.date_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public PeersStruct$UserOutPeer getPeer() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.peer_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public BoolValue getUserLastSeenUnknown() {
        BoolValue boolValue = this.userLastSeenUnknown_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUserLastSeenUnknown() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(PresenceStruct$UserOffline presenceStruct$UserOffline) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceStruct$UserOffline);
    }

    public static PresenceStruct$UserOffline parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceStruct$UserOffline parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceStruct$UserOffline parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceStruct$UserOffline parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceStruct$UserOffline parseFrom(byte[] bArr) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceStruct$UserOffline parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceStruct$UserOffline parseFrom(InputStream inputStream) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceStruct$UserOffline parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceStruct$UserOffline parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceStruct$UserOffline parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceStruct$UserOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
