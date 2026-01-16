package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class BotCommandObject {
    public String command;
    public String description;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BotCommandObject)) {
            return false;
        }
        BotCommandObject botCommandObject = (BotCommandObject) obj;
        return Objects.equals(this.command, botCommandObject.command) && Objects.equals(this.description, botCommandObject.description);
    }

    public int hashCode() {
        return Objects.hash(this.command, this.description);
    }
}
