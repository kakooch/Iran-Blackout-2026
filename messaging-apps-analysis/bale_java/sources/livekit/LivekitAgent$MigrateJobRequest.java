package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAgent$MigrateJobRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$MigrateJobRequest DEFAULT_INSTANCE;
    public static final int JOB_IDS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j jobIds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$MigrateJobRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$MigrateJobRequest livekitAgent$MigrateJobRequest = new LivekitAgent$MigrateJobRequest();
        DEFAULT_INSTANCE = livekitAgent$MigrateJobRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$MigrateJobRequest.class, livekitAgent$MigrateJobRequest);
    }

    private LivekitAgent$MigrateJobRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllJobIds(Iterable<String> iterable) {
        ensureJobIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.jobIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addJobIds(String str) {
        str.getClass();
        ensureJobIdsIsMutable();
        this.jobIds_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addJobIdsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureJobIdsIsMutable();
        this.jobIds_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJobIds() {
        this.jobIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureJobIdsIsMutable() {
        B.j jVar = this.jobIds_;
        if (jVar.u()) {
            return;
        }
        this.jobIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAgent$MigrateJobRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$MigrateJobRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobIds(int i, String str) {
        str.getClass();
        ensureJobIdsIsMutable();
        this.jobIds_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$MigrateJobRequest();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002Ț", new Object[]{"jobIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$MigrateJobRequest.class) {
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

    public String getJobIds(int i) {
        return (String) this.jobIds_.get(i);
    }

    public AbstractC2383g getJobIdsBytes(int i) {
        return AbstractC2383g.N((String) this.jobIds_.get(i));
    }

    public int getJobIdsCount() {
        return this.jobIds_.size();
    }

    public List<String> getJobIdsList() {
        return this.jobIds_;
    }

    public static a newBuilder(LivekitAgent$MigrateJobRequest livekitAgent$MigrateJobRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$MigrateJobRequest);
    }

    public static LivekitAgent$MigrateJobRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(byte[] bArr) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(InputStream inputStream) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$MigrateJobRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$MigrateJobRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
