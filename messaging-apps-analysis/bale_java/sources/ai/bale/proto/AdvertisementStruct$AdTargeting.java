package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AudienceTarget;
import ai.bale.proto.AdvertisementStruct$ChannelMembersTarget;
import ai.bale.proto.AdvertisementStruct$ChannelsTarget;
import ai.bale.proto.AdvertisementStruct$GenderTarget;
import ai.bale.proto.AdvertisementStruct$LocationsTarget;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AdTargeting extends GeneratedMessageLite implements U64 {
    public static final int AUDIENCE_FIELD_NUMBER = 1;
    public static final int CHANNELS_FIELD_NUMBER = 2;
    public static final int CHANNEL_MEMBERS_FIELD_NUMBER = 3;
    private static final AdvertisementStruct$AdTargeting DEFAULT_INSTANCE;
    public static final int GENDER_FIELD_NUMBER = 4;
    public static final int LOCATIONS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER;
    private AdvertisementStruct$AudienceTarget audience_;
    private int bitField0_;
    private AdvertisementStruct$ChannelMembersTarget channelMembers_;
    private AdvertisementStruct$ChannelsTarget channels_;
    private AdvertisementStruct$GenderTarget gender_;
    private AdvertisementStruct$LocationsTarget locations_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$AdTargeting.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting = new AdvertisementStruct$AdTargeting();
        DEFAULT_INSTANCE = advertisementStruct$AdTargeting;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AdTargeting.class, advertisementStruct$AdTargeting);
    }

    private AdvertisementStruct$AdTargeting() {
    }

    private void clearAudience() {
        this.audience_ = null;
        this.bitField0_ &= -2;
    }

    private void clearChannelMembers() {
        this.channelMembers_ = null;
        this.bitField0_ &= -5;
    }

    private void clearChannels() {
        this.channels_ = null;
        this.bitField0_ &= -3;
    }

    private void clearGender() {
        this.gender_ = null;
        this.bitField0_ &= -9;
    }

    private void clearLocations() {
        this.locations_ = null;
        this.bitField0_ &= -17;
    }

    public static AdvertisementStruct$AdTargeting getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAudience(AdvertisementStruct$AudienceTarget advertisementStruct$AudienceTarget) {
        advertisementStruct$AudienceTarget.getClass();
        AdvertisementStruct$AudienceTarget advertisementStruct$AudienceTarget2 = this.audience_;
        if (advertisementStruct$AudienceTarget2 == null || advertisementStruct$AudienceTarget2 == AdvertisementStruct$AudienceTarget.getDefaultInstance()) {
            this.audience_ = advertisementStruct$AudienceTarget;
        } else {
            this.audience_ = (AdvertisementStruct$AudienceTarget) ((AdvertisementStruct$AudienceTarget.a) AdvertisementStruct$AudienceTarget.newBuilder(this.audience_).v(advertisementStruct$AudienceTarget)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeChannelMembers(AdvertisementStruct$ChannelMembersTarget advertisementStruct$ChannelMembersTarget) {
        advertisementStruct$ChannelMembersTarget.getClass();
        AdvertisementStruct$ChannelMembersTarget advertisementStruct$ChannelMembersTarget2 = this.channelMembers_;
        if (advertisementStruct$ChannelMembersTarget2 == null || advertisementStruct$ChannelMembersTarget2 == AdvertisementStruct$ChannelMembersTarget.getDefaultInstance()) {
            this.channelMembers_ = advertisementStruct$ChannelMembersTarget;
        } else {
            this.channelMembers_ = (AdvertisementStruct$ChannelMembersTarget) ((AdvertisementStruct$ChannelMembersTarget.a) AdvertisementStruct$ChannelMembersTarget.newBuilder(this.channelMembers_).v(advertisementStruct$ChannelMembersTarget)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeChannels(AdvertisementStruct$ChannelsTarget advertisementStruct$ChannelsTarget) {
        advertisementStruct$ChannelsTarget.getClass();
        AdvertisementStruct$ChannelsTarget advertisementStruct$ChannelsTarget2 = this.channels_;
        if (advertisementStruct$ChannelsTarget2 == null || advertisementStruct$ChannelsTarget2 == AdvertisementStruct$ChannelsTarget.getDefaultInstance()) {
            this.channels_ = advertisementStruct$ChannelsTarget;
        } else {
            this.channels_ = (AdvertisementStruct$ChannelsTarget) ((AdvertisementStruct$ChannelsTarget.a) AdvertisementStruct$ChannelsTarget.newBuilder(this.channels_).v(advertisementStruct$ChannelsTarget)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeGender(AdvertisementStruct$GenderTarget advertisementStruct$GenderTarget) {
        advertisementStruct$GenderTarget.getClass();
        AdvertisementStruct$GenderTarget advertisementStruct$GenderTarget2 = this.gender_;
        if (advertisementStruct$GenderTarget2 == null || advertisementStruct$GenderTarget2 == AdvertisementStruct$GenderTarget.getDefaultInstance()) {
            this.gender_ = advertisementStruct$GenderTarget;
        } else {
            this.gender_ = (AdvertisementStruct$GenderTarget) ((AdvertisementStruct$GenderTarget.a) AdvertisementStruct$GenderTarget.newBuilder(this.gender_).v(advertisementStruct$GenderTarget)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeLocations(AdvertisementStruct$LocationsTarget advertisementStruct$LocationsTarget) {
        advertisementStruct$LocationsTarget.getClass();
        AdvertisementStruct$LocationsTarget advertisementStruct$LocationsTarget2 = this.locations_;
        if (advertisementStruct$LocationsTarget2 == null || advertisementStruct$LocationsTarget2 == AdvertisementStruct$LocationsTarget.getDefaultInstance()) {
            this.locations_ = advertisementStruct$LocationsTarget;
        } else {
            this.locations_ = (AdvertisementStruct$LocationsTarget) ((AdvertisementStruct$LocationsTarget.b) AdvertisementStruct$LocationsTarget.newBuilder(this.locations_).v(advertisementStruct$LocationsTarget)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AdTargeting parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAudience(AdvertisementStruct$AudienceTarget advertisementStruct$AudienceTarget) {
        advertisementStruct$AudienceTarget.getClass();
        this.audience_ = advertisementStruct$AudienceTarget;
        this.bitField0_ |= 1;
    }

    private void setChannelMembers(AdvertisementStruct$ChannelMembersTarget advertisementStruct$ChannelMembersTarget) {
        advertisementStruct$ChannelMembersTarget.getClass();
        this.channelMembers_ = advertisementStruct$ChannelMembersTarget;
        this.bitField0_ |= 4;
    }

    private void setChannels(AdvertisementStruct$ChannelsTarget advertisementStruct$ChannelsTarget) {
        advertisementStruct$ChannelsTarget.getClass();
        this.channels_ = advertisementStruct$ChannelsTarget;
        this.bitField0_ |= 2;
    }

    private void setGender(AdvertisementStruct$GenderTarget advertisementStruct$GenderTarget) {
        advertisementStruct$GenderTarget.getClass();
        this.gender_ = advertisementStruct$GenderTarget;
        this.bitField0_ |= 8;
    }

    private void setLocations(AdvertisementStruct$LocationsTarget advertisementStruct$LocationsTarget) {
        advertisementStruct$LocationsTarget.getClass();
        this.locations_ = advertisementStruct$LocationsTarget;
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AdTargeting();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"bitField0_", "audience_", "channels_", "channelMembers_", "gender_", "locations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AdTargeting.class) {
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

    public AdvertisementStruct$AudienceTarget getAudience() {
        AdvertisementStruct$AudienceTarget advertisementStruct$AudienceTarget = this.audience_;
        return advertisementStruct$AudienceTarget == null ? AdvertisementStruct$AudienceTarget.getDefaultInstance() : advertisementStruct$AudienceTarget;
    }

    public AdvertisementStruct$ChannelMembersTarget getChannelMembers() {
        AdvertisementStruct$ChannelMembersTarget advertisementStruct$ChannelMembersTarget = this.channelMembers_;
        return advertisementStruct$ChannelMembersTarget == null ? AdvertisementStruct$ChannelMembersTarget.getDefaultInstance() : advertisementStruct$ChannelMembersTarget;
    }

    public AdvertisementStruct$ChannelsTarget getChannels() {
        AdvertisementStruct$ChannelsTarget advertisementStruct$ChannelsTarget = this.channels_;
        return advertisementStruct$ChannelsTarget == null ? AdvertisementStruct$ChannelsTarget.getDefaultInstance() : advertisementStruct$ChannelsTarget;
    }

    public AdvertisementStruct$GenderTarget getGender() {
        AdvertisementStruct$GenderTarget advertisementStruct$GenderTarget = this.gender_;
        return advertisementStruct$GenderTarget == null ? AdvertisementStruct$GenderTarget.getDefaultInstance() : advertisementStruct$GenderTarget;
    }

    public AdvertisementStruct$LocationsTarget getLocations() {
        AdvertisementStruct$LocationsTarget advertisementStruct$LocationsTarget = this.locations_;
        return advertisementStruct$LocationsTarget == null ? AdvertisementStruct$LocationsTarget.getDefaultInstance() : advertisementStruct$LocationsTarget;
    }

    public boolean hasAudience() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasChannelMembers() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasChannels() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasGender() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasLocations() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AdTargeting);
    }

    public static AdvertisementStruct$AdTargeting parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AdTargeting parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AdTargeting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
