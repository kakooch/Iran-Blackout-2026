package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketAction;
import ai.bale.proto.MarketStruct$MarketMenuItemDialog;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.NT3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketMenuItem extends GeneratedMessageLite implements NT3 {
    public static final int ACTION_FIELD_NUMBER = 2;
    public static final int BADGE_FIELD_NUMBER = 5;
    private static final MarketStruct$MarketMenuItem DEFAULT_INSTANCE;
    public static final int DIALOG_FIELD_NUMBER = 4;
    public static final int DRAWABLEID_FIELD_NUMBER = 3;
    public static final int ISDISABLE_FIELD_NUMBER = 6;
    public static final int MAXAPPVERSION_FIELD_NUMBER = 9;
    public static final int MINAPPVERSION_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 7;
    private MarketStruct$MarketAction action_;
    private int bitField0_;
    private MarketStruct$MarketMenuItemDialog dialog_;
    private boolean isDisable_;
    private int maxAppVersion_;
    private int minAppVersion_;
    private String title_ = "";
    private String drawableId_ = "";
    private String badge_ = "";
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements NT3 {
        private a() {
            super(MarketStruct$MarketMenuItem.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketMenuItem marketStruct$MarketMenuItem = new MarketStruct$MarketMenuItem();
        DEFAULT_INSTANCE = marketStruct$MarketMenuItem;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketMenuItem.class, marketStruct$MarketMenuItem);
    }

    private MarketStruct$MarketMenuItem() {
    }

    private void clearAction() {
        this.action_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBadge() {
        this.badge_ = getDefaultInstance().getBadge();
    }

    private void clearDialog() {
        this.dialog_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDrawableId() {
        this.drawableId_ = getDefaultInstance().getDrawableId();
    }

    private void clearIsDisable() {
        this.isDisable_ = false;
    }

    private void clearMaxAppVersion() {
        this.maxAppVersion_ = 0;
    }

    private void clearMinAppVersion() {
        this.minAppVersion_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static MarketStruct$MarketMenuItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAction(MarketStruct$MarketAction marketStruct$MarketAction) {
        marketStruct$MarketAction.getClass();
        MarketStruct$MarketAction marketStruct$MarketAction2 = this.action_;
        if (marketStruct$MarketAction2 == null || marketStruct$MarketAction2 == MarketStruct$MarketAction.getDefaultInstance()) {
            this.action_ = marketStruct$MarketAction;
        } else {
            this.action_ = (MarketStruct$MarketAction) ((MarketStruct$MarketAction.a) MarketStruct$MarketAction.newBuilder(this.action_).v(marketStruct$MarketAction)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeDialog(MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog) {
        marketStruct$MarketMenuItemDialog.getClass();
        MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog2 = this.dialog_;
        if (marketStruct$MarketMenuItemDialog2 == null || marketStruct$MarketMenuItemDialog2 == MarketStruct$MarketMenuItemDialog.getDefaultInstance()) {
            this.dialog_ = marketStruct$MarketMenuItemDialog;
        } else {
            this.dialog_ = (MarketStruct$MarketMenuItemDialog) ((MarketStruct$MarketMenuItemDialog.a) MarketStruct$MarketMenuItemDialog.newBuilder(this.dialog_).v(marketStruct$MarketMenuItemDialog)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketMenuItem parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketMenuItem parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(MarketStruct$MarketAction marketStruct$MarketAction) {
        marketStruct$MarketAction.getClass();
        this.action_ = marketStruct$MarketAction;
        this.bitField0_ |= 1;
    }

    private void setBadge(String str) {
        str.getClass();
        this.badge_ = str;
    }

    private void setBadgeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.badge_ = abstractC2383g.f0();
    }

    private void setDialog(MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog) {
        marketStruct$MarketMenuItemDialog.getClass();
        this.dialog_ = marketStruct$MarketMenuItemDialog;
        this.bitField0_ |= 2;
    }

    private void setDrawableId(String str) {
        str.getClass();
        this.drawableId_ = str;
    }

    private void setDrawableIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.drawableId_ = abstractC2383g.f0();
    }

    private void setIsDisable(boolean z) {
        this.isDisable_ = z;
    }

    private void setMaxAppVersion(int i) {
        this.maxAppVersion_ = i;
    }

    private void setMinAppVersion(int i) {
        this.minAppVersion_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketMenuItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003Ȉ\u0004ဉ\u0001\u0005Ȉ\u0006\u0007\u0007Ȉ\b\u0004\t\u0004", new Object[]{"bitField0_", "title_", "action_", "drawableId_", "dialog_", "badge_", "isDisable_", "url_", "minAppVersion_", "maxAppVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketMenuItem.class) {
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

    public MarketStruct$MarketAction getAction() {
        MarketStruct$MarketAction marketStruct$MarketAction = this.action_;
        return marketStruct$MarketAction == null ? MarketStruct$MarketAction.getDefaultInstance() : marketStruct$MarketAction;
    }

    public String getBadge() {
        return this.badge_;
    }

    public AbstractC2383g getBadgeBytes() {
        return AbstractC2383g.N(this.badge_);
    }

    public MarketStruct$MarketMenuItemDialog getDialog() {
        MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog = this.dialog_;
        return marketStruct$MarketMenuItemDialog == null ? MarketStruct$MarketMenuItemDialog.getDefaultInstance() : marketStruct$MarketMenuItemDialog;
    }

    public String getDrawableId() {
        return this.drawableId_;
    }

    public AbstractC2383g getDrawableIdBytes() {
        return AbstractC2383g.N(this.drawableId_);
    }

    public boolean getIsDisable() {
        return this.isDisable_;
    }

    public int getMaxAppVersion() {
        return this.maxAppVersion_;
    }

    public int getMinAppVersion() {
        return this.minAppVersion_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasAction() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDialog() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MarketStruct$MarketMenuItem marketStruct$MarketMenuItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketMenuItem);
    }

    public static MarketStruct$MarketMenuItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketMenuItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketMenuItem parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$MarketMenuItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketMenuItem parseFrom(byte[] bArr) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketMenuItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketMenuItem parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketMenuItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketMenuItem parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketMenuItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketMenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
