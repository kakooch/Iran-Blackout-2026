package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10201bF3;
import ir.nasim.EnumC9607aF3;
import ir.nasim.InterfaceC12224eF3;
import ir.nasim.InterfaceC18197oF3;
import ir.nasim.KW4;
import ir.nasim.ME3;
import ir.nasim.NE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import livekit.LivekitModels$Encryption;

/* loaded from: classes8.dex */
public final class LivekitRtc$AddTrackRequest extends GeneratedMessageLite implements U64 {
    public static final int AUDIO_FEATURES_FIELD_NUMBER = 17;
    public static final int BACKUP_CODEC_POLICY_FIELD_NUMBER = 16;
    public static final int CID_FIELD_NUMBER = 1;
    private static final LivekitRtc$AddTrackRequest DEFAULT_INSTANCE;
    public static final int DISABLE_DTX_FIELD_NUMBER = 7;
    public static final int DISABLE_RED_FIELD_NUMBER = 13;
    public static final int ENCRYPTION_FIELD_NUMBER = 14;
    public static final int HEIGHT_FIELD_NUMBER = 5;
    public static final int LAYERS_FIELD_NUMBER = 9;
    public static final int MUTED_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SID_FIELD_NUMBER = 11;
    public static final int SIMULCAST_CODECS_FIELD_NUMBER = 10;
    public static final int SOURCE_FIELD_NUMBER = 8;
    public static final int STEREO_FIELD_NUMBER = 12;
    public static final int STREAM_FIELD_NUMBER = 15;
    public static final int TYPE_FIELD_NUMBER = 3;
    public static final int WIDTH_FIELD_NUMBER = 4;
    private static final B.h.a audioFeatures_converter_ = new a();
    private int audioFeaturesMemoizedSerializedSize;
    private int backupCodecPolicy_;
    private boolean disableDtx_;
    private boolean disableRed_;
    private int encryption_;
    private int height_;
    private boolean muted_;
    private int source_;
    private boolean stereo_;
    private int type_;
    private int width_;
    private String cid_ = "";
    private String name_ = "";
    private B.j layers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j simulcastCodecs_ = GeneratedMessageLite.emptyProtobufList();
    private String sid_ = "";
    private String stream_ = "";
    private B.g audioFeatures_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ME3 a(Integer num) {
            ME3 me3J = ME3.j(num.intValue());
            return me3J == null ? ME3.UNRECOGNIZED : me3J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(s sVar) {
            this();
        }

        public b A(Iterable iterable) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).addAllAudioFeatures(iterable);
            return this;
        }

        public b B(Iterable iterable) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).addAllLayers(iterable);
            return this;
        }

        public b C(LivekitRtc$SimulcastCodec livekitRtc$SimulcastCodec) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).addSimulcastCodecs(livekitRtc$SimulcastCodec);
            return this;
        }

        public b D() {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).clearStream();
            return this;
        }

        public EnumC9607aF3 E() {
            return ((LivekitRtc$AddTrackRequest) this.b).getSource();
        }

        public b F(String str) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setCid(str);
            return this;
        }

        public b G(boolean z) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setDisableDtx(z);
            return this;
        }

        public b H(boolean z) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setDisableRed(z);
            return this;
        }

        public b I(LivekitModels$Encryption.b bVar) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setEncryption(bVar);
            return this;
        }

        public b J(int i) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setHeight(i);
            return this;
        }

        public b K(boolean z) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setMuted(z);
            return this;
        }

        public b L(String str) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setName(str);
            return this;
        }

        public b M(String str) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setSid(str);
            return this;
        }

        public b N(EnumC9607aF3 enumC9607aF3) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setSource(enumC9607aF3);
            return this;
        }

        public b O(String str) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setStream(str);
            return this;
        }

        public b Q(EnumC10201bF3 enumC10201bF3) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setType(enumC10201bF3);
            return this;
        }

        public b R(int i) {
            q();
            ((LivekitRtc$AddTrackRequest) this.b).setWidth(i);
            return this;
        }

        private b() {
            super(LivekitRtc$AddTrackRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$AddTrackRequest livekitRtc$AddTrackRequest = new LivekitRtc$AddTrackRequest();
        DEFAULT_INSTANCE = livekitRtc$AddTrackRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$AddTrackRequest.class, livekitRtc$AddTrackRequest);
    }

    private LivekitRtc$AddTrackRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAudioFeatures(Iterable<? extends ME3> iterable) {
        ensureAudioFeaturesIsMutable();
        Iterator<? extends ME3> it = iterable.iterator();
        while (it.hasNext()) {
            this.audioFeatures_.b1(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAudioFeaturesValue(Iterable<Integer> iterable) {
        ensureAudioFeaturesIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.audioFeatures_.b1(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLayers(Iterable<? extends LivekitModels$VideoLayer> iterable) {
        ensureLayersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.layers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSimulcastCodecs(Iterable<? extends LivekitRtc$SimulcastCodec> iterable) {
        ensureSimulcastCodecsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.simulcastCodecs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAudioFeatures(ME3 me3) {
        me3.getClass();
        ensureAudioFeaturesIsMutable();
        this.audioFeatures_.b1(me3.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAudioFeaturesValue(int i) {
        ensureAudioFeaturesIsMutable();
        this.audioFeatures_.b1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(livekitModels$VideoLayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSimulcastCodecs(LivekitRtc$SimulcastCodec livekitRtc$SimulcastCodec) {
        livekitRtc$SimulcastCodec.getClass();
        ensureSimulcastCodecsIsMutable();
        this.simulcastCodecs_.add(livekitRtc$SimulcastCodec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioFeatures() {
        this.audioFeatures_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackupCodecPolicy() {
        this.backupCodecPolicy_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCid() {
        this.cid_ = getDefaultInstance().getCid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisableDtx() {
        this.disableDtx_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisableRed() {
        this.disableRed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEncryption() {
        this.encryption_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeight() {
        this.height_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayers() {
        this.layers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMuted() {
        this.muted_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSid() {
        this.sid_ = getDefaultInstance().getSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSimulcastCodecs() {
        this.simulcastCodecs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSource() {
        this.source_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStereo() {
        this.stereo_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStream() {
        this.stream_ = getDefaultInstance().getStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidth() {
        this.width_ = 0;
    }

    private void ensureAudioFeaturesIsMutable() {
        B.g gVar = this.audioFeatures_;
        if (gVar.u()) {
            return;
        }
        this.audioFeatures_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureLayersIsMutable() {
        B.j jVar = this.layers_;
        if (jVar.u()) {
            return;
        }
        this.layers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureSimulcastCodecsIsMutable() {
        B.j jVar = this.simulcastCodecs_;
        if (jVar.u()) {
            return;
        }
        this.simulcastCodecs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$AddTrackRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$AddTrackRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLayers(int i) {
        ensureLayersIsMutable();
        this.layers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSimulcastCodecs(int i) {
        ensureSimulcastCodecsIsMutable();
        this.simulcastCodecs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioFeatures(int i, ME3 me3) {
        me3.getClass();
        ensureAudioFeaturesIsMutable();
        this.audioFeatures_.U(i, me3.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioFeaturesValue(int i, int i2) {
        ensureAudioFeaturesIsMutable();
        this.audioFeatures_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackupCodecPolicy(NE3 ne3) {
        this.backupCodecPolicy_ = ne3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackupCodecPolicyValue(int i) {
        this.backupCodecPolicy_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCid(String str) {
        str.getClass();
        this.cid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisableDtx(boolean z) {
        this.disableDtx_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisableRed(boolean z) {
        this.disableRed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncryption(LivekitModels$Encryption.b bVar) {
        this.encryption_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncryptionValue(int i) {
        this.encryption_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        this.height_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayers(int i, LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.set(i, livekitModels$VideoLayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMuted(boolean z) {
        this.muted_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSid(String str) {
        str.getClass();
        this.sid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSimulcastCodecs(int i, LivekitRtc$SimulcastCodec livekitRtc$SimulcastCodec) {
        livekitRtc$SimulcastCodec.getClass();
        ensureSimulcastCodecsIsMutable();
        this.simulcastCodecs_.set(i, livekitRtc$SimulcastCodec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSource(EnumC9607aF3 enumC9607aF3) {
        this.source_ = enumC9607aF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceValue(int i) {
        this.source_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStereo(boolean z) {
        this.stereo_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStream(String str) {
        str.getClass();
        this.stream_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stream_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(EnumC10201bF3 enumC10201bF3) {
        this.type_ = enumC10201bF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i) {
        this.type_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$AddTrackRequest();
            case 2:
                return new b(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0000\u0000\u0001\u0011\u0011\u0000\u0003\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\u000b\u0005\u000b\u0006\u0007\u0007\u0007\b\f\t\u001b\n\u001b\u000bȈ\f\u0007\r\u0007\u000e\f\u000fȈ\u0010\f\u0011,", new Object[]{"cid_", "name_", "type_", "width_", "height_", "muted_", "disableDtx_", "source_", "layers_", LivekitModels$VideoLayer.class, "simulcastCodecs_", LivekitRtc$SimulcastCodec.class, "sid_", "stereo_", "disableRed_", "encryption_", "stream_", "backupCodecPolicy_", "audioFeatures_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$AddTrackRequest.class) {
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

    public ME3 getAudioFeatures(int i) {
        ME3 me3J = ME3.j(this.audioFeatures_.getInt(i));
        return me3J == null ? ME3.UNRECOGNIZED : me3J;
    }

    public int getAudioFeaturesCount() {
        return this.audioFeatures_.size();
    }

    public List<ME3> getAudioFeaturesList() {
        return new B.h(this.audioFeatures_, audioFeatures_converter_);
    }

    public int getAudioFeaturesValue(int i) {
        return this.audioFeatures_.getInt(i);
    }

    public List<Integer> getAudioFeaturesValueList() {
        return this.audioFeatures_;
    }

    public NE3 getBackupCodecPolicy() {
        NE3 ne3J = NE3.j(this.backupCodecPolicy_);
        return ne3J == null ? NE3.UNRECOGNIZED : ne3J;
    }

    public int getBackupCodecPolicyValue() {
        return this.backupCodecPolicy_;
    }

    public String getCid() {
        return this.cid_;
    }

    public AbstractC2383g getCidBytes() {
        return AbstractC2383g.N(this.cid_);
    }

    @Deprecated
    public boolean getDisableDtx() {
        return this.disableDtx_;
    }

    public boolean getDisableRed() {
        return this.disableRed_;
    }

    public LivekitModels$Encryption.b getEncryption() {
        LivekitModels$Encryption.b bVarJ = LivekitModels$Encryption.b.j(this.encryption_);
        return bVarJ == null ? LivekitModels$Encryption.b.UNRECOGNIZED : bVarJ;
    }

    public int getEncryptionValue() {
        return this.encryption_;
    }

    public int getHeight() {
        return this.height_;
    }

    public LivekitModels$VideoLayer getLayers(int i) {
        return (LivekitModels$VideoLayer) this.layers_.get(i);
    }

    public int getLayersCount() {
        return this.layers_.size();
    }

    public List<LivekitModels$VideoLayer> getLayersList() {
        return this.layers_;
    }

    public InterfaceC12224eF3 getLayersOrBuilder(int i) {
        return (InterfaceC12224eF3) this.layers_.get(i);
    }

    public List<? extends InterfaceC12224eF3> getLayersOrBuilderList() {
        return this.layers_;
    }

    public boolean getMuted() {
        return this.muted_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getSid() {
        return this.sid_;
    }

    public AbstractC2383g getSidBytes() {
        return AbstractC2383g.N(this.sid_);
    }

    public LivekitRtc$SimulcastCodec getSimulcastCodecs(int i) {
        return (LivekitRtc$SimulcastCodec) this.simulcastCodecs_.get(i);
    }

    public int getSimulcastCodecsCount() {
        return this.simulcastCodecs_.size();
    }

    public List<LivekitRtc$SimulcastCodec> getSimulcastCodecsList() {
        return this.simulcastCodecs_;
    }

    public InterfaceC18197oF3 getSimulcastCodecsOrBuilder(int i) {
        return (InterfaceC18197oF3) this.simulcastCodecs_.get(i);
    }

    public List<? extends InterfaceC18197oF3> getSimulcastCodecsOrBuilderList() {
        return this.simulcastCodecs_;
    }

    public EnumC9607aF3 getSource() {
        EnumC9607aF3 enumC9607aF3J = EnumC9607aF3.j(this.source_);
        return enumC9607aF3J == null ? EnumC9607aF3.UNRECOGNIZED : enumC9607aF3J;
    }

    public int getSourceValue() {
        return this.source_;
    }

    @Deprecated
    public boolean getStereo() {
        return this.stereo_;
    }

    public String getStream() {
        return this.stream_;
    }

    public AbstractC2383g getStreamBytes() {
        return AbstractC2383g.N(this.stream_);
    }

    public EnumC10201bF3 getType() {
        EnumC10201bF3 enumC10201bF3J = EnumC10201bF3.j(this.type_);
        return enumC10201bF3J == null ? EnumC10201bF3.UNRECOGNIZED : enumC10201bF3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public int getWidth() {
        return this.width_;
    }

    public static b newBuilder(LivekitRtc$AddTrackRequest livekitRtc$AddTrackRequest) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitRtc$AddTrackRequest);
    }

    public static LivekitRtc$AddTrackRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(int i, LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(i, livekitModels$VideoLayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSimulcastCodecs(int i, LivekitRtc$SimulcastCodec livekitRtc$SimulcastCodec) {
        livekitRtc$SimulcastCodec.getClass();
        ensureSimulcastCodecsIsMutable();
        this.simulcastCodecs_.add(i, livekitRtc$SimulcastCodec);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(byte[] bArr) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(InputStream inputStream) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$AddTrackRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$AddTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
