package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitAnalytics$FeatureUsageInfo;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$ReportInfo extends GeneratedMessageLite implements U64 {
    private static final LivekitAnalytics$ReportInfo DEFAULT_INSTANCE;
    public static final int FEATURE_USAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int messageCase_ = 0;
    private Object message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$ReportInfo.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        FEATURE_USAGE(1),
        MESSAGE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return MESSAGE_NOT_SET;
            }
            if (i != 1) {
                return null;
            }
            return FEATURE_USAGE;
        }
    }

    static {
        LivekitAnalytics$ReportInfo livekitAnalytics$ReportInfo = new LivekitAnalytics$ReportInfo();
        DEFAULT_INSTANCE = livekitAnalytics$ReportInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$ReportInfo.class, livekitAnalytics$ReportInfo);
    }

    private LivekitAnalytics$ReportInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFeatureUsage() {
        if (this.messageCase_ == 1) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.messageCase_ = 0;
        this.message_ = null;
    }

    public static LivekitAnalytics$ReportInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFeatureUsage(LivekitAnalytics$FeatureUsageInfo livekitAnalytics$FeatureUsageInfo) {
        livekitAnalytics$FeatureUsageInfo.getClass();
        if (this.messageCase_ != 1 || this.message_ == LivekitAnalytics$FeatureUsageInfo.getDefaultInstance()) {
            this.message_ = livekitAnalytics$FeatureUsageInfo;
        } else {
            this.message_ = ((LivekitAnalytics$FeatureUsageInfo.a) LivekitAnalytics$FeatureUsageInfo.newBuilder((LivekitAnalytics$FeatureUsageInfo) this.message_).v(livekitAnalytics$FeatureUsageInfo)).j();
        }
        this.messageCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$ReportInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFeatureUsage(LivekitAnalytics$FeatureUsageInfo livekitAnalytics$FeatureUsageInfo) {
        livekitAnalytics$FeatureUsageInfo.getClass();
        this.message_ = livekitAnalytics$FeatureUsageInfo;
        this.messageCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$ReportInfo();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"message_", "messageCase_", LivekitAnalytics$FeatureUsageInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$ReportInfo.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public LivekitAnalytics$FeatureUsageInfo getFeatureUsage() {
        return this.messageCase_ == 1 ? (LivekitAnalytics$FeatureUsageInfo) this.message_ : LivekitAnalytics$FeatureUsageInfo.getDefaultInstance();
    }

    public b getMessageCase() {
        return b.j(this.messageCase_);
    }

    public boolean hasFeatureUsage() {
        return this.messageCase_ == 1;
    }

    public static a newBuilder(LivekitAnalytics$ReportInfo livekitAnalytics$ReportInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$ReportInfo);
    }

    public static LivekitAnalytics$ReportInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(byte[] bArr) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$ReportInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$ReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
