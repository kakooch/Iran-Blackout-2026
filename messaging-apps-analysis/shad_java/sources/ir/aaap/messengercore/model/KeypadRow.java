package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.DataGenerator;
import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class KeypadRow {
    public ArrayList<KeyboardButton> buttons;

    public static KeypadRow generate(long j) {
        KeypadRow keypadRow = new KeypadRow();
        int iRandomIntSeed = DataGenerator.randomIntSeed(j, 2) + 1;
        if (iRandomIntSeed > 0) {
            keypadRow.buttons = new ArrayList<>();
            for (int i = 0; i < iRandomIntSeed; i++) {
                keypadRow.buttons.add(new KeyboardButton(DataGenerator.randomStringSeed(j)));
            }
        }
        return keypadRow;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeypadRow) {
            return Objects.equals(this.buttons, ((KeypadRow) obj).buttons);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.buttons);
    }
}
