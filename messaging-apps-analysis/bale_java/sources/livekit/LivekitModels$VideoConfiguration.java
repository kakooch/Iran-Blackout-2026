package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.OE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$VideoConfiguration extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$VideoConfiguration DEFAULT_INSTANCE;
    public static final int HARDWARE_ENCODER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int hardwareEncoder_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$VideoConfiguration.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$VideoConfiguration livekitModels$VideoConfiguration = new LivekitModels$VideoConfiguration();
        DEFAULT_INSTANCE = livekitModels$VideoConfiguration;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$VideoConfiguration.class, livekitModels$VideoConfiguration);
    }

    private LivekitModels$VideoConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHardwareEncoder() {
        this.hardwareEncoder_ = 0;
    }

    public static LivekitModels$VideoConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$VideoConfiguration parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$VideoConfiguration parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHardwareEncoder(OE3 oe3) {
        this.hardwareEncoder_ = oe3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHardwareEncoderValue(int i) {
        this.hardwareEncoder_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$VideoConfiguration();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"hardwareEncoder_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$VideoConfiguration.class) {
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

    public OE3 getHardwareEncoder() {
        OE3 oe3J = OE3.j(this.hardwareEncoder_);
        return oe3J == null ? OE3.UNRECOGNIZED : oe3J;
    }

    public int getHardwareEncoderValue() {
        return this.hardwareEncoder_;
    }

    public static a newBuilder(LivekitModels$VideoConfiguration livekitModels$VideoConfiguration) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$VideoConfiguration);
    }

    public static LivekitModels$VideoConfiguration parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$VideoConfiguration parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$VideoConfiguration parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$VideoConfiguration parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$VideoConfiguration parseFrom(byte[] bArr) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$VideoConfiguration parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$VideoConfiguration parseFrom(InputStream inputStream) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$VideoConfiguration parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$VideoConfiguration parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$VideoConfiguration parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
