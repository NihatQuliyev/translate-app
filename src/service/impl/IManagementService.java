package service.impl;

import service.GameService;
import service.ManagementService;
import util.MenuUtil;

public class IManagementService implements ManagementService {

    GameService gameService = new IGameService();

    public void manage() {
        while (true) {
            try {
                int option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        gameService.playEngToAze();
                        break;

                    case 2:
                        gameService.playAzeToEng();
                        break;
                    case 3:
                        gameService.show();
                        break;
                    case 4:
                        gameService.add();
                        break;
                    default:
                        System.err.println("invalid option!!!");
                }
            } catch (RuntimeException runtimeException) {
                System.out.println(runtimeException.getMessage());
            }
        }
    }
}
