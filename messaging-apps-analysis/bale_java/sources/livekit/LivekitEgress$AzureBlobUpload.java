package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitEgress$AzureBlobUpload extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_KEY_FIELD_NUMBER = 2;
    public static final int ACCOUNT_NAME_FIELD_NUMBER = 1;
    public static final int CONTAINER_NAME_FIELD_NUMBER = 3;
    private static final LivekitEgress$AzureBlobUpload DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String accountName_ = "";
    private String accountKey_ = "";
    private String containerName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$AzureBlobUpload.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$AzureBlobUpload livekitEgress$AzureBlobUpload = new LivekitEgress$AzureBlobUpload();
        DEFAULT_INSTANCE = livekitEgress$AzureBlobUpload;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$AzureBlobUpload.class, livekitEgress$AzureBlobUpload);
    }

    private LivekitEgress$AzureBlobUpload() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccountKey() {
        this.accountKey_ = getDefaultInstance().getAccountKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccountName() {
        this.accountName_ = getDefaultInstance().getAccountName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContainerName() {
        this.containerName_ = getDefaultInstance().getContainerName();
    }

    public static LivekitEgress$AzureBlobUpload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$AzureBlobUpload parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccountKey(String str) {
        str.getClass();
        this.accountKey_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccountKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accountKey_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccountName(String str) {
        str.getClass();
        this.accountName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccountNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accountName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContainerName(String str) {
        str.getClass();
        this.containerName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContainerNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.containerName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$AzureBlobUpload();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"accountName_", "accountKey_", "containerName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$AzureBlobUpload.class) {
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

    public String getAccountKey() {
        return this.accountKey_;
    }

    public AbstractC2383g getAccountKeyBytes() {
        return AbstractC2383g.N(this.accountKey_);
    }

    public String getAccountName() {
        return this.accountName_;
    }

    public AbstractC2383g getAccountNameBytes() {
        return AbstractC2383g.N(this.accountName_);
    }

    public String getContainerName() {
        return this.containerName_;
    }

    public AbstractC2383g getContainerNameBytes() {
        return AbstractC2383g.N(this.containerName_);
    }

    public static a newBuilder(LivekitEgress$AzureBlobUpload livekitEgress$AzureBlobUpload) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$AzureBlobUpload);
    }

    public static LivekitEgress$AzureBlobUpload parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(byte[] bArr) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(InputStream inputStream) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$AzureBlobUpload parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$AzureBlobUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
