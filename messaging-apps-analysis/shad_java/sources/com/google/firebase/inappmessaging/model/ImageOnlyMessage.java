package com.google.firebase.inappmessaging.model;

import java.util.Map;

/* loaded from: classes3.dex */
public class ImageOnlyMessage extends InAppMessage {
    private Action action;
    private ImageData imageData;

    public int hashCode() {
        Action action = this.action;
        return this.imageData.hashCode() + (action != null ? action.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageOnlyMessage)) {
            return false;
        }
        ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) obj;
        if (hashCode() != imageOnlyMessage.hashCode()) {
            return false;
        }
        Action action = this.action;
        return (action != null || imageOnlyMessage.action == null) && (action == null || action.equals(imageOnlyMessage.action)) && this.imageData.equals(imageOnlyMessage.imageData);
    }

    private ImageOnlyMessage(CampaignMetadata campaignMetadata, ImageData imageData, Action action, Map<String, String> map) {
        super(campaignMetadata, MessageType.IMAGE_ONLY, map);
        this.imageData = imageData;
        this.action = action;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Action action;
        ImageData imageData;

        public Builder setImageData(ImageData imageData) {
            this.imageData = imageData;
            return this;
        }

        public Builder setAction(Action action) {
            this.action = action;
            return this;
        }

        public ImageOnlyMessage build(CampaignMetadata campaignMetadata, Map<String, String> map) {
            ImageData imageData = this.imageData;
            if (imageData == null) {
                throw new IllegalArgumentException("ImageOnly model must have image data");
            }
            return new ImageOnlyMessage(campaignMetadata, imageData, this.action, map);
        }
    }
}
