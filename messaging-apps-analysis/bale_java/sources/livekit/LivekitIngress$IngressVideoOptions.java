package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.CE3;
import ir.nasim.EnumC9607aF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitIngress$IngressVideoEncodingOptions;

/* loaded from: classes8.dex */
public final class LivekitIngress$IngressVideoOptions extends GeneratedMessageLite implements U64 {
    private static final LivekitIngress$IngressVideoOptions DEFAULT_INSTANCE;
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
            super(LivekitIngress$IngressVideoOptions.DEFAULT_INSTANCE);
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
        LivekitIngress$IngressVideoOptions livekitIngress$IngressVideoOptions = new LivekitIngress$IngressVideoOptions();
        DEFAULT_INSTANCE = livekitIngress$IngressVideoOptions;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$IngressVideoOptions.class, livekitIngress$IngressVideoOptions);
    }

    private LivekitIngress$IngressVideoOptions() {
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

    public static LivekitIngress$IngressVideoOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOptions(LivekitIngress$IngressVideoEncodingOptions livekitIngress$IngressVideoEncodingOptions) {
        livekitIngress$IngressVideoEncodingOptions.getClass();
        if (this.encodingOptionsCase_ != 4 || this.encodingOptions_ == LivekitIngress$IngressVideoEncodingOptions.getDefaultInstance()) {
            this.encodingOptions_ = livekitIngress$IngressVideoEncodingOptions;
        } else {
            this.encodingOptions_ = ((LivekitIngress$IngressVideoEncodingOptions.a) LivekitIngress$IngressVideoEncodingOptions.newBuilder((LivekitIngress$IngressVideoEncodingOptions) this.encodingOptions_).v(livekitIngress$IngressVideoEncodingOptions)).j();
        }
        this.encodingOptionsCase_ = 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$IngressVideoOptions parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setOptions(LivekitIngress$IngressVideoEncodingOptions livekitIngress$IngressVideoEncodingOptions) {
        livekitIngress$IngressVideoEncodingOptions.getClass();
        this.encodingOptions_ = livekitIngress$IngressVideoEncodingOptions;
        this.encodingOptionsCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreset(CE3 ce3) {
        this.encodingOptions_ = Integer.valueOf(ce3.getNumber());
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
                return new LivekitIngress$IngressVideoOptions();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003?\u0000\u0004<\u0000", new Object[]{"encodingOptions_", "encodingOptionsCase_", "name_", "source_", LivekitIngress$IngressVideoEncodingOptions.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$IngressVideoOptions.class) {
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

    public LivekitIngress$IngressVideoEncodingOptions getOptions() {
        return this.encodingOptionsCase_ == 4 ? (LivekitIngress$IngressVideoEncodingOptions) this.encodingOptions_ : LivekitIngress$IngressVideoEncodingOptions.getDefaultInstance();
    }

    public CE3 getPreset() {
        if (this.encodingOptionsCase_ != 3) {
            return CE3.H264_720P_30FPS_3_LAYERS;
        }
        CE3 ce3J = CE3.j(((Integer) this.encodingOptions_).intValue());
        return ce3J == null ? CE3.UNRECOGNIZED : ce3J;
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

    public static a newBuilder(LivekitIngress$IngressVideoOptions livekitIngress$IngressVideoOptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$IngressVideoOptions);
    }

    public static LivekitIngress$IngressVideoOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(byte[] bArr) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(InputStream inputStream) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$IngressVideoOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$IngressVideoOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
