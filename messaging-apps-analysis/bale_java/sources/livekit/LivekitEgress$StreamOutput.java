package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC24213yE3;
import ir.nasim.InterfaceC23623xE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitEgress$StreamOutput extends GeneratedMessageLite implements InterfaceC23623xE3 {
    private static final LivekitEgress$StreamOutput DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PROTOCOL_FIELD_NUMBER = 1;
    public static final int URLS_FIELD_NUMBER = 2;
    private int protocol_;
    private B.j urls_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23623xE3 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$StreamOutput.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$StreamOutput livekitEgress$StreamOutput = new LivekitEgress$StreamOutput();
        DEFAULT_INSTANCE = livekitEgress$StreamOutput;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$StreamOutput.class, livekitEgress$StreamOutput);
    }

    private LivekitEgress$StreamOutput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUrls(Iterable<String> iterable) {
        ensureUrlsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.urls_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUrls(String str) {
        str.getClass();
        ensureUrlsIsMutable();
        this.urls_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUrlsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureUrlsIsMutable();
        this.urls_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProtocol() {
        this.protocol_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrls() {
        this.urls_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUrlsIsMutable() {
        B.j jVar = this.urls_;
        if (jVar.u()) {
            return;
        }
        this.urls_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitEgress$StreamOutput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$StreamOutput parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$StreamOutput parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocol(EnumC24213yE3 enumC24213yE3) {
        this.protocol_ = enumC24213yE3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocolValue(int i) {
        this.protocol_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrls(int i, String str) {
        str.getClass();
        ensureUrlsIsMutable();
        this.urls_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$StreamOutput();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002Ț", new Object[]{"protocol_", "urls_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$StreamOutput.class) {
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

    public EnumC24213yE3 getProtocol() {
        EnumC24213yE3 enumC24213yE3J = EnumC24213yE3.j(this.protocol_);
        return enumC24213yE3J == null ? EnumC24213yE3.UNRECOGNIZED : enumC24213yE3J;
    }

    public int getProtocolValue() {
        return this.protocol_;
    }

    public String getUrls(int i) {
        return (String) this.urls_.get(i);
    }

    public AbstractC2383g getUrlsBytes(int i) {
        return AbstractC2383g.N((String) this.urls_.get(i));
    }

    public int getUrlsCount() {
        return this.urls_.size();
    }

    public List<String> getUrlsList() {
        return this.urls_;
    }

    public static a newBuilder(LivekitEgress$StreamOutput livekitEgress$StreamOutput) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$StreamOutput);
    }

    public static LivekitEgress$StreamOutput parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$StreamOutput parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$StreamOutput parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$StreamOutput parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$StreamOutput parseFrom(byte[] bArr) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$StreamOutput parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$StreamOutput parseFrom(InputStream inputStream) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$StreamOutput parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$StreamOutput parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$StreamOutput parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$StreamOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
