package replay;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11731dW0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class CloudReplay$ReplayInfo extends GeneratedMessageLite implements InterfaceC11731dW0 {
    private static final CloudReplay$ReplayInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPLAY_ID_FIELD_NUMBER = 1;
    private String replayId_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC11731dW0 {
        /* synthetic */ a(replay.a aVar) {
            this();
        }

        private a() {
            super(CloudReplay$ReplayInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        CloudReplay$ReplayInfo cloudReplay$ReplayInfo = new CloudReplay$ReplayInfo();
        DEFAULT_INSTANCE = cloudReplay$ReplayInfo;
        GeneratedMessageLite.registerDefaultInstance(CloudReplay$ReplayInfo.class, cloudReplay$ReplayInfo);
    }

    private CloudReplay$ReplayInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReplayId() {
        this.replayId_ = getDefaultInstance().getReplayId();
    }

    public static CloudReplay$ReplayInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CloudReplay$ReplayInfo parseDelimitedFrom(InputStream inputStream) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CloudReplay$ReplayInfo parseFrom(ByteBuffer byteBuffer) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplayId(String str) {
        str.getClass();
        this.replayId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplayIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.replayId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        replay.a aVar = null;
        switch (replay.a.a[gVar.ordinal()]) {
            case 1:
                return new CloudReplay$ReplayInfo();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"replayId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CloudReplay$ReplayInfo.class) {
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

    public String getReplayId() {
        return this.replayId_;
    }

    public AbstractC2383g getReplayIdBytes() {
        return AbstractC2383g.N(this.replayId_);
    }

    public static a newBuilder(CloudReplay$ReplayInfo cloudReplay$ReplayInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(cloudReplay$ReplayInfo);
    }

    public static CloudReplay$ReplayInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CloudReplay$ReplayInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CloudReplay$ReplayInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CloudReplay$ReplayInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CloudReplay$ReplayInfo parseFrom(byte[] bArr) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CloudReplay$ReplayInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CloudReplay$ReplayInfo parseFrom(InputStream inputStream) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CloudReplay$ReplayInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CloudReplay$ReplayInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CloudReplay$ReplayInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CloudReplay$ReplayInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
