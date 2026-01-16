package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class GameQuestionObject {
    public boolean allow_use_relive;
    public ArrayList<GameOptionObject> options;
    public String question_id;
    public int show_time;
    public String text;

    protected Object clone() throws CloneNotSupportedException {
        GameQuestionObject gameQuestionObject = new GameQuestionObject();
        gameQuestionObject.question_id = this.question_id;
        gameQuestionObject.text = this.text;
        if (this.options != null) {
            ArrayList<GameOptionObject> arrayList = new ArrayList<>(this.options.size());
            gameQuestionObject.options = arrayList;
            arrayList.addAll(this.options);
        }
        gameQuestionObject.allow_use_relive = this.allow_use_relive;
        gameQuestionObject.show_time = this.show_time;
        return gameQuestionObject;
    }

    public GameQuestionObject getCopy() throws CloneNotSupportedException {
        return (GameQuestionObject) clone();
    }

    public String toString() {
        return "question_id: " + this.question_id + " text: " + this.text + " options: " + getOptionString() + " allow_user_relive: " + this.allow_use_relive + " showTime: " + this.show_time;
    }

    private String getOptionString() {
        ArrayList<GameOptionObject> arrayList = this.options;
        if (arrayList == null) {
            return "null!";
        }
        Iterator<GameOptionObject> it = arrayList.iterator();
        String str = BuildConfig.FLAVOR;
        while (it.hasNext()) {
            GameOptionObject next = it.next();
            str = str + " {optionId: " + next.option_id + " optionText " + next.text + "}";
        }
        return str;
    }
}
