package androidMessenger.network;

import androidMessenger.model.GetBaseInfoInput;
import androidMessenger.model.GetBaseInfoOutput;
import androidMessenger.model.GetLinkObjectInput;
import androidMessenger.model.GetLinkObjectOutput;
import androidMessenger.model.GetSettingsInput;
import androidMessenger.model.GetSettingsOutput2;
import androidMessenger.model.MessangerOutput;
import androidMessenger.model.MessengerInput;
import io.reactivex.Observable;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* loaded from: classes.dex */
public interface RestApiRx {
    @POST
    Observable<MessangerOutput<GetBaseInfoOutput>> getBaseInfo(@Url String str, @Body MessengerInput<GetBaseInfoInput> messengerInput);

    @POST
    Observable<GetLinkObjectOutput> getLinkObject(@Url String str, @HeaderMap HashMap<String, String> map, @Body GetLinkObjectInput getLinkObjectInput);

    @POST
    Observable<MessangerOutput<GetSettingsOutput2>> getSettings(@Url String str, @Body MessengerInput<GetSettingsInput> messengerInput);
}
