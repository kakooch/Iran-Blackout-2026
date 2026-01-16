package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.WidgetStoryObject;

/* loaded from: classes3.dex */
public class EmojiSliderObject {
    public int answer_count;
    public float average_float_answer;
    public ColorObject color;
    public String content;
    public String emoji_char;
    public float my_float_answer;
    public WidgetStoryObject.StateEnum state;
    public ThemeEmojiSlider theme;

    public static class ThemeEmojiSlider {
        public ColorObject background_color;
        public ColorObject seekbar_background_color;
        public ColorObject seekbar_progress_color;
        public SeekbarTypeEnum seekbar_type;
        public ColorObject text_color;

        public enum SeekbarTypeEnum {
            Simple,
            Gradient
        }
    }

    public void answerEmojiSlider(float f) {
        if (f > 100.0f) {
            f = 100.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.state != WidgetStoryObject.StateEnum.Closed && this.my_float_answer < 0.0f) {
            float f2 = f / 100.0f;
            this.my_float_answer = f2;
            float f3 = this.average_float_answer;
            int i = this.answer_count;
            this.average_float_answer = ((f3 * i) + f2) / (i + 1);
            this.answer_count = i + 1;
        }
    }
}
