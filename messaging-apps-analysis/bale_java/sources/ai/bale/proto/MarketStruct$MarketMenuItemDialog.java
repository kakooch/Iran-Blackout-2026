package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketMenuItemDialog extends GeneratedMessageLite implements U64 {
    private static final MarketStruct$MarketMenuItemDialog DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private String title_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketStruct$MarketMenuItemDialog.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog = new MarketStruct$MarketMenuItemDialog();
        DEFAULT_INSTANCE = marketStruct$MarketMenuItemDialog;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketMenuItemDialog.class, marketStruct$MarketMenuItemDialog);
    }

    private MarketStruct$MarketMenuItemDialog() {
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static MarketStruct$MarketMenuItemDialog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketMenuItemDialog parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketMenuItemDialog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"title_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketMenuItemDialog.class) {
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

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketMenuItemDialog);
    }

    public static MarketStruct$MarketMenuItemDialog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(byte[] bArr) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketMenuItemDialog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketMenuItemDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
