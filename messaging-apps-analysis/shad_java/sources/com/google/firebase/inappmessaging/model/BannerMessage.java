package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public class BannerMessage extends InAppMessage {
    private final Action action;
    private final String backgroundHexColor;
    private final Text body;
    private final ImageData imageData;
    private final Text title;

    public int hashCode() {
        Text text = this.body;
        int iHashCode = text != null ? text.hashCode() : 0;
        ImageData imageData = this.imageData;
        int iHashCode2 = imageData != null ? imageData.hashCode() : 0;
        Action action = this.action;
        return this.title.hashCode() + iHashCode + iHashCode2 + (action != null ? action.hashCode() : 0) + this.backgroundHexColor.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BannerMessage)) {
            return false;
        }
        BannerMessage bannerMessage = (BannerMessage) obj;
        if (hashCode() != bannerMessage.hashCode()) {
            return false;
        }
        Text text = this.body;
        if ((text == null && bannerMessage.body != null) || (text != null && !text.equals(bannerMessage.body))) {
            return false;
        }
        ImageData imageData = this.imageData;
        if ((imageData == null && bannerMessage.imageData != null) || (imageData != null && !imageData.equals(bannerMessage.imageData))) {
            return false;
        }
        Action action = this.action;
        return (action != null || bannerMessage.action == null) && (action == null || action.equals(bannerMessage.action)) && this.title.equals(bannerMessage.title) && this.backgroundHexColor.equals(bannerMessage.backgroundHexColor);
    }

    private BannerMessage(CampaignMetadata campaignMetadata, Text text, Text text2, ImageData imageData, Action action, String str, Map<String, String> map) {
        super(campaignMetadata, MessageType.BANNER, map);
        this.title = text;
        this.body = text2;
        this.imageData = imageData;
        this.action = action;
        this.backgroundHexColor = str;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Action action;
        String backgroundHexColor;
        Text body;
        ImageData imageData;
        Text title;

        public Builder setTitle(Text text) {
            this.title = text;
            return this;
        }

        public Builder setBody(Text text) {
            this.body = text;
            return this;
        }

        public Builder setImageData(ImageData imageData) {
            this.imageData = imageData;
            return this;
        }

        public Builder setAction(Action action) {
            this.action = action;
            return this;
        }

        public Builder setBackgroundHexColor(String str) {
            this.backgroundHexColor = str;
            return this;
        }

        public BannerMessage build(CampaignMetadata campaignMetadata, Map<String, String> map) {
            if (this.title == null) {
                throw new IllegalArgumentException("Banner model must have a title");
            }
            if (TextUtils.isEmpty(this.backgroundHexColor)) {
                throw new IllegalArgumentException("Banner model must have a background color");
            }
            return new BannerMessage(campaignMetadata, this.title, this.body, this.imageData, this.action, this.backgroundHexColor, map);
        }
    }
}
