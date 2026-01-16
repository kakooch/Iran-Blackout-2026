package ai.bale.proto;

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

/* loaded from: classes9.dex */
public final class Advertisementnew$ResponseGetAdProviderV2 extends GeneratedMessageLite implements U64 {
    public static final int CONTENT_FIELD_NUMBER = 1;
    private static final Advertisementnew$ResponseGetAdProviderV2 DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j content_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$ResponseGetAdProviderV2.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$ResponseGetAdProviderV2 advertisementnew$ResponseGetAdProviderV2 = new Advertisementnew$ResponseGetAdProviderV2();
        DEFAULT_INSTANCE = advertisementnew$ResponseGetAdProviderV2;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$ResponseGetAdProviderV2.class, advertisementnew$ResponseGetAdProviderV2);
    }

    private Advertisementnew$ResponseGetAdProviderV2() {
    }

    private void addAllContent(Iterable<? extends AdvertisementStruct$AdContent> iterable) {
        ensureContentIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.content_);
    }

    private void addContent(AdvertisementStruct$AdContent advertisementStruct$AdContent) {
        advertisementStruct$AdContent.getClass();
        ensureContentIsMutable();
        this.content_.add(advertisementStruct$AdContent);
    }

    private void clearContent() {
        this.content_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureContentIsMutable() {
        B.j jVar = this.content_;
        if (jVar.u()) {
            return;
        }
        this.content_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeContent(int i) {
        ensureContentIsMutable();
        this.content_.remove(i);
    }

    private void setContent(int i, AdvertisementStruct$AdContent advertisementStruct$AdContent) {
        advertisementStruct$AdContent.getClass();
        ensureContentIsMutable();
        this.content_.set(i, advertisementStruct$AdContent);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$ResponseGetAdProviderV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"content_", AdvertisementStruct$AdContent.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$ResponseGetAdProviderV2.class) {
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

    public AdvertisementStruct$AdContent getContent(int i) {
        return (AdvertisementStruct$AdContent) this.content_.get(i);
    }

    public int getContentCount() {
        return this.content_.size();
    }

    public List<AdvertisementStruct$AdContent> getContentList() {
        return this.content_;
    }

    public InterfaceC1846d getContentOrBuilder(int i) {
        return (InterfaceC1846d) this.content_.get(i);
    }

    public List<? extends InterfaceC1846d> getContentOrBuilderList() {
        return this.content_;
    }

    public static a newBuilder(Advertisementnew$ResponseGetAdProviderV2 advertisementnew$ResponseGetAdProviderV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$ResponseGetAdProviderV2);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addContent(int i, AdvertisementStruct$AdContent advertisementStruct$AdContent) {
        advertisementStruct$AdContent.getClass();
        ensureContentIsMutable();
        this.content_.add(i, advertisementStruct$AdContent);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(byte[] bArr) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$ResponseGetAdProviderV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
