package ai.bale.proto;

import ai.bale.proto.VitrineOuterClass$VitrineItem;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineOuterClass$RequestAddItemToVitrinePanel extends GeneratedMessageLite implements U64 {
    private static final VitrineOuterClass$RequestAddItemToVitrinePanel DEFAULT_INSTANCE;
    public static final int ITEM_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SECTION_TITLE_FIELD_NUMBER = 3;
    public static final int VITRINE_TITLE_FIELD_NUMBER = 2;
    private int bitField0_;
    private VitrineOuterClass$VitrineItem item_;
    private String vitrineTitle_ = "";
    private String sectionTitle_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$RequestAddItemToVitrinePanel.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$RequestAddItemToVitrinePanel vitrineOuterClass$RequestAddItemToVitrinePanel = new VitrineOuterClass$RequestAddItemToVitrinePanel();
        DEFAULT_INSTANCE = vitrineOuterClass$RequestAddItemToVitrinePanel;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$RequestAddItemToVitrinePanel.class, vitrineOuterClass$RequestAddItemToVitrinePanel);
    }

    private VitrineOuterClass$RequestAddItemToVitrinePanel() {
    }

    private void clearItem() {
        this.item_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSectionTitle() {
        this.sectionTitle_ = getDefaultInstance().getSectionTitle();
    }

    private void clearVitrineTitle() {
        this.vitrineTitle_ = getDefaultInstance().getVitrineTitle();
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeItem(VitrineOuterClass$VitrineItem vitrineOuterClass$VitrineItem) {
        vitrineOuterClass$VitrineItem.getClass();
        VitrineOuterClass$VitrineItem vitrineOuterClass$VitrineItem2 = this.item_;
        if (vitrineOuterClass$VitrineItem2 == null || vitrineOuterClass$VitrineItem2 == VitrineOuterClass$VitrineItem.getDefaultInstance()) {
            this.item_ = vitrineOuterClass$VitrineItem;
        } else {
            this.item_ = (VitrineOuterClass$VitrineItem) ((VitrineOuterClass$VitrineItem.a) VitrineOuterClass$VitrineItem.newBuilder(this.item_).v(vitrineOuterClass$VitrineItem)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setItem(VitrineOuterClass$VitrineItem vitrineOuterClass$VitrineItem) {
        vitrineOuterClass$VitrineItem.getClass();
        this.item_ = vitrineOuterClass$VitrineItem;
        this.bitField0_ |= 1;
    }

    private void setSectionTitle(String str) {
        str.getClass();
        this.sectionTitle_ = str;
    }

    private void setSectionTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sectionTitle_ = abstractC2383g.f0();
    }

    private void setVitrineTitle(String str) {
        str.getClass();
        this.vitrineTitle_ = str;
    }

    private void setVitrineTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.vitrineTitle_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$RequestAddItemToVitrinePanel();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003Ȉ", new Object[]{"bitField0_", "item_", "vitrineTitle_", "sectionTitle_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$RequestAddItemToVitrinePanel.class) {
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

    public VitrineOuterClass$VitrineItem getItem() {
        VitrineOuterClass$VitrineItem vitrineOuterClass$VitrineItem = this.item_;
        return vitrineOuterClass$VitrineItem == null ? VitrineOuterClass$VitrineItem.getDefaultInstance() : vitrineOuterClass$VitrineItem;
    }

    public String getSectionTitle() {
        return this.sectionTitle_;
    }

    public AbstractC2383g getSectionTitleBytes() {
        return AbstractC2383g.N(this.sectionTitle_);
    }

    public String getVitrineTitle() {
        return this.vitrineTitle_;
    }

    public AbstractC2383g getVitrineTitleBytes() {
        return AbstractC2383g.N(this.vitrineTitle_);
    }

    public boolean hasItem() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineOuterClass$RequestAddItemToVitrinePanel vitrineOuterClass$RequestAddItemToVitrinePanel) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$RequestAddItemToVitrinePanel);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(byte[] bArr) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$RequestAddItemToVitrinePanel parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$RequestAddItemToVitrinePanel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
