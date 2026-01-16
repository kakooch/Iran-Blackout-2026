package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16311l35;
import ir.nasim.InterfaceC15720k35;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PeersStruct$Peer extends GeneratedMessageLite implements InterfaceC15720k35 {
    private static final PeersStruct$Peer DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int id_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15720k35 {
        public a A(int i) {
            q();
            ((PeersStruct$Peer) this.b).setId(i);
            return this;
        }

        public a B(EnumC16311l35 enumC16311l35) {
            q();
            ((PeersStruct$Peer) this.b).setType(enumC16311l35);
            return this;
        }

        private a() {
            super(PeersStruct$Peer.DEFAULT_INSTANCE);
        }
    }

    static {
        PeersStruct$Peer peersStruct$Peer = new PeersStruct$Peer();
        DEFAULT_INSTANCE = peersStruct$Peer;
        GeneratedMessageLite.registerDefaultInstance(PeersStruct$Peer.class, peersStruct$Peer);
    }

    private PeersStruct$Peer() {
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static PeersStruct$Peer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PeersStruct$Peer parseDelimitedFrom(InputStream inputStream) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PeersStruct$Peer parseFrom(ByteBuffer byteBuffer) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.id_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(EnumC16311l35 enumC16311l35) {
        this.type_ = enumC16311l35.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1845c1.a[gVar.ordinal()]) {
            case 1:
                return new PeersStruct$Peer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u0004", new Object[]{"type_", "id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PeersStruct$Peer.class) {
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

    public EnumC16311l35 getType() {
        EnumC16311l35 enumC16311l35J = EnumC16311l35.j(this.type_);
        return enumC16311l35J == null ? EnumC16311l35.UNRECOGNIZED : enumC16311l35J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(PeersStruct$Peer peersStruct$Peer) {
        return (a) DEFAULT_INSTANCE.createBuilder(peersStruct$Peer);
    }

    public static PeersStruct$Peer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PeersStruct$Peer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PeersStruct$Peer parseFrom(AbstractC2383g abstractC2383g) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PeersStruct$Peer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PeersStruct$Peer parseFrom(byte[] bArr) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PeersStruct$Peer parseFrom(byte[] bArr, C2394s c2394s) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PeersStruct$Peer parseFrom(InputStream inputStream) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PeersStruct$Peer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PeersStruct$Peer parseFrom(AbstractC2384h abstractC2384h) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PeersStruct$Peer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PeersStruct$Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
