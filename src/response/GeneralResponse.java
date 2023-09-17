package response;

import java.time.LocalDateTime;

public class GeneralResponse<T> {
    private int status;
    private String message;
    private LocalDateTime ResponseTime;
    private T data;

    private GeneralResponse(int status, String message, LocalDateTime ResponseTime, T data){
    }
    public GeneralResponse(){
    }
    private GeneralResponse<T> build(int status,String message ,LocalDateTime now, T data){
        return new GeneralResponse<>(status,message,now,data);
    }

    public GeneralResponse<T> of(int status,String message,T data){
        return build(status,message,LocalDateTime.now(),data);
    }
    public GeneralResponse<T> of(int status,String message){
        return build(status,message,LocalDateTime.now(),null);
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", ResponseTime=" + ResponseTime +
                ", data=" + data +
                '}';
    }
}