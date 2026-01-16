package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.InterfaceC15233jE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$AgentSecret extends GeneratedMessageLite implements InterfaceC15233jE3 {
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    private static final LivekitCloudAgent$AgentSecret DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int UPDATED_AT_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 2;
    private Timestamp createdAt_;
    private Timestamp updatedAt_;
    private String name_ = "";
    private AbstractC2383g value_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15233jE3 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$AgentSecret.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$AgentSecret livekitCloudAgent$AgentSecret = new LivekitCloudAgent$AgentSecret();
        DEFAULT_INSTANCE = livekitCloudAgent$AgentSecret;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$AgentSecret.class, livekitCloudAgent$AgentSecret);
    }

    private LivekitCloudAgent$AgentSecret() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAt() {
        this.createdAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdatedAt() {
        this.updatedAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static LivekitCloudAgent$AgentSecret getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCreatedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.createdAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.createdAt_ = timestamp;
        } else {
            this.createdAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.createdAt_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdatedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.updatedAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.updatedAt_ = timestamp;
        } else {
            this.updatedAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.updatedAt_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$AgentSecret parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreatedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.createdAt_ = timestamp;
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
    public void setUpdatedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.updatedAt_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.value_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$AgentSecret();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\t\u0004\t", new Object[]{"name_", "value_", "createdAt_", "updatedAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$AgentSecret.class) {
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

    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public AbstractC2383g getValue() {
        return this.value_;
    }

    public boolean hasCreatedAt() {
        return this.createdAt_ != null;
    }

    public boolean hasUpdatedAt() {
        return this.updatedAt_ != null;
    }

    public static a newBuilder(LivekitCloudAgent$AgentSecret livekitCloudAgent$AgentSecret) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$AgentSecret);
    }

    public static LivekitCloudAgent$AgentSecret parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$AgentSecret parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$AgentSecret) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
