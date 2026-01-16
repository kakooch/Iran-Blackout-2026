package org.rbmain.tgnet;

import ir.aaap.messengercore.model.GroupCallModels;
import java.util.EnumMap;

/* loaded from: classes4.dex */
public class TLRPC$TL_groupCallParticipant extends TLObject {
    public static int constructor = -1184160274;
    public String about;
    public int active_date;
    public float amplitude;
    public boolean canManageCallVoiceChat;
    public boolean can_self_unmute;
    public int date;
    public int flags;
    public int hasCameraFrame;
    public int hasPresentationFrame;
    public boolean hasVoice;
    public boolean hasVoiceDelayed;
    public boolean just_joined;
    public long lastActiveDate;
    public long lastRaiseHandDate;
    public long lastSpeakTime;
    public int lastTypingDate;
    public long lastVisibleDate;
    public long lastVoiceUpdateTime;
    public boolean left;
    public boolean min;
    public boolean muted;
    public boolean muted_by_you;
    public TLRPC$Peer peer;
    public TLRPC$TL_groupCallParticipantVideo presentation;
    public String presentationEndpoint;
    public long raise_hand_rating;
    public boolean self;
    public int source;
    public boolean updateFromNotif;
    public GroupCallModels.GroupVoiceChatParticipantUpdate updateObject;
    public boolean versioned;
    public TLRPC$TL_groupCallParticipantVideo video;
    public String videoEndpoint;
    public int videoIndex;
    public boolean video_joined;
    public int volume;
    public boolean volume_by_admin;
    public EnumMap<GroupCallModels.GroupVoiceChatParticipantUpdateParameter, Long> updatedParamsTimeMap = new EnumMap<>(GroupCallModels.GroupVoiceChatParticipantUpdateParameter.class);
    public long allTimeStamp = 0;

    public long getUpdateParamTimeStamp(GroupCallModels.GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter) {
        Long l = this.updatedParamsTimeMap.get(groupVoiceChatParticipantUpdateParameter);
        if (l == null) {
            return this.allTimeStamp;
        }
        if (this.allTimeStamp > l.longValue()) {
            return this.allTimeStamp;
        }
        return l.longValue();
    }

    public void setUpdateParamTimeStamp(GroupCallModels.GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter, long j) {
        if (groupVoiceChatParticipantUpdateParameter == null) {
            return;
        }
        this.updatedParamsTimeMap.put((EnumMap<GroupCallModels.GroupVoiceChatParticipantUpdateParameter, Long>) groupVoiceChatParticipantUpdateParameter, (GroupCallModels.GroupVoiceChatParticipantUpdateParameter) Long.valueOf(j));
    }

    public static TLRPC$TL_groupCallParticipant TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_groupCallParticipant", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = new TLRPC$TL_groupCallParticipant();
        tLRPC$TL_groupCallParticipant.readParams(abstractSerializedData, z);
        return tLRPC$TL_groupCallParticipant;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.muted = (int32 & 1) != 0;
        this.left = (int32 & 2) != 0;
        this.can_self_unmute = (int32 & 4) != 0;
        this.just_joined = (int32 & 16) != 0;
        this.versioned = (int32 & 32) != 0;
        this.min = (int32 & 256) != 0;
        this.muted_by_you = (int32 & 512) != 0;
        this.volume_by_admin = (int32 & 1024) != 0;
        this.self = (int32 & 4096) != 0;
        this.peer = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.date = abstractSerializedData.readInt32(z);
        if ((this.flags & 8) != 0) {
            this.active_date = abstractSerializedData.readInt32(z);
        }
        this.source = abstractSerializedData.readInt32(z);
        if ((this.flags & 128) != 0) {
            this.volume = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 2048) != 0) {
            this.about = abstractSerializedData.readString(z);
        }
        if ((this.flags & 8192) != 0) {
            this.raise_hand_rating = abstractSerializedData.readInt64(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.muted ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.left ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.can_self_unmute ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.just_joined ? i3 | 16 : i3 & (-17);
        this.flags = i4;
        int i5 = this.versioned ? i4 | 32 : i4 & (-33);
        this.flags = i5;
        int i6 = this.min ? i5 | 256 : i5 & (-257);
        this.flags = i6;
        int i7 = this.muted_by_you ? i6 | 512 : i6 & (-513);
        this.flags = i7;
        int i8 = this.volume_by_admin ? i7 | 1024 : i7 & (-1025);
        this.flags = i8;
        int i9 = this.self ? i8 | 4096 : i8 & (-4097);
        this.flags = i9;
        abstractSerializedData.writeInt32(i9);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.date);
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeInt32(this.active_date);
        }
        abstractSerializedData.writeInt32(this.source);
        if ((this.flags & 128) != 0) {
            abstractSerializedData.writeInt32(this.volume);
        }
        if ((this.flags & 2048) != 0) {
            abstractSerializedData.writeString(this.about);
        }
        if ((this.flags & 8192) != 0) {
            abstractSerializedData.writeInt64(this.raise_hand_rating);
        }
    }
}
