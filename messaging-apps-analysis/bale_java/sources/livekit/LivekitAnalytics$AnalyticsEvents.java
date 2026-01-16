package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.ZD3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsEvents extends GeneratedMessageLite implements U64 {
    private static final LivekitAnalytics$AnalyticsEvents DEFAULT_INSTANCE;
    public static final int EVENTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j events_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsEvents.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsEvents livekitAnalytics$AnalyticsEvents = new LivekitAnalytics$AnalyticsEvents();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsEvents;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsEvents.class, livekitAnalytics$AnalyticsEvents);
    }

    private LivekitAnalytics$AnalyticsEvents() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEvents(Iterable<? extends LivekitAnalytics$AnalyticsEvent> iterable) {
        ensureEventsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.events_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEvents(LivekitAnalytics$AnalyticsEvent livekitAnalytics$AnalyticsEvent) {
        livekitAnalytics$AnalyticsEvent.getClass();
        ensureEventsIsMutable();
        this.events_.add(livekitAnalytics$AnalyticsEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEvents() {
        this.events_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureEventsIsMutable() {
        B.j jVar = this.events_;
        if (jVar.u()) {
            return;
        }
        this.events_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAnalytics$AnalyticsEvents getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsEvents parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEvents(int i) {
        ensureEventsIsMutable();
        this.events_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEvents(int i, LivekitAnalytics$AnalyticsEvent livekitAnalytics$AnalyticsEvent) {
        livekitAnalytics$AnalyticsEvent.getClass();
        ensureEventsIsMutable();
        this.events_.set(i, livekitAnalytics$AnalyticsEvent);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsEvents();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"events_", LivekitAnalytics$AnalyticsEvent.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsEvents.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public LivekitAnalytics$AnalyticsEvent getEvents(int i) {
        return (LivekitAnalytics$AnalyticsEvent) this.events_.get(i);
    }

    public int getEventsCount() {
        return this.events_.size();
    }

    public List<LivekitAnalytics$AnalyticsEvent> getEventsList() {
        return this.events_;
    }

    public ZD3 getEventsOrBuilder(int i) {
        return (ZD3) this.events_.get(i);
    }

    public List<? extends ZD3> getEventsOrBuilderList() {
        return this.events_;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsEvents livekitAnalytics$AnalyticsEvents) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsEvents);
    }

    public static LivekitAnalytics$AnalyticsEvents parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEvents(int i, LivekitAnalytics$AnalyticsEvent livekitAnalytics$AnalyticsEvent) {
        livekitAnalytics$AnalyticsEvent.getClass();
        ensureEventsIsMutable();
        this.events_.add(i, livekitAnalytics$AnalyticsEvent);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsEvents parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
