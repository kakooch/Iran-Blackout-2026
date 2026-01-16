package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.YE3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$SpeakerInfo extends GeneratedMessageLite implements YE3 {
    public static final int ACTIVE_FIELD_NUMBER = 3;
    private static final LivekitModels$SpeakerInfo DEFAULT_INSTANCE;
    public static final int LEVEL_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SID_FIELD_NUMBER = 1;
    private boolean active_;
    private float level_;
    private String sid_ = "";

    public static final class a extends GeneratedMessageLite.b implements YE3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$SpeakerInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$SpeakerInfo livekitModels$SpeakerInfo = new LivekitModels$SpeakerInfo();
        DEFAULT_INSTANCE = livekitModels$SpeakerInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$SpeakerInfo.class, livekitModels$SpeakerInfo);
    }

    private LivekitModels$SpeakerInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearActive() {
        this.active_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLevel() {
        this.level_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSid() {
        this.sid_ = getDefaultInstance().getSid();
    }

    public static LivekitModels$SpeakerInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$SpeakerInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$SpeakerInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActive(boolean z) {
        this.active_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLevel(float f) {
        this.level_ = f;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$SpeakerInfo();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0001\u0003\u0007", new Object[]{"sid_", "level_", "active_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$SpeakerInfo.class) {
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

    public boolean getActive() {
        return this.active_;
    }

    public float getLevel() {
        return this.level_;
    }

    public String getSid() {
        return this.sid_;
    }

    public AbstractC2383g getSidBytes() {
        return AbstractC2383g.N(this.sid_);
    }

    public static a newBuilder(LivekitModels$SpeakerInfo livekitModels$SpeakerInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$SpeakerInfo);
    }

    public static LivekitModels$SpeakerInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$SpeakerInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$SpeakerInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$SpeakerInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$SpeakerInfo parseFrom(byte[] bArr) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$SpeakerInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$SpeakerInfo parseFrom(InputStream inputStream) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$SpeakerInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$SpeakerInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$SpeakerInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$SpeakerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
