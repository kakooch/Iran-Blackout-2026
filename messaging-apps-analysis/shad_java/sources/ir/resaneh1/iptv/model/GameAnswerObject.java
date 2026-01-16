package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class GameAnswerObject {
    public String correct_option_key;
    public boolean hide_answer_count = false;
    public Map<String, Integer> options;

    public String toString() {
        return "options: " + getOptionString() + " correct: " + this.correct_option_key;
    }

    private String getOptionString() {
        Map<String, Integer> map = this.options;
        if (map == null) {
            return "null!";
        }
        String str = BuildConfig.FLAVOR;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            str = str + "optionKey " + ((Object) entry.getKey()) + " text " + entry.getValue();
        }
        return str;
    }

    protected Object clone() throws CloneNotSupportedException {
        GameAnswerObject gameAnswerObject = new GameAnswerObject();
        HashMap map = new HashMap();
        gameAnswerObject.options = map;
        map.putAll(this.options);
        gameAnswerObject.correct_option_key = this.correct_option_key;
        return gameAnswerObject;
    }

    public GameAnswerObject getCopy() throws CloneNotSupportedException {
        return (GameAnswerObject) clone();
    }
}
