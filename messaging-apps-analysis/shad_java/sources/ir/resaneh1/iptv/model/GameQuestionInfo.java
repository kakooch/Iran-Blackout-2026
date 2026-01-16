package ir.resaneh1.iptv.model;

import io.reactivex.disposables.Disposable;

/* loaded from: classes3.dex */
public class GameQuestionInfo {
    public String correctOptionId;
    public int nextLevel;
    public Disposable requestSendAnswerDisposable;
    public String requestingSelectingId;
    public String selectedId;
    public Disposable waitingForAnswerDisposable;
    public boolean isSendAnswerRequesting = false;
    public boolean isShowCorrectToast = false;
    public boolean isShowLostToast = false;
    public boolean isOneTimeShowedQuestion = false;
    public boolean isDialogChanceShowed = false;
    public boolean isChanceUsed = false;
    public long showEndTime = 0;
    public boolean isUsedChanceForThisQuestion = false;
}
