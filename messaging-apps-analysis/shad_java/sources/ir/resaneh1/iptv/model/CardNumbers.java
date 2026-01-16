package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class CardNumbers {
    private ArrayList<String> numbers = new ArrayList<>();

    public void addNumberIfNotExist(int i, String str) {
        str.replace(" ", BuildConfig.FLAVOR);
    }

    public ArrayList<String> getNumbers(int i) {
        return new ArrayList<>();
    }
}
