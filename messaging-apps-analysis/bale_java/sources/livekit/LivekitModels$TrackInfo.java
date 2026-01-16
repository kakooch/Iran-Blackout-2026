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
import ir.nasim.KW4;
import ir.nasim.ME3;
import ir.nasim.NE3;
import ir.nasim.XE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import livekit.LivekitModels$Encryption;
import livekit.LivekitModels$TimedVersion;

/* loaded from: classes8.dex */
public final class LivekitModels$TrackInfo extends GeneratedMessageLite implements q {
    public static final int AUDIO_FEATURES_FIELD_NUMBER = 19;
    public static final int BACKUP_CODEC_POLICY_FIELD_NUMBER = 20;
    public static final int CODECS_FIELD_NUMBER = 13;
    private static final LivekitModels$TrackInfo DEFAULT_INSTANCE;
    public static final int DISABLE_DTX_FIELD_NUMBER = 8;
    public static final int DISABLE_RED_FIELD_NUMBER = 15;
    public static final int ENCRYPTION_FIELD_NUMBER = 16;
    public static final int HEIGHT_FIELD_NUMBER = 6;
    public static final int LAYERS_FIELD_NUMBER = 10;
    public static final int MID_FIELD_NUMBER = 12;
    public static final int MIME_TYPE_FIELD_NUMBER = 11;
    public static final int MUTED_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SID_FIELD_NUMBER = 1;
    public static final int SIMULCAST_FIELD_NUMBER = 7;
    public static final int SOURCE_FIELD_NUMBER = 9;
    public static final int STEREO_FIELD_NUMBER = 14;
    public static final int STREAM_FIELD_NUMBER = 17;
    public static final int TYPE_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 18;
    public static final int WIDTH_FIELD_NUMBER = 5;
    private static final B.h.a audioFeatures_converter_ = new a();
    private int audioFeaturesMemoizedSerializedSize;
    private int backupCodecPolicy_;
    private boolean disableDtx_;
    private boolean disableRed_;
    private int encryption_;
    private int height_;
    private boolean muted_;
    private boolean simulcast_;
    private int source_;
    private boolean stereo_;
    private int type_;
    private LivekitModels$TimedVersion version_;
    private int width_;
    private String sid_ = "";
    private String name_ = "";
    private B.j layers_ = GeneratedMessageLite.emptyProtobufList();
    private String mimeType_ = "";
    private String mid_ = "";
    private B.j codecs_ = GeneratedMessageLite.emptyProtobufList();
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

    public static final class b extends GeneratedMessageLite.b implements q {
        /* synthetic */ b(o oVar) {
            this();
        }

        private b() {
            super(LivekitModels$TrackInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$TrackInfo livekitModels$TrackInfo = new LivekitModels$TrackInfo();
        DEFAULT_INSTANCE = livekitModels$TrackInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$TrackInfo.class, livekitModels$TrackInfo);
    }

    private LivekitModels$TrackInfo() {
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
    public void addAllCodecs(Iterable<? extends LivekitModels$SimulcastCodecInfo> iterable) {
        ensureCodecsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.codecs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLayers(Iterable<? extends LivekitModels$VideoLayer> iterable) {
        ensureLayersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.layers_);
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
    public void addCodecs(LivekitModels$SimulcastCodecInfo livekitModels$SimulcastCodecInfo) {
        livekitModels$SimulcastCodecInfo.getClass();
        ensureCodecsIsMutable();
        this.codecs_.add(livekitModels$SimulcastCodecInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(livekitModels$VideoLayer);
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
    public void clearCodecs() {
        this.codecs_ = GeneratedMessageLite.emptyProtobufList();
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
    public void clearMid() {
        this.mid_ = getDefaultInstance().getMid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
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
    public void clearSimulcast() {
        this.simulcast_ = false;
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
    public void clearVersion() {
        this.version_ = null;
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

    private void ensureCodecsIsMutable() {
        B.j jVar = this.codecs_;
        if (jVar.u()) {
            return;
        }
        this.codecs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureLayersIsMutable() {
        B.j jVar = this.layers_;
        if (jVar.u()) {
            return;
        }
        this.layers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$TrackInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeVersion(LivekitModels$TimedVersion livekitModels$TimedVersion) {
        livekitModels$TimedVersion.getClass();
        LivekitModels$TimedVersion livekitModels$TimedVersion2 = this.version_;
        if (livekitModels$TimedVersion2 == null || livekitModels$TimedVersion2 == LivekitModels$TimedVersion.getDefaultInstance()) {
            this.version_ = livekitModels$TimedVersion;
        } else {
            this.version_ = (LivekitModels$TimedVersion) ((LivekitModels$TimedVersion.a) LivekitModels$TimedVersion.newBuilder(this.version_).v(livekitModels$TimedVersion)).j();
        }
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$TrackInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$TrackInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCodecs(int i) {
        ensureCodecsIsMutable();
        this.codecs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLayers(int i) {
        ensureLayersIsMutable();
        this.layers_.remove(i);
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
    public void setCodecs(int i, LivekitModels$SimulcastCodecInfo livekitModels$SimulcastCodecInfo) {
        livekitModels$SimulcastCodecInfo.getClass();
        ensureCodecsIsMutable();
        this.codecs_.set(i, livekitModels$SimulcastCodecInfo);
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
    public void setMid(String str) {
        str.getClass();
        this.mid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mimeType_ = abstractC2383g.f0();
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
    public void setSimulcast(boolean z) {
        this.simulcast_ = z;
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
    public void setVersion(LivekitModels$TimedVersion livekitModels$TimedVersion) {
        livekitModels$TimedVersion.getClass();
        this.version_ = livekitModels$TimedVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$TrackInfo();
            case 2:
                return new b(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0014\u0000\u0000\u0001\u0014\u0014\u0000\u0003\u0000\u0001Ȉ\u0002\f\u0003Ȉ\u0004\u0007\u0005\u000b\u0006\u000b\u0007\u0007\b\u0007\t\f\n\u001b\u000bȈ\fȈ\r\u001b\u000e\u0007\u000f\u0007\u0010\f\u0011Ȉ\u0012\t\u0013,\u0014\f", new Object[]{"sid_", "type_", "name_", "muted_", "width_", "height_", "simulcast_", "disableDtx_", "source_", "layers_", LivekitModels$VideoLayer.class, "mimeType_", "mid_", "codecs_", LivekitModels$SimulcastCodecInfo.class, "stereo_", "disableRed_", "encryption_", "stream_", "version_", "audioFeatures_", "backupCodecPolicy_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$TrackInfo.class) {
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

    public LivekitModels$SimulcastCodecInfo getCodecs(int i) {
        return (LivekitModels$SimulcastCodecInfo) this.codecs_.get(i);
    }

    public int getCodecsCount() {
        return this.codecs_.size();
    }

    public List<LivekitModels$SimulcastCodecInfo> getCodecsList() {
        return this.codecs_;
    }

    public XE3 getCodecsOrBuilder(int i) {
        return (XE3) this.codecs_.get(i);
    }

    public List<? extends XE3> getCodecsOrBuilderList() {
        return this.codecs_;
    }

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

    public String getMid() {
        return this.mid_;
    }

    public AbstractC2383g getMidBytes() {
        return AbstractC2383g.N(this.mid_);
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
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

    public boolean getSimulcast() {
        return this.simulcast_;
    }

    public EnumC9607aF3 getSource() {
        EnumC9607aF3 enumC9607aF3J = EnumC9607aF3.j(this.source_);
        return enumC9607aF3J == null ? EnumC9607aF3.UNRECOGNIZED : enumC9607aF3J;
    }

    public int getSourceValue() {
        return this.source_;
    }

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

    public LivekitModels$TimedVersion getVersion() {
        LivekitModels$TimedVersion livekitModels$TimedVersion = this.version_;
        return livekitModels$TimedVersion == null ? LivekitModels$TimedVersion.getDefaultInstance() : livekitModels$TimedVersion;
    }

    public int getWidth() {
        return this.width_;
    }

    public boolean hasVersion() {
        return this.version_ != null;
    }

    public static b newBuilder(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitModels$TrackInfo);
    }

    public static LivekitModels$TrackInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$TrackInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$TrackInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCodecs(int i, LivekitModels$SimulcastCodecInfo livekitModels$SimulcastCodecInfo) {
        livekitModels$SimulcastCodecInfo.getClass();
        ensureCodecsIsMutable();
        this.codecs_.add(i, livekitModels$SimulcastCodecInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(int i, LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(i, livekitModels$VideoLayer);
    }

    public static LivekitModels$TrackInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$TrackInfo parseFrom(byte[] bArr) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$TrackInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$TrackInfo parseFrom(InputStream inputStream) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$TrackInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$TrackInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$TrackInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
