package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21521th;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetOnboardingPeers extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetOnboardingPeers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 1;
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetOnboardingPeers.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetOnboardingPeers advertisementOuterClass$ResponseGetOnboardingPeers = new AdvertisementOuterClass$ResponseGetOnboardingPeers();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetOnboardingPeers;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetOnboardingPeers.class, advertisementOuterClass$ResponseGetOnboardingPeers);
    }

    private AdvertisementOuterClass$ResponseGetOnboardingPeers() {
    }

    private void addAllPeers(Iterable<? extends AdvertisementStruct$OnboardingPeers> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addPeers(AdvertisementStruct$OnboardingPeers advertisementStruct$OnboardingPeers) {
        advertisementStruct$OnboardingPeers.getClass();
        ensurePeersIsMutable();
        this.peers_.add(advertisementStruct$OnboardingPeers);
    }

    private void clearPeers() {
        this.peers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePeersIsMutable() {
        B.j jVar = this.peers_;
        if (jVar.u()) {
            return;
        }
        this.peers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void setPeers(int i, AdvertisementStruct$OnboardingPeers advertisementStruct$OnboardingPeers) {
        advertisementStruct$OnboardingPeers.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, advertisementStruct$OnboardingPeers);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetOnboardingPeers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"peers_", AdvertisementStruct$OnboardingPeers.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetOnboardingPeers.class) {
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

    public AdvertisementStruct$OnboardingPeers getPeers(int i) {
        return (AdvertisementStruct$OnboardingPeers) this.peers_.get(i);
    }

    public int getPeersCount() {
        return this.peers_.size();
    }

    public List<AdvertisementStruct$OnboardingPeers> getPeersList() {
        return this.peers_;
    }

    public InterfaceC21521th getPeersOrBuilder(int i) {
        return (InterfaceC21521th) this.peers_.get(i);
    }

    public List<? extends InterfaceC21521th> getPeersOrBuilderList() {
        return this.peers_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetOnboardingPeers advertisementOuterClass$ResponseGetOnboardingPeers) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetOnboardingPeers);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeers(int i, AdvertisementStruct$OnboardingPeers advertisementStruct$OnboardingPeers) {
        advertisementStruct$OnboardingPeers.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, advertisementStruct$OnboardingPeers);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPeers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPeers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
