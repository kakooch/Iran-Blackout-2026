package ir.aaap.messengercore.network;

/* loaded from: classes3.dex */
public class RetryObject {
    public int diffTime;
    public int retryCount;
    public int retryDelaySecond;
    public int[] retryDelaySecondArray;
    public RetryTypeEnum type;

    public enum RetryTypeEnum {
        NoRetry,
        CountAndDelay,
        DelayArray,
        DelayWithTimeLimit
    }

    public static RetryObject getDefaultRetry() {
        return getCountAndDelayRetry(0, 2, 3, 5, 10);
    }

    public static RetryObject getCountAndDelayRetry(int... iArr) {
        RetryObject retryObject = new RetryObject();
        retryObject.type = RetryTypeEnum.DelayArray;
        retryObject.retryDelaySecondArray = iArr;
        return retryObject;
    }

    public static RetryObject getCountAndDelayRetryWithTime(int i, int... iArr) {
        RetryObject retryObject = new RetryObject();
        retryObject.type = RetryTypeEnum.DelayWithTimeLimit;
        retryObject.retryDelaySecondArray = iArr;
        retryObject.diffTime = i;
        return retryObject;
    }
}
