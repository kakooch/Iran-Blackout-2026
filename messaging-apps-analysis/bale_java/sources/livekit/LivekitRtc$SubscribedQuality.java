package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12833fF3;
import ir.nasim.InterfaceC20579sF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$SubscribedQuality extends GeneratedMessageLite implements InterfaceC20579sF3 {
    private static final LivekitRtc$SubscribedQuality DEFAULT_INSTANCE;
    public static final int ENABLED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int QUALITY_FIELD_NUMBER = 1;
    private boolean enabled_;
    private int quality_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20579sF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SubscribedQuality.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SubscribedQuality livekitRtc$SubscribedQuality = new LivekitRtc$SubscribedQuality();
        DEFAULT_INSTANCE = livekitRtc$SubscribedQuality;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SubscribedQuality.class, livekitRtc$SubscribedQuality);
    }

    private LivekitRtc$SubscribedQuality() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnabled() {
        this.enabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuality() {
        this.quality_ = 0;
    }

    public static LivekitRtc$SubscribedQuality getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SubscribedQuality parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabled(boolean z) {
        this.enabled_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuality(EnumC12833fF3 enumC12833fF3) {
        this.quality_ = enumC12833fF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQualityValue(int i) {
        this.quality_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SubscribedQuality();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u0007", new Object[]{"quality_", "enabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SubscribedQuality.class) {
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

    public EnumC12833fF3 getQuality() {
        EnumC12833fF3 enumC12833fF3J = EnumC12833fF3.j(this.quality_);
        return enumC12833fF3J == null ? EnumC12833fF3.UNRECOGNIZED : enumC12833fF3J;
    }

    public int getQualityValue() {
        return this.quality_;
    }

    public static a newBuilder(LivekitRtc$SubscribedQuality livekitRtc$SubscribedQuality) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SubscribedQuality);
    }

    public static LivekitRtc$SubscribedQuality parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(byte[] bArr) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(InputStream inputStream) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SubscribedQuality parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SubscribedQuality) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
