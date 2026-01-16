package ir.aaap.messengercore.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.utilites.DataGenerator;
import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class KeyPadObject {
    public ArrayList<KeypadRow> rows;
    public boolean one_time_keyboard = true;
    public boolean resize_keyboard = false;
    public String state_id = BuildConfig.FLAVOR;

    public static KeyPadObject generate(long j) {
        KeyPadObject keyPadObject = new KeyPadObject();
        int iRandomIntSeed = DataGenerator.randomIntSeed(j, 5) + 1;
        if (iRandomIntSeed > 0) {
            keyPadObject.rows = new ArrayList<>();
            for (int i = 0; i < iRandomIntSeed; i++) {
                keyPadObject.rows.add(KeypadRow.generate(j));
            }
        }
        return keyPadObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyPadObject)) {
            return false;
        }
        KeyPadObject keyPadObject = (KeyPadObject) obj;
        return this.one_time_keyboard == keyPadObject.one_time_keyboard && this.resize_keyboard == keyPadObject.resize_keyboard && Objects.equals(this.rows, keyPadObject.rows) && Objects.equals(this.state_id, keyPadObject.state_id);
    }

    public int hashCode() {
        return Objects.hash(this.rows, Boolean.valueOf(this.one_time_keyboard), Boolean.valueOf(this.resize_keyboard), this.state_id);
    }
}
