package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19043ph;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$OnBoardingChannelData extends GeneratedMessageLite implements InterfaceC19043ph {
    private static final AdvertisementStruct$OnBoardingChannelData DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_SELECTED_FIELD_NUMBER = 6;
    public static final int MEMBERS_COUNT_FIELD_NUMBER = 4;
    public static final int NICKNAME_FIELD_NUMBER = 2;
    public static final int ORDER_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int id_;
    private boolean isSelected_;
    private int membersCount_;
    private int order_;
    private String nickname_ = "";
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19043ph {
        private a() {
            super(AdvertisementStruct$OnBoardingChannelData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$OnBoardingChannelData advertisementStruct$OnBoardingChannelData = new AdvertisementStruct$OnBoardingChannelData();
        DEFAULT_INSTANCE = advertisementStruct$OnBoardingChannelData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$OnBoardingChannelData.class, advertisementStruct$OnBoardingChannelData);
    }

    private AdvertisementStruct$OnBoardingChannelData() {
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsSelected() {
        this.isSelected_ = false;
    }

    private void clearMembersCount() {
        this.membersCount_ = 0;
    }

    private void clearNickname() {
        this.nickname_ = getDefaultInstance().getNickname();
    }

    private void clearOrder() {
        this.order_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static AdvertisementStruct$OnBoardingChannelData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$OnBoardingChannelData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsSelected(boolean z) {
        this.isSelected_ = z;
    }

    private void setMembersCount(int i) {
        this.membersCount_ = i;
    }

    private void setNickname(String str) {
        str.getClass();
        this.nickname_ = str;
    }

    private void setNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nickname_ = abstractC2383g.f0();
    }

    private void setOrder(int i) {
        this.order_ = i;
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
                return new AdvertisementStruct$OnBoardingChannelData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004\u0004\u0005\u0004\u0006\u0007", new Object[]{"id_", "nickname_", "title_", "membersCount_", "order_", "isSelected_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$OnBoardingChannelData.class) {
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

    public boolean getIsSelected() {
        return this.isSelected_;
    }

    public int getMembersCount() {
        return this.membersCount_;
    }

    public String getNickname() {
        return this.nickname_;
    }

    public AbstractC2383g getNicknameBytes() {
        return AbstractC2383g.N(this.nickname_);
    }

    public int getOrder() {
        return this.order_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(AdvertisementStruct$OnBoardingChannelData advertisementStruct$OnBoardingChannelData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$OnBoardingChannelData);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$OnBoardingChannelData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$OnBoardingChannelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
