package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.XU6;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestGetUserStoryConfig extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestGetUserStoryConfig DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 2;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private static final B.h.a key_converter_ = new a();
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private int keyMemoizedSerializedSize;
    private B.g key_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public XU6 a(Integer num) {
            XU6 xu6J = XU6.j(num.intValue());
            return xu6J == null ? XU6.UNRECOGNIZED : xu6J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        public b A(Iterable iterable) {
            q();
            ((StoryOuterClass$RequestGetUserStoryConfig) this.b).addAllKey(iterable);
            return this;
        }

        public b B(XU6 xu6) {
            q();
            ((StoryOuterClass$RequestGetUserStoryConfig) this.b).addKey(xu6);
            return this;
        }

        private b() {
            super(StoryOuterClass$RequestGetUserStoryConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestGetUserStoryConfig storyOuterClass$RequestGetUserStoryConfig = new StoryOuterClass$RequestGetUserStoryConfig();
        DEFAULT_INSTANCE = storyOuterClass$RequestGetUserStoryConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestGetUserStoryConfig.class, storyOuterClass$RequestGetUserStoryConfig);
    }

    private StoryOuterClass$RequestGetUserStoryConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKey(Iterable<? extends XU6> iterable) {
        ensureKeyIsMutable();
        Iterator<? extends XU6> it = iterable.iterator();
        while (it.hasNext()) {
            this.key_.b1(it.next().getNumber());
        }
    }

    private void addAllKeyValue(Iterable<Integer> iterable) {
        ensureKeyIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.key_.b1(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKey(XU6 xu6) {
        xu6.getClass();
        ensureKeyIsMutable();
        this.key_.b1(xu6.getNumber());
    }

    private void addKeyValue(int i) {
        ensureKeyIsMutable();
        this.key_.b1(i);
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearKey() {
        this.key_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureKeyIsMutable() {
        B.g gVar = this.key_;
        if (gVar.u()) {
            return;
        }
        this.key_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setKey(int i, XU6 xu6) {
        xu6.getClass();
        ensureKeyIsMutable();
        this.key_.U(i, xu6.getNumber());
    }

    private void setKeyValue(int i, int i2) {
        ensureKeyIsMutable();
        this.key_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestGetUserStoryConfig();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001,\u0002ဉ\u0000", new Object[]{"bitField0_", "key_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestGetUserStoryConfig.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public XU6 getKey(int i) {
        XU6 xu6J = XU6.j(this.key_.getInt(i));
        return xu6J == null ? XU6.UNRECOGNIZED : xu6J;
    }

    public int getKeyCount() {
        return this.key_.size();
    }

    public List<XU6> getKeyList() {
        return new B.h(this.key_, key_converter_);
    }

    public int getKeyValue(int i) {
        return this.key_.getInt(i);
    }

    public List<Integer> getKeyValueList() {
        return this.key_;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static b newBuilder(StoryOuterClass$RequestGetUserStoryConfig storyOuterClass$RequestGetUserStoryConfig) {
        return (b) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestGetUserStoryConfig);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestGetUserStoryConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
