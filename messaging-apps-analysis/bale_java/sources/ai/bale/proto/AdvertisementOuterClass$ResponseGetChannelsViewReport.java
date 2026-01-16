package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5415Jg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetChannelsViewReport extends GeneratedMessageLite implements U64 {
    public static final int CHANNELS_VIEW_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetChannelsViewReport DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j channelsView_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetChannelsViewReport.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetChannelsViewReport advertisementOuterClass$ResponseGetChannelsViewReport = new AdvertisementOuterClass$ResponseGetChannelsViewReport();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetChannelsViewReport;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetChannelsViewReport.class, advertisementOuterClass$ResponseGetChannelsViewReport);
    }

    private AdvertisementOuterClass$ResponseGetChannelsViewReport() {
    }

    private void addAllChannelsView(Iterable<? extends AdvertisementStruct$ChannelsView> iterable) {
        ensureChannelsViewIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.channelsView_);
    }

    private void addChannelsView(AdvertisementStruct$ChannelsView advertisementStruct$ChannelsView) {
        advertisementStruct$ChannelsView.getClass();
        ensureChannelsViewIsMutable();
        this.channelsView_.add(advertisementStruct$ChannelsView);
    }

    private void clearChannelsView() {
        this.channelsView_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureChannelsViewIsMutable() {
        B.j jVar = this.channelsView_;
        if (jVar.u()) {
            return;
        }
        this.channelsView_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeChannelsView(int i) {
        ensureChannelsViewIsMutable();
        this.channelsView_.remove(i);
    }

    private void setChannelsView(int i, AdvertisementStruct$ChannelsView advertisementStruct$ChannelsView) {
        advertisementStruct$ChannelsView.getClass();
        ensureChannelsViewIsMutable();
        this.channelsView_.set(i, advertisementStruct$ChannelsView);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetChannelsViewReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"channelsView_", AdvertisementStruct$ChannelsView.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetChannelsViewReport.class) {
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

    public AdvertisementStruct$ChannelsView getChannelsView(int i) {
        return (AdvertisementStruct$ChannelsView) this.channelsView_.get(i);
    }

    public int getChannelsViewCount() {
        return this.channelsView_.size();
    }

    public List<AdvertisementStruct$ChannelsView> getChannelsViewList() {
        return this.channelsView_;
    }

    public InterfaceC5415Jg getChannelsViewOrBuilder(int i) {
        return (InterfaceC5415Jg) this.channelsView_.get(i);
    }

    public List<? extends InterfaceC5415Jg> getChannelsViewOrBuilderList() {
        return this.channelsView_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetChannelsViewReport advertisementOuterClass$ResponseGetChannelsViewReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetChannelsViewReport);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addChannelsView(int i, AdvertisementStruct$ChannelsView advertisementStruct$ChannelsView) {
        advertisementStruct$ChannelsView.getClass();
        ensureChannelsViewIsMutable();
        this.channelsView_.add(i, advertisementStruct$ChannelsView);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetChannelsViewReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelsViewReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
