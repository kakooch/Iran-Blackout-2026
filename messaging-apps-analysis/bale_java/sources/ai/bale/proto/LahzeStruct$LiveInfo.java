package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8146Us3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LahzeStruct$LiveInfo extends GeneratedMessageLite implements InterfaceC8146Us3 {
    private static final LahzeStruct$LiveInfo DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 2;
    public static final int HLS_LINK_FIELD_NUMBER = 6;
    public static final int IS_LIVE_FIELD_NUMBER = 4;
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int LINK_FIELD_NUMBER = 5;
    public static final int MAIN_MESSAGE_DATE_FIELD_NUMBER = 9;
    public static final int MAIN_MESSAGE_ID_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int RTMP_LINK_FIELD_NUMBER = 7;
    public static final int USER_COUNT_FIELD_NUMBER = 3;
    private int groupId_;
    private boolean isLive_;
    private long key_;
    private long mainMessageDate_;
    private long mainMessageId_;
    private int userCount_;
    private String link_ = "";
    private String hlsLink_ = "";
    private String rtmpLink_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8146Us3 {
        private a() {
            super(LahzeStruct$LiveInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LahzeStruct$LiveInfo lahzeStruct$LiveInfo = new LahzeStruct$LiveInfo();
        DEFAULT_INSTANCE = lahzeStruct$LiveInfo;
        GeneratedMessageLite.registerDefaultInstance(LahzeStruct$LiveInfo.class, lahzeStruct$LiveInfo);
    }

    private LahzeStruct$LiveInfo() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearHlsLink() {
        this.hlsLink_ = getDefaultInstance().getHlsLink();
    }

    private void clearIsLive() {
        this.isLive_ = false;
    }

    private void clearKey() {
        this.key_ = 0L;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearMainMessageDate() {
        this.mainMessageDate_ = 0L;
    }

    private void clearMainMessageId() {
        this.mainMessageId_ = 0L;
    }

    private void clearRtmpLink() {
        this.rtmpLink_ = getDefaultInstance().getRtmpLink();
    }

    private void clearUserCount() {
        this.userCount_ = 0;
    }

    public static LahzeStruct$LiveInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LahzeStruct$LiveInfo parseDelimitedFrom(InputStream inputStream) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeStruct$LiveInfo parseFrom(ByteBuffer byteBuffer) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setHlsLink(String str) {
        str.getClass();
        this.hlsLink_ = str;
    }

    private void setHlsLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.hlsLink_ = abstractC2383g.f0();
    }

    private void setIsLive(boolean z) {
        this.isLive_ = z;
    }

    private void setKey(long j) {
        this.key_ = j;
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setMainMessageDate(long j) {
        this.mainMessageDate_ = j;
    }

    private void setMainMessageId(long j) {
        this.mainMessageId_ = j;
    }

    private void setRtmpLink(String str) {
        str.getClass();
        this.rtmpLink_ = str;
    }

    private void setRtmpLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.rtmpLink_ = abstractC2383g.f0();
    }

    private void setUserCount(int i) {
        this.userCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1906x0.a[gVar.ordinal()]) {
            case 1:
                return new LahzeStruct$LiveInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003\u0004\u0004\u0007\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0002\t\u0002", new Object[]{"key_", "groupId_", "userCount_", "isLive_", "link_", "hlsLink_", "rtmpLink_", "mainMessageId_", "mainMessageDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LahzeStruct$LiveInfo.class) {
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

    public int getGroupId() {
        return this.groupId_;
    }

    public String getHlsLink() {
        return this.hlsLink_;
    }

    public AbstractC2383g getHlsLinkBytes() {
        return AbstractC2383g.N(this.hlsLink_);
    }

    public boolean getIsLive() {
        return this.isLive_;
    }

    public long getKey() {
        return this.key_;
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public long getMainMessageDate() {
        return this.mainMessageDate_;
    }

    public long getMainMessageId() {
        return this.mainMessageId_;
    }

    public String getRtmpLink() {
        return this.rtmpLink_;
    }

    public AbstractC2383g getRtmpLinkBytes() {
        return AbstractC2383g.N(this.rtmpLink_);
    }

    public int getUserCount() {
        return this.userCount_;
    }

    public static a newBuilder(LahzeStruct$LiveInfo lahzeStruct$LiveInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(lahzeStruct$LiveInfo);
    }

    public static LahzeStruct$LiveInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeStruct$LiveInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LahzeStruct$LiveInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LahzeStruct$LiveInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LahzeStruct$LiveInfo parseFrom(byte[] bArr) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LahzeStruct$LiveInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LahzeStruct$LiveInfo parseFrom(InputStream inputStream) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeStruct$LiveInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeStruct$LiveInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LahzeStruct$LiveInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LahzeStruct$LiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
