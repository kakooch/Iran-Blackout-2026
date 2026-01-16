package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$PlayoutDelay extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$PlayoutDelay DEFAULT_INSTANCE;
    public static final int ENABLED_FIELD_NUMBER = 1;
    public static final int MAX_FIELD_NUMBER = 3;
    public static final int MIN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private boolean enabled_;
    private int max_;
    private int min_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$PlayoutDelay.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$PlayoutDelay livekitModels$PlayoutDelay = new LivekitModels$PlayoutDelay();
        DEFAULT_INSTANCE = livekitModels$PlayoutDelay;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$PlayoutDelay.class, livekitModels$PlayoutDelay);
    }

    private LivekitModels$PlayoutDelay() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnabled() {
        this.enabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMax() {
        this.max_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMin() {
        this.min_ = 0;
    }

    public static LivekitModels$PlayoutDelay getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$PlayoutDelay parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$PlayoutDelay parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabled(boolean z) {
        this.enabled_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMax(int i) {
        this.max_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMin(int i) {
        this.min_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$PlayoutDelay();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002\u000b\u0003\u000b", new Object[]{"enabled_", "min_", "max_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$PlayoutDelay.class) {
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

    public boolean getEnabled() {
        return this.enabled_;
    }

    public int getMax() {
        return this.max_;
    }

    public int getMin() {
        return this.min_;
    }

    public static a newBuilder(LivekitModels$PlayoutDelay livekitModels$PlayoutDelay) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$PlayoutDelay);
    }

    public static LivekitModels$PlayoutDelay parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$PlayoutDelay parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$PlayoutDelay parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$PlayoutDelay parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$PlayoutDelay parseFrom(byte[] bArr) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$PlayoutDelay parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$PlayoutDelay parseFrom(InputStream inputStream) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$PlayoutDelay parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$PlayoutDelay parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$PlayoutDelay parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$PlayoutDelay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
