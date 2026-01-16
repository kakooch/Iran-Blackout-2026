package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16311l35;
import ir.nasim.InterfaceC13929h35;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PeersStruct$OutPeer extends GeneratedMessageLite implements InterfaceC13929h35 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 3;
    private static final PeersStruct$OutPeer DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private long accessHash_;
    private int id_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13929h35 {
        public a A(long j) {
            q();
            ((PeersStruct$OutPeer) this.b).setAccessHash(j);
            return this;
        }

        public a B(int i) {
            q();
            ((PeersStruct$OutPeer) this.b).setId(i);
            return this;
        }

        public a C(EnumC16311l35 enumC16311l35) {
            q();
            ((PeersStruct$OutPeer) this.b).setType(enumC16311l35);
            return this;
        }

        public a D(int i) {
            q();
            ((PeersStruct$OutPeer) this.b).setTypeValue(i);
            return this;
        }

        private a() {
            super(PeersStruct$OutPeer.DEFAULT_INSTANCE);
        }
    }

    static {
        PeersStruct$OutPeer peersStruct$OutPeer = new PeersStruct$OutPeer();
        DEFAULT_INSTANCE = peersStruct$OutPeer;
        GeneratedMessageLite.registerDefaultInstance(PeersStruct$OutPeer.class, peersStruct$OutPeer);
    }

    private PeersStruct$OutPeer() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static PeersStruct$OutPeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PeersStruct$OutPeer parseDelimitedFrom(InputStream inputStream) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PeersStruct$OutPeer parseFrom(ByteBuffer byteBuffer) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.id_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(EnumC16311l35 enumC16311l35) {
        this.type_ = enumC16311l35.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1845c1.a[gVar.ordinal()]) {
            case 1:
                return new PeersStruct$OutPeer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003\u0002", new Object[]{"type_", "id_", "accessHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PeersStruct$OutPeer.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
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

    public static a newBuilder(PeersStruct$OutPeer peersStruct$OutPeer) {
        return (a) DEFAULT_INSTANCE.createBuilder(peersStruct$OutPeer);
    }

    public static PeersStruct$OutPeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PeersStruct$OutPeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PeersStruct$OutPeer parseFrom(AbstractC2383g abstractC2383g) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PeersStruct$OutPeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PeersStruct$OutPeer parseFrom(byte[] bArr) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PeersStruct$OutPeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PeersStruct$OutPeer parseFrom(InputStream inputStream) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PeersStruct$OutPeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PeersStruct$OutPeer parseFrom(AbstractC2384h abstractC2384h) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PeersStruct$OutPeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PeersStruct$OutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
