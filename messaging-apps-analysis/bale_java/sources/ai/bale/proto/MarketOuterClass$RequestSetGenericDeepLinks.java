package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23168wT3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestSetGenericDeepLinks extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestSetGenericDeepLinks DEFAULT_INSTANCE;
    public static final int LINKS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j links_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestSetGenericDeepLinks.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestSetGenericDeepLinks marketOuterClass$RequestSetGenericDeepLinks = new MarketOuterClass$RequestSetGenericDeepLinks();
        DEFAULT_INSTANCE = marketOuterClass$RequestSetGenericDeepLinks;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestSetGenericDeepLinks.class, marketOuterClass$RequestSetGenericDeepLinks);
    }

    private MarketOuterClass$RequestSetGenericDeepLinks() {
    }

    private void addAllLinks(Iterable<? extends MarketStruct$GenericDeepLink> iterable) {
        ensureLinksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.links_);
    }

    private void addLinks(MarketStruct$GenericDeepLink marketStruct$GenericDeepLink) {
        marketStruct$GenericDeepLink.getClass();
        ensureLinksIsMutable();
        this.links_.add(marketStruct$GenericDeepLink);
    }

    private void clearLinks() {
        this.links_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureLinksIsMutable() {
        B.j jVar = this.links_;
        if (jVar.u()) {
            return;
        }
        this.links_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLinks(int i) {
        ensureLinksIsMutable();
        this.links_.remove(i);
    }

    private void setLinks(int i, MarketStruct$GenericDeepLink marketStruct$GenericDeepLink) {
        marketStruct$GenericDeepLink.getClass();
        ensureLinksIsMutable();
        this.links_.set(i, marketStruct$GenericDeepLink);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestSetGenericDeepLinks();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"links_", MarketStruct$GenericDeepLink.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestSetGenericDeepLinks.class) {
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

    public MarketStruct$GenericDeepLink getLinks(int i) {
        return (MarketStruct$GenericDeepLink) this.links_.get(i);
    }

    public int getLinksCount() {
        return this.links_.size();
    }

    public List<MarketStruct$GenericDeepLink> getLinksList() {
        return this.links_;
    }

    public InterfaceC23168wT3 getLinksOrBuilder(int i) {
        return (InterfaceC23168wT3) this.links_.get(i);
    }

    public List<? extends InterfaceC23168wT3> getLinksOrBuilderList() {
        return this.links_;
    }

    public static a newBuilder(MarketOuterClass$RequestSetGenericDeepLinks marketOuterClass$RequestSetGenericDeepLinks) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestSetGenericDeepLinks);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addLinks(int i, MarketStruct$GenericDeepLink marketStruct$GenericDeepLink) {
        marketStruct$GenericDeepLink.getClass();
        ensureLinksIsMutable();
        this.links_.add(i, marketStruct$GenericDeepLink);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestSetGenericDeepLinks parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestSetGenericDeepLinks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
