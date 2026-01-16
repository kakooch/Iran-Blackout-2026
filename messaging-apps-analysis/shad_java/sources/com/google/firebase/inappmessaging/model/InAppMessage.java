package com.google.firebase.inappmessaging.model;

import java.util.Map;

/* loaded from: classes3.dex */
public abstract class InAppMessage {
    private Map<String, String> data;
    MessageType messageType;

    public InAppMessage(CampaignMetadata campaignMetadata, MessageType messageType, Map<String, String> map) {
        this.messageType = messageType;
        this.data = map;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }
}
