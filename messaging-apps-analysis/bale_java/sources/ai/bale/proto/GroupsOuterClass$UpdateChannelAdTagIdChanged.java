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
public final class GroupsOuterClass$UpdateChannelAdTagIdChanged extends GeneratedMessageLite implements U64 {
    public static final int CHANNEL_BANNER_AD_TAG_ID_FIELD_NUMBER = 4;
    public static final int CHANNEL_NATIVE_AD_TAG_ID_FIELD_NUMBER = 3;
    private static final GroupsOuterClass$UpdateChannelAdTagIdChanged DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int groupId_;
    private String channelNativeAdTagId_ = "";
    private String channelBannerAdTagId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateChannelAdTagIdChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateChannelAdTagIdChanged groupsOuterClass$UpdateChannelAdTagIdChanged = new GroupsOuterClass$UpdateChannelAdTagIdChanged();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateChannelAdTagIdChanged;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateChannelAdTagIdChanged.class, groupsOuterClass$UpdateChannelAdTagIdChanged);
    }

    private GroupsOuterClass$UpdateChannelAdTagIdChanged() {
    }

    private void clearChannelBannerAdTagId() {
        this.channelBannerAdTagId_ = getDefaultInstance().getChannelBannerAdTagId();
    }

    private void clearChannelNativeAdTagId() {
        this.channelNativeAdTagId_ = getDefaultInstance().getChannelNativeAdTagId();
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelBannerAdTagId(String str) {
        str.getClass();
        this.channelBannerAdTagId_ = str;
    }

    private void setChannelBannerAdTagIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.channelBannerAdTagId_ = abstractC2383g.f0();
    }

    private void setChannelNativeAdTagId(String str) {
        str.getClass();
        this.channelNativeAdTagId_ = str;
    }

    private void setChannelNativeAdTagIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.channelNativeAdTagId_ = abstractC2383g.f0();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateChannelAdTagIdChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0004\u0003\u0000\u0000\u0000\u0001\u0004\u0003Ȉ\u0004Ȉ", new Object[]{"groupId_", "channelNativeAdTagId_", "channelBannerAdTagId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateChannelAdTagIdChanged.class) {
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

    public String getChannelBannerAdTagId() {
        return this.channelBannerAdTagId_;
    }

    public AbstractC2383g getChannelBannerAdTagIdBytes() {
        return AbstractC2383g.N(this.channelBannerAdTagId_);
    }

    public String getChannelNativeAdTagId() {
        return this.channelNativeAdTagId_;
    }

    public AbstractC2383g getChannelNativeAdTagIdBytes() {
        return AbstractC2383g.N(this.channelNativeAdTagId_);
    }

    public int getGroupId() {
        return this.groupId_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateChannelAdTagIdChanged groupsOuterClass$UpdateChannelAdTagIdChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateChannelAdTagIdChanged);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateChannelAdTagIdChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateChannelAdTagIdChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
