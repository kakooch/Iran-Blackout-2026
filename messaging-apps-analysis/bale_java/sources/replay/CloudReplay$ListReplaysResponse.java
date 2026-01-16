package replay;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11731dW0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class CloudReplay$ListReplaysResponse extends GeneratedMessageLite implements U64 {
    private static final CloudReplay$ListReplaysResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPLAYS_FIELD_NUMBER = 1;
    private B.j replays_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(replay.a aVar) {
            this();
        }

        private a() {
            super(CloudReplay$ListReplaysResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        CloudReplay$ListReplaysResponse cloudReplay$ListReplaysResponse = new CloudReplay$ListReplaysResponse();
        DEFAULT_INSTANCE = cloudReplay$ListReplaysResponse;
        GeneratedMessageLite.registerDefaultInstance(CloudReplay$ListReplaysResponse.class, cloudReplay$ListReplaysResponse);
    }

    private CloudReplay$ListReplaysResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllReplays(Iterable<? extends CloudReplay$ReplayInfo> iterable) {
        ensureReplaysIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.replays_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addReplays(CloudReplay$ReplayInfo cloudReplay$ReplayInfo) {
        cloudReplay$ReplayInfo.getClass();
        ensureReplaysIsMutable();
        this.replays_.add(cloudReplay$ReplayInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReplays() {
        this.replays_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureReplaysIsMutable() {
        B.j jVar = this.replays_;
        if (jVar.u()) {
            return;
        }
        this.replays_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static CloudReplay$ListReplaysResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CloudReplay$ListReplaysResponse parseDelimitedFrom(InputStream inputStream) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(ByteBuffer byteBuffer) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeReplays(int i) {
        ensureReplaysIsMutable();
        this.replays_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplays(int i, CloudReplay$ReplayInfo cloudReplay$ReplayInfo) {
        cloudReplay$ReplayInfo.getClass();
        ensureReplaysIsMutable();
        this.replays_.set(i, cloudReplay$ReplayInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        replay.a aVar = null;
        switch (replay.a.a[gVar.ordinal()]) {
            case 1:
                return new CloudReplay$ListReplaysResponse();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"replays_", CloudReplay$ReplayInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CloudReplay$ListReplaysResponse.class) {
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

    public CloudReplay$ReplayInfo getReplays(int i) {
        return (CloudReplay$ReplayInfo) this.replays_.get(i);
    }

    public int getReplaysCount() {
        return this.replays_.size();
    }

    public List<CloudReplay$ReplayInfo> getReplaysList() {
        return this.replays_;
    }

    public InterfaceC11731dW0 getReplaysOrBuilder(int i) {
        return (InterfaceC11731dW0) this.replays_.get(i);
    }

    public List<? extends InterfaceC11731dW0> getReplaysOrBuilderList() {
        return this.replays_;
    }

    public static a newBuilder(CloudReplay$ListReplaysResponse cloudReplay$ListReplaysResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(cloudReplay$ListReplaysResponse);
    }

    public static CloudReplay$ListReplaysResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addReplays(int i, CloudReplay$ReplayInfo cloudReplay$ReplayInfo) {
        cloudReplay$ReplayInfo.getClass();
        ensureReplaysIsMutable();
        this.replays_.add(i, cloudReplay$ReplayInfo);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(byte[] bArr) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(InputStream inputStream) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CloudReplay$ListReplaysResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CloudReplay$ListReplaysResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
