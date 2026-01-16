package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.W96;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirStruct$SafirBots extends GeneratedMessageLite implements W96 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    public static final int CONTACTS_COUNT_LIMIT_FIELD_NUMBER = 11;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final SafirStruct$SafirBots DEFAULT_INSTANCE;
    public static final int ENABLE_CONTACTS_LIMIT_FIELD_NUMBER = 10;
    public static final int IS_REMOVED_FIELD_NUMBER = 5;
    public static final int MESSAGE_PER_SECOND_RATE_FIELD_NUMBER = 6;
    public static final int MIN_CREDIT_THRESHOLD_FIELD_NUMBER = 7;
    public static final int PANEL_MESSAGE_PHONE_LIMIT_FIELD_NUMBER = 9;
    public static final int PANEL_MESSAGE_PRICE_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 3;
    private int botId_;
    private long contactsCountLimit_;
    private long createdAt_;
    private boolean enableContactsLimit_;
    private boolean isRemoved_;
    private long messagePerSecondRate_;
    private long minCreditThreshold_;
    private long panelMessagePhoneLimit_;
    private long panelMessagePrice_;
    private long price_;

    public static final class a extends GeneratedMessageLite.b implements W96 {
        private a() {
            super(SafirStruct$SafirBots.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirStruct$SafirBots safirStruct$SafirBots = new SafirStruct$SafirBots();
        DEFAULT_INSTANCE = safirStruct$SafirBots;
        GeneratedMessageLite.registerDefaultInstance(SafirStruct$SafirBots.class, safirStruct$SafirBots);
    }

    private SafirStruct$SafirBots() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearContactsCountLimit() {
        this.contactsCountLimit_ = 0L;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearEnableContactsLimit() {
        this.enableContactsLimit_ = false;
    }

    private void clearIsRemoved() {
        this.isRemoved_ = false;
    }

    private void clearMessagePerSecondRate() {
        this.messagePerSecondRate_ = 0L;
    }

    private void clearMinCreditThreshold() {
        this.minCreditThreshold_ = 0L;
    }

    private void clearPanelMessagePhoneLimit() {
        this.panelMessagePhoneLimit_ = 0L;
    }

    private void clearPanelMessagePrice() {
        this.panelMessagePrice_ = 0L;
    }

    private void clearPrice() {
        this.price_ = 0L;
    }

    public static SafirStruct$SafirBots getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirStruct$SafirBots parseDelimitedFrom(InputStream inputStream) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$SafirBots parseFrom(ByteBuffer byteBuffer) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setContactsCountLimit(long j) {
        this.contactsCountLimit_ = j;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setEnableContactsLimit(boolean z) {
        this.enableContactsLimit_ = z;
    }

    private void setIsRemoved(boolean z) {
        this.isRemoved_ = z;
    }

    private void setMessagePerSecondRate(long j) {
        this.messagePerSecondRate_ = j;
    }

    private void setMinCreditThreshold(long j) {
        this.minCreditThreshold_ = j;
    }

    private void setPanelMessagePhoneLimit(long j) {
        this.panelMessagePhoneLimit_ = j;
    }

    private void setPanelMessagePrice(long j) {
        this.panelMessagePrice_ = j;
    }

    private void setPrice(long j) {
        this.price_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G1.a[gVar.ordinal()]) {
            case 1:
                return new SafirStruct$SafirBots();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002\u0005\u0007\u0006\u0002\u0007\u0002\b\u0002\t\u0002\n\u0007\u000b\u0002", new Object[]{"botId_", "createdAt_", "price_", "isRemoved_", "messagePerSecondRate_", "minCreditThreshold_", "panelMessagePrice_", "panelMessagePhoneLimit_", "enableContactsLimit_", "contactsCountLimit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirStruct$SafirBots.class) {
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

    public int getBotId() {
        return this.botId_;
    }

    public long getContactsCountLimit() {
        return this.contactsCountLimit_;
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public boolean getEnableContactsLimit() {
        return this.enableContactsLimit_;
    }

    public boolean getIsRemoved() {
        return this.isRemoved_;
    }

    public long getMessagePerSecondRate() {
        return this.messagePerSecondRate_;
    }

    public long getMinCreditThreshold() {
        return this.minCreditThreshold_;
    }

    public long getPanelMessagePhoneLimit() {
        return this.panelMessagePhoneLimit_;
    }

    public long getPanelMessagePrice() {
        return this.panelMessagePrice_;
    }

    public long getPrice() {
        return this.price_;
    }

    public static a newBuilder(SafirStruct$SafirBots safirStruct$SafirBots) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirStruct$SafirBots);
    }

    public static SafirStruct$SafirBots parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$SafirBots parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirStruct$SafirBots parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirStruct$SafirBots parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirStruct$SafirBots parseFrom(byte[] bArr) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirStruct$SafirBots parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirStruct$SafirBots parseFrom(InputStream inputStream) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$SafirBots parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$SafirBots parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirStruct$SafirBots parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirStruct$SafirBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
