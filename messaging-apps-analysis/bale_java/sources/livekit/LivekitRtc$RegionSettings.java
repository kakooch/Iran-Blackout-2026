package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17015mF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$RegionSettings extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$RegionSettings DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REGIONS_FIELD_NUMBER = 1;
    private B.j regions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$RegionSettings.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$RegionSettings livekitRtc$RegionSettings = new LivekitRtc$RegionSettings();
        DEFAULT_INSTANCE = livekitRtc$RegionSettings;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$RegionSettings.class, livekitRtc$RegionSettings);
    }

    private LivekitRtc$RegionSettings() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRegions(Iterable<? extends LivekitRtc$RegionInfo> iterable) {
        ensureRegionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.regions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRegions(LivekitRtc$RegionInfo livekitRtc$RegionInfo) {
        livekitRtc$RegionInfo.getClass();
        ensureRegionsIsMutable();
        this.regions_.add(livekitRtc$RegionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegions() {
        this.regions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRegionsIsMutable() {
        B.j jVar = this.regions_;
        if (jVar.u()) {
            return;
        }
        this.regions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$RegionSettings getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$RegionSettings parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RegionSettings parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRegions(int i) {
        ensureRegionsIsMutable();
        this.regions_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegions(int i, LivekitRtc$RegionInfo livekitRtc$RegionInfo) {
        livekitRtc$RegionInfo.getClass();
        ensureRegionsIsMutable();
        this.regions_.set(i, livekitRtc$RegionInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$RegionSettings();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"regions_", LivekitRtc$RegionInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$RegionSettings.class) {
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

    public LivekitRtc$RegionInfo getRegions(int i) {
        return (LivekitRtc$RegionInfo) this.regions_.get(i);
    }

    public int getRegionsCount() {
        return this.regions_.size();
    }

    public List<LivekitRtc$RegionInfo> getRegionsList() {
        return this.regions_;
    }

    public InterfaceC17015mF3 getRegionsOrBuilder(int i) {
        return (InterfaceC17015mF3) this.regions_.get(i);
    }

    public List<? extends InterfaceC17015mF3> getRegionsOrBuilderList() {
        return this.regions_;
    }

    public static a newBuilder(LivekitRtc$RegionSettings livekitRtc$RegionSettings) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$RegionSettings);
    }

    public static LivekitRtc$RegionSettings parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RegionSettings parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$RegionSettings parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRegions(int i, LivekitRtc$RegionInfo livekitRtc$RegionInfo) {
        livekitRtc$RegionInfo.getClass();
        ensureRegionsIsMutable();
        this.regions_.add(i, livekitRtc$RegionInfo);
    }

    public static LivekitRtc$RegionSettings parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$RegionSettings parseFrom(byte[] bArr) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$RegionSettings parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$RegionSettings parseFrom(InputStream inputStream) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RegionSettings parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RegionSettings parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$RegionSettings parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$RegionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
