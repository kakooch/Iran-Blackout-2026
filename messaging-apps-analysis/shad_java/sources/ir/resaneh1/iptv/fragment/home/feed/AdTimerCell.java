package ir.resaneh1.iptv.fragment.home.feed;

import android.content.Context;
import android.os.CountDownTimer;
import com.facebook.stetho.websocket.CloseCodes;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.FrameLayoutLikeLinear;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class AdTimerCell extends FrameLayoutLikeLinear {
    private final Context context;
    private CountDownTimer countDownTimer;
    public AdTimerItemCell daysCell;
    public AdTimerItemCell hoursCell;
    public AdTimerItemCell minutesCell;
    public AdTimerItemCell secondsCell;

    private boolean isValidData(HomePageModels.AdItemObject adItemObject) {
        return adItemObject != null;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'MINUTES' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class TIME_TYPE {
        private static final /* synthetic */ TIME_TYPE[] $VALUES;
        public static final TIME_TYPE DAYS;
        public static final TIME_TYPE HOURS;
        public static final TIME_TYPE MINUTES;
        public static final TIME_TYPE SECONDS;
        public final int interval;
        public final int milliSeconds;
        private final String name;

        public static TIME_TYPE valueOf(String str) {
            return (TIME_TYPE) Enum.valueOf(TIME_TYPE.class, str);
        }

        public static TIME_TYPE[] values() {
            return (TIME_TYPE[]) $VALUES.clone();
        }

        static {
            TIME_TYPE time_type = new TIME_TYPE("SECONDS", 0, CloseCodes.NORMAL_CLOSURE, 60, LocaleController.getString(R.string.second));
            SECONDS = time_type;
            TIME_TYPE time_type2 = new TIME_TYPE("MINUTES", 1, time_type.milliSeconds * 60, 60, LocaleController.getString(R.string.minutes));
            MINUTES = time_type2;
            TIME_TYPE time_type3 = new TIME_TYPE("HOURS", 2, time_type2.milliSeconds * 60, 24, LocaleController.getString(R.string.hour));
            HOURS = time_type3;
            TIME_TYPE time_type4 = new TIME_TYPE("DAYS", 3, time_type3.milliSeconds * 24, 30, LocaleController.getString(R.string.day));
            DAYS = time_type4;
            $VALUES = new TIME_TYPE[]{time_type, time_type2, time_type3, time_type4};
        }

        private TIME_TYPE(String str, int i, int i2, int i3, String str2) {
            this.milliSeconds = i2;
            this.interval = i3;
            this.name = str2;
        }

        public String getName() {
            return this.name;
        }
    }

    public void setColonsColor(String str) {
        if (str != null) {
            this.daysCell.setSeparatorColor(str);
            this.hoursCell.setSeparatorColor(str);
            this.minutesCell.setSeparatorColor(str);
            this.secondsCell.setSeparatorColor(str);
        }
    }

    public AdTimerCell(Context context, Boolean bool) {
        super(context);
        this.context = context;
        initFeedTimerItems(bool);
        addView(this.daysCell, LayoutHelper.createLinear(0, -1, 1.0f, 0, 1, 0, 1, 0));
        addView(this.hoursCell, LayoutHelper.createLinear(0, -1, 1.0f, 0, 1, 0, 1, 0));
        addView(this.minutesCell, LayoutHelper.createLinear(0, -1, 1.0f, 0, 1, 0, 1, 0));
        addView(this.secondsCell, LayoutHelper.createLinear(0, -1, 1.0f, 0, 1, 0, 1, 0));
    }

    private void initFeedTimerItems(Boolean bool) {
        this.secondsCell = new AdTimerItemCell(this.context, TIME_TYPE.SECONDS, bool);
        this.minutesCell = new AdTimerItemCell(this.context, TIME_TYPE.MINUTES, bool);
        this.hoursCell = new AdTimerItemCell(this.context, TIME_TYPE.HOURS, bool);
        this.daysCell = new AdTimerItemCell(this.context, TIME_TYPE.DAYS, bool);
    }

    public void setAdTimerData(HomePageModels.AdItemObject adItemObject) {
        resetViews();
        if (isValidData(adItemObject)) {
            VisibilityHelper.showViews(this.secondsCell, this.minutesCell, this.hoursCell, this.daysCell);
        } else {
            VisibilityHelper.hideViews(this.secondsCell, this.minutesCell, this.hoursCell, this.daysCell);
        }
    }

    public void stopCounter() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.countDownTimer = null;
        }
    }

    public void resetViews() {
        resetFonts();
        resetTextColor();
        this.secondsCell.setTimeTextView(NumberUtils.toPersian("00"));
        this.minutesCell.setTimeTextView(NumberUtils.toPersian("00"));
        this.hoursCell.setTimeTextView(NumberUtils.toPersian("00"));
        this.daysCell.setTimeTextView(NumberUtils.toPersian("00"));
        setVisibility(8);
    }

    public void refreshCounter(long j) {
        stopCounter();
        resetViews();
        long j2 = j * 1000;
        if (j2 - System.currentTimeMillis() > 0) {
            setVisibility(0);
            this.countDownTimer = new CountDownTimer(j2 - System.currentTimeMillis(), TIME_TYPE.SECONDS.milliSeconds) { // from class: ir.resaneh1.iptv.fragment.home.feed.AdTimerCell.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AdTimerCell adTimerCell = AdTimerCell.this;
                    AdTimerItemCell adTimerItemCell = adTimerCell.secondsCell;
                    TIME_TYPE time_type = TIME_TYPE.SECONDS;
                    adTimerItemCell.setTimeTextView(adTimerCell.getTimerValue((j3 / time_type.milliSeconds) % time_type.interval));
                    AdTimerCell adTimerCell2 = AdTimerCell.this;
                    AdTimerItemCell adTimerItemCell2 = adTimerCell2.minutesCell;
                    TIME_TYPE time_type2 = TIME_TYPE.MINUTES;
                    adTimerItemCell2.setTimeTextView(adTimerCell2.getTimerValue((j3 / time_type2.milliSeconds) % time_type2.interval));
                    AdTimerCell adTimerCell3 = AdTimerCell.this;
                    AdTimerItemCell adTimerItemCell3 = adTimerCell3.hoursCell;
                    TIME_TYPE time_type3 = TIME_TYPE.HOURS;
                    adTimerItemCell3.setTimeTextView(adTimerCell3.getTimerValue((j3 / time_type3.milliSeconds) % time_type3.interval));
                    AdTimerCell adTimerCell4 = AdTimerCell.this;
                    adTimerCell4.daysCell.setTimeTextView(adTimerCell4.getTimerValue(j3 / TIME_TYPE.DAYS.milliSeconds));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdTimerCell.this.resetViews();
                    AdTimerCell.this.setVisibility(8);
                }
            }.start();
        } else {
            setVisibility(8);
        }
    }

    public String getTimerValue(long j) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(j);
        } catch (Exception unused) {
            sb.append("00");
        }
        if (sb.length() <= 1) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    public void updateFonts(float f) {
        if (f > 0.0f) {
            this.secondsCell.updateFontSize(f);
            this.minutesCell.updateFontSize(f);
            this.hoursCell.updateFontSize(f);
            this.daysCell.updateFontSize(f);
        }
    }

    private void resetFonts() {
        this.secondsCell.resetFontSize();
        this.minutesCell.resetFontSize();
        this.hoursCell.resetFontSize();
        this.daysCell.resetFontSize();
    }

    public void updateTextColor(String str) {
        if (str != null) {
            this.secondsCell.updateTextColors(str);
            this.minutesCell.updateTextColors(str);
            this.hoursCell.updateTextColors(str);
            this.daysCell.updateTextColors(str);
        }
    }

    private void resetTextColor() {
        this.secondsCell.updateTextColors("#FFFFFF");
        this.minutesCell.updateTextColors("#FFFFFF");
        this.hoursCell.updateTextColors("#FFFFFF");
        this.daysCell.updateTextColors("#FFFFFF");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
