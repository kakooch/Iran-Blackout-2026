package ai.bale.proto;

import ai.bale.proto.VitrineStruct$MyBankItemPayload;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.LZ7;
import ir.nasim.MZ7;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineStruct$MyBankItem extends GeneratedMessageLite implements MZ7 {
    public static final int ACTION_FIELD_NUMBER = 4;
    public static final int BADGE_FIELD_NUMBER = 3;
    public static final int BLINKBADGE_FIELD_NUMBER = 8;
    private static final VitrineStruct$MyBankItem DEFAULT_INSTANCE;
    public static final int ICON_FIELD_NUMBER = 2;
    public static final int ISDISABLE_FIELD_NUMBER = 9;
    public static final int MAXAPPVERSION_FIELD_NUMBER = 7;
    public static final int MESSAGE_FIELD_NUMBER = 10;
    public static final int MINAPPVERSION_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 1;
    private int action_;
    private int bitField0_;
    private boolean blinkBadge_;
    private boolean isDisable_;
    private int maxAppVersion_;
    private int minAppVersion_;
    private VitrineStruct$MyBankItemPayload payload_;
    private String title_ = "";
    private String icon_ = "";
    private String badge_ = "";
    private String message_ = "";

    public static final class a extends GeneratedMessageLite.b implements MZ7 {
        private a() {
            super(VitrineStruct$MyBankItem.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineStruct$MyBankItem vitrineStruct$MyBankItem = new VitrineStruct$MyBankItem();
        DEFAULT_INSTANCE = vitrineStruct$MyBankItem;
        GeneratedMessageLite.registerDefaultInstance(VitrineStruct$MyBankItem.class, vitrineStruct$MyBankItem);
    }

    private VitrineStruct$MyBankItem() {
    }

    private void clearAction() {
        this.action_ = 0;
    }

    private void clearBadge() {
        this.badge_ = getDefaultInstance().getBadge();
    }

    private void clearBlinkBadge() {
        this.blinkBadge_ = false;
    }

    private void clearIcon() {
        this.icon_ = getDefaultInstance().getIcon();
    }

    private void clearIsDisable() {
        this.isDisable_ = false;
    }

    private void clearMaxAppVersion() {
        this.maxAppVersion_ = 0;
    }

    private void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    private void clearMinAppVersion() {
        this.minAppVersion_ = 0;
    }

    private void clearPayload() {
        this.payload_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static VitrineStruct$MyBankItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePayload(VitrineStruct$MyBankItemPayload vitrineStruct$MyBankItemPayload) {
        vitrineStruct$MyBankItemPayload.getClass();
        VitrineStruct$MyBankItemPayload vitrineStruct$MyBankItemPayload2 = this.payload_;
        if (vitrineStruct$MyBankItemPayload2 == null || vitrineStruct$MyBankItemPayload2 == VitrineStruct$MyBankItemPayload.getDefaultInstance()) {
            this.payload_ = vitrineStruct$MyBankItemPayload;
        } else {
            this.payload_ = (VitrineStruct$MyBankItemPayload) ((VitrineStruct$MyBankItemPayload.a) VitrineStruct$MyBankItemPayload.newBuilder(this.payload_).v(vitrineStruct$MyBankItemPayload)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineStruct$MyBankItem parseDelimitedFrom(InputStream inputStream) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineStruct$MyBankItem parseFrom(ByteBuffer byteBuffer) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(LZ7 lz7) {
        this.action_ = lz7.getNumber();
    }

    private void setActionValue(int i) {
        this.action_ = i;
    }

    private void setBadge(String str) {
        str.getClass();
        this.badge_ = str;
    }

    private void setBadgeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.badge_ = abstractC2383g.f0();
    }

    private void setBlinkBadge(boolean z) {
        this.blinkBadge_ = z;
    }

    private void setIcon(String str) {
        str.getClass();
        this.icon_ = str;
    }

    private void setIconBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.icon_ = abstractC2383g.f0();
    }

    private void setIsDisable(boolean z) {
        this.isDisable_ = z;
    }

    private void setMaxAppVersion(int i) {
        this.maxAppVersion_ = i;
    }

    private void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    private void setMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.message_ = abstractC2383g.f0();
    }

    private void setMinAppVersion(int i) {
        this.minAppVersion_ = i;
    }

    private void setPayload(VitrineStruct$MyBankItemPayload vitrineStruct$MyBankItemPayload) {
        vitrineStruct$MyBankItemPayload.getClass();
        this.payload_ = vitrineStruct$MyBankItemPayload;
        this.bitField0_ |= 1;
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
        switch (t2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineStruct$MyBankItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0005ဉ\u0000\u0006\u0004\u0007\u0004\b\u0007\t\u0007\nȈ", new Object[]{"bitField0_", "title_", "icon_", "badge_", "action_", "payload_", "minAppVersion_", "maxAppVersion_", "blinkBadge_", "isDisable_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineStruct$MyBankItem.class) {
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

    public LZ7 getAction() {
        LZ7 lz7J = LZ7.j(this.action_);
        return lz7J == null ? LZ7.UNRECOGNIZED : lz7J;
    }

    public int getActionValue() {
        return this.action_;
    }

    public String getBadge() {
        return this.badge_;
    }

    public AbstractC2383g getBadgeBytes() {
        return AbstractC2383g.N(this.badge_);
    }

    public boolean getBlinkBadge() {
        return this.blinkBadge_;
    }

    public String getIcon() {
        return this.icon_;
    }

    public AbstractC2383g getIconBytes() {
        return AbstractC2383g.N(this.icon_);
    }

    public boolean getIsDisable() {
        return this.isDisable_;
    }

    public int getMaxAppVersion() {
        return this.maxAppVersion_;
    }

    public String getMessage() {
        return this.message_;
    }

    public AbstractC2383g getMessageBytes() {
        return AbstractC2383g.N(this.message_);
    }

    public int getMinAppVersion() {
        return this.minAppVersion_;
    }

    public VitrineStruct$MyBankItemPayload getPayload() {
        VitrineStruct$MyBankItemPayload vitrineStruct$MyBankItemPayload = this.payload_;
        return vitrineStruct$MyBankItemPayload == null ? VitrineStruct$MyBankItemPayload.getDefaultInstance() : vitrineStruct$MyBankItemPayload;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasPayload() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineStruct$MyBankItem vitrineStruct$MyBankItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineStruct$MyBankItem);
    }

    public static VitrineStruct$MyBankItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineStruct$MyBankItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineStruct$MyBankItem parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineStruct$MyBankItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineStruct$MyBankItem parseFrom(byte[] bArr) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineStruct$MyBankItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineStruct$MyBankItem parseFrom(InputStream inputStream) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineStruct$MyBankItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineStruct$MyBankItem parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineStruct$MyBankItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineStruct$MyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
