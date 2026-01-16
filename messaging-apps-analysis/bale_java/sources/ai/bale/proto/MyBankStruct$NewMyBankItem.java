package ai.bale.proto;

import ai.bale.proto.MyBankStruct$NewMyBankItemPayload;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC25146zo4;
import ir.nasim.InterfaceC3366Ao4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MyBankStruct$NewMyBankItem extends GeneratedMessageLite implements InterfaceC3366Ao4 {
    public static final int ACTION_FIELD_NUMBER = 7;
    public static final int ALTER_MESSAGE_FIELD_NUMBER = 12;
    public static final int BADGE_FIELD_NUMBER = 4;
    public static final int BLINK_BADGE_FIELD_NUMBER = 5;
    private static final MyBankStruct$NewMyBankItem DEFAULT_INSTANCE;
    public static final int ICON_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_ADS_FIELD_NUMBER = 6;
    public static final int IS_DEFAULT_FIELD_NUMBER = 13;
    public static final int IS_DISABLED_FIELD_NUMBER = 11;
    public static final int MAX_APP_VERSION_FIELD_NUMBER = 10;
    public static final int MIN_APP_VERSION_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 8;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int action_;
    private int bitField0_;
    private boolean blinkBadge_;
    private int id_;
    private boolean isAds_;
    private boolean isDefault_;
    private boolean isDisabled_;
    private int maxAppVersion_;
    private int minAppVersion_;
    private MyBankStruct$NewMyBankItemPayload payload_;
    private String title_ = "";
    private String icon_ = "";
    private String badge_ = "";
    private String alterMessage_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3366Ao4 {
        private a() {
            super(MyBankStruct$NewMyBankItem.DEFAULT_INSTANCE);
        }
    }

    static {
        MyBankStruct$NewMyBankItem myBankStruct$NewMyBankItem = new MyBankStruct$NewMyBankItem();
        DEFAULT_INSTANCE = myBankStruct$NewMyBankItem;
        GeneratedMessageLite.registerDefaultInstance(MyBankStruct$NewMyBankItem.class, myBankStruct$NewMyBankItem);
    }

    private MyBankStruct$NewMyBankItem() {
    }

    private void clearAction() {
        this.action_ = 0;
    }

    private void clearAlterMessage() {
        this.alterMessage_ = getDefaultInstance().getAlterMessage();
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

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsAds() {
        this.isAds_ = false;
    }

    private void clearIsDefault() {
        this.isDefault_ = false;
    }

    private void clearIsDisabled() {
        this.isDisabled_ = false;
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

    public static MyBankStruct$NewMyBankItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePayload(MyBankStruct$NewMyBankItemPayload myBankStruct$NewMyBankItemPayload) {
        myBankStruct$NewMyBankItemPayload.getClass();
        MyBankStruct$NewMyBankItemPayload myBankStruct$NewMyBankItemPayload2 = this.payload_;
        if (myBankStruct$NewMyBankItemPayload2 == null || myBankStruct$NewMyBankItemPayload2 == MyBankStruct$NewMyBankItemPayload.getDefaultInstance()) {
            this.payload_ = myBankStruct$NewMyBankItemPayload;
        } else {
            this.payload_ = (MyBankStruct$NewMyBankItemPayload) ((MyBankStruct$NewMyBankItemPayload.a) MyBankStruct$NewMyBankItemPayload.newBuilder(this.payload_).v(myBankStruct$NewMyBankItemPayload)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MyBankStruct$NewMyBankItem parseDelimitedFrom(InputStream inputStream) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(ByteBuffer byteBuffer) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(EnumC25146zo4 enumC25146zo4) {
        this.action_ = enumC25146zo4.getNumber();
    }

    private void setActionValue(int i) {
        this.action_ = i;
    }

    private void setAlterMessage(String str) {
        str.getClass();
        this.alterMessage_ = str;
    }

    private void setAlterMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.alterMessage_ = abstractC2383g.f0();
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

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsAds(boolean z) {
        this.isAds_ = z;
    }

    private void setIsDefault(boolean z) {
        this.isDefault_ = z;
    }

    private void setIsDisabled(boolean z) {
        this.isDisabled_ = z;
    }

    private void setMaxAppVersion(int i) {
        this.maxAppVersion_ = i;
    }

    private void setMinAppVersion(int i) {
        this.minAppVersion_ = i;
    }

    private void setPayload(MyBankStruct$NewMyBankItemPayload myBankStruct$NewMyBankItemPayload) {
        myBankStruct$NewMyBankItemPayload.getClass();
        this.payload_ = myBankStruct$NewMyBankItemPayload;
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
        switch (R0.a[gVar.ordinal()]) {
            case 1:
                return new MyBankStruct$NewMyBankItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0001\u0001\r\r\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0007\u0006\u0007\u0007\f\bဉ\u0000\t\u0004\n\u0004\u000b\u0007\fȈ\r\u0007", new Object[]{"bitField0_", "id_", "title_", "icon_", "badge_", "blinkBadge_", "isAds_", "action_", "payload_", "minAppVersion_", "maxAppVersion_", "isDisabled_", "alterMessage_", "isDefault_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MyBankStruct$NewMyBankItem.class) {
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

    public EnumC25146zo4 getAction() {
        EnumC25146zo4 enumC25146zo4J = EnumC25146zo4.j(this.action_);
        return enumC25146zo4J == null ? EnumC25146zo4.UNRECOGNIZED : enumC25146zo4J;
    }

    public int getActionValue() {
        return this.action_;
    }

    public String getAlterMessage() {
        return this.alterMessage_;
    }

    public AbstractC2383g getAlterMessageBytes() {
        return AbstractC2383g.N(this.alterMessage_);
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

    public int getId() {
        return this.id_;
    }

    public boolean getIsAds() {
        return this.isAds_;
    }

    public boolean getIsDefault() {
        return this.isDefault_;
    }

    public boolean getIsDisabled() {
        return this.isDisabled_;
    }

    public int getMaxAppVersion() {
        return this.maxAppVersion_;
    }

    public int getMinAppVersion() {
        return this.minAppVersion_;
    }

    public MyBankStruct$NewMyBankItemPayload getPayload() {
        MyBankStruct$NewMyBankItemPayload myBankStruct$NewMyBankItemPayload = this.payload_;
        return myBankStruct$NewMyBankItemPayload == null ? MyBankStruct$NewMyBankItemPayload.getDefaultInstance() : myBankStruct$NewMyBankItemPayload;
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

    public static a newBuilder(MyBankStruct$NewMyBankItem myBankStruct$NewMyBankItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(myBankStruct$NewMyBankItem);
    }

    public static MyBankStruct$NewMyBankItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(AbstractC2383g abstractC2383g) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(byte[] bArr) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(InputStream inputStream) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(AbstractC2384h abstractC2384h) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MyBankStruct$NewMyBankItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
