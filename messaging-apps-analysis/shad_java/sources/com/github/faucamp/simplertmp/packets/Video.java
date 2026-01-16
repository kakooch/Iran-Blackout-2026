package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.packets.RtmpHeader;

/* loaded from: classes.dex */
public class Video extends ContentData {
    public String toString() {
        return "RTMP Video";
    }

    public Video(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    public Video() {
        super(new RtmpHeader(RtmpHeader.ChunkType.TYPE_0_FULL, 6, RtmpHeader.MessageType.VIDEO));
    }
}
