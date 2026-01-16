package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$Pagination;

@Deprecated
/* loaded from: classes8.dex */
public final class LivekitSip$ListSIPTrunkRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$ListSIPTrunkRequest DEFAULT_INSTANCE;
    public static final int PAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private LivekitModels$Pagination page_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$ListSIPTrunkRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$ListSIPTrunkRequest livekitSip$ListSIPTrunkRequest = new LivekitSip$ListSIPTrunkRequest();
        DEFAULT_INSTANCE = livekitSip$ListSIPTrunkRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$ListSIPTrunkRequest.class, livekitSip$ListSIPTrunkRequest);
    }

    private LivekitSip$ListSIPTrunkRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPage() {
        this.page_ = null;
    }

    public static LivekitSip$ListSIPTrunkRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePage(LivekitModels$Pagination livekitModels$Pagination) {
        livekitModels$Pagination.getClass();
        LivekitModels$Pagination livekitModels$Pagination2 = this.page_;
        if (livekitModels$Pagination2 == null || livekitModels$Pagination2 == LivekitModels$Pagination.getDefaultInstance()) {
            this.page_ = livekitModels$Pagination;
        } else {
            this.page_ = (LivekitModels$Pagination) ((LivekitModels$Pagination.a) LivekitModels$Pagination.newBuilder(this.page_).v(livekitModels$Pagination)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$ListSIPTrunkRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPage(LivekitModels$Pagination livekitModels$Pagination) {
        livekitModels$Pagination.getClass();
        this.page_ = livekitModels$Pagination;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$ListSIPTrunkRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"page_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$ListSIPTrunkRequest.class) {
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

    public LivekitModels$Pagination getPage() {
        LivekitModels$Pagination livekitModels$Pagination = this.page_;
        return livekitModels$Pagination == null ? LivekitModels$Pagination.getDefaultInstance() : livekitModels$Pagination;
    }

    public boolean hasPage() {
        return this.page_ != null;
    }

    public static a newBuilder(LivekitSip$ListSIPTrunkRequest livekitSip$ListSIPTrunkRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$ListSIPTrunkRequest);
    }

    public static LivekitSip$ListSIPTrunkRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(byte[] bArr) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$ListSIPTrunkRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$ListSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
