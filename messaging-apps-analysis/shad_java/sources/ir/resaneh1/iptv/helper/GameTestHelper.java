package ir.resaneh1.iptv.helper;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.GameAnswerObject;
import ir.resaneh1.iptv.model.GameOptionObject;
import ir.resaneh1.iptv.model.GameQuestionObject;
import ir.resaneh1.iptv.model.GameStateObject;
import ir.resaneh1.iptv.model.GetGameStatusOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class GameTestHelper {
    static int counter;
    static GameQuestionObject lastQ;
    private static ArrayList<GetGameStatusOutput> statusArray;

    public static GameStateObject getGameState() {
        GameStateObject stateA;
        int iRandomInt = DataGenerator.randomInt(0, 100);
        if (iRandomInt < 10) {
            return getStateNoGame();
        }
        if (iRandomInt >= 10 && iRandomInt < 30) {
            return getStateHost();
        }
        if (iRandomInt >= 30 && iRandomInt < 70) {
            GameStateObject stateQ = getStateQ();
            lastQ = stateQ.question;
            return stateQ;
        }
        if (iRandomInt >= 70 && iRandomInt < 100) {
            GameQuestionObject gameQuestionObject = lastQ;
            if (gameQuestionObject != null) {
                if (iRandomInt >= 75) {
                    stateA = getStateA(gameQuestionObject);
                } else {
                    stateA = getStateA();
                }
                lastQ = null;
                return stateA;
            }
            return getStateA();
        }
        return getStateNoGame();
    }

    private static GameStateObject getStateHost() {
        GameStateObject gameStateObject = new GameStateObject();
        gameStateObject.status = GameStateObject.GameStatusEnum.Host;
        return gameStateObject;
    }

    private static GameStateObject getStateNoGame() {
        GameStateObject gameStateObject = new GameStateObject();
        gameStateObject.status = GameStateObject.GameStatusEnum.NoGame;
        return gameStateObject;
    }

    private static GameStateObject getStateQ() {
        GameStateObject gameStateObject = new GameStateObject();
        gameStateObject.status = GameStateObject.GameStatusEnum.ShowQuestion;
        gameStateObject.question = getQuestion();
        gameStateObject.allowed_level = counter;
        return gameStateObject;
    }

    private static GameStateObject makeNextState(GameStateObject gameStateObject) {
        GameStateObject.GameStatusEnum gameStatusEnum = gameStateObject.status;
        if (gameStatusEnum == GameStateObject.GameStatusEnum.ShowQuestion) {
            makeNextStateQ(gameStateObject);
        } else if (gameStatusEnum == GameStateObject.GameStatusEnum.ShowAnswer) {
            makeNextStateA(gameStateObject);
        }
        return gameStateObject;
    }

    private static GameStateObject makeNextStateQ(GameStateObject gameStateObject) {
        GameStateObject gameStateObject2 = new GameStateObject();
        gameStateObject2.status = GameStateObject.GameStatusEnum.ShowQuestion;
        try {
            gameStateObject2.question = gameStateObject.question.getCopy();
        } catch (Exception unused) {
        }
        gameStateObject2.allowed_level = gameStateObject.allowed_level;
        if (gameStateObject2.question != null && DataGenerator.randomBoolean(0.7f)) {
            gameStateObject2.question.options = null;
        }
        return gameStateObject2;
    }

    private static GameStateObject makeNextStateA(GameStateObject gameStateObject) {
        GameStateObject gameStateObject2 = new GameStateObject();
        gameStateObject2.status = GameStateObject.GameStatusEnum.ShowAnswer;
        gameStateObject2.question = gameStateObject.question;
        try {
            gameStateObject2.answer = gameStateObject.answer.getCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (gameStateObject2.answer != null && DataGenerator.randomBoolean(0.7f)) {
            gameStateObject2.answer.correct_option_key = null;
        }
        return gameStateObject2;
    }

    private static GameStateObject getStateA(GameQuestionObject gameQuestionObject) {
        GameStateObject gameStateObject = new GameStateObject();
        gameStateObject.status = GameStateObject.GameStatusEnum.ShowAnswer;
        try {
            gameStateObject.question = gameQuestionObject.getCopy();
        } catch (Exception unused) {
        }
        gameStateObject.answer = getAnswer(gameStateObject.question);
        return gameStateObject;
    }

    private static GameStateObject getStateA() {
        GameStateObject gameStateObject = new GameStateObject();
        gameStateObject.status = GameStateObject.GameStatusEnum.ShowAnswer;
        gameStateObject.answer = getAnswer();
        return gameStateObject;
    }

    private static GameQuestionObject getQuestion() {
        GameQuestionObject gameQuestionObject = new GameQuestionObject();
        gameQuestionObject.text = DataGenerator.randomLongString();
        gameQuestionObject.allow_use_relive = DataGenerator.randomBoolean(0.7f);
        gameQuestionObject.show_time = DataGenerator.randomInt(2000, 5000);
        gameQuestionObject.options = getRandomOptions(DataGenerator.randomInt(2, 5));
        int i = counter + 1;
        counter = i;
        if (i > 1000) {
            counter = 0;
        }
        gameQuestionObject.question_id = counter + BuildConfig.FLAVOR;
        return gameQuestionObject;
    }

    private static ArrayList<GameOptionObject> getRandomOptions(int i) {
        if (i < 0) {
            i = 0;
        }
        ArrayList<GameOptionObject> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            GameOptionObject gameOptionObject = new GameOptionObject();
            gameOptionObject.text = DataGenerator.randomName();
            gameOptionObject.option_id = i2 + BuildConfig.FLAVOR;
            arrayList.add(gameOptionObject);
        }
        return arrayList;
    }

    private static GameAnswerObject getAnswer() {
        return getAnswer(getQuestion());
    }

    private static GameAnswerObject getAnswer(GameQuestionObject gameQuestionObject) {
        if (gameQuestionObject == null) {
            gameQuestionObject = getQuestion();
        }
        while (gameQuestionObject.options == null) {
            gameQuestionObject = getQuestion();
        }
        GameAnswerObject gameAnswerObject = new GameAnswerObject();
        gameAnswerObject.options = new HashMap();
        Iterator<GameOptionObject> it = gameQuestionObject.options.iterator();
        while (it.hasNext()) {
            gameAnswerObject.options.put(it.next().option_id, Integer.valueOf(DataGenerator.randomInt(10, 2000)));
        }
        gameAnswerObject.correct_option_key = gameQuestionObject.options.get(DataGenerator.randomInt(0, gameQuestionObject.options.size())).option_id;
        return gameAnswerObject;
    }

    public static ArrayList<GetGameStatusOutput> getStatusArray() {
        ArrayList<GetGameStatusOutput> statusArray2 = GameTestAppPreferences.getInstance().getStatusArray();
        statusArray = statusArray2;
        if (statusArray2 == null) {
            createStateArrayAndSave();
        }
        return statusArray;
    }

    public static void createStateArrayAndSave() {
        statusArray = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            GetGameStatusOutput getGameStatusOutput = new GetGameStatusOutput();
            getGameStatusOutput.state = getGameState();
            getGameStatusOutput.state_remaining = DataGenerator.randomInt(6000, 12000);
            getGameStatusOutput.api_call_time = DataGenerator.randomInt(10000, 14000);
            getGameStatusOutput.stream_url = "http://node5.iranlms.ir/cdn.ashx?sc=1&ac=08A2EB09282DEED2577CADCEA63A9B1E&add=/video/6fc5b440-5159-437d-b7ab-9c856f8d529e&token=2B1F2FBBDF9B1I7I8AAD86A96AD65CFA96F3976AB5&.m3u8";
            getGameStatusOutput.retry_time = 1000L;
            getGameStatusOutput.count_online = DataGenerator.randomInt(10, 10000) + BuildConfig.FLAVOR;
            statusArray.add(getGameStatusOutput);
        }
        for (int i2 = 0; i2 < statusArray.size() - 1; i2++) {
            if (DataGenerator.randomBoolean(0.7f)) {
                statusArray.get(i2).next_state = makeNextState(statusArray.get(i2 + 1).state);
            }
        }
        GameTestAppPreferences.getInstance().setStatusArray(statusArray);
    }
}
