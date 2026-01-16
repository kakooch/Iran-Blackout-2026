package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonActionPayload;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12214eE2;
import ir.nasim.InterfaceC24212yE2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonServiceItem extends GeneratedMessageLite implements InterfaceC24212yE2 {
    public static final int ACTION_FIELD_NUMBER = 5;
    public static final int BADGE_FIELD_NUMBER = 3;
    public static final int CUSTOM_ICON_FIELD_NUMBER = 9;
    private static final GarsonStruct$GarsonServiceItem DEFAULT_INSTANCE;
    public static final int ICON_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MAX_APP_VERSION_FIELD_NUMBER = 8;
    public static final int MIN_APP_VERSION_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 6;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int action_;
    private int bitField0_;
    private int id_;
    private int maxAppVersion_;
    private int minAppVersion_;
    private GarsonStruct$GarsonActionPayload payload_;
    private String title_ = "";
    private String badge_ = "";
    private String icon_ = "";
    private String customIcon_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC24212yE2 {
        private a() {
            super(GarsonStruct$GarsonServiceItem.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem = new GarsonStruct$GarsonServiceItem();
        DEFAULT_INSTANCE = garsonStruct$GarsonServiceItem;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonServiceItem.class, garsonStruct$GarsonServiceItem);
    }

    private GarsonStruct$GarsonServiceItem() {
    }

    private void clearAction() {
        this.action_ = 0;
    }

    private void clearBadge() {
        this.badge_ = getDefaultInstance().getBadge();
    }

    private void clearCustomIcon() {
        this.customIcon_ = getDefaultInstance().getCustomIcon();
    }

    private void clearIcon() {
        this.icon_ = getDefaultInstance().getIcon();
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearMaxAppVersion() {
        this.maxAppVersion_ = 0;
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

    public static GarsonStruct$GarsonServiceItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePayload(GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload) {
        garsonStruct$GarsonActionPayload.getClass();
        GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload2 = this.payload_;
        if (garsonStruct$GarsonActionPayload2 == null || garsonStruct$GarsonActionPayload2 == GarsonStruct$GarsonActionPayload.getDefaultInstance()) {
            this.payload_ = garsonStruct$GarsonActionPayload;
        } else {
            this.payload_ = (GarsonStruct$GarsonActionPayload) ((GarsonStruct$GarsonActionPayload.a) GarsonStruct$GarsonActionPayload.newBuilder(this.payload_).v(garsonStruct$GarsonActionPayload)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonServiceItem parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(EnumC12214eE2 enumC12214eE2) {
        this.action_ = enumC12214eE2.getNumber();
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

    private void setCustomIcon(String str) {
        str.getClass();
        this.customIcon_ = str;
    }

    private void setCustomIconBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.customIcon_ = abstractC2383g.f0();
    }

    private void setIcon(String str) {
        str.getClass();
        this.icon_ = str;
    }

    private void setIconBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.icon_ = abstractC2383g.f0();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setMaxAppVersion(int i) {
        this.maxAppVersion_ = i;
    }

    private void setMinAppVersion(int i) {
        this.minAppVersion_ = i;
    }

    private void setPayload(GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload) {
        garsonStruct$GarsonActionPayload.getClass();
        this.payload_ = garsonStruct$GarsonActionPayload;
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
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonServiceItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f\u0006ဉ\u0000\u0007\u0004\b\u0004\tȈ", new Object[]{"bitField0_", "id_", "title_", "badge_", "icon_", "action_", "payload_", "minAppVersion_", "maxAppVersion_", "customIcon_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonServiceItem.class) {
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

    public EnumC12214eE2 getAction() {
        EnumC12214eE2 enumC12214eE2J = EnumC12214eE2.j(this.action_);
        return enumC12214eE2J == null ? EnumC12214eE2.UNRECOGNIZED : enumC12214eE2J;
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

    public String getCustomIcon() {
        return this.customIcon_;
    }

    public AbstractC2383g getCustomIconBytes() {
        return AbstractC2383g.N(this.customIcon_);
    }

    public String getIcon() {
        return this.icon_;
    }

    public AbstractC2383g getIconBytes() {
        return AbstractC2383g.N(this.icon_);
    }

    public int getId() {
        return this.id_;
    }

    public int getMaxAppVersion() {
        return this.maxAppVersion_;
    }

    public int getMinAppVersion() {
        return this.minAppVersion_;
    }

    public GarsonStruct$GarsonActionPayload getPayload() {
        GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload = this.payload_;
        return garsonStruct$GarsonActionPayload == null ? GarsonStruct$GarsonActionPayload.getDefaultInstance() : garsonStruct$GarsonActionPayload;
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

    public static a newBuilder(GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonServiceItem);
    }

    public static GarsonStruct$GarsonServiceItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonServiceItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonServiceItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
