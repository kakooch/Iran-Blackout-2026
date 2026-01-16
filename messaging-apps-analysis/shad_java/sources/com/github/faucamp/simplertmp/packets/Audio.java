package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.packets.RtmpHeader;

/* loaded from: classes.dex */
public class Audio extends ContentData {
    public String toString() {
        return "RTMP Audio";
    }

    public Audio(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    public Audio() {
        super(new RtmpHeader(RtmpHeader.ChunkType.TYPE_0_FULL, 7, RtmpHeader.MessageType.AUDIO));
    }
}
