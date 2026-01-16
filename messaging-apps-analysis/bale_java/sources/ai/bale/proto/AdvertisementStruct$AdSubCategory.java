package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6107Mf;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AdSubCategory extends GeneratedMessageLite implements InterfaceC6107Mf {
    private static final AdvertisementStruct$AdSubCategory DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_ACTIVE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int id_;
    private boolean isActive_;
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6107Mf {
        private a() {
            super(AdvertisementStruct$AdSubCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AdSubCategory advertisementStruct$AdSubCategory = new AdvertisementStruct$AdSubCategory();
        DEFAULT_INSTANCE = advertisementStruct$AdSubCategory;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AdSubCategory.class, advertisementStruct$AdSubCategory);
    }

    private AdvertisementStruct$AdSubCategory() {
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsActive() {
        this.isActive_ = false;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static AdvertisementStruct$AdSubCategory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AdSubCategory parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsActive(boolean z) {
        this.isActive_ = z;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AdSubCategory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0007", new Object[]{"id_", "title_", "isActive_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AdSubCategory.class) {
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

    public int getId() {
        return this.id_;
    }

    public boolean getIsActive() {
        return this.isActive_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(AdvertisementStruct$AdSubCategory advertisementStruct$AdSubCategory) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AdSubCategory);
    }

    public static AdvertisementStruct$AdSubCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AdSubCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AdSubCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
