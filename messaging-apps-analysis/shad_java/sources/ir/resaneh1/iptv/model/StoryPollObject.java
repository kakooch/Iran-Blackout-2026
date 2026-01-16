package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.WidgetStoryObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StoryPollObject {
    public int answer_count;
    public ArrayList<Integer> choices_count_list;
    public ArrayList<String> choices_list;
    public String content;
    public int selection_index;
    public WidgetStoryObject.StateEnum state;

    public void setData(String str, String str2, String str3) {
        this.content = str;
        ArrayList<String> arrayList = new ArrayList<>();
        this.choices_list = arrayList;
        arrayList.add(str2);
        this.choices_list.add(str3);
    }

    public void answerPoll(int i) {
        if (this.state != WidgetStoryObject.StateEnum.Closed && this.selection_index <= 0) {
            this.selection_index = i;
            int i2 = i - 1;
            if (this.choices_count_list == null) {
                this.choices_count_list = new ArrayList<>();
            }
            if (this.choices_count_list.size() <= i2) {
                for (int size = this.choices_count_list.size(); size < i2; size++) {
                    this.choices_count_list.add(0);
                }
                this.choices_count_list.add(1);
            } else {
                this.choices_count_list.set(i2, Integer.valueOf(this.choices_count_list.get(i2).intValue() + 1));
            }
            this.answer_count++;
        }
    }

    public int getLeftPercentage() {
        ArrayList<Integer> arrayList = this.choices_count_list;
        int iIntValue = 0;
        if (arrayList != null && arrayList.size() > 0) {
            iIntValue = this.choices_count_list.get(0).intValue();
        }
        int i = this.answer_count;
        if (i <= 0) {
            i = 1;
        }
        return (int) (((iIntValue * 1.0f) / (i * 1.0f)) * 100.0f);
    }
}
