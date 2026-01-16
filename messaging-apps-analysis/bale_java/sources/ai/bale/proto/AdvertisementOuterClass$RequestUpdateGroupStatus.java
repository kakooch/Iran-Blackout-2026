package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestUpdateGroupStatus extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestUpdateGroupStatus DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$OutPeer groupId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestUpdateGroupStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestUpdateGroupStatus advertisementOuterClass$RequestUpdateGroupStatus = new AdvertisementOuterClass$RequestUpdateGroupStatus();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestUpdateGroupStatus;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestUpdateGroupStatus.class, advertisementOuterClass$RequestUpdateGroupStatus);
    }

    private AdvertisementOuterClass$RequestUpdateGroupStatus() {
    }

    private void clearGroupId() {
        this.groupId_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupId(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.groupId_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.groupId_ = peersStruct$OutPeer;
        } else {
            this.groupId_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.groupId_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.groupId_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestUpdateGroupStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "groupId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestUpdateGroupStatus.class) {
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

    public PeersStruct$OutPeer getGroupId() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.groupId_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public boolean hasGroupId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestUpdateGroupStatus advertisementOuterClass$RequestUpdateGroupStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestUpdateGroupStatus);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestUpdateGroupStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateGroupStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
