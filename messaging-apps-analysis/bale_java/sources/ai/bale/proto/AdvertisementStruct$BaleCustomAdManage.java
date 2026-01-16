package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10472bg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$BaleCustomAdManage extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$BaleCustomAdManage DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LINK_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PIC_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 6;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int status_;
    private String id_ = "";
    private String pic_ = "";
    private String title_ = "";
    private String description_ = "";
    private String link_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$BaleCustomAdManage.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$BaleCustomAdManage advertisementStruct$BaleCustomAdManage = new AdvertisementStruct$BaleCustomAdManage();
        DEFAULT_INSTANCE = advertisementStruct$BaleCustomAdManage;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$BaleCustomAdManage.class, advertisementStruct$BaleCustomAdManage);
    }

    private AdvertisementStruct$BaleCustomAdManage() {
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearPic() {
        this.pic_ = getDefaultInstance().getPic();
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static AdvertisementStruct$BaleCustomAdManage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$BaleCustomAdManage parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setPic(String str) {
        str.getClass();
        this.pic_ = str;
    }

    private void setPicBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.pic_ = abstractC2383g.f0();
    }

    private void setStatus(EnumC10472bg enumC10472bg) {
        this.status_ = enumC10472bg.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
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
                return new AdvertisementStruct$BaleCustomAdManage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\f", new Object[]{"id_", "pic_", "title_", "description_", "link_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$BaleCustomAdManage.class) {
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

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public String getPic() {
        return this.pic_;
    }

    public AbstractC2383g getPicBytes() {
        return AbstractC2383g.N(this.pic_);
    }

    public EnumC10472bg getStatus() {
        EnumC10472bg enumC10472bgJ = EnumC10472bg.j(this.status_);
        return enumC10472bgJ == null ? EnumC10472bg.UNRECOGNIZED : enumC10472bgJ;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(AdvertisementStruct$BaleCustomAdManage advertisementStruct$BaleCustomAdManage) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$BaleCustomAdManage);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(byte[] bArr) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$BaleCustomAdManage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$BaleCustomAdManage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
