package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16415lE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$ClientSettingsResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitCloudAgent$ClientSettingsResponse DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j params_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$ClientSettingsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$ClientSettingsResponse livekitCloudAgent$ClientSettingsResponse = new LivekitCloudAgent$ClientSettingsResponse();
        DEFAULT_INSTANCE = livekitCloudAgent$ClientSettingsResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$ClientSettingsResponse.class, livekitCloudAgent$ClientSettingsResponse);
    }

    private LivekitCloudAgent$ClientSettingsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllParams(Iterable<? extends LivekitCloudAgent$SettingsParam> iterable) {
        ensureParamsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.params_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParams(LivekitCloudAgent$SettingsParam livekitCloudAgent$SettingsParam) {
        livekitCloudAgent$SettingsParam.getClass();
        ensureParamsIsMutable();
        this.params_.add(livekitCloudAgent$SettingsParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureParamsIsMutable() {
        B.j jVar = this.params_;
        if (jVar.u()) {
            return;
        }
        this.params_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitCloudAgent$ClientSettingsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParams(int i) {
        ensureParamsIsMutable();
        this.params_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(int i, LivekitCloudAgent$SettingsParam livekitCloudAgent$SettingsParam) {
        livekitCloudAgent$SettingsParam.getClass();
        ensureParamsIsMutable();
        this.params_.set(i, livekitCloudAgent$SettingsParam);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$ClientSettingsResponse();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"params_", LivekitCloudAgent$SettingsParam.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$ClientSettingsResponse.class) {
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

    public LivekitCloudAgent$SettingsParam getParams(int i) {
        return (LivekitCloudAgent$SettingsParam) this.params_.get(i);
    }

    public int getParamsCount() {
        return this.params_.size();
    }

    public List<LivekitCloudAgent$SettingsParam> getParamsList() {
        return this.params_;
    }

    public InterfaceC16415lE3 getParamsOrBuilder(int i) {
        return (InterfaceC16415lE3) this.params_.get(i);
    }

    public List<? extends InterfaceC16415lE3> getParamsOrBuilderList() {
        return this.params_;
    }

    public static a newBuilder(LivekitCloudAgent$ClientSettingsResponse livekitCloudAgent$ClientSettingsResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$ClientSettingsResponse);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParams(int i, LivekitCloudAgent$SettingsParam livekitCloudAgent$SettingsParam) {
        livekitCloudAgent$SettingsParam.getClass();
        ensureParamsIsMutable();
        this.params_.add(i, livekitCloudAgent$SettingsParam);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$ClientSettingsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
