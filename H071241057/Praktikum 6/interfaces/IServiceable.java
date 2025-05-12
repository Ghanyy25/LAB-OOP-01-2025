package interfaces;

import java.time.*;

public interface IServiceable {
    boolean periksakondisi();
    void lakukanservis();
    LocalDate getWaktuservisberikutnya();
    double biayaservis();
    
} 