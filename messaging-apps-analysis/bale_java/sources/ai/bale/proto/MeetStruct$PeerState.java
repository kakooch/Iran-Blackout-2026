package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.EnumC11447d14;
import ir.nasim.InterfaceC12090e14;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MeetStruct$PeerState extends GeneratedMessageLite implements InterfaceC12090e14 {
    public static final int DATE_FIELD_NUMBER = 2;
    private static final MeetStruct$PeerState DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PEER_STATE_ENUM_FIELD_NUMBER = 3;
    private long date_;
    private com.google.protobuf.J extra_ = com.google.protobuf.J.e();
    private int id_;
    private int peerStateEnum_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC12090e14 {
        private a() {
            super(MeetStruct$PeerState.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        MeetStruct$PeerState meetStruct$PeerState = new MeetStruct$PeerState();
        DEFAULT_INSTANCE = meetStruct$PeerState;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$PeerState.class, meetStruct$PeerState);
    }

    private MeetStruct$PeerState() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearPeerStateEnum() {
        this.peerStateEnum_ = 0;
    }

    public static MeetStruct$PeerState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtraMap() {
        return internalGetMutableExtra();
    }

    private com.google.protobuf.J internalGetExtra() {
        return this.extra_;
    }

    private com.google.protobuf.J internalGetMutableExtra() {
        if (!this.extra_.n()) {
            this.extra_ = this.extra_.s();
        }
        return this.extra_;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$PeerState parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$PeerState parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setPeerStateEnum(EnumC11447d14 enumC11447d14) {
        this.peerStateEnum_ = enumC11447d14.getNumber();
    }

    private void setPeerStateEnumValue(int i) {
        this.peerStateEnum_ = i;
    }

    public boolean containsExtra(String str) {
        str.getClass();
        return internalGetExtra().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$PeerState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001\u0004\u0002\u0002\u0003\f\u00042", new Object[]{"id_", "date_", "peerStateEnum_", "extra_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$PeerState.class) {
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

    public long getDate() {
        return this.date_;
    }

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getExtra() {
        return getExtraMap();
    }

    public int getExtraCount() {
        return internalGetExtra().size();
    }

    public Map<String, CollectionsStruct$RawValue> getExtraMap() {
        return Collections.unmodifiableMap(internalGetExtra());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtraOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        return jInternalGetExtra.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetExtra.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtraOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        if (jInternalGetExtra.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetExtra.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int getId() {
        return this.id_;
    }

    public EnumC11447d14 getPeerStateEnum() {
        EnumC11447d14 enumC11447d14J = EnumC11447d14.j(this.peerStateEnum_);
        return enumC11447d14J == null ? EnumC11447d14.UNRECOGNIZED : enumC11447d14J;
    }

    public int getPeerStateEnumValue() {
        return this.peerStateEnum_;
    }

    public static a newBuilder(MeetStruct$PeerState meetStruct$PeerState) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$PeerState);
    }

    public static MeetStruct$PeerState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$PeerState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$PeerState parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$PeerState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$PeerState parseFrom(byte[] bArr) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$PeerState parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$PeerState parseFrom(InputStream inputStream) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$PeerState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$PeerState parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$PeerState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$PeerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
