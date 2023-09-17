package service;

import response.GeneralResponse;

public interface GameService {
    void playEngToAze();
    void playAzeToEng();
    void show();

    GeneralResponse<String> add();

}
