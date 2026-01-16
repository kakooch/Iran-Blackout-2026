package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.StoryStruct$UserStoryConfig;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17153mU6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestSetUserStoryConfig extends GeneratedMessageLite implements U64 {
    public static final int CONFIG_FIELD_NUMBER = 2;
    private static final StoryOuterClass$RequestSetUserStoryConfig DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SET_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private StoryStruct$UserStoryConfig config_;
    private PeersStruct$ExPeer exPeer_;
    private int setType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StoryStruct$UserStoryConfig storyStruct$UserStoryConfig) {
            q();
            ((StoryOuterClass$RequestSetUserStoryConfig) this.b).setConfig(storyStruct$UserStoryConfig);
            return this;
        }

        public a B(EnumC17153mU6 enumC17153mU6) {
            q();
            ((StoryOuterClass$RequestSetUserStoryConfig) this.b).setSetType(enumC17153mU6);
            return this;
        }

        private a() {
            super(StoryOuterClass$RequestSetUserStoryConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestSetUserStoryConfig storyOuterClass$RequestSetUserStoryConfig = new StoryOuterClass$RequestSetUserStoryConfig();
        DEFAULT_INSTANCE = storyOuterClass$RequestSetUserStoryConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestSetUserStoryConfig.class, storyOuterClass$RequestSetUserStoryConfig);
    }

    private StoryOuterClass$RequestSetUserStoryConfig() {
    }

    private void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -2;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSetType() {
        this.setType_ = 0;
    }

    public static StoryOuterClass$RequestSetUserStoryConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConfig(StoryStruct$UserStoryConfig storyStruct$UserStoryConfig) {
        storyStruct$UserStoryConfig.getClass();
        StoryStruct$UserStoryConfig storyStruct$UserStoryConfig2 = this.config_;
        if (storyStruct$UserStoryConfig2 == null || storyStruct$UserStoryConfig2 == StoryStruct$UserStoryConfig.getDefaultInstance()) {
            this.config_ = storyStruct$UserStoryConfig;
        } else {
            this.config_ = (StoryStruct$UserStoryConfig) ((StoryStruct$UserStoryConfig.a) StoryStruct$UserStoryConfig.newBuilder(this.config_).v(storyStruct$UserStoryConfig)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfig(StoryStruct$UserStoryConfig storyStruct$UserStoryConfig) {
        storyStruct$UserStoryConfig.getClass();
        this.config_ = storyStruct$UserStoryConfig;
        this.bitField0_ |= 1;
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSetType(EnumC17153mU6 enumC17153mU6) {
        this.setType_ = enumC17153mU6.getNumber();
    }

    private void setSetTypeValue(int i) {
        this.setType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestSetUserStoryConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "setType_", "config_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestSetUserStoryConfig.class) {
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

    public StoryStruct$UserStoryConfig getConfig() {
        StoryStruct$UserStoryConfig storyStruct$UserStoryConfig = this.config_;
        return storyStruct$UserStoryConfig == null ? StoryStruct$UserStoryConfig.getDefaultInstance() : storyStruct$UserStoryConfig;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public EnumC17153mU6 getSetType() {
        EnumC17153mU6 enumC17153mU6J = EnumC17153mU6.j(this.setType_);
        return enumC17153mU6J == null ? EnumC17153mU6.UNRECOGNIZED : enumC17153mU6J;
    }

    public int getSetTypeValue() {
        return this.setType_;
    }

    public boolean hasConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(StoryOuterClass$RequestSetUserStoryConfig storyOuterClass$RequestSetUserStoryConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestSetUserStoryConfig);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestSetUserStoryConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
