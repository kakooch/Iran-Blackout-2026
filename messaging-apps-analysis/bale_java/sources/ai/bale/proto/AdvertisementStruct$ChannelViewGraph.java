package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4713Gg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$ChannelViewGraph extends GeneratedMessageLite implements InterfaceC4713Gg {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$ChannelViewGraph DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VIEW_FIELD_NUMBER = 2;
    private long date_;
    private long view_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4713Gg {
        private a() {
            super(AdvertisementStruct$ChannelViewGraph.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ChannelViewGraph advertisementStruct$ChannelViewGraph = new AdvertisementStruct$ChannelViewGraph();
        DEFAULT_INSTANCE = advertisementStruct$ChannelViewGraph;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ChannelViewGraph.class, advertisementStruct$ChannelViewGraph);
    }

    private AdvertisementStruct$ChannelViewGraph() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearView() {
        this.view_ = 0L;
    }

    public static AdvertisementStruct$ChannelViewGraph getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$ChannelViewGraph parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setView(long j) {
        this.view_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ChannelViewGraph();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"date_", "view_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ChannelViewGraph.class) {
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

    public long getDate() {
        return this.date_;
    }

    public long getView() {
        return this.view_;
    }

    public static a newBuilder(AdvertisementStruct$ChannelViewGraph advertisementStruct$ChannelViewGraph) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ChannelViewGraph);
    }

    public static AdvertisementStruct$ChannelViewGraph parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ChannelViewGraph parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ChannelViewGraph) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
