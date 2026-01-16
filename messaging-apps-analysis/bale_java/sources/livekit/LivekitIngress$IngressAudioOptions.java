package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC24807zE3;
import ir.nasim.EnumC9607aF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitIngress$IngressAudioEncodingOptions;

/* loaded from: classes8.dex */
public final class LivekitIngress$IngressAudioOptions extends GeneratedMessageLite implements U64 {
    private static final LivekitIngress$IngressAudioOptions DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PRESET_FIELD_NUMBER = 3;
    public static final int SOURCE_FIELD_NUMBER = 2;
    private Object encodingOptions_;
    private int source_;
    private int encodingOptionsCase_ = 0;
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$IngressAudioOptions.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PRESET(3),
        OPTIONS(4),
        ENCODINGOPTIONS_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return ENCODINGOPTIONS_NOT_SET;
            }
            if (i == 3) {
                return PRESET;
            }
            if (i != 4) {
                return null;
            }
            return OPTIONS;
        }
    }

    static {
        LivekitIngress$IngressAudioOptions livekitIngress$IngressAudioOptions = new LivekitIngress$IngressAudioOptions();
        DEFAULT_INSTANCE = livekitIngress$IngressAudioOptions;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$IngressAudioOptions.class, livekitIngress$IngressAudioOptions);
    }

    private LivekitIngress$IngressAudioOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEncodingOptions() {
        this.encodingOptionsCase_ = 0;
        this.encodingOptions_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        if (this.encodingOptionsCase_ == 4) {
            this.encodingOptionsCase_ = 0;
            this.encodingOptions_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPreset() {
        if (this.encodingOptionsCase_ == 3) {
            this.encodingOptionsCase_ = 0;
            this.encodingOptions_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSource() {
        this.source_ = 0;
    }

    public static LivekitIngress$IngressAudioOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOptions(LivekitIngress$IngressAudioEncodingOptions livekitIngress$IngressAudioEncodingOptions) {
        livekitIngress$IngressAudioEncodingOptions.getClass();
        if (this.encodingOptionsCase_ != 4 || this.encodingOptions_ == LivekitIngress$IngressAudioEncodingOptions.getDefaultInstance()) {
            this.encodingOptions_ = livekitIngress$IngressAudioEncodingOptions;
        } else {
            this.encodingOptions_ = ((LivekitIngress$IngressAudioEncodingOptions.a) LivekitIngress$IngressAudioEncodingOptions.newBuilder((LivekitIngress$IngressAudioEncodingOptions) this.encodingOptions_).v(livekitIngress$IngressAudioEncodingOptions)).j();
        }
        this.encodingOptionsCase_ = 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$IngressAudioOptions parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setOptions(LivekitIngress$IngressAudioEncodingOptions livekitIngress$IngressAudioEncodingOptions) {
        livekitIngress$IngressAudioEncodingOptions.getClass();
        this.encodingOptions_ = livekitIngress$IngressAudioEncodingOptions;
        this.encodingOptionsCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreset(EnumC24807zE3 enumC24807zE3) {
        this.encodingOptions_ = Integer.valueOf(enumC24807zE3.getNumber());
        this.encodingOptionsCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresetValue(int i) {
        this.encodingOptionsCase_ = 3;
        this.encodingOptions_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSource(EnumC9607aF3 enumC9607aF3) {
        this.source_ = enumC9607aF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceValue(int i) {
        this.source_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$IngressAudioOptions();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003?\u0000\u0004<\u0000", new Object[]{"encodingOptions_", "encodingOptionsCase_", "name_", "source_", LivekitIngress$IngressAudioEncodingOptions.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$IngressAudioOptions.class) {
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

    public b getEncodingOptionsCase() {
        return b.j(this.encodingOptionsCase_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public LivekitIngress$IngressAudioEncodingOptions getOptions() {
        return this.encodingOptionsCase_ == 4 ? (LivekitIngress$IngressAudioEncodingOptions) this.encodingOptions_ : LivekitIngress$IngressAudioEncodingOptions.getDefaultInstance();
    }

    public EnumC24807zE3 getPreset() {
        if (this.encodingOptionsCase_ != 3) {
            return EnumC24807zE3.OPUS_STEREO_96KBPS;
        }
        EnumC24807zE3 enumC24807zE3J = EnumC24807zE3.j(((Integer) this.encodingOptions_).intValue());
        return enumC24807zE3J == null ? EnumC24807zE3.UNRECOGNIZED : enumC24807zE3J;
    }

    public int getPresetValue() {
        if (this.encodingOptionsCase_ == 3) {
            return ((Integer) this.encodingOptions_).intValue();
        }
        return 0;
    }

    public EnumC9607aF3 getSource() {
        EnumC9607aF3 enumC9607aF3J = EnumC9607aF3.j(this.source_);
        return enumC9607aF3J == null ? EnumC9607aF3.UNRECOGNIZED : enumC9607aF3J;
    }

    public int getSourceValue() {
        return this.source_;
    }

    public boolean hasOptions() {
        return this.encodingOptionsCase_ == 4;
    }

    public boolean hasPreset() {
        return this.encodingOptionsCase_ == 3;
    }

    public static a newBuilder(LivekitIngress$IngressAudioOptions livekitIngress$IngressAudioOptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$IngressAudioOptions);
    }

    public static LivekitIngress$IngressAudioOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(byte[] bArr) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(InputStream inputStream) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$IngressAudioOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$IngressAudioOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
