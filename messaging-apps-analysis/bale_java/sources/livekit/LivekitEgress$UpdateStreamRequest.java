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
public final class LivekitEgress$UpdateStreamRequest extends GeneratedMessageLite implements U64 {
    public static final int ADD_OUTPUT_URLS_FIELD_NUMBER = 2;
    private static final LivekitEgress$UpdateStreamRequest DEFAULT_INSTANCE;
    public static final int EGRESS_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REMOVE_OUTPUT_URLS_FIELD_NUMBER = 3;
    private String egressId_ = "";
    private B.j addOutputUrls_ = GeneratedMessageLite.emptyProtobufList();
    private B.j removeOutputUrls_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$UpdateStreamRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$UpdateStreamRequest livekitEgress$UpdateStreamRequest = new LivekitEgress$UpdateStreamRequest();
        DEFAULT_INSTANCE = livekitEgress$UpdateStreamRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$UpdateStreamRequest.class, livekitEgress$UpdateStreamRequest);
    }

    private LivekitEgress$UpdateStreamRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAddOutputUrls(String str) {
        str.getClass();
        ensureAddOutputUrlsIsMutable();
        this.addOutputUrls_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAddOutputUrlsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureAddOutputUrlsIsMutable();
        this.addOutputUrls_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAddOutputUrls(Iterable<String> iterable) {
        ensureAddOutputUrlsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.addOutputUrls_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRemoveOutputUrls(Iterable<String> iterable) {
        ensureRemoveOutputUrlsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.removeOutputUrls_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRemoveOutputUrls(String str) {
        str.getClass();
        ensureRemoveOutputUrlsIsMutable();
        this.removeOutputUrls_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRemoveOutputUrlsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureRemoveOutputUrlsIsMutable();
        this.removeOutputUrls_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddOutputUrls() {
        this.addOutputUrls_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgressId() {
        this.egressId_ = getDefaultInstance().getEgressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRemoveOutputUrls() {
        this.removeOutputUrls_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAddOutputUrlsIsMutable() {
        B.j jVar = this.addOutputUrls_;
        if (jVar.u()) {
            return;
        }
        this.addOutputUrls_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureRemoveOutputUrlsIsMutable() {
        B.j jVar = this.removeOutputUrls_;
        if (jVar.u()) {
            return;
        }
        this.removeOutputUrls_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitEgress$UpdateStreamRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$UpdateStreamRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddOutputUrls(int i, String str) {
        str.getClass();
        ensureAddOutputUrlsIsMutable();
        this.addOutputUrls_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressId(String str) {
        str.getClass();
        this.egressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.egressId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemoveOutputUrls(int i, String str) {
        str.getClass();
        ensureRemoveOutputUrlsIsMutable();
        this.removeOutputUrls_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$UpdateStreamRequest();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001Ȉ\u0002Ț\u0003Ț", new Object[]{"egressId_", "addOutputUrls_", "removeOutputUrls_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$UpdateStreamRequest.class) {
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

    public String getAddOutputUrls(int i) {
        return (String) this.addOutputUrls_.get(i);
    }

    public AbstractC2383g getAddOutputUrlsBytes(int i) {
        return AbstractC2383g.N((String) this.addOutputUrls_.get(i));
    }

    public int getAddOutputUrlsCount() {
        return this.addOutputUrls_.size();
    }

    public List<String> getAddOutputUrlsList() {
        return this.addOutputUrls_;
    }

    public String getEgressId() {
        return this.egressId_;
    }

    public AbstractC2383g getEgressIdBytes() {
        return AbstractC2383g.N(this.egressId_);
    }

    public String getRemoveOutputUrls(int i) {
        return (String) this.removeOutputUrls_.get(i);
    }

    public AbstractC2383g getRemoveOutputUrlsBytes(int i) {
        return AbstractC2383g.N((String) this.removeOutputUrls_.get(i));
    }

    public int getRemoveOutputUrlsCount() {
        return this.removeOutputUrls_.size();
    }

    public List<String> getRemoveOutputUrlsList() {
        return this.removeOutputUrls_;
    }

    public static a newBuilder(LivekitEgress$UpdateStreamRequest livekitEgress$UpdateStreamRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$UpdateStreamRequest);
    }

    public static LivekitEgress$UpdateStreamRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(byte[] bArr) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(InputStream inputStream) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$UpdateStreamRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$UpdateStreamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
