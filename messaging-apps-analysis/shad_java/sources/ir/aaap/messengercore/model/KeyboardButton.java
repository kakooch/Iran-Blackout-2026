package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class KeyboardButton extends MiniFunctionObject {
    public String button_text;
    public String id;

    public KeyboardButton(String str) {
        this.button_text = str;
    }

    @Override // ir.aaap.messengercore.model.MiniFunctionObject
    public String getTitle() {
        String str = this.button_text;
        return str != null ? str : "-";
    }

    public String getId() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardButton)) {
            return false;
        }
        KeyboardButton keyboardButton = (KeyboardButton) obj;
        return Objects.equals(this.button_text, keyboardButton.button_text) && Objects.equals(this.id, keyboardButton.id);
    }

    public int hashCode() {
        return Objects.hash(this.button_text, this.id);
    }
}
