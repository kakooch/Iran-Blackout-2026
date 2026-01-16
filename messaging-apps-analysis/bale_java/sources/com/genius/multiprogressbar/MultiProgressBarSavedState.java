package com.genius.multiprogressbar;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0000\u0018\u0000 H2\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0015R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010)\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\"\u0010,\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001d\u001a\u0004\b\u0011\u0010\u001f\"\u0004\b+\u0010!R\"\u0010.\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001c\u0010\u001f\"\u0004\b-\u0010!R\"\u00100\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b/\u0010\u0015R\"\u00103\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0012\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u0015R\"\u00105\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0012\u001a\u0004\b#\u0010\u0010\"\u0004\b4\u0010\u0015R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010@\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\"\u0010C\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u001d\u001a\u0004\b7\u0010\u001f\"\u0004\bB\u0010!R\"\u0010E\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\bA\u0010:\"\u0004\bD\u0010<R\"\u0010G\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0012\u001a\u0004\b*\u0010\u0010\"\u0004\bF\u0010\u0015¨\u0006I"}, d2 = {"Lcom/genius/multiprogressbar/MultiProgressBarSavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "in", "(Landroid/os/Parcel;)V", "out", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", TokenNames.I, "g", "x", "(I)V", "progressColor", "b", "e", "u", "lineColor", "", "c", TokenNames.F, "h", "()F", "z", "(F)V", "progressPadding", "d", "j", "B", "progressWidth", "l", "D", "singleProgressWidth", "f", "p", "animatedAbsoluteProgress", "s", "currentAbsoluteProgress", "r", "countProgress", "i", "A", "progressPercents", "t", "displayedStepForListener", "", "k", "Z", "o", "()Z", "y", "(Z)V", "isProgressIsRunning", "n", "v", "isNeedRestoreProgressAfterRecreate", "m", TokenNames.C, "singleDisplayedTime", "q", "isCompactMode", "w", "orientation", "CREATOR", "multiprogressbar_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class MultiProgressBarSavedState extends View.BaseSavedState {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private int progressColor;

    /* renamed from: b, reason: from kotlin metadata */
    private int lineColor;

    /* renamed from: c, reason: from kotlin metadata */
    private float progressPadding;

    /* renamed from: d, reason: from kotlin metadata */
    private float progressWidth;

    /* renamed from: e, reason: from kotlin metadata */
    private float singleProgressWidth;

    /* renamed from: f, reason: from kotlin metadata */
    private float animatedAbsoluteProgress;

    /* renamed from: g, reason: from kotlin metadata */
    private float currentAbsoluteProgress;

    /* renamed from: h, reason: from kotlin metadata */
    private int countProgress;

    /* renamed from: i, reason: from kotlin metadata */
    private int progressPercents;

    /* renamed from: j, reason: from kotlin metadata */
    private int displayedStepForListener;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isProgressIsRunning;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean isNeedRestoreProgressAfterRecreate;

    /* renamed from: m, reason: from kotlin metadata */
    private float singleDisplayedTime;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean isCompactMode;

    /* renamed from: o, reason: from kotlin metadata */
    private int orientation;

    /* renamed from: com.genius.multiprogressbar.MultiProgressBarSavedState$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator {
        private Companion() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MultiProgressBarSavedState createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new MultiProgressBarSavedState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MultiProgressBarSavedState[] newArray(int i) {
            return new MultiProgressBarSavedState[i];
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ MultiProgressBarSavedState(Parcel parcel, ED1 ed1) {
        this(parcel);
    }

    public final void A(int i) {
        this.progressPercents = i;
    }

    public final void B(float f) {
        this.progressWidth = f;
    }

    public final void C(float f) {
        this.singleDisplayedTime = f;
    }

    public final void D(float f) {
        this.singleProgressWidth = f;
    }

    /* renamed from: a, reason: from getter */
    public final float getAnimatedAbsoluteProgress() {
        return this.animatedAbsoluteProgress;
    }

    /* renamed from: b, reason: from getter */
    public final int getCountProgress() {
        return this.countProgress;
    }

    /* renamed from: c, reason: from getter */
    public final float getCurrentAbsoluteProgress() {
        return this.currentAbsoluteProgress;
    }

    /* renamed from: d, reason: from getter */
    public final int getDisplayedStepForListener() {
        return this.displayedStepForListener;
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getLineColor() {
        return this.lineColor;
    }

    /* renamed from: f, reason: from getter */
    public final int getOrientation() {
        return this.orientation;
    }

    /* renamed from: g, reason: from getter */
    public final int getProgressColor() {
        return this.progressColor;
    }

    /* renamed from: h, reason: from getter */
    public final float getProgressPadding() {
        return this.progressPadding;
    }

    /* renamed from: i, reason: from getter */
    public final int getProgressPercents() {
        return this.progressPercents;
    }

    /* renamed from: j, reason: from getter */
    public final float getProgressWidth() {
        return this.progressWidth;
    }

    /* renamed from: k, reason: from getter */
    public final float getSingleDisplayedTime() {
        return this.singleDisplayedTime;
    }

    /* renamed from: l, reason: from getter */
    public final float getSingleProgressWidth() {
        return this.singleProgressWidth;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsCompactMode() {
        return this.isCompactMode;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsNeedRestoreProgressAfterRecreate() {
        return this.isNeedRestoreProgressAfterRecreate;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsProgressIsRunning() {
        return this.isProgressIsRunning;
    }

    public final void p(float f) {
        this.animatedAbsoluteProgress = f;
    }

    public final void q(boolean z) {
        this.isCompactMode = z;
    }

    public final void r(int i) {
        this.countProgress = i;
    }

    public final void s(float f) {
        this.currentAbsoluteProgress = f;
    }

    public final void t(int i) {
        this.displayedStepForListener = i;
    }

    public final void u(int i) {
        this.lineColor = i;
    }

    public final void v(boolean z) {
        this.isNeedRestoreProgressAfterRecreate = z;
    }

    public final void w(int i) {
        this.orientation = i;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        AbstractC13042fc3.i(out, "out");
        super.writeToParcel(out, flags);
        out.writeInt(this.progressColor);
        out.writeInt(this.lineColor);
        out.writeInt(this.countProgress);
        out.writeInt(this.progressPercents);
        out.writeFloat(this.progressPadding);
        out.writeFloat(this.progressWidth);
        out.writeFloat(this.singleProgressWidth);
        out.writeFloat(this.currentAbsoluteProgress);
        out.writeFloat(this.animatedAbsoluteProgress);
        out.writeInt(this.isProgressIsRunning ? 1 : 0);
        out.writeInt(this.isNeedRestoreProgressAfterRecreate ? 1 : 0);
        out.writeInt(this.displayedStepForListener);
        out.writeFloat(this.singleDisplayedTime);
        out.writeInt(this.isCompactMode ? 1 : 0);
        out.writeInt(this.orientation);
    }

    public final void x(int i) {
        this.progressColor = i;
    }

    public final void y(boolean z) {
        this.isProgressIsRunning = z;
    }

    public final void z(float f) {
        this.progressPadding = f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProgressBarSavedState(Parcelable parcelable) {
        super(parcelable);
        AbstractC13042fc3.i(parcelable, "superState");
        this.progressWidth = 10.0f;
        this.countProgress = 1;
        this.displayedStepForListener = -1;
        this.singleDisplayedTime = 1.0f;
        this.orientation = 1;
    }

    private MultiProgressBarSavedState(Parcel parcel) {
        super(parcel);
        this.progressWidth = 10.0f;
        this.countProgress = 1;
        this.displayedStepForListener = -1;
        this.singleDisplayedTime = 1.0f;
        this.orientation = 1;
        this.progressColor = parcel.readInt();
        this.lineColor = parcel.readInt();
        this.countProgress = parcel.readInt();
        this.progressPercents = parcel.readInt();
        this.progressPadding = parcel.readFloat();
        this.progressWidth = parcel.readFloat();
        this.singleProgressWidth = parcel.readFloat();
        this.currentAbsoluteProgress = parcel.readFloat();
        this.animatedAbsoluteProgress = parcel.readFloat();
        this.isProgressIsRunning = parcel.readInt() == 1;
        this.isNeedRestoreProgressAfterRecreate = parcel.readInt() == 1;
        this.displayedStepForListener = parcel.readInt();
        this.singleDisplayedTime = parcel.readFloat();
        this.isCompactMode = parcel.readInt() == 1;
        this.orientation = parcel.readInt();
    }
}
