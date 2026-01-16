package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PeersStruct$UserOutPeer extends GeneratedMessageLite implements InterfaceC18084o35 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    private static final PeersStruct$UserOutPeer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private long accessHash_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC18084o35 {
        public a A(long j) {
            q();
            ((PeersStruct$UserOutPeer) this.b).setAccessHash(j);
            return this;
        }

        public a B(int i) {
            q();
            ((PeersStruct$UserOutPeer) this.b).setUid(i);
            return this;
        }

        private a() {
            super(PeersStruct$UserOutPeer.DEFAULT_INSTANCE);
        }
    }

    static {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = new PeersStruct$UserOutPeer();
        DEFAULT_INSTANCE = peersStruct$UserOutPeer;
        GeneratedMessageLite.registerDefaultInstance(PeersStruct$UserOutPeer.class, peersStruct$UserOutPeer);
    }

    private PeersStruct$UserOutPeer() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static PeersStruct$UserOutPeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PeersStruct$UserOutPeer parseDelimitedFrom(InputStream inputStream) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PeersStruct$UserOutPeer parseFrom(ByteBuffer byteBuffer) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1845c1.a[gVar.ordinal()]) {
            case 1:
                return new PeersStruct$UserOutPeer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"uid_", "accessHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PeersStruct$UserOutPeer.class) {
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

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        return (a) DEFAULT_INSTANCE.createBuilder(peersStruct$UserOutPeer);
    }

    public static PeersStruct$UserOutPeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PeersStruct$UserOutPeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PeersStruct$UserOutPeer parseFrom(AbstractC2383g abstractC2383g) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PeersStruct$UserOutPeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PeersStruct$UserOutPeer parseFrom(byte[] bArr) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PeersStruct$UserOutPeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PeersStruct$UserOutPeer parseFrom(InputStream inputStream) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PeersStruct$UserOutPeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PeersStruct$UserOutPeer parseFrom(AbstractC2384h abstractC2384h) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PeersStruct$UserOutPeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PeersStruct$UserOutPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
