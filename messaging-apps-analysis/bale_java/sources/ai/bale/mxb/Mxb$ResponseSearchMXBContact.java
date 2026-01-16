package ai.bale.mxb;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13929h35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Mxb$ResponseSearchMXBContact extends GeneratedMessageLite implements U64 {
    private static final Mxb$ResponseSearchMXBContact DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_OUT_PEERS_FIELD_NUMBER = 1;
    private B.j userOutPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Mxb$ResponseSearchMXBContact.DEFAULT_INSTANCE);
        }
    }

    static {
        Mxb$ResponseSearchMXBContact mxb$ResponseSearchMXBContact = new Mxb$ResponseSearchMXBContact();
        DEFAULT_INSTANCE = mxb$ResponseSearchMXBContact;
        GeneratedMessageLite.registerDefaultInstance(Mxb$ResponseSearchMXBContact.class, mxb$ResponseSearchMXBContact);
    }

    private Mxb$ResponseSearchMXBContact() {
    }

    private void addAllUserOutPeers(Iterable<? extends PeersStruct$OutPeer> iterable) {
        ensureUserOutPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userOutPeers_);
    }

    private void addUserOutPeers(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.add(peersStruct$OutPeer);
    }

    private void clearUserOutPeers() {
        this.userOutPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUserOutPeersIsMutable() {
        B.j jVar = this.userOutPeers_;
        if (jVar.u()) {
            return;
        }
        this.userOutPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Mxb$ResponseSearchMXBContact getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Mxb$ResponseSearchMXBContact parseDelimitedFrom(InputStream inputStream) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(ByteBuffer byteBuffer) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserOutPeers(int i) {
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.remove(i);
    }

    private void setUserOutPeers(int i, PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.set(i, peersStruct$OutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (ai.bale.mxb.a.a[gVar.ordinal()]) {
            case 1:
                return new Mxb$ResponseSearchMXBContact();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"userOutPeers_", PeersStruct$OutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Mxb$ResponseSearchMXBContact.class) {
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

    public PeersStruct$OutPeer getUserOutPeers(int i) {
        return (PeersStruct$OutPeer) this.userOutPeers_.get(i);
    }

    public int getUserOutPeersCount() {
        return this.userOutPeers_.size();
    }

    public List<PeersStruct$OutPeer> getUserOutPeersList() {
        return this.userOutPeers_;
    }

    public InterfaceC13929h35 getUserOutPeersOrBuilder(int i) {
        return (InterfaceC13929h35) this.userOutPeers_.get(i);
    }

    public List<? extends InterfaceC13929h35> getUserOutPeersOrBuilderList() {
        return this.userOutPeers_;
    }

    public static a newBuilder(Mxb$ResponseSearchMXBContact mxb$ResponseSearchMXBContact) {
        return (a) DEFAULT_INSTANCE.createBuilder(mxb$ResponseSearchMXBContact);
    }

    public static Mxb$ResponseSearchMXBContact parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(AbstractC2383g abstractC2383g) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUserOutPeers(int i, PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.add(i, peersStruct$OutPeer);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(byte[] bArr) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(byte[] bArr, C2394s c2394s) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(InputStream inputStream) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(AbstractC2384h abstractC2384h) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Mxb$ResponseSearchMXBContact parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Mxb$ResponseSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
