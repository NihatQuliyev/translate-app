import service.ManagementService;
import service.impl.IManagementService;

public class Main {
    public static void main(String[] args) {
        ManagementService management = new IManagementService();
        management.manage();
    }
}