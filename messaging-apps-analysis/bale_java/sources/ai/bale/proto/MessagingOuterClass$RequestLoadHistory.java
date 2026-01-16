package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.EnumC6845Pf4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestLoadHistory extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 2;
    private static final MessagingOuterClass$RequestLoadHistory DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int LOAD_MODE_FIELD_NUMBER = 4;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private static final B.h.a optimizations_converter_ = new a();
    private int bitField0_;
    private long date_;
    private int limit_;
    private int loadMode_;
    private int optimizationsMemoizedSerializedSize;
    private B.g optimizations_ = GeneratedMessageLite.emptyIntList();
    private PeersStruct$OutPeer peer_;

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16902m35 a(Integer num) {
            EnumC16902m35 enumC16902m35J = EnumC16902m35.j(num.intValue());
            return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(MessagingOuterClass$RequestLoadHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestLoadHistory messagingOuterClass$RequestLoadHistory = new MessagingOuterClass$RequestLoadHistory();
        DEFAULT_INSTANCE = messagingOuterClass$RequestLoadHistory;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestLoadHistory.class, messagingOuterClass$RequestLoadHistory);
    }

    private MessagingOuterClass$RequestLoadHistory() {
    }

    private void addAllOptimizations(Iterable<? extends EnumC16902m35> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<? extends EnumC16902m35> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().getNumber());
        }
    }

    private void addAllOptimizationsValue(Iterable<Integer> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().intValue());
        }
    }

    private void addOptimizations(EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(enumC16902m35.getNumber());
    }

    private void addOptimizationsValue(int i) {
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(i);
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearLoadMode() {
        this.loadMode_ = 0;
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MessagingOuterClass$RequestLoadHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestLoadHistory parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setLimit(int i) {
        this.limit_ = i;
    }

    private void setLoadMode(EnumC6845Pf4 enumC6845Pf4) {
        this.loadMode_ = enumC6845Pf4.getNumber();
    }

    private void setLoadModeValue(int i) {
        this.loadMode_ = i;
    }

    private void setOptimizations(int i, EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, enumC16902m35.getNumber());
    }

    private void setOptimizationsValue(int i, int i2) {
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, i2);
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestLoadHistory();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0002\u0004\f\u0005\u0004\u0006,", new Object[]{"bitField0_", "peer_", "date_", "loadMode_", "limit_", "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestLoadHistory.class) {
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

    public int getLimit() {
        return this.limit_;
    }

    public EnumC6845Pf4 getLoadMode() {
        EnumC6845Pf4 enumC6845Pf4J = EnumC6845Pf4.j(this.loadMode_);
        return enumC6845Pf4J == null ? EnumC6845Pf4.UNRECOGNIZED : enumC6845Pf4J;
    }

    public int getLoadModeValue() {
        return this.loadMode_;
    }

    public EnumC16902m35 getOptimizations(int i) {
        EnumC16902m35 enumC16902m35J = EnumC16902m35.j(this.optimizations_.getInt(i));
        return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
    }

    public int getOptimizationsCount() {
        return this.optimizations_.size();
    }

    public List<EnumC16902m35> getOptimizationsList() {
        return new B.h(this.optimizations_, optimizations_converter_);
    }

    public int getOptimizationsValue(int i) {
        return this.optimizations_.getInt(i);
    }

    public List<Integer> getOptimizationsValueList() {
        return this.optimizations_;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static b newBuilder(MessagingOuterClass$RequestLoadHistory messagingOuterClass$RequestLoadHistory) {
        return (b) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestLoadHistory);
    }

    public static MessagingOuterClass$RequestLoadHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestLoadHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
